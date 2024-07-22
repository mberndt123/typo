/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesreason

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `sales.salesreason` which has not been persisted yet */
case class SalesreasonRowUnsaved(
  /** Sales reason description. */
  name: Name,
  /** Category the sales reason belongs to. */
  reasontype: Name,
  /** Default: nextval('sales.salesreason_salesreasonid_seq'::regclass)
      Primary key for SalesReason records. */
  salesreasonid: Defaulted[SalesreasonId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(salesreasonidDefault: => SalesreasonId, modifieddateDefault: => TypoLocalDateTime): SalesreasonRow =
    SalesreasonRow(
      salesreasonid = salesreasonid match {
                        case Defaulted.UseDefault => salesreasonidDefault
                        case Defaulted.Provided(value) => value
                      },
      name = name,
      reasontype = reasontype,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object SalesreasonRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[SalesreasonRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val reasontype = jsonObj.get("reasontype").toRight("Missing field 'reasontype'").flatMap(_.as(Name.jsonDecoder))
    val salesreasonid = jsonObj.get("salesreasonid").toRight("Missing field 'salesreasonid'").flatMap(_.as(Defaulted.jsonDecoder(SalesreasonId.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (name.isRight && reasontype.isRight && salesreasonid.isRight && modifieddate.isRight)
      Right(SalesreasonRowUnsaved(name = name.toOption.get, reasontype = reasontype.toOption.get, salesreasonid = salesreasonid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](name, reasontype, salesreasonid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SalesreasonRowUnsaved] = new JsonEncoder[SalesreasonRowUnsaved] {
    override def unsafeEncode(a: SalesreasonRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""reasontype":""")
      Name.jsonEncoder.unsafeEncode(a.reasontype, indent, out)
      out.write(",")
      out.write(""""salesreasonid":""")
      Defaulted.jsonEncoder(SalesreasonId.jsonEncoder).unsafeEncode(a.salesreasonid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[SalesreasonRowUnsaved] = Text.instance[SalesreasonRowUnsaved]{ (row, sb) =>
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.reasontype, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(SalesreasonId.text).unsafeEncode(row.salesreasonid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
