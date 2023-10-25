/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.address.AddressId
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.OrderNumber
import adventureworks.purchasing.shipmethod.ShipmethodId
import adventureworks.sales.currencyrate.CurrencyrateId
import adventureworks.sales.customer.CustomerId
import adventureworks.sales.salesterritory.SalesterritoryId
import adventureworks.userdefined.CustomCreditcardId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class SalesorderheaderRow(
  /** Primary key. */
  salesorderid: SalesorderheaderId,
  /** Incremental number to track changes to the sales order over time. */
  revisionnumber: TypoShort,
  /** Dates the sales order was created.
      Constraint CK_SalesOrderHeader_DueDate affecting columns "duedate", "orderdate":  ((duedate >= orderdate))
      Constraint CK_SalesOrderHeader_ShipDate affecting columns "orderdate", "shipdate":  (((shipdate >= orderdate) OR (shipdate IS NULL))) */
  orderdate: TypoLocalDateTime,
  /** Date the order is due to the customer.
      Constraint CK_SalesOrderHeader_DueDate affecting columns "duedate", "orderdate":  ((duedate >= orderdate)) */
  duedate: TypoLocalDateTime,
  /** Date the order was shipped to the customer.
      Constraint CK_SalesOrderHeader_ShipDate affecting columns "orderdate", "shipdate":  (((shipdate >= orderdate) OR (shipdate IS NULL))) */
  shipdate: Option[TypoLocalDateTime],
  /** Order current status. 1 = In process; 2 = Approved; 3 = Backordered; 4 = Rejected; 5 = Shipped; 6 = Cancelled
      Constraint CK_SalesOrderHeader_Status affecting columns "status":  (((status >= 0) AND (status <= 8))) */
  status: TypoShort,
  /** 0 = Order placed by sales person. 1 = Order placed online by customer. */
  onlineorderflag: Flag,
  /** Customer purchase order number reference. */
  purchaseordernumber: Option[OrderNumber],
  /** Financial accounting number reference. */
  accountnumber: Option[AccountNumber],
  /** Customer identification number. Foreign key to Customer.BusinessEntityID.
      Points to [[customer.CustomerRow.customerid]] */
  customerid: CustomerId,
  /** Sales person who created the sales order. Foreign key to SalesPerson.BusinessEntityID.
      Points to [[salesperson.SalespersonRow.businessentityid]] */
  salespersonid: Option[BusinessentityId],
  /** Territory in which the sale was made. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Customer billing address. Foreign key to Address.AddressID.
      Points to [[person.address.AddressRow.addressid]] */
  billtoaddressid: AddressId,
  /** Customer shipping address. Foreign key to Address.AddressID.
      Points to [[person.address.AddressRow.addressid]] */
  shiptoaddressid: AddressId,
  /** Shipping method. Foreign key to ShipMethod.ShipMethodID.
      Points to [[purchasing.shipmethod.ShipmethodRow.shipmethodid]] */
  shipmethodid: ShipmethodId,
  /** Credit card identification number. Foreign key to CreditCard.CreditCardID.
      Points to [[creditcard.CreditcardRow.creditcardid]] */
  creditcardid: Option[/* user-picked */ CustomCreditcardId],
  /** Approval code provided by the credit card company. */
  creditcardapprovalcode: Option[/* max 15 chars */ String],
  /** Currency exchange rate used. Foreign key to CurrencyRate.CurrencyRateID.
      Points to [[currencyrate.CurrencyrateRow.currencyrateid]] */
  currencyrateid: Option[CurrencyrateId],
  /** Sales subtotal. Computed as SUM(SalesOrderDetail.LineTotal)for the appropriate SalesOrderID.
      Constraint CK_SalesOrderHeader_SubTotal affecting columns "subtotal":  ((subtotal >= 0.00)) */
  subtotal: BigDecimal,
  /** Tax amount.
      Constraint CK_SalesOrderHeader_TaxAmt affecting columns "taxamt":  ((taxamt >= 0.00)) */
  taxamt: BigDecimal,
  /** Shipping cost.
      Constraint CK_SalesOrderHeader_Freight affecting columns "freight":  ((freight >= 0.00)) */
  freight: BigDecimal,
  /** Total due from customer. Computed as Subtotal + TaxAmt + Freight. */
  totaldue: Option[BigDecimal],
  /** Sales representative comments. */
  comment: Option[/* max 128 chars */ String],
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
)

object SalesorderheaderRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[SalesorderheaderRow] = new JdbcDecoder[SalesorderheaderRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SalesorderheaderRow) =
      columIndex + 24 ->
        SalesorderheaderRow(
          salesorderid = SalesorderheaderId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          revisionnumber = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          orderdate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          duedate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          shipdate = JdbcDecoder.optionDecoder(TypoLocalDateTime.jdbcDecoder).unsafeDecode(columIndex + 4, rs)._2,
          status = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
          onlineorderflag = Flag.jdbcDecoder.unsafeDecode(columIndex + 6, rs)._2,
          purchaseordernumber = JdbcDecoder.optionDecoder(OrderNumber.jdbcDecoder).unsafeDecode(columIndex + 7, rs)._2,
          accountnumber = JdbcDecoder.optionDecoder(AccountNumber.jdbcDecoder).unsafeDecode(columIndex + 8, rs)._2,
          customerid = CustomerId.jdbcDecoder.unsafeDecode(columIndex + 9, rs)._2,
          salespersonid = JdbcDecoder.optionDecoder(BusinessentityId.jdbcDecoder).unsafeDecode(columIndex + 10, rs)._2,
          territoryid = JdbcDecoder.optionDecoder(SalesterritoryId.jdbcDecoder).unsafeDecode(columIndex + 11, rs)._2,
          billtoaddressid = AddressId.jdbcDecoder.unsafeDecode(columIndex + 12, rs)._2,
          shiptoaddressid = AddressId.jdbcDecoder.unsafeDecode(columIndex + 13, rs)._2,
          shipmethodid = ShipmethodId.jdbcDecoder.unsafeDecode(columIndex + 14, rs)._2,
          creditcardid = JdbcDecoder.optionDecoder(CustomCreditcardId.jdbcDecoder).unsafeDecode(columIndex + 15, rs)._2,
          creditcardapprovalcode = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 16, rs)._2,
          currencyrateid = JdbcDecoder.optionDecoder(CurrencyrateId.jdbcDecoder).unsafeDecode(columIndex + 17, rs)._2,
          subtotal = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 18, rs)._2,
          taxamt = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 19, rs)._2,
          freight = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 20, rs)._2,
          totaldue = JdbcDecoder.optionDecoder(JdbcDecoder.bigDecimalDecoderScala).unsafeDecode(columIndex + 21, rs)._2,
          comment = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 22, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 23, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 24, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[SalesorderheaderRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val salesorderid = jsonObj.get("salesorderid").toRight("Missing field 'salesorderid'").flatMap(_.as(SalesorderheaderId.jsonDecoder))
    val revisionnumber = jsonObj.get("revisionnumber").toRight("Missing field 'revisionnumber'").flatMap(_.as(TypoShort.jsonDecoder))
    val orderdate = jsonObj.get("orderdate").toRight("Missing field 'orderdate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val duedate = jsonObj.get("duedate").toRight("Missing field 'duedate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val shipdate = jsonObj.get("shipdate").fold[Either[String, Option[TypoLocalDateTime]]](Right(None))(_.as(JsonDecoder.option(TypoLocalDateTime.jsonDecoder)))
    val status = jsonObj.get("status").toRight("Missing field 'status'").flatMap(_.as(TypoShort.jsonDecoder))
    val onlineorderflag = jsonObj.get("onlineorderflag").toRight("Missing field 'onlineorderflag'").flatMap(_.as(Flag.jsonDecoder))
    val purchaseordernumber = jsonObj.get("purchaseordernumber").fold[Either[String, Option[OrderNumber]]](Right(None))(_.as(JsonDecoder.option(OrderNumber.jsonDecoder)))
    val accountnumber = jsonObj.get("accountnumber").fold[Either[String, Option[AccountNumber]]](Right(None))(_.as(JsonDecoder.option(AccountNumber.jsonDecoder)))
    val customerid = jsonObj.get("customerid").toRight("Missing field 'customerid'").flatMap(_.as(CustomerId.jsonDecoder))
    val salespersonid = jsonObj.get("salespersonid").fold[Either[String, Option[BusinessentityId]]](Right(None))(_.as(JsonDecoder.option(BusinessentityId.jsonDecoder)))
    val territoryid = jsonObj.get("territoryid").fold[Either[String, Option[SalesterritoryId]]](Right(None))(_.as(JsonDecoder.option(SalesterritoryId.jsonDecoder)))
    val billtoaddressid = jsonObj.get("billtoaddressid").toRight("Missing field 'billtoaddressid'").flatMap(_.as(AddressId.jsonDecoder))
    val shiptoaddressid = jsonObj.get("shiptoaddressid").toRight("Missing field 'shiptoaddressid'").flatMap(_.as(AddressId.jsonDecoder))
    val shipmethodid = jsonObj.get("shipmethodid").toRight("Missing field 'shipmethodid'").flatMap(_.as(ShipmethodId.jsonDecoder))
    val creditcardid = jsonObj.get("creditcardid").fold[Either[String, Option[CustomCreditcardId]]](Right(None))(_.as(JsonDecoder.option(CustomCreditcardId.jsonDecoder)))
    val creditcardapprovalcode = jsonObj.get("creditcardapprovalcode").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val currencyrateid = jsonObj.get("currencyrateid").fold[Either[String, Option[CurrencyrateId]]](Right(None))(_.as(JsonDecoder.option(CurrencyrateId.jsonDecoder)))
    val subtotal = jsonObj.get("subtotal").toRight("Missing field 'subtotal'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val taxamt = jsonObj.get("taxamt").toRight("Missing field 'taxamt'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val freight = jsonObj.get("freight").toRight("Missing field 'freight'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val totaldue = jsonObj.get("totaldue").fold[Either[String, Option[BigDecimal]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.scalaBigDecimal)))
    val comment = jsonObj.get("comment").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (salesorderid.isRight && revisionnumber.isRight && orderdate.isRight && duedate.isRight && shipdate.isRight && status.isRight && onlineorderflag.isRight && purchaseordernumber.isRight && accountnumber.isRight && customerid.isRight && salespersonid.isRight && territoryid.isRight && billtoaddressid.isRight && shiptoaddressid.isRight && shipmethodid.isRight && creditcardid.isRight && creditcardapprovalcode.isRight && currencyrateid.isRight && subtotal.isRight && taxamt.isRight && freight.isRight && totaldue.isRight && comment.isRight && rowguid.isRight && modifieddate.isRight)
      Right(SalesorderheaderRow(salesorderid = salesorderid.toOption.get, revisionnumber = revisionnumber.toOption.get, orderdate = orderdate.toOption.get, duedate = duedate.toOption.get, shipdate = shipdate.toOption.get, status = status.toOption.get, onlineorderflag = onlineorderflag.toOption.get, purchaseordernumber = purchaseordernumber.toOption.get, accountnumber = accountnumber.toOption.get, customerid = customerid.toOption.get, salespersonid = salespersonid.toOption.get, territoryid = territoryid.toOption.get, billtoaddressid = billtoaddressid.toOption.get, shiptoaddressid = shiptoaddressid.toOption.get, shipmethodid = shipmethodid.toOption.get, creditcardid = creditcardid.toOption.get, creditcardapprovalcode = creditcardapprovalcode.toOption.get, currencyrateid = currencyrateid.toOption.get, subtotal = subtotal.toOption.get, taxamt = taxamt.toOption.get, freight = freight.toOption.get, totaldue = totaldue.toOption.get, comment = comment.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, comment, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SalesorderheaderRow] = new JsonEncoder[SalesorderheaderRow] {
    override def unsafeEncode(a: SalesorderheaderRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""salesorderid":""")
      SalesorderheaderId.jsonEncoder.unsafeEncode(a.salesorderid, indent, out)
      out.write(",")
      out.write(""""revisionnumber":""")
      TypoShort.jsonEncoder.unsafeEncode(a.revisionnumber, indent, out)
      out.write(",")
      out.write(""""orderdate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.orderdate, indent, out)
      out.write(",")
      out.write(""""duedate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.duedate, indent, out)
      out.write(",")
      out.write(""""shipdate":""")
      JsonEncoder.option(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.shipdate, indent, out)
      out.write(",")
      out.write(""""status":""")
      TypoShort.jsonEncoder.unsafeEncode(a.status, indent, out)
      out.write(",")
      out.write(""""onlineorderflag":""")
      Flag.jsonEncoder.unsafeEncode(a.onlineorderflag, indent, out)
      out.write(",")
      out.write(""""purchaseordernumber":""")
      JsonEncoder.option(OrderNumber.jsonEncoder).unsafeEncode(a.purchaseordernumber, indent, out)
      out.write(",")
      out.write(""""accountnumber":""")
      JsonEncoder.option(AccountNumber.jsonEncoder).unsafeEncode(a.accountnumber, indent, out)
      out.write(",")
      out.write(""""customerid":""")
      CustomerId.jsonEncoder.unsafeEncode(a.customerid, indent, out)
      out.write(",")
      out.write(""""salespersonid":""")
      JsonEncoder.option(BusinessentityId.jsonEncoder).unsafeEncode(a.salespersonid, indent, out)
      out.write(",")
      out.write(""""territoryid":""")
      JsonEncoder.option(SalesterritoryId.jsonEncoder).unsafeEncode(a.territoryid, indent, out)
      out.write(",")
      out.write(""""billtoaddressid":""")
      AddressId.jsonEncoder.unsafeEncode(a.billtoaddressid, indent, out)
      out.write(",")
      out.write(""""shiptoaddressid":""")
      AddressId.jsonEncoder.unsafeEncode(a.shiptoaddressid, indent, out)
      out.write(",")
      out.write(""""shipmethodid":""")
      ShipmethodId.jsonEncoder.unsafeEncode(a.shipmethodid, indent, out)
      out.write(",")
      out.write(""""creditcardid":""")
      JsonEncoder.option(CustomCreditcardId.jsonEncoder).unsafeEncode(a.creditcardid, indent, out)
      out.write(",")
      out.write(""""creditcardapprovalcode":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.creditcardapprovalcode, indent, out)
      out.write(",")
      out.write(""""currencyrateid":""")
      JsonEncoder.option(CurrencyrateId.jsonEncoder).unsafeEncode(a.currencyrateid, indent, out)
      out.write(",")
      out.write(""""subtotal":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.subtotal, indent, out)
      out.write(",")
      out.write(""""taxamt":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.taxamt, indent, out)
      out.write(",")
      out.write(""""freight":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.freight, indent, out)
      out.write(",")
      out.write(""""totaldue":""")
      JsonEncoder.option(JsonEncoder.scalaBigDecimal).unsafeEncode(a.totaldue, indent, out)
      out.write(",")
      out.write(""""comment":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.comment, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[SalesorderheaderRow] = Text.instance[SalesorderheaderRow]{ (row, sb) =>
    SalesorderheaderId.text.unsafeEncode(row.salesorderid, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.revisionnumber, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.orderdate, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.duedate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.shipdate, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.status, sb)
    sb.append(Text.DELIMETER)
    Flag.text.unsafeEncode(row.onlineorderflag, sb)
    sb.append(Text.DELIMETER)
    Text.option(OrderNumber.text).unsafeEncode(row.purchaseordernumber, sb)
    sb.append(Text.DELIMETER)
    Text.option(AccountNumber.text).unsafeEncode(row.accountnumber, sb)
    sb.append(Text.DELIMETER)
    CustomerId.text.unsafeEncode(row.customerid, sb)
    sb.append(Text.DELIMETER)
    Text.option(BusinessentityId.text).unsafeEncode(row.salespersonid, sb)
    sb.append(Text.DELIMETER)
    Text.option(SalesterritoryId.text).unsafeEncode(row.territoryid, sb)
    sb.append(Text.DELIMETER)
    AddressId.text.unsafeEncode(row.billtoaddressid, sb)
    sb.append(Text.DELIMETER)
    AddressId.text.unsafeEncode(row.shiptoaddressid, sb)
    sb.append(Text.DELIMETER)
    ShipmethodId.text.unsafeEncode(row.shipmethodid, sb)
    sb.append(Text.DELIMETER)
    Text.option(CustomCreditcardId.text).unsafeEncode(row.creditcardid, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.creditcardapprovalcode, sb)
    sb.append(Text.DELIMETER)
    Text.option(CurrencyrateId.text).unsafeEncode(row.currencyrateid, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.subtotal, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.taxamt, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.freight, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.bigDecimalInstance).unsafeEncode(row.totaldue, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.comment, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
