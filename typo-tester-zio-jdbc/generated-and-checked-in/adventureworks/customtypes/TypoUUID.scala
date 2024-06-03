/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import java.sql.ResultSet
import java.sql.Types
import java.util.UUID
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** UUID */
case class TypoUUID(value: UUID)

object TypoUUID {
  def apply(str: String): TypoUUID = TypoUUID(UUID.fromString(str))
  def randomUUID: TypoUUID = TypoUUID(UUID.randomUUID())
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TypoUUID]] = JdbcDecoder[Array[TypoUUID]]((rs: ResultSet) => (i: Int) =>
    rs.getArray(i) match {
      case null => null
      case arr => arr.getArray.asInstanceOf[Array[AnyRef]].map(x => TypoUUID(x.asInstanceOf[UUID]))
    },
    "Array[java.util.UUID]"
  )
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TypoUUID]] = JdbcEncoder.singleParamEncoder(using arraySetter)
  implicit lazy val arraySetter: Setter[Array[TypoUUID]] = Setter.forSqlType((ps, i, v) =>
    ps.setArray(
      i,
      ps.getConnection.createArrayOf(
        "uuid",
        v.map { vv =>
          vv.value
        }
      )
    ),
    Types.ARRAY
  )
  implicit lazy val bijection: Bijection[TypoUUID, UUID] = Bijection[TypoUUID, UUID](_.value)(TypoUUID.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoUUID] = JdbcDecoder[TypoUUID](
    (rs: ResultSet) => (i: Int) => {
      val v = rs.getObject(i)
      if (v eq null) null else TypoUUID(v.asInstanceOf[UUID])
    },
    "java.util.UUID"
  )
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoUUID] = JdbcEncoder.singleParamEncoder(using setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoUUID] = JsonDecoder.uuid.map(TypoUUID.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoUUID] = JsonEncoder.uuid.contramap(_.value)
  implicit lazy val ordering: Ordering[TypoUUID] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[TypoUUID] = PGType.instance[TypoUUID]("uuid", Types.OTHER)
  implicit lazy val setter: Setter[TypoUUID] = Setter.other(
    (ps, i, v) => {
      ps.setObject(
        i,
        v.value
      )
    },
    "uuid"
  )
  implicit lazy val text: Text[TypoUUID] = new Text[TypoUUID] {
    override def unsafeEncode(v: TypoUUID, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.toString, sb)
    override def unsafeArrayEncode(v: TypoUUID, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.toString, sb)
  }
}
