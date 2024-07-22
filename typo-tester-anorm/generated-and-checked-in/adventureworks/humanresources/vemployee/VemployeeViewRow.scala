/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.vemployee

import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import adventureworks.userdefined.FirstName
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** View: humanresources.vemployee */
case class VemployeeViewRow(
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[adventureworks.person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[adventureworks.person.person.PersonRow.firstname]] */
  firstname: /* user-picked */ FirstName,
  /** Points to [[adventureworks.person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[adventureworks.person.person.PersonRow.lastname]] */
  lastname: Name,
  /** Points to [[adventureworks.person.person.PersonRow.suffix]] */
  suffix: Option[/* max 10 chars */ String],
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.jobtitle]] */
  jobtitle: /* max 50 chars */ String,
  /** Points to [[adventureworks.person.personphone.PersonphoneRow.phonenumber]] */
  phonenumber: Option[Phone],
  /** Points to [[adventureworks.person.phonenumbertype.PhonenumbertypeRow.name]] */
  phonenumbertype: Option[Name],
  /** Points to [[adventureworks.person.emailaddress.EmailaddressRow.emailaddress]] */
  emailaddress: Option[/* max 50 chars */ String],
  /** Points to [[adventureworks.person.person.PersonRow.emailpromotion]] */
  emailpromotion: Int,
  /** Points to [[adventureworks.person.address.AddressRow.addressline1]] */
  addressline1: /* max 60 chars */ String,
  /** Points to [[adventureworks.person.address.AddressRow.addressline2]] */
  addressline2: Option[/* max 60 chars */ String],
  /** Points to [[adventureworks.person.address.AddressRow.city]] */
  city: /* max 30 chars */ String,
  /** Points to [[adventureworks.person.stateprovince.StateprovinceRow.name]] */
  stateprovincename: Name,
  /** Points to [[adventureworks.person.address.AddressRow.postalcode]] */
  postalcode: /* max 15 chars */ String,
  /** Points to [[adventureworks.person.countryregion.CountryregionRow.name]] */
  countryregionname: Name,
  /** Points to [[adventureworks.person.person.PersonRow.additionalcontactinfo]] */
  additionalcontactinfo: Option[TypoXml]
)

object VemployeeViewRow {
  implicit lazy val reads: Reads[VemployeeViewRow] = Reads[VemployeeViewRow](json => JsResult.fromTry(
      Try(
        VemployeeViewRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          title = json.\("title").toOption.map(_.as(Reads.StringReads)),
          firstname = json.\("firstname").as(FirstName.reads),
          middlename = json.\("middlename").toOption.map(_.as(Name.reads)),
          lastname = json.\("lastname").as(Name.reads),
          suffix = json.\("suffix").toOption.map(_.as(Reads.StringReads)),
          jobtitle = json.\("jobtitle").as(Reads.StringReads),
          phonenumber = json.\("phonenumber").toOption.map(_.as(Phone.reads)),
          phonenumbertype = json.\("phonenumbertype").toOption.map(_.as(Name.reads)),
          emailaddress = json.\("emailaddress").toOption.map(_.as(Reads.StringReads)),
          emailpromotion = json.\("emailpromotion").as(Reads.IntReads),
          addressline1 = json.\("addressline1").as(Reads.StringReads),
          addressline2 = json.\("addressline2").toOption.map(_.as(Reads.StringReads)),
          city = json.\("city").as(Reads.StringReads),
          stateprovincename = json.\("stateprovincename").as(Name.reads),
          postalcode = json.\("postalcode").as(Reads.StringReads),
          countryregionname = json.\("countryregionname").as(Name.reads),
          additionalcontactinfo = json.\("additionalcontactinfo").toOption.map(_.as(TypoXml.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VemployeeViewRow] = RowParser[VemployeeViewRow] { row =>
    Success(
      VemployeeViewRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        title = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        firstname = row(idx + 2)(/* user-picked */ FirstName.column),
        middlename = row(idx + 3)(Column.columnToOption(Name.column)),
        lastname = row(idx + 4)(Name.column),
        suffix = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        jobtitle = row(idx + 6)(Column.columnToString),
        phonenumber = row(idx + 7)(Column.columnToOption(Phone.column)),
        phonenumbertype = row(idx + 8)(Column.columnToOption(Name.column)),
        emailaddress = row(idx + 9)(Column.columnToOption(Column.columnToString)),
        emailpromotion = row(idx + 10)(Column.columnToInt),
        addressline1 = row(idx + 11)(Column.columnToString),
        addressline2 = row(idx + 12)(Column.columnToOption(Column.columnToString)),
        city = row(idx + 13)(Column.columnToString),
        stateprovincename = row(idx + 14)(Name.column),
        postalcode = row(idx + 15)(Column.columnToString),
        countryregionname = row(idx + 16)(Name.column),
        additionalcontactinfo = row(idx + 17)(Column.columnToOption(TypoXml.column))
      )
    )
  }
  implicit lazy val writes: OWrites[VemployeeViewRow] = OWrites[VemployeeViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "title" -> Writes.OptionWrites(Writes.StringWrites).writes(o.title),
      "firstname" -> FirstName.writes.writes(o.firstname),
      "middlename" -> Writes.OptionWrites(Name.writes).writes(o.middlename),
      "lastname" -> Name.writes.writes(o.lastname),
      "suffix" -> Writes.OptionWrites(Writes.StringWrites).writes(o.suffix),
      "jobtitle" -> Writes.StringWrites.writes(o.jobtitle),
      "phonenumber" -> Writes.OptionWrites(Phone.writes).writes(o.phonenumber),
      "phonenumbertype" -> Writes.OptionWrites(Name.writes).writes(o.phonenumbertype),
      "emailaddress" -> Writes.OptionWrites(Writes.StringWrites).writes(o.emailaddress),
      "emailpromotion" -> Writes.IntWrites.writes(o.emailpromotion),
      "addressline1" -> Writes.StringWrites.writes(o.addressline1),
      "addressline2" -> Writes.OptionWrites(Writes.StringWrites).writes(o.addressline2),
      "city" -> Writes.StringWrites.writes(o.city),
      "stateprovincename" -> Name.writes.writes(o.stateprovincename),
      "postalcode" -> Writes.StringWrites.writes(o.postalcode),
      "countryregionname" -> Name.writes.writes(o.countryregionname),
      "additionalcontactinfo" -> Writes.OptionWrites(TypoXml.writes).writes(o.additionalcontactinfo)
    ))
  )
}
