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

case class PgIndexRow(
  indexrelid: PgIndexId,
  indrelid: Long,
  indnatts: Short,
  indnkeyatts: Short,
  indisunique: Boolean,
  indisprimary: Boolean,
  indisexclusion: Boolean,
  indimmediate: Boolean,
  indisclustered: Boolean,
  indisvalid: Boolean,
  indcheckxmin: Boolean,
  indisready: Boolean,
  indislive: Boolean,
  indisreplident: Boolean,
  indkey: String,
  indcollation: Array[Long],
  indclass: Array[Long],
  indoption: String,
  indexprs: Option[String],
  indpred: Option[String]
)

object PgIndexRow {
  implicit val rowParser: RowParser[PgIndexRow] = { row =>
    Success(
      PgIndexRow(
        indexrelid = row[PgIndexId]("indexrelid"),
        indrelid = row[Long]("indrelid"),
        indnatts = row[Short]("indnatts"),
        indnkeyatts = row[Short]("indnkeyatts"),
        indisunique = row[Boolean]("indisunique"),
        indisprimary = row[Boolean]("indisprimary"),
        indisexclusion = row[Boolean]("indisexclusion"),
        indimmediate = row[Boolean]("indimmediate"),
        indisclustered = row[Boolean]("indisclustered"),
        indisvalid = row[Boolean]("indisvalid"),
        indcheckxmin = row[Boolean]("indcheckxmin"),
        indisready = row[Boolean]("indisready"),
        indislive = row[Boolean]("indislive"),
        indisreplident = row[Boolean]("indisreplident"),
        indkey = row[String]("indkey"),
        indcollation = row[Array[Long]]("indcollation"),
        indclass = row[Array[Long]]("indclass"),
        indoption = row[String]("indoption"),
        indexprs = row[Option[String]]("indexprs"),
        indpred = row[Option[String]]("indpred")
      )
    )
  }

  
}
