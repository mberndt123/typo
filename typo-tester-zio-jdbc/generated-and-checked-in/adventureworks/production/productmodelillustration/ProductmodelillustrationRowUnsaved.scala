/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productmodelillustration

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `production.productmodelillustration` which has not been persisted yet */
case class ProductmodelillustrationRowUnsaved(
  /** Primary key. Foreign key to ProductModel.ProductModelID.
      Points to [[adventureworks.production.productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Primary key. Foreign key to Illustration.IllustrationID.
      Points to [[adventureworks.production.illustration.IllustrationRow.illustrationid]] */
  illustrationid: IllustrationId,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): ProductmodelillustrationRow =
    ProductmodelillustrationRow(
      productmodelid = productmodelid,
      illustrationid = illustrationid,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductmodelillustrationRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[ProductmodelillustrationRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productmodelid = jsonObj.get("productmodelid").toRight("Missing field 'productmodelid'").flatMap(_.as(ProductmodelId.jsonDecoder))
    val illustrationid = jsonObj.get("illustrationid").toRight("Missing field 'illustrationid'").flatMap(_.as(IllustrationId.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (productmodelid.isRight && illustrationid.isRight && modifieddate.isRight)
      Right(ProductmodelillustrationRowUnsaved(productmodelid = productmodelid.toOption.get, illustrationid = illustrationid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productmodelid, illustrationid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductmodelillustrationRowUnsaved] = new JsonEncoder[ProductmodelillustrationRowUnsaved] {
    override def unsafeEncode(a: ProductmodelillustrationRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productmodelid":""")
      ProductmodelId.jsonEncoder.unsafeEncode(a.productmodelid, indent, out)
      out.write(",")
      out.write(""""illustrationid":""")
      IllustrationId.jsonEncoder.unsafeEncode(a.illustrationid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ProductmodelillustrationRowUnsaved] = Text.instance[ProductmodelillustrationRowUnsaved]{ (row, sb) =>
    ProductmodelId.text.unsafeEncode(row.productmodelid, sb)
    sb.append(Text.DELIMETER)
    IllustrationId.text.unsafeEncode(row.illustrationid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
