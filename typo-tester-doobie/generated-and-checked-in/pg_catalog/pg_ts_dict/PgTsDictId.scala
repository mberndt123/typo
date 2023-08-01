/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_dict

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_ts_dict` */
case class PgTsDictId(value: /* oid */ Long) extends AnyVal
object PgTsDictId {
  implicit val arrayGet: Get[Array[PgTsDictId]] = adventureworks.LongArrayMeta.get.map(_.map(PgTsDictId.apply))
  implicit val arrayPut: Put[Array[PgTsDictId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val bijection: Bijection[PgTsDictId, /* oid */ Long] = Bijection[PgTsDictId, /* oid */ Long](_.value)(PgTsDictId.apply)
  implicit val decoder: Decoder[PgTsDictId] = Decoder.decodeLong.map(PgTsDictId.apply)
  implicit val encoder: Encoder[PgTsDictId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgTsDictId] = Meta.LongMeta.get.map(PgTsDictId.apply)
  implicit val ordering: Ordering[PgTsDictId] = Ordering.by(_.value)
  implicit val put: Put[PgTsDictId] = Meta.LongMeta.put.contramap(_.value)
}
