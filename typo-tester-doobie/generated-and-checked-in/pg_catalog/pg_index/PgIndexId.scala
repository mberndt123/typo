/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_index

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_index` */
case class PgIndexId(value: /* oid */ Long) extends AnyVal
object PgIndexId {
  implicit val arrayGet: Get[Array[PgIndexId]] = adventureworks.LongArrayMeta.get.map(_.map(PgIndexId.apply))
  implicit val arrayPut: Put[Array[PgIndexId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[PgIndexId, /* oid */ Long] = Bijection[PgIndexId, /* oid */ Long](_.value)(PgIndexId.apply)
  implicit val decoder: Decoder[PgIndexId] = Decoder.decodeLong.map(PgIndexId.apply)
  implicit val encoder: Encoder[PgIndexId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgIndexId] = Meta.LongMeta.get.map(PgIndexId.apply)
  implicit val ordering: Ordering[PgIndexId] = Ordering.by(_.value)
  implicit val put: Put[PgIndexId] = Meta.LongMeta.put.contramap(_.value)
}
