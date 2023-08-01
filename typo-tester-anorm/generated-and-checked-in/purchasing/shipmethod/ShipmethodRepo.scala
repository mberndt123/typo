/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ShipmethodRepo {
  def delete(shipmethodid: ShipmethodId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[ShipmethodFields, ShipmethodRow]
  def insert(unsaved: ShipmethodRow)(implicit c: Connection): ShipmethodRow
  def insert(unsaved: ShipmethodRowUnsaved)(implicit c: Connection): ShipmethodRow
  def select: SelectBuilder[ShipmethodFields, ShipmethodRow]
  def selectAll(implicit c: Connection): List[ShipmethodRow]
  def selectById(shipmethodid: ShipmethodId)(implicit c: Connection): Option[ShipmethodRow]
  def selectByIds(shipmethodids: Array[ShipmethodId])(implicit c: Connection): List[ShipmethodRow]
  def update(row: ShipmethodRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[ShipmethodFields, ShipmethodRow]
  def upsert(unsaved: ShipmethodRow)(implicit c: Connection): ShipmethodRow
}
