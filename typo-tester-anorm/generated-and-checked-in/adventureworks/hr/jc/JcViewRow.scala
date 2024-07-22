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
import anorm.Column;
import anorm.RowParser;
import anorm.Success;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import play.api.libs.json.Writes;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** View: hr.jc */
case class JcViewRow(
  /** Points to [[adventureworks.humanresources.jobcandidate.JobcandidateRow.jobcandidateid]] */
  id: JobcandidateId,
  /** Points to [[adventureworks.humanresources.jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: JobcandidateId,
  /** Points to [[adventureworks.humanresources.jobcandidate.JobcandidateRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[adventureworks.humanresources.jobcandidate.JobcandidateRow.resume]] */
  resume: Option[TypoXml],
  /** Points to [[adventureworks.humanresources.jobcandidate.JobcandidateRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object JcViewRow {
  implicit lazy val reads: Reads[JcViewRow] = {
    Reads[JcViewRow](json => JsResult.fromTry(
        Try(
          JcViewRow(
            id = json.\("id").as(JobcandidateId.reads),
            jobcandidateid = json.\("jobcandidateid").as(JobcandidateId.reads),
            businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
            resume = json.\("resume").toOption.map(_.as(TypoXml.reads)),
            modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
          )
        )
      ),
    )
  }
  def rowParser(idx: Int): RowParser[JcViewRow] = {
    RowParser[JcViewRow] { row =>
      Success(
        JcViewRow(
          id = row(idx + 0)(JobcandidateId.column),
          jobcandidateid = row(idx + 1)(JobcandidateId.column),
          businessentityid = row(idx + 2)(Column.columnToOption(BusinessentityId.column)),
          resume = row(idx + 3)(Column.columnToOption(TypoXml.column)),
          modifieddate = row(idx + 4)(TypoLocalDateTime.column)
        )
      )
    }
  }
  implicit lazy val writes: OWrites[JcViewRow] = {
    OWrites[JcViewRow](o =>
      new JsObject(ListMap[String, JsValue](
        "id" -> JobcandidateId.writes.writes(o.id),
        "jobcandidateid" -> JobcandidateId.writes.writes(o.jobcandidateid),
        "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
        "resume" -> Writes.OptionWrites(TypoXml.writes).writes(o.resume),
        "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
      ))
    )
  }
}