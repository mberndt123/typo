/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Domain `public.Flag`
  * No constraint
  */
case class Flag(value: Boolean) extends AnyVal
object Flag {
  implicit val arrayToStatement: ToStatement[Array[Flag]] = implicitly[ToStatement[Array[Boolean]]].contramap(_.map(_.value))
  implicit val bijection: Bijection[Flag, Boolean] = Bijection[Flag, Boolean](_.value)(Flag.apply)
  implicit val column: Column[Flag] = implicitly[Column[Boolean]].map(Flag.apply)
  implicit val ordering: Ordering[Flag] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[Flag] = new ParameterMetaData[Flag] {
    override def sqlType: String = implicitly[ParameterMetaData[Boolean]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Boolean]].jdbcType
  }
  implicit val reads: Reads[Flag] = Reads.BooleanReads.map(Flag.apply)
  implicit val toStatement: ToStatement[Flag] = implicitly[ToStatement[Boolean]].contramap(_.value)
  implicit val writes: Writes[Flag] = Writes.BooleanWrites.contramap(_.value)
}
