/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.shoppingcartitem

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductFields
import adventureworks.production.product.ProductId
import adventureworks.production.product.ProductRow
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait ShoppingcartitemFields {
  def shoppingcartitemid: IdField[ShoppingcartitemId, ShoppingcartitemRow]
  def shoppingcartid: Field[/* max 50 chars */ String, ShoppingcartitemRow]
  def quantity: Field[Int, ShoppingcartitemRow]
  def productid: Field[ProductId, ShoppingcartitemRow]
  def datecreated: Field[TypoLocalDateTime, ShoppingcartitemRow]
  def modifieddate: Field[TypoLocalDateTime, ShoppingcartitemRow]
  def fkProductionProduct: ForeignKey[ProductFields, ProductRow] =
    ForeignKey[ProductFields, ProductRow]("sales.FK_ShoppingCartItem_Product_ProductID", Nil)
      .withColumnPair(productid, _.productid)
}

object ShoppingcartitemFields {
  lazy val structure: Relation[ShoppingcartitemFields, ShoppingcartitemRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[ShoppingcartitemFields, ShoppingcartitemRow] {
  
    override lazy val fields: ShoppingcartitemFields = new ShoppingcartitemFields {
      override def shoppingcartitemid = IdField[ShoppingcartitemId, ShoppingcartitemRow](_path, "shoppingcartitemid", None, Some("int4"), x => x.shoppingcartitemid, (row, value) => row.copy(shoppingcartitemid = value))
      override def shoppingcartid = Field[/* max 50 chars */ String, ShoppingcartitemRow](_path, "shoppingcartid", None, None, x => x.shoppingcartid, (row, value) => row.copy(shoppingcartid = value))
      override def quantity = Field[Int, ShoppingcartitemRow](_path, "quantity", None, Some("int4"), x => x.quantity, (row, value) => row.copy(quantity = value))
      override def productid = Field[ProductId, ShoppingcartitemRow](_path, "productid", None, Some("int4"), x => x.productid, (row, value) => row.copy(productid = value))
      override def datecreated = Field[TypoLocalDateTime, ShoppingcartitemRow](_path, "datecreated", Some("text"), Some("timestamp"), x => x.datecreated, (row, value) => row.copy(datecreated = value))
      override def modifieddate = Field[TypoLocalDateTime, ShoppingcartitemRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, ShoppingcartitemRow]] =
      List[FieldLikeNoHkt[?, ShoppingcartitemRow]](fields.shoppingcartitemid, fields.shoppingcartid, fields.quantity, fields.productid, fields.datecreated, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
