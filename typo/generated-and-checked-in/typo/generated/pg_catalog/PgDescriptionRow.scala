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

case class PgDescriptionRow(
  objoid: Long,
  classoid: Long,
  objsubid: Int,
  description: String
){
  val compositeId: PgDescriptionId = PgDescriptionId(objoid, classoid, objsubid)
}

object PgDescriptionRow {
  implicit val rowParser: RowParser[PgDescriptionRow] = { row =>
    Success(
      PgDescriptionRow(
        objoid = row[Long]("objoid"),
        classoid = row[Long]("classoid"),
        objsubid = row[Int]("objsubid"),
        description = row[String]("description")
      )
    )
  }

  
}
