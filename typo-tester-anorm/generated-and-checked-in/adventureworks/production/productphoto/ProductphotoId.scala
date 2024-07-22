/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productphoto

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `production.productphoto` */
case class ProductphotoId(value: Int) extends AnyVal
object ProductphotoId {
  implicit lazy val arrayColumn: Column[Array[ProductphotoId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[ProductphotoId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductphotoId, Int] = Bijection[ProductphotoId, Int](_.value)(ProductphotoId.apply)
  implicit lazy val column: Column[ProductphotoId] = Column.columnToInt.map(ProductphotoId.apply)
  implicit lazy val ordering: Ordering[ProductphotoId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[ProductphotoId] = new ParameterMetaData[ProductphotoId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[ProductphotoId] = Reads.IntReads.map(ProductphotoId.apply)
  implicit lazy val text: Text[ProductphotoId] = new Text[ProductphotoId] {
    override def unsafeEncode(v: ProductphotoId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ProductphotoId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[ProductphotoId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[ProductphotoId] = Writes.IntWrites.contramap(_.value)
}
