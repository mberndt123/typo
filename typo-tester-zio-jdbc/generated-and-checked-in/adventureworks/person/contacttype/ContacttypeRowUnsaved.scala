/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `person.contacttype` which has not been persisted yet */
case class ContacttypeRowUnsaved(
  /** Contact type description. */
  name: Name,
  /** Default: nextval('person.contacttype_contacttypeid_seq'::regclass)
      Primary key for ContactType records. */
  contacttypeid: Defaulted[ContacttypeId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(contacttypeidDefault: => ContacttypeId, modifieddateDefault: => TypoLocalDateTime): ContacttypeRow =
    ContacttypeRow(
      name = name,
      contacttypeid = contacttypeid match {
                        case Defaulted.UseDefault => contacttypeidDefault
                        case Defaulted.Provided(value) => value
                      },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ContacttypeRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[ContacttypeRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val contacttypeid = jsonObj.get("contacttypeid").toRight("Missing field 'contacttypeid'").flatMap(_.as(Defaulted.jsonDecoder(ContacttypeId.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (name.isRight && contacttypeid.isRight && modifieddate.isRight)
      Right(ContacttypeRowUnsaved(name = name.toOption.get, contacttypeid = contacttypeid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](name, contacttypeid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ContacttypeRowUnsaved] = new JsonEncoder[ContacttypeRowUnsaved] {
    override def unsafeEncode(a: ContacttypeRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""contacttypeid":""")
      Defaulted.jsonEncoder(ContacttypeId.jsonEncoder).unsafeEncode(a.contacttypeid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ContacttypeRowUnsaved] = Text.instance[ContacttypeRowUnsaved]{ (row, sb) =>
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(ContacttypeId.text).unsafeEncode(row.contacttypeid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
