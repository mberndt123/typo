package typo
package internal
package sqlfiles

case class SqlFile(
    relPath: RelPath,
    decomposedSql: DecomposedSql,
    params: List[SqlFile.Param],
    cols: MaybeReturnsRows[NonEmptyList[db.Col]],
    dependencies: Map[db.ColName, (db.RelationName, db.ColName)]
)

object SqlFile {
  case class Param(maybeName: DecomposedSql.Param, indices: List[Int], udtName: String, tpe: db.Type)
}
