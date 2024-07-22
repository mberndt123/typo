/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.shipmethod

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `purchasing.shipmethod` */
case class ShipmethodId(value: Int) extends AnyVal
object ShipmethodId {
  implicit lazy val arrayColumn: Column[Array[ShipmethodId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[ShipmethodId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ShipmethodId, Int] = Bijection[ShipmethodId, Int](_.value)(ShipmethodId.apply)
  implicit lazy val column: Column[ShipmethodId] = Column.columnToInt.map(ShipmethodId.apply)
  implicit lazy val parameterMetadata: ParameterMetaData[ShipmethodId] = new ParameterMetaData[ShipmethodId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[ShipmethodId] = Reads.IntReads.map(ShipmethodId.apply)
  implicit lazy val text: Text[ShipmethodId] = new Text[ShipmethodId] {
    override def unsafeEncode(v: ShipmethodId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ShipmethodId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[ShipmethodId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[ShipmethodId] = Writes.IntWrites.contramap(_.value)
}
