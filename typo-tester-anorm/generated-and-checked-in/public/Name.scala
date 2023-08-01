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

/** Domain `public.Name`
  * No constraint
  */
case class Name(value: String) extends AnyVal
object Name {
  implicit val arrayToStatement: ToStatement[Array[Name]] = implicitly[ToStatement[Array[String]]].contramap(_.map(_.value))
  implicit val bijection: Bijection[Name, String] = Bijection[Name, String](_.value)(Name.apply)
  implicit val column: Column[Name] = implicitly[Column[String]].map(Name.apply)
  implicit val ordering: Ordering[Name] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[Name] = new ParameterMetaData[Name] {
    override def sqlType: String = implicitly[ParameterMetaData[String]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[String]].jdbcType
  }
  implicit val reads: Reads[Name] = Reads.StringReads.map(Name.apply)
  implicit val toStatement: ToStatement[Name] = implicitly[ToStatement[String]].contramap(_.value)
  implicit val writes: Writes[Name] = Writes.StringWrites.contramap(_.value)
}
