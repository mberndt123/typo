/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `production.productreview` */
case class ProductreviewId(value: Int) extends AnyVal
object ProductreviewId {
  implicit lazy val arrayColumn: Column[Array[ProductreviewId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[ProductreviewId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductreviewId, Int] = Bijection[ProductreviewId, Int](_.value)(ProductreviewId.apply)
  implicit lazy val column: Column[ProductreviewId] = Column.columnToInt.map(ProductreviewId.apply)
  implicit lazy val ordering: Ordering[ProductreviewId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[ProductreviewId] = new ParameterMetaData[ProductreviewId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[ProductreviewId] = Reads.IntReads.map(ProductreviewId.apply)
  implicit lazy val text: Text[ProductreviewId] = new Text[ProductreviewId] {
    override def unsafeEncode(v: ProductreviewId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ProductreviewId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[ProductreviewId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[ProductreviewId] = Writes.IntWrites.contramap(_.value)
}
