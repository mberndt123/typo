/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.pch

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait PchViewFields {
  def id: Field[ProductId, PchViewRow]
  def productid: Field[ProductId, PchViewRow]
  def startdate: Field[TypoLocalDateTime, PchViewRow]
  def enddate: OptField[TypoLocalDateTime, PchViewRow]
  def standardcost: Field[BigDecimal, PchViewRow]
  def modifieddate: Field[TypoLocalDateTime, PchViewRow]
}

object PchViewFields {
  lazy val structure: Relation[PchViewFields, PchViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[PchViewFields, PchViewRow] {
  
    override lazy val fields: PchViewFields = new PchViewFields {
      override def id = Field[ProductId, PchViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def productid = Field[ProductId, PchViewRow](_path, "productid", None, None, x => x.productid, (row, value) => row.copy(productid = value))
      override def startdate = Field[TypoLocalDateTime, PchViewRow](_path, "startdate", Some("text"), None, x => x.startdate, (row, value) => row.copy(startdate = value))
      override def enddate = OptField[TypoLocalDateTime, PchViewRow](_path, "enddate", Some("text"), None, x => x.enddate, (row, value) => row.copy(enddate = value))
      override def standardcost = Field[BigDecimal, PchViewRow](_path, "standardcost", None, None, x => x.standardcost, (row, value) => row.copy(standardcost = value))
      override def modifieddate = Field[TypoLocalDateTime, PchViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, PchViewRow]] =
      List[FieldLikeNoHkt[?, PchViewRow]](fields.id, fields.productid, fields.startdate, fields.enddate, fields.standardcost, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
