/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded.compositepk.person;

import zio.json.JsonDecoder;
import zio.json.JsonEncoder;
import zio.json.ast.Json;
import zio.json.internal.Write;

/** Type for the composite primary key of table `compositepk.person` */
case class PersonId(one: Long, two: Option[String])

object PersonId {
  implicit lazy val jsonDecoder: JsonDecoder[PersonId] = {
    JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
      val one = jsonObj.get("one").toRight("Missing field 'one'").flatMap(_.as(JsonDecoder.long))
      val two = jsonObj.get("two").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
      if (one.isRight && two.isRight)
        Right(PersonId(one = one.toOption.get, two = two.toOption.get))
      else Left(List[Either[String, Any]](one, two).flatMap(_.left.toOption).mkString(", "))
    }
  }
  implicit lazy val jsonEncoder: JsonEncoder[PersonId] = {
    new JsonEncoder[PersonId] {
      override def unsafeEncode(a: PersonId, indent: Option[Int], out: Write): Unit = {
        out.write("{")
        out.write(""""one":""")
        JsonEncoder.long.unsafeEncode(a.one, indent, out)
        out.write(",")
        out.write(""""two":""")
        JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.two, indent, out)
        out.write("}")
      }
    }
  }
}