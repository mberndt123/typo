/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_tablespace

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_tablespace` */
case class PgTablespaceId(value: /* oid */ Long) extends AnyVal
object PgTablespaceId {
  implicit lazy val arrayColumn: Column[Array[PgTablespaceId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgTablespaceId]] = adventureworks.LongArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgTablespaceId, /* oid */ Long] = Bijection[PgTablespaceId, /* oid */ Long](_.value)(PgTablespaceId.apply)
  implicit lazy val column: Column[PgTablespaceId] = Column.columnToLong.map(PgTablespaceId.apply)
  implicit lazy val ordering: Ordering[PgTablespaceId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgTablespaceId] = new ParameterMetaData[PgTablespaceId] {
    override def sqlType: String = ParameterMetaData.LongParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.LongParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[PgTablespaceId] = Reads.LongReads.map(PgTablespaceId.apply)
  implicit lazy val toStatement: ToStatement[PgTablespaceId] = ToStatement.longToStatement.contramap(_.value)
  implicit lazy val writes: Writes[PgTablespaceId] = Writes.LongWrites.contramap(_.value)
}
