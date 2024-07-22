/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public;

import adventureworks.Text;
import anorm.Column;
import anorm.ParameterMetaData;
import anorm.ToStatement;
import java.sql.Types;
import play.api.libs.json.Reads;
import play.api.libs.json.Writes;
import typo.dsl.Bijection;

/** Domain `public.Name`
  * No constraint
  */
case class Name(value: String)

object Name {
  implicit lazy val arrayColumn: Column[Array[Name]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[Name]] = ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData).contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[Name, String] = Bijection[Name, String](_.value)(Name.apply)
  implicit lazy val column: Column[Name] = Column.columnToString.map(Name.apply)
  implicit lazy val parameterMetadata: ParameterMetaData[Name] = {
    new ParameterMetaData[Name] {
      override def sqlType: String = """"public"."Name""""
      override def jdbcType: Int = Types.OTHER
    }
  }
  implicit lazy val reads: Reads[Name] = Reads.StringReads.map(Name.apply)
  implicit lazy val text: Text[Name] = {
    new Text[Name] {
      override def unsafeEncode(v: Name, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
      override def unsafeArrayEncode(v: Name, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
    }
  }
  implicit lazy val toStatement: ToStatement[Name] = ToStatement.stringToStatement.contramap(_.value)
  implicit lazy val writes: Writes[Name] = Writes.StringWrites.contramap(_.value)
}