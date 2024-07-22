/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.sr;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.production.scrapreason.ScrapreasonId;
import adventureworks.public.Name;
import anorm.RowParser;
import anorm.Success;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** View: pr.sr */
case class SrViewRow(
  /** Points to [[adventureworks.production.scrapreason.ScrapreasonRow.scrapreasonid]] */
  id: ScrapreasonId,
  /** Points to [[adventureworks.production.scrapreason.ScrapreasonRow.scrapreasonid]] */
  scrapreasonid: ScrapreasonId,
  /** Points to [[adventureworks.production.scrapreason.ScrapreasonRow.name]] */
  name: Name,
  /** Points to [[adventureworks.production.scrapreason.ScrapreasonRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SrViewRow {
  implicit lazy val reads: Reads[SrViewRow] = {
    Reads[SrViewRow](json => JsResult.fromTry(
        Try(
          SrViewRow(
            id = json.\("id").as(ScrapreasonId.reads),
            scrapreasonid = json.\("scrapreasonid").as(ScrapreasonId.reads),
            name = json.\("name").as(Name.reads),
            modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
          )
        )
      ),
    )
  }
  def rowParser(idx: Int): RowParser[SrViewRow] = {
    RowParser[SrViewRow] { row =>
      Success(
        SrViewRow(
          id = row(idx + 0)(ScrapreasonId.column),
          scrapreasonid = row(idx + 1)(ScrapreasonId.column),
          name = row(idx + 2)(Name.column),
          modifieddate = row(idx + 3)(TypoLocalDateTime.column)
        )
      )
    }
  }
  implicit lazy val writes: OWrites[SrViewRow] = {
    OWrites[SrViewRow](o =>
      new JsObject(ListMap[String, JsValue](
        "id" -> ScrapreasonId.writes.writes(o.id),
        "scrapreasonid" -> ScrapreasonId.writes.writes(o.scrapreasonid),
        "name" -> Name.writes.writes(o.name),
        "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
      ))
    )
  }
}