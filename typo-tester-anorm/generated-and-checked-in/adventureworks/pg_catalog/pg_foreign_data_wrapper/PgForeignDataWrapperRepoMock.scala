/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_data_wrapper

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

class PgForeignDataWrapperRepoMock(map: scala.collection.mutable.Map[PgForeignDataWrapperId, PgForeignDataWrapperRow] = scala.collection.mutable.Map.empty) extends PgForeignDataWrapperRepo {
  override def delete(oid: PgForeignDataWrapperId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgForeignDataWrapperFields, PgForeignDataWrapperRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgForeignDataWrapperFields, map)
  }
  override def insert(unsaved: PgForeignDataWrapperRow)(implicit c: Connection): PgForeignDataWrapperRow = {
    val _ = if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    
    unsaved
  }
  override def select: SelectBuilder[PgForeignDataWrapperFields, PgForeignDataWrapperRow] = {
    SelectBuilderMock(PgForeignDataWrapperFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgForeignDataWrapperRow] = {
    map.values.toList
  }
  override def selectById(oid: PgForeignDataWrapperId)(implicit c: Connection): Option[PgForeignDataWrapperRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgForeignDataWrapperId])(implicit c: Connection): List[PgForeignDataWrapperRow] = {
    oids.flatMap(map.get).toList
  }
  override def selectByUnique(fdwname: String)(implicit c: Connection): Option[PgForeignDataWrapperRow] = {
    map.values.find(v => fdwname == v.fdwname)
  }
  override def update(row: PgForeignDataWrapperRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgForeignDataWrapperFields, PgForeignDataWrapperRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgForeignDataWrapperFields, map)
  }
  override def upsert(unsaved: PgForeignDataWrapperRow)(implicit c: Connection): PgForeignDataWrapperRow = {
    map.put(unsaved.oid, unsaved): @nowarn
    unsaved
  }
}
