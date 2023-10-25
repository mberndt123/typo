/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Domain `public.NameStyle`
  * No constraint
  */
case class NameStyle(value: Boolean) extends AnyVal
object NameStyle {
  implicit lazy val arrayColumn: Column[Array[NameStyle]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[NameStyle]] = adventureworks.BooleanArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[NameStyle, Boolean] = Bijection[NameStyle, Boolean](_.value)(NameStyle.apply)
  implicit lazy val column: Column[NameStyle] = Column.columnToBoolean.map(NameStyle.apply)
  implicit lazy val ordering: Ordering[NameStyle] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[NameStyle] = new ParameterMetaData[NameStyle] {
    override def sqlType: String = ParameterMetaData.BooleanParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.BooleanParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[NameStyle] = Reads.BooleanReads.map(NameStyle.apply)
  implicit lazy val text: Text[NameStyle] = new Text[NameStyle] {
    override def unsafeEncode(v: NameStyle, sb: StringBuilder) = Text.booleanInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: NameStyle, sb: StringBuilder) = Text.booleanInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[NameStyle] = ToStatement.booleanToStatement.contramap(_.value)
  implicit lazy val writes: Writes[NameStyle] = Writes.BooleanWrites.contramap(_.value)
}