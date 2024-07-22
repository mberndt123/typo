/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.vproductanddescription

import adventureworks.production.culture.CultureId
import adventureworks.production.product.ProductId
import adventureworks.public.Name
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLike
import typo.dsl.Structure.Relation

trait VproductanddescriptionMVFields {
  def productid: Field[ProductId, VproductanddescriptionMVRow]
  def name: Field[Name, VproductanddescriptionMVRow]
  def productmodel: Field[Name, VproductanddescriptionMVRow]
  def cultureid: Field[CultureId, VproductanddescriptionMVRow]
  def description: Field[/* max 400 chars */ String, VproductanddescriptionMVRow]
}

object VproductanddescriptionMVFields {
  lazy val structure: Relation[VproductanddescriptionMVFields, VproductanddescriptionMVRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[VproductanddescriptionMVFields, VproductanddescriptionMVRow] {
  
    override lazy val fields: VproductanddescriptionMVFields = new VproductanddescriptionMVFields {
      override def productid = Field[ProductId, VproductanddescriptionMVRow](_path, "productid", None, None, x => x.productid, (row, value) => row.copy(productid = value))
      override def name = Field[Name, VproductanddescriptionMVRow](_path, "name", None, None, x => x.name, (row, value) => row.copy(name = value))
      override def productmodel = Field[Name, VproductanddescriptionMVRow](_path, "productmodel", None, None, x => x.productmodel, (row, value) => row.copy(productmodel = value))
      override def cultureid = Field[CultureId, VproductanddescriptionMVRow](_path, "cultureid", None, None, x => x.cultureid, (row, value) => row.copy(cultureid = value))
      override def description = Field[/* max 400 chars */ String, VproductanddescriptionMVRow](_path, "description", None, None, x => x.description, (row, value) => row.copy(description = value))
    }
  
    override lazy val columns: List[FieldLike[?, VproductanddescriptionMVRow]] =
      List[FieldLike[?, VproductanddescriptionMVRow]](fields.productid, fields.name, fields.productmodel, fields.cultureid, fields.description)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
