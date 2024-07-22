/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesterritory;

import adventureworks.Text;
import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.person.countryregion.CountryregionId;
import adventureworks.public.Name;
import java.sql.ResultSet;
import zio.jdbc.JdbcDecoder;
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;
import zio.json.ast.Json;
import zio.json.internal.Write;

/** Table: sales.salesterritory
  * Sales territory lookup table.
  * Primary key: territoryid
  */
case class SalesterritoryRow(
  /** Primary key for SalesTerritory records.
    * Default: nextval('sales.salesterritory_territoryid_seq'::regclass)
    */
  territoryid: SalesterritoryId,
  /** Sales territory description */
  name: Name,
  /** ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode.
    * Points to [[adventureworks.person.countryregion.CountryregionRow.countryregioncode]]
    */
  countryregioncode: CountryregionId,
  /** Geographic area to which the sales territory belong. */
  group: /* max 50 chars */ String,
  /** Sales in the territory year to date.
    * Default: 0.00
    * Constraint CK_SalesTerritory_SalesYTD affecting columns salesytd: ((salesytd >= 0.00))
    */
  salesytd: BigDecimal,
  /** Sales in the territory the previous year.
    * Default: 0.00
    * Constraint CK_SalesTerritory_SalesLastYear affecting columns saleslastyear: ((saleslastyear >= 0.00))
    */
  saleslastyear: BigDecimal,
  /** Business costs in the territory year to date.
    * Default: 0.00
    * Constraint CK_SalesTerritory_CostYTD affecting columns costytd: ((costytd >= 0.00))
    */
  costytd: BigDecimal,
  /** Business costs in the territory the previous year.
    * Default: 0.00
    * Constraint CK_SalesTerritory_CostLastYear affecting columns costlastyear: ((costlastyear >= 0.00))
    */
  costlastyear: BigDecimal,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
) {
  def id: SalesterritoryId = territoryid
  def toUnsavedRow(
    territoryid: Defaulted[SalesterritoryId],
    salesytd: Defaulted[BigDecimal] = Defaulted.Provided(this.salesytd),
    saleslastyear: Defaulted[BigDecimal] = Defaulted.Provided(this.saleslastyear),
    costytd: Defaulted[BigDecimal] = Defaulted.Provided(this.costytd),
    costlastyear: Defaulted[BigDecimal] = Defaulted.Provided(this.costlastyear),
    rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid),
    modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)
  ): SalesterritoryRowUnsaved = {
    new SalesterritoryRowUnsaved(
      name,
      countryregioncode,
      group,
      territoryid,
      salesytd,
      saleslastyear,
      costytd,
      costlastyear,
      rowguid,
      modifieddate
    )
  }
}

object SalesterritoryRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[SalesterritoryRow] = {
    new JdbcDecoder[SalesterritoryRow] {
      override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SalesterritoryRow) =
        columIndex + 9 ->
          SalesterritoryRow(
            territoryid = SalesterritoryId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
            name = Name.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
            countryregioncode = CountryregionId.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
            group = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 3, rs)._2,
            salesytd = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 4, rs)._2,
            saleslastyear = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 5, rs)._2,
            costytd = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 6, rs)._2,
            costlastyear = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 7, rs)._2,
            rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 8, rs)._2,
            modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 9, rs)._2
          )
    }
  }
  implicit lazy val jsonDecoder: JsonDecoder[SalesterritoryRow] = {
    JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
      val territoryid = jsonObj.get("territoryid").toRight("Missing field 'territoryid'").flatMap(_.as(SalesterritoryId.jsonDecoder))
      val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
      val countryregioncode = jsonObj.get("countryregioncode").toRight("Missing field 'countryregioncode'").flatMap(_.as(CountryregionId.jsonDecoder))
      val group = jsonObj.get("group").toRight("Missing field 'group'").flatMap(_.as(JsonDecoder.string))
      val salesytd = jsonObj.get("salesytd").toRight("Missing field 'salesytd'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
      val saleslastyear = jsonObj.get("saleslastyear").toRight("Missing field 'saleslastyear'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
      val costytd = jsonObj.get("costytd").toRight("Missing field 'costytd'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
      val costlastyear = jsonObj.get("costlastyear").toRight("Missing field 'costlastyear'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
      val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
      val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
      if (territoryid.isRight && name.isRight && countryregioncode.isRight && group.isRight && salesytd.isRight && saleslastyear.isRight && costytd.isRight && costlastyear.isRight && rowguid.isRight && modifieddate.isRight)
        Right(SalesterritoryRow(territoryid = territoryid.toOption.get, name = name.toOption.get, countryregioncode = countryregioncode.toOption.get, group = group.toOption.get, salesytd = salesytd.toOption.get, saleslastyear = saleslastyear.toOption.get, costytd = costytd.toOption.get, costlastyear = costlastyear.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
      else Left(List[Either[String, Any]](territoryid, name, countryregioncode, group, salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
    }
  }
  implicit lazy val jsonEncoder: JsonEncoder[SalesterritoryRow] = {
    new JsonEncoder[SalesterritoryRow] {
      override def unsafeEncode(a: SalesterritoryRow, indent: Option[Int], out: Write): Unit = {
        out.write("{")
        out.write(""""territoryid":""")
        SalesterritoryId.jsonEncoder.unsafeEncode(a.territoryid, indent, out)
        out.write(",")
        out.write(""""name":""")
        Name.jsonEncoder.unsafeEncode(a.name, indent, out)
        out.write(",")
        out.write(""""countryregioncode":""")
        CountryregionId.jsonEncoder.unsafeEncode(a.countryregioncode, indent, out)
        out.write(",")
        out.write(""""group":""")
        JsonEncoder.string.unsafeEncode(a.group, indent, out)
        out.write(",")
        out.write(""""salesytd":""")
        JsonEncoder.scalaBigDecimal.unsafeEncode(a.salesytd, indent, out)
        out.write(",")
        out.write(""""saleslastyear":""")
        JsonEncoder.scalaBigDecimal.unsafeEncode(a.saleslastyear, indent, out)
        out.write(",")
        out.write(""""costytd":""")
        JsonEncoder.scalaBigDecimal.unsafeEncode(a.costytd, indent, out)
        out.write(",")
        out.write(""""costlastyear":""")
        JsonEncoder.scalaBigDecimal.unsafeEncode(a.costlastyear, indent, out)
        out.write(",")
        out.write(""""rowguid":""")
        TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
        out.write(",")
        out.write(""""modifieddate":""")
        TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
        out.write("}")
      }
    }
  }
  implicit lazy val text: Text[SalesterritoryRow] = {
    Text.instance[SalesterritoryRow]{ (row, sb) =>
      SalesterritoryId.text.unsafeEncode(row.territoryid, sb)
      sb.append(Text.DELIMETER)
      Name.text.unsafeEncode(row.name, sb)
      sb.append(Text.DELIMETER)
      CountryregionId.text.unsafeEncode(row.countryregioncode, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.group, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.salesytd, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.saleslastyear, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.costytd, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.costlastyear, sb)
      sb.append(Text.DELIMETER)
      TypoUUID.text.unsafeEncode(row.rowguid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    }
  }
}