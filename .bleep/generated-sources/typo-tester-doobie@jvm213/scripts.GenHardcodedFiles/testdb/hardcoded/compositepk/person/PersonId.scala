/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded.compositepk.person

import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `compositepk.person` */
case class PersonId(
  one: Long,
  two: Option[String]
)
object PersonId {
  implicit lazy val decoder: Decoder[PersonId] = Decoder.forProduct2[PersonId, Long, Option[String]]("one", "two")(PersonId.apply)(Decoder.decodeLong, Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[PersonId] = Encoder.forProduct2[PersonId, Long, Option[String]]("one", "two")(x => (x.one, x.two))(Encoder.encodeLong, Encoder.encodeOption(Encoder.encodeString))
  implicit def ordering(implicit O0: Ordering[Option[String]]): Ordering[PersonId] = Ordering.by(x => (x.one, x.two))
}
