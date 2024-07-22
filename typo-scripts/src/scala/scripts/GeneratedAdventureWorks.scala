package scripts

import bleep.logging.{Formatter, LogLevel, Loggers}
import bleep.{FileWatching, LogPatterns, cli}
import typo.*
import typo.internal.codegen.*
import typo.internal.sqlfiles.readSqlFileDirectories
import typo.internal.{FileSync, generate}

import java.nio.file.Path
import java.util.concurrent.atomic.AtomicReference
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object GeneratedAdventureWorks {
  val buildDir = Path.of(sys.props("user.dir"))

  // çlickable links in intellij
  implicit val PathFormatter: Formatter[Path] = _.toUri.toString

  def main(args: Array[String]): Unit =
    Loggers
      .stdout(LogPatterns.interface(None, noColor = false), disableProgress = true)
      .map(_.minLogLevel(LogLevel.info))
      .untyped
      .use { logger =>
        val ds = TypoDataSource.hikari(server = "localhost", port = 6432, databaseName = "Adventureworks", username = "postgres", password = "password")
        val scriptsPath = buildDir.resolve("adventureworks_sql")
        val selector = Selector.ExcludePostgresInternal
        val metadb = Await.result(MetaDb.fromDb(TypoLogger.Console, ds, selector), Duration.Inf)

        val variants = List(
          (LangScala, Some(DbLibName.Anorm), Some(JsonLibName.PlayJson), "typo-tester-anorm", new AtomicReference(Map.empty[RelPath, sc.Code])),
          (LangScala, Some(DbLibName.Doobie), Some(JsonLibName.Circe), "typo-tester-doobie", new AtomicReference(Map.empty[RelPath, sc.Code])),
          (LangScala, Some(DbLibName.ZioJdbc), Some(JsonLibName.ZioJson), "typo-tester-zio-jdbc", new AtomicReference(Map.empty[RelPath, sc.Code])),
          (LangJava, None, None, "typo-tester-java", new AtomicReference(Map.empty[RelPath, sc.Code]))
        )

        def go(): Unit = {
          val newSqlScripts = Await.result(readSqlFileDirectories(TypoLogger.Console, scriptsPath, ds), Duration.Inf)

          variants.foreach { case (lang, dbLib, jsonLib, projectPath, oldFilesRef) =>
            val options = Options(
              pkg = "adventureworks",
              dbLib,
              lang = lang,
              jsonLib.toList,
              typeOverride = TypeOverride.relation {
                case (_, "firstname")                     => "adventureworks.userdefined.FirstName"
                case ("sales.creditcard", "creditcardid") => "adventureworks.userdefined.CustomCreditcardId"
              },
              generateMockRepos = !Selector.relationNames("purchaseorderdetail"),
              enablePrimaryKeyType = !Selector.relationNames("billofmaterials"),
              enableTestInserts = Selector.All,
              readonlyRepo = Selector.relationNames("purchaseorderdetail"),
              enableDsl = !projectPath.endsWith("java")
            )
            val targetSources = buildDir.resolve(s"$projectPath/generated-and-checked-in")

            val newFiles: Generated =
              generate(options, metadb, ProjectGraph(name = "", targetSources, None, selector, newSqlScripts, Nil)).head

            val knownUnchanged: Set[RelPath] = {
              val oldFiles = oldFilesRef.get()
              newFiles.files.iterator.collect { case (relPath, contents) if oldFiles.get(relPath).contains(contents) => relPath }.toSet
            }
            oldFilesRef.set(newFiles.files)

            newFiles
              .overwriteFolder(softWrite = FileSync.SoftWrite.Yes(knownUnchanged))
              .filter { case (_, synced) => synced != FileSync.Synced.Unchanged }
              .foreach { case (path, synced) => logger.withContext(path).warn(synced.toString) }

            cli(
              "add files to git",
              buildDir,
              List("git", "add", "-f", targetSources.toString),
              logger = logger,
              cli.Out.Raw
            )
          }
        }

        go()

        // demonstrate how you can `watch` for changes in sql files and immediately regenerate code
        // note that this does not listen to changes in db schema naturally, though I'm sure that's possible to do as well
        if (args.contains("--watch")) {
          logger.warn(s"watching for changes in .sql files under $scriptsPath")
          FileWatching(logger, Map(scriptsPath -> List("sql scripts")))(_ => go())
            .run(FileWatching.StopWhen.OnStdInput)
        }
      }
}
