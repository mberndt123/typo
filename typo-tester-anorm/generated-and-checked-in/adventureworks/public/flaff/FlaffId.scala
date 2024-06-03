/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package flaff

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `public.flaff` */
case class FlaffId(code: ShortText, anotherCode: /* max 20 chars */ String, someNumber: Int, specifier: ShortText)
object FlaffId {
  implicit lazy val ordering: Ordering[FlaffId] = Ordering.by(x => (x.code, x.anotherCode, x.someNumber, x.specifier))
  implicit lazy val reads: Reads[FlaffId] = Reads[FlaffId](json => JsResult.fromTry(
      Try(
        FlaffId(
          code = json.\("code").as(ShortText.reads),
          anotherCode = json.\("another_code").as(Reads.StringReads),
          someNumber = json.\("some_number").as(Reads.IntReads),
          specifier = json.\("specifier").as(ShortText.reads)
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[FlaffId] = OWrites[FlaffId](o =>
    new JsObject(ListMap[String, JsValue](
      "code" -> ShortText.writes.writes(o.code),
      "another_code" -> Writes.StringWrites.writes(o.anotherCode),
      "some_number" -> Writes.IntWrites.writes(o.someNumber),
      "specifier" -> ShortText.writes.writes(o.specifier)
    ))
  )
}
