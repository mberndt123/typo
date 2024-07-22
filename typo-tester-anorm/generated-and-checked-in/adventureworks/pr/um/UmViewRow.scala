/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.um

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** View: pr.um */
case class UmViewRow(
  /** Points to [[adventureworks.production.unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  id: UnitmeasureId,
  /** Points to [[adventureworks.production.unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Points to [[adventureworks.production.unitmeasure.UnitmeasureRow.name]] */
  name: Name,
  /** Points to [[adventureworks.production.unitmeasure.UnitmeasureRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object UmViewRow {
  implicit lazy val reads: Reads[UmViewRow] = Reads[UmViewRow](json => JsResult.fromTry(
      Try(
        UmViewRow(
          id = json.\("id").as(UnitmeasureId.reads),
          unitmeasurecode = json.\("unitmeasurecode").as(UnitmeasureId.reads),
          name = json.\("name").as(Name.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[UmViewRow] = RowParser[UmViewRow] { row =>
    Success(
      UmViewRow(
        id = row(idx + 0)(UnitmeasureId.column),
        unitmeasurecode = row(idx + 1)(UnitmeasureId.column),
        name = row(idx + 2)(Name.column),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[UmViewRow] = OWrites[UmViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> UnitmeasureId.writes.writes(o.id),
      "unitmeasurecode" -> UnitmeasureId.writes.writes(o.unitmeasurecode),
      "name" -> Name.writes.writes(o.name),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
