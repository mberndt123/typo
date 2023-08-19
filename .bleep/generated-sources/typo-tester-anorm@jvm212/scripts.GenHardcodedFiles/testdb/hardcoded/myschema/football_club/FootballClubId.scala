/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package football_club

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `myschema.football_club` */
case class FootballClubId(value: Long) extends AnyVal
object FootballClubId {
  implicit lazy val arrayColumn: Column[Array[FootballClubId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[FootballClubId]] = testdb.hardcoded.LongArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[FootballClubId, Long] = Bijection[FootballClubId, Long](_.value)(FootballClubId.apply)
  implicit lazy val column: Column[FootballClubId] = Column.columnToLong.map(FootballClubId.apply)
  implicit lazy val ordering: Ordering[FootballClubId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[FootballClubId] = new ParameterMetaData[FootballClubId] {
    override def sqlType: String = ParameterMetaData.LongParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.LongParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[FootballClubId] = Reads.LongReads.map(FootballClubId.apply)
  implicit lazy val toStatement: ToStatement[FootballClubId] = ToStatement.longToStatement.contramap(_.value)
  implicit lazy val writes: Writes[FootballClubId] = Writes.LongWrites.contramap(_.value)
}
