/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductmodelillustrationRepo {
  def delete(compositeId: ProductmodelillustrationId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow]
  def insert(unsaved: ProductmodelillustrationRow): ConnectionIO[ProductmodelillustrationRow]
  def insert(unsaved: ProductmodelillustrationRowUnsaved): ConnectionIO[ProductmodelillustrationRow]
  def select: SelectBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow]
  def selectAll: Stream[ConnectionIO, ProductmodelillustrationRow]
  def selectById(compositeId: ProductmodelillustrationId): ConnectionIO[Option[ProductmodelillustrationRow]]
  def update(row: ProductmodelillustrationRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow]
  def upsert(unsaved: ProductmodelillustrationRow): ConnectionIO[ProductmodelillustrationRow]
}
