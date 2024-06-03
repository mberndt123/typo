/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.public.Name
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `production.productsubcategory` which has not been persisted yet */
case class ProductsubcategoryRowUnsaved(
  /** Product category identification number. Foreign key to ProductCategory.ProductCategoryID.
      Points to [[productcategory.ProductcategoryRow.productcategoryid]] */
  productcategoryid: ProductcategoryId,
  /** Subcategory description. */
  name: Name,
  /** Default: nextval('production.productsubcategory_productsubcategoryid_seq'::regclass)
      Primary key for ProductSubcategory records. */
  productsubcategoryid: Defaulted[ProductsubcategoryId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productsubcategoryidDefault: => ProductsubcategoryId, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): ProductsubcategoryRow =
    ProductsubcategoryRow(
      productcategoryid = productcategoryid,
      name = name,
      productsubcategoryid = productsubcategoryid match {
                               case Defaulted.UseDefault => productsubcategoryidDefault
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
object ProductsubcategoryRowUnsaved {
  implicit lazy val reads: Reads[ProductsubcategoryRowUnsaved] = Reads[ProductsubcategoryRowUnsaved](json => JsResult.fromTry(
      Try(
        ProductsubcategoryRowUnsaved(
          productcategoryid = json.\("productcategoryid").as(ProductcategoryId.reads),
          name = json.\("name").as(Name.reads),
          productsubcategoryid = json.\("productsubcategoryid").as(Defaulted.reads(ProductsubcategoryId.reads)),
          rowguid = json.\("rowguid").as(Defaulted.reads(TypoUUID.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val text: Text[ProductsubcategoryRowUnsaved] = Text.instance[ProductsubcategoryRowUnsaved]{ (row, sb) =>
    ProductcategoryId.text.unsafeEncode(row.productcategoryid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(ProductsubcategoryId.text).unsafeEncode(row.productsubcategoryid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[ProductsubcategoryRowUnsaved] = OWrites[ProductsubcategoryRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "productcategoryid" -> ProductcategoryId.writes.writes(o.productcategoryid),
      "name" -> Name.writes.writes(o.name),
      "productsubcategoryid" -> Defaulted.writes(ProductsubcategoryId.writes).writes(o.productsubcategoryid),
      "rowguid" -> Defaulted.writes(TypoUUID.writes).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
