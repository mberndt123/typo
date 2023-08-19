/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_index

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_index` */
case class PgIndexId(value: /* oid */ Long) extends AnyVal
object PgIndexId {
  implicit lazy val arrayColumn: Column[Array[PgIndexId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgIndexId]] = adventureworks.LongArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgIndexId, /* oid */ Long] = Bijection[PgIndexId, /* oid */ Long](_.value)(PgIndexId.apply)
  implicit lazy val column: Column[PgIndexId] = Column.columnToLong.map(PgIndexId.apply)
  implicit lazy val ordering: Ordering[PgIndexId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgIndexId] = new ParameterMetaData[PgIndexId] {
    override def sqlType: String = ParameterMetaData.LongParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.LongParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[PgIndexId] = Reads.LongReads.map(PgIndexId.apply)
  implicit lazy val toStatement: ToStatement[PgIndexId] = ToStatement.longToStatement.contramap(_.value)
  implicit lazy val writes: Writes[PgIndexId] = Writes.LongWrites.contramap(_.value)
}
