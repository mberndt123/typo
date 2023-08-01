/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_transform

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_transform` */
case class PgTransformId(value: /* oid */ Long) extends AnyVal
object PgTransformId {
  implicit val arrayGet: Get[Array[PgTransformId]] = adventureworks.LongArrayMeta.get.map(_.map(PgTransformId.apply))
  implicit val arrayPut: Put[Array[PgTransformId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[PgTransformId, /* oid */ Long] = Bijection[PgTransformId, /* oid */ Long](_.value)(PgTransformId.apply)
  implicit val decoder: Decoder[PgTransformId] = Decoder.decodeLong.map(PgTransformId.apply)
  implicit val encoder: Encoder[PgTransformId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgTransformId] = Meta.LongMeta.get.map(PgTransformId.apply)
  implicit val ordering: Ordering[PgTransformId] = Ordering.by(_.value)
  implicit val put: Put[PgTransformId] = Meta.LongMeta.put.contramap(_.value)
}
