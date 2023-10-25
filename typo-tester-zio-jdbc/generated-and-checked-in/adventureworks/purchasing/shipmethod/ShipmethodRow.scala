/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class ShipmethodRow(
  /** Primary key for ShipMethod records. */
  shipmethodid: ShipmethodId,
  /** Shipping company name. */
  name: Name,
  /** Minimum shipping charge.
      Constraint CK_ShipMethod_ShipBase affecting columns "shipbase":  ((shipbase > 0.00)) */
  shipbase: BigDecimal,
  /** Shipping charge per pound.
      Constraint CK_ShipMethod_ShipRate affecting columns "shiprate":  ((shiprate > 0.00)) */
  shiprate: BigDecimal,
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
)

object ShipmethodRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[ShipmethodRow] = new JdbcDecoder[ShipmethodRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ShipmethodRow) =
      columIndex + 5 ->
        ShipmethodRow(
          shipmethodid = ShipmethodId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          shipbase = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 2, rs)._2,
          shiprate = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 3, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ShipmethodRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val shipmethodid = jsonObj.get("shipmethodid").toRight("Missing field 'shipmethodid'").flatMap(_.as(ShipmethodId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val shipbase = jsonObj.get("shipbase").toRight("Missing field 'shipbase'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val shiprate = jsonObj.get("shiprate").toRight("Missing field 'shiprate'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (shipmethodid.isRight && name.isRight && shipbase.isRight && shiprate.isRight && rowguid.isRight && modifieddate.isRight)
      Right(ShipmethodRow(shipmethodid = shipmethodid.toOption.get, name = name.toOption.get, shipbase = shipbase.toOption.get, shiprate = shiprate.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](shipmethodid, name, shipbase, shiprate, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ShipmethodRow] = new JsonEncoder[ShipmethodRow] {
    override def unsafeEncode(a: ShipmethodRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""shipmethodid":""")
      ShipmethodId.jsonEncoder.unsafeEncode(a.shipmethodid, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""shipbase":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.shipbase, indent, out)
      out.write(",")
      out.write(""""shiprate":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.shiprate, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ShipmethodRow] = Text.instance[ShipmethodRow]{ (row, sb) =>
    ShipmethodId.text.unsafeEncode(row.shipmethodid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.shipbase, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.shiprate, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
