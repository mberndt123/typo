/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productdescription

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `production.productdescription` which has not been persisted yet */
case class ProductdescriptionRowUnsaved(
  /** Description of the product. */
  description: /* max 400 chars */ String,
  /** Default: nextval('production.productdescription_productdescriptionid_seq'::regclass)
      Primary key for ProductDescription records. */
  productdescriptionid: Defaulted[ProductdescriptionId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productdescriptionidDefault: => ProductdescriptionId, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): ProductdescriptionRow =
    ProductdescriptionRow(
      productdescriptionid = productdescriptionid match {
                               case Defaulted.UseDefault => productdescriptionidDefault
                               case Defaulted.Provided(value) => value
                             },
      description = description,
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductdescriptionRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[ProductdescriptionRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val description = jsonObj.get("description").toRight("Missing field 'description'").flatMap(_.as(JsonDecoder.string))
    val productdescriptionid = jsonObj.get("productdescriptionid").toRight("Missing field 'productdescriptionid'").flatMap(_.as(Defaulted.jsonDecoder(ProductdescriptionId.jsonDecoder)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(Defaulted.jsonDecoder(TypoUUID.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (description.isRight && productdescriptionid.isRight && rowguid.isRight && modifieddate.isRight)
      Right(ProductdescriptionRowUnsaved(description = description.toOption.get, productdescriptionid = productdescriptionid.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](description, productdescriptionid, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductdescriptionRowUnsaved] = new JsonEncoder[ProductdescriptionRowUnsaved] {
    override def unsafeEncode(a: ProductdescriptionRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""description":""")
      JsonEncoder.string.unsafeEncode(a.description, indent, out)
      out.write(",")
      out.write(""""productdescriptionid":""")
      Defaulted.jsonEncoder(ProductdescriptionId.jsonEncoder).unsafeEncode(a.productdescriptionid, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      Defaulted.jsonEncoder(TypoUUID.jsonEncoder).unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ProductdescriptionRowUnsaved] = Text.instance[ProductdescriptionRowUnsaved]{ (row, sb) =>
    Text.stringInstance.unsafeEncode(row.description, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(ProductdescriptionId.text).unsafeEncode(row.productdescriptionid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
