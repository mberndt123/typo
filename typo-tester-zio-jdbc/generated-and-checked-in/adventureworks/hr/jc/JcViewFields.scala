/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.hr.jc;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoXml;
import adventureworks.humanresources.jobcandidate.JobcandidateId;
import adventureworks.person.businessentity.BusinessentityId;
import typo.dsl.Path;
import typo.dsl.SqlExpr.Field;
import typo.dsl.SqlExpr.FieldLike;
import typo.dsl.SqlExpr.OptField;
import typo.dsl.Structure.Relation;

trait JcViewFields {
  def id: Field[JobcandidateId, JcViewRow]
  def jobcandidateid: Field[JobcandidateId, JcViewRow]
  def businessentityid: OptField[BusinessentityId, JcViewRow]
  def resume: OptField[TypoXml, JcViewRow]
  def modifieddate: Field[TypoLocalDateTime, JcViewRow]
}

object JcViewFields {
  lazy val structure: Relation[JcViewFields, JcViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[JcViewFields, JcViewRow] {
  
    override lazy val fields: JcViewFields = new JcViewFields {
      override def id = Field[JobcandidateId, JcViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def jobcandidateid = Field[JobcandidateId, JcViewRow](_path, "jobcandidateid", None, None, x => x.jobcandidateid, (row, value) => row.copy(jobcandidateid = value))
      override def businessentityid = OptField[BusinessentityId, JcViewRow](_path, "businessentityid", None, None, x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def resume = OptField[TypoXml, JcViewRow](_path, "resume", None, None, x => x.resume, (row, value) => row.copy(resume = value))
      override def modifieddate = Field[TypoLocalDateTime, JcViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, JcViewRow]] =
      List[FieldLike[?, JcViewRow]](fields.id, fields.jobcandidateid, fields.businessentityid, fields.resume, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
