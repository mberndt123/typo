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

case class PgTsConfigRow(
  oid: PgTsConfigId,
  cfgname: String,
  cfgnamespace: Long,
  cfgowner: Long,
  cfgparser: Long
)

object PgTsConfigRow {
  implicit val rowParser: RowParser[PgTsConfigRow] = { row =>
    Success(
      PgTsConfigRow(
        oid = row[PgTsConfigId]("oid"),
        cfgname = row[String]("cfgname"),
        cfgnamespace = row[Long]("cfgnamespace"),
        cfgowner = row[Long]("cfgowner"),
        cfgparser = row[Long]("cfgparser")
      )
    )
  }

  
}
