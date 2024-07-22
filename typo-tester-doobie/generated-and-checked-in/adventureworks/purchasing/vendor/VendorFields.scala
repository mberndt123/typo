/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.vendor

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityFields
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.businessentity.BusinessentityRow
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait VendorFields {
  def businessentityid: IdField[BusinessentityId, VendorRow]
  def accountnumber: Field[AccountNumber, VendorRow]
  def name: Field[Name, VendorRow]
  def creditrating: Field[TypoShort, VendorRow]
  def preferredvendorstatus: Field[Flag, VendorRow]
  def activeflag: Field[Flag, VendorRow]
  def purchasingwebserviceurl: OptField[/* max 1024 chars */ String, VendorRow]
  def modifieddate: Field[TypoLocalDateTime, VendorRow]
  def fkPersonBusinessentity: ForeignKey[BusinessentityFields, BusinessentityRow] =
    ForeignKey[BusinessentityFields, BusinessentityRow]("purchasing.FK_Vendor_BusinessEntity_BusinessEntityID", Nil)
      .withColumnPair(businessentityid, _.businessentityid)
}

object VendorFields {
  lazy val structure: Relation[VendorFields, VendorRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[VendorFields, VendorRow] {
  
    override lazy val fields: VendorFields = new VendorFields {
      override def businessentityid = IdField[BusinessentityId, VendorRow](_path, "businessentityid", None, Some("int4"), x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def accountnumber = Field[AccountNumber, VendorRow](_path, "accountnumber", None, Some("varchar"), x => x.accountnumber, (row, value) => row.copy(accountnumber = value))
      override def name = Field[Name, VendorRow](_path, "name", None, Some("varchar"), x => x.name, (row, value) => row.copy(name = value))
      override def creditrating = Field[TypoShort, VendorRow](_path, "creditrating", None, Some("int2"), x => x.creditrating, (row, value) => row.copy(creditrating = value))
      override def preferredvendorstatus = Field[Flag, VendorRow](_path, "preferredvendorstatus", None, Some("bool"), x => x.preferredvendorstatus, (row, value) => row.copy(preferredvendorstatus = value))
      override def activeflag = Field[Flag, VendorRow](_path, "activeflag", None, Some("bool"), x => x.activeflag, (row, value) => row.copy(activeflag = value))
      override def purchasingwebserviceurl = OptField[/* max 1024 chars */ String, VendorRow](_path, "purchasingwebserviceurl", None, None, x => x.purchasingwebserviceurl, (row, value) => row.copy(purchasingwebserviceurl = value))
      override def modifieddate = Field[TypoLocalDateTime, VendorRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, VendorRow]] =
      List[FieldLikeNoHkt[?, VendorRow]](fields.businessentityid, fields.accountnumber, fields.name, fields.creditrating, fields.preferredvendorstatus, fields.activeflag, fields.purchasingwebserviceurl, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
