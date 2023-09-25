/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

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
  override def delete(countryregioncode: CountryregionId)(implicit c: Connection): Boolean = {
    map.remove(countryregioncode).isDefined
  }
  override def delete: DeleteBuilder[CountryregionFields, CountryregionRow] = {
    DeleteBuilderMock(DeleteParams.empty, CountryregionFields, map)
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
  override def select: SelectBuilder[CountryregionFields, CountryregionRow] = {
    SelectBuilderMock(CountryregionFields, () => map.values.toList, SelectParams.empty)
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
  override def update(row: CountryregionRow)(implicit c: Connection): Boolean = {
    map.get(row.countryregioncode) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.countryregioncode, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[CountryregionFields, CountryregionRow] = {
    UpdateBuilderMock(UpdateParams.empty, CountryregionFields, map)
  }
  override def upsert(unsaved: CountryregionRow)(implicit c: Connection): CountryregionRow = {
    map.put(unsaved.countryregioncode, unsaved): @nowarn
    unsaved
  }
}
