/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_namespace

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_namespace` */
case class PgNamespaceId(value: /* oid */ Long) extends AnyVal
object PgNamespaceId {
  implicit lazy val arrayColumn: Column[Array[PgNamespaceId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgNamespaceId]] = adventureworks.LongArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgNamespaceId, /* oid */ Long] = Bijection[PgNamespaceId, /* oid */ Long](_.value)(PgNamespaceId.apply)
  implicit lazy val column: Column[PgNamespaceId] = Column.columnToLong.map(PgNamespaceId.apply)
  implicit lazy val ordering: Ordering[PgNamespaceId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgNamespaceId] = new ParameterMetaData[PgNamespaceId] {
    override def sqlType: String = ParameterMetaData.LongParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.LongParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[PgNamespaceId] = Reads.LongReads.map(PgNamespaceId.apply)
  implicit lazy val toStatement: ToStatement[PgNamespaceId] = ToStatement.longToStatement.contramap(_.value)
  implicit lazy val writes: Writes[PgNamespaceId] = Writes.LongWrites.contramap(_.value)
}
