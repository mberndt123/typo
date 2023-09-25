/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_seclabel

import java.sql.Connection
import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class PgSeclabelRepoMock(map: scala.collection.mutable.Map[PgSeclabelId, PgSeclabelRow] = scala.collection.mutable.Map.empty) extends PgSeclabelRepo {
  override def delete(compositeId: PgSeclabelId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def delete: DeleteBuilder[PgSeclabelFields, PgSeclabelRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgSeclabelFields, map)
  }
  override def insert(unsaved: PgSeclabelRow)(implicit c: Connection): PgSeclabelRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def select: SelectBuilder[PgSeclabelFields, PgSeclabelRow] = {
    SelectBuilderMock(PgSeclabelFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgSeclabelRow] = {
    map.values.toList
  }
  override def selectById(compositeId: PgSeclabelId)(implicit c: Connection): Option[PgSeclabelRow] = {
    map.get(compositeId)
  }
  override def update(row: PgSeclabelRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgSeclabelFields, PgSeclabelRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgSeclabelFields, map)
  }
  override def upsert(unsaved: PgSeclabelRow)(implicit c: Connection): PgSeclabelRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
}
