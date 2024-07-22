/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.person;

import adventureworks.Text;
import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.customtypes.TypoXml;
import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.public.Name;
import adventureworks.public.NameStyle;
import adventureworks.userdefined.FirstName;
import anorm.Column;
import anorm.RowParser;
import anorm.Success;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import play.api.libs.json.Writes;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** Table: person.person
  * Human beings involved with AdventureWorks: employees, customer contacts, and vendor contacts.
  * Primary key: businessentityid
  */
case class PersonRow(
  /** Primary key for Person records.
    * Points to [[adventureworks.person.businessentity.BusinessentityRow.businessentityid]]
    */
  businessentityid: BusinessentityId,
  /** Primary type of person: SC = Store Contact, IN = Individual (retail) customer, SP = Sales person, EM = Employee (non-sales), VC = Vendor contact, GC = General contact
    * Constraint CK_Person_PersonType affecting columns persontype: (((persontype IS NULL) OR (upper((persontype)::text) = ANY (ARRAY['SC'::text, 'VC'::text, 'IN'::text, 'EM'::text, 'SP'::text, 'GC'::text]))))
    */
  persontype: /* bpchar, max 2 chars */ String,
  /** 0 = The data in FirstName and LastName are stored in western style (first name, last name) order.  1 = Eastern style (last name, first name) order.
    * Default: false
    */
  namestyle: NameStyle,
  /** A courtesy title. For example, Mr. or Ms. */
  title: Option[/* max 8 chars */ String],
  /** First name of the person. */
  firstname: /* user-picked */ FirstName,
  /** Middle name or middle initial of the person. */
  middlename: Option[Name],
  /** Last name of the person. */
  lastname: Name,
  /** Surname suffix. For example, Sr. or Jr. */
  suffix: Option[/* max 10 chars */ String],
  /** 0 = Contact does not wish to receive e-mail promotions, 1 = Contact does wish to receive e-mail promotions from AdventureWorks, 2 = Contact does wish to receive e-mail promotions from AdventureWorks and selected partners.
    * Default: 0
    * Constraint CK_Person_EmailPromotion affecting columns emailpromotion: (((emailpromotion >= 0) AND (emailpromotion <= 2)))
    */
  emailpromotion: Int,
  /** Additional contact information about the person stored in xml format. */
  additionalcontactinfo: Option[TypoXml],
  /** Personal information such as hobbies, and income collected from online shoppers. Used for sales analysis. */
  demographics: Option[TypoXml],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
) {
  def id: BusinessentityId = businessentityid
  def toUnsavedRow(
    namestyle: Defaulted[NameStyle] = Defaulted.Provided(this.namestyle),
    emailpromotion: Defaulted[Int] = Defaulted.Provided(this.emailpromotion),
    rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid),
    modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)
  ): PersonRowUnsaved = {
    new PersonRowUnsaved(
      businessentityid,
      persontype,
      title,
      firstname,
      middlename,
      lastname,
      suffix,
      additionalcontactinfo,
      demographics,
      namestyle,
      emailpromotion,
      rowguid,
      modifieddate
    )
  }
}

object PersonRow {
  implicit lazy val reads: Reads[PersonRow] = {
    Reads[PersonRow](json => JsResult.fromTry(
        Try(
          PersonRow(
            businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
            persontype = json.\("persontype").as(Reads.StringReads),
            namestyle = json.\("namestyle").as(NameStyle.reads),
            title = json.\("title").toOption.map(_.as(Reads.StringReads)),
            firstname = json.\("firstname").as(FirstName.reads),
            middlename = json.\("middlename").toOption.map(_.as(Name.reads)),
            lastname = json.\("lastname").as(Name.reads),
            suffix = json.\("suffix").toOption.map(_.as(Reads.StringReads)),
            emailpromotion = json.\("emailpromotion").as(Reads.IntReads),
            additionalcontactinfo = json.\("additionalcontactinfo").toOption.map(_.as(TypoXml.reads)),
            demographics = json.\("demographics").toOption.map(_.as(TypoXml.reads)),
            rowguid = json.\("rowguid").as(TypoUUID.reads),
            modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
          )
        )
      ),
    )
  }
  def rowParser(idx: Int): RowParser[PersonRow] = {
    RowParser[PersonRow] { row =>
      Success(
        PersonRow(
          businessentityid = row(idx + 0)(BusinessentityId.column),
          persontype = row(idx + 1)(Column.columnToString),
          namestyle = row(idx + 2)(NameStyle.column),
          title = row(idx + 3)(Column.columnToOption(Column.columnToString)),
          firstname = row(idx + 4)(/* user-picked */ FirstName.column),
          middlename = row(idx + 5)(Column.columnToOption(Name.column)),
          lastname = row(idx + 6)(Name.column),
          suffix = row(idx + 7)(Column.columnToOption(Column.columnToString)),
          emailpromotion = row(idx + 8)(Column.columnToInt),
          additionalcontactinfo = row(idx + 9)(Column.columnToOption(TypoXml.column)),
          demographics = row(idx + 10)(Column.columnToOption(TypoXml.column)),
          rowguid = row(idx + 11)(TypoUUID.column),
          modifieddate = row(idx + 12)(TypoLocalDateTime.column)
        )
      )
    }
  }
  implicit lazy val text: Text[PersonRow] = {
    Text.instance[PersonRow]{ (row, sb) =>
      BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.persontype, sb)
      sb.append(Text.DELIMETER)
      NameStyle.text.unsafeEncode(row.namestyle, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.title, sb)
      sb.append(Text.DELIMETER)
      /* user-picked */ FirstName.text.unsafeEncode(row.firstname, sb)
      sb.append(Text.DELIMETER)
      Text.option(Name.text).unsafeEncode(row.middlename, sb)
      sb.append(Text.DELIMETER)
      Name.text.unsafeEncode(row.lastname, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.suffix, sb)
      sb.append(Text.DELIMETER)
      Text.intInstance.unsafeEncode(row.emailpromotion, sb)
      sb.append(Text.DELIMETER)
      Text.option(TypoXml.text).unsafeEncode(row.additionalcontactinfo, sb)
      sb.append(Text.DELIMETER)
      Text.option(TypoXml.text).unsafeEncode(row.demographics, sb)
      sb.append(Text.DELIMETER)
      TypoUUID.text.unsafeEncode(row.rowguid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    }
  }
  implicit lazy val writes: OWrites[PersonRow] = {
    OWrites[PersonRow](o =>
      new JsObject(ListMap[String, JsValue](
        "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
        "persontype" -> Writes.StringWrites.writes(o.persontype),
        "namestyle" -> NameStyle.writes.writes(o.namestyle),
        "title" -> Writes.OptionWrites(Writes.StringWrites).writes(o.title),
        "firstname" -> FirstName.writes.writes(o.firstname),
        "middlename" -> Writes.OptionWrites(Name.writes).writes(o.middlename),
        "lastname" -> Name.writes.writes(o.lastname),
        "suffix" -> Writes.OptionWrites(Writes.StringWrites).writes(o.suffix),
        "emailpromotion" -> Writes.IntWrites.writes(o.emailpromotion),
        "additionalcontactinfo" -> Writes.OptionWrites(TypoXml.writes).writes(o.additionalcontactinfo),
        "demographics" -> Writes.OptionWrites(TypoXml.writes).writes(o.demographics),
        "rowguid" -> TypoUUID.writes.writes(o.rowguid),
        "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
      ))
    )
  }
}