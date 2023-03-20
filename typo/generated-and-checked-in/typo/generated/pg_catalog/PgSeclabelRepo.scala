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

trait PgSeclabelRepo {
  def selectAll(implicit c: Connection): List[PgSeclabelRow]
  def selectById(compositeId: PgSeclabelId)(implicit c: Connection): Option[PgSeclabelRow]
  def selectByFieldValues(fieldValues: List[PgSeclabelFieldValue[_]])(implicit c: Connection): List[PgSeclabelRow]
  def updateFieldValues(compositeId: PgSeclabelId, fieldValues: List[PgSeclabelFieldValue[_]])(implicit c: Connection): Int
  def insert(compositeId: PgSeclabelId, unsaved: PgSeclabelRowUnsaved)(implicit c: Connection): Unit
  def delete(compositeId: PgSeclabelId)(implicit c: Connection): Boolean
}
