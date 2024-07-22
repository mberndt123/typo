/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.hr.d;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.humanresources.department.DepartmentId;
import adventureworks.public.Name;
import typo.dsl.Path;
import typo.dsl.SqlExpr.Field;
import typo.dsl.SqlExpr.FieldLike;
import typo.dsl.Structure.Relation;

trait DViewFields {
  def id: Field[DepartmentId, DViewRow]
  def departmentid: Field[DepartmentId, DViewRow]
  def name: Field[Name, DViewRow]
  def groupname: Field[Name, DViewRow]
  def modifieddate: Field[TypoLocalDateTime, DViewRow]
}

object DViewFields {
  lazy val structure: Relation[DViewFields, DViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[DViewFields, DViewRow] {
  
    override lazy val fields: DViewFields = new DViewFields {
      override def id = Field[DepartmentId, DViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def departmentid = Field[DepartmentId, DViewRow](_path, "departmentid", None, None, x => x.departmentid, (row, value) => row.copy(departmentid = value))
      override def name = Field[Name, DViewRow](_path, "name", None, None, x => x.name, (row, value) => row.copy(name = value))
      override def groupname = Field[Name, DViewRow](_path, "groupname", None, None, x => x.groupname, (row, value) => row.copy(groupname = value))
      override def modifieddate = Field[TypoLocalDateTime, DViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, DViewRow]] =
      List[FieldLike[?, DViewRow]](fields.id, fields.departmentid, fields.name, fields.groupname, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
