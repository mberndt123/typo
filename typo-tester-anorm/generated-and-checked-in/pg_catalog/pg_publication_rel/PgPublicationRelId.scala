/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication_rel

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_publication_rel` */
case class PgPublicationRelId(value: /* oid */ Long) extends AnyVal
object PgPublicationRelId {
  implicit val arrayToStatement: ToStatement[Array[PgPublicationRelId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val bijection: Bijection[PgPublicationRelId, /* oid */ Long] = Bijection[PgPublicationRelId, /* oid */ Long](_.value)(PgPublicationRelId.apply)
  implicit val column: Column[PgPublicationRelId] = implicitly[Column[/* oid */ Long]].map(PgPublicationRelId.apply)
  implicit val ordering: Ordering[PgPublicationRelId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[PgPublicationRelId] = new ParameterMetaData[PgPublicationRelId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit val reads: Reads[PgPublicationRelId] = Reads.LongReads.map(PgPublicationRelId.apply)
  implicit val toStatement: ToStatement[PgPublicationRelId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val writes: Writes[PgPublicationRelId] = Writes.LongWrites.contramap(_.value)
}
