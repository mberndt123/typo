/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded.myschema.marital_status

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import testdb.hardcoded.Text
import typo.dsl.Bijection

/** Type for the primary key of table `myschema.marital_status` */
case class MaritalStatusId(value: Long) extends AnyVal
object MaritalStatusId {
  implicit lazy val arrayColumn: Column[Array[MaritalStatusId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[MaritalStatusId]] = testdb.hardcoded.LongArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[MaritalStatusId, Long] = Bijection[MaritalStatusId, Long](_.value)(MaritalStatusId.apply)
  implicit lazy val column: Column[MaritalStatusId] = Column.columnToLong.map(MaritalStatusId.apply)
  implicit lazy val ordering: Ordering[MaritalStatusId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[MaritalStatusId] = new ParameterMetaData[MaritalStatusId] {
    override def sqlType: String = ParameterMetaData.LongParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.LongParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[MaritalStatusId] = Reads.LongReads.map(MaritalStatusId.apply)
  implicit lazy val text: Text[MaritalStatusId] = new Text[MaritalStatusId] {
    override def unsafeEncode(v: MaritalStatusId, sb: StringBuilder) = Text.longInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: MaritalStatusId, sb: StringBuilder) = Text.longInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[MaritalStatusId] = ToStatement.longToStatement.contramap(_.value)
  implicit lazy val writes: Writes[MaritalStatusId] = Writes.LongWrites.contramap(_.value)
}
