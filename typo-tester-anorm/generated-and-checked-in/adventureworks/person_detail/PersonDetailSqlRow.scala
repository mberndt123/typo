/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person_detail;

import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.public.Name;
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

/** SQL file: person_detail.sql */
case class PersonDetailSqlRow(
  /** Points to [[adventureworks.sales.salesperson.SalespersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[adventureworks.person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[adventureworks.person.person.PersonRow.firstname]] */
  firstname: /* user-picked */ FirstName,
  /** Points to [[adventureworks.person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[adventureworks.person.person.PersonRow.lastname]] */
  lastname: Name,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.jobtitle]] */
  jobtitle: /* max 50 chars */ String,
  /** Points to [[adventureworks.person.address.AddressRow.addressline1]] */
  addressline1: Option[/* max 60 chars */ String],
  /** Points to [[adventureworks.person.address.AddressRow.city]] */
  city: Option[/* max 30 chars */ String],
  /** Points to [[adventureworks.person.address.AddressRow.postalcode]] */
  postalcode: Option[/* max 15 chars */ String],
  /** Points to [[adventureworks.person.address.AddressRow.rowguid]] */
  rowguid: /* user-picked */ String
)

object PersonDetailSqlRow {
  implicit lazy val reads: Reads[PersonDetailSqlRow] = {
    Reads[PersonDetailSqlRow](json => JsResult.fromTry(
        Try(
          PersonDetailSqlRow(
            businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
            title = json.\("title").toOption.map(_.as(Reads.StringReads)),
            firstname = json.\("firstname").as(FirstName.reads),
            middlename = json.\("middlename").toOption.map(_.as(Name.reads)),
            lastname = json.\("lastname").as(Name.reads),
            jobtitle = json.\("jobtitle").as(Reads.StringReads),
            addressline1 = json.\("addressline1").toOption.map(_.as(Reads.StringReads)),
            city = json.\("city").toOption.map(_.as(Reads.StringReads)),
            postalcode = json.\("postalcode").toOption.map(_.as(Reads.StringReads)),
            rowguid = json.\("rowguid").as(Reads.StringReads)
          )
        )
      ),
    )
  }
  def rowParser(idx: Int): RowParser[PersonDetailSqlRow] = {
    RowParser[PersonDetailSqlRow] { row =>
      Success(
        PersonDetailSqlRow(
          businessentityid = row(idx + 0)(BusinessentityId.column),
          title = row(idx + 1)(Column.columnToOption(Column.columnToString)),
          firstname = row(idx + 2)(/* user-picked */ FirstName.column),
          middlename = row(idx + 3)(Column.columnToOption(Name.column)),
          lastname = row(idx + 4)(Name.column),
          jobtitle = row(idx + 5)(Column.columnToString),
          addressline1 = row(idx + 6)(Column.columnToOption(Column.columnToString)),
          city = row(idx + 7)(Column.columnToOption(Column.columnToString)),
          postalcode = row(idx + 8)(Column.columnToOption(Column.columnToString)),
          rowguid = row(idx + 9)(Column.columnToString)
        )
      )
    }
  }
  implicit lazy val writes: OWrites[PersonDetailSqlRow] = {
    OWrites[PersonDetailSqlRow](o =>
      new JsObject(ListMap[String, JsValue](
        "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
        "title" -> Writes.OptionWrites(Writes.StringWrites).writes(o.title),
        "firstname" -> FirstName.writes.writes(o.firstname),
        "middlename" -> Writes.OptionWrites(Name.writes).writes(o.middlename),
        "lastname" -> Name.writes.writes(o.lastname),
        "jobtitle" -> Writes.StringWrites.writes(o.jobtitle),
        "addressline1" -> Writes.OptionWrites(Writes.StringWrites).writes(o.addressline1),
        "city" -> Writes.OptionWrites(Writes.StringWrites).writes(o.city),
        "postalcode" -> Writes.OptionWrites(Writes.StringWrites).writes(o.postalcode),
        "rowguid" -> Writes.StringWrites.writes(o.rowguid)
      ))
    )
  }
}