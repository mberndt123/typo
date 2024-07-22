/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productcategory

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLike
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait ProductcategoryFields {
  def productcategoryid: IdField[ProductcategoryId, ProductcategoryRow]
  def name: Field[Name, ProductcategoryRow]
  def rowguid: Field[TypoUUID, ProductcategoryRow]
  def modifieddate: Field[TypoLocalDateTime, ProductcategoryRow]
}

object ProductcategoryFields {
  lazy val structure: Relation[ProductcategoryFields, ProductcategoryRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[ProductcategoryFields, ProductcategoryRow] {
  
    override lazy val fields: ProductcategoryFields = new ProductcategoryFields {
      override def productcategoryid = IdField[ProductcategoryId, ProductcategoryRow](_path, "productcategoryid", None, Some("int4"), x => x.productcategoryid, (row, value) => row.copy(productcategoryid = value))
      override def name = Field[Name, ProductcategoryRow](_path, "name", None, Some("varchar"), x => x.name, (row, value) => row.copy(name = value))
      override def rowguid = Field[TypoUUID, ProductcategoryRow](_path, "rowguid", None, Some("uuid"), x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, ProductcategoryRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, ProductcategoryRow]] =
      List[FieldLike[?, ProductcategoryRow]](fields.productcategoryid, fields.name, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
