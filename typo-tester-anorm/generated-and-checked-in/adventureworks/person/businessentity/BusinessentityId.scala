/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `person.businessentity` */
case class BusinessentityId(value: Int) extends AnyVal
object BusinessentityId {
  implicit lazy val arrayColumn: Column[Array[BusinessentityId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[BusinessentityId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[BusinessentityId, Int] = Bijection[BusinessentityId, Int](_.value)(BusinessentityId.apply)
  implicit lazy val column: Column[BusinessentityId] = Column.columnToInt.map(BusinessentityId.apply)
  implicit lazy val ordering: Ordering[BusinessentityId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[BusinessentityId] = new ParameterMetaData[BusinessentityId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[BusinessentityId] = Reads.IntReads.map(BusinessentityId.apply)
  implicit lazy val text: Text[BusinessentityId] = new Text[BusinessentityId] {
    override def unsafeEncode(v: BusinessentityId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: BusinessentityId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[BusinessentityId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[BusinessentityId] = Writes.IntWrites.contramap(_.value)
}
