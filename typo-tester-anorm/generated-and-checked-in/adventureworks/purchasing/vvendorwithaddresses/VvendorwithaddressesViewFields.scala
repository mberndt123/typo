/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.vvendorwithaddresses

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLike
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait VvendorwithaddressesViewFields {
  def businessentityid: Field[BusinessentityId, VvendorwithaddressesViewRow]
  def name: Field[Name, VvendorwithaddressesViewRow]
  def addresstype: Field[Name, VvendorwithaddressesViewRow]
  def addressline1: Field[/* max 60 chars */ String, VvendorwithaddressesViewRow]
  def addressline2: OptField[/* max 60 chars */ String, VvendorwithaddressesViewRow]
  def city: Field[/* max 30 chars */ String, VvendorwithaddressesViewRow]
  def stateprovincename: Field[Name, VvendorwithaddressesViewRow]
  def postalcode: Field[/* max 15 chars */ String, VvendorwithaddressesViewRow]
  def countryregionname: Field[Name, VvendorwithaddressesViewRow]
}

object VvendorwithaddressesViewFields {
  lazy val structure: Relation[VvendorwithaddressesViewFields, VvendorwithaddressesViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[VvendorwithaddressesViewFields, VvendorwithaddressesViewRow] {
  
    override lazy val fields: VvendorwithaddressesViewFields = new VvendorwithaddressesViewFields {
      override def businessentityid = Field[BusinessentityId, VvendorwithaddressesViewRow](_path, "businessentityid", None, None, x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def name = Field[Name, VvendorwithaddressesViewRow](_path, "name", None, None, x => x.name, (row, value) => row.copy(name = value))
      override def addresstype = Field[Name, VvendorwithaddressesViewRow](_path, "addresstype", None, None, x => x.addresstype, (row, value) => row.copy(addresstype = value))
      override def addressline1 = Field[/* max 60 chars */ String, VvendorwithaddressesViewRow](_path, "addressline1", None, None, x => x.addressline1, (row, value) => row.copy(addressline1 = value))
      override def addressline2 = OptField[/* max 60 chars */ String, VvendorwithaddressesViewRow](_path, "addressline2", None, None, x => x.addressline2, (row, value) => row.copy(addressline2 = value))
      override def city = Field[/* max 30 chars */ String, VvendorwithaddressesViewRow](_path, "city", None, None, x => x.city, (row, value) => row.copy(city = value))
      override def stateprovincename = Field[Name, VvendorwithaddressesViewRow](_path, "stateprovincename", None, None, x => x.stateprovincename, (row, value) => row.copy(stateprovincename = value))
      override def postalcode = Field[/* max 15 chars */ String, VvendorwithaddressesViewRow](_path, "postalcode", None, None, x => x.postalcode, (row, value) => row.copy(postalcode = value))
      override def countryregionname = Field[Name, VvendorwithaddressesViewRow](_path, "countryregionname", None, None, x => x.countryregionname, (row, value) => row.copy(countryregionname = value))
    }
  
    override lazy val columns: List[FieldLike[?, VvendorwithaddressesViewRow]] =
      List[FieldLike[?, VvendorwithaddressesViewRow]](fields.businessentityid, fields.name, fields.addresstype, fields.addressline1, fields.addressline2, fields.city, fields.stateprovincename, fields.postalcode, fields.countryregionname)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
