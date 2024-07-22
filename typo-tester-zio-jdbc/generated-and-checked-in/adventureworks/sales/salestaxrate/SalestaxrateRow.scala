/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salestaxrate;

import adventureworks.Text;
import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoShort;
import adventureworks.customtypes.TypoUUID;
import adventureworks.person.stateprovince.StateprovinceId;
import adventureworks.public.Name;
import java.sql.ResultSet;
import zio.jdbc.JdbcDecoder;
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;
import zio.json.ast.Json;
import zio.json.internal.Write;

/** Table: sales.salestaxrate
  * Tax rate lookup table.
  * Primary key: salestaxrateid
  */
case class SalestaxrateRow(
  /** Primary key for SalesTaxRate records.
    * Default: nextval('sales.salestaxrate_salestaxrateid_seq'::regclass)
    */
  salestaxrateid: SalestaxrateId,
  /** State, province, or country/region the sales tax applies to.
    * Points to [[adventureworks.person.stateprovince.StateprovinceRow.stateprovinceid]]
    */
  stateprovinceid: StateprovinceId,
  /** 1 = Tax applied to retail transactions, 2 = Tax applied to wholesale transactions, 3 = Tax applied to all sales (retail and wholesale) transactions.
    * Constraint CK_SalesTaxRate_TaxType affecting columns taxtype: (((taxtype >= 1) AND (taxtype <= 3)))
    */
  taxtype: TypoShort,
  /** Tax rate amount.
    * Default: 0.00
    */
  taxrate: BigDecimal,
  /** Tax rate description. */
  name: Name,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
) {
  def id: SalestaxrateId = salestaxrateid
  def toUnsavedRow(
    salestaxrateid: Defaulted[SalestaxrateId],
    taxrate: Defaulted[BigDecimal] = Defaulted.Provided(this.taxrate),
    rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid),
    modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)
  ): SalestaxrateRowUnsaved = {
    new SalestaxrateRowUnsaved(
      stateprovinceid,
      taxtype,
      name,
      salestaxrateid,
      taxrate,
      rowguid,
      modifieddate
    )
  }
}

object SalestaxrateRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[SalestaxrateRow] = {
    new JdbcDecoder[SalestaxrateRow] {
      override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SalestaxrateRow) =
        columIndex + 6 ->
          SalestaxrateRow(
            salestaxrateid = SalestaxrateId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
            stateprovinceid = StateprovinceId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
            taxtype = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
            taxrate = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 3, rs)._2,
            name = Name.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
            rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
            modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 6, rs)._2
          )
    }
  }
  implicit lazy val jsonDecoder: JsonDecoder[SalestaxrateRow] = {
    JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
      val salestaxrateid = jsonObj.get("salestaxrateid").toRight("Missing field 'salestaxrateid'").flatMap(_.as(SalestaxrateId.jsonDecoder))
      val stateprovinceid = jsonObj.get("stateprovinceid").toRight("Missing field 'stateprovinceid'").flatMap(_.as(StateprovinceId.jsonDecoder))
      val taxtype = jsonObj.get("taxtype").toRight("Missing field 'taxtype'").flatMap(_.as(TypoShort.jsonDecoder))
      val taxrate = jsonObj.get("taxrate").toRight("Missing field 'taxrate'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
      val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
      val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
      val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
      if (salestaxrateid.isRight && stateprovinceid.isRight && taxtype.isRight && taxrate.isRight && name.isRight && rowguid.isRight && modifieddate.isRight)
        Right(SalestaxrateRow(salestaxrateid = salestaxrateid.toOption.get, stateprovinceid = stateprovinceid.toOption.get, taxtype = taxtype.toOption.get, taxrate = taxrate.toOption.get, name = name.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
      else Left(List[Either[String, Any]](salestaxrateid, stateprovinceid, taxtype, taxrate, name, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
    }
  }
  implicit lazy val jsonEncoder: JsonEncoder[SalestaxrateRow] = {
    new JsonEncoder[SalestaxrateRow] {
      override def unsafeEncode(a: SalestaxrateRow, indent: Option[Int], out: Write): Unit = {
        out.write("{")
        out.write(""""salestaxrateid":""")
        SalestaxrateId.jsonEncoder.unsafeEncode(a.salestaxrateid, indent, out)
        out.write(",")
        out.write(""""stateprovinceid":""")
        StateprovinceId.jsonEncoder.unsafeEncode(a.stateprovinceid, indent, out)
        out.write(",")
        out.write(""""taxtype":""")
        TypoShort.jsonEncoder.unsafeEncode(a.taxtype, indent, out)
        out.write(",")
        out.write(""""taxrate":""")
        JsonEncoder.scalaBigDecimal.unsafeEncode(a.taxrate, indent, out)
        out.write(",")
        out.write(""""name":""")
        Name.jsonEncoder.unsafeEncode(a.name, indent, out)
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
  implicit lazy val text: Text[SalestaxrateRow] = {
    Text.instance[SalestaxrateRow]{ (row, sb) =>
      SalestaxrateId.text.unsafeEncode(row.salestaxrateid, sb)
      sb.append(Text.DELIMETER)
      StateprovinceId.text.unsafeEncode(row.stateprovinceid, sb)
      sb.append(Text.DELIMETER)
      TypoShort.text.unsafeEncode(row.taxtype, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.taxrate, sb)
      sb.append(Text.DELIMETER)
      Name.text.unsafeEncode(row.name, sb)
      sb.append(Text.DELIMETER)
      TypoUUID.text.unsafeEncode(row.rowguid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    }
  }
}