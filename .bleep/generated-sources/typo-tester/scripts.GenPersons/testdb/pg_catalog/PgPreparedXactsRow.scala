package testdb.pg_catalog

import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class PgPreparedXactsRow(
  transaction: /* unknown nullability */ Option[/* xid */ String],
  gid: /* unknown nullability */ Option[String],
  prepared: /* unknown nullability */ Option[LocalDateTime],
  /** Points to [[testdb.pg_catalog.PgAuthidRow.rolname]] */
  owner: String,
  /** Points to [[testdb.pg_catalog.PgDatabaseRow.datname]] */
  database: String
)

object PgPreparedXactsRow {
  implicit val rowParser: RowParser[PgPreparedXactsRow] = { row =>
    Success(
      PgPreparedXactsRow(
        transaction = row[/* unknown nullability */ Option[/* xid */ String]]("transaction"),
        gid = row[/* unknown nullability */ Option[String]]("gid"),
        prepared = row[/* unknown nullability */ Option[LocalDateTime]]("prepared"),
        owner = row[String]("owner"),
        database = row[String]("database")
      )
    )
  }

  implicit val oFormat: OFormat[PgPreparedXactsRow] = Json.format
}
