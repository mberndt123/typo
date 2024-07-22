/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.purchaseorderdetail;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoShort;
import adventureworks.production.product.ProductFields;
import adventureworks.production.product.ProductId;
import adventureworks.production.product.ProductRow;
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderFields;
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId;
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderRow;
import anorm.ParameterMetaData;
import anorm.ToParameterValue;
import typo.dsl.ForeignKey;
import typo.dsl.Path;
import typo.dsl.SqlExpr;
import typo.dsl.SqlExpr.CompositeIn;
import typo.dsl.SqlExpr.CompositeIn.TuplePart;
import typo.dsl.SqlExpr.Const.As.as;
import typo.dsl.SqlExpr.Field;
import typo.dsl.SqlExpr.FieldLike;
import typo.dsl.SqlExpr.IdField;
import typo.dsl.Structure.Relation;

trait PurchaseorderdetailFields {
  def purchaseorderid: IdField[PurchaseorderheaderId, PurchaseorderdetailRow]
  def purchaseorderdetailid: IdField[Int, PurchaseorderdetailRow]
  def duedate: Field[TypoLocalDateTime, PurchaseorderdetailRow]
  def orderqty: Field[TypoShort, PurchaseorderdetailRow]
  def productid: Field[ProductId, PurchaseorderdetailRow]
  def unitprice: Field[BigDecimal, PurchaseorderdetailRow]
  def receivedqty: Field[BigDecimal, PurchaseorderdetailRow]
  def rejectedqty: Field[BigDecimal, PurchaseorderdetailRow]
  def modifieddate: Field[TypoLocalDateTime, PurchaseorderdetailRow]
  def fkProductionProduct: ForeignKey[ProductFields, ProductRow] =
    ForeignKey[ProductFields, ProductRow]("purchasing.FK_PurchaseOrderDetail_Product_ProductID", Nil)
      .withColumnPair(productid, _.productid)
  def fkPurchaseorderheader: ForeignKey[PurchaseorderheaderFields, PurchaseorderheaderRow] =
    ForeignKey[PurchaseorderheaderFields, PurchaseorderheaderRow]("purchasing.FK_PurchaseOrderDetail_PurchaseOrderHeader_PurchaseOrderID", Nil)
      .withColumnPair(purchaseorderid, _.purchaseorderid)
  def compositeIdIs(compositeId: PurchaseorderdetailId): SqlExpr[Boolean] =
    purchaseorderid.isEqual(compositeId.purchaseorderid).and(purchaseorderdetailid.isEqual(compositeId.purchaseorderdetailid))
  def compositeIdIn(compositeIds: Array[PurchaseorderdetailId]): SqlExpr[Boolean] =
    new CompositeIn(compositeIds)(TuplePart[PurchaseorderdetailId](purchaseorderid)(_.purchaseorderid)(using as[Array[PurchaseorderheaderId]](ToParameterValue(null, PurchaseorderheaderId.arrayToStatement), adventureworks.arrayParameterMetaData(PurchaseorderheaderId.parameterMetadata)), implicitly), TuplePart[PurchaseorderdetailId](purchaseorderdetailid)(_.purchaseorderdetailid)(using as[Array[Int]](ToParameterValue(null, adventureworks.IntArrayToStatement), adventureworks.arrayParameterMetaData(ParameterMetaData.IntParameterMetaData)), implicitly))
  
}

object PurchaseorderdetailFields {
  lazy val structure: Relation[PurchaseorderdetailFields, PurchaseorderdetailRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[PurchaseorderdetailFields, PurchaseorderdetailRow] {
  
    override lazy val fields: PurchaseorderdetailFields = new PurchaseorderdetailFields {
      override def purchaseorderid = IdField[PurchaseorderheaderId, PurchaseorderdetailRow](_path, "purchaseorderid", None, Some("int4"), x => x.purchaseorderid, (row, value) => row.copy(purchaseorderid = value))
      override def purchaseorderdetailid = IdField[Int, PurchaseorderdetailRow](_path, "purchaseorderdetailid", None, Some("int4"), x => x.purchaseorderdetailid, (row, value) => row.copy(purchaseorderdetailid = value))
      override def duedate = Field[TypoLocalDateTime, PurchaseorderdetailRow](_path, "duedate", Some("text"), Some("timestamp"), x => x.duedate, (row, value) => row.copy(duedate = value))
      override def orderqty = Field[TypoShort, PurchaseorderdetailRow](_path, "orderqty", None, Some("int2"), x => x.orderqty, (row, value) => row.copy(orderqty = value))
      override def productid = Field[ProductId, PurchaseorderdetailRow](_path, "productid", None, Some("int4"), x => x.productid, (row, value) => row.copy(productid = value))
      override def unitprice = Field[BigDecimal, PurchaseorderdetailRow](_path, "unitprice", None, Some("numeric"), x => x.unitprice, (row, value) => row.copy(unitprice = value))
      override def receivedqty = Field[BigDecimal, PurchaseorderdetailRow](_path, "receivedqty", None, Some("numeric"), x => x.receivedqty, (row, value) => row.copy(receivedqty = value))
      override def rejectedqty = Field[BigDecimal, PurchaseorderdetailRow](_path, "rejectedqty", None, Some("numeric"), x => x.rejectedqty, (row, value) => row.copy(rejectedqty = value))
      override def modifieddate = Field[TypoLocalDateTime, PurchaseorderdetailRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, PurchaseorderdetailRow]] =
      List[FieldLike[?, PurchaseorderdetailRow]](fields.purchaseorderid, fields.purchaseorderdetailid, fields.duedate, fields.orderqty, fields.productid, fields.unitprice, fields.receivedqty, fields.rejectedqty, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
