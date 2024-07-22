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
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;
import zio.json.ast.Json;
import zio.json.internal.Write;

/** This class corresponds to a row in table `sales.salesorderdetail` which has not been persisted yet */
case class SalesorderdetailRowUnsaved(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
    * Points to [[adventureworks.sales.salesorderheader.SalesorderheaderRow.salesorderid]]
    */
  salesorderid: SalesorderheaderId,
  /** Shipment tracking number supplied by the shipper. */
  carriertrackingnumber: Option[/* max 25 chars */ String],
  /** Quantity ordered per product.
    * Constraint CK_SalesOrderDetail_OrderQty affecting columns orderqty:  ((orderqty > 0))
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
    * Constraint CK_SalesOrderDetail_UnitPrice affecting columns unitprice:  ((unitprice >= 0.00))
    */
  unitprice: BigDecimal,
  /** Default: nextval('sales.salesorderdetail_salesorderdetailid_seq'::regclass)
    * Primary key. One incremental unique number per product sold.
    */
  salesorderdetailid: Defaulted[Int] = Defaulted.UseDefault(),
  /** Default: 0.0
    * Discount amount.
    * Constraint CK_SalesOrderDetail_UnitPriceDiscount affecting columns unitpricediscount:  ((unitpricediscount >= 0.00))
    */
  unitpricediscount: Defaulted[BigDecimal] = Defaulted.UseDefault(),
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault(),
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault()
) {
  def toRow(
    salesorderdetailidDefault: => Int,
    unitpricediscountDefault: => BigDecimal,
    rowguidDefault: => TypoUUID,
    modifieddateDefault: => TypoLocalDateTime
  ): SalesorderdetailRow = {
    new SalesorderdetailRow(
      salesorderid = salesorderid,
      salesorderdetailid = salesorderdetailid.getOrElse(salesorderdetailidDefault),
      carriertrackingnumber = carriertrackingnumber,
      orderqty = orderqty,
      productid = productid,
      specialofferid = specialofferid,
      unitprice = unitprice,
      unitpricediscount = unitpricediscount.getOrElse(unitpricediscountDefault),
      rowguid = rowguid.getOrElse(rowguidDefault),
      modifieddate = modifieddate.getOrElse(modifieddateDefault)
    )
  }
}

object SalesorderdetailRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[SalesorderdetailRowUnsaved] = {
    JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
      val salesorderid = jsonObj.get("salesorderid").toRight("Missing field 'salesorderid'").flatMap(_.as(SalesorderheaderId.jsonDecoder))
      val carriertrackingnumber = jsonObj.get("carriertrackingnumber").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
      val orderqty = jsonObj.get("orderqty").toRight("Missing field 'orderqty'").flatMap(_.as(TypoShort.jsonDecoder))
      val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
      val specialofferid = jsonObj.get("specialofferid").toRight("Missing field 'specialofferid'").flatMap(_.as(SpecialofferId.jsonDecoder))
      val unitprice = jsonObj.get("unitprice").toRight("Missing field 'unitprice'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
      val salesorderdetailid = jsonObj.get("salesorderdetailid").toRight("Missing field 'salesorderdetailid'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.int)))
      val unitpricediscount = jsonObj.get("unitpricediscount").toRight("Missing field 'unitpricediscount'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.scalaBigDecimal)))
      val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(Defaulted.jsonDecoder(TypoUUID.jsonDecoder)))
      val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
      if (salesorderid.isRight && carriertrackingnumber.isRight && orderqty.isRight && productid.isRight && specialofferid.isRight && unitprice.isRight && salesorderdetailid.isRight && unitpricediscount.isRight && rowguid.isRight && modifieddate.isRight)
        Right(SalesorderdetailRowUnsaved(salesorderid = salesorderid.toOption.get, carriertrackingnumber = carriertrackingnumber.toOption.get, orderqty = orderqty.toOption.get, productid = productid.toOption.get, specialofferid = specialofferid.toOption.get, unitprice = unitprice.toOption.get, salesorderdetailid = salesorderdetailid.toOption.get, unitpricediscount = unitpricediscount.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
      else Left(List[Either[String, Any]](salesorderid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, salesorderdetailid, unitpricediscount, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
    }
  }
  implicit lazy val jsonEncoder: JsonEncoder[SalesorderdetailRowUnsaved] = {
    new JsonEncoder[SalesorderdetailRowUnsaved] {
      override def unsafeEncode(a: SalesorderdetailRowUnsaved, indent: Option[Int], out: Write): Unit = {
        out.write("{")
        out.write(""""salesorderid":""")
        SalesorderheaderId.jsonEncoder.unsafeEncode(a.salesorderid, indent, out)
        out.write(",")
        out.write(""""carriertrackingnumber":""")
        JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.carriertrackingnumber, indent, out)
        out.write(",")
        out.write(""""orderqty":""")
        TypoShort.jsonEncoder.unsafeEncode(a.orderqty, indent, out)
        out.write(",")
        out.write(""""productid":""")
        ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
        out.write(",")
        out.write(""""specialofferid":""")
        SpecialofferId.jsonEncoder.unsafeEncode(a.specialofferid, indent, out)
        out.write(",")
        out.write(""""unitprice":""")
        JsonEncoder.scalaBigDecimal.unsafeEncode(a.unitprice, indent, out)
        out.write(",")
        out.write(""""salesorderdetailid":""")
        Defaulted.jsonEncoder(JsonEncoder.int).unsafeEncode(a.salesorderdetailid, indent, out)
        out.write(",")
        out.write(""""unitpricediscount":""")
        Defaulted.jsonEncoder(JsonEncoder.scalaBigDecimal).unsafeEncode(a.unitpricediscount, indent, out)
        out.write(",")
        out.write(""""rowguid":""")
        Defaulted.jsonEncoder(TypoUUID.jsonEncoder).unsafeEncode(a.rowguid, indent, out)
        out.write(",")
        out.write(""""modifieddate":""")
        Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
        out.write("}")
      }
    }
  }
  implicit lazy val text: Text[SalesorderdetailRowUnsaved] = {
    Text.instance[SalesorderdetailRowUnsaved]{ (row, sb) =>
      SalesorderheaderId.text.unsafeEncode(row.salesorderid, sb)
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
      Defaulted.text(Text.intInstance).unsafeEncode(row.salesorderdetailid, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.unitpricediscount, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
    }
  }
}