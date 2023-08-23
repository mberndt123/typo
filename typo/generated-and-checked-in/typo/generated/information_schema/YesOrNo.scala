/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Domain `information_schema.yes_or_no`
  * Constraint: CHECK (((VALUE)::text = ANY ((ARRAY['YES'::character varying, 'NO'::character varying])::text[])))
  */
case class YesOrNo(value: String) extends AnyVal
object YesOrNo {
  implicit lazy val arrayColumn: Column[Array[YesOrNo]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[YesOrNo]] = ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData).contramap(_.map(_.value))
  implicit lazy val column: Column[YesOrNo] = Column.columnToString.map(YesOrNo.apply)
  implicit lazy val ordering: Ordering[YesOrNo] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[YesOrNo] = new ParameterMetaData[YesOrNo] {
    override def sqlType: String = ParameterMetaData.StringParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.StringParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[YesOrNo] = Reads.StringReads.map(YesOrNo.apply)
  implicit lazy val toStatement: ToStatement[YesOrNo] = ToStatement.stringToStatement.contramap(_.value)
  implicit lazy val writes: Writes[YesOrNo] = Writes.StringWrites.contramap(_.value)
}