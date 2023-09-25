/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_type

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

class PgTypeRepoMock(map: scala.collection.mutable.Map[PgTypeId, PgTypeRow] = scala.collection.mutable.Map.empty) extends PgTypeRepo {
  override def delete(oid: PgTypeId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgTypeFields, PgTypeRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgTypeFields, map)
  }
  override def insert(unsaved: PgTypeRow)(implicit c: Connection): PgTypeRow = {
    val _ = if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    
    unsaved
  }
  override def select: SelectBuilder[PgTypeFields, PgTypeRow] = {
    SelectBuilderMock(PgTypeFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgTypeRow] = {
    map.values.toList
  }
  override def selectById(oid: PgTypeId)(implicit c: Connection): Option[PgTypeRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgTypeId])(implicit c: Connection): List[PgTypeRow] = {
    oids.flatMap(map.get).toList
  }
  override def selectByUnique(typname: String, typnamespace: /* oid */ Long)(implicit c: Connection): Option[PgTypeRow] = {
    map.values.find(v => typname == v.typname && typnamespace == v.typnamespace)
  }
  override def update(row: PgTypeRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgTypeFields, PgTypeRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgTypeFields, map)
  }
  override def upsert(unsaved: PgTypeRow)(implicit c: Connection): PgTypeRow = {
    map.put(unsaved.oid, unsaved): @nowarn
    unsaved
  }
}
