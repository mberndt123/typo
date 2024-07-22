/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.sp;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.person.countryregion.CountryregionId;
import adventureworks.person.stateprovince.StateprovinceId;
import adventureworks.public.Flag;
import adventureworks.public.Name;
import adventureworks.sales.salesterritory.SalesterritoryId;
import typo.dsl.Path;
import typo.dsl.SqlExpr.Field;
import typo.dsl.SqlExpr.FieldLike;
import typo.dsl.Structure.Relation;

trait SpViewFields {
  def id: Field[StateprovinceId, SpViewRow]
  def stateprovinceid: Field[StateprovinceId, SpViewRow]
  def stateprovincecode: Field[/* bpchar, max 3 chars */ String, SpViewRow]
  def countryregioncode: Field[CountryregionId, SpViewRow]
  def isonlystateprovinceflag: Field[Flag, SpViewRow]
  def name: Field[Name, SpViewRow]
  def territoryid: Field[SalesterritoryId, SpViewRow]
  def rowguid: Field[TypoUUID, SpViewRow]
  def modifieddate: Field[TypoLocalDateTime, SpViewRow]
}

object SpViewFields {
  lazy val structure: Relation[SpViewFields, SpViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[SpViewFields, SpViewRow] {
  
    override lazy val fields: SpViewFields = new SpViewFields {
      override def id = Field[StateprovinceId, SpViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def stateprovinceid = Field[StateprovinceId, SpViewRow](_path, "stateprovinceid", None, None, x => x.stateprovinceid, (row, value) => row.copy(stateprovinceid = value))
      override def stateprovincecode = Field[/* bpchar, max 3 chars */ String, SpViewRow](_path, "stateprovincecode", None, None, x => x.stateprovincecode, (row, value) => row.copy(stateprovincecode = value))
      override def countryregioncode = Field[CountryregionId, SpViewRow](_path, "countryregioncode", None, None, x => x.countryregioncode, (row, value) => row.copy(countryregioncode = value))
      override def isonlystateprovinceflag = Field[Flag, SpViewRow](_path, "isonlystateprovinceflag", None, None, x => x.isonlystateprovinceflag, (row, value) => row.copy(isonlystateprovinceflag = value))
      override def name = Field[Name, SpViewRow](_path, "name", None, None, x => x.name, (row, value) => row.copy(name = value))
      override def territoryid = Field[SalesterritoryId, SpViewRow](_path, "territoryid", None, None, x => x.territoryid, (row, value) => row.copy(territoryid = value))
      override def rowguid = Field[TypoUUID, SpViewRow](_path, "rowguid", None, None, x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, SpViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, SpViewRow]] =
      List[FieldLike[?, SpViewRow]](fields.id, fields.stateprovinceid, fields.stateprovincecode, fields.countryregioncode, fields.isonlystateprovinceflag, fields.name, fields.territoryid, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
