/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class SalespersonRow(
  /** Primary key for SalesPerson records. Foreign key to Employee.BusinessEntityID
      Points to [[humanresources.employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Territory currently assigned to. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Projected yearly sales.
      Constraint CK_SalesPerson_SalesQuota affecting columns "salesquota":  ((salesquota > 0.00)) */
  salesquota: Option[BigDecimal],
  /** Bonus due if quota is met.
      Constraint CK_SalesPerson_Bonus affecting columns "bonus":  ((bonus >= 0.00)) */
  bonus: BigDecimal,
  /** Commision percent received per sale.
      Constraint CK_SalesPerson_CommissionPct affecting columns "commissionpct":  ((commissionpct >= 0.00)) */
  commissionpct: BigDecimal,
  /** Sales total year to date.
      Constraint CK_SalesPerson_SalesYTD affecting columns "salesytd":  ((salesytd >= 0.00)) */
  salesytd: BigDecimal,
  /** Sales total of previous year.
      Constraint CK_SalesPerson_SalesLastYear affecting columns "saleslastyear":  ((saleslastyear >= 0.00)) */
  saleslastyear: BigDecimal,
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
)

object SalespersonRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[SalespersonRow] = new JdbcDecoder[SalespersonRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SalespersonRow) =
      columIndex + 8 ->
        SalespersonRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          territoryid = JdbcDecoder.optionDecoder(SalesterritoryId.jdbcDecoder).unsafeDecode(columIndex + 1, rs)._2,
          salesquota = JdbcDecoder.optionDecoder(JdbcDecoder.bigDecimalDecoderScala).unsafeDecode(columIndex + 2, rs)._2,
          bonus = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 3, rs)._2,
          commissionpct = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 4, rs)._2,
          salesytd = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 5, rs)._2,
          saleslastyear = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 6, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 7, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 8, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[SalespersonRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val territoryid = jsonObj.get("territoryid").fold[Either[String, Option[SalesterritoryId]]](Right(None))(_.as(JsonDecoder.option(SalesterritoryId.jsonDecoder)))
    val salesquota = jsonObj.get("salesquota").fold[Either[String, Option[BigDecimal]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.scalaBigDecimal)))
    val bonus = jsonObj.get("bonus").toRight("Missing field 'bonus'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val commissionpct = jsonObj.get("commissionpct").toRight("Missing field 'commissionpct'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val salesytd = jsonObj.get("salesytd").toRight("Missing field 'salesytd'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val saleslastyear = jsonObj.get("saleslastyear").toRight("Missing field 'saleslastyear'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (businessentityid.isRight && territoryid.isRight && salesquota.isRight && bonus.isRight && commissionpct.isRight && salesytd.isRight && saleslastyear.isRight && rowguid.isRight && modifieddate.isRight)
      Right(SalespersonRow(businessentityid = businessentityid.toOption.get, territoryid = territoryid.toOption.get, salesquota = salesquota.toOption.get, bonus = bonus.toOption.get, commissionpct = commissionpct.toOption.get, salesytd = salesytd.toOption.get, saleslastyear = saleslastyear.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SalespersonRow] = new JsonEncoder[SalespersonRow] {
    override def unsafeEncode(a: SalespersonRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""territoryid":""")
      JsonEncoder.option(SalesterritoryId.jsonEncoder).unsafeEncode(a.territoryid, indent, out)
      out.write(",")
      out.write(""""salesquota":""")
      JsonEncoder.option(JsonEncoder.scalaBigDecimal).unsafeEncode(a.salesquota, indent, out)
      out.write(",")
      out.write(""""bonus":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.bonus, indent, out)
      out.write(",")
      out.write(""""commissionpct":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.commissionpct, indent, out)
      out.write(",")
      out.write(""""salesytd":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.salesytd, indent, out)
      out.write(",")
      out.write(""""saleslastyear":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.saleslastyear, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[SalespersonRow] = Text.instance[SalespersonRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    Text.option(SalesterritoryId.text).unsafeEncode(row.territoryid, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.bigDecimalInstance).unsafeEncode(row.salesquota, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.bonus, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.commissionpct, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.salesytd, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.saleslastyear, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
