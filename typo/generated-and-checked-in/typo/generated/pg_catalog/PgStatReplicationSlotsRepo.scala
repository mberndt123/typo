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

import java.sql.Connection

trait PgStatReplicationSlotsRepo {
  def selectAll(implicit c: Connection): List[PgStatReplicationSlotsRow]
  def selectByFieldValues(fieldValues: List[PgStatReplicationSlotsFieldValue[_]])(implicit c: Connection): List[PgStatReplicationSlotsRow]
}
