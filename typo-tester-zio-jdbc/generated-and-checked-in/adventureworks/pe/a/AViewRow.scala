/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.a

import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.address.AddressId
import adventureworks.person.stateprovince.StateprovinceId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** View: pe.a */
case class AViewRow(
  /** Points to [[adventureworks.person.address.AddressRow.addressid]] */
  id: AddressId,
  /** Points to [[adventureworks.person.address.AddressRow.addressid]] */
  addressid: AddressId,
  /** Points to [[adventureworks.person.address.AddressRow.addressline1]] */
  addressline1: /* max 60 chars */ String,
  /** Points to [[adventureworks.person.address.AddressRow.addressline2]] */
  addressline2: Option[/* max 60 chars */ String],
  /** Points to [[adventureworks.person.address.AddressRow.city]] */
  city: /* max 30 chars */ String,
  /** Points to [[adventureworks.person.address.AddressRow.stateprovinceid]] */
  stateprovinceid: StateprovinceId,
  /** Points to [[adventureworks.person.address.AddressRow.postalcode]] */
  postalcode: /* max 15 chars */ String,
  /** Points to [[adventureworks.person.address.AddressRow.spatiallocation]] */
  spatiallocation: Option[TypoBytea],
  /** Points to [[adventureworks.person.address.AddressRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[adventureworks.person.address.AddressRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object AViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[AViewRow] = new JdbcDecoder[AViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, AViewRow) =
      columIndex + 9 ->
        AViewRow(
          id = AddressId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          addressid = AddressId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          addressline1 = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2,
          addressline2 = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          city = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 4, rs)._2,
          stateprovinceid = StateprovinceId.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
          postalcode = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 6, rs)._2,
          spatiallocation = JdbcDecoder.optionDecoder(TypoBytea.jdbcDecoder).unsafeDecode(columIndex + 7, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 8, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 9, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[AViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(AddressId.jsonDecoder))
    val addressid = jsonObj.get("addressid").toRight("Missing field 'addressid'").flatMap(_.as(AddressId.jsonDecoder))
    val addressline1 = jsonObj.get("addressline1").toRight("Missing field 'addressline1'").flatMap(_.as(JsonDecoder.string))
    val addressline2 = jsonObj.get("addressline2").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val city = jsonObj.get("city").toRight("Missing field 'city'").flatMap(_.as(JsonDecoder.string))
    val stateprovinceid = jsonObj.get("stateprovinceid").toRight("Missing field 'stateprovinceid'").flatMap(_.as(StateprovinceId.jsonDecoder))
    val postalcode = jsonObj.get("postalcode").toRight("Missing field 'postalcode'").flatMap(_.as(JsonDecoder.string))
    val spatiallocation = jsonObj.get("spatiallocation").fold[Either[String, Option[TypoBytea]]](Right(None))(_.as(JsonDecoder.option(using TypoBytea.jsonDecoder)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && addressid.isRight && addressline1.isRight && addressline2.isRight && city.isRight && stateprovinceid.isRight && postalcode.isRight && spatiallocation.isRight && rowguid.isRight && modifieddate.isRight)
      Right(AViewRow(id = id.toOption.get, addressid = addressid.toOption.get, addressline1 = addressline1.toOption.get, addressline2 = addressline2.toOption.get, city = city.toOption.get, stateprovinceid = stateprovinceid.toOption.get, postalcode = postalcode.toOption.get, spatiallocation = spatiallocation.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[AViewRow] = new JsonEncoder[AViewRow] {
    override def unsafeEncode(a: AViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      AddressId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""addressid":""")
      AddressId.jsonEncoder.unsafeEncode(a.addressid, indent, out)
      out.write(",")
      out.write(""""addressline1":""")
      JsonEncoder.string.unsafeEncode(a.addressline1, indent, out)
      out.write(",")
      out.write(""""addressline2":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.addressline2, indent, out)
      out.write(",")
      out.write(""""city":""")
      JsonEncoder.string.unsafeEncode(a.city, indent, out)
      out.write(",")
      out.write(""""stateprovinceid":""")
      StateprovinceId.jsonEncoder.unsafeEncode(a.stateprovinceid, indent, out)
      out.write(",")
      out.write(""""postalcode":""")
      JsonEncoder.string.unsafeEncode(a.postalcode, indent, out)
      out.write(",")
      out.write(""""spatiallocation":""")
      JsonEncoder.option(using TypoBytea.jsonEncoder).unsafeEncode(a.spatiallocation, indent, out)
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
