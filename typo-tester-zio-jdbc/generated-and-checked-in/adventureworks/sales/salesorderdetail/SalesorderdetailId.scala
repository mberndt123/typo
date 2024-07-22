/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesorderdetail

import adventureworks.sales.salesorderheader.SalesorderheaderId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Type for the composite primary key of table `sales.salesorderdetail` */
case class SalesorderdetailId(
  salesorderid: SalesorderheaderId,
  salesorderdetailid: Int
)
object SalesorderdetailId {
  implicit lazy val jsonDecoder: JsonDecoder[SalesorderdetailId] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val salesorderid = jsonObj.get("salesorderid").toRight("Missing field 'salesorderid'").flatMap(_.as(SalesorderheaderId.jsonDecoder))
    val salesorderdetailid = jsonObj.get("salesorderdetailid").toRight("Missing field 'salesorderdetailid'").flatMap(_.as(JsonDecoder.int))
    if (salesorderid.isRight && salesorderdetailid.isRight)
      Right(SalesorderdetailId(salesorderid = salesorderid.toOption.get, salesorderdetailid = salesorderdetailid.toOption.get))
    else Left(List[Either[String, Any]](salesorderid, salesorderdetailid).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SalesorderdetailId] = new JsonEncoder[SalesorderdetailId] {
    override def unsafeEncode(a: SalesorderdetailId, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""salesorderid":""")
      SalesorderheaderId.jsonEncoder.unsafeEncode(a.salesorderid, indent, out)
      out.write(",")
      out.write(""""salesorderdetailid":""")
      JsonEncoder.int.unsafeEncode(a.salesorderdetailid, indent, out)
      out.write("}")
    }
  }
}
