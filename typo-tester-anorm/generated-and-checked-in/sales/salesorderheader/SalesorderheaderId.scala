/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `sales.salesorderheader` */
case class SalesorderheaderId(value: Int) extends AnyVal
object SalesorderheaderId {
  implicit lazy val arrayColumn: Column[Array[SalesorderheaderId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[SalesorderheaderId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[SalesorderheaderId, Int] = Bijection[SalesorderheaderId, Int](_.value)(SalesorderheaderId.apply)
  implicit lazy val column: Column[SalesorderheaderId] = Column.columnToInt.map(SalesorderheaderId.apply)
  implicit lazy val ordering: Ordering[SalesorderheaderId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[SalesorderheaderId] = new ParameterMetaData[SalesorderheaderId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[SalesorderheaderId] = Reads.IntReads.map(SalesorderheaderId.apply)
  implicit lazy val toStatement: ToStatement[SalesorderheaderId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[SalesorderheaderId] = Writes.IntWrites.contramap(_.value)
}
