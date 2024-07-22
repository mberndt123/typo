/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.workorder

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `production.workorder` */
case class WorkorderId(value: Int) extends AnyVal
object WorkorderId {
  implicit lazy val arrayColumn: Column[Array[WorkorderId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[WorkorderId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[WorkorderId, Int] = Bijection[WorkorderId, Int](_.value)(WorkorderId.apply)
  implicit lazy val column: Column[WorkorderId] = Column.columnToInt.map(WorkorderId.apply)
  implicit lazy val ordering: Ordering[WorkorderId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[WorkorderId] = new ParameterMetaData[WorkorderId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[WorkorderId] = Reads.IntReads.map(WorkorderId.apply)
  implicit lazy val text: Text[WorkorderId] = new Text[WorkorderId] {
    override def unsafeEncode(v: WorkorderId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: WorkorderId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[WorkorderId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[WorkorderId] = Writes.IntWrites.contramap(_.value)
}
