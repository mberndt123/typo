/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.sohsr;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.sales.salesorderheader.SalesorderheaderId;
import adventureworks.sales.salesreason.SalesreasonId;
import anorm.RowParser;
import anorm.Success;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** View: sa.sohsr */
case class SohsrViewRow(/** Points to [[adventureworks.sales.salesorderheadersalesreason.SalesorderheadersalesreasonRow.salesorderid]] */
                        salesorderid: SalesorderheaderId, /** Points to [[adventureworks.sales.salesorderheadersalesreason.SalesorderheadersalesreasonRow.salesreasonid]] */
                        salesreasonid: SalesreasonId, /** Points to [[adventureworks.sales.salesorderheadersalesreason.SalesorderheadersalesreasonRow.modifieddate]] */
                        modifieddate: TypoLocalDateTime)

object SohsrViewRow {
  implicit lazy val reads: Reads[SohsrViewRow] = {
    Reads[SohsrViewRow](json => JsResult.fromTry(
        Try(
          SohsrViewRow(
            salesorderid = json.\("salesorderid").as(SalesorderheaderId.reads),
            salesreasonid = json.\("salesreasonid").as(SalesreasonId.reads),
            modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
          )
        )
      ),
    )
  }
  def rowParser(idx: Int): RowParser[SohsrViewRow] = {
    RowParser[SohsrViewRow] { row =>
      Success(
        SohsrViewRow(
          salesorderid = row(idx + 0)(SalesorderheaderId.column),
          salesreasonid = row(idx + 1)(SalesreasonId.column),
          modifieddate = row(idx + 2)(TypoLocalDateTime.column)
        )
      )
    }
  }
  implicit lazy val writes: OWrites[SohsrViewRow] = {
    OWrites[SohsrViewRow](o =>
      new JsObject(ListMap[String, JsValue](
        "salesorderid" -> SalesorderheaderId.writes.writes(o.salesorderid),
        "salesreasonid" -> SalesreasonId.writes.writes(o.salesreasonid),
        "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
      ))
    )
  }
}