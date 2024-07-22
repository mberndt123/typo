/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.customtypes

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import org.postgresql.jdbc.PgArray
import org.postgresql.util.PGInterval
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** Interval type in PostgreSQL */
case class TypoInterval(years: Int, months: Int, days: Int, hours: Int, minutes: Int, seconds: Double)

object TypoInterval {
  implicit lazy val arrayColumn: Column[Array[TypoInterval]] = Column.nonNull[Array[TypoInterval]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoInterval(v.asInstanceOf[PGInterval].getYears, v.asInstanceOf[PGInterval].getMonths, v.asInstanceOf[PGInterval].getDays, v.asInstanceOf[PGInterval].getHours, v.asInstanceOf[PGInterval].getMinutes, v.asInstanceOf[PGInterval].getSeconds)))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoInterval, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayToStatement: ToStatement[Array[TypoInterval]] = ToStatement[Array[TypoInterval]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("interval", v.map(v => new PGInterval(v.years, v.months, v.days, v.hours, v.minutes, v.seconds)))))
  implicit lazy val column: Column[TypoInterval] = Column.nonNull[TypoInterval]((v1: Any, _) =>
    v1 match {
      case v: PGInterval => Right(TypoInterval(v.getYears, v.getMonths, v.getDays, v.getHours, v.getMinutes, v.getSeconds))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.util.PGInterval, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val ordering: Ordering[TypoInterval] = Ordering.by(x => (x.years, x.months, x.days, x.hours, x.minutes, x.seconds))
  implicit lazy val parameterMetadata: ParameterMetaData[TypoInterval] = new ParameterMetaData[TypoInterval] {
    override def sqlType: String = "interval"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoInterval] = Reads[TypoInterval](json => JsResult.fromTry(
      Try(
        TypoInterval(
          years = json.\("years").as(Reads.IntReads),
          months = json.\("months").as(Reads.IntReads),
          days = json.\("days").as(Reads.IntReads),
          hours = json.\("hours").as(Reads.IntReads),
          minutes = json.\("minutes").as(Reads.IntReads),
          seconds = json.\("seconds").as(Reads.DoubleReads)
        )
      )
    ),
  )
  implicit lazy val text: Text[TypoInterval] = new Text[TypoInterval] {
    override def unsafeEncode(v: TypoInterval, sb: StringBuilder) = Text.stringInstance.unsafeEncode(s"P${v.years}Y${v.months}M${v.days}DT${v.hours}H${v.minutes}M${v.seconds}S", sb)
    override def unsafeArrayEncode(v: TypoInterval, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(s"P${v.years}Y${v.months}M${v.days}DT${v.hours}H${v.minutes}M${v.seconds}S", sb)
  }
  implicit lazy val toStatement: ToStatement[TypoInterval] = ToStatement[TypoInterval]((s, index, v) => s.setObject(index, new PGInterval(v.years, v.months, v.days, v.hours, v.minutes, v.seconds)))
  implicit lazy val writes: OWrites[TypoInterval] = OWrites[TypoInterval](o =>
    new JsObject(ListMap[String, JsValue](
      "years" -> Writes.IntWrites.writes(o.years),
      "months" -> Writes.IntWrites.writes(o.months),
      "days" -> Writes.IntWrites.writes(o.days),
      "hours" -> Writes.IntWrites.writes(o.hours),
      "minutes" -> Writes.IntWrites.writes(o.minutes),
      "seconds" -> Writes.DoubleWrites.writes(o.seconds)
    ))
  )
}
