package typo

import typo.internal.FileSync
import typo.internal.FileSync.SoftWrite

import java.nio.file.Path

case class Generated(language: Lang, folder: Path, scope: Scope, files: Map[RelPath, sc.Code]) {
  def mapFiles(f: Map[RelPath, sc.Code] => Map[RelPath, sc.Code]): Generated =
    copy(files = f(files))

  def overwriteFolder(softWrite: SoftWrite = SoftWrite.Yes(Set.empty)): Map[Path, FileSync.Synced] =
    FileSync.syncStrings(
      folder = folder,
      fileRelMap = files.map { case (relPath, code) => (relPath, code.render(language).asString) },
      deleteUnknowns = FileSync.DeleteUnknowns.Yes(maxDepth = None),
      softWrite = softWrite
    )
}

object Generated {
  def apply(language: Lang, folder: Path, testFolder: Option[Path], files: Iterator[sc.File]): List[Generated] =
    testFolder match {
      case Some(testFolder) =>
        val (mainFiles, testFiles) = files.partition(_.scope == Scope.Main)
        List(
          Generated(language, folder, Scope.Main, asRelativePaths(language, mainFiles)),
          Generated(language, testFolder, Scope.Test, asRelativePaths(language, testFiles))
        )
      case None =>
        List(Generated(language, folder, Scope.Main, asRelativePaths(language, files)))
    }

  def asRelativePaths(language: Lang, files: Iterator[sc.File]): Map[RelPath, sc.Code] =
    files.map { case sc.File(sc.Type.Qualified(sc.QIdent(idents)), code, _, _) =>
      val path = idents.init
      val name = idents.last
      val relPath = RelPath(path.map(_.value) :+ s"${name.value}.${language.extension}")
      relPath -> code
    }.toMap
}
