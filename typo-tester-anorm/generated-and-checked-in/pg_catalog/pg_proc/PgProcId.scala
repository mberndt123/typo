/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_proc

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_proc` */
case class PgProcId(value: /* oid */ Long) extends AnyVal
object PgProcId {
  implicit val arrayToStatement: ToStatement[Array[PgProcId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val bijection: Bijection[PgProcId, /* oid */ Long] = Bijection[PgProcId, /* oid */ Long](_.value)(PgProcId.apply)
  implicit val column: Column[PgProcId] = implicitly[Column[/* oid */ Long]].map(PgProcId.apply)
  implicit val ordering: Ordering[PgProcId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[PgProcId] = new ParameterMetaData[PgProcId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit val reads: Reads[PgProcId] = Reads.LongReads.map(PgProcId.apply)
  implicit val toStatement: ToStatement[PgProcId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val writes: Writes[PgProcId] = Writes.LongWrites.contramap(_.value)
}
