/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesorderdetail;

import adventureworks.Text;
import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoShort;
import adventureworks.customtypes.TypoUUID;
import adventureworks.production.product.ProductId;
import adventureworks.sales.salesorderheader.SalesorderheaderId;
import adventureworks.sales.specialoffer.SpecialofferId;
import adventureworks.sales.specialofferproduct.SpecialofferproductId;
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

/** Table: sales.salesorderdetail
  * Individual products associated with a specific sales order. See SalesOrderHeader.
  * Composite primary key: salesorderid, salesorderdetailid
  */
case class SalesorderdetailRow(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
    * Points to [[adventureworks.sales.salesorderheader.SalesorderheaderRow.salesorderid]]
    */
  salesorderid: SalesorderheaderId,
  /** Primary key. One incremental unique number per product sold.
    * Default: nextval('sales.salesorderdetail_salesorderdetailid_seq'::regclass)
    */
  salesorderdetailid: Int,
  /** Shipment tracking number supplied by the shipper. */
  carriertrackingnumber: Option[/* max 25 chars */ String],
  /** Quantity ordered per product.
    * Constraint CK_SalesOrderDetail_OrderQty affecting columns orderqty: ((orderqty > 0))
    */
  orderqty: TypoShort,
  /** Product sold to customer. Foreign key to Product.ProductID.
    * Points to [[adventureworks.sales.specialofferproduct.SpecialofferproductRow.productid]]
    */
  productid: ProductId,
  /** Promotional code. Foreign key to SpecialOffer.SpecialOfferID.
    * Points to [[adventureworks.sales.specialofferproduct.SpecialofferproductRow.specialofferid]]
    */
  specialofferid: SpecialofferId,
  /** Selling price of a single product.
    * Constraint CK_SalesOrderDetail_UnitPrice affecting columns unitprice: ((unitprice >= 0.00))
    */
  unitprice: BigDecimal,
  /** Discount amount.
    * Default: 0.0
    * Constraint CK_SalesOrderDetail_UnitPriceDiscount affecting columns unitpricediscount: ((unitpricediscount >= 0.00))
    */
  unitpricediscount: BigDecimal,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
) {
  def compositeId: SalesorderdetailId = new SalesorderdetailId(salesorderid, salesorderdetailid)
  def id: SalesorderdetailId = compositeId
  def extractSpecialofferproductId: SpecialofferproductId = new SpecialofferproductId(specialofferid = specialofferid, productid = productid)
  def toUnsavedRow(
    salesorderdetailid: Defaulted[Int],
    unitpricediscount: Defaulted[BigDecimal] = Defaulted.Provided(this.unitpricediscount),
    rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid),
    modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)
  ): SalesorderdetailRowUnsaved = {
    new SalesorderdetailRowUnsaved(
      salesorderid,
      carriertrackingnumber,
      orderqty,
      productid,
      specialofferid,
      unitprice,
      salesorderdetailid,
      unitpricediscount,
      rowguid,
      modifieddate
    )
  }
}

object SalesorderdetailRow {
  def apply(
    compositeId: SalesorderdetailId,
    carriertrackingnumber: Option[/* max 25 chars */ String],
    orderqty: TypoShort,
    productid: ProductId,
    specialofferid: SpecialofferId,
    unitprice: BigDecimal,
    unitpricediscount: BigDecimal,
    rowguid: TypoUUID,
    modifieddate: TypoLocalDateTime
  ): SalesorderdetailRow = {
    new SalesorderdetailRow(
      compositeId.salesorderid,
      compositeId.salesorderdetailid,
      carriertrackingnumber,
      orderqty,
      productid,
      specialofferid,
      unitprice,
      unitpricediscount,
      rowguid,
      modifieddate
    )
  }
  implicit lazy val reads: Reads[SalesorderdetailRow] = {
    Reads[SalesorderdetailRow](json => JsResult.fromTry(
        Try(
          SalesorderdetailRow(
            salesorderid = json.\("salesorderid").as(SalesorderheaderId.reads),
            salesorderdetailid = json.\("salesorderdetailid").as(Reads.IntReads),
            carriertrackingnumber = json.\("carriertrackingnumber").toOption.map(_.as(Reads.StringReads)),
            orderqty = json.\("orderqty").as(TypoShort.reads),
            productid = json.\("productid").as(ProductId.reads),
            specialofferid = json.\("specialofferid").as(SpecialofferId.reads),
            unitprice = json.\("unitprice").as(Reads.bigDecReads),
            unitpricediscount = json.\("unitpricediscount").as(Reads.bigDecReads),
            rowguid = json.\("rowguid").as(TypoUUID.reads),
            modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
          )
        )
      ),
    )
  }
  def rowParser(idx: Int): RowParser[SalesorderdetailRow] = {
    RowParser[SalesorderdetailRow] { row =>
      Success(
        SalesorderdetailRow(
          salesorderid = row(idx + 0)(SalesorderheaderId.column),
          salesorderdetailid = row(idx + 1)(Column.columnToInt),
          carriertrackingnumber = row(idx + 2)(Column.columnToOption(Column.columnToString)),
          orderqty = row(idx + 3)(TypoShort.column),
          productid = row(idx + 4)(ProductId.column),
          specialofferid = row(idx + 5)(SpecialofferId.column),
          unitprice = row(idx + 6)(Column.columnToScalaBigDecimal),
          unitpricediscount = row(idx + 7)(Column.columnToScalaBigDecimal),
          rowguid = row(idx + 8)(TypoUUID.column),
          modifieddate = row(idx + 9)(TypoLocalDateTime.column)
        )
      )
    }
  }
  implicit lazy val text: Text[SalesorderdetailRow] = {
    Text.instance[SalesorderdetailRow]{ (row, sb) =>
      SalesorderheaderId.text.unsafeEncode(row.salesorderid, sb)
      sb.append(Text.DELIMETER)
      Text.intInstance.unsafeEncode(row.salesorderdetailid, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.carriertrackingnumber, sb)
      sb.append(Text.DELIMETER)
      TypoShort.text.unsafeEncode(row.orderqty, sb)
      sb.append(Text.DELIMETER)
      ProductId.text.unsafeEncode(row.productid, sb)
      sb.append(Text.DELIMETER)
      SpecialofferId.text.unsafeEncode(row.specialofferid, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.unitprice, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.unitpricediscount, sb)
      sb.append(Text.DELIMETER)
      TypoUUID.text.unsafeEncode(row.rowguid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    }
  }
  implicit lazy val writes: OWrites[SalesorderdetailRow] = {
    OWrites[SalesorderdetailRow](o =>
      new JsObject(ListMap[String, JsValue](
        "salesorderid" -> SalesorderheaderId.writes.writes(o.salesorderid),
        "salesorderdetailid" -> Writes.IntWrites.writes(o.salesorderdetailid),
        "carriertrackingnumber" -> Writes.OptionWrites(Writes.StringWrites).writes(o.carriertrackingnumber),
        "orderqty" -> TypoShort.writes.writes(o.orderqty),
        "productid" -> ProductId.writes.writes(o.productid),
        "specialofferid" -> SpecialofferId.writes.writes(o.specialofferid),
        "unitprice" -> Writes.BigDecimalWrites.writes(o.unitprice),
        "unitpricediscount" -> Writes.BigDecimalWrites.writes(o.unitpricediscount),
        "rowguid" -> TypoUUID.writes.writes(o.rowguid),
        "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
      ))
    )
  }
}