/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.customtypes

import adventureworks.Text
import java.sql.ResultSet
import java.sql.Types
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.time.temporal.ChronoUnit
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** This is `java.time.LocalDateTime`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */
case class TypoLocalDateTime(value: LocalDateTime)

object TypoLocalDateTime {
  val parser: DateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss").appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true).toFormatter
  def apply(value: LocalDateTime): TypoLocalDateTime = new TypoLocalDateTime(value.truncatedTo(ChronoUnit.MICROS))
  def apply(str: String): TypoLocalDateTime = apply(LocalDateTime.parse(str, parser))
  def now = TypoLocalDateTime(LocalDateTime.now)
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TypoLocalDateTime]] = JdbcDecoder[Array[TypoLocalDateTime]]((rs: ResultSet) => (i: Int) =>
    rs.getArray(i) match {
      case null => null
      case arr => arr.getArray.asInstanceOf[Array[AnyRef]].map(x => TypoLocalDateTime(LocalDateTime.parse(x.asInstanceOf[String], parser)))
    },
    "Array[java.lang.String]"
  )
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TypoLocalDateTime]] = JdbcEncoder.singleParamEncoder(using arraySetter)
  implicit lazy val arraySetter: Setter[Array[TypoLocalDateTime]] = Setter.forSqlType((ps, i, v) =>
    ps.setArray(
      i,
      ps.getConnection.createArrayOf(
        "timestamp",
        v.map { vv =>
          vv.value.toString
        }
      )
    ),
    Types.ARRAY
  )
  implicit lazy val bijection: Bijection[TypoLocalDateTime, LocalDateTime] = Bijection[TypoLocalDateTime, LocalDateTime](_.value)(TypoLocalDateTime.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoLocalDateTime] = JdbcDecoder[TypoLocalDateTime](
    (rs: ResultSet) => (i: Int) => {
      val v = rs.getObject(i)
      if (v eq null) null else TypoLocalDateTime(LocalDateTime.parse(v.asInstanceOf[String], parser))
    },
    "java.lang.String"
  )
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoLocalDateTime] = JdbcEncoder.singleParamEncoder(using setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoLocalDateTime] = JsonDecoder.localDateTime.map(TypoLocalDateTime.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoLocalDateTime] = JsonEncoder.localDateTime.contramap(_.value)
  implicit lazy val ordering: Ordering[TypoLocalDateTime] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[TypoLocalDateTime] = PGType.instance[TypoLocalDateTime]("timestamp", Types.OTHER)
  implicit lazy val setter: Setter[TypoLocalDateTime] = Setter.other(
    (ps, i, v) => {
      ps.setObject(
        i,
        v.value.toString
      )
    },
    "timestamp"
  )
  implicit lazy val text: Text[TypoLocalDateTime] = new Text[TypoLocalDateTime] {
    override def unsafeEncode(v: TypoLocalDateTime, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.toString, sb)
    override def unsafeArrayEncode(v: TypoLocalDateTime, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.toString, sb)
  }
}
