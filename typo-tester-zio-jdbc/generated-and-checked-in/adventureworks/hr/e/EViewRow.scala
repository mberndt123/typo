/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.hr.e

import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** View: hr.e */
case class EViewRow(
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.nationalidnumber]] */
  nationalidnumber: /* max 15 chars */ String,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.loginid]] */
  loginid: /* max 256 chars */ String,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.jobtitle]] */
  jobtitle: /* max 50 chars */ String,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.birthdate]] */
  birthdate: TypoLocalDate,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.maritalstatus]] */
  maritalstatus: /* bpchar, max 1 chars */ String,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.gender]] */
  gender: /* bpchar, max 1 chars */ String,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.hiredate]] */
  hiredate: TypoLocalDate,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.salariedflag]] */
  salariedflag: Flag,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.vacationhours]] */
  vacationhours: TypoShort,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.sickleavehours]] */
  sickleavehours: TypoShort,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.currentflag]] */
  currentflag: Flag,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.modifieddate]] */
  modifieddate: TypoLocalDateTime,
  /** Points to [[adventureworks.humanresources.employee.EmployeeRow.organizationnode]] */
  organizationnode: Option[String]
)

object EViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[EViewRow] = new JdbcDecoder[EViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, EViewRow) =
      columIndex + 15 ->
        EViewRow(
          id = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          nationalidnumber = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2,
          loginid = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 3, rs)._2,
          jobtitle = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 4, rs)._2,
          birthdate = TypoLocalDate.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
          maritalstatus = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 6, rs)._2,
          gender = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 7, rs)._2,
          hiredate = TypoLocalDate.jdbcDecoder.unsafeDecode(columIndex + 8, rs)._2,
          salariedflag = Flag.jdbcDecoder.unsafeDecode(columIndex + 9, rs)._2,
          vacationhours = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 10, rs)._2,
          sickleavehours = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 11, rs)._2,
          currentflag = Flag.jdbcDecoder.unsafeDecode(columIndex + 12, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 13, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 14, rs)._2,
          organizationnode = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 15, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[EViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val nationalidnumber = jsonObj.get("nationalidnumber").toRight("Missing field 'nationalidnumber'").flatMap(_.as(JsonDecoder.string))
    val loginid = jsonObj.get("loginid").toRight("Missing field 'loginid'").flatMap(_.as(JsonDecoder.string))
    val jobtitle = jsonObj.get("jobtitle").toRight("Missing field 'jobtitle'").flatMap(_.as(JsonDecoder.string))
    val birthdate = jsonObj.get("birthdate").toRight("Missing field 'birthdate'").flatMap(_.as(TypoLocalDate.jsonDecoder))
    val maritalstatus = jsonObj.get("maritalstatus").toRight("Missing field 'maritalstatus'").flatMap(_.as(JsonDecoder.string))
    val gender = jsonObj.get("gender").toRight("Missing field 'gender'").flatMap(_.as(JsonDecoder.string))
    val hiredate = jsonObj.get("hiredate").toRight("Missing field 'hiredate'").flatMap(_.as(TypoLocalDate.jsonDecoder))
    val salariedflag = jsonObj.get("salariedflag").toRight("Missing field 'salariedflag'").flatMap(_.as(Flag.jsonDecoder))
    val vacationhours = jsonObj.get("vacationhours").toRight("Missing field 'vacationhours'").flatMap(_.as(TypoShort.jsonDecoder))
    val sickleavehours = jsonObj.get("sickleavehours").toRight("Missing field 'sickleavehours'").flatMap(_.as(TypoShort.jsonDecoder))
    val currentflag = jsonObj.get("currentflag").toRight("Missing field 'currentflag'").flatMap(_.as(Flag.jsonDecoder))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val organizationnode = jsonObj.get("organizationnode").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    if (id.isRight && businessentityid.isRight && nationalidnumber.isRight && loginid.isRight && jobtitle.isRight && birthdate.isRight && maritalstatus.isRight && gender.isRight && hiredate.isRight && salariedflag.isRight && vacationhours.isRight && sickleavehours.isRight && currentflag.isRight && rowguid.isRight && modifieddate.isRight && organizationnode.isRight)
      Right(EViewRow(id = id.toOption.get, businessentityid = businessentityid.toOption.get, nationalidnumber = nationalidnumber.toOption.get, loginid = loginid.toOption.get, jobtitle = jobtitle.toOption.get, birthdate = birthdate.toOption.get, maritalstatus = maritalstatus.toOption.get, gender = gender.toOption.get, hiredate = hiredate.toOption.get, salariedflag = salariedflag.toOption.get, vacationhours = vacationhours.toOption.get, sickleavehours = sickleavehours.toOption.get, currentflag = currentflag.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get, organizationnode = organizationnode.toOption.get))
    else Left(List[Either[String, Any]](id, businessentityid, nationalidnumber, loginid, jobtitle, birthdate, maritalstatus, gender, hiredate, salariedflag, vacationhours, sickleavehours, currentflag, rowguid, modifieddate, organizationnode).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[EViewRow] = new JsonEncoder[EViewRow] {
    override def unsafeEncode(a: EViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""nationalidnumber":""")
      JsonEncoder.string.unsafeEncode(a.nationalidnumber, indent, out)
      out.write(",")
      out.write(""""loginid":""")
      JsonEncoder.string.unsafeEncode(a.loginid, indent, out)
      out.write(",")
      out.write(""""jobtitle":""")
      JsonEncoder.string.unsafeEncode(a.jobtitle, indent, out)
      out.write(",")
      out.write(""""birthdate":""")
      TypoLocalDate.jsonEncoder.unsafeEncode(a.birthdate, indent, out)
      out.write(",")
      out.write(""""maritalstatus":""")
      JsonEncoder.string.unsafeEncode(a.maritalstatus, indent, out)
      out.write(",")
      out.write(""""gender":""")
      JsonEncoder.string.unsafeEncode(a.gender, indent, out)
      out.write(",")
      out.write(""""hiredate":""")
      TypoLocalDate.jsonEncoder.unsafeEncode(a.hiredate, indent, out)
      out.write(",")
      out.write(""""salariedflag":""")
      Flag.jsonEncoder.unsafeEncode(a.salariedflag, indent, out)
      out.write(",")
      out.write(""""vacationhours":""")
      TypoShort.jsonEncoder.unsafeEncode(a.vacationhours, indent, out)
      out.write(",")
      out.write(""""sickleavehours":""")
      TypoShort.jsonEncoder.unsafeEncode(a.sickleavehours, indent, out)
      out.write(",")
      out.write(""""currentflag":""")
      Flag.jsonEncoder.unsafeEncode(a.currentflag, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write(",")
      out.write(""""organizationnode":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.organizationnode, indent, out)
      out.write("}")
    }
  }
}
