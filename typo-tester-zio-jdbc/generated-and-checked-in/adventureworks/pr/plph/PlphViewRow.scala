/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.plph

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** View: pr.plph */
case class PlphViewRow(
  /** Points to [[adventureworks.production.productlistpricehistory.ProductlistpricehistoryRow.productid]] */
  id: ProductId,
  /** Points to [[adventureworks.production.productlistpricehistory.ProductlistpricehistoryRow.productid]] */
  productid: ProductId,
  /** Points to [[adventureworks.production.productlistpricehistory.ProductlistpricehistoryRow.startdate]] */
  startdate: TypoLocalDateTime,
  /** Points to [[adventureworks.production.productlistpricehistory.ProductlistpricehistoryRow.enddate]] */
  enddate: Option[TypoLocalDateTime],
  /** Points to [[adventureworks.production.productlistpricehistory.ProductlistpricehistoryRow.listprice]] */
  listprice: BigDecimal,
  /** Points to [[adventureworks.production.productlistpricehistory.ProductlistpricehistoryRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PlphViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PlphViewRow] = new JdbcDecoder[PlphViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PlphViewRow) =
      columIndex + 5 ->
        PlphViewRow(
          id = ProductId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          productid = ProductId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          startdate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          enddate = JdbcDecoder.optionDecoder(TypoLocalDateTime.jdbcDecoder).unsafeDecode(columIndex + 3, rs)._2,
          listprice = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 4, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PlphViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(ProductId.jsonDecoder))
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val startdate = jsonObj.get("startdate").toRight("Missing field 'startdate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val enddate = jsonObj.get("enddate").fold[Either[String, Option[TypoLocalDateTime]]](Right(None))(_.as(JsonDecoder.option(using TypoLocalDateTime.jsonDecoder)))
    val listprice = jsonObj.get("listprice").toRight("Missing field 'listprice'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && productid.isRight && startdate.isRight && enddate.isRight && listprice.isRight && modifieddate.isRight)
      Right(PlphViewRow(id = id.toOption.get, productid = productid.toOption.get, startdate = startdate.toOption.get, enddate = enddate.toOption.get, listprice = listprice.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, productid, startdate, enddate, listprice, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PlphViewRow] = new JsonEncoder[PlphViewRow] {
    override def unsafeEncode(a: PlphViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      ProductId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""productid":""")
      ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
      out.write(",")
      out.write(""""startdate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.startdate, indent, out)
      out.write(",")
      out.write(""""enddate":""")
      JsonEncoder.option(using TypoLocalDateTime.jsonEncoder).unsafeEncode(a.enddate, indent, out)
      out.write(",")
      out.write(""""listprice":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.listprice, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
