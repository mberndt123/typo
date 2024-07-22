/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.vvendorwithcontacts

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import adventureworks.userdefined.FirstName
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLike
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait VvendorwithcontactsViewFields {
  def businessentityid: Field[BusinessentityId, VvendorwithcontactsViewRow]
  def name: Field[Name, VvendorwithcontactsViewRow]
  def contacttype: Field[Name, VvendorwithcontactsViewRow]
  def title: OptField[/* max 8 chars */ String, VvendorwithcontactsViewRow]
  def firstname: Field[/* user-picked */ FirstName, VvendorwithcontactsViewRow]
  def middlename: OptField[Name, VvendorwithcontactsViewRow]
  def lastname: Field[Name, VvendorwithcontactsViewRow]
  def suffix: OptField[/* max 10 chars */ String, VvendorwithcontactsViewRow]
  def phonenumber: OptField[Phone, VvendorwithcontactsViewRow]
  def phonenumbertype: OptField[Name, VvendorwithcontactsViewRow]
  def emailaddress: OptField[/* max 50 chars */ String, VvendorwithcontactsViewRow]
  def emailpromotion: Field[Int, VvendorwithcontactsViewRow]
}

object VvendorwithcontactsViewFields {
  lazy val structure: Relation[VvendorwithcontactsViewFields, VvendorwithcontactsViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[VvendorwithcontactsViewFields, VvendorwithcontactsViewRow] {
  
    override lazy val fields: VvendorwithcontactsViewFields = new VvendorwithcontactsViewFields {
      override def businessentityid = Field[BusinessentityId, VvendorwithcontactsViewRow](_path, "businessentityid", None, None, x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def name = Field[Name, VvendorwithcontactsViewRow](_path, "name", None, None, x => x.name, (row, value) => row.copy(name = value))
      override def contacttype = Field[Name, VvendorwithcontactsViewRow](_path, "contacttype", None, None, x => x.contacttype, (row, value) => row.copy(contacttype = value))
      override def title = OptField[/* max 8 chars */ String, VvendorwithcontactsViewRow](_path, "title", None, None, x => x.title, (row, value) => row.copy(title = value))
      override def firstname = Field[/* user-picked */ FirstName, VvendorwithcontactsViewRow](_path, "firstname", None, None, x => x.firstname, (row, value) => row.copy(firstname = value))
      override def middlename = OptField[Name, VvendorwithcontactsViewRow](_path, "middlename", None, None, x => x.middlename, (row, value) => row.copy(middlename = value))
      override def lastname = Field[Name, VvendorwithcontactsViewRow](_path, "lastname", None, None, x => x.lastname, (row, value) => row.copy(lastname = value))
      override def suffix = OptField[/* max 10 chars */ String, VvendorwithcontactsViewRow](_path, "suffix", None, None, x => x.suffix, (row, value) => row.copy(suffix = value))
      override def phonenumber = OptField[Phone, VvendorwithcontactsViewRow](_path, "phonenumber", None, None, x => x.phonenumber, (row, value) => row.copy(phonenumber = value))
      override def phonenumbertype = OptField[Name, VvendorwithcontactsViewRow](_path, "phonenumbertype", None, None, x => x.phonenumbertype, (row, value) => row.copy(phonenumbertype = value))
      override def emailaddress = OptField[/* max 50 chars */ String, VvendorwithcontactsViewRow](_path, "emailaddress", None, None, x => x.emailaddress, (row, value) => row.copy(emailaddress = value))
      override def emailpromotion = Field[Int, VvendorwithcontactsViewRow](_path, "emailpromotion", None, None, x => x.emailpromotion, (row, value) => row.copy(emailpromotion = value))
    }
  
    override lazy val columns: List[FieldLike[?, VvendorwithcontactsViewRow]] =
      List[FieldLike[?, VvendorwithcontactsViewRow]](fields.businessentityid, fields.name, fields.contacttype, fields.title, fields.firstname, fields.middlename, fields.lastname, fields.suffix, fields.phonenumber, fields.phonenumbertype, fields.emailaddress, fields.emailpromotion)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
