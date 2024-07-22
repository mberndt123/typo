/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.vproductmodelinstructions;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.production.productmodel.ProductmodelId;
import adventureworks.public.Name;
import java.sql.ResultSet;
import zio.jdbc.JdbcDecoder;
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;
import zio.json.ast.Json;
import zio.json.internal.Write;

/** View: production.vproductmodelinstructions */
case class VproductmodelinstructionsViewRow(
  /** Points to [[adventureworks.production.productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Points to [[adventureworks.production.productmodel.ProductmodelRow.name]] */
  name: Name,
  instructions: /* nullability unknown */ Option[String],
  locationID: /* nullability unknown */ Option[Int],
  setupHours: /* nullability unknown */ Option[BigDecimal],
  machineHours: /* nullability unknown */ Option[BigDecimal],
  laborHours: /* nullability unknown */ Option[BigDecimal],
  lotSize: /* nullability unknown */ Option[Int],
  step: /* nullability unknown */ Option[/* max 1024 chars */ String],
  /** Points to [[adventureworks.production.productmodel.ProductmodelRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[adventureworks.production.productmodel.ProductmodelRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object VproductmodelinstructionsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[VproductmodelinstructionsViewRow] = {
    new JdbcDecoder[VproductmodelinstructionsViewRow] {
      override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, VproductmodelinstructionsViewRow) =
        columIndex + 10 ->
          VproductmodelinstructionsViewRow(
            productmodelid = ProductmodelId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
            name = Name.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
            instructions = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
            locationID = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 3, rs)._2,
            setupHours = JdbcDecoder.optionDecoder(JdbcDecoder.bigDecimalDecoderScala).unsafeDecode(columIndex + 4, rs)._2,
            machineHours = JdbcDecoder.optionDecoder(JdbcDecoder.bigDecimalDecoderScala).unsafeDecode(columIndex + 5, rs)._2,
            laborHours = JdbcDecoder.optionDecoder(JdbcDecoder.bigDecimalDecoderScala).unsafeDecode(columIndex + 6, rs)._2,
            lotSize = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 7, rs)._2,
            step = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 8, rs)._2,
            rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 9, rs)._2,
            modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 10, rs)._2
          )
    }
  }
  implicit lazy val jsonDecoder: JsonDecoder[VproductmodelinstructionsViewRow] = {
    JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
      val productmodelid = jsonObj.get("productmodelid").toRight("Missing field 'productmodelid'").flatMap(_.as(ProductmodelId.jsonDecoder))
      val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
      val instructions = jsonObj.get("instructions").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
      val locationID = jsonObj.get("LocationID").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.int)))
      val setupHours = jsonObj.get("SetupHours").fold[Either[String, Option[BigDecimal]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.scalaBigDecimal)))
      val machineHours = jsonObj.get("MachineHours").fold[Either[String, Option[BigDecimal]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.scalaBigDecimal)))
      val laborHours = jsonObj.get("LaborHours").fold[Either[String, Option[BigDecimal]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.scalaBigDecimal)))
      val lotSize = jsonObj.get("LotSize").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.int)))
      val step = jsonObj.get("Step").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
      val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
      val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
      if (productmodelid.isRight && name.isRight && instructions.isRight && locationID.isRight && setupHours.isRight && machineHours.isRight && laborHours.isRight && lotSize.isRight && step.isRight && rowguid.isRight && modifieddate.isRight)
        Right(VproductmodelinstructionsViewRow(productmodelid = productmodelid.toOption.get, name = name.toOption.get, instructions = instructions.toOption.get, locationID = locationID.toOption.get, setupHours = setupHours.toOption.get, machineHours = machineHours.toOption.get, laborHours = laborHours.toOption.get, lotSize = lotSize.toOption.get, step = step.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
      else Left(List[Either[String, Any]](productmodelid, name, instructions, locationID, setupHours, machineHours, laborHours, lotSize, step, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
    }
  }
  implicit lazy val jsonEncoder: JsonEncoder[VproductmodelinstructionsViewRow] = {
    new JsonEncoder[VproductmodelinstructionsViewRow] {
      override def unsafeEncode(a: VproductmodelinstructionsViewRow, indent: Option[Int], out: Write): Unit = {
        out.write("{")
        out.write(""""productmodelid":""")
        ProductmodelId.jsonEncoder.unsafeEncode(a.productmodelid, indent, out)
        out.write(",")
        out.write(""""name":""")
        Name.jsonEncoder.unsafeEncode(a.name, indent, out)
        out.write(",")
        out.write(""""instructions":""")
        JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.instructions, indent, out)
        out.write(",")
        out.write(""""LocationID":""")
        JsonEncoder.option(using JsonEncoder.int).unsafeEncode(a.locationID, indent, out)
        out.write(",")
        out.write(""""SetupHours":""")
        JsonEncoder.option(using JsonEncoder.scalaBigDecimal).unsafeEncode(a.setupHours, indent, out)
        out.write(",")
        out.write(""""MachineHours":""")
        JsonEncoder.option(using JsonEncoder.scalaBigDecimal).unsafeEncode(a.machineHours, indent, out)
        out.write(",")
        out.write(""""LaborHours":""")
        JsonEncoder.option(using JsonEncoder.scalaBigDecimal).unsafeEncode(a.laborHours, indent, out)
        out.write(",")
        out.write(""""LotSize":""")
        JsonEncoder.option(using JsonEncoder.int).unsafeEncode(a.lotSize, indent, out)
        out.write(",")
        out.write(""""Step":""")
        JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.step, indent, out)
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
}