/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.phonenumbertype

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `person.phonenumbertype` which has not been persisted yet */
case class PhonenumbertypeRowUnsaved(
  /** Name of the telephone number type */
  name: Name,
  /** Default: nextval('person.phonenumbertype_phonenumbertypeid_seq'::regclass)
      Primary key for telephone number type records. */
  phonenumbertypeid: Defaulted[PhonenumbertypeId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(phonenumbertypeidDefault: => PhonenumbertypeId, modifieddateDefault: => TypoLocalDateTime): PhonenumbertypeRow =
    PhonenumbertypeRow(
      name = name,
      phonenumbertypeid = phonenumbertypeid match {
                            case Defaulted.UseDefault => phonenumbertypeidDefault
                            case Defaulted.Provided(value) => value
                          },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object PhonenumbertypeRowUnsaved {
  implicit lazy val reads: Reads[PhonenumbertypeRowUnsaved] = Reads[PhonenumbertypeRowUnsaved](json => JsResult.fromTry(
      Try(
        PhonenumbertypeRowUnsaved(
          name = json.\("name").as(Name.reads),
          phonenumbertypeid = json.\("phonenumbertypeid").as(Defaulted.reads(PhonenumbertypeId.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val text: Text[PhonenumbertypeRowUnsaved] = Text.instance[PhonenumbertypeRowUnsaved]{ (row, sb) =>
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(PhonenumbertypeId.text).unsafeEncode(row.phonenumbertypeid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[PhonenumbertypeRowUnsaved] = OWrites[PhonenumbertypeRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Name.writes.writes(o.name),
      "phonenumbertypeid" -> Defaulted.writes(PhonenumbertypeId.writes).writes(o.phonenumbertypeid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
