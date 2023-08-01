/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_class

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_class` */
case class PgClassId(value: /* oid */ Long) extends AnyVal
object PgClassId {
  implicit val arrayGet: Get[Array[PgClassId]] = adventureworks.LongArrayMeta.get.map(_.map(PgClassId.apply))
  implicit val arrayPut: Put[Array[PgClassId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[PgClassId, /* oid */ Long] = Bijection[PgClassId, /* oid */ Long](_.value)(PgClassId.apply)
  implicit val decoder: Decoder[PgClassId] = Decoder.decodeLong.map(PgClassId.apply)
  implicit val encoder: Encoder[PgClassId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgClassId] = Meta.LongMeta.get.map(PgClassId.apply)
  implicit val ordering: Ordering[PgClassId] = Ordering.by(_.value)
  implicit val put: Put[PgClassId] = Meta.LongMeta.put.contramap(_.value)
}
