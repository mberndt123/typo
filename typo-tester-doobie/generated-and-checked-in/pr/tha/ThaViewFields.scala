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
import typo.dsl.SqlExpr.OptField

trait ThaViewFields[Row] {
  val id: OptField[Int, Row]
  val transactionid: OptField[TransactionhistoryarchiveId, Row]
  val productid: OptField[Int, Row]
  val referenceorderid: OptField[Int, Row]
  val referenceorderlineid: OptField[Int, Row]
  val transactiondate: OptField[TypoLocalDateTime, Row]
  val transactiontype: OptField[/* bpchar */ String, Row]
  val quantity: OptField[Int, Row]
  val actualcost: OptField[BigDecimal, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object ThaViewFields extends ThaViewStructure[ThaViewRow](None, identity, (_, x) => x)

