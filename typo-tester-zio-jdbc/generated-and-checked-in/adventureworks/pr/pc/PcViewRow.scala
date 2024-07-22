/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.pc

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.public.Name
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** View: pr.pc */
case class PcViewRow(
  /** Points to [[adventureworks.production.productcategory.ProductcategoryRow.productcategoryid]] */
  id: ProductcategoryId,
  /** Points to [[adventureworks.production.productcategory.ProductcategoryRow.productcategoryid]] */
  productcategoryid: ProductcategoryId,
  /** Points to [[adventureworks.production.productcategory.ProductcategoryRow.name]] */
  name: Name,
  /** Points to [[adventureworks.production.productcategory.ProductcategoryRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[adventureworks.production.productcategory.ProductcategoryRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PcViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PcViewRow] = new JdbcDecoder[PcViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PcViewRow) =
      columIndex + 4 ->
        PcViewRow(
          id = ProductcategoryId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          productcategoryid = ProductcategoryId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PcViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(ProductcategoryId.jsonDecoder))
    val productcategoryid = jsonObj.get("productcategoryid").toRight("Missing field 'productcategoryid'").flatMap(_.as(ProductcategoryId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && productcategoryid.isRight && name.isRight && rowguid.isRight && modifieddate.isRight)
      Right(PcViewRow(id = id.toOption.get, productcategoryid = productcategoryid.toOption.get, name = name.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, productcategoryid, name, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PcViewRow] = new JsonEncoder[PcViewRow] {
    override def unsafeEncode(a: PcViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      ProductcategoryId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""productcategoryid":""")
      ProductcategoryId.jsonEncoder.unsafeEncode(a.productcategoryid, indent, out)
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
