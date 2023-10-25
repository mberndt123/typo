/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import cats.data.NonEmptyList
import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
import org.postgresql.jdbc.PgSQLXML
import org.postgresql.util.PGobject
import typo.dsl.Bijection

/** XML */
case class TypoXml(value: String)

object TypoXml {
  implicit lazy val arrayGet: Get[Array[TypoXml]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_xml"))
    .map(_.map(v => TypoXml(v.asInstanceOf[PGobject].getValue)))
  implicit lazy val arrayPut: Put[Array[TypoXml]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_xml"), "xml")
    .contramap(_.map(v => {
                            val obj = new PGobject
                            obj.setType("xml")
                            obj.setValue(v.value)
                            obj
                          }))
  implicit lazy val bijection: Bijection[TypoXml, String] = Bijection[TypoXml, String](_.value)(TypoXml.apply)
  implicit lazy val decoder: Decoder[TypoXml] = Decoder.decodeString.map(TypoXml.apply)
  implicit lazy val encoder: Encoder[TypoXml] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[TypoXml] = Get.Advanced.other[PgSQLXML](NonEmptyList.one("xml"))
    .map(v => TypoXml(v.getString))
  implicit lazy val ordering: Ordering[TypoXml] = Ordering.by(_.value)
  implicit lazy val put: Put[TypoXml] = Put.Advanced.other[String](NonEmptyList.one("xml")).contramap(v => v.value)
  implicit lazy val text: Text[TypoXml] = new Text[TypoXml] {
    override def unsafeEncode(v: TypoXml, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.toString, sb)
    override def unsafeArrayEncode(v: TypoXml, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.toString, sb)
  }
}
