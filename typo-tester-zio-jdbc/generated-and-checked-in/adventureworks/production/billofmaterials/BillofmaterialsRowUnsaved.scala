/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `production.billofmaterials` which has not been persisted yet */
case class BillofmaterialsRowUnsaved(
  /** Parent product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]]
      Constraint CK_BillOfMaterials_BOMLevel affecting columns bomlevel, perassemblyqty, productassemblyid:  ((((productassemblyid IS NULL) AND (bomlevel = 0) AND (perassemblyqty = 1.00)) OR ((productassemblyid IS NOT NULL) AND (bomlevel >= 1))))
      Constraint CK_BillOfMaterials_ProductAssemblyID affecting columns componentid, productassemblyid:  ((productassemblyid <> componentid)) */
  productassemblyid: Option[ProductId],
  /** Component identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]]
      Constraint CK_BillOfMaterials_ProductAssemblyID affecting columns componentid, productassemblyid:  ((productassemblyid <> componentid)) */
  componentid: ProductId,
  /** Date the component stopped being used in the assembly item.
      Constraint CK_BillOfMaterials_EndDate affecting columns enddate, startdate:  (((enddate > startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Standard code identifying the unit of measure for the quantity.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Indicates the depth the component is from its parent (AssemblyID).
      Constraint CK_BillOfMaterials_BOMLevel affecting columns bomlevel, perassemblyqty, productassemblyid:  ((((productassemblyid IS NULL) AND (bomlevel = 0) AND (perassemblyqty = 1.00)) OR ((productassemblyid IS NOT NULL) AND (bomlevel >= 1)))) */
  bomlevel: TypoShort,
  /** Default: nextval('production.billofmaterials_billofmaterialsid_seq'::regclass)
      Primary key for BillOfMaterials records. */
  billofmaterialsid: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: now()
      Date the component started being used in the assembly item.
      Constraint CK_BillOfMaterials_EndDate affecting columns enddate, startdate:  (((enddate > startdate) OR (enddate IS NULL))) */
  startdate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: 1.00
      Quantity of the component needed to create the assembly.
      Constraint CK_BillOfMaterials_BOMLevel affecting columns bomlevel, perassemblyqty, productassemblyid:  ((((productassemblyid IS NULL) AND (bomlevel = 0) AND (perassemblyqty = 1.00)) OR ((productassemblyid IS NOT NULL) AND (bomlevel >= 1))))
      Constraint CK_BillOfMaterials_PerAssemblyQty affecting columns perassemblyqty:  ((perassemblyqty >= 1.00)) */
  perassemblyqty: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(billofmaterialsidDefault: => Int, startdateDefault: => TypoLocalDateTime, perassemblyqtyDefault: => BigDecimal, modifieddateDefault: => TypoLocalDateTime): BillofmaterialsRow =
    BillofmaterialsRow(
      productassemblyid = productassemblyid,
      componentid = componentid,
      enddate = enddate,
      unitmeasurecode = unitmeasurecode,
      bomlevel = bomlevel,
      billofmaterialsid = billofmaterialsid match {
                            case Defaulted.UseDefault => billofmaterialsidDefault
                            case Defaulted.Provided(value) => value
                          },
      startdate = startdate match {
                    case Defaulted.UseDefault => startdateDefault
                    case Defaulted.Provided(value) => value
                  },
      perassemblyqty = perassemblyqty match {
                         case Defaulted.UseDefault => perassemblyqtyDefault
                         case Defaulted.Provided(value) => value
                       },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object BillofmaterialsRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[BillofmaterialsRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productassemblyid = jsonObj.get("productassemblyid").fold[Either[String, Option[ProductId]]](Right(None))(_.as(JsonDecoder.option(using ProductId.jsonDecoder)))
    val componentid = jsonObj.get("componentid").toRight("Missing field 'componentid'").flatMap(_.as(ProductId.jsonDecoder))
    val enddate = jsonObj.get("enddate").fold[Either[String, Option[TypoLocalDateTime]]](Right(None))(_.as(JsonDecoder.option(using TypoLocalDateTime.jsonDecoder)))
    val unitmeasurecode = jsonObj.get("unitmeasurecode").toRight("Missing field 'unitmeasurecode'").flatMap(_.as(UnitmeasureId.jsonDecoder))
    val bomlevel = jsonObj.get("bomlevel").toRight("Missing field 'bomlevel'").flatMap(_.as(TypoShort.jsonDecoder))
    val billofmaterialsid = jsonObj.get("billofmaterialsid").toRight("Missing field 'billofmaterialsid'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.int)))
    val startdate = jsonObj.get("startdate").toRight("Missing field 'startdate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    val perassemblyqty = jsonObj.get("perassemblyqty").toRight("Missing field 'perassemblyqty'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.scalaBigDecimal)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (productassemblyid.isRight && componentid.isRight && enddate.isRight && unitmeasurecode.isRight && bomlevel.isRight && billofmaterialsid.isRight && startdate.isRight && perassemblyqty.isRight && modifieddate.isRight)
      Right(BillofmaterialsRowUnsaved(productassemblyid = productassemblyid.toOption.get, componentid = componentid.toOption.get, enddate = enddate.toOption.get, unitmeasurecode = unitmeasurecode.toOption.get, bomlevel = bomlevel.toOption.get, billofmaterialsid = billofmaterialsid.toOption.get, startdate = startdate.toOption.get, perassemblyqty = perassemblyqty.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productassemblyid, componentid, enddate, unitmeasurecode, bomlevel, billofmaterialsid, startdate, perassemblyqty, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[BillofmaterialsRowUnsaved] = new JsonEncoder[BillofmaterialsRowUnsaved] {
    override def unsafeEncode(a: BillofmaterialsRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productassemblyid":""")
      JsonEncoder.option(using ProductId.jsonEncoder).unsafeEncode(a.productassemblyid, indent, out)
      out.write(",")
      out.write(""""componentid":""")
      ProductId.jsonEncoder.unsafeEncode(a.componentid, indent, out)
      out.write(",")
      out.write(""""enddate":""")
      JsonEncoder.option(using TypoLocalDateTime.jsonEncoder).unsafeEncode(a.enddate, indent, out)
      out.write(",")
      out.write(""""unitmeasurecode":""")
      UnitmeasureId.jsonEncoder.unsafeEncode(a.unitmeasurecode, indent, out)
      out.write(",")
      out.write(""""bomlevel":""")
      TypoShort.jsonEncoder.unsafeEncode(a.bomlevel, indent, out)
      out.write(",")
      out.write(""""billofmaterialsid":""")
      Defaulted.jsonEncoder(JsonEncoder.int).unsafeEncode(a.billofmaterialsid, indent, out)
      out.write(",")
      out.write(""""startdate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.startdate, indent, out)
      out.write(",")
      out.write(""""perassemblyqty":""")
      Defaulted.jsonEncoder(JsonEncoder.scalaBigDecimal).unsafeEncode(a.perassemblyqty, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[BillofmaterialsRowUnsaved] = Text.instance[BillofmaterialsRowUnsaved]{ (row, sb) =>
    Text.option(ProductId.text).unsafeEncode(row.productassemblyid, sb)
    sb.append(Text.DELIMETER)
    ProductId.text.unsafeEncode(row.componentid, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    UnitmeasureId.text.unsafeEncode(row.unitmeasurecode, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.bomlevel, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.intInstance).unsafeEncode(row.billofmaterialsid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.perassemblyqty, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
