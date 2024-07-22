/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productsubcategory

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productcategory.ProductcategoryFields
import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.production.productcategory.ProductcategoryRow
import adventureworks.public.Name
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait ProductsubcategoryFields {
  def productsubcategoryid: IdField[ProductsubcategoryId, ProductsubcategoryRow]
  def productcategoryid: Field[ProductcategoryId, ProductsubcategoryRow]
  def name: Field[Name, ProductsubcategoryRow]
  def rowguid: Field[TypoUUID, ProductsubcategoryRow]
  def modifieddate: Field[TypoLocalDateTime, ProductsubcategoryRow]
  def fkProductcategory: ForeignKey[ProductcategoryFields, ProductcategoryRow] =
    ForeignKey[ProductcategoryFields, ProductcategoryRow]("production.FK_ProductSubcategory_ProductCategory_ProductCategoryID", Nil)
      .withColumnPair(productcategoryid, _.productcategoryid)
}

object ProductsubcategoryFields {
  lazy val structure: Relation[ProductsubcategoryFields, ProductsubcategoryRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[ProductsubcategoryFields, ProductsubcategoryRow] {
  
    override lazy val fields: ProductsubcategoryFields = new ProductsubcategoryFields {
      override def productsubcategoryid = IdField[ProductsubcategoryId, ProductsubcategoryRow](_path, "productsubcategoryid", None, Some("int4"), x => x.productsubcategoryid, (row, value) => row.copy(productsubcategoryid = value))
      override def productcategoryid = Field[ProductcategoryId, ProductsubcategoryRow](_path, "productcategoryid", None, Some("int4"), x => x.productcategoryid, (row, value) => row.copy(productcategoryid = value))
      override def name = Field[Name, ProductsubcategoryRow](_path, "name", None, Some("varchar"), x => x.name, (row, value) => row.copy(name = value))
      override def rowguid = Field[TypoUUID, ProductsubcategoryRow](_path, "rowguid", None, Some("uuid"), x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, ProductsubcategoryRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, ProductsubcategoryRow]] =
      List[FieldLikeNoHkt[?, ProductsubcategoryRow]](fields.productsubcategoryid, fields.productcategoryid, fields.name, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
