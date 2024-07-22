/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.pp

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLike
import typo.dsl.Structure.Relation

trait PpViewFields {
  def id: Field[BusinessentityId, PpViewRow]
  def businessentityid: Field[BusinessentityId, PpViewRow]
  def phonenumber: Field[Phone, PpViewRow]
  def phonenumbertypeid: Field[PhonenumbertypeId, PpViewRow]
  def modifieddate: Field[TypoLocalDateTime, PpViewRow]
}

object PpViewFields {
  lazy val structure: Relation[PpViewFields, PpViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[PpViewFields, PpViewRow] {
  
    override lazy val fields: PpViewFields = new PpViewFields {
      override def id = Field[BusinessentityId, PpViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def businessentityid = Field[BusinessentityId, PpViewRow](_path, "businessentityid", None, None, x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def phonenumber = Field[Phone, PpViewRow](_path, "phonenumber", None, None, x => x.phonenumber, (row, value) => row.copy(phonenumber = value))
      override def phonenumbertypeid = Field[PhonenumbertypeId, PpViewRow](_path, "phonenumbertypeid", None, None, x => x.phonenumbertypeid, (row, value) => row.copy(phonenumbertypeid = value))
      override def modifieddate = Field[TypoLocalDateTime, PpViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, PpViewRow]] =
      List[FieldLike[?, PpViewRow]](fields.id, fields.businessentityid, fields.phonenumber, fields.phonenumbertypeid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
