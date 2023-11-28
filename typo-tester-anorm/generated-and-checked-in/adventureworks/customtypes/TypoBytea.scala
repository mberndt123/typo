/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** This represents the bytea datatype in PostgreSQL */
case class TypoBytea(value: Array[Byte])

object TypoBytea {
  implicit lazy val bijection: Bijection[TypoBytea, Array[Byte]] = Bijection[TypoBytea, Array[Byte]](_.value)(TypoBytea.apply)
  implicit lazy val column: Column[TypoBytea] = Column.nonNull[TypoBytea]((v1: Any, _) =>
    v1 match {
      case v: Array[Byte] => Right(TypoBytea(v))
      case other => Left(TypeDoesNotMatch(s"Expected instance of Array[scala.Byte], got ${other.getClass.getName}"))
    }
  )
  implicit def ordering(implicit O0: Ordering[Array[Byte]]): Ordering[TypoBytea] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoBytea] = new ParameterMetaData[TypoBytea] {
    override def sqlType: String = "bytea"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoBytea] = Reads.ArrayReads[Byte](Reads.ByteReads, implicitly).map(TypoBytea.apply)
  implicit lazy val text: Text[TypoBytea] = new Text[TypoBytea] {
    override def unsafeEncode(v: TypoBytea, sb: StringBuilder) = Text.byteArrayInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: TypoBytea, sb: StringBuilder) = Text.byteArrayInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[TypoBytea] = ToStatement[TypoBytea]((s, index, v) => s.setObject(index, v.value))
  implicit lazy val writes: Writes[TypoBytea] = Writes.arrayWrites[Byte](implicitly, Writes.ByteWrites).contramap(_.value)
}
