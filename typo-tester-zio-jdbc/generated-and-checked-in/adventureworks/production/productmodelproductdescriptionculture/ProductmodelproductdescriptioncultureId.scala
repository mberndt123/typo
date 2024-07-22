/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productmodelproductdescriptionculture

import adventureworks.production.culture.CultureId
import adventureworks.production.productdescription.ProductdescriptionId
import adventureworks.production.productmodel.ProductmodelId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Type for the composite primary key of table `production.productmodelproductdescriptionculture` */
case class ProductmodelproductdescriptioncultureId(
  productmodelid: ProductmodelId,
  productdescriptionid: ProductdescriptionId,
  cultureid: CultureId
)
object ProductmodelproductdescriptioncultureId {
  implicit lazy val jsonDecoder: JsonDecoder[ProductmodelproductdescriptioncultureId] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productmodelid = jsonObj.get("productmodelid").toRight("Missing field 'productmodelid'").flatMap(_.as(ProductmodelId.jsonDecoder))
    val productdescriptionid = jsonObj.get("productdescriptionid").toRight("Missing field 'productdescriptionid'").flatMap(_.as(ProductdescriptionId.jsonDecoder))
    val cultureid = jsonObj.get("cultureid").toRight("Missing field 'cultureid'").flatMap(_.as(CultureId.jsonDecoder))
    if (productmodelid.isRight && productdescriptionid.isRight && cultureid.isRight)
      Right(ProductmodelproductdescriptioncultureId(productmodelid = productmodelid.toOption.get, productdescriptionid = productdescriptionid.toOption.get, cultureid = cultureid.toOption.get))
    else Left(List[Either[String, Any]](productmodelid, productdescriptionid, cultureid).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductmodelproductdescriptioncultureId] = new JsonEncoder[ProductmodelproductdescriptioncultureId] {
    override def unsafeEncode(a: ProductmodelproductdescriptioncultureId, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productmodelid":""")
      ProductmodelId.jsonEncoder.unsafeEncode(a.productmodelid, indent, out)
      out.write(",")
      out.write(""""productdescriptionid":""")
      ProductdescriptionId.jsonEncoder.unsafeEncode(a.productdescriptionid, indent, out)
      out.write(",")
      out.write(""""cultureid":""")
      CultureId.jsonEncoder.unsafeEncode(a.cultureid, indent, out)
      out.write("}")
    }
  }
}
