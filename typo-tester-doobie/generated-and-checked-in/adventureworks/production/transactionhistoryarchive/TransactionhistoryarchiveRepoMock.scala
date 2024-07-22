/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.transactionhistoryarchive

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream
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

class TransactionhistoryarchiveRepoMock(toRow: Function1[TransactionhistoryarchiveRowUnsaved, TransactionhistoryarchiveRow],
                                        map: scala.collection.mutable.Map[TransactionhistoryarchiveId, TransactionhistoryarchiveRow] = scala.collection.mutable.Map.empty) extends TransactionhistoryarchiveRepo {
  override def delete: DeleteBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = {
    DeleteBuilderMock(DeleteParams.empty, TransactionhistoryarchiveFields.structure, map)
  }
  override def deleteById(transactionid: TransactionhistoryarchiveId): ConnectionIO[Boolean] = {
    delay(map.remove(transactionid).isDefined)
  }
  override def deleteByIds(transactionids: Array[TransactionhistoryarchiveId]): ConnectionIO[Int] = {
    delay(transactionids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: TransactionhistoryarchiveRow): ConnectionIO[TransactionhistoryarchiveRow] = {
    delay {
      val _ = if (map.contains(unsaved.transactionid))
        sys.error(s"id ${unsaved.transactionid} already exists")
      else
        map.put(unsaved.transactionid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: TransactionhistoryarchiveRowUnsaved): ConnectionIO[TransactionhistoryarchiveRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, TransactionhistoryarchiveRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.transactionid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, TransactionhistoryarchiveRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.transactionid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = {
    SelectBuilderMock(TransactionhistoryarchiveFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, TransactionhistoryarchiveRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(transactionid: TransactionhistoryarchiveId): ConnectionIO[Option[TransactionhistoryarchiveRow]] = {
    delay(map.get(transactionid))
  }
  override def selectByIds(transactionids: Array[TransactionhistoryarchiveId]): Stream[ConnectionIO, TransactionhistoryarchiveRow] = {
    Stream.emits(transactionids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(transactionids: Array[TransactionhistoryarchiveId]): ConnectionIO[Map[TransactionhistoryarchiveId, TransactionhistoryarchiveRow]] = {
    selectByIds(transactionids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.transactionid, x)).toMap
      transactionids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = {
    UpdateBuilderMock(UpdateParams.empty, TransactionhistoryarchiveFields.structure, map)
  }
  override def update(row: TransactionhistoryarchiveRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.transactionid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.transactionid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: TransactionhistoryarchiveRow): ConnectionIO[TransactionhistoryarchiveRow] = {
    delay {
      map.put(unsaved.transactionid, unsaved): @nowarn
      unsaved
    }
  }
  override def upsertBatch(unsaved: List[TransactionhistoryarchiveRow]): Stream[ConnectionIO, TransactionhistoryarchiveRow] = {
    Stream.emits {
      unsaved.map { row =>
        map += (row.transactionid -> row)
        row
      }
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, TransactionhistoryarchiveRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    unsaved.compile.toList.map { rows =>
      var num = 0
      rows.foreach { row =>
        map += (row.transactionid -> row)
        num += 1
      }
      num
    }
  }
}
