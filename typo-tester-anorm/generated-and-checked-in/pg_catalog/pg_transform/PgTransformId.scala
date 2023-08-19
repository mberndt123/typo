/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_transform

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_transform` */
case class PgTransformId(value: /* oid */ Long) extends AnyVal
object PgTransformId {
  implicit lazy val arrayColumn: Column[Array[PgTransformId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgTransformId]] = adventureworks.LongArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgTransformId, /* oid */ Long] = Bijection[PgTransformId, /* oid */ Long](_.value)(PgTransformId.apply)
  implicit lazy val column: Column[PgTransformId] = Column.columnToLong.map(PgTransformId.apply)
  implicit lazy val ordering: Ordering[PgTransformId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgTransformId] = new ParameterMetaData[PgTransformId] {
    override def sqlType: String = ParameterMetaData.LongParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.LongParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[PgTransformId] = Reads.LongReads.map(PgTransformId.apply)
  implicit lazy val toStatement: ToStatement[PgTransformId] = ToStatement.longToStatement.contramap(_.value)
  implicit lazy val writes: Writes[PgTransformId] = Writes.LongWrites.contramap(_.value)
}
