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

import anorm.RowParser
import anorm.Success

case class PgShdescriptionId(objoid: Long, classoid: Long)
object PgShdescriptionId {
  implicit val ordering: Ordering[PgShdescriptionId] = Ordering.by(x => (x.objoid, x.classoid))
  
  implicit val rowParser: RowParser[PgShdescriptionId] = { row =>
    Success(
      PgShdescriptionId(
        objoid = row[Long]("objoid"),
        classoid = row[Long]("classoid")
      )
    )
  }

}
