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

trait PgConstraintRepo {
  def selectAll(implicit c: Connection): List[PgConstraintRow]
  def selectById(oid: PgConstraintId)(implicit c: Connection): Option[PgConstraintRow]
  def selectByIds(oids: List[PgConstraintId])(implicit c: Connection): List[PgConstraintRow]
  def selectByFieldValues(fieldValues: List[PgConstraintFieldValue[_]])(implicit c: Connection): List[PgConstraintRow]
  def updateFieldValues(oid: PgConstraintId, fieldValues: List[PgConstraintFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgConstraintId, unsaved: PgConstraintRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgConstraintId)(implicit c: Connection): Boolean
  def selectByUnique(conrelid: Long, contypid: Long, conname: String)(implicit c: Connection): Option[PgConstraintRow]
}
