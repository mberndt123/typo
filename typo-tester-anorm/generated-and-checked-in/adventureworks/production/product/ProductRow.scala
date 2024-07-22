/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.product;

import adventureworks.Text;
import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoShort;
import adventureworks.customtypes.TypoUUID;
import adventureworks.production.productmodel.ProductmodelId;
import adventureworks.production.productsubcategory.ProductsubcategoryId;
import adventureworks.production.unitmeasure.UnitmeasureId;
import adventureworks.public.Flag;
import adventureworks.public.Name;
import anorm.Column;
import anorm.RowParser;
import anorm.Success;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import play.api.libs.json.Writes;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** Table: production.product
  * Products sold or used in the manfacturing of sold products.
  * Primary key: productid
  */
case class ProductRow(
  /** Primary key for Product records.
    * Default: nextval('production.product_productid_seq'::regclass)
    */
  productid: ProductId,
  /** Name of the product. */
  name: Name,
  /** Unique product identification number. */
  productnumber: /* max 25 chars */ String,
  /** 0 = Product is purchased, 1 = Product is manufactured in-house.
    * Default: true
    */
  makeflag: Flag,
  /** 0 = Product is not a salable item. 1 = Product is salable.
    * Default: true
    */
  finishedgoodsflag: Flag,
  /** Product color. */
  color: Option[/* max 15 chars */ String],
  /** Minimum inventory quantity.
    * Constraint CK_Product_SafetyStockLevel affecting columns safetystocklevel: ((safetystocklevel > 0))
    */
  safetystocklevel: TypoShort,
  /** Inventory level that triggers a purchase order or work order.
    * Constraint CK_Product_ReorderPoint affecting columns reorderpoint: ((reorderpoint > 0))
    */
  reorderpoint: TypoShort,
  /** Standard cost of the product.
    * Constraint CK_Product_StandardCost affecting columns standardcost: ((standardcost >= 0.00))
    */
  standardcost: BigDecimal,
  /** Selling price.
    * Constraint CK_Product_ListPrice affecting columns listprice: ((listprice >= 0.00))
    */
  listprice: BigDecimal,
  /** Product size. */
  size: Option[/* max 5 chars */ String],
  /** Unit of measure for Size column.
    * Points to [[adventureworks.production.unitmeasure.UnitmeasureRow.unitmeasurecode]]
    */
  sizeunitmeasurecode: Option[UnitmeasureId],
  /** Unit of measure for Weight column.
    * Points to [[adventureworks.production.unitmeasure.UnitmeasureRow.unitmeasurecode]]
    */
  weightunitmeasurecode: Option[UnitmeasureId],
  /** Product weight.
    * Constraint CK_Product_Weight affecting columns weight: ((weight > 0.00))
    */
  weight: Option[BigDecimal],
  /** Number of days required to manufacture the product.
    * Constraint CK_Product_DaysToManufacture affecting columns daystomanufacture: ((daystomanufacture >= 0))
    */
  daystomanufacture: Int,
  /** R = Road, M = Mountain, T = Touring, S = Standard
    * Constraint CK_Product_ProductLine affecting columns productline: (((upper((productline)::text) = ANY (ARRAY['S'::text, 'T'::text, 'M'::text, 'R'::text])) OR (productline IS NULL)))
    */
  productline: Option[/* bpchar, max 2 chars */ String],
  /** H = High, M = Medium, L = Low
    * Constraint CK_Product_Class affecting columns class: (((upper((class)::text) = ANY (ARRAY['L'::text, 'M'::text, 'H'::text])) OR (class IS NULL)))
    */
  `class`: Option[/* bpchar, max 2 chars */ String],
  /** W = Womens, M = Mens, U = Universal
    * Constraint CK_Product_Style affecting columns style: (((upper((style)::text) = ANY (ARRAY['W'::text, 'M'::text, 'U'::text])) OR (style IS NULL)))
    */
  style: Option[/* bpchar, max 2 chars */ String],
  /** Product is a member of this product subcategory. Foreign key to ProductSubCategory.ProductSubCategoryID.
    * Points to [[adventureworks.production.productsubcategory.ProductsubcategoryRow.productsubcategoryid]]
    */
  productsubcategoryid: Option[ProductsubcategoryId],
  /** Product is a member of this product model. Foreign key to ProductModel.ProductModelID.
    * Points to [[adventureworks.production.productmodel.ProductmodelRow.productmodelid]]
    */
  productmodelid: Option[ProductmodelId],
  /** Date the product was available for sale.
    * Constraint CK_Product_SellEndDate affecting columns sellenddate, sellstartdate: (((sellenddate >= sellstartdate) OR (sellenddate IS NULL)))
    */
  sellstartdate: TypoLocalDateTime,
  /** Date the product was no longer available for sale.
    * Constraint CK_Product_SellEndDate affecting columns sellenddate, sellstartdate: (((sellenddate >= sellstartdate) OR (sellenddate IS NULL)))
    */
  sellenddate: Option[TypoLocalDateTime],
  /** Date the product was discontinued. */
  discontinueddate: Option[TypoLocalDateTime],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
) {
  def id: ProductId = productid
  def toUnsavedRow(
    productid: Defaulted[ProductId],
    makeflag: Defaulted[Flag] = Defaulted.Provided(this.makeflag),
    finishedgoodsflag: Defaulted[Flag] = Defaulted.Provided(this.finishedgoodsflag),
    rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid),
    modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)
  ): ProductRowUnsaved = {
    new ProductRowUnsaved(
      name,
      productnumber,
      color,
      safetystocklevel,
      reorderpoint,
      standardcost,
      listprice,
      size,
      sizeunitmeasurecode,
      weightunitmeasurecode,
      weight,
      daystomanufacture,
      productline,
      `class`,
      style,
      productsubcategoryid,
      productmodelid,
      sellstartdate,
      sellenddate,
      discontinueddate,
      productid,
      makeflag,
      finishedgoodsflag,
      rowguid,
      modifieddate
    )
  }
}

object ProductRow {
  implicit lazy val reads: Reads[ProductRow] = {
    Reads[ProductRow](json => JsResult.fromTry(
        Try(
          ProductRow(
            productid = json.\("productid").as(ProductId.reads),
            name = json.\("name").as(Name.reads),
            productnumber = json.\("productnumber").as(Reads.StringReads),
            makeflag = json.\("makeflag").as(Flag.reads),
            finishedgoodsflag = json.\("finishedgoodsflag").as(Flag.reads),
            color = json.\("color").toOption.map(_.as(Reads.StringReads)),
            safetystocklevel = json.\("safetystocklevel").as(TypoShort.reads),
            reorderpoint = json.\("reorderpoint").as(TypoShort.reads),
            standardcost = json.\("standardcost").as(Reads.bigDecReads),
            listprice = json.\("listprice").as(Reads.bigDecReads),
            size = json.\("size").toOption.map(_.as(Reads.StringReads)),
            sizeunitmeasurecode = json.\("sizeunitmeasurecode").toOption.map(_.as(UnitmeasureId.reads)),
            weightunitmeasurecode = json.\("weightunitmeasurecode").toOption.map(_.as(UnitmeasureId.reads)),
            weight = json.\("weight").toOption.map(_.as(Reads.bigDecReads)),
            daystomanufacture = json.\("daystomanufacture").as(Reads.IntReads),
            productline = json.\("productline").toOption.map(_.as(Reads.StringReads)),
            `class` = json.\("class").toOption.map(_.as(Reads.StringReads)),
            style = json.\("style").toOption.map(_.as(Reads.StringReads)),
            productsubcategoryid = json.\("productsubcategoryid").toOption.map(_.as(ProductsubcategoryId.reads)),
            productmodelid = json.\("productmodelid").toOption.map(_.as(ProductmodelId.reads)),
            sellstartdate = json.\("sellstartdate").as(TypoLocalDateTime.reads),
            sellenddate = json.\("sellenddate").toOption.map(_.as(TypoLocalDateTime.reads)),
            discontinueddate = json.\("discontinueddate").toOption.map(_.as(TypoLocalDateTime.reads)),
            rowguid = json.\("rowguid").as(TypoUUID.reads),
            modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
          )
        )
      ),
    )
  }
  def rowParser(idx: Int): RowParser[ProductRow] = {
    RowParser[ProductRow] { row =>
      Success(
        ProductRow(
          productid = row(idx + 0)(ProductId.column),
          name = row(idx + 1)(Name.column),
          productnumber = row(idx + 2)(Column.columnToString),
          makeflag = row(idx + 3)(Flag.column),
          finishedgoodsflag = row(idx + 4)(Flag.column),
          color = row(idx + 5)(Column.columnToOption(Column.columnToString)),
          safetystocklevel = row(idx + 6)(TypoShort.column),
          reorderpoint = row(idx + 7)(TypoShort.column),
          standardcost = row(idx + 8)(Column.columnToScalaBigDecimal),
          listprice = row(idx + 9)(Column.columnToScalaBigDecimal),
          size = row(idx + 10)(Column.columnToOption(Column.columnToString)),
          sizeunitmeasurecode = row(idx + 11)(Column.columnToOption(UnitmeasureId.column)),
          weightunitmeasurecode = row(idx + 12)(Column.columnToOption(UnitmeasureId.column)),
          weight = row(idx + 13)(Column.columnToOption(Column.columnToScalaBigDecimal)),
          daystomanufacture = row(idx + 14)(Column.columnToInt),
          productline = row(idx + 15)(Column.columnToOption(Column.columnToString)),
          `class` = row(idx + 16)(Column.columnToOption(Column.columnToString)),
          style = row(idx + 17)(Column.columnToOption(Column.columnToString)),
          productsubcategoryid = row(idx + 18)(Column.columnToOption(ProductsubcategoryId.column)),
          productmodelid = row(idx + 19)(Column.columnToOption(ProductmodelId.column)),
          sellstartdate = row(idx + 20)(TypoLocalDateTime.column),
          sellenddate = row(idx + 21)(Column.columnToOption(TypoLocalDateTime.column)),
          discontinueddate = row(idx + 22)(Column.columnToOption(TypoLocalDateTime.column)),
          rowguid = row(idx + 23)(TypoUUID.column),
          modifieddate = row(idx + 24)(TypoLocalDateTime.column)
        )
      )
    }
  }
  implicit lazy val text: Text[ProductRow] = {
    Text.instance[ProductRow]{ (row, sb) =>
      ProductId.text.unsafeEncode(row.productid, sb)
      sb.append(Text.DELIMETER)
      Name.text.unsafeEncode(row.name, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.productnumber, sb)
      sb.append(Text.DELIMETER)
      Flag.text.unsafeEncode(row.makeflag, sb)
      sb.append(Text.DELIMETER)
      Flag.text.unsafeEncode(row.finishedgoodsflag, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.color, sb)
      sb.append(Text.DELIMETER)
      TypoShort.text.unsafeEncode(row.safetystocklevel, sb)
      sb.append(Text.DELIMETER)
      TypoShort.text.unsafeEncode(row.reorderpoint, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.standardcost, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.listprice, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.size, sb)
      sb.append(Text.DELIMETER)
      Text.option(UnitmeasureId.text).unsafeEncode(row.sizeunitmeasurecode, sb)
      sb.append(Text.DELIMETER)
      Text.option(UnitmeasureId.text).unsafeEncode(row.weightunitmeasurecode, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.bigDecimalInstance).unsafeEncode(row.weight, sb)
      sb.append(Text.DELIMETER)
      Text.intInstance.unsafeEncode(row.daystomanufacture, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.productline, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.`class`, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.style, sb)
      sb.append(Text.DELIMETER)
      Text.option(ProductsubcategoryId.text).unsafeEncode(row.productsubcategoryid, sb)
      sb.append(Text.DELIMETER)
      Text.option(ProductmodelId.text).unsafeEncode(row.productmodelid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.sellstartdate, sb)
      sb.append(Text.DELIMETER)
      Text.option(TypoLocalDateTime.text).unsafeEncode(row.sellenddate, sb)
      sb.append(Text.DELIMETER)
      Text.option(TypoLocalDateTime.text).unsafeEncode(row.discontinueddate, sb)
      sb.append(Text.DELIMETER)
      TypoUUID.text.unsafeEncode(row.rowguid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    }
  }
  implicit lazy val writes: OWrites[ProductRow] = {
    OWrites[ProductRow](o =>
      new JsObject(ListMap[String, JsValue](
        "productid" -> ProductId.writes.writes(o.productid),
        "name" -> Name.writes.writes(o.name),
        "productnumber" -> Writes.StringWrites.writes(o.productnumber),
        "makeflag" -> Flag.writes.writes(o.makeflag),
        "finishedgoodsflag" -> Flag.writes.writes(o.finishedgoodsflag),
        "color" -> Writes.OptionWrites(Writes.StringWrites).writes(o.color),
        "safetystocklevel" -> TypoShort.writes.writes(o.safetystocklevel),
        "reorderpoint" -> TypoShort.writes.writes(o.reorderpoint),
        "standardcost" -> Writes.BigDecimalWrites.writes(o.standardcost),
        "listprice" -> Writes.BigDecimalWrites.writes(o.listprice),
        "size" -> Writes.OptionWrites(Writes.StringWrites).writes(o.size),
        "sizeunitmeasurecode" -> Writes.OptionWrites(UnitmeasureId.writes).writes(o.sizeunitmeasurecode),
        "weightunitmeasurecode" -> Writes.OptionWrites(UnitmeasureId.writes).writes(o.weightunitmeasurecode),
        "weight" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.weight),
        "daystomanufacture" -> Writes.IntWrites.writes(o.daystomanufacture),
        "productline" -> Writes.OptionWrites(Writes.StringWrites).writes(o.productline),
        "class" -> Writes.OptionWrites(Writes.StringWrites).writes(o.`class`),
        "style" -> Writes.OptionWrites(Writes.StringWrites).writes(o.style),
        "productsubcategoryid" -> Writes.OptionWrites(ProductsubcategoryId.writes).writes(o.productsubcategoryid),
        "productmodelid" -> Writes.OptionWrites(ProductmodelId.writes).writes(o.productmodelid),
        "sellstartdate" -> TypoLocalDateTime.writes.writes(o.sellstartdate),
        "sellenddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.sellenddate),
        "discontinueddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.discontinueddate),
        "rowguid" -> TypoUUID.writes.writes(o.rowguid),
        "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
      ))
    )
  }
}