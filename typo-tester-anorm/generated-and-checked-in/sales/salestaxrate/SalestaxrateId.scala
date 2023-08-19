/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `sales.salestaxrate` */
case class SalestaxrateId(value: Int) extends AnyVal
object SalestaxrateId {
  implicit lazy val arrayColumn: Column[Array[SalestaxrateId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[SalestaxrateId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[SalestaxrateId, Int] = Bijection[SalestaxrateId, Int](_.value)(SalestaxrateId.apply)
  implicit lazy val column: Column[SalestaxrateId] = Column.columnToInt.map(SalestaxrateId.apply)
  implicit lazy val ordering: Ordering[SalestaxrateId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[SalestaxrateId] = new ParameterMetaData[SalestaxrateId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[SalestaxrateId] = Reads.IntReads.map(SalestaxrateId.apply)
  implicit lazy val toStatement: ToStatement[SalestaxrateId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[SalestaxrateId] = Writes.IntWrites.contramap(_.value)
}
