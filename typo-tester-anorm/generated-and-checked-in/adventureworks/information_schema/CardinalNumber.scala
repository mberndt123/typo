/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.information_schema

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import java.sql.Types
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Domain `information_schema.cardinal_number`
  * Constraint: CHECK ((VALUE >= 0))
  */
case class CardinalNumber(value: Int)
object CardinalNumber {
  implicit lazy val arrayColumn: Column[Array[CardinalNumber]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[CardinalNumber]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CardinalNumber, Int] = Bijection[CardinalNumber, Int](_.value)(CardinalNumber.apply)
  implicit lazy val column: Column[CardinalNumber] = Column.columnToInt.map(CardinalNumber.apply)
  implicit lazy val parameterMetadata: ParameterMetaData[CardinalNumber] = new ParameterMetaData[CardinalNumber] {
    override def sqlType: String = """"information_schema"."cardinal_number""""
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[CardinalNumber] = Reads.IntReads.map(CardinalNumber.apply)
  implicit lazy val text: Text[CardinalNumber] = new Text[CardinalNumber] {
    override def unsafeEncode(v: CardinalNumber, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: CardinalNumber, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[CardinalNumber] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[CardinalNumber] = Writes.IntWrites.contramap(_.value)
}