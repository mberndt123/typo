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

case class PgExtensionRow(
  oid: PgExtensionId,
  extname: String,
  extowner: Long,
  extnamespace: Long,
  extrelocatable: Boolean,
  extversion: String,
  extconfig: Option[Array[Long]],
  extcondition: Option[Array[String]]
)

object PgExtensionRow {
  implicit val rowParser: RowParser[PgExtensionRow] = { row =>
    Success(
      PgExtensionRow(
        oid = row[PgExtensionId]("oid"),
        extname = row[String]("extname"),
        extowner = row[Long]("extowner"),
        extnamespace = row[Long]("extnamespace"),
        extrelocatable = row[Boolean]("extrelocatable"),
        extversion = row[String]("extversion"),
        extconfig = row[Option[Array[Long]]]("extconfig"),
        extcondition = row[Option[Array[String]]]("extcondition")
      )
    )
  }

  
}
