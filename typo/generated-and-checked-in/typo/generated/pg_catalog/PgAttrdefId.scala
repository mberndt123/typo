/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement

case class PgAttrdefId(value: Long) extends AnyVal
object PgAttrdefId {
  implicit val ordering: Ordering[PgAttrdefId] = Ordering.by(_.value)
  
  implicit val toStatement: ToStatement[PgAttrdefId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgAttrdefId] = implicitly[Column[Long]].map(PgAttrdefId.apply)
  implicit val rowParser: RowParser[PgAttrdefId] = SqlParser.get[PgAttrdefId]("oid")
}
