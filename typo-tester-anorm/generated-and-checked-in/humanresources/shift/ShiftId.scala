/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `humanresources.shift` */
case class ShiftId(value: Int) extends AnyVal
object ShiftId {
  implicit lazy val arrayColumn: Column[Array[ShiftId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[ShiftId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ShiftId, Int] = Bijection[ShiftId, Int](_.value)(ShiftId.apply)
  implicit lazy val column: Column[ShiftId] = Column.columnToInt.map(ShiftId.apply)
  implicit lazy val ordering: Ordering[ShiftId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[ShiftId] = new ParameterMetaData[ShiftId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[ShiftId] = Reads.IntReads.map(ShiftId.apply)
  implicit lazy val toStatement: ToStatement[ShiftId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[ShiftId] = Writes.IntWrites.contramap(_.value)
}
