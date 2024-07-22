/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.vemployeedepartment

import adventureworks.customtypes.TypoLocalDate
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.userdefined.FirstName
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** View: humanresources.vemployeedepartment */
case class VemployeedepartmentViewRow(
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
  /** Points to [[adventureworks.humanresources.department.DepartmentRow.name]] */
  department: Name,
  /** Points to [[adventureworks.humanresources.department.DepartmentRow.groupname]] */
  groupname: Name,
  /** Points to [[adventureworks.humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.startdate]] */
  startdate: TypoLocalDate
)

object VemployeedepartmentViewRow {
  implicit lazy val decoder: Decoder[VemployeedepartmentViewRow] = Decoder.forProduct10[VemployeedepartmentViewRow, BusinessentityId, Option[/* max 8 chars */ String], /* user-picked */ FirstName, Option[Name], Name, Option[/* max 10 chars */ String], /* max 50 chars */ String, Name, Name, TypoLocalDate]("businessentityid", "title", "firstname", "middlename", "lastname", "suffix", "jobtitle", "department", "groupname", "startdate")(VemployeedepartmentViewRow.apply)(BusinessentityId.decoder, Decoder.decodeOption(Decoder.decodeString), FirstName.decoder, Decoder.decodeOption(Name.decoder), Name.decoder, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, Name.decoder, Name.decoder, TypoLocalDate.decoder)
  implicit lazy val encoder: Encoder[VemployeedepartmentViewRow] = Encoder.forProduct10[VemployeedepartmentViewRow, BusinessentityId, Option[/* max 8 chars */ String], /* user-picked */ FirstName, Option[Name], Name, Option[/* max 10 chars */ String], /* max 50 chars */ String, Name, Name, TypoLocalDate]("businessentityid", "title", "firstname", "middlename", "lastname", "suffix", "jobtitle", "department", "groupname", "startdate")(x => (x.businessentityid, x.title, x.firstname, x.middlename, x.lastname, x.suffix, x.jobtitle, x.department, x.groupname, x.startdate))(BusinessentityId.encoder, Encoder.encodeOption(Encoder.encodeString), FirstName.encoder, Encoder.encodeOption(Name.encoder), Name.encoder, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, Name.encoder, Name.encoder, TypoLocalDate.encoder)
  implicit lazy val read: Read[VemployeedepartmentViewRow] = new Read[VemployeedepartmentViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (/* user-picked */ FirstName.get, Nullability.NoNulls),
      (Name.get, Nullability.Nullable),
      (Name.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalDate.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VemployeedepartmentViewRow(
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      title = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      firstname = /* user-picked */ FirstName.get.unsafeGetNonNullable(rs, i + 2),
      middlename = Name.get.unsafeGetNullable(rs, i + 3),
      lastname = Name.get.unsafeGetNonNullable(rs, i + 4),
      suffix = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      jobtitle = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 6),
      department = Name.get.unsafeGetNonNullable(rs, i + 7),
      groupname = Name.get.unsafeGetNonNullable(rs, i + 8),
      startdate = TypoLocalDate.get.unsafeGetNonNullable(rs, i + 9)
    )
  )
}
