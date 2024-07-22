/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.pa

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** View: pe.pa */
case class PaViewRow(
  /** Points to [[adventureworks.person.password.PasswordRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[adventureworks.person.password.PasswordRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[adventureworks.person.password.PasswordRow.passwordhash]] */
  passwordhash: /* max 128 chars */ String,
  /** Points to [[adventureworks.person.password.PasswordRow.passwordsalt]] */
  passwordsalt: /* max 10 chars */ String,
  /** Points to [[adventureworks.person.password.PasswordRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[adventureworks.person.password.PasswordRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PaViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PaViewRow] = new JdbcDecoder[PaViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PaViewRow) =
      columIndex + 5 ->
        PaViewRow(
          id = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          passwordhash = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2,
          passwordsalt = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 3, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PaViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val passwordhash = jsonObj.get("passwordhash").toRight("Missing field 'passwordhash'").flatMap(_.as(JsonDecoder.string))
    val passwordsalt = jsonObj.get("passwordsalt").toRight("Missing field 'passwordsalt'").flatMap(_.as(JsonDecoder.string))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && businessentityid.isRight && passwordhash.isRight && passwordsalt.isRight && rowguid.isRight && modifieddate.isRight)
      Right(PaViewRow(id = id.toOption.get, businessentityid = businessentityid.toOption.get, passwordhash = passwordhash.toOption.get, passwordsalt = passwordsalt.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, businessentityid, passwordhash, passwordsalt, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PaViewRow] = new JsonEncoder[PaViewRow] {
    override def unsafeEncode(a: PaViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""passwordhash":""")
      JsonEncoder.string.unsafeEncode(a.passwordhash, indent, out)
      out.write(",")
      out.write(""""passwordsalt":""")
      JsonEncoder.string.unsafeEncode(a.passwordsalt, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
