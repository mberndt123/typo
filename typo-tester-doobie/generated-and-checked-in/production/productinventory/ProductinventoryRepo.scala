/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductinventoryRepo {
  def delete(compositeId: ProductinventoryId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[ProductinventoryFields, ProductinventoryRow]
  def insert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow]
  def insert(unsaved: ProductinventoryRowUnsaved): ConnectionIO[ProductinventoryRow]
  def select: SelectBuilder[ProductinventoryFields, ProductinventoryRow]
  def selectAll: Stream[ConnectionIO, ProductinventoryRow]
  def selectById(compositeId: ProductinventoryId): ConnectionIO[Option[ProductinventoryRow]]
  def update(row: ProductinventoryRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[ProductinventoryFields, ProductinventoryRow]
  def upsert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow]
}
