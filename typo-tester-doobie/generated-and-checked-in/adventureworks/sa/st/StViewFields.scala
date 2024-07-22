/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.st

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

trait StViewFields {
  def id: Field[SalesterritoryId, StViewRow]
  def territoryid: Field[SalesterritoryId, StViewRow]
  def name: Field[Name, StViewRow]
  def countryregioncode: Field[CountryregionId, StViewRow]
  def group: Field[/* max 50 chars */ String, StViewRow]
  def salesytd: Field[BigDecimal, StViewRow]
  def saleslastyear: Field[BigDecimal, StViewRow]
  def costytd: Field[BigDecimal, StViewRow]
  def costlastyear: Field[BigDecimal, StViewRow]
  def rowguid: Field[TypoUUID, StViewRow]
  def modifieddate: Field[TypoLocalDateTime, StViewRow]
}

object StViewFields {
  lazy val structure: Relation[StViewFields, StViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[StViewFields, StViewRow] {
  
    override lazy val fields: StViewFields = new StViewFields {
      override def id = Field[SalesterritoryId, StViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def territoryid = Field[SalesterritoryId, StViewRow](_path, "territoryid", None, None, x => x.territoryid, (row, value) => row.copy(territoryid = value))
      override def name = Field[Name, StViewRow](_path, "name", None, None, x => x.name, (row, value) => row.copy(name = value))
      override def countryregioncode = Field[CountryregionId, StViewRow](_path, "countryregioncode", None, None, x => x.countryregioncode, (row, value) => row.copy(countryregioncode = value))
      override def group = Field[/* max 50 chars */ String, StViewRow](_path, "group", None, None, x => x.group, (row, value) => row.copy(group = value))
      override def salesytd = Field[BigDecimal, StViewRow](_path, "salesytd", None, None, x => x.salesytd, (row, value) => row.copy(salesytd = value))
      override def saleslastyear = Field[BigDecimal, StViewRow](_path, "saleslastyear", None, None, x => x.saleslastyear, (row, value) => row.copy(saleslastyear = value))
      override def costytd = Field[BigDecimal, StViewRow](_path, "costytd", None, None, x => x.costytd, (row, value) => row.copy(costytd = value))
      override def costlastyear = Field[BigDecimal, StViewRow](_path, "costlastyear", None, None, x => x.costlastyear, (row, value) => row.copy(costlastyear = value))
      override def rowguid = Field[TypoUUID, StViewRow](_path, "rowguid", None, None, x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, StViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, StViewRow]] =
      List[FieldLikeNoHkt[?, StViewRow]](fields.id, fields.territoryid, fields.name, fields.countryregioncode, fields.group, fields.salesytd, fields.saleslastyear, fields.costytd, fields.costlastyear, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
