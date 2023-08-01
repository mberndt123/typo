/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_enum

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class PgEnumStructure[Row](val prefix: Option[String], val extract: Row => PgEnumRow, val merge: (Row, PgEnumRow) => Row)
  extends Relation[PgEnumFields, PgEnumRow, Row]
    with PgEnumFields[Row] { outer =>

  override val oid = new IdField[PgEnumId, Row](prefix, "oid", None, Some("oid"))(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))
  override val enumtypid = new Field[/* oid */ Long, Row](prefix, "enumtypid", None, Some("oid"))(x => extract(x).enumtypid, (row, value) => merge(row, extract(row).copy(enumtypid = value)))
  override val enumsortorder = new Field[Float, Row](prefix, "enumsortorder", None, Some("float4"))(x => extract(x).enumsortorder, (row, value) => merge(row, extract(row).copy(enumsortorder = value)))
  override val enumlabel = new Field[String, Row](prefix, "enumlabel", None, Some("name"))(x => extract(x).enumlabel, (row, value) => merge(row, extract(row).copy(enumlabel = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](oid, enumtypid, enumsortorder, enumlabel)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgEnumRow, merge: (NewRow, PgEnumRow) => NewRow): PgEnumStructure[NewRow] =
    new PgEnumStructure(prefix, extract, merge)
}
