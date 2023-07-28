/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package compositepk
package person

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PersonRow(
  one: Long,
  two: Option[String],
  name: Option[String]
){
   val compositeId: PersonId = PersonId(one, two)
 }

object PersonRow {
  def rowParser(idx: Int): RowParser[PersonRow] =
    RowParser[PersonRow] { row =>
      Success(
        PersonRow(
          one = row[Long](idx + 0),
          two = row[Option[String]](idx + 1),
          name = row[Option[String]](idx + 2)
        )
      )
    }
  implicit val oFormat: OFormat[PersonRow] = new OFormat[PersonRow]{
    override def writes(o: PersonRow): JsObject =
      Json.obj(
        "one" -> o.one,
        "two" -> o.two,
        "name" -> o.name
      )
  
    override def reads(json: JsValue): JsResult[PersonRow] = {
      JsResult.fromTry(
        Try(
          PersonRow(
            one = json.\("one").as[Long],
            two = json.\("two").toOption.map(_.as[String]),
            name = json.\("name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
