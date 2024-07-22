/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productdescription

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `production.productdescription` */
case class ProductdescriptionId(value: Int) extends AnyVal
object ProductdescriptionId {
  implicit lazy val arrayColumn: Column[Array[ProductdescriptionId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[ProductdescriptionId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductdescriptionId, Int] = Bijection[ProductdescriptionId, Int](_.value)(ProductdescriptionId.apply)
  implicit lazy val column: Column[ProductdescriptionId] = Column.columnToInt.map(ProductdescriptionId.apply)
  implicit lazy val ordering: Ordering[ProductdescriptionId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[ProductdescriptionId] = new ParameterMetaData[ProductdescriptionId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[ProductdescriptionId] = Reads.IntReads.map(ProductdescriptionId.apply)
  implicit lazy val text: Text[ProductdescriptionId] = new Text[ProductdescriptionId] {
    override def unsafeEncode(v: ProductdescriptionId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ProductdescriptionId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[ProductdescriptionId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[ProductdescriptionId] = Writes.IntWrites.contramap(_.value)
}
