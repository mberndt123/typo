/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

import adventureworks.Defaulted
import adventureworks.public.Name
import java.time.LocalDateTime
import java.util.UUID
import org.postgresql.jdbc.PgSQLXML
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `production.productmodel` which has not been persisted yet */
case class ProductmodelRowUnsaved(
  /** Product model description. */
  name: Name,
  /** Detailed product catalog information in xml format. */
  catalogdescription: Option[PgSQLXML],
  /** Manufacturing instructions in xml format. */
  instructions: Option[PgSQLXML],
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID],
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(productmodelid: ProductmodelId): ProductmodelRow =
    ProductmodelRow(
      productmodelid = productmodelid,
      name = name,
      catalogdescription = catalogdescription,
      instructions = instructions,
      rowguid = rowguid match {
                  case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductmodelRowUnsaved {
  implicit val oFormat: OFormat[ProductmodelRowUnsaved] = new OFormat[ProductmodelRowUnsaved]{
    override def writes(o: ProductmodelRowUnsaved): JsObject =
      Json.obj(
        "name" -> o.name,
        "catalogdescription" -> o.catalogdescription,
        "instructions" -> o.instructions,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ProductmodelRowUnsaved] = {
      JsResult.fromTry(
        Try(
          ProductmodelRowUnsaved(
            name = json.\("name").as[Name],
            catalogdescription = json.\("catalogdescription").toOption.map(_.as[PgSQLXML]),
            instructions = json.\("instructions").toOption.map(_.as[PgSQLXML]),
            rowguid = json.\("rowguid").as[Defaulted[UUID]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
