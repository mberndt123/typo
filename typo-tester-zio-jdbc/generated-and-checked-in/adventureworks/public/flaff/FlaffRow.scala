/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package flaff

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: public.flaff
    Composite primary key: code, another_code, some_number, specifier */
case class FlaffRow(
  /** Points to [[FlaffRow.code]] */
  code: ShortText,
  /** Points to [[FlaffRow.anotherCode]] */
  anotherCode: /* max 20 chars */ String,
  /** Points to [[FlaffRow.someNumber]] */
  someNumber: Int,
  specifier: ShortText,
  /** Points to [[FlaffRow.specifier]] */
  parentspecifier: Option[ShortText]
){
   val compositeId: FlaffId = FlaffId(code, anotherCode, someNumber, specifier)
 }

object FlaffRow {
  def apply(compositeId: FlaffId, parentspecifier: Option[ShortText]) =
    new FlaffRow(compositeId.code, compositeId.anotherCode, compositeId.someNumber, compositeId.specifier, parentspecifier)
  implicit lazy val jdbcDecoder: JdbcDecoder[FlaffRow] = new JdbcDecoder[FlaffRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, FlaffRow) =
      columIndex + 4 ->
        FlaffRow(
          code = ShortText.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          anotherCode = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          someNumber = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 2, rs)._2,
          specifier = ShortText.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          parentspecifier = JdbcDecoder.optionDecoder(ShortText.jdbcDecoder).unsafeDecode(columIndex + 4, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[FlaffRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val code = jsonObj.get("code").toRight("Missing field 'code'").flatMap(_.as(ShortText.jsonDecoder))
    val anotherCode = jsonObj.get("another_code").toRight("Missing field 'another_code'").flatMap(_.as(JsonDecoder.string))
    val someNumber = jsonObj.get("some_number").toRight("Missing field 'some_number'").flatMap(_.as(JsonDecoder.int))
    val specifier = jsonObj.get("specifier").toRight("Missing field 'specifier'").flatMap(_.as(ShortText.jsonDecoder))
    val parentspecifier = jsonObj.get("parentspecifier").fold[Either[String, Option[ShortText]]](Right(None))(_.as(JsonDecoder.option(using ShortText.jsonDecoder)))
    if (code.isRight && anotherCode.isRight && someNumber.isRight && specifier.isRight && parentspecifier.isRight)
      Right(FlaffRow(code = code.toOption.get, anotherCode = anotherCode.toOption.get, someNumber = someNumber.toOption.get, specifier = specifier.toOption.get, parentspecifier = parentspecifier.toOption.get))
    else Left(List[Either[String, Any]](code, anotherCode, someNumber, specifier, parentspecifier).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[FlaffRow] = new JsonEncoder[FlaffRow] {
    override def unsafeEncode(a: FlaffRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""code":""")
      ShortText.jsonEncoder.unsafeEncode(a.code, indent, out)
      out.write(",")
      out.write(""""another_code":""")
      JsonEncoder.string.unsafeEncode(a.anotherCode, indent, out)
      out.write(",")
      out.write(""""some_number":""")
      JsonEncoder.int.unsafeEncode(a.someNumber, indent, out)
      out.write(",")
      out.write(""""specifier":""")
      ShortText.jsonEncoder.unsafeEncode(a.specifier, indent, out)
      out.write(",")
      out.write(""""parentspecifier":""")
      JsonEncoder.option(using ShortText.jsonEncoder).unsafeEncode(a.parentspecifier, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[FlaffRow] = Text.instance[FlaffRow]{ (row, sb) =>
    ShortText.text.unsafeEncode(row.code, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.anotherCode, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.someNumber, sb)
    sb.append(Text.DELIMETER)
    ShortText.text.unsafeEncode(row.specifier, sb)
    sb.append(Text.DELIMETER)
    Text.option(ShortText.text).unsafeEncode(row.parentspecifier, sb)
  }
}
