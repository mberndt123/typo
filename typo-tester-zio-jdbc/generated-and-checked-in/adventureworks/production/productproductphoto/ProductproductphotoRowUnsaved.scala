/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productproductphoto

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import adventureworks.public.Flag
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `production.productproductphoto` which has not been persisted yet */
case class ProductproductphotoRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Product photo identification number. Foreign key to ProductPhoto.ProductPhotoID.
      Points to [[productphoto.ProductphotoRow.productphotoid]] */
  productphotoid: ProductphotoId,
  /** Default: false
      0 = Photo is not the principal image. 1 = Photo is the principal image. */
  primary: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(primaryDefault: => Flag, modifieddateDefault: => TypoLocalDateTime): ProductproductphotoRow =
    ProductproductphotoRow(
      productid = productid,
      productphotoid = productphotoid,
      primary = primary match {
                  case Defaulted.UseDefault => primaryDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductproductphotoRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[ProductproductphotoRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val productphotoid = jsonObj.get("productphotoid").toRight("Missing field 'productphotoid'").flatMap(_.as(ProductphotoId.jsonDecoder))
    val primary = jsonObj.get("primary").toRight("Missing field 'primary'").flatMap(_.as(Defaulted.jsonDecoder(Flag.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (productid.isRight && productphotoid.isRight && primary.isRight && modifieddate.isRight)
      Right(ProductproductphotoRowUnsaved(productid = productid.toOption.get, productphotoid = productphotoid.toOption.get, primary = primary.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productid, productphotoid, primary, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductproductphotoRowUnsaved] = new JsonEncoder[ProductproductphotoRowUnsaved] {
    override def unsafeEncode(a: ProductproductphotoRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productid":""")
      ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
      out.write(",")
      out.write(""""productphotoid":""")
      ProductphotoId.jsonEncoder.unsafeEncode(a.productphotoid, indent, out)
      out.write(",")
      out.write(""""primary":""")
      Defaulted.jsonEncoder(Flag.jsonEncoder).unsafeEncode(a.primary, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ProductproductphotoRowUnsaved] = Text.instance[ProductproductphotoRowUnsaved]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    ProductphotoId.text.unsafeEncode(row.productphotoid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Flag.text).unsafeEncode(row.primary, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
