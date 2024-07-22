/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.shoppingcartitem;

import adventureworks.Text;
import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.production.product.ProductId;
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;
import zio.json.ast.Json;
import zio.json.internal.Write;

/** This class corresponds to a row in table `sales.shoppingcartitem` which has not been persisted yet */
case class ShoppingcartitemRowUnsaved(
  /** Shopping cart identification number. */
  shoppingcartid: /* max 50 chars */ String,
  /** Product ordered. Foreign key to Product.ProductID.
    * Points to [[adventureworks.production.product.ProductRow.productid]]
    */
  productid: ProductId,
  /** Default: nextval('sales.shoppingcartitem_shoppingcartitemid_seq'::regclass)
    * Primary key for ShoppingCartItem records.
    */
  shoppingcartitemid: Defaulted[ShoppingcartitemId] = Defaulted.UseDefault(),
  /** Default: 1
    * Product quantity ordered.
    * Constraint CK_ShoppingCartItem_Quantity affecting columns quantity:  ((quantity >= 1))
    */
  quantity: Defaulted[Int] = Defaulted.UseDefault(),
  /** Default: now()
    * Date the time the record was created.
    */
  datecreated: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault(),
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault()
) {
  def toRow(
    shoppingcartitemidDefault: => ShoppingcartitemId,
    quantityDefault: => Int,
    datecreatedDefault: => TypoLocalDateTime,
    modifieddateDefault: => TypoLocalDateTime
  ): ShoppingcartitemRow = {
    new ShoppingcartitemRow(
      shoppingcartitemid = shoppingcartitemid.getOrElse(shoppingcartitemidDefault),
      shoppingcartid = shoppingcartid,
      quantity = quantity.getOrElse(quantityDefault),
      productid = productid,
      datecreated = datecreated.getOrElse(datecreatedDefault),
      modifieddate = modifieddate.getOrElse(modifieddateDefault)
    )
  }
}

object ShoppingcartitemRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[ShoppingcartitemRowUnsaved] = {
    JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
      val shoppingcartid = jsonObj.get("shoppingcartid").toRight("Missing field 'shoppingcartid'").flatMap(_.as(JsonDecoder.string))
      val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
      val shoppingcartitemid = jsonObj.get("shoppingcartitemid").toRight("Missing field 'shoppingcartitemid'").flatMap(_.as(Defaulted.jsonDecoder(ShoppingcartitemId.jsonDecoder)))
      val quantity = jsonObj.get("quantity").toRight("Missing field 'quantity'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.int)))
      val datecreated = jsonObj.get("datecreated").toRight("Missing field 'datecreated'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
      val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
      if (shoppingcartid.isRight && productid.isRight && shoppingcartitemid.isRight && quantity.isRight && datecreated.isRight && modifieddate.isRight)
        Right(ShoppingcartitemRowUnsaved(shoppingcartid = shoppingcartid.toOption.get, productid = productid.toOption.get, shoppingcartitemid = shoppingcartitemid.toOption.get, quantity = quantity.toOption.get, datecreated = datecreated.toOption.get, modifieddate = modifieddate.toOption.get))
      else Left(List[Either[String, Any]](shoppingcartid, productid, shoppingcartitemid, quantity, datecreated, modifieddate).flatMap(_.left.toOption).mkString(", "))
    }
  }
  implicit lazy val jsonEncoder: JsonEncoder[ShoppingcartitemRowUnsaved] = {
    new JsonEncoder[ShoppingcartitemRowUnsaved] {
      override def unsafeEncode(a: ShoppingcartitemRowUnsaved, indent: Option[Int], out: Write): Unit = {
        out.write("{")
        out.write(""""shoppingcartid":""")
        JsonEncoder.string.unsafeEncode(a.shoppingcartid, indent, out)
        out.write(",")
        out.write(""""productid":""")
        ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
        out.write(",")
        out.write(""""shoppingcartitemid":""")
        Defaulted.jsonEncoder(ShoppingcartitemId.jsonEncoder).unsafeEncode(a.shoppingcartitemid, indent, out)
        out.write(",")
        out.write(""""quantity":""")
        Defaulted.jsonEncoder(JsonEncoder.int).unsafeEncode(a.quantity, indent, out)
        out.write(",")
        out.write(""""datecreated":""")
        Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.datecreated, indent, out)
        out.write(",")
        out.write(""""modifieddate":""")
        Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
        out.write("}")
      }
    }
  }
  implicit lazy val text: Text[ShoppingcartitemRowUnsaved] = {
    Text.instance[ShoppingcartitemRowUnsaved]{ (row, sb) =>
      Text.stringInstance.unsafeEncode(row.shoppingcartid, sb)
      sb.append(Text.DELIMETER)
      ProductId.text.unsafeEncode(row.productid, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(ShoppingcartitemId.text).unsafeEncode(row.shoppingcartitemid, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(Text.intInstance).unsafeEncode(row.quantity, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.datecreated, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
    }
  }
}