/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_init_privs

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

class PgInitPrivsRepoMock(map: scala.collection.mutable.Map[PgInitPrivsId, PgInitPrivsRow] = scala.collection.mutable.Map.empty) extends PgInitPrivsRepo {
  override def delete(compositeId: PgInitPrivsId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def delete: DeleteBuilder[PgInitPrivsFields, PgInitPrivsRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgInitPrivsFields, map)
  }
  override def insert(unsaved: PgInitPrivsRow)(implicit c: Connection): PgInitPrivsRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def select: SelectBuilder[PgInitPrivsFields, PgInitPrivsRow] = {
    SelectBuilderMock(PgInitPrivsFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgInitPrivsRow] = {
    map.values.toList
  }
  override def selectById(compositeId: PgInitPrivsId)(implicit c: Connection): Option[PgInitPrivsRow] = {
    map.get(compositeId)
  }
  override def update(row: PgInitPrivsRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgInitPrivsFields, PgInitPrivsRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgInitPrivsFields, map)
  }
  override def upsert(unsaved: PgInitPrivsRow)(implicit c: Connection): PgInitPrivsRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
}
