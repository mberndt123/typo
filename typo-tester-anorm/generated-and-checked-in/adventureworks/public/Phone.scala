/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import java.sql.Types
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Domain `public.Phone`
  * No constraint
  */
case class Phone(value: String)
object Phone {
  implicit lazy val arrayColumn: Column[Array[Phone]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[Phone]] = ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData).contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[Phone, String] = Bijection[Phone, String](_.value)(Phone.apply)
  implicit lazy val column: Column[Phone] = Column.columnToString.map(Phone.apply)
  implicit lazy val ordering: Ordering[Phone] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[Phone] = new ParameterMetaData[Phone] {
    override def sqlType: String = """"public"."Phone""""
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[Phone] = Reads.StringReads.map(Phone.apply)
  implicit lazy val text: Text[Phone] = new Text[Phone] {
    override def unsafeEncode(v: Phone, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: Phone, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[Phone] = ToStatement.stringToStatement.contramap(_.value)
  implicit lazy val writes: Writes[Phone] = Writes.StringWrites.contramap(_.value)
}