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

trait PgCollationRepo {
  def selectAll(implicit c: Connection): List[PgCollationRow]
  def selectById(oid: PgCollationId)(implicit c: Connection): Option[PgCollationRow]
  def selectByIds(oids: List[PgCollationId])(implicit c: Connection): List[PgCollationRow]
  def selectByFieldValues(fieldValues: List[PgCollationFieldValue[_]])(implicit c: Connection): List[PgCollationRow]
  def updateFieldValues(oid: PgCollationId, fieldValues: List[PgCollationFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgCollationId, unsaved: PgCollationRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgCollationId)(implicit c: Connection): Boolean
  def selectByUnique(collname: String, collencoding: Int, collnamespace: Long)(implicit c: Connection): Option[PgCollationRow]
}
