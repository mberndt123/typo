/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package p

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PViewStructure[Row](val prefix: Option[String], val extract: Row => PViewRow, val merge: (Row, PViewRow) => Row)
  extends Relation[PViewFields, PViewRow, Row]
    with PViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val productid = new OptField[ProductId, Row](prefix, "productid", None, Some("int4"))(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
  override val name = new OptField[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val productnumber = new OptField[/* max 25 chars */ String, Row](prefix, "productnumber", None, None)(x => extract(x).productnumber, (row, value) => merge(row, extract(row).copy(productnumber = value)))
  override val makeflag = new Field[Flag, Row](prefix, "makeflag", None, Some(""""public"."Flag""""))(x => extract(x).makeflag, (row, value) => merge(row, extract(row).copy(makeflag = value)))
  override val finishedgoodsflag = new Field[Flag, Row](prefix, "finishedgoodsflag", None, Some(""""public"."Flag""""))(x => extract(x).finishedgoodsflag, (row, value) => merge(row, extract(row).copy(finishedgoodsflag = value)))
  override val color = new OptField[/* max 15 chars */ String, Row](prefix, "color", None, None)(x => extract(x).color, (row, value) => merge(row, extract(row).copy(color = value)))
  override val safetystocklevel = new OptField[Int, Row](prefix, "safetystocklevel", None, Some("int2"))(x => extract(x).safetystocklevel, (row, value) => merge(row, extract(row).copy(safetystocklevel = value)))
  override val reorderpoint = new OptField[Int, Row](prefix, "reorderpoint", None, Some("int2"))(x => extract(x).reorderpoint, (row, value) => merge(row, extract(row).copy(reorderpoint = value)))
  override val standardcost = new OptField[BigDecimal, Row](prefix, "standardcost", None, Some("numeric"))(x => extract(x).standardcost, (row, value) => merge(row, extract(row).copy(standardcost = value)))
  override val listprice = new OptField[BigDecimal, Row](prefix, "listprice", None, Some("numeric"))(x => extract(x).listprice, (row, value) => merge(row, extract(row).copy(listprice = value)))
  override val size = new OptField[/* max 5 chars */ String, Row](prefix, "size", None, None)(x => extract(x).size, (row, value) => merge(row, extract(row).copy(size = value)))
  override val sizeunitmeasurecode = new OptField[UnitmeasureId, Row](prefix, "sizeunitmeasurecode", None, Some("bpchar"))(x => extract(x).sizeunitmeasurecode, (row, value) => merge(row, extract(row).copy(sizeunitmeasurecode = value)))
  override val weightunitmeasurecode = new OptField[UnitmeasureId, Row](prefix, "weightunitmeasurecode", None, Some("bpchar"))(x => extract(x).weightunitmeasurecode, (row, value) => merge(row, extract(row).copy(weightunitmeasurecode = value)))
  override val weight = new OptField[BigDecimal, Row](prefix, "weight", None, Some("numeric"))(x => extract(x).weight, (row, value) => merge(row, extract(row).copy(weight = value)))
  override val daystomanufacture = new OptField[Int, Row](prefix, "daystomanufacture", None, Some("int4"))(x => extract(x).daystomanufacture, (row, value) => merge(row, extract(row).copy(daystomanufacture = value)))
  override val productline = new OptField[/* bpchar */ String, Row](prefix, "productline", None, Some("bpchar"))(x => extract(x).productline, (row, value) => merge(row, extract(row).copy(productline = value)))
  override val `class` = new OptField[/* bpchar */ String, Row](prefix, "class", None, Some("bpchar"))(x => extract(x).`class`, (row, value) => merge(row, extract(row).copy(`class` = value)))
  override val style = new OptField[/* bpchar */ String, Row](prefix, "style", None, Some("bpchar"))(x => extract(x).style, (row, value) => merge(row, extract(row).copy(style = value)))
  override val productsubcategoryid = new OptField[ProductsubcategoryId, Row](prefix, "productsubcategoryid", None, Some("int4"))(x => extract(x).productsubcategoryid, (row, value) => merge(row, extract(row).copy(productsubcategoryid = value)))
  override val productmodelid = new OptField[ProductmodelId, Row](prefix, "productmodelid", None, Some("int4"))(x => extract(x).productmodelid, (row, value) => merge(row, extract(row).copy(productmodelid = value)))
  override val sellstartdate = new OptField[TypoLocalDateTime, Row](prefix, "sellstartdate", Some("text"), Some("timestamp"))(x => extract(x).sellstartdate, (row, value) => merge(row, extract(row).copy(sellstartdate = value)))
  override val sellenddate = new OptField[TypoLocalDateTime, Row](prefix, "sellenddate", Some("text"), Some("timestamp"))(x => extract(x).sellenddate, (row, value) => merge(row, extract(row).copy(sellenddate = value)))
  override val discontinueddate = new OptField[TypoLocalDateTime, Row](prefix, "discontinueddate", Some("text"), Some("timestamp"))(x => extract(x).discontinueddate, (row, value) => merge(row, extract(row).copy(discontinueddate = value)))
  override val rowguid = new OptField[UUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, productid, name, productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, size, sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, `class`, style, productsubcategoryid, productmodelid, sellstartdate, sellenddate, discontinueddate, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PViewRow, merge: (NewRow, PViewRow) => NewRow): PViewStructure[NewRow] =
    new PViewStructure(prefix, extract, merge)
}
