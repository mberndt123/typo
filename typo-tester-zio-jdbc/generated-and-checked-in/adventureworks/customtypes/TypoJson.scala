/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.customtypes;

import adventureworks.Text;
import java.sql.ResultSet;
import java.sql.Types;
import org.postgresql.util.PGobject;
import typo.dsl.Bijection;
import typo.dsl.PGType;
import zio.jdbc.JdbcDecoder;
import zio.jdbc.JdbcEncoder;
import zio.jdbc.SqlFragment.Setter;
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;

/** json (via PGObject) */
case class TypoJson(value: String)

object TypoJson {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TypoJson]] = {
    JdbcDecoder[Array[TypoJson]]((rs: ResultSet) => (i: Int) =>
      rs.getArray(i) match {
        case null => null
        case arr => arr.getArray.asInstanceOf[Array[AnyRef]].map(x => TypoJson(x.asInstanceOf[String]))
      },
      "Array[org.postgresql.util.PGobject]"
    )
  }
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TypoJson]] = JdbcEncoder.singleParamEncoder(using arraySetter)
  implicit lazy val arraySetter: Setter[Array[TypoJson]] = {
    Setter.forSqlType((ps, i, v) =>
      ps.setArray(
        i,
        ps.getConnection.createArrayOf(
          "json",
          v.map { vv =>
            {
              val obj = new PGobject
              obj.setType("json")
              obj.setValue(vv.value)
              obj
            }
          }
        )
      ),
      Types.ARRAY
    )
  }
  implicit lazy val bijection: Bijection[TypoJson, String] = Bijection[TypoJson, String](_.value)(TypoJson.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoJson] = {
    JdbcDecoder[TypoJson](
      (rs: ResultSet) => (i: Int) => {
        val v = rs.getObject(i)
        if (v eq null) null else TypoJson(v.asInstanceOf[PGobject].getValue)
      },
      "org.postgresql.util.PGobject"
    )
  }
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoJson] = JdbcEncoder.singleParamEncoder(using setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoJson] = JsonDecoder.string.map(TypoJson.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoJson] = JsonEncoder.string.contramap(_.value)
  implicit lazy val pgType: PGType[TypoJson] = PGType.instance[TypoJson]("json", Types.OTHER)
  implicit lazy val setter: Setter[TypoJson] = {
    Setter.other(
      (ps, i, v) => {
        ps.setObject(
          i,
          {
            val obj = new PGobject
            obj.setType("json")
            obj.setValue(v.value)
            obj
          }
        )
      },
      "json"
    )
  }
  implicit lazy val text: Text[TypoJson] = {
    new Text[TypoJson] {
      override def unsafeEncode(v: TypoJson, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
      override def unsafeArrayEncode(v: TypoJson, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
    }
  }
}