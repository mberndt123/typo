/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.customtypes;

import adventureworks.Text;
import java.sql.ResultSet;
import java.sql.Types;
import typo.dsl.Bijection;
import typo.dsl.PGType;
import zio.jdbc.JdbcDecoder;
import zio.jdbc.JdbcEncoder;
import zio.jdbc.SqlFragment.Setter;
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;

/** This is a type typo does not know how to handle yet. This falls back to casting to string and crossing fingers. Time to file an issue! :] */
case class TypoUnknownCitext(value: String)

object TypoUnknownCitext {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TypoUnknownCitext]] = {
    JdbcDecoder[Array[TypoUnknownCitext]]((rs: ResultSet) => (i: Int) =>
      rs.getArray(i) match {
        case null => null
        case arr => arr.getArray.asInstanceOf[Array[AnyRef]].map(x => TypoUnknownCitext(x.asInstanceOf[String]))
      },
      "Array[java.lang.String]"
    )
  }
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TypoUnknownCitext]] = JdbcEncoder.singleParamEncoder(using arraySetter)
  implicit lazy val arraySetter: Setter[Array[TypoUnknownCitext]] = {
    Setter.forSqlType((ps, i, v) =>
      ps.setArray(
        i,
        ps.getConnection.createArrayOf(
          "citext",
          v.map { vv =>
            vv.value
          }
        )
      ),
      Types.ARRAY
    )
  }
  implicit lazy val bijection: Bijection[TypoUnknownCitext, String] = Bijection[TypoUnknownCitext, String](_.value)(TypoUnknownCitext.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoUnknownCitext] = {
    JdbcDecoder[TypoUnknownCitext](
      (rs: ResultSet) => (i: Int) => {
        val v = rs.getObject(i)
        if (v eq null) null else TypoUnknownCitext(v.asInstanceOf[String])
      },
      "java.lang.String"
    )
  }
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoUnknownCitext] = JdbcEncoder.singleParamEncoder(using setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoUnknownCitext] = JsonDecoder.string.map(TypoUnknownCitext.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoUnknownCitext] = JsonEncoder.string.contramap(_.value)
  implicit lazy val pgType: PGType[TypoUnknownCitext] = PGType.instance[TypoUnknownCitext]("citext", Types.OTHER)
  implicit lazy val setter: Setter[TypoUnknownCitext] = {
    Setter.other(
      (ps, i, v) => {
        ps.setObject(
          i,
          v.value
        )
      },
      "citext"
    )
  }
  implicit lazy val text: Text[TypoUnknownCitext] = {
    new Text[TypoUnknownCitext] {
      override def unsafeEncode(v: TypoUnknownCitext, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.toString, sb)
      override def unsafeArrayEncode(v: TypoUnknownCitext, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.toString, sb)
    }
  }
}