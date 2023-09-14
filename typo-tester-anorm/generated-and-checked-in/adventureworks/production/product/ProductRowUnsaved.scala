/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `production.product` which has not been persisted yet */
case class ProductRowUnsaved(
  /** Name of the product. */
  name: Name,
  /** Unique product identification number. */
  productnumber: /* max 25 chars */ String,
  /** Product color. */
  color: Option[/* max 15 chars */ String],
  /** Minimum inventory quantity.
      Constraint CK_Product_SafetyStockLevel affecting columns "safetystocklevel":  ((safetystocklevel > 0)) */
  safetystocklevel: TypoShort,
  /** Inventory level that triggers a purchase order or work order.
      Constraint CK_Product_ReorderPoint affecting columns "reorderpoint":  ((reorderpoint > 0)) */
  reorderpoint: TypoShort,
  /** Standard cost of the product.
      Constraint CK_Product_StandardCost affecting columns "standardcost":  ((standardcost >= 0.00)) */
  standardcost: BigDecimal,
  /** Selling price.
      Constraint CK_Product_ListPrice affecting columns "listprice":  ((listprice >= 0.00)) */
  listprice: BigDecimal,
  /** Product size. */
  size: Option[/* max 5 chars */ String],
  /** Unit of measure for Size column.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  sizeunitmeasurecode: Option[UnitmeasureId],
  /** Unit of measure for Weight column.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  weightunitmeasurecode: Option[UnitmeasureId],
  /** Product weight.
      Constraint CK_Product_Weight affecting columns "weight":  ((weight > 0.00)) */
  weight: Option[BigDecimal],
  /** Number of days required to manufacture the product.
      Constraint CK_Product_DaysToManufacture affecting columns "daystomanufacture":  ((daystomanufacture >= 0)) */
  daystomanufacture: Int,
  /** R = Road, M = Mountain, T = Touring, S = Standard
      Constraint CK_Product_ProductLine affecting columns "productline":  (((upper((productline)::text) = ANY (ARRAY['S'::text, 'T'::text, 'M'::text, 'R'::text])) OR (productline IS NULL))) */
  productline: Option[/* bpchar, max 2 chars */ String],
  /** H = High, M = Medium, L = Low
      Constraint CK_Product_Class affecting columns "class":  (((upper((class)::text) = ANY (ARRAY['L'::text, 'M'::text, 'H'::text])) OR (class IS NULL))) */
  `class`: Option[/* bpchar, max 2 chars */ String],
  /** W = Womens, M = Mens, U = Universal
      Constraint CK_Product_Style affecting columns "style":  (((upper((style)::text) = ANY (ARRAY['W'::text, 'M'::text, 'U'::text])) OR (style IS NULL))) */
  style: Option[/* bpchar, max 2 chars */ String],
  /** Product is a member of this product subcategory. Foreign key to ProductSubCategory.ProductSubCategoryID.
      Points to [[productsubcategory.ProductsubcategoryRow.productsubcategoryid]] */
  productsubcategoryid: Option[ProductsubcategoryId],
  /** Product is a member of this product model. Foreign key to ProductModel.ProductModelID.
      Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Date the product was available for sale.
      Constraint CK_Product_SellEndDate affecting columns "sellenddate", "sellstartdate":  (((sellenddate >= sellstartdate) OR (sellenddate IS NULL))) */
  sellstartdate: TypoLocalDateTime,
  /** Date the product was no longer available for sale.
      Constraint CK_Product_SellEndDate affecting columns "sellenddate", "sellstartdate":  (((sellenddate >= sellstartdate) OR (sellenddate IS NULL))) */
  sellenddate: Option[TypoLocalDateTime],
  /** Date the product was discontinued. */
  discontinueddate: Option[TypoLocalDateTime],
  /** Default: nextval('production.product_productid_seq'::regclass)
      Primary key for Product records. */
  productid: Defaulted[ProductId] = Defaulted.UseDefault,
  /** Default: true
      0 = Product is purchased, 1 = Product is manufactured in-house. */
  makeflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: true
      0 = Product is not a salable item. 1 = Product is salable. */
  finishedgoodsflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productidDefault: => ProductId, makeflagDefault: => Flag, finishedgoodsflagDefault: => Flag, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): ProductRow =
    ProductRow(
      name = name,
      productnumber = productnumber,
      color = color,
      safetystocklevel = safetystocklevel,
      reorderpoint = reorderpoint,
      standardcost = standardcost,
      listprice = listprice,
      size = size,
      sizeunitmeasurecode = sizeunitmeasurecode,
      weightunitmeasurecode = weightunitmeasurecode,
      weight = weight,
      daystomanufacture = daystomanufacture,
      productline = productline,
      `class` = `class`,
      style = style,
      productsubcategoryid = productsubcategoryid,
      productmodelid = productmodelid,
      sellstartdate = sellstartdate,
      sellenddate = sellenddate,
      discontinueddate = discontinueddate,
      productid = productid match {
                    case Defaulted.UseDefault => productidDefault
                    case Defaulted.Provided(value) => value
                  },
      makeflag = makeflag match {
                   case Defaulted.UseDefault => makeflagDefault
                   case Defaulted.Provided(value) => value
                 },
      finishedgoodsflag = finishedgoodsflag match {
                            case Defaulted.UseDefault => finishedgoodsflagDefault
                            case Defaulted.Provided(value) => value
                          },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductRowUnsaved {
  implicit lazy val reads: Reads[ProductRowUnsaved] = Reads[ProductRowUnsaved](json => JsResult.fromTry(
      Try(
        ProductRowUnsaved(
          name = json.\("name").as(Name.reads),
          productnumber = json.\("productnumber").as(Reads.StringReads),
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
          productid = json.\("productid").as(Defaulted.reads(ProductId.reads)),
          makeflag = json.\("makeflag").as(Defaulted.reads(Flag.reads)),
          finishedgoodsflag = json.\("finishedgoodsflag").as(Defaulted.reads(Flag.reads)),
          rowguid = json.\("rowguid").as(Defaulted.reads(TypoUUID.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[ProductRowUnsaved] = OWrites[ProductRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Name.writes.writes(o.name),
      "productnumber" -> Writes.StringWrites.writes(o.productnumber),
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
      "productid" -> Defaulted.writes(ProductId.writes).writes(o.productid),
      "makeflag" -> Defaulted.writes(Flag.writes).writes(o.makeflag),
      "finishedgoodsflag" -> Defaulted.writes(Flag.writes).writes(o.finishedgoodsflag),
      "rowguid" -> Defaulted.writes(TypoUUID.writes).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
