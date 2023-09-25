/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currencyrate

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

class CurrencyrateRepoMock(toRow: Function1[CurrencyrateRowUnsaved, CurrencyrateRow],
                           map: scala.collection.mutable.Map[CurrencyrateId, CurrencyrateRow] = scala.collection.mutable.Map.empty) extends CurrencyrateRepo {
  override def delete(currencyrateid: CurrencyrateId): ConnectionIO[Boolean] = {
    delay(map.remove(currencyrateid).isDefined)
  }
  override def delete: DeleteBuilder[CurrencyrateFields, CurrencyrateRow] = {
    DeleteBuilderMock(DeleteParams.empty, CurrencyrateFields, map)
  }
  override def insert(unsaved: CurrencyrateRow): ConnectionIO[CurrencyrateRow] = {
    delay {
      val _ = if (map.contains(unsaved.currencyrateid))
        sys.error(s"id ${unsaved.currencyrateid} already exists")
      else
        map.put(unsaved.currencyrateid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: CurrencyrateRowUnsaved): ConnectionIO[CurrencyrateRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[CurrencyrateFields, CurrencyrateRow] = {
    SelectBuilderMock(CurrencyrateFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, CurrencyrateRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(currencyrateid: CurrencyrateId): ConnectionIO[Option[CurrencyrateRow]] = {
    delay(map.get(currencyrateid))
  }
  override def selectByIds(currencyrateids: Array[CurrencyrateId]): Stream[ConnectionIO, CurrencyrateRow] = {
    Stream.emits(currencyrateids.flatMap(map.get).toList)
  }
  override def update(row: CurrencyrateRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.currencyrateid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.currencyrateid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[CurrencyrateFields, CurrencyrateRow] = {
    UpdateBuilderMock(UpdateParams.empty, CurrencyrateFields, map)
  }
  override def upsert(unsaved: CurrencyrateRow): ConnectionIO[CurrencyrateRow] = {
    delay {
      map.put(unsaved.currencyrateid, unsaved): @nowarn
      unsaved
    }
  }
}
