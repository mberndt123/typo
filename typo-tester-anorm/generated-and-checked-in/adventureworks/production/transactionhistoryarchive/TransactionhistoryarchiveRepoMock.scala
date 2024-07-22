/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.transactionhistoryarchive;

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

class TransactionhistoryarchiveRepoMock(val toRow: Function1[TransactionhistoryarchiveRowUnsaved, TransactionhistoryarchiveRow], val map: scala.collection.mutable.Map[TransactionhistoryarchiveId, TransactionhistoryarchiveRow] = scala.collection.mutable.Map.empty) extends TransactionhistoryarchiveRepo {
  def delete: DeleteBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = DeleteBuilderMock(DeleteParams.empty, TransactionhistoryarchiveFields.structure, map)
  def deleteById(transactionid: TransactionhistoryarchiveId)(implicit c: Connection): Boolean = map.remove(transactionid).isDefined
  def deleteByIds(transactionids: Array[TransactionhistoryarchiveId])(implicit c: Connection): Int = transactionids.map(id => map.remove(id)).count(_.isDefined)
  def insert(unsaved: TransactionhistoryarchiveRow)(implicit c: Connection): TransactionhistoryarchiveRow = {
    val _ = if (map.contains(unsaved.transactionid))
      sys.error(s"id ${unsaved.transactionid} already exists")
    else
      map.put(unsaved.transactionid, unsaved)
    
    unsaved
  }
  def insert(unsaved: TransactionhistoryarchiveRowUnsaved)(implicit c: Connection): TransactionhistoryarchiveRow = insert(toRow(unsaved))
  def insertStreaming(unsaved: Iterator[TransactionhistoryarchiveRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.transactionid -> row)
    }
    unsaved.size.toLong
  }
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[TransactionhistoryarchiveRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.transactionid -> row)
    }
    unsaved.size.toLong
  }
  def select: SelectBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = SelectBuilderMock(TransactionhistoryarchiveFields.structure, () => map.values.toList, SelectParams.empty)
  def selectAll(implicit c: Connection): List[TransactionhistoryarchiveRow] = map.values.toList
  def selectById(transactionid: TransactionhistoryarchiveId)(implicit c: Connection): Option[TransactionhistoryarchiveRow] = map.get(transactionid)
  def selectByIds(transactionids: Array[TransactionhistoryarchiveId])(implicit c: Connection): List[TransactionhistoryarchiveRow] = transactionids.flatMap(map.get).toList
  def selectByIdsTracked(transactionids: Array[TransactionhistoryarchiveId])(implicit c: Connection): Map[TransactionhistoryarchiveId, TransactionhistoryarchiveRow] = {
    val byId = selectByIds(transactionids).view.map(x => (x.transactionid, x)).toMap
    transactionids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  def update: UpdateBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = UpdateBuilderMock(UpdateParams.empty, TransactionhistoryarchiveFields.structure, map)
  def update(row: TransactionhistoryarchiveRow)(implicit c: Connection): Boolean = {
    map.get(row.transactionid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.transactionid, row): @nowarn
        true
      case None => false
    }
  }
  def upsert(unsaved: TransactionhistoryarchiveRow)(implicit c: Connection): TransactionhistoryarchiveRow = {
    map.put(unsaved.transactionid, unsaved): @nowarn
    unsaved
  }
  def upsertBatch(unsaved: Iterable[TransactionhistoryarchiveRow])(implicit c: Connection): List[TransactionhistoryarchiveRow] = {
    unsaved.map { row =>
      map += (row.transactionid -> row)
      row
    }.toList
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[TransactionhistoryarchiveRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.transactionid -> row)
    }
    unsaved.size
  }
}