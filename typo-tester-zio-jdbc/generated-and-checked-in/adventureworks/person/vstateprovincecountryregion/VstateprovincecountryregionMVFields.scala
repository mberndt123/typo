/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.vstateprovincecountryregion

import adventureworks.person.countryregion.CountryregionId
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

trait VstateprovincecountryregionMVFields {
  def stateprovinceid: Field[StateprovinceId, VstateprovincecountryregionMVRow]
  def stateprovincecode: Field[/* bpchar, max 3 chars */ String, VstateprovincecountryregionMVRow]
  def isonlystateprovinceflag: Field[Flag, VstateprovincecountryregionMVRow]
  def stateprovincename: Field[Name, VstateprovincecountryregionMVRow]
  def territoryid: Field[SalesterritoryId, VstateprovincecountryregionMVRow]
  def countryregioncode: Field[CountryregionId, VstateprovincecountryregionMVRow]
  def countryregionname: Field[Name, VstateprovincecountryregionMVRow]
}

object VstateprovincecountryregionMVFields {
  lazy val structure: Relation[VstateprovincecountryregionMVFields, VstateprovincecountryregionMVRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[VstateprovincecountryregionMVFields, VstateprovincecountryregionMVRow] {
  
    override lazy val fields: VstateprovincecountryregionMVFields = new VstateprovincecountryregionMVFields {
      override def stateprovinceid = Field[StateprovinceId, VstateprovincecountryregionMVRow](_path, "stateprovinceid", None, None, x => x.stateprovinceid, (row, value) => row.copy(stateprovinceid = value))
      override def stateprovincecode = Field[/* bpchar, max 3 chars */ String, VstateprovincecountryregionMVRow](_path, "stateprovincecode", None, None, x => x.stateprovincecode, (row, value) => row.copy(stateprovincecode = value))
      override def isonlystateprovinceflag = Field[Flag, VstateprovincecountryregionMVRow](_path, "isonlystateprovinceflag", None, None, x => x.isonlystateprovinceflag, (row, value) => row.copy(isonlystateprovinceflag = value))
      override def stateprovincename = Field[Name, VstateprovincecountryregionMVRow](_path, "stateprovincename", None, None, x => x.stateprovincename, (row, value) => row.copy(stateprovincename = value))
      override def territoryid = Field[SalesterritoryId, VstateprovincecountryregionMVRow](_path, "territoryid", None, None, x => x.territoryid, (row, value) => row.copy(territoryid = value))
      override def countryregioncode = Field[CountryregionId, VstateprovincecountryregionMVRow](_path, "countryregioncode", None, None, x => x.countryregioncode, (row, value) => row.copy(countryregioncode = value))
      override def countryregionname = Field[Name, VstateprovincecountryregionMVRow](_path, "countryregionname", None, None, x => x.countryregionname, (row, value) => row.copy(countryregionname = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, VstateprovincecountryregionMVRow]] =
      List[FieldLikeNoHkt[?, VstateprovincecountryregionMVRow]](fields.stateprovinceid, fields.stateprovincecode, fields.isonlystateprovinceflag, fields.stateprovincename, fields.territoryid, fields.countryregioncode, fields.countryregionname)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
