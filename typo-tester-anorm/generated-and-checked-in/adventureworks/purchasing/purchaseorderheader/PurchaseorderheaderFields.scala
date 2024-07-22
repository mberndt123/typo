/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.purchaseorderheader

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.humanresources.employee.EmployeeFields
import adventureworks.humanresources.employee.EmployeeRow
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.purchasing.shipmethod.ShipmethodFields
import adventureworks.purchasing.shipmethod.ShipmethodId
import adventureworks.purchasing.shipmethod.ShipmethodRow
import adventureworks.purchasing.vendor.VendorFields
import adventureworks.purchasing.vendor.VendorRow
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLike
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait PurchaseorderheaderFields {
  def purchaseorderid: IdField[PurchaseorderheaderId, PurchaseorderheaderRow]
  def revisionnumber: Field[TypoShort, PurchaseorderheaderRow]
  def status: Field[TypoShort, PurchaseorderheaderRow]
  def employeeid: Field[BusinessentityId, PurchaseorderheaderRow]
  def vendorid: Field[BusinessentityId, PurchaseorderheaderRow]
  def shipmethodid: Field[ShipmethodId, PurchaseorderheaderRow]
  def orderdate: Field[TypoLocalDateTime, PurchaseorderheaderRow]
  def shipdate: OptField[TypoLocalDateTime, PurchaseorderheaderRow]
  def subtotal: Field[BigDecimal, PurchaseorderheaderRow]
  def taxamt: Field[BigDecimal, PurchaseorderheaderRow]
  def freight: Field[BigDecimal, PurchaseorderheaderRow]
  def modifieddate: Field[TypoLocalDateTime, PurchaseorderheaderRow]
  def fkHumanresourcesEmployee: ForeignKey[EmployeeFields, EmployeeRow] =
    ForeignKey[EmployeeFields, EmployeeRow]("purchasing.FK_PurchaseOrderHeader_Employee_EmployeeID", Nil)
      .withColumnPair(employeeid, _.businessentityid)
  def fkShipmethod: ForeignKey[ShipmethodFields, ShipmethodRow] =
    ForeignKey[ShipmethodFields, ShipmethodRow]("purchasing.FK_PurchaseOrderHeader_ShipMethod_ShipMethodID", Nil)
      .withColumnPair(shipmethodid, _.shipmethodid)
  def fkVendor: ForeignKey[VendorFields, VendorRow] =
    ForeignKey[VendorFields, VendorRow]("purchasing.FK_PurchaseOrderHeader_Vendor_VendorID", Nil)
      .withColumnPair(vendorid, _.businessentityid)
}

object PurchaseorderheaderFields {
  lazy val structure: Relation[PurchaseorderheaderFields, PurchaseorderheaderRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[PurchaseorderheaderFields, PurchaseorderheaderRow] {
  
    override lazy val fields: PurchaseorderheaderFields = new PurchaseorderheaderFields {
      override def purchaseorderid = IdField[PurchaseorderheaderId, PurchaseorderheaderRow](_path, "purchaseorderid", None, Some("int4"), x => x.purchaseorderid, (row, value) => row.copy(purchaseorderid = value))
      override def revisionnumber = Field[TypoShort, PurchaseorderheaderRow](_path, "revisionnumber", None, Some("int2"), x => x.revisionnumber, (row, value) => row.copy(revisionnumber = value))
      override def status = Field[TypoShort, PurchaseorderheaderRow](_path, "status", None, Some("int2"), x => x.status, (row, value) => row.copy(status = value))
      override def employeeid = Field[BusinessentityId, PurchaseorderheaderRow](_path, "employeeid", None, Some("int4"), x => x.employeeid, (row, value) => row.copy(employeeid = value))
      override def vendorid = Field[BusinessentityId, PurchaseorderheaderRow](_path, "vendorid", None, Some("int4"), x => x.vendorid, (row, value) => row.copy(vendorid = value))
      override def shipmethodid = Field[ShipmethodId, PurchaseorderheaderRow](_path, "shipmethodid", None, Some("int4"), x => x.shipmethodid, (row, value) => row.copy(shipmethodid = value))
      override def orderdate = Field[TypoLocalDateTime, PurchaseorderheaderRow](_path, "orderdate", Some("text"), Some("timestamp"), x => x.orderdate, (row, value) => row.copy(orderdate = value))
      override def shipdate = OptField[TypoLocalDateTime, PurchaseorderheaderRow](_path, "shipdate", Some("text"), Some("timestamp"), x => x.shipdate, (row, value) => row.copy(shipdate = value))
      override def subtotal = Field[BigDecimal, PurchaseorderheaderRow](_path, "subtotal", None, Some("numeric"), x => x.subtotal, (row, value) => row.copy(subtotal = value))
      override def taxamt = Field[BigDecimal, PurchaseorderheaderRow](_path, "taxamt", None, Some("numeric"), x => x.taxamt, (row, value) => row.copy(taxamt = value))
      override def freight = Field[BigDecimal, PurchaseorderheaderRow](_path, "freight", None, Some("numeric"), x => x.freight, (row, value) => row.copy(freight = value))
      override def modifieddate = Field[TypoLocalDateTime, PurchaseorderheaderRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, PurchaseorderheaderRow]] =
      List[FieldLike[?, PurchaseorderheaderRow]](fields.purchaseorderid, fields.revisionnumber, fields.status, fields.employeeid, fields.vendorid, fields.shipmethodid, fields.orderdate, fields.shipdate, fields.subtotal, fields.taxamt, fields.freight, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
