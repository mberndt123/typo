/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.RowParser
import anorm.Success
import typo.generated.pg_catalog.PgAttributeRow
import typo.generated.pg_catalog.PgClassRow
import typo.generated.pg_catalog.PgNamespaceRow

case class PgForeignTableColumnsRow(
  /** Points to [[PgNamespaceRow.nspname]] */
  nspname: String,
  /** Points to [[PgClassRow.relname]] */
  relname: String,
  /** Points to [[PgAttributeRow.attname]] */
  attname: String,
  /** Points to [[PgAttributeRow.attfdwoptions]] */
  attfdwoptions: Option[Array[String]]
)

object PgForeignTableColumnsRow {
  implicit val rowParser: RowParser[PgForeignTableColumnsRow] = { row =>
    Success(
      PgForeignTableColumnsRow(
        nspname = row[String]("nspname"),
        relname = row[String]("relname"),
        attname = row[String]("attname"),
        attfdwoptions = row[Option[Array[String]]]("attfdwoptions")
      )
    )
  }

  
}
