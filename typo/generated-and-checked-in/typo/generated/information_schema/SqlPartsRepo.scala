/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import java.sql.Connection

trait SqlPartsRepo {
  def selectAll(implicit c: Connection): List[SqlPartsRow]
  def selectByFieldValues(fieldValues: List[SqlPartsFieldValue[_]])(implicit c: Connection): List[SqlPartsRow]
}
