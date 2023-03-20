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

case class PgInitPrivsId(objoid: Long, classoid: Long, objsubid: Int)
object PgInitPrivsId {
  implicit val ordering: Ordering[PgInitPrivsId] = Ordering.by(x => (x.objoid, x.classoid, x.objsubid))
  
  implicit val rowParser: RowParser[PgInitPrivsId] = { row =>
    Success(
      PgInitPrivsId(
        objoid = row[Long]("objoid"),
        classoid = row[Long]("classoid"),
        objsubid = row[Int]("objsubid")
      )
    )
  }

}
