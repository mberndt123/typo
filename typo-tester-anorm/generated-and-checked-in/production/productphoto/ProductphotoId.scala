/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `production.productphoto` */
case class ProductphotoId(value: Int) extends AnyVal
object ProductphotoId {
  implicit val arrayToStatement: ToStatement[Array[ProductphotoId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit val bijection: Bijection[ProductphotoId, Int] = Bijection[ProductphotoId, Int](_.value)(ProductphotoId.apply)
  implicit val column: Column[ProductphotoId] = implicitly[Column[Int]].map(ProductphotoId.apply)
  implicit val ordering: Ordering[ProductphotoId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[ProductphotoId] = new ParameterMetaData[ProductphotoId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit val reads: Reads[ProductphotoId] = Reads.IntReads.map(ProductphotoId.apply)
  implicit val toStatement: ToStatement[ProductphotoId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val writes: Writes[ProductphotoId] = Writes.IntWrites.contramap(_.value)
}
