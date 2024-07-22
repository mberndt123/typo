/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.information_schema;

import adventureworks.Text;
import anorm.Column;
import anorm.ParameterMetaData;
import anorm.ToStatement;
import java.sql.Types;
import play.api.libs.json.Reads;
import play.api.libs.json.Writes;
import typo.dsl.Bijection;

/** Domain `information_schema.character_data`
  * No constraint
  */
case class CharacterData(value: String)

object CharacterData {
  implicit lazy val arrayColumn: Column[Array[CharacterData]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[CharacterData]] = ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData).contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CharacterData, String] = Bijection[CharacterData, String](_.value)(CharacterData.apply)
  implicit lazy val column: Column[CharacterData] = Column.columnToString.map(CharacterData.apply)
  implicit lazy val parameterMetadata: ParameterMetaData[CharacterData] = {
    new ParameterMetaData[CharacterData] {
      override def sqlType: String = """"information_schema"."character_data""""
      override def jdbcType: Int = Types.OTHER
    }
  }
  implicit lazy val reads: Reads[CharacterData] = Reads.StringReads.map(CharacterData.apply)
  implicit lazy val text: Text[CharacterData] = {
    new Text[CharacterData] {
      override def unsafeEncode(v: CharacterData, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
      override def unsafeArrayEncode(v: CharacterData, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
    }
  }
  implicit lazy val toStatement: ToStatement[CharacterData] = ToStatement.stringToStatement.contramap(_.value)
  implicit lazy val writes: Writes[CharacterData] = Writes.StringWrites.contramap(_.value)
}