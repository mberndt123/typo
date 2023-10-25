/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PasswordRow(
  /** Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Password for the e-mail account. */
  passwordhash: /* max 128 chars */ String,
  /** Random value concatenated with the password string before the password is hashed. */
  passwordsalt: /* max 10 chars */ String,
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
)

object PasswordRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PasswordRow] = new JdbcDecoder[PasswordRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PasswordRow) =
      columIndex + 4 ->
        PasswordRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          passwordhash = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          passwordsalt = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PasswordRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val passwordhash = jsonObj.get("passwordhash").toRight("Missing field 'passwordhash'").flatMap(_.as(JsonDecoder.string))
    val passwordsalt = jsonObj.get("passwordsalt").toRight("Missing field 'passwordsalt'").flatMap(_.as(JsonDecoder.string))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (businessentityid.isRight && passwordhash.isRight && passwordsalt.isRight && rowguid.isRight && modifieddate.isRight)
      Right(PasswordRow(businessentityid = businessentityid.toOption.get, passwordhash = passwordhash.toOption.get, passwordsalt = passwordsalt.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, passwordhash, passwordsalt, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PasswordRow] = new JsonEncoder[PasswordRow] {
    override def unsafeEncode(a: PasswordRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
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
  implicit lazy val text: Text[PasswordRow] = Text.instance[PasswordRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.passwordhash, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.passwordsalt, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
