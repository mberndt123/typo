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
  implicit val arrayToStatement: ToStatement[Array[FootballClubId]] = implicitly[ToStatement[Array[Long]]].contramap(_.map(_.value))
  implicit val bijection: Bijection[FootballClubId, Long] = Bijection[FootballClubId, Long](_.value)(FootballClubId.apply)
  implicit val column: Column[FootballClubId] = implicitly[Column[Long]].map(FootballClubId.apply)
  implicit val ordering: Ordering[FootballClubId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[FootballClubId] = new ParameterMetaData[FootballClubId] {
    override def sqlType: String = implicitly[ParameterMetaData[Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Long]].jdbcType
  }
  implicit val reads: Reads[FootballClubId] = Reads.LongReads.map(FootballClubId.apply)
  implicit val toStatement: ToStatement[FootballClubId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val writes: Writes[FootballClubId] = Writes.LongWrites.contramap(_.value)
}
