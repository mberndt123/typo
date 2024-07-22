/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public.identity_test

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `public.identity-test` */
case class IdentityTestId(value: /* max 250 chars */ String) extends AnyVal
object IdentityTestId {
  implicit lazy val arrayColumn: Column[Array[IdentityTestId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[IdentityTestId]] = ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData).contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[IdentityTestId, /* max 250 chars */ String] = Bijection[IdentityTestId, /* max 250 chars */ String](_.value)(IdentityTestId.apply)
  implicit lazy val column: Column[IdentityTestId] = Column.columnToString.map(IdentityTestId.apply)
  implicit lazy val parameterMetadata: ParameterMetaData[IdentityTestId] = new ParameterMetaData[IdentityTestId] {
    override def sqlType: String = ParameterMetaData.StringParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.StringParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[IdentityTestId] = Reads.StringReads.map(IdentityTestId.apply)
  implicit lazy val text: Text[IdentityTestId] = new Text[IdentityTestId] {
    override def unsafeEncode(v: IdentityTestId, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: IdentityTestId, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[IdentityTestId] = ToStatement.stringToStatement.contramap(_.value)
  implicit lazy val writes: Writes[IdentityTestId] = Writes.StringWrites.contramap(_.value)
}
