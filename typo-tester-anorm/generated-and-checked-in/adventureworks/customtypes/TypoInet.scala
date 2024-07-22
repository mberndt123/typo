/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.customtypes;

import adventureworks.Text;
import anorm.Column;
import anorm.ParameterMetaData;
import anorm.ToStatement;
import anorm.TypeDoesNotMatch;
import java.sql.Types;
import org.postgresql.jdbc.PgArray;
import org.postgresql.util.PGobject;
import play.api.libs.json.Reads;
import play.api.libs.json.Writes;
import typo.dsl.Bijection;

/** inet (via PGObject) */
case class TypoInet(value: String)

object TypoInet {
  implicit lazy val arrayColumn: Column[Array[TypoInet]] = {
    Column.nonNull[Array[TypoInet]]((v1: Any, _) =>
      v1 match {
          case v: PgArray =>
           v.getArray match {
             case v: Array[?] =>
               Right(v.map(v => TypoInet(v.asInstanceOf[PGobject].getValue)))
             case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoInet, got ${other.getClass.getName}"))
           }
        case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
      }
    )
  }
  implicit lazy val arrayToStatement: ToStatement[Array[TypoInet]] = {
    ToStatement[Array[TypoInet]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("inet", v.map(v => {
                                                                                                                       val obj = new PGobject
                                                                                                                       obj.setType("inet")
                                                                                                                       obj.setValue(v.value)
                                                                                                                       obj
                                                                                                                     }))))
  }
  implicit lazy val bijection: Bijection[TypoInet, String] = Bijection[TypoInet, String](_.value)(TypoInet.apply)
  implicit lazy val column: Column[TypoInet] = {
    Column.nonNull[TypoInet]((v1: Any, _) =>
      v1 match {
        case v: PGobject => Right(TypoInet(v.getValue))
        case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.util.PGobject, got ${other.getClass.getName}"))
      }
    )
  }
  implicit lazy val parameterMetadata: ParameterMetaData[TypoInet] = {
    new ParameterMetaData[TypoInet] {
      override def sqlType: String = "inet"
      override def jdbcType: Int = Types.OTHER
    }
  }
  implicit lazy val reads: Reads[TypoInet] = Reads.StringReads.map(TypoInet.apply)
  implicit lazy val text: Text[TypoInet] = {
    new Text[TypoInet] {
      override def unsafeEncode(v: TypoInet, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
      override def unsafeArrayEncode(v: TypoInet, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
    }
  }
  implicit lazy val toStatement: ToStatement[TypoInet] = {
    ToStatement[TypoInet]((s, index, v) => s.setObject(index, {
                                                                val obj = new PGobject
                                                                obj.setType("inet")
                                                                obj.setValue(v.value)
                                                                obj
                                                              }))
  }
  implicit lazy val writes: Writes[TypoInet] = Writes.StringWrites.contramap(_.value)
}