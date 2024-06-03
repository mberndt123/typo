/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package unitmeasure

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `production.unitmeasure` which has not been persisted yet */
case class UnitmeasureRowUnsaved(
  /** Primary key. */
  unitmeasurecode: UnitmeasureId,
  /** Unit of measure description. */
  name: Name,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): UnitmeasureRow =
    UnitmeasureRow(
      unitmeasurecode = unitmeasurecode,
      name = name,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object UnitmeasureRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[UnitmeasureRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val unitmeasurecode = jsonObj.get("unitmeasurecode").toRight("Missing field 'unitmeasurecode'").flatMap(_.as(UnitmeasureId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (unitmeasurecode.isRight && name.isRight && modifieddate.isRight)
      Right(UnitmeasureRowUnsaved(unitmeasurecode = unitmeasurecode.toOption.get, name = name.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](unitmeasurecode, name, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[UnitmeasureRowUnsaved] = new JsonEncoder[UnitmeasureRowUnsaved] {
    override def unsafeEncode(a: UnitmeasureRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""unitmeasurecode":""")
      UnitmeasureId.jsonEncoder.unsafeEncode(a.unitmeasurecode, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[UnitmeasureRowUnsaved] = Text.instance[UnitmeasureRowUnsaved]{ (row, sb) =>
    UnitmeasureId.text.unsafeEncode(row.unitmeasurecode, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
