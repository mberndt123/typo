/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.vemployeedepartment;

import adventureworks.customtypes.TypoLocalDate;
import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.public.Name;
import adventureworks.userdefined.FirstName;
import typo.dsl.Path;
import typo.dsl.SqlExpr.Field;
import typo.dsl.SqlExpr.FieldLike;
import typo.dsl.SqlExpr.OptField;
import typo.dsl.Structure.Relation;

trait VemployeedepartmentViewFields {
  def businessentityid: Field[BusinessentityId, VemployeedepartmentViewRow]
  def title: OptField[/* max 8 chars */ String, VemployeedepartmentViewRow]
  def firstname: Field[/* user-picked */ FirstName, VemployeedepartmentViewRow]
  def middlename: OptField[Name, VemployeedepartmentViewRow]
  def lastname: Field[Name, VemployeedepartmentViewRow]
  def suffix: OptField[/* max 10 chars */ String, VemployeedepartmentViewRow]
  def jobtitle: Field[/* max 50 chars */ String, VemployeedepartmentViewRow]
  def department: Field[Name, VemployeedepartmentViewRow]
  def groupname: Field[Name, VemployeedepartmentViewRow]
  def startdate: Field[TypoLocalDate, VemployeedepartmentViewRow]
}

object VemployeedepartmentViewFields {
  lazy val structure: Relation[VemployeedepartmentViewFields, VemployeedepartmentViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[VemployeedepartmentViewFields, VemployeedepartmentViewRow] {
  
    override lazy val fields: VemployeedepartmentViewFields = new VemployeedepartmentViewFields {
      override def businessentityid = Field[BusinessentityId, VemployeedepartmentViewRow](_path, "businessentityid", None, None, x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def title = OptField[/* max 8 chars */ String, VemployeedepartmentViewRow](_path, "title", None, None, x => x.title, (row, value) => row.copy(title = value))
      override def firstname = Field[/* user-picked */ FirstName, VemployeedepartmentViewRow](_path, "firstname", None, None, x => x.firstname, (row, value) => row.copy(firstname = value))
      override def middlename = OptField[Name, VemployeedepartmentViewRow](_path, "middlename", None, None, x => x.middlename, (row, value) => row.copy(middlename = value))
      override def lastname = Field[Name, VemployeedepartmentViewRow](_path, "lastname", None, None, x => x.lastname, (row, value) => row.copy(lastname = value))
      override def suffix = OptField[/* max 10 chars */ String, VemployeedepartmentViewRow](_path, "suffix", None, None, x => x.suffix, (row, value) => row.copy(suffix = value))
      override def jobtitle = Field[/* max 50 chars */ String, VemployeedepartmentViewRow](_path, "jobtitle", None, None, x => x.jobtitle, (row, value) => row.copy(jobtitle = value))
      override def department = Field[Name, VemployeedepartmentViewRow](_path, "department", None, None, x => x.department, (row, value) => row.copy(department = value))
      override def groupname = Field[Name, VemployeedepartmentViewRow](_path, "groupname", None, None, x => x.groupname, (row, value) => row.copy(groupname = value))
      override def startdate = Field[TypoLocalDate, VemployeedepartmentViewRow](_path, "startdate", Some("text"), None, x => x.startdate, (row, value) => row.copy(startdate = value))
    }
  
    override lazy val columns: List[FieldLike[?, VemployeedepartmentViewRow]] =
      List[FieldLike[?, VemployeedepartmentViewRow]](fields.businessentityid, fields.title, fields.firstname, fields.middlename, fields.lastname, fields.suffix, fields.jobtitle, fields.department, fields.groupname, fields.startdate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
