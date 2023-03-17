package testdb.pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class PgTablesRow(
  /** Points to [[testdb.pg_catalog.PgNamespaceRow.nspname]] */
  schemaname: String,
  /** Points to [[testdb.pg_catalog.PgClassRow.relname]] */
  tablename: String,
  tableowner: /* unknown nullability */ Option[String],
  /** Points to [[testdb.pg_catalog.PgTablespaceRow.spcname]] */
  tablespace: String,
  /** Points to [[testdb.pg_catalog.PgClassRow.relhasindex]] */
  hasindexes: Boolean,
  /** Points to [[testdb.pg_catalog.PgClassRow.relhasrules]] */
  hasrules: Boolean,
  /** Points to [[testdb.pg_catalog.PgClassRow.relhastriggers]] */
  hastriggers: Boolean,
  /** Points to [[testdb.pg_catalog.PgClassRow.relrowsecurity]] */
  rowsecurity: Boolean
)

object PgTablesRow {
  implicit val rowParser: RowParser[PgTablesRow] = { row =>
    Success(
      PgTablesRow(
        schemaname = row[String]("schemaname"),
        tablename = row[String]("tablename"),
        tableowner = row[/* unknown nullability */ Option[String]]("tableowner"),
        tablespace = row[String]("tablespace"),
        hasindexes = row[Boolean]("hasindexes"),
        hasrules = row[Boolean]("hasrules"),
        hastriggers = row[Boolean]("hastriggers"),
        rowsecurity = row[Boolean]("rowsecurity")
      )
    )
  }

  implicit val oFormat: OFormat[PgTablesRow] = Json.format
}
