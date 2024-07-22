/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.address

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `person.address` */
case class AddressId(value: Int) extends AnyVal
object AddressId {
  implicit lazy val arrayColumn: Column[Array[AddressId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[AddressId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[AddressId, Int] = Bijection[AddressId, Int](_.value)(AddressId.apply)
  implicit lazy val column: Column[AddressId] = Column.columnToInt.map(AddressId.apply)
  implicit lazy val parameterMetadata: ParameterMetaData[AddressId] = new ParameterMetaData[AddressId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[AddressId] = Reads.IntReads.map(AddressId.apply)
  implicit lazy val text: Text[AddressId] = new Text[AddressId] {
    override def unsafeEncode(v: AddressId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: AddressId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[AddressId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[AddressId] = Writes.IntWrites.contramap(_.value)
}
