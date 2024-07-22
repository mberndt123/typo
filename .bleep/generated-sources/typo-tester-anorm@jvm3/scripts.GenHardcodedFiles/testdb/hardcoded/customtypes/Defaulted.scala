/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded.customtypes

import play.api.libs.json.JsError
import play.api.libs.json.JsNull
import play.api.libs.json.JsObject
import play.api.libs.json.JsString
import play.api.libs.json.JsSuccess
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import testdb.hardcoded.Text


/**
 * This signals a value where if you don't provide it, postgres will generate it for you
 */
sealed trait Defaulted[+T]

object Defaulted {
  case class Provided[T](value: T) extends Defaulted[T]
  case object UseDefault extends Defaulted[Nothing]
  implicit def reads[T](implicit T: Reads[T]): Reads[Defaulted[T]] = {
    case JsString("defaulted") =>
      JsSuccess(Defaulted.UseDefault)
    case JsObject(Seq(("provided", providedJson: JsValue))) =>
      Json.fromJson[T](providedJson).map(Defaulted.Provided.apply)
    case _ =>
      JsError(s"Expected `Defaulted` json object structure")
  }
  implicit def readsOpt[T](implicit T: Reads[T]): Reads[Defaulted[Option[T]]] = {
    case JsString("defaulted") =>
      JsSuccess(Defaulted.UseDefault)
    case JsObject(Seq(("provided", JsNull))) =>
      JsSuccess(Defaulted.Provided(None))
    case JsObject(Seq(("provided", providedJson: JsValue))) =>
      Json.fromJson[T](providedJson).map(x => Defaulted.Provided(Some(x)))
    case _ =>
      JsError(s"Expected `Defaulted` json object structure")
  }
  implicit def text[T](implicit t: Text[T]): Text[Defaulted[T]] = Text.instance {
    case (Defaulted.Provided(value), sb) => t.unsafeEncode(value, sb)
    case (Defaulted.UseDefault, sb) =>
      sb.append("__DEFAULT_VALUE__")
      ()
  }
  implicit def writes[T](implicit T: Writes[T]): Writes[Defaulted[T]] = {
    case Defaulted.Provided(value) => Json.obj("provided" -> T.writes(value))
    case Defaulted.UseDefault      => JsString("defaulted")
  }
}
