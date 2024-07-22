/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.vstateprovincecountryregion;

import adventureworks.person.countryregion.CountryregionId;
import adventureworks.person.stateprovince.StateprovinceId;
import adventureworks.public.Flag;
import adventureworks.public.Name;
import adventureworks.sales.salesterritory.SalesterritoryId;
import java.sql.ResultSet;
import zio.jdbc.JdbcDecoder;
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;
import zio.json.ast.Json;
import zio.json.internal.Write;

/** Materialized View: person.vstateprovincecountryregion */
case class VstateprovincecountryregionMVRow(
  /** Points to [[adventureworks.person.stateprovince.StateprovinceRow.stateprovinceid]] */
  stateprovinceid: StateprovinceId,
  /** Points to [[adventureworks.person.stateprovince.StateprovinceRow.stateprovincecode]] */
  stateprovincecode: /* bpchar, max 3 chars */ String,
  /** Points to [[adventureworks.person.stateprovince.StateprovinceRow.isonlystateprovinceflag]] */
  isonlystateprovinceflag: Flag,
  /** Points to [[adventureworks.person.stateprovince.StateprovinceRow.name]] */
  stateprovincename: Name,
  /** Points to [[adventureworks.person.stateprovince.StateprovinceRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Points to [[adventureworks.person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** Points to [[adventureworks.person.countryregion.CountryregionRow.name]] */
  countryregionname: Name
)

object VstateprovincecountryregionMVRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[VstateprovincecountryregionMVRow] = {
    new JdbcDecoder[VstateprovincecountryregionMVRow] {
      override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, VstateprovincecountryregionMVRow) =
        columIndex + 6 ->
          VstateprovincecountryregionMVRow(
            stateprovinceid = StateprovinceId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
            stateprovincecode = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
            isonlystateprovinceflag = Flag.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
            stateprovincename = Name.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
            territoryid = SalesterritoryId.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
            countryregioncode = CountryregionId.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
            countryregionname = Name.jdbcDecoder.unsafeDecode(columIndex + 6, rs)._2
          )
    }
  }
  implicit lazy val jsonDecoder: JsonDecoder[VstateprovincecountryregionMVRow] = {
    JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
      val stateprovinceid = jsonObj.get("stateprovinceid").toRight("Missing field 'stateprovinceid'").flatMap(_.as(StateprovinceId.jsonDecoder))
      val stateprovincecode = jsonObj.get("stateprovincecode").toRight("Missing field 'stateprovincecode'").flatMap(_.as(JsonDecoder.string))
      val isonlystateprovinceflag = jsonObj.get("isonlystateprovinceflag").toRight("Missing field 'isonlystateprovinceflag'").flatMap(_.as(Flag.jsonDecoder))
      val stateprovincename = jsonObj.get("stateprovincename").toRight("Missing field 'stateprovincename'").flatMap(_.as(Name.jsonDecoder))
      val territoryid = jsonObj.get("territoryid").toRight("Missing field 'territoryid'").flatMap(_.as(SalesterritoryId.jsonDecoder))
      val countryregioncode = jsonObj.get("countryregioncode").toRight("Missing field 'countryregioncode'").flatMap(_.as(CountryregionId.jsonDecoder))
      val countryregionname = jsonObj.get("countryregionname").toRight("Missing field 'countryregionname'").flatMap(_.as(Name.jsonDecoder))
      if (stateprovinceid.isRight && stateprovincecode.isRight && isonlystateprovinceflag.isRight && stateprovincename.isRight && territoryid.isRight && countryregioncode.isRight && countryregionname.isRight)
        Right(VstateprovincecountryregionMVRow(stateprovinceid = stateprovinceid.toOption.get, stateprovincecode = stateprovincecode.toOption.get, isonlystateprovinceflag = isonlystateprovinceflag.toOption.get, stateprovincename = stateprovincename.toOption.get, territoryid = territoryid.toOption.get, countryregioncode = countryregioncode.toOption.get, countryregionname = countryregionname.toOption.get))
      else Left(List[Either[String, Any]](stateprovinceid, stateprovincecode, isonlystateprovinceflag, stateprovincename, territoryid, countryregioncode, countryregionname).flatMap(_.left.toOption).mkString(", "))
    }
  }
  implicit lazy val jsonEncoder: JsonEncoder[VstateprovincecountryregionMVRow] = {
    new JsonEncoder[VstateprovincecountryregionMVRow] {
      override def unsafeEncode(a: VstateprovincecountryregionMVRow, indent: Option[Int], out: Write): Unit = {
        out.write("{")
        out.write(""""stateprovinceid":""")
        StateprovinceId.jsonEncoder.unsafeEncode(a.stateprovinceid, indent, out)
        out.write(",")
        out.write(""""stateprovincecode":""")
        JsonEncoder.string.unsafeEncode(a.stateprovincecode, indent, out)
        out.write(",")
        out.write(""""isonlystateprovinceflag":""")
        Flag.jsonEncoder.unsafeEncode(a.isonlystateprovinceflag, indent, out)
        out.write(",")
        out.write(""""stateprovincename":""")
        Name.jsonEncoder.unsafeEncode(a.stateprovincename, indent, out)
        out.write(",")
        out.write(""""territoryid":""")
        SalesterritoryId.jsonEncoder.unsafeEncode(a.territoryid, indent, out)
        out.write(",")
        out.write(""""countryregioncode":""")
        CountryregionId.jsonEncoder.unsafeEncode(a.countryregioncode, indent, out)
        out.write(",")
        out.write(""""countryregionname":""")
        Name.jsonEncoder.unsafeEncode(a.countryregionname, indent, out)
        out.write("}")
      }
    }
  }
}