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

case class PgLargeobjectMetadataId(value: Long) extends AnyVal
object PgLargeobjectMetadataId {
  implicit val ordering: Ordering[PgLargeobjectMetadataId] = Ordering.by(_.value)
  
  implicit val toStatement: ToStatement[PgLargeobjectMetadataId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgLargeobjectMetadataId] = implicitly[Column[Long]].map(PgLargeobjectMetadataId.apply)
  implicit val rowParser: RowParser[PgLargeobjectMetadataId] = SqlParser.get[PgLargeobjectMetadataId]("oid")
}
