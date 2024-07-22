/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.businessentityaddress

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.address.AddressFields
import adventureworks.person.address.AddressId
import adventureworks.person.address.AddressRow
import adventureworks.person.addresstype.AddresstypeFields
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.person.addresstype.AddresstypeRow
import adventureworks.person.businessentity.BusinessentityFields
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.businessentity.BusinessentityRow
import anorm.ToParameterValue
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.Required
import typo.dsl.SqlExpr
import typo.dsl.SqlExpr.CompositeIn
import typo.dsl.SqlExpr.CompositeIn.TuplePart
import typo.dsl.SqlExpr.Const.As.as
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait BusinessentityaddressFields {
  def businessentityid: IdField[BusinessentityId, BusinessentityaddressRow]
  def addressid: IdField[AddressId, BusinessentityaddressRow]
  def addresstypeid: IdField[AddresstypeId, BusinessentityaddressRow]
  def rowguid: Field[TypoUUID, BusinessentityaddressRow]
  def modifieddate: Field[TypoLocalDateTime, BusinessentityaddressRow]
  def fkAddresstype: ForeignKey[AddresstypeFields, AddresstypeRow] =
    ForeignKey[AddresstypeFields, AddresstypeRow]("person.FK_BusinessEntityAddress_AddressType_AddressTypeID", Nil)
      .withColumnPair(addresstypeid, _.addresstypeid)
  def fkAddress: ForeignKey[AddressFields, AddressRow] =
    ForeignKey[AddressFields, AddressRow]("person.FK_BusinessEntityAddress_Address_AddressID", Nil)
      .withColumnPair(addressid, _.addressid)
  def fkBusinessentity: ForeignKey[BusinessentityFields, BusinessentityRow] =
    ForeignKey[BusinessentityFields, BusinessentityRow]("person.FK_BusinessEntityAddress_BusinessEntity_BusinessEntityID", Nil)
      .withColumnPair(businessentityid, _.businessentityid)
  def compositeIdIs(compositeId: BusinessentityaddressId): SqlExpr[Boolean, Required] =
    businessentityid.isEqual(compositeId.businessentityid).and(addressid.isEqual(compositeId.addressid)).and(addresstypeid.isEqual(compositeId.addresstypeid))
  def compositeIdIn(compositeIds: Array[BusinessentityaddressId]): SqlExpr[Boolean, Required] =
    new CompositeIn(compositeIds)(TuplePart[BusinessentityaddressId](businessentityid)(_.businessentityid)(using as[Array[BusinessentityId], Required](ToParameterValue(null, BusinessentityId.arrayToStatement), adventureworks.arrayParameterMetaData(BusinessentityId.parameterMetadata)), implicitly), TuplePart[BusinessentityaddressId](addressid)(_.addressid)(using as[Array[AddressId], Required](ToParameterValue(null, AddressId.arrayToStatement), adventureworks.arrayParameterMetaData(AddressId.parameterMetadata)), implicitly), TuplePart[BusinessentityaddressId](addresstypeid)(_.addresstypeid)(using as[Array[AddresstypeId], Required](ToParameterValue(null, AddresstypeId.arrayToStatement), adventureworks.arrayParameterMetaData(AddresstypeId.parameterMetadata)), implicitly))
  
}

object BusinessentityaddressFields {
  lazy val structure: Relation[BusinessentityaddressFields, BusinessentityaddressRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[BusinessentityaddressFields, BusinessentityaddressRow] {
  
    override lazy val fields: BusinessentityaddressFields = new BusinessentityaddressFields {
      override def businessentityid = IdField[BusinessentityId, BusinessentityaddressRow](_path, "businessentityid", None, Some("int4"), x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def addressid = IdField[AddressId, BusinessentityaddressRow](_path, "addressid", None, Some("int4"), x => x.addressid, (row, value) => row.copy(addressid = value))
      override def addresstypeid = IdField[AddresstypeId, BusinessentityaddressRow](_path, "addresstypeid", None, Some("int4"), x => x.addresstypeid, (row, value) => row.copy(addresstypeid = value))
      override def rowguid = Field[TypoUUID, BusinessentityaddressRow](_path, "rowguid", None, Some("uuid"), x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, BusinessentityaddressRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, BusinessentityaddressRow]] =
      List[FieldLikeNoHkt[?, BusinessentityaddressRow]](fields.businessentityid, fields.addressid, fields.addresstypeid, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
