/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_dict

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class PgTsDictRepoMock(map: scala.collection.mutable.Map[PgTsDictId, PgTsDictRow] = scala.collection.mutable.Map.empty) extends PgTsDictRepo {
  override def delete(oid: PgTsDictId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgTsDictFields, PgTsDictRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgTsDictFields, map)
  }
  override def insert(unsaved: PgTsDictRow)(implicit c: Connection): PgTsDictRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgTsDictFields, PgTsDictRow] = {
    SelectBuilderMock(PgTsDictFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgTsDictRow] = {
    map.values.toList
  }
  override def selectById(oid: PgTsDictId)(implicit c: Connection): Option[PgTsDictRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgTsDictId])(implicit c: Connection): List[PgTsDictRow] = {
    oids.flatMap(map.get).toList
  }
  override def update(row: PgTsDictRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgTsDictFields, PgTsDictRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgTsDictFields, map)
  }
  override def upsert(unsaved: PgTsDictRow)(implicit c: Connection): PgTsDictRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}
