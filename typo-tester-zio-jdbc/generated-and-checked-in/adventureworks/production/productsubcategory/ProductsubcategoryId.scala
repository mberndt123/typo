/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `production.productsubcategory` */
case class ProductsubcategoryId(value: Int) extends AnyVal
object ProductsubcategoryId {
  implicit lazy val arraySetter: Setter[Array[ProductsubcategoryId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductsubcategoryId, Int] = Bijection[ProductsubcategoryId, Int](_.value)(ProductsubcategoryId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductsubcategoryId] = JdbcDecoder.intDecoder.map(ProductsubcategoryId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[ProductsubcategoryId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[ProductsubcategoryId] = JsonDecoder.int.map(ProductsubcategoryId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[ProductsubcategoryId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[ProductsubcategoryId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[ProductsubcategoryId] = ParameterMetaData.instance[ProductsubcategoryId](ParameterMetaData.IntParameterMetaData.sqlType, ParameterMetaData.IntParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[ProductsubcategoryId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[ProductsubcategoryId] = new Text[ProductsubcategoryId] {
    override def unsafeEncode(v: ProductsubcategoryId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ProductsubcategoryId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
