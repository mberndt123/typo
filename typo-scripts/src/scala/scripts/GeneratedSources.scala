package scripts

import bleep._
import bleep.logging.Logger
import typo._
import typo.sc.syntax.CodeInterpolator

import java.nio.file.Path
import java.sql.{Connection, DriverManager}
import java.util

object GeneratedSources {
  def main(args: Array[String]): Unit = {
    implicit val c: Connection = {
      val url = "jdbc:postgresql://localhost/postgres"
      val props = new util.Properties
      props.setProperty("user", "postgres")
      props.setProperty("password", "postgres")
      DriverManager.getConnection(url, props)
    }
    val header =
      code"""|/**
             | * File has been automatically generated by `typo` for internal use.
             | *
             | * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
             | *
             | * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
             | */
             |""".stripMargin

    val typoSources = Path.of(sys.props("user.dir")).resolve("typo/generated-and-checked-in")

    val filesByRelPath: Map[RelPath, String] = {
      val generated = sc.Ident("generated")
      val options = Options(pkg = sc.QIdent(List(sc.Ident("typo"), generated)), JsonLibPlay, DbLibAnorm, header, debugTypes = true)
      Gen.fromDb(options, Selector.OnlyPostgresInternal).map { case sc.File(sc.Type.Qualified(sc.QIdent(path :+ name)), content) =>
        val relpath = RelPath(path.map(_.value) :+ (name.value + ".scala"))
        relpath -> content.render
      }.toMap
    }

    FileSync
      .syncStrings(
        typoSources,
        filesByRelPath,
        deleteUnknowns = FileSync.DeleteUnknowns.Yes(maxDepth = None),
        soft = true
      )

    cli("add to git", typoSources, List("git", "add", "-f", typoSources.toString), Logger.DevNull, cli.Out.Raw)
    ()
  }
}
