/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.shift

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoLocalTime
import adventureworks.public.Name
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: humanresources.shift
    Work shift lookup table.
    Primary key: shiftid */
case class ShiftRow(
  /** Primary key for Shift records.
      Default: nextval('humanresources.shift_shiftid_seq'::regclass) */
  shiftid: ShiftId,
  /** Shift description. */
  name: Name,
  /** Shift start time. */
  starttime: TypoLocalTime,
  /** Shift end time. */
  endtime: TypoLocalTime,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = shiftid
   def toUnsavedRow(shiftid: Defaulted[ShiftId], modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ShiftRowUnsaved =
     ShiftRowUnsaved(name, starttime, endtime, shiftid, modifieddate)
 }

object ShiftRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[ShiftRow] = new JdbcDecoder[ShiftRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ShiftRow) =
      columIndex + 4 ->
        ShiftRow(
          shiftid = ShiftId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          starttime = TypoLocalTime.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          endtime = TypoLocalTime.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ShiftRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val shiftid = jsonObj.get("shiftid").toRight("Missing field 'shiftid'").flatMap(_.as(ShiftId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val starttime = jsonObj.get("starttime").toRight("Missing field 'starttime'").flatMap(_.as(TypoLocalTime.jsonDecoder))
    val endtime = jsonObj.get("endtime").toRight("Missing field 'endtime'").flatMap(_.as(TypoLocalTime.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (shiftid.isRight && name.isRight && starttime.isRight && endtime.isRight && modifieddate.isRight)
      Right(ShiftRow(shiftid = shiftid.toOption.get, name = name.toOption.get, starttime = starttime.toOption.get, endtime = endtime.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](shiftid, name, starttime, endtime, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ShiftRow] = new JsonEncoder[ShiftRow] {
    override def unsafeEncode(a: ShiftRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""shiftid":""")
      ShiftId.jsonEncoder.unsafeEncode(a.shiftid, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""starttime":""")
      TypoLocalTime.jsonEncoder.unsafeEncode(a.starttime, indent, out)
      out.write(",")
      out.write(""""endtime":""")
      TypoLocalTime.jsonEncoder.unsafeEncode(a.endtime, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ShiftRow] = Text.instance[ShiftRow]{ (row, sb) =>
    ShiftId.text.unsafeEncode(row.shiftid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoLocalTime.text.unsafeEncode(row.starttime, sb)
    sb.append(Text.DELIMETER)
    TypoLocalTime.text.unsafeEncode(row.endtime, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
