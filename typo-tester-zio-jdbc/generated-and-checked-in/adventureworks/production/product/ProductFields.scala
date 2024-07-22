/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.product

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productmodel.ProductmodelFields
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productmodel.ProductmodelRow
import adventureworks.production.productsubcategory.ProductsubcategoryFields
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.productsubcategory.ProductsubcategoryRow
import adventureworks.production.unitmeasure.UnitmeasureFields
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.production.unitmeasure.UnitmeasureRow
import adventureworks.public.Flag
import adventureworks.public.Name
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait ProductFields {
  def productid: IdField[ProductId, ProductRow]
  def name: Field[Name, ProductRow]
  def productnumber: Field[/* max 25 chars */ String, ProductRow]
  def makeflag: Field[Flag, ProductRow]
  def finishedgoodsflag: Field[Flag, ProductRow]
  def color: OptField[/* max 15 chars */ String, ProductRow]
  def safetystocklevel: Field[TypoShort, ProductRow]
  def reorderpoint: Field[TypoShort, ProductRow]
  def standardcost: Field[BigDecimal, ProductRow]
  def listprice: Field[BigDecimal, ProductRow]
  def size: OptField[/* max 5 chars */ String, ProductRow]
  def sizeunitmeasurecode: OptField[UnitmeasureId, ProductRow]
  def weightunitmeasurecode: OptField[UnitmeasureId, ProductRow]
  def weight: OptField[BigDecimal, ProductRow]
  def daystomanufacture: Field[Int, ProductRow]
  def productline: OptField[/* bpchar, max 2 chars */ String, ProductRow]
  def `class`: OptField[/* bpchar, max 2 chars */ String, ProductRow]
  def style: OptField[/* bpchar, max 2 chars */ String, ProductRow]
  def productsubcategoryid: OptField[ProductsubcategoryId, ProductRow]
  def productmodelid: OptField[ProductmodelId, ProductRow]
  def sellstartdate: Field[TypoLocalDateTime, ProductRow]
  def sellenddate: OptField[TypoLocalDateTime, ProductRow]
  def discontinueddate: OptField[TypoLocalDateTime, ProductRow]
  def rowguid: Field[TypoUUID, ProductRow]
  def modifieddate: Field[TypoLocalDateTime, ProductRow]
  def fkProductmodel: ForeignKey[ProductmodelFields, ProductmodelRow] =
    ForeignKey[ProductmodelFields, ProductmodelRow]("production.FK_Product_ProductModel_ProductModelID", Nil)
      .withColumnPair(productmodelid, _.productmodelid)
  def fkProductsubcategory: ForeignKey[ProductsubcategoryFields, ProductsubcategoryRow] =
    ForeignKey[ProductsubcategoryFields, ProductsubcategoryRow]("production.FK_Product_ProductSubcategory_ProductSubcategoryID", Nil)
      .withColumnPair(productsubcategoryid, _.productsubcategoryid)
  def fkUnitmeasureSizeunitmeasurecode: ForeignKey[UnitmeasureFields, UnitmeasureRow] =
    ForeignKey[UnitmeasureFields, UnitmeasureRow]("production.FK_Product_UnitMeasure_SizeUnitMeasureCode", Nil)
      .withColumnPair(sizeunitmeasurecode, _.unitmeasurecode)
  def fkUnitmeasureWeightunitmeasurecode: ForeignKey[UnitmeasureFields, UnitmeasureRow] =
    ForeignKey[UnitmeasureFields, UnitmeasureRow]("production.FK_Product_UnitMeasure_WeightUnitMeasureCode", Nil)
      .withColumnPair(weightunitmeasurecode, _.unitmeasurecode)
}

object ProductFields {
  lazy val structure: Relation[ProductFields, ProductRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[ProductFields, ProductRow] {
  
    override lazy val fields: ProductFields = new ProductFields {
      override def productid = IdField[ProductId, ProductRow](_path, "productid", None, Some("int4"), x => x.productid, (row, value) => row.copy(productid = value))
      override def name = Field[Name, ProductRow](_path, "name", None, Some("varchar"), x => x.name, (row, value) => row.copy(name = value))
      override def productnumber = Field[/* max 25 chars */ String, ProductRow](_path, "productnumber", None, None, x => x.productnumber, (row, value) => row.copy(productnumber = value))
      override def makeflag = Field[Flag, ProductRow](_path, "makeflag", None, Some("bool"), x => x.makeflag, (row, value) => row.copy(makeflag = value))
      override def finishedgoodsflag = Field[Flag, ProductRow](_path, "finishedgoodsflag", None, Some("bool"), x => x.finishedgoodsflag, (row, value) => row.copy(finishedgoodsflag = value))
      override def color = OptField[/* max 15 chars */ String, ProductRow](_path, "color", None, None, x => x.color, (row, value) => row.copy(color = value))
      override def safetystocklevel = Field[TypoShort, ProductRow](_path, "safetystocklevel", None, Some("int2"), x => x.safetystocklevel, (row, value) => row.copy(safetystocklevel = value))
      override def reorderpoint = Field[TypoShort, ProductRow](_path, "reorderpoint", None, Some("int2"), x => x.reorderpoint, (row, value) => row.copy(reorderpoint = value))
      override def standardcost = Field[BigDecimal, ProductRow](_path, "standardcost", None, Some("numeric"), x => x.standardcost, (row, value) => row.copy(standardcost = value))
      override def listprice = Field[BigDecimal, ProductRow](_path, "listprice", None, Some("numeric"), x => x.listprice, (row, value) => row.copy(listprice = value))
      override def size = OptField[/* max 5 chars */ String, ProductRow](_path, "size", None, None, x => x.size, (row, value) => row.copy(size = value))
      override def sizeunitmeasurecode = OptField[UnitmeasureId, ProductRow](_path, "sizeunitmeasurecode", None, Some("bpchar"), x => x.sizeunitmeasurecode, (row, value) => row.copy(sizeunitmeasurecode = value))
      override def weightunitmeasurecode = OptField[UnitmeasureId, ProductRow](_path, "weightunitmeasurecode", None, Some("bpchar"), x => x.weightunitmeasurecode, (row, value) => row.copy(weightunitmeasurecode = value))
      override def weight = OptField[BigDecimal, ProductRow](_path, "weight", None, Some("numeric"), x => x.weight, (row, value) => row.copy(weight = value))
      override def daystomanufacture = Field[Int, ProductRow](_path, "daystomanufacture", None, Some("int4"), x => x.daystomanufacture, (row, value) => row.copy(daystomanufacture = value))
      override def productline = OptField[/* bpchar, max 2 chars */ String, ProductRow](_path, "productline", None, Some("bpchar"), x => x.productline, (row, value) => row.copy(productline = value))
      override def `class` = OptField[/* bpchar, max 2 chars */ String, ProductRow](_path, "class", None, Some("bpchar"), x => x.`class`, (row, value) => row.copy(`class` = value))
      override def style = OptField[/* bpchar, max 2 chars */ String, ProductRow](_path, "style", None, Some("bpchar"), x => x.style, (row, value) => row.copy(style = value))
      override def productsubcategoryid = OptField[ProductsubcategoryId, ProductRow](_path, "productsubcategoryid", None, Some("int4"), x => x.productsubcategoryid, (row, value) => row.copy(productsubcategoryid = value))
      override def productmodelid = OptField[ProductmodelId, ProductRow](_path, "productmodelid", None, Some("int4"), x => x.productmodelid, (row, value) => row.copy(productmodelid = value))
      override def sellstartdate = Field[TypoLocalDateTime, ProductRow](_path, "sellstartdate", Some("text"), Some("timestamp"), x => x.sellstartdate, (row, value) => row.copy(sellstartdate = value))
      override def sellenddate = OptField[TypoLocalDateTime, ProductRow](_path, "sellenddate", Some("text"), Some("timestamp"), x => x.sellenddate, (row, value) => row.copy(sellenddate = value))
      override def discontinueddate = OptField[TypoLocalDateTime, ProductRow](_path, "discontinueddate", Some("text"), Some("timestamp"), x => x.discontinueddate, (row, value) => row.copy(discontinueddate = value))
      override def rowguid = Field[TypoUUID, ProductRow](_path, "rowguid", None, Some("uuid"), x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, ProductRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, ProductRow]] =
      List[FieldLikeNoHkt[?, ProductRow]](fields.productid, fields.name, fields.productnumber, fields.makeflag, fields.finishedgoodsflag, fields.color, fields.safetystocklevel, fields.reorderpoint, fields.standardcost, fields.listprice, fields.size, fields.sizeunitmeasurecode, fields.weightunitmeasurecode, fields.weight, fields.daystomanufacture, fields.productline, fields.`class`, fields.style, fields.productsubcategoryid, fields.productmodelid, fields.sellstartdate, fields.sellenddate, fields.discontinueddate, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
