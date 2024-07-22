/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.sop

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** View: sa.sop */
case class SopViewRow(
  /** Points to [[adventureworks.sales.specialofferproduct.SpecialofferproductRow.specialofferid]] */
  id: SpecialofferId,
  /** Points to [[adventureworks.sales.specialofferproduct.SpecialofferproductRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Points to [[adventureworks.sales.specialofferproduct.SpecialofferproductRow.productid]] */
  productid: ProductId,
  /** Points to [[adventureworks.sales.specialofferproduct.SpecialofferproductRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[adventureworks.sales.specialofferproduct.SpecialofferproductRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SopViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[SopViewRow] = new JdbcDecoder[SopViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SopViewRow) =
      columIndex + 4 ->
        SopViewRow(
          id = SpecialofferId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          specialofferid = SpecialofferId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          productid = ProductId.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[SopViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(SpecialofferId.jsonDecoder))
    val specialofferid = jsonObj.get("specialofferid").toRight("Missing field 'specialofferid'").flatMap(_.as(SpecialofferId.jsonDecoder))
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && specialofferid.isRight && productid.isRight && rowguid.isRight && modifieddate.isRight)
      Right(SopViewRow(id = id.toOption.get, specialofferid = specialofferid.toOption.get, productid = productid.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, specialofferid, productid, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SopViewRow] = new JsonEncoder[SopViewRow] {
    override def unsafeEncode(a: SopViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      SpecialofferId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""specialofferid":""")
      SpecialofferId.jsonEncoder.unsafeEncode(a.specialofferid, indent, out)
      out.write(",")
      out.write(""""productid":""")
      ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
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
