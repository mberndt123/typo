/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import java.sql.ResultSet
import java.sql.Types
import org.postgresql.util.PGobject
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** record (via PGObject) */
case class TypoRecord(value: String)

object TypoRecord {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TypoRecord]] = JdbcDecoder[Array[TypoRecord]]((rs: ResultSet) => (i: Int) =>
    rs.getArray(i) match {
      case null => null
      case arr => arr.getArray.asInstanceOf[Array[AnyRef]].map(x => TypoRecord(x.asInstanceOf[PGobject].getValue))
    },
    "Array[org.postgresql.util.PGobject]"
  )
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TypoRecord]] = JdbcEncoder.singleParamEncoder(using arraySetter)
  implicit lazy val arraySetter: Setter[Array[TypoRecord]] = Setter.forSqlType((ps, i, v) =>
    ps.setArray(
      i,
      ps.getConnection.createArrayOf(
        "record",
        v.map { vv =>
          {
            val obj = new PGobject
            obj.setType("record")
            obj.setValue(vv.value)
            obj
          }
        }
      )
    ),
    Types.ARRAY
  )
  implicit lazy val bijection: Bijection[TypoRecord, String] = Bijection[TypoRecord, String](_.value)(TypoRecord.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoRecord] = JdbcDecoder[TypoRecord](
    (rs: ResultSet) => (i: Int) => {
      val v = rs.getObject(i)
      if (v eq null) null else TypoRecord(v.asInstanceOf[PGobject].getValue)
    },
    "org.postgresql.util.PGobject"
  )
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoRecord] = JdbcEncoder.singleParamEncoder(using setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoRecord] = JsonDecoder.string.map(TypoRecord.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoRecord] = JsonEncoder.string.contramap(_.value)
  implicit lazy val ordering: Ordering[TypoRecord] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[TypoRecord] = PGType.instance[TypoRecord]("record", Types.OTHER)
  implicit lazy val setter: Setter[TypoRecord] = Setter.other(
    (ps, i, v) => {
      ps.setObject(
        i,
        {
          val obj = new PGobject
          obj.setType("record")
          obj.setValue(v.value)
          obj
        }
      )
    },
    "record"
  )
  implicit lazy val text: Text[TypoRecord] = new Text[TypoRecord] {
    override def unsafeEncode(v: TypoRecord, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: TypoRecord, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
}
