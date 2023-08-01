/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package tha

import adventureworks.TypoLocalDateTime
import adventureworks.production.transactionhistoryarchive.TransactionhistoryarchiveId
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class ThaViewStructure[Row](val prefix: Option[String], val extract: Row => ThaViewRow, val merge: (Row, ThaViewRow) => Row)
  extends Relation[ThaViewFields, ThaViewRow, Row]
    with ThaViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val transactionid = new OptField[TransactionhistoryarchiveId, Row](prefix, "transactionid", None, Some("int4"))(x => extract(x).transactionid, (row, value) => merge(row, extract(row).copy(transactionid = value)))
  override val productid = new OptField[Int, Row](prefix, "productid", None, Some("int4"))(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
  override val referenceorderid = new OptField[Int, Row](prefix, "referenceorderid", None, Some("int4"))(x => extract(x).referenceorderid, (row, value) => merge(row, extract(row).copy(referenceorderid = value)))
  override val referenceorderlineid = new OptField[Int, Row](prefix, "referenceorderlineid", None, Some("int4"))(x => extract(x).referenceorderlineid, (row, value) => merge(row, extract(row).copy(referenceorderlineid = value)))
  override val transactiondate = new OptField[TypoLocalDateTime, Row](prefix, "transactiondate", Some("text"), Some("timestamp"))(x => extract(x).transactiondate, (row, value) => merge(row, extract(row).copy(transactiondate = value)))
  override val transactiontype = new OptField[/* bpchar */ String, Row](prefix, "transactiontype", None, Some("bpchar"))(x => extract(x).transactiontype, (row, value) => merge(row, extract(row).copy(transactiontype = value)))
  override val quantity = new OptField[Int, Row](prefix, "quantity", None, Some("int4"))(x => extract(x).quantity, (row, value) => merge(row, extract(row).copy(quantity = value)))
  override val actualcost = new OptField[BigDecimal, Row](prefix, "actualcost", None, Some("numeric"))(x => extract(x).actualcost, (row, value) => merge(row, extract(row).copy(actualcost = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => ThaViewRow, merge: (NewRow, ThaViewRow) => NewRow): ThaViewStructure[NewRow] =
    new ThaViewStructure(prefix, extract, merge)
}
