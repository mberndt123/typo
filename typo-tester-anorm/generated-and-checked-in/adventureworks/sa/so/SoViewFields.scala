/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.so

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.sales.specialoffer.SpecialofferId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLike
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait SoViewFields {
  def id: Field[SpecialofferId, SoViewRow]
  def specialofferid: Field[SpecialofferId, SoViewRow]
  def description: Field[/* max 255 chars */ String, SoViewRow]
  def discountpct: Field[BigDecimal, SoViewRow]
  def `type`: Field[/* max 50 chars */ String, SoViewRow]
  def category: Field[/* max 50 chars */ String, SoViewRow]
  def startdate: Field[TypoLocalDateTime, SoViewRow]
  def enddate: Field[TypoLocalDateTime, SoViewRow]
  def minqty: Field[Int, SoViewRow]
  def maxqty: OptField[Int, SoViewRow]
  def rowguid: Field[TypoUUID, SoViewRow]
  def modifieddate: Field[TypoLocalDateTime, SoViewRow]
}

object SoViewFields {
  lazy val structure: Relation[SoViewFields, SoViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[SoViewFields, SoViewRow] {
  
    override lazy val fields: SoViewFields = new SoViewFields {
      override def id = Field[SpecialofferId, SoViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def specialofferid = Field[SpecialofferId, SoViewRow](_path, "specialofferid", None, None, x => x.specialofferid, (row, value) => row.copy(specialofferid = value))
      override def description = Field[/* max 255 chars */ String, SoViewRow](_path, "description", None, None, x => x.description, (row, value) => row.copy(description = value))
      override def discountpct = Field[BigDecimal, SoViewRow](_path, "discountpct", None, None, x => x.discountpct, (row, value) => row.copy(discountpct = value))
      override def `type` = Field[/* max 50 chars */ String, SoViewRow](_path, "type", None, None, x => x.`type`, (row, value) => row.copy(`type` = value))
      override def category = Field[/* max 50 chars */ String, SoViewRow](_path, "category", None, None, x => x.category, (row, value) => row.copy(category = value))
      override def startdate = Field[TypoLocalDateTime, SoViewRow](_path, "startdate", Some("text"), None, x => x.startdate, (row, value) => row.copy(startdate = value))
      override def enddate = Field[TypoLocalDateTime, SoViewRow](_path, "enddate", Some("text"), None, x => x.enddate, (row, value) => row.copy(enddate = value))
      override def minqty = Field[Int, SoViewRow](_path, "minqty", None, None, x => x.minqty, (row, value) => row.copy(minqty = value))
      override def maxqty = OptField[Int, SoViewRow](_path, "maxqty", None, None, x => x.maxqty, (row, value) => row.copy(maxqty = value))
      override def rowguid = Field[TypoUUID, SoViewRow](_path, "rowguid", None, None, x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, SoViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, SoViewRow]] =
      List[FieldLike[?, SoViewRow]](fields.id, fields.specialofferid, fields.description, fields.discountpct, fields.`type`, fields.category, fields.startdate, fields.enddate, fields.minqty, fields.maxqty, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
