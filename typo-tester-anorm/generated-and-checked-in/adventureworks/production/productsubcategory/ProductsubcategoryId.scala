/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productsubcategory;

import adventureworks.Text;
import anorm.Column;
import anorm.ParameterMetaData;
import anorm.ToStatement;
import play.api.libs.json.Reads;
import play.api.libs.json.Writes;
import typo.dsl.Bijection;

/** Type for the primary key of table `production.productsubcategory` */
case class ProductsubcategoryId(value: Int) extends scala.AnyVal

object ProductsubcategoryId {
  implicit lazy val arrayColumn: Column[Array[ProductsubcategoryId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[ProductsubcategoryId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductsubcategoryId, Int] = Bijection[ProductsubcategoryId, Int](_.value)(ProductsubcategoryId.apply)
  implicit lazy val column: Column[ProductsubcategoryId] = Column.columnToInt.map(ProductsubcategoryId.apply)
  implicit lazy val parameterMetadata: ParameterMetaData[ProductsubcategoryId] = {
    new ParameterMetaData[ProductsubcategoryId] {
      override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
      override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
    }
  }
  implicit lazy val reads: Reads[ProductsubcategoryId] = Reads.IntReads.map(ProductsubcategoryId.apply)
  implicit lazy val text: Text[ProductsubcategoryId] = {
    new Text[ProductsubcategoryId] {
      override def unsafeEncode(v: ProductsubcategoryId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
      override def unsafeArrayEncode(v: ProductsubcategoryId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
    }
  }
  implicit lazy val toStatement: ToStatement[ProductsubcategoryId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[ProductsubcategoryId] = Writes.IntWrites.contramap(_.value)
}