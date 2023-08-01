/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class CountryregioncurrencyRepoMock(toRow: Function1[CountryregioncurrencyRowUnsaved, CountryregioncurrencyRow],
                                    map: scala.collection.mutable.Map[CountryregioncurrencyId, CountryregioncurrencyRow] = scala.collection.mutable.Map.empty) extends CountryregioncurrencyRepo {
  override def delete(compositeId: CountryregioncurrencyId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow] = {
    DeleteBuilderMock(DeleteParams.empty, CountryregioncurrencyFields, map)
  }
  override def insert(unsaved: CountryregioncurrencyRow): ConnectionIO[CountryregioncurrencyRow] = {
    delay {
      if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: CountryregioncurrencyRowUnsaved): ConnectionIO[CountryregioncurrencyRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow] = {
    SelectBuilderMock(CountryregioncurrencyFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, CountryregioncurrencyRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: CountryregioncurrencyId): ConnectionIO[Option[CountryregioncurrencyRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: CountryregioncurrencyRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.compositeId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.compositeId, row)
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow] = {
    UpdateBuilderMock(UpdateParams.empty, CountryregioncurrencyFields, map)
  }
  override def upsert(unsaved: CountryregioncurrencyRow): ConnectionIO[CountryregioncurrencyRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
}
