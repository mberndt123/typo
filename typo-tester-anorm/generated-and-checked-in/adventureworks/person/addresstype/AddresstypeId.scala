/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `person.addresstype` */
case class AddresstypeId(value: Int) extends AnyVal
object AddresstypeId {
  implicit lazy val arrayColumn: Column[Array[AddresstypeId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[AddresstypeId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[AddresstypeId, Int] = Bijection[AddresstypeId, Int](_.value)(AddresstypeId.apply)
  implicit lazy val column: Column[AddresstypeId] = Column.columnToInt.map(AddresstypeId.apply)
  implicit lazy val ordering: Ordering[AddresstypeId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[AddresstypeId] = new ParameterMetaData[AddresstypeId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[AddresstypeId] = Reads.IntReads.map(AddresstypeId.apply)
  implicit lazy val text: Text[AddresstypeId] = new Text[AddresstypeId] {
    override def unsafeEncode(v: AddresstypeId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: AddresstypeId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[AddresstypeId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[AddresstypeId] = Writes.IntWrites.contramap(_.value)
}
