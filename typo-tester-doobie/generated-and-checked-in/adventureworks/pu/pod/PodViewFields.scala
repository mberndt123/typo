/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pu.pod

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

trait PodViewFields {
  def id: Field[Int, PodViewRow]
  def purchaseorderid: Field[PurchaseorderheaderId, PodViewRow]
  def purchaseorderdetailid: Field[Int, PodViewRow]
  def duedate: Field[TypoLocalDateTime, PodViewRow]
  def orderqty: Field[TypoShort, PodViewRow]
  def productid: Field[ProductId, PodViewRow]
  def unitprice: Field[BigDecimal, PodViewRow]
  def receivedqty: Field[BigDecimal, PodViewRow]
  def rejectedqty: Field[BigDecimal, PodViewRow]
  def modifieddate: Field[TypoLocalDateTime, PodViewRow]
}

object PodViewFields {
  lazy val structure: Relation[PodViewFields, PodViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[PodViewFields, PodViewRow] {
  
    override lazy val fields: PodViewFields = new PodViewFields {
      override def id = Field[Int, PodViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def purchaseorderid = Field[PurchaseorderheaderId, PodViewRow](_path, "purchaseorderid", None, None, x => x.purchaseorderid, (row, value) => row.copy(purchaseorderid = value))
      override def purchaseorderdetailid = Field[Int, PodViewRow](_path, "purchaseorderdetailid", None, None, x => x.purchaseorderdetailid, (row, value) => row.copy(purchaseorderdetailid = value))
      override def duedate = Field[TypoLocalDateTime, PodViewRow](_path, "duedate", Some("text"), None, x => x.duedate, (row, value) => row.copy(duedate = value))
      override def orderqty = Field[TypoShort, PodViewRow](_path, "orderqty", None, None, x => x.orderqty, (row, value) => row.copy(orderqty = value))
      override def productid = Field[ProductId, PodViewRow](_path, "productid", None, None, x => x.productid, (row, value) => row.copy(productid = value))
      override def unitprice = Field[BigDecimal, PodViewRow](_path, "unitprice", None, None, x => x.unitprice, (row, value) => row.copy(unitprice = value))
      override def receivedqty = Field[BigDecimal, PodViewRow](_path, "receivedqty", None, None, x => x.receivedqty, (row, value) => row.copy(receivedqty = value))
      override def rejectedqty = Field[BigDecimal, PodViewRow](_path, "rejectedqty", None, None, x => x.rejectedqty, (row, value) => row.copy(rejectedqty = value))
      override def modifieddate = Field[TypoLocalDateTime, PodViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, PodViewRow]] =
      List[FieldLikeNoHkt[?, PodViewRow]](fields.id, fields.purchaseorderid, fields.purchaseorderdetailid, fields.duedate, fields.orderqty, fields.productid, fields.unitprice, fields.receivedqty, fields.rejectedqty, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
