/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.sop;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.production.product.ProductId;
import adventureworks.sales.specialoffer.SpecialofferId;
import typo.dsl.Path;
import typo.dsl.SqlExpr.Field;
import typo.dsl.SqlExpr.FieldLike;
import typo.dsl.Structure.Relation;

trait SopViewFields {
  def id: Field[SpecialofferId, SopViewRow]
  def specialofferid: Field[SpecialofferId, SopViewRow]
  def productid: Field[ProductId, SopViewRow]
  def rowguid: Field[TypoUUID, SopViewRow]
  def modifieddate: Field[TypoLocalDateTime, SopViewRow]
}

object SopViewFields {
  lazy val structure: Relation[SopViewFields, SopViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[SopViewFields, SopViewRow] {
  
    override lazy val fields: SopViewFields = new SopViewFields {
      override def id = Field[SpecialofferId, SopViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def specialofferid = Field[SpecialofferId, SopViewRow](_path, "specialofferid", None, None, x => x.specialofferid, (row, value) => row.copy(specialofferid = value))
      override def productid = Field[ProductId, SopViewRow](_path, "productid", None, None, x => x.productid, (row, value) => row.copy(productid = value))
      override def rowguid = Field[TypoUUID, SopViewRow](_path, "rowguid", None, None, x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, SopViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, SopViewRow]] =
      List[FieldLike[?, SopViewRow]](fields.id, fields.specialofferid, fields.productid, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
