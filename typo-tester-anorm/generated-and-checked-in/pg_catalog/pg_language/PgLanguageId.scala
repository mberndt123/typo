/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_language

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_language` */
case class PgLanguageId(value: /* oid */ Long) extends AnyVal
object PgLanguageId {
  implicit val arrayToStatement: ToStatement[Array[PgLanguageId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val bijection: Bijection[PgLanguageId, /* oid */ Long] = Bijection[PgLanguageId, /* oid */ Long](_.value)(PgLanguageId.apply)
  implicit val column: Column[PgLanguageId] = implicitly[Column[/* oid */ Long]].map(PgLanguageId.apply)
  implicit val ordering: Ordering[PgLanguageId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[PgLanguageId] = new ParameterMetaData[PgLanguageId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit val reads: Reads[PgLanguageId] = Reads.LongReads.map(PgLanguageId.apply)
  implicit val toStatement: ToStatement[PgLanguageId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val writes: Writes[PgLanguageId] = Writes.LongWrites.contramap(_.value)
}
