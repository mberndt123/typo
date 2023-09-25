/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_sequence

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

class PgSequenceRepoMock(map: scala.collection.mutable.Map[PgSequenceId, PgSequenceRow] = scala.collection.mutable.Map.empty) extends PgSequenceRepo {
  override def delete(seqrelid: PgSequenceId)(implicit c: Connection): Boolean = {
    map.remove(seqrelid).isDefined
  }
  override def delete: DeleteBuilder[PgSequenceFields, PgSequenceRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgSequenceFields, map)
  }
  override def insert(unsaved: PgSequenceRow)(implicit c: Connection): PgSequenceRow = {
    val _ = if (map.contains(unsaved.seqrelid))
      sys.error(s"id ${unsaved.seqrelid} already exists")
    else
      map.put(unsaved.seqrelid, unsaved)
    
    unsaved
  }
  override def select: SelectBuilder[PgSequenceFields, PgSequenceRow] = {
    SelectBuilderMock(PgSequenceFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgSequenceRow] = {
    map.values.toList
  }
  override def selectById(seqrelid: PgSequenceId)(implicit c: Connection): Option[PgSequenceRow] = {
    map.get(seqrelid)
  }
  override def selectByIds(seqrelids: Array[PgSequenceId])(implicit c: Connection): List[PgSequenceRow] = {
    seqrelids.flatMap(map.get).toList
  }
  override def update(row: PgSequenceRow)(implicit c: Connection): Boolean = {
    map.get(row.seqrelid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.seqrelid, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgSequenceFields, PgSequenceRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgSequenceFields, map)
  }
  override def upsert(unsaved: PgSequenceRow)(implicit c: Connection): PgSequenceRow = {
    map.put(unsaved.seqrelid, unsaved): @nowarn
    unsaved
  }
}
