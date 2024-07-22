/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salespersonquotahistory;

import adventureworks.Text;
import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.person.businessentity.BusinessentityId;
import anorm.Column;
import anorm.RowParser;
import anorm.Success;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import play.api.libs.json.Writes;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** Table: sales.salespersonquotahistory
  * Sales performance tracking.
  * Composite primary key: businessentityid, quotadate
  */
case class SalespersonquotahistoryRow(
  /** Sales person identification number. Foreign key to SalesPerson.BusinessEntityID.
    * Points to [[adventureworks.sales.salesperson.SalespersonRow.businessentityid]]
    */
  businessentityid: BusinessentityId,
  /** Sales quota date. */
  quotadate: TypoLocalDateTime,
  /** Sales quota amount.
    * Constraint CK_SalesPersonQuotaHistory_SalesQuota affecting columns salesquota: ((salesquota > 0.00))
    */
  salesquota: BigDecimal,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
) {
  def compositeId: SalespersonquotahistoryId = new SalespersonquotahistoryId(businessentityid, quotadate)
  def id: SalespersonquotahistoryId = compositeId
  def toUnsavedRow(rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): SalespersonquotahistoryRowUnsaved = {
    new SalespersonquotahistoryRowUnsaved(
      businessentityid,
      quotadate,
      salesquota,
      rowguid,
      modifieddate
    )
  }
}

object SalespersonquotahistoryRow {
  def apply(
    compositeId: SalespersonquotahistoryId,
    salesquota: BigDecimal,
    rowguid: TypoUUID,
    modifieddate: TypoLocalDateTime
  ): SalespersonquotahistoryRow = {
    new SalespersonquotahistoryRow(
      compositeId.businessentityid,
      compositeId.quotadate,
      salesquota,
      rowguid,
      modifieddate
    )
  }
  implicit lazy val reads: Reads[SalespersonquotahistoryRow] = {
    Reads[SalespersonquotahistoryRow](json => JsResult.fromTry(
        Try(
          SalespersonquotahistoryRow(
            businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
            quotadate = json.\("quotadate").as(TypoLocalDateTime.reads),
            salesquota = json.\("salesquota").as(Reads.bigDecReads),
            rowguid = json.\("rowguid").as(TypoUUID.reads),
            modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
          )
        )
      ),
    )
  }
  def rowParser(idx: Int): RowParser[SalespersonquotahistoryRow] = {
    RowParser[SalespersonquotahistoryRow] { row =>
      Success(
        SalespersonquotahistoryRow(
          businessentityid = row(idx + 0)(BusinessentityId.column),
          quotadate = row(idx + 1)(TypoLocalDateTime.column),
          salesquota = row(idx + 2)(Column.columnToScalaBigDecimal),
          rowguid = row(idx + 3)(TypoUUID.column),
          modifieddate = row(idx + 4)(TypoLocalDateTime.column)
        )
      )
    }
  }
  implicit lazy val text: Text[SalespersonquotahistoryRow] = {
    Text.instance[SalespersonquotahistoryRow]{ (row, sb) =>
      BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.quotadate, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.salesquota, sb)
      sb.append(Text.DELIMETER)
      TypoUUID.text.unsafeEncode(row.rowguid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    }
  }
  implicit lazy val writes: OWrites[SalespersonquotahistoryRow] = {
    OWrites[SalespersonquotahistoryRow](o =>
      new JsObject(ListMap[String, JsValue](
        "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
        "quotadate" -> TypoLocalDateTime.writes.writes(o.quotadate),
        "salesquota" -> Writes.BigDecimalWrites.writes(o.salesquota),
        "rowguid" -> TypoUUID.writes.writes(o.rowguid),
        "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
      ))
    )
  }
}