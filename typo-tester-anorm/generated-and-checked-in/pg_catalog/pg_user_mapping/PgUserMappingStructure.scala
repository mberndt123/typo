/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user_mapping

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgUserMappingStructure[Row](val prefix: Option[String], val extract: Row => PgUserMappingRow, val merge: (Row, PgUserMappingRow) => Row)
  extends Relation[PgUserMappingFields, PgUserMappingRow, Row]
    with PgUserMappingFields[Row] { outer =>

  override val oid = new IdField[PgUserMappingId, Row](prefix, "oid", None, Some("oid"))(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))
  override val umuser = new Field[/* oid */ Long, Row](prefix, "umuser", None, Some("oid"))(x => extract(x).umuser, (row, value) => merge(row, extract(row).copy(umuser = value)))
  override val umserver = new Field[/* oid */ Long, Row](prefix, "umserver", None, Some("oid"))(x => extract(x).umserver, (row, value) => merge(row, extract(row).copy(umserver = value)))
  override val umoptions = new OptField[Array[String], Row](prefix, "umoptions", None, Some("_text"))(x => extract(x).umoptions, (row, value) => merge(row, extract(row).copy(umoptions = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](oid, umuser, umserver, umoptions)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgUserMappingRow, merge: (NewRow, PgUserMappingRow) => NewRow): PgUserMappingStructure[NewRow] =
    new PgUserMappingStructure(prefix, extract, merge)
}
