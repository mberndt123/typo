/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amproc

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_amproc` */
case class PgAmprocId(value: /* oid */ Long) extends AnyVal
object PgAmprocId {
  implicit lazy val arrayColumn: Column[Array[PgAmprocId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgAmprocId]] = adventureworks.LongArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgAmprocId, /* oid */ Long] = Bijection[PgAmprocId, /* oid */ Long](_.value)(PgAmprocId.apply)
  implicit lazy val column: Column[PgAmprocId] = Column.columnToLong.map(PgAmprocId.apply)
  implicit lazy val ordering: Ordering[PgAmprocId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgAmprocId] = new ParameterMetaData[PgAmprocId] {
    override def sqlType: String = ParameterMetaData.LongParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.LongParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[PgAmprocId] = Reads.LongReads.map(PgAmprocId.apply)
  implicit lazy val toStatement: ToStatement[PgAmprocId] = ToStatement.longToStatement.contramap(_.value)
  implicit lazy val writes: Writes[PgAmprocId] = Writes.LongWrites.contramap(_.value)
}
