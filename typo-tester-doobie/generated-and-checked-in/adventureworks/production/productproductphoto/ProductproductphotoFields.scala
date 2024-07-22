/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productproductphoto

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductFields
import adventureworks.production.product.ProductId
import adventureworks.production.product.ProductRow
import adventureworks.production.productphoto.ProductphotoFields
import adventureworks.production.productphoto.ProductphotoId
import adventureworks.production.productphoto.ProductphotoRow
import adventureworks.public.Flag
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr
import typo.dsl.SqlExpr.CompositeIn
import typo.dsl.SqlExpr.CompositeIn.TuplePart
import typo.dsl.SqlExpr.Const.As.as
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLike
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait ProductproductphotoFields {
  def productid: IdField[ProductId, ProductproductphotoRow]
  def productphotoid: IdField[ProductphotoId, ProductproductphotoRow]
  def primary: Field[Flag, ProductproductphotoRow]
  def modifieddate: Field[TypoLocalDateTime, ProductproductphotoRow]
  def fkProductphoto: ForeignKey[ProductphotoFields, ProductphotoRow] =
    ForeignKey[ProductphotoFields, ProductphotoRow]("production.FK_ProductProductPhoto_ProductPhoto_ProductPhotoID", Nil)
      .withColumnPair(productphotoid, _.productphotoid)
  def fkProduct: ForeignKey[ProductFields, ProductRow] =
    ForeignKey[ProductFields, ProductRow]("production.FK_ProductProductPhoto_Product_ProductID", Nil)
      .withColumnPair(productid, _.productid)
  def compositeIdIs(compositeId: ProductproductphotoId): SqlExpr[Boolean] =
    productid.isEqual(compositeId.productid).and(productphotoid.isEqual(compositeId.productphotoid))
  def compositeIdIn(compositeIds: Array[ProductproductphotoId]): SqlExpr[Boolean] =
    new CompositeIn(compositeIds)(TuplePart[ProductproductphotoId](productid)(_.productid)(using as[Array[ProductId]](ProductId.arrayPut), implicitly), TuplePart[ProductproductphotoId](productphotoid)(_.productphotoid)(using as[Array[ProductphotoId]](ProductphotoId.arrayPut), implicitly))
  
}

object ProductproductphotoFields {
  lazy val structure: Relation[ProductproductphotoFields, ProductproductphotoRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[ProductproductphotoFields, ProductproductphotoRow] {
  
    override lazy val fields: ProductproductphotoFields = new ProductproductphotoFields {
      override def productid = IdField[ProductId, ProductproductphotoRow](_path, "productid", None, Some("int4"), x => x.productid, (row, value) => row.copy(productid = value))
      override def productphotoid = IdField[ProductphotoId, ProductproductphotoRow](_path, "productphotoid", None, Some("int4"), x => x.productphotoid, (row, value) => row.copy(productphotoid = value))
      override def primary = Field[Flag, ProductproductphotoRow](_path, "primary", None, Some("bool"), x => x.primary, (row, value) => row.copy(primary = value))
      override def modifieddate = Field[TypoLocalDateTime, ProductproductphotoRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, ProductproductphotoRow]] =
      List[FieldLike[?, ProductproductphotoRow]](fields.productid, fields.productphotoid, fields.primary, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
