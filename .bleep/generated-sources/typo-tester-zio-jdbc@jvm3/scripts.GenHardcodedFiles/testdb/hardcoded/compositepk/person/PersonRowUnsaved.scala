/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded.compositepk.person

import testdb.hardcoded.Text
import testdb.hardcoded.customtypes.Defaulted
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `compositepk.person` which has not been persisted yet */
case class PersonRowUnsaved(
  name: Option[String],
  /** Default: auto-increment */
  one: Defaulted[Long] = Defaulted.UseDefault,
  /** Default: auto-increment */
  two: Defaulted[Option[String]] = Defaulted.UseDefault
) {
  def toRow(oneDefault: => Long, twoDefault: => Option[String]): PersonRow =
    PersonRow(
      one = one match {
              case Defaulted.UseDefault => oneDefault
              case Defaulted.Provided(value) => value
            },
      two = two match {
              case Defaulted.UseDefault => twoDefault
              case Defaulted.Provided(value) => value
            },
      name = name
    )
}
object PersonRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[PersonRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val name = jsonObj.get("name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val one = jsonObj.get("one").toRight("Missing field 'one'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.long)))
    val two = jsonObj.get("two").toRight("Missing field 'two'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.option(using JsonDecoder.string))))
    if (name.isRight && one.isRight && two.isRight)
      Right(PersonRowUnsaved(name = name.toOption.get, one = one.toOption.get, two = two.toOption.get))
    else Left(List[Either[String, Any]](name, one, two).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PersonRowUnsaved] = new JsonEncoder[PersonRowUnsaved] {
    override def unsafeEncode(a: PersonRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""name":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""one":""")
      Defaulted.jsonEncoder(JsonEncoder.long).unsafeEncode(a.one, indent, out)
      out.write(",")
      out.write(""""two":""")
      Defaulted.jsonEncoder(JsonEncoder.option(using JsonEncoder.string)).unsafeEncode(a.two, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[PersonRowUnsaved] = Text.instance[PersonRowUnsaved]{ (row, sb) =>
    Text.option(Text.stringInstance).unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.longInstance).unsafeEncode(row.one, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.option(Text.stringInstance)).unsafeEncode(row.two, sb)
  }
}
