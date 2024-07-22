/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.culture

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

class CultureRepoMock(toRow: Function1[CultureRowUnsaved, CultureRow],
                      map: scala.collection.mutable.Map[CultureId, CultureRow] = scala.collection.mutable.Map.empty) extends CultureRepo {
  override def delete: DeleteBuilder[CultureFields, CultureRow] = {
    DeleteBuilderMock(DeleteParams.empty, CultureFields.structure, map)
  }
  override def deleteById(cultureid: CultureId)(implicit c: Connection): Boolean = {
    map.remove(cultureid).isDefined
  }
  override def deleteByIds(cultureids: Array[CultureId])(implicit c: Connection): Int = {
    cultureids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: CultureRow)(implicit c: Connection): CultureRow = {
    val _ = if (map.contains(unsaved.cultureid))
      sys.error(s"id ${unsaved.cultureid} already exists")
    else
      map.put(unsaved.cultureid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: CultureRowUnsaved)(implicit c: Connection): CultureRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[CultureRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.cultureid -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[CultureRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.cultureid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[CultureFields, CultureRow] = {
    SelectBuilderMock(CultureFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[CultureRow] = {
    map.values.toList
  }
  override def selectById(cultureid: CultureId)(implicit c: Connection): Option[CultureRow] = {
    map.get(cultureid)
  }
  override def selectByIds(cultureids: Array[CultureId])(implicit c: Connection): List[CultureRow] = {
    cultureids.flatMap(map.get).toList
  }
  override def selectByIdsTracked(cultureids: Array[CultureId])(implicit c: Connection): Map[CultureId, CultureRow] = {
    val byId = selectByIds(cultureids).view.map(x => (x.cultureid, x)).toMap
    cultureids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[CultureFields, CultureRow] = {
    UpdateBuilderMock(UpdateParams.empty, CultureFields.structure, map)
  }
  override def update(row: CultureRow)(implicit c: Connection): Boolean = {
    map.get(row.cultureid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.cultureid, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: CultureRow)(implicit c: Connection): CultureRow = {
    map.put(unsaved.cultureid, unsaved): @nowarn
    unsaved
  }
  override def upsertBatch(unsaved: Iterable[CultureRow])(implicit c: Connection): List[CultureRow] = {
    unsaved.map { row =>
      map += (row.cultureid -> row)
      row
    }.toList
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[CultureRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.cultureid -> row)
    }
    unsaved.size
  }
}
