/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public.flaff

import adventureworks.public.ShortText
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Type for the composite primary key of table `public.flaff` */
case class FlaffId(
  code: ShortText,
  anotherCode: /* max 20 chars */ String,
  someNumber: Int,
  specifier: ShortText
)
object FlaffId {
  implicit lazy val jsonDecoder: JsonDecoder[FlaffId] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val code = jsonObj.get("code").toRight("Missing field 'code'").flatMap(_.as(ShortText.jsonDecoder))
    val anotherCode = jsonObj.get("another_code").toRight("Missing field 'another_code'").flatMap(_.as(JsonDecoder.string))
    val someNumber = jsonObj.get("some_number").toRight("Missing field 'some_number'").flatMap(_.as(JsonDecoder.int))
    val specifier = jsonObj.get("specifier").toRight("Missing field 'specifier'").flatMap(_.as(ShortText.jsonDecoder))
    if (code.isRight && anotherCode.isRight && someNumber.isRight && specifier.isRight)
      Right(FlaffId(code = code.toOption.get, anotherCode = anotherCode.toOption.get, someNumber = someNumber.toOption.get, specifier = specifier.toOption.get))
    else Left(List[Either[String, Any]](code, anotherCode, someNumber, specifier).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[FlaffId] = new JsonEncoder[FlaffId] {
    override def unsafeEncode(a: FlaffId, indent: Option[Int], out: Write): Unit = {
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
      out.write("}")
    }
  }
}
