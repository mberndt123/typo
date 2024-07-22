/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.bea

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.address.AddressId
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLike
import typo.dsl.Structure.Relation

trait BeaViewFields {
  def id: Field[BusinessentityId, BeaViewRow]
  def businessentityid: Field[BusinessentityId, BeaViewRow]
  def addressid: Field[AddressId, BeaViewRow]
  def addresstypeid: Field[AddresstypeId, BeaViewRow]
  def rowguid: Field[TypoUUID, BeaViewRow]
  def modifieddate: Field[TypoLocalDateTime, BeaViewRow]
}

object BeaViewFields {
  lazy val structure: Relation[BeaViewFields, BeaViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[BeaViewFields, BeaViewRow] {
  
    override lazy val fields: BeaViewFields = new BeaViewFields {
      override def id = Field[BusinessentityId, BeaViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def businessentityid = Field[BusinessentityId, BeaViewRow](_path, "businessentityid", None, None, x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def addressid = Field[AddressId, BeaViewRow](_path, "addressid", None, None, x => x.addressid, (row, value) => row.copy(addressid = value))
      override def addresstypeid = Field[AddresstypeId, BeaViewRow](_path, "addresstypeid", None, None, x => x.addresstypeid, (row, value) => row.copy(addresstypeid = value))
      override def rowguid = Field[TypoUUID, BeaViewRow](_path, "rowguid", None, None, x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, BeaViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, BeaViewRow]] =
      List[FieldLike[?, BeaViewRow]](fields.id, fields.businessentityid, fields.addressid, fields.addresstypeid, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
