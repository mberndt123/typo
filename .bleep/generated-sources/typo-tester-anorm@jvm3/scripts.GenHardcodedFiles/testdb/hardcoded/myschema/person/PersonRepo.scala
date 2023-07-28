/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import java.sql.Connection

trait PersonRepo {
  def delete(id: PersonId)(implicit c: Connection): Boolean
  def insert(unsaved: PersonRow)(implicit c: Connection): PersonRow
  def insert(unsaved: PersonRowUnsaved)(implicit c: Connection): PersonRow
  def selectAll(implicit c: Connection): List[PersonRow]
  def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[_]])(implicit c: Connection): List[PersonRow]
  def selectById(id: PersonId)(implicit c: Connection): Option[PersonRow]
  def selectByIds(ids: Array[PersonId])(implicit c: Connection): List[PersonRow]
  def update(row: PersonRow)(implicit c: Connection): Boolean
  def updateFieldValues(id: PersonId, fieldValues: List[PersonFieldValue[_]])(implicit c: Connection): Boolean
  def upsert(unsaved: PersonRow)(implicit c: Connection): PersonRow
}
