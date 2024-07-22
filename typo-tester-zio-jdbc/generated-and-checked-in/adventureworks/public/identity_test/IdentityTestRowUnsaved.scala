/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public.identity_test

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `public.identity-test` which has not been persisted yet */
case class IdentityTestRowUnsaved(
  name: IdentityTestId,
  /** Identity BY DEFAULT, identityStart: 1, identityIncrement: 1, identityMaximum: 2147483647, identityMinimum: 1 */
  defaultGenerated: Defaulted[Int]
) {
  def toRow(defaultGeneratedDefault: => Int, alwaysGeneratedDefault: => Int): IdentityTestRow =
    IdentityTestRow(
      name = name,
      defaultGenerated = defaultGenerated match {
                           case Defaulted.UseDefault => defaultGeneratedDefault
                           case Defaulted.Provided(value) => value
                         },
      alwaysGenerated = alwaysGeneratedDefault
    )
}
object IdentityTestRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[IdentityTestRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(IdentityTestId.jsonDecoder))
    val defaultGenerated = jsonObj.get("default_generated").toRight("Missing field 'default_generated'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.int)))
    if (name.isRight && defaultGenerated.isRight)
      Right(IdentityTestRowUnsaved(name = name.toOption.get, defaultGenerated = defaultGenerated.toOption.get))
    else Left(List[Either[String, Any]](name, defaultGenerated).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[IdentityTestRowUnsaved] = new JsonEncoder[IdentityTestRowUnsaved] {
    override def unsafeEncode(a: IdentityTestRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""name":""")
      IdentityTestId.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""default_generated":""")
      Defaulted.jsonEncoder(JsonEncoder.int).unsafeEncode(a.defaultGenerated, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[IdentityTestRowUnsaved] = Text.instance[IdentityTestRowUnsaved]{ (row, sb) =>
    IdentityTestId.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.intInstance).unsafeEncode(row.defaultGenerated, sb)
  }
}
