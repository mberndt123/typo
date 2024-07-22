/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.pa

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

trait PaViewFields {
  def id: Field[BusinessentityId, PaViewRow]
  def businessentityid: Field[BusinessentityId, PaViewRow]
  def passwordhash: Field[/* max 128 chars */ String, PaViewRow]
  def passwordsalt: Field[/* max 10 chars */ String, PaViewRow]
  def rowguid: Field[TypoUUID, PaViewRow]
  def modifieddate: Field[TypoLocalDateTime, PaViewRow]
}

object PaViewFields {
  lazy val structure: Relation[PaViewFields, PaViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[PaViewFields, PaViewRow] {
  
    override lazy val fields: PaViewFields = new PaViewFields {
      override def id = Field[BusinessentityId, PaViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def businessentityid = Field[BusinessentityId, PaViewRow](_path, "businessentityid", None, None, x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def passwordhash = Field[/* max 128 chars */ String, PaViewRow](_path, "passwordhash", None, None, x => x.passwordhash, (row, value) => row.copy(passwordhash = value))
      override def passwordsalt = Field[/* max 10 chars */ String, PaViewRow](_path, "passwordsalt", None, None, x => x.passwordsalt, (row, value) => row.copy(passwordsalt = value))
      override def rowguid = Field[TypoUUID, PaViewRow](_path, "rowguid", None, None, x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, PaViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, PaViewRow]] =
      List[FieldLikeNoHkt[?, PaViewRow]](fields.id, fields.businessentityid, fields.passwordhash, fields.passwordsalt, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
