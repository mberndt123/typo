/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.scrapreason

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `production.scrapreason` */
case class ScrapreasonId(value: Int) extends AnyVal
object ScrapreasonId {
  implicit lazy val arrayColumn: Column[Array[ScrapreasonId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[ScrapreasonId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ScrapreasonId, Int] = Bijection[ScrapreasonId, Int](_.value)(ScrapreasonId.apply)
  implicit lazy val column: Column[ScrapreasonId] = Column.columnToInt.map(ScrapreasonId.apply)
  implicit lazy val ordering: Ordering[ScrapreasonId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[ScrapreasonId] = new ParameterMetaData[ScrapreasonId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[ScrapreasonId] = Reads.IntReads.map(ScrapreasonId.apply)
  implicit lazy val text: Text[ScrapreasonId] = new Text[ScrapreasonId] {
    override def unsafeEncode(v: ScrapreasonId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ScrapreasonId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[ScrapreasonId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[ScrapreasonId] = Writes.IntWrites.contramap(_.value)
}
