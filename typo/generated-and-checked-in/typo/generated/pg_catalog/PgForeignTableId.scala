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

case class PgForeignTableId(value: Long) extends AnyVal
object PgForeignTableId {
  implicit val ordering: Ordering[PgForeignTableId] = Ordering.by(_.value)
  
  implicit val toStatement: ToStatement[PgForeignTableId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgForeignTableId] = implicitly[Column[Long]].map(PgForeignTableId.apply)
  implicit val rowParser: RowParser[PgForeignTableId] = SqlParser.get[PgForeignTableId]("ftrelid")
}
