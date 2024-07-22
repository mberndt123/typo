/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.store;

import adventureworks.person.businessentity.BusinessentityId;
import java.sql.Connection;
import scala.annotation.nowarn;
import typo.dsl.DeleteBuilder;
import typo.dsl.DeleteBuilder.DeleteBuilderMock;
import typo.dsl.DeleteParams;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderMock;
import typo.dsl.SelectParams;
import typo.dsl.UpdateBuilder;
import typo.dsl.UpdateBuilder.UpdateBuilderMock;
import typo.dsl.UpdateParams;

class StoreRepoMock(val toRow: Function1[StoreRowUnsaved, StoreRow], val map: scala.collection.mutable.Map[BusinessentityId, StoreRow] = scala.collection.mutable.Map.empty) extends StoreRepo {
  def delete: DeleteBuilder[StoreFields, StoreRow] = DeleteBuilderMock(DeleteParams.empty, StoreFields.structure, map)
  def deleteById(businessentityid: BusinessentityId)(implicit c: Connection): Boolean = map.remove(businessentityid).isDefined
  def deleteByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): Int = businessentityids.map(id => map.remove(id)).count(_.isDefined)
  def insert(unsaved: StoreRow)(implicit c: Connection): StoreRow = {
    val _ = if (map.contains(unsaved.businessentityid))
      sys.error(s"id ${unsaved.businessentityid} already exists")
    else
      map.put(unsaved.businessentityid, unsaved)
    
    unsaved
  }
  def insert(unsaved: StoreRowUnsaved)(implicit c: Connection): StoreRow = insert(toRow(unsaved))
  def insertStreaming(unsaved: Iterator[StoreRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.businessentityid -> row)
    }
    unsaved.size.toLong
  }
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[StoreRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.businessentityid -> row)
    }
    unsaved.size.toLong
  }
  def select: SelectBuilder[StoreFields, StoreRow] = SelectBuilderMock(StoreFields.structure, () => map.values.toList, SelectParams.empty)
  def selectAll(implicit c: Connection): List[StoreRow] = map.values.toList
  def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[StoreRow] = map.get(businessentityid)
  def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[StoreRow] = businessentityids.flatMap(map.get).toList
  def selectByIdsTracked(businessentityids: Array[BusinessentityId])(implicit c: Connection): Map[BusinessentityId, StoreRow] = {
    val byId = selectByIds(businessentityids).view.map(x => (x.businessentityid, x)).toMap
    businessentityids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  def update: UpdateBuilder[StoreFields, StoreRow] = UpdateBuilderMock(UpdateParams.empty, StoreFields.structure, map)
  def update(row: StoreRow)(implicit c: Connection): Boolean = {
    map.get(row.businessentityid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.businessentityid, row): @nowarn
        true
      case None => false
    }
  }
  def upsert(unsaved: StoreRow)(implicit c: Connection): StoreRow = {
    map.put(unsaved.businessentityid, unsaved): @nowarn
    unsaved
  }
  def upsertBatch(unsaved: Iterable[StoreRow])(implicit c: Connection): List[StoreRow] = {
    unsaved.map { row =>
      map += (row.businessentityid -> row)
      row
    }.toList
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[StoreRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.businessentityid -> row)
    }
    unsaved.size
  }
}