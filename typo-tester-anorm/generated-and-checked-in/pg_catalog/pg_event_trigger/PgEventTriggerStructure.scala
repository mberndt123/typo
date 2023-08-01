/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_event_trigger

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgEventTriggerStructure[Row](val prefix: Option[String], val extract: Row => PgEventTriggerRow, val merge: (Row, PgEventTriggerRow) => Row)
  extends Relation[PgEventTriggerFields, PgEventTriggerRow, Row]
    with PgEventTriggerFields[Row] { outer =>

  override val oid = new IdField[PgEventTriggerId, Row](prefix, "oid", None, Some("oid"))(x => extract(x).oid, (row, value) => merge(row, extract(row).copy(oid = value)))
  override val evtname = new Field[String, Row](prefix, "evtname", None, Some("name"))(x => extract(x).evtname, (row, value) => merge(row, extract(row).copy(evtname = value)))
  override val evtevent = new Field[String, Row](prefix, "evtevent", None, Some("name"))(x => extract(x).evtevent, (row, value) => merge(row, extract(row).copy(evtevent = value)))
  override val evtowner = new Field[/* oid */ Long, Row](prefix, "evtowner", None, Some("oid"))(x => extract(x).evtowner, (row, value) => merge(row, extract(row).copy(evtowner = value)))
  override val evtfoid = new Field[/* oid */ Long, Row](prefix, "evtfoid", None, Some("oid"))(x => extract(x).evtfoid, (row, value) => merge(row, extract(row).copy(evtfoid = value)))
  override val evtenabled = new Field[String, Row](prefix, "evtenabled", None, Some("char"))(x => extract(x).evtenabled, (row, value) => merge(row, extract(row).copy(evtenabled = value)))
  override val evttags = new OptField[Array[String], Row](prefix, "evttags", None, Some("_text"))(x => extract(x).evttags, (row, value) => merge(row, extract(row).copy(evttags = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](oid, evtname, evtevent, evtowner, evtfoid, evtenabled, evttags)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgEventTriggerRow, merge: (NewRow, PgEventTriggerRow) => NewRow): PgEventTriggerStructure[NewRow] =
    new PgEventTriggerStructure(prefix, extract, merge)
}
