/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.contacttype;

import adventureworks.Text;
import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.public.Name;
import anorm.RowParser;
import anorm.Success;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** Table: person.contacttype
  * Lookup table containing the types of business entity contacts.
  * Primary key: contacttypeid
  */
case class ContacttypeRow(/** Primary key for ContactType records.
                            * Default: nextval('person.contacttype_contacttypeid_seq'::regclass)
                            */
                          contacttypeid: ContacttypeId, /** Contact type description. */
                          name: Name, /** Default: now() */
                          modifieddate: TypoLocalDateTime) {
  def id: ContacttypeId = contacttypeid
  def toUnsavedRow(contacttypeid: Defaulted[ContacttypeId], modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ContacttypeRowUnsaved = new ContacttypeRowUnsaved(name, contacttypeid, modifieddate)
}

object ContacttypeRow {
  implicit lazy val reads: Reads[ContacttypeRow] = {
    Reads[ContacttypeRow](json => JsResult.fromTry(
        Try(
          ContacttypeRow(
            contacttypeid = json.\("contacttypeid").as(ContacttypeId.reads),
            name = json.\("name").as(Name.reads),
            modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
          )
        )
      ),
    )
  }
  def rowParser(idx: Int): RowParser[ContacttypeRow] = {
    RowParser[ContacttypeRow] { row =>
      Success(
        ContacttypeRow(
          contacttypeid = row(idx + 0)(ContacttypeId.column),
          name = row(idx + 1)(Name.column),
          modifieddate = row(idx + 2)(TypoLocalDateTime.column)
        )
      )
    }
  }
  implicit lazy val text: Text[ContacttypeRow] = {
    Text.instance[ContacttypeRow]{ (row, sb) =>
      ContacttypeId.text.unsafeEncode(row.contacttypeid, sb)
      sb.append(Text.DELIMETER)
      Name.text.unsafeEncode(row.name, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    }
  }
  implicit lazy val writes: OWrites[ContacttypeRow] = {
    OWrites[ContacttypeRow](o =>
      new JsObject(ListMap[String, JsValue](
        "contacttypeid" -> ContacttypeId.writes.writes(o.contacttypeid),
        "name" -> Name.writes.writes(o.name),
        "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
      ))
    )
  }
}