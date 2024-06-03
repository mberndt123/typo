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
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Money and cash types in PostgreSQL */
case class TypoMoney(value: BigDecimal)

object TypoMoney {
  implicit lazy val arrayColumn: Column[Array[TypoMoney]] = Column.nonNull[Array[TypoMoney]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoMoney(BigDecimal(v.asInstanceOf[java.math.BigDecimal]))))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoMoney, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayToStatement: ToStatement[Array[TypoMoney]] = ToStatement[Array[TypoMoney]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("money", v.map(v => v.value.bigDecimal))))
  implicit lazy val bijection: Bijection[TypoMoney, BigDecimal] = Bijection[TypoMoney, BigDecimal](_.value)(TypoMoney.apply)
  implicit lazy val column: Column[TypoMoney] = Column.nonNull[TypoMoney]((v1: Any, _) =>
    v1 match {
      case v: java.math.BigDecimal => Right(TypoMoney(BigDecimal(v)))
      case other => Left(TypeDoesNotMatch(s"Expected instance of java.math.BigDecimal, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val ordering: Ordering[TypoMoney] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoMoney] = new ParameterMetaData[TypoMoney] {
    override def sqlType: String = "money"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoMoney] = Reads.bigDecReads.map(TypoMoney.apply)
  implicit lazy val text: Text[TypoMoney] = new Text[TypoMoney] {
    override def unsafeEncode(v: TypoMoney, sb: StringBuilder) = Text.bigDecimalInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: TypoMoney, sb: StringBuilder) = Text.bigDecimalInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[TypoMoney] = ToStatement[TypoMoney]((s, index, v) => s.setObject(index, v.value.bigDecimal))
  implicit lazy val writes: Writes[TypoMoney] = Writes.BigDecimalWrites.contramap(_.value)
}
