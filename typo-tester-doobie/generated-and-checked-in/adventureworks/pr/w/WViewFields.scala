/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.w

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
import adventureworks.production.workorder.WorkorderId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait WViewFields {
  def id: Field[WorkorderId, WViewRow]
  def workorderid: Field[WorkorderId, WViewRow]
  def productid: Field[ProductId, WViewRow]
  def orderqty: Field[Int, WViewRow]
  def scrappedqty: Field[TypoShort, WViewRow]
  def startdate: Field[TypoLocalDateTime, WViewRow]
  def enddate: OptField[TypoLocalDateTime, WViewRow]
  def duedate: Field[TypoLocalDateTime, WViewRow]
  def scrapreasonid: OptField[ScrapreasonId, WViewRow]
  def modifieddate: Field[TypoLocalDateTime, WViewRow]
}

object WViewFields {
  lazy val structure: Relation[WViewFields, WViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[WViewFields, WViewRow] {
  
    override lazy val fields: WViewFields = new WViewFields {
      override def id = Field[WorkorderId, WViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def workorderid = Field[WorkorderId, WViewRow](_path, "workorderid", None, None, x => x.workorderid, (row, value) => row.copy(workorderid = value))
      override def productid = Field[ProductId, WViewRow](_path, "productid", None, None, x => x.productid, (row, value) => row.copy(productid = value))
      override def orderqty = Field[Int, WViewRow](_path, "orderqty", None, None, x => x.orderqty, (row, value) => row.copy(orderqty = value))
      override def scrappedqty = Field[TypoShort, WViewRow](_path, "scrappedqty", None, None, x => x.scrappedqty, (row, value) => row.copy(scrappedqty = value))
      override def startdate = Field[TypoLocalDateTime, WViewRow](_path, "startdate", Some("text"), None, x => x.startdate, (row, value) => row.copy(startdate = value))
      override def enddate = OptField[TypoLocalDateTime, WViewRow](_path, "enddate", Some("text"), None, x => x.enddate, (row, value) => row.copy(enddate = value))
      override def duedate = Field[TypoLocalDateTime, WViewRow](_path, "duedate", Some("text"), None, x => x.duedate, (row, value) => row.copy(duedate = value))
      override def scrapreasonid = OptField[ScrapreasonId, WViewRow](_path, "scrapreasonid", None, None, x => x.scrapreasonid, (row, value) => row.copy(scrapreasonid = value))
      override def modifieddate = Field[TypoLocalDateTime, WViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, WViewRow]] =
      List[FieldLikeNoHkt[?, WViewRow]](fields.id, fields.workorderid, fields.productid, fields.orderqty, fields.scrappedqty, fields.startdate, fields.enddate, fields.duedate, fields.scrapreasonid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
