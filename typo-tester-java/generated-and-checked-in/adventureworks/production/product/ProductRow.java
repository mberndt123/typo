/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.product;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoShort;
import adventureworks.customtypes.TypoUUID;
import adventureworks.production.productmodel.ProductmodelId;
import adventureworks.production.productsubcategory.ProductsubcategoryId;
import adventureworks.production.unitmeasure.UnitmeasureId;
import adventureworks.public_.Flag;
import adventureworks.public_.Name;
import java.math.BigDecimal;
import java.util.Optional;

/** Table: production.product
  * Products sold or used in the manfacturing of sold products.
  * Primary key: productid
  */
public record ProductRow(
  /** Primary key for Product records.
    * Default: nextval('production.product_productid_seq'::regclass)
    */
  ProductId productid,
  /** Name of the product. */
  Name name,
  /** Unique product identification number. */
  /* max 25 chars */ String productnumber,
  /** 0 = Product is purchased, 1 = Product is manufactured in-house.
    * Default: true
    */
  Flag makeflag,
  /** 0 = Product is not a salable item. 1 = Product is salable.
    * Default: true
    */
  Flag finishedgoodsflag,
  /** Product color. */
  Optional</* max 15 chars */ String> color,
  /** Minimum inventory quantity.
    * Constraint CK_Product_SafetyStockLevel affecting columns safetystocklevel: ((safetystocklevel > 0))
    */
  TypoShort safetystocklevel,
  /** Inventory level that triggers a purchase order or work order.
    * Constraint CK_Product_ReorderPoint affecting columns reorderpoint: ((reorderpoint > 0))
    */
  TypoShort reorderpoint,
  /** Standard cost of the product.
    * Constraint CK_Product_StandardCost affecting columns standardcost: ((standardcost >= 0.00))
    */
  BigDecimal standardcost,
  /** Selling price.
    * Constraint CK_Product_ListPrice affecting columns listprice: ((listprice >= 0.00))
    */
  BigDecimal listprice,
  /** Product size. */
  Optional</* max 5 chars */ String> size,
  /** Unit of measure for Size column.
    * Points to {@link adventureworks.production.unitmeasure.UnitmeasureRow.unitmeasurecode}
    */
  Optional<UnitmeasureId> sizeunitmeasurecode,
  /** Unit of measure for Weight column.
    * Points to {@link adventureworks.production.unitmeasure.UnitmeasureRow.unitmeasurecode}
    */
  Optional<UnitmeasureId> weightunitmeasurecode,
  /** Product weight.
    * Constraint CK_Product_Weight affecting columns weight: ((weight > 0.00))
    */
  Optional<BigDecimal> weight,
  /** Number of days required to manufacture the product.
    * Constraint CK_Product_DaysToManufacture affecting columns daystomanufacture: ((daystomanufacture >= 0))
    */
  Integer daystomanufacture,
  /** R = Road, M = Mountain, T = Touring, S = Standard
    * Constraint CK_Product_ProductLine affecting columns productline: (((upper((productline)::text) = ANY (ARRAY['S'::text, 'T'::text, 'M'::text, 'R'::text])) OR (productline IS NULL)))
    */
  Optional</* bpchar, max 2 chars */ String> productline,
  /** H = High, M = Medium, L = Low
    * Constraint CK_Product_Class affecting columns class: (((upper((class)::text) = ANY (ARRAY['L'::text, 'M'::text, 'H'::text])) OR (class IS NULL)))
    */
  Optional</* bpchar, max 2 chars */ String> class_,
  /** W = Womens, M = Mens, U = Universal
    * Constraint CK_Product_Style affecting columns style: (((upper((style)::text) = ANY (ARRAY['W'::text, 'M'::text, 'U'::text])) OR (style IS NULL)))
    */
  Optional</* bpchar, max 2 chars */ String> style,
  /** Product is a member of this product subcategory. Foreign key to ProductSubCategory.ProductSubCategoryID.
    * Points to {@link adventureworks.production.productsubcategory.ProductsubcategoryRow.productsubcategoryid}
    */
  Optional<ProductsubcategoryId> productsubcategoryid,
  /** Product is a member of this product model. Foreign key to ProductModel.ProductModelID.
    * Points to {@link adventureworks.production.productmodel.ProductmodelRow.productmodelid}
    */
  Optional<ProductmodelId> productmodelid,
  /** Date the product was available for sale.
    * Constraint CK_Product_SellEndDate affecting columns sellenddate, sellstartdate: (((sellenddate >= sellstartdate) OR (sellenddate IS NULL)))
    */
  TypoLocalDateTime sellstartdate,
  /** Date the product was no longer available for sale.
    * Constraint CK_Product_SellEndDate affecting columns sellenddate, sellstartdate: (((sellenddate >= sellstartdate) OR (sellenddate IS NULL)))
    */
  Optional<TypoLocalDateTime> sellenddate,
  /** Date the product was discontinued. */
  Optional<TypoLocalDateTime> discontinueddate,
  /** Default: uuid_generate_v1() */
  TypoUUID rowguid,
  /** Default: now() */
  TypoLocalDateTime modifieddate
) {
  public ProductId id() {
    return productid;
  };
  public ProductRowUnsaved toUnsavedRow(
                                         Defaulted<ProductId> productid,
                                         Defaulted<Flag> makeflag,
                                         Defaulted<Flag> finishedgoodsflag,
                                         Defaulted<TypoUUID> rowguid,
                                         Defaulted<TypoLocalDateTime> modifieddate
                                       ) {
    return new ProductRowUnsaved(name, productnumber, color, safetystocklevel, reorderpoint, standardcost, listprice, size, sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, class_, style, productsubcategoryid, productmodelid, sellstartdate, sellenddate, discontinueddate, productid, makeflag, finishedgoodsflag, rowguid, modifieddate);
  };
}