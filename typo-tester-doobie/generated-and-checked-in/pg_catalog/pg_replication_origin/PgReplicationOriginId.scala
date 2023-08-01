/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_replication_origin

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_replication_origin` */
case class PgReplicationOriginId(value: /* oid */ Long) extends AnyVal
object PgReplicationOriginId {
  implicit val arrayGet: Get[Array[PgReplicationOriginId]] = adventureworks.LongArrayMeta.get.map(_.map(PgReplicationOriginId.apply))
  implicit val arrayPut: Put[Array[PgReplicationOriginId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[PgReplicationOriginId, /* oid */ Long] = Bijection[PgReplicationOriginId, /* oid */ Long](_.value)(PgReplicationOriginId.apply)
  implicit val decoder: Decoder[PgReplicationOriginId] = Decoder.decodeLong.map(PgReplicationOriginId.apply)
  implicit val encoder: Encoder[PgReplicationOriginId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgReplicationOriginId] = Meta.LongMeta.get.map(PgReplicationOriginId.apply)
  implicit val ordering: Ordering[PgReplicationOriginId] = Ordering.by(_.value)
  implicit val put: Put[PgReplicationOriginId] = Meta.LongMeta.put.contramap(_.value)
}
