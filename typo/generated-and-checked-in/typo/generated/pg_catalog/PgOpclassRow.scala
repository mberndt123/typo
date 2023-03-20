/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.RowParser
import anorm.Success

case class PgOpclassRow(
  oid: PgOpclassId,
  opcmethod: Long,
  opcname: String,
  opcnamespace: Long,
  opcowner: Long,
  opcfamily: Long,
  opcintype: Long,
  opcdefault: Boolean,
  opckeytype: Long
)

object PgOpclassRow {
  implicit val rowParser: RowParser[PgOpclassRow] = { row =>
    Success(
      PgOpclassRow(
        oid = row[PgOpclassId]("oid"),
        opcmethod = row[Long]("opcmethod"),
        opcname = row[String]("opcname"),
        opcnamespace = row[Long]("opcnamespace"),
        opcowner = row[Long]("opcowner"),
        opcfamily = row[Long]("opcfamily"),
        opcintype = row[Long]("opcintype"),
        opcdefault = row[Boolean]("opcdefault"),
        opckeytype = row[Long]("opckeytype")
      )
    )
  }

  
}
