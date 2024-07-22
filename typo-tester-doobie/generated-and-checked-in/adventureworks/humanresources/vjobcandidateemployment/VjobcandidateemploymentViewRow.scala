/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.vjobcandidateemployment;

import adventureworks.customtypes.TypoLocalDate;
import adventureworks.humanresources.jobcandidate.JobcandidateId;
import doobie.enumerated.Nullability;
import doobie.util.Read;
import doobie.util.meta.Meta;
import io.circe.Decoder;
import io.circe.Encoder;
import java.sql.ResultSet;

/** View: humanresources.vjobcandidateemployment */
case class VjobcandidateemploymentViewRow(
  /** Points to [[adventureworks.humanresources.jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: JobcandidateId,
  empStartDate: /* nullability unknown */ Option[TypoLocalDate],
  empEndDate: /* nullability unknown */ Option[TypoLocalDate],
  empOrgName: /* nullability unknown */ Option[/* max 100 chars */ String],
  empJobTitle: /* nullability unknown */ Option[/* max 100 chars */ String],
  empResponsibility: /* nullability unknown */ Option[String],
  empFunctionCategory: /* nullability unknown */ Option[String],
  empIndustryCategory: /* nullability unknown */ Option[String],
  empLocCountryRegion: /* nullability unknown */ Option[String],
  empLocState: /* nullability unknown */ Option[String],
  empLocCity: /* nullability unknown */ Option[String]
)

object VjobcandidateemploymentViewRow {
  implicit lazy val decoder: Decoder[VjobcandidateemploymentViewRow] = Decoder.forProduct11[VjobcandidateemploymentViewRow, JobcandidateId, /* nullability unknown */ Option[TypoLocalDate], /* nullability unknown */ Option[TypoLocalDate], /* nullability unknown */ Option[/* max 100 chars */ String], /* nullability unknown */ Option[/* max 100 chars */ String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String]]("jobcandidateid", "Emp.StartDate", "Emp.EndDate", "Emp.OrgName", "Emp.JobTitle", "Emp.Responsibility", "Emp.FunctionCategory", "Emp.IndustryCategory", "Emp.Loc.CountryRegion", "Emp.Loc.State", "Emp.Loc.City")(VjobcandidateemploymentViewRow.apply)(JobcandidateId.decoder, Decoder.decodeOption(TypoLocalDate.decoder), Decoder.decodeOption(TypoLocalDate.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[VjobcandidateemploymentViewRow] = Encoder.forProduct11[VjobcandidateemploymentViewRow, JobcandidateId, /* nullability unknown */ Option[TypoLocalDate], /* nullability unknown */ Option[TypoLocalDate], /* nullability unknown */ Option[/* max 100 chars */ String], /* nullability unknown */ Option[/* max 100 chars */ String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String]]("jobcandidateid", "Emp.StartDate", "Emp.EndDate", "Emp.OrgName", "Emp.JobTitle", "Emp.Responsibility", "Emp.FunctionCategory", "Emp.IndustryCategory", "Emp.Loc.CountryRegion", "Emp.Loc.State", "Emp.Loc.City")(x => (x.jobcandidateid, x.empStartDate, x.empEndDate, x.empOrgName, x.empJobTitle, x.empResponsibility, x.empFunctionCategory, x.empIndustryCategory, x.empLocCountryRegion, x.empLocState, x.empLocCity))(JobcandidateId.encoder, Encoder.encodeOption(TypoLocalDate.encoder), Encoder.encodeOption(TypoLocalDate.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit lazy val read: Read[VjobcandidateemploymentViewRow] = {
    new Read[VjobcandidateemploymentViewRow](
      gets = List(
        (JobcandidateId.get, Nullability.NoNulls),
        (TypoLocalDate.get, Nullability.Nullable),
        (TypoLocalDate.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => VjobcandidateemploymentViewRow(
        jobcandidateid = JobcandidateId.get.unsafeGetNonNullable(rs, i + 0),
        empStartDate = TypoLocalDate.get.unsafeGetNullable(rs, i + 1),
        empEndDate = TypoLocalDate.get.unsafeGetNullable(rs, i + 2),
        empOrgName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
        empJobTitle = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
        empResponsibility = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
        empFunctionCategory = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
        empIndustryCategory = Meta.StringMeta.get.unsafeGetNullable(rs, i + 7),
        empLocCountryRegion = Meta.StringMeta.get.unsafeGetNullable(rs, i + 8),
        empLocState = Meta.StringMeta.get.unsafeGetNullable(rs, i + 9),
        empLocCity = Meta.StringMeta.get.unsafeGetNullable(rs, i + 10)
      )
    )
  
  }
}