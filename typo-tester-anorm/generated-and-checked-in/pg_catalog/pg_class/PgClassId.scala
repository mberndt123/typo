/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_class

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_class` */
case class PgClassId(value: /* oid */ Long) extends AnyVal
object PgClassId {
  implicit lazy val arrayColumn: Column[Array[PgClassId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgClassId]] = adventureworks.LongArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgClassId, /* oid */ Long] = Bijection[PgClassId, /* oid */ Long](_.value)(PgClassId.apply)
  implicit lazy val column: Column[PgClassId] = Column.columnToLong.map(PgClassId.apply)
  implicit lazy val ordering: Ordering[PgClassId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgClassId] = new ParameterMetaData[PgClassId] {
    override def sqlType: String = ParameterMetaData.LongParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.LongParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[PgClassId] = Reads.LongReads.map(PgClassId.apply)
  implicit lazy val toStatement: ToStatement[PgClassId] = ToStatement.longToStatement.contramap(_.value)
  implicit lazy val writes: Writes[PgClassId] = Writes.LongWrites.contramap(_.value)
}
