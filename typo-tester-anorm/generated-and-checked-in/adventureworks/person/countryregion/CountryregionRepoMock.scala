/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.countryregion

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

class CountryregionRepoMock(toRow: Function1[CountryregionRowUnsaved, CountryregionRow],
                            map: scala.collection.mutable.Map[CountryregionId, CountryregionRow] = scala.collection.mutable.Map.empty) extends CountryregionRepo {
  override def delete: DeleteBuilder[CountryregionFields, CountryregionRow] = {
    DeleteBuilderMock(DeleteParams.empty, CountryregionFields.structure, map)
  }
  override def deleteById(countryregioncode: CountryregionId)(implicit c: Connection): Boolean = {
    map.remove(countryregioncode).isDefined
  }
  override def deleteByIds(countryregioncodes: Array[CountryregionId])(implicit c: Connection): Int = {
    countryregioncodes.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: CountryregionRow)(implicit c: Connection): CountryregionRow = {
    val _ = if (map.contains(unsaved.countryregioncode))
      sys.error(s"id ${unsaved.countryregioncode} already exists")
    else
      map.put(unsaved.countryregioncode, unsaved)
    
    unsaved
  }
  override def insert(unsaved: CountryregionRowUnsaved)(implicit c: Connection): CountryregionRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[CountryregionRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.countryregioncode -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[CountryregionRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.countryregioncode -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[CountryregionFields, CountryregionRow] = {
    SelectBuilderMock(CountryregionFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[CountryregionRow] = {
    map.values.toList
  }
  override def selectById(countryregioncode: CountryregionId)(implicit c: Connection): Option[CountryregionRow] = {
    map.get(countryregioncode)
  }
  override def selectByIds(countryregioncodes: Array[CountryregionId])(implicit c: Connection): List[CountryregionRow] = {
    countryregioncodes.flatMap(map.get).toList
  }
  override def selectByIdsTracked(countryregioncodes: Array[CountryregionId])(implicit c: Connection): Map[CountryregionId, CountryregionRow] = {
    val byId = selectByIds(countryregioncodes).view.map(x => (x.countryregioncode, x)).toMap
    countryregioncodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[CountryregionFields, CountryregionRow] = {
    UpdateBuilderMock(UpdateParams.empty, CountryregionFields.structure, map)
  }
  override def update(row: CountryregionRow)(implicit c: Connection): Boolean = {
    map.get(row.countryregioncode) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.countryregioncode, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: CountryregionRow)(implicit c: Connection): CountryregionRow = {
    map.put(unsaved.countryregioncode, unsaved): @nowarn
    unsaved
  }
  override def upsertBatch(unsaved: Iterable[CountryregionRow])(implicit c: Connection): List[CountryregionRow] = {
    unsaved.map { row =>
      map += (row.countryregioncode -> row)
      row
    }.toList
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[CountryregionRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.countryregioncode -> row)
    }
    unsaved.size
  }
}
