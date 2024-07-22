/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.customtypes

import cats.data.NonEmptyList
import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
import java.util.HashMap
import typo.dsl.Bijection

/** The text representation of an hstore, used for input and output, includes zero or more key => value pairs separated by commas */
case class TypoHStore(value: Map[String, String])

object TypoHStore {
  implicit lazy val bijection: Bijection[TypoHStore, Map[String, String]] = Bijection[TypoHStore, Map[String, String]](_.value)(TypoHStore.apply)
  implicit lazy val decoder: Decoder[TypoHStore] = Decoder[Map[String, String]].map(TypoHStore.apply)
  implicit lazy val encoder: Encoder[TypoHStore] = Encoder[Map[String, String]].contramap(_.value)
  implicit lazy val get: Get[TypoHStore] = Get.Advanced.other[java.util.Map[?, ?]](NonEmptyList.one("hstore"))
    .map(v => {
                val b = Map.newBuilder[String, String]
                v.forEach { case (k, v) => b += k.asInstanceOf[String] -> v.asInstanceOf[String]}
                TypoHStore(b.result())
              })
  implicit def ordering(implicit O0: Ordering[Map[String, String]]): Ordering[TypoHStore] = Ordering.by(_.value)
  implicit lazy val put: Put[TypoHStore] = Put.Advanced.other[java.util.Map[String, String]](NonEmptyList.one("hstore")).contramap(v => {
                                                                                                 val b = new HashMap[String, String]
                                                                                                 v.value.foreach { case (k, v) => b.put(k, v)}
                                                                                                 b
                                                                                               })
  implicit lazy val text: Text[TypoHStore] = new Text[TypoHStore] {
    override def unsafeEncode(v: TypoHStore, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.map { case (k, v) => s"$k => $v" }.mkString(","), sb)
    override def unsafeArrayEncode(v: TypoHStore, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.map { case (k, v) => s"$k => $v" }.mkString(","), sb)
  }
}
