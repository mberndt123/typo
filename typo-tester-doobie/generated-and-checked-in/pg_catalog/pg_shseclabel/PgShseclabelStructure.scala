/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shseclabel

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class PgShseclabelStructure[Row](val prefix: Option[String], val extract: Row => PgShseclabelRow, val merge: (Row, PgShseclabelRow) => Row)
  extends Relation[PgShseclabelFields, PgShseclabelRow, Row]
    with PgShseclabelFields[Row] { outer =>

  override val objoid = new IdField[/* oid */ Long, Row](prefix, "objoid", None, Some("oid"))(x => extract(x).objoid, (row, value) => merge(row, extract(row).copy(objoid = value)))
  override val classoid = new IdField[/* oid */ Long, Row](prefix, "classoid", None, Some("oid"))(x => extract(x).classoid, (row, value) => merge(row, extract(row).copy(classoid = value)))
  override val provider = new IdField[String, Row](prefix, "provider", None, None)(x => extract(x).provider, (row, value) => merge(row, extract(row).copy(provider = value)))
  override val label = new Field[String, Row](prefix, "label", None, None)(x => extract(x).label, (row, value) => merge(row, extract(row).copy(label = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](objoid, classoid, provider, label)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgShseclabelRow, merge: (NewRow, PgShseclabelRow) => NewRow): PgShseclabelStructure[NewRow] =
    new PgShseclabelStructure(prefix, extract, merge)
}
