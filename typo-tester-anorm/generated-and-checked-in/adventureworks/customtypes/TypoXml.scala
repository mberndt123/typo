/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import org.postgresql.jdbc.PgArray
import org.postgresql.jdbc.PgSQLXML
import org.postgresql.util.PGobject
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** XML */
case class TypoXml(value: String)

object TypoXml {
  implicit lazy val arrayColumn: Column[Array[TypoXml]] = Column.nonNull[Array[TypoXml]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoXml(v.asInstanceOf[PGobject].getValue)))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoXml, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayToStatement: ToStatement[Array[TypoXml]] = ToStatement[Array[TypoXml]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("xml", v.map(v => {
                                                                                                                   val obj = new PGobject
                                                                                                                   obj.setType("xml")
                                                                                                                   obj.setValue(v.value)
                                                                                                                   obj
                                                                                                                 }))))
  implicit lazy val bijection: Bijection[TypoXml, String] = Bijection[TypoXml, String](_.value)(TypoXml.apply)
  implicit lazy val column: Column[TypoXml] = Column.nonNull[TypoXml]((v1: Any, _) =>
    v1 match {
      case v: PgSQLXML => Right(TypoXml(v.getString))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgSQLXML, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val ordering: Ordering[TypoXml] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoXml] = new ParameterMetaData[TypoXml] {
    override def sqlType: String = "xml"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoXml] = Reads.StringReads.map(TypoXml.apply)
  implicit lazy val text: Text[TypoXml] = new Text[TypoXml] {
    override def unsafeEncode(v: TypoXml, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.toString, sb)
    override def unsafeArrayEncode(v: TypoXml, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.toString, sb)
  }
  implicit lazy val toStatement: ToStatement[TypoXml] = ToStatement[TypoXml]((s, index, v) => s.setObject(index, v.value))
  implicit lazy val writes: Writes[TypoXml] = Writes.StringWrites.contramap(_.value)
}
