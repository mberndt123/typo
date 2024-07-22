/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.vjobcandidate

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.humanresources.jobcandidate.JobcandidateId
import adventureworks.person.businessentity.BusinessentityId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** View: humanresources.vjobcandidate */
case class VjobcandidateViewRow(
  /** Points to [[adventureworks.humanresources.jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: JobcandidateId,
  /** Points to [[adventureworks.humanresources.jobcandidate.JobcandidateRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  namePrefix: /* nullability unknown */ Option[/* max 30 chars */ String],
  nameFirst: /* nullability unknown */ Option[/* max 30 chars */ String],
  nameMiddle: /* nullability unknown */ Option[/* max 30 chars */ String],
  nameLast: /* nullability unknown */ Option[/* max 30 chars */ String],
  nameSuffix: /* nullability unknown */ Option[/* max 30 chars */ String],
  skills: /* nullability unknown */ Option[String],
  addrType: /* nullability unknown */ Option[/* max 30 chars */ String],
  addrLocCountryRegion: /* nullability unknown */ Option[/* max 100 chars */ String],
  addrLocState: /* nullability unknown */ Option[/* max 100 chars */ String],
  addrLocCity: /* nullability unknown */ Option[/* max 100 chars */ String],
  addrPostalCode: /* nullability unknown */ Option[/* max 20 chars */ String],
  eMail: /* nullability unknown */ Option[String],
  webSite: /* nullability unknown */ Option[String],
  /** Points to [[adventureworks.humanresources.jobcandidate.JobcandidateRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object VjobcandidateViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[VjobcandidateViewRow] = new JdbcDecoder[VjobcandidateViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, VjobcandidateViewRow) =
      columIndex + 15 ->
        VjobcandidateViewRow(
          jobcandidateid = JobcandidateId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          businessentityid = JdbcDecoder.optionDecoder(BusinessentityId.jdbcDecoder).unsafeDecode(columIndex + 1, rs)._2,
          namePrefix = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          nameFirst = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          nameMiddle = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          nameLast = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          nameSuffix = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2,
          skills = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 7, rs)._2,
          addrType = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 8, rs)._2,
          addrLocCountryRegion = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 9, rs)._2,
          addrLocState = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 10, rs)._2,
          addrLocCity = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 11, rs)._2,
          addrPostalCode = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 12, rs)._2,
          eMail = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 13, rs)._2,
          webSite = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 14, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 15, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[VjobcandidateViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val jobcandidateid = jsonObj.get("jobcandidateid").toRight("Missing field 'jobcandidateid'").flatMap(_.as(JobcandidateId.jsonDecoder))
    val businessentityid = jsonObj.get("businessentityid").fold[Either[String, Option[BusinessentityId]]](Right(None))(_.as(JsonDecoder.option(using BusinessentityId.jsonDecoder)))
    val namePrefix = jsonObj.get("Name.Prefix").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val nameFirst = jsonObj.get("Name.First").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val nameMiddle = jsonObj.get("Name.Middle").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val nameLast = jsonObj.get("Name.Last").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val nameSuffix = jsonObj.get("Name.Suffix").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val skills = jsonObj.get("Skills").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val addrType = jsonObj.get("Addr.Type").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val addrLocCountryRegion = jsonObj.get("Addr.Loc.CountryRegion").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val addrLocState = jsonObj.get("Addr.Loc.State").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val addrLocCity = jsonObj.get("Addr.Loc.City").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val addrPostalCode = jsonObj.get("Addr.PostalCode").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val eMail = jsonObj.get("EMail").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val webSite = jsonObj.get("WebSite").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (jobcandidateid.isRight && businessentityid.isRight && namePrefix.isRight && nameFirst.isRight && nameMiddle.isRight && nameLast.isRight && nameSuffix.isRight && skills.isRight && addrType.isRight && addrLocCountryRegion.isRight && addrLocState.isRight && addrLocCity.isRight && addrPostalCode.isRight && eMail.isRight && webSite.isRight && modifieddate.isRight)
      Right(VjobcandidateViewRow(jobcandidateid = jobcandidateid.toOption.get, businessentityid = businessentityid.toOption.get, namePrefix = namePrefix.toOption.get, nameFirst = nameFirst.toOption.get, nameMiddle = nameMiddle.toOption.get, nameLast = nameLast.toOption.get, nameSuffix = nameSuffix.toOption.get, skills = skills.toOption.get, addrType = addrType.toOption.get, addrLocCountryRegion = addrLocCountryRegion.toOption.get, addrLocState = addrLocState.toOption.get, addrLocCity = addrLocCity.toOption.get, addrPostalCode = addrPostalCode.toOption.get, eMail = eMail.toOption.get, webSite = webSite.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](jobcandidateid, businessentityid, namePrefix, nameFirst, nameMiddle, nameLast, nameSuffix, skills, addrType, addrLocCountryRegion, addrLocState, addrLocCity, addrPostalCode, eMail, webSite, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[VjobcandidateViewRow] = new JsonEncoder[VjobcandidateViewRow] {
    override def unsafeEncode(a: VjobcandidateViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""jobcandidateid":""")
      JobcandidateId.jsonEncoder.unsafeEncode(a.jobcandidateid, indent, out)
      out.write(",")
      out.write(""""businessentityid":""")
      JsonEncoder.option(using BusinessentityId.jsonEncoder).unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""Name.Prefix":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.namePrefix, indent, out)
      out.write(",")
      out.write(""""Name.First":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.nameFirst, indent, out)
      out.write(",")
      out.write(""""Name.Middle":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.nameMiddle, indent, out)
      out.write(",")
      out.write(""""Name.Last":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.nameLast, indent, out)
      out.write(",")
      out.write(""""Name.Suffix":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.nameSuffix, indent, out)
      out.write(",")
      out.write(""""Skills":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.skills, indent, out)
      out.write(",")
      out.write(""""Addr.Type":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.addrType, indent, out)
      out.write(",")
      out.write(""""Addr.Loc.CountryRegion":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.addrLocCountryRegion, indent, out)
      out.write(",")
      out.write(""""Addr.Loc.State":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.addrLocState, indent, out)
      out.write(",")
      out.write(""""Addr.Loc.City":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.addrLocCity, indent, out)
      out.write(",")
      out.write(""""Addr.PostalCode":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.addrPostalCode, indent, out)
      out.write(",")
      out.write(""""EMail":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.eMail, indent, out)
      out.write(",")
      out.write(""""WebSite":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.webSite, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
