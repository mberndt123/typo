/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait StateprovinceRepo {
  def delete(stateprovinceid: StateprovinceId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[StateprovinceFields, StateprovinceRow]
  def insert(unsaved: StateprovinceRow): ConnectionIO[StateprovinceRow]
  def insert(unsaved: StateprovinceRowUnsaved): ConnectionIO[StateprovinceRow]
  def select: SelectBuilder[StateprovinceFields, StateprovinceRow]
  def selectAll: Stream[ConnectionIO, StateprovinceRow]
  def selectById(stateprovinceid: StateprovinceId): ConnectionIO[Option[StateprovinceRow]]
  def selectByIds(stateprovinceids: Array[StateprovinceId]): Stream[ConnectionIO, StateprovinceRow]
  def update(row: StateprovinceRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[StateprovinceFields, StateprovinceRow]
  def upsert(unsaved: StateprovinceRow): ConnectionIO[StateprovinceRow]
}
