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
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;
import zio.json.ast.Json;
import zio.json.internal.Write;

/** This class corresponds to a row in table `sales.salesterritory` which has not been persisted yet */
case class SalesterritoryRowUnsaved(
  /** Sales territory description */
  name: Name,
  /** ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode.
    * Points to [[adventureworks.person.countryregion.CountryregionRow.countryregioncode]]
    */
  countryregioncode: CountryregionId,
  /** Geographic area to which the sales territory belong. */
  group: /* max 50 chars */ String,
  /** Default: nextval('sales.salesterritory_territoryid_seq'::regclass)
    * Primary key for SalesTerritory records.
    */
  territoryid: Defaulted[SalesterritoryId] = Defaulted.UseDefault(),
  /** Default: 0.00
    * Sales in the territory year to date.
    * Constraint CK_SalesTerritory_SalesYTD affecting columns salesytd:  ((salesytd >= 0.00))
    */
  salesytd: Defaulted[BigDecimal] = Defaulted.UseDefault(),
  /** Default: 0.00
    * Sales in the territory the previous year.
    * Constraint CK_SalesTerritory_SalesLastYear affecting columns saleslastyear:  ((saleslastyear >= 0.00))
    */
  saleslastyear: Defaulted[BigDecimal] = Defaulted.UseDefault(),
  /** Default: 0.00
    * Business costs in the territory year to date.
    * Constraint CK_SalesTerritory_CostYTD affecting columns costytd:  ((costytd >= 0.00))
    */
  costytd: Defaulted[BigDecimal] = Defaulted.UseDefault(),
  /** Default: 0.00
    * Business costs in the territory the previous year.
    * Constraint CK_SalesTerritory_CostLastYear affecting columns costlastyear:  ((costlastyear >= 0.00))
    */
  costlastyear: Defaulted[BigDecimal] = Defaulted.UseDefault(),
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault(),
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault()
) {
  def toRow(
    territoryidDefault: => SalesterritoryId,
    salesytdDefault: => BigDecimal,
    saleslastyearDefault: => BigDecimal,
    costytdDefault: => BigDecimal,
    costlastyearDefault: => BigDecimal,
    rowguidDefault: => TypoUUID,
    modifieddateDefault: => TypoLocalDateTime
  ): SalesterritoryRow = {
    new SalesterritoryRow(
      territoryid = territoryid.getOrElse(territoryidDefault),
      name = name,
      countryregioncode = countryregioncode,
      group = group,
      salesytd = salesytd.getOrElse(salesytdDefault),
      saleslastyear = saleslastyear.getOrElse(saleslastyearDefault),
      costytd = costytd.getOrElse(costytdDefault),
      costlastyear = costlastyear.getOrElse(costlastyearDefault),
      rowguid = rowguid.getOrElse(rowguidDefault),
      modifieddate = modifieddate.getOrElse(modifieddateDefault)
    )
  }
}

object SalesterritoryRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[SalesterritoryRowUnsaved] = {
    JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
      val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
      val countryregioncode = jsonObj.get("countryregioncode").toRight("Missing field 'countryregioncode'").flatMap(_.as(CountryregionId.jsonDecoder))
      val group = jsonObj.get("group").toRight("Missing field 'group'").flatMap(_.as(JsonDecoder.string))
      val territoryid = jsonObj.get("territoryid").toRight("Missing field 'territoryid'").flatMap(_.as(Defaulted.jsonDecoder(SalesterritoryId.jsonDecoder)))
      val salesytd = jsonObj.get("salesytd").toRight("Missing field 'salesytd'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.scalaBigDecimal)))
      val saleslastyear = jsonObj.get("saleslastyear").toRight("Missing field 'saleslastyear'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.scalaBigDecimal)))
      val costytd = jsonObj.get("costytd").toRight("Missing field 'costytd'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.scalaBigDecimal)))
      val costlastyear = jsonObj.get("costlastyear").toRight("Missing field 'costlastyear'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.scalaBigDecimal)))
      val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(Defaulted.jsonDecoder(TypoUUID.jsonDecoder)))
      val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
      if (name.isRight && countryregioncode.isRight && group.isRight && territoryid.isRight && salesytd.isRight && saleslastyear.isRight && costytd.isRight && costlastyear.isRight && rowguid.isRight && modifieddate.isRight)
        Right(SalesterritoryRowUnsaved(name = name.toOption.get, countryregioncode = countryregioncode.toOption.get, group = group.toOption.get, territoryid = territoryid.toOption.get, salesytd = salesytd.toOption.get, saleslastyear = saleslastyear.toOption.get, costytd = costytd.toOption.get, costlastyear = costlastyear.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
      else Left(List[Either[String, Any]](name, countryregioncode, group, territoryid, salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
    }
  }
  implicit lazy val jsonEncoder: JsonEncoder[SalesterritoryRowUnsaved] = {
    new JsonEncoder[SalesterritoryRowUnsaved] {
      override def unsafeEncode(a: SalesterritoryRowUnsaved, indent: Option[Int], out: Write): Unit = {
        out.write("{")
        out.write(""""name":""")
        Name.jsonEncoder.unsafeEncode(a.name, indent, out)
        out.write(",")
        out.write(""""countryregioncode":""")
        CountryregionId.jsonEncoder.unsafeEncode(a.countryregioncode, indent, out)
        out.write(",")
        out.write(""""group":""")
        JsonEncoder.string.unsafeEncode(a.group, indent, out)
        out.write(",")
        out.write(""""territoryid":""")
        Defaulted.jsonEncoder(SalesterritoryId.jsonEncoder).unsafeEncode(a.territoryid, indent, out)
        out.write(",")
        out.write(""""salesytd":""")
        Defaulted.jsonEncoder(JsonEncoder.scalaBigDecimal).unsafeEncode(a.salesytd, indent, out)
        out.write(",")
        out.write(""""saleslastyear":""")
        Defaulted.jsonEncoder(JsonEncoder.scalaBigDecimal).unsafeEncode(a.saleslastyear, indent, out)
        out.write(",")
        out.write(""""costytd":""")
        Defaulted.jsonEncoder(JsonEncoder.scalaBigDecimal).unsafeEncode(a.costytd, indent, out)
        out.write(",")
        out.write(""""costlastyear":""")
        Defaulted.jsonEncoder(JsonEncoder.scalaBigDecimal).unsafeEncode(a.costlastyear, indent, out)
        out.write(",")
        out.write(""""rowguid":""")
        Defaulted.jsonEncoder(TypoUUID.jsonEncoder).unsafeEncode(a.rowguid, indent, out)
        out.write(",")
        out.write(""""modifieddate":""")
        Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
        out.write("}")
      }
    }
  }
  implicit lazy val text: Text[SalesterritoryRowUnsaved] = {
    Text.instance[SalesterritoryRowUnsaved]{ (row, sb) =>
      Name.text.unsafeEncode(row.name, sb)
      sb.append(Text.DELIMETER)
      CountryregionId.text.unsafeEncode(row.countryregioncode, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.group, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(SalesterritoryId.text).unsafeEncode(row.territoryid, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.salesytd, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.saleslastyear, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.costytd, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.costlastyear, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
    }
  }
}