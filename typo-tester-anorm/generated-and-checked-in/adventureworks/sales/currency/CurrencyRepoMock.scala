/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currency

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

class CurrencyRepoMock(toRow: Function1[CurrencyRowUnsaved, CurrencyRow],
                       map: scala.collection.mutable.Map[CurrencyId, CurrencyRow] = scala.collection.mutable.Map.empty) extends CurrencyRepo {
  override def delete(currencycode: CurrencyId)(implicit c: Connection): Boolean = {
    map.remove(currencycode).isDefined
  }
  override def delete: DeleteBuilder[CurrencyFields, CurrencyRow] = {
    DeleteBuilderMock(DeleteParams.empty, CurrencyFields, map)
  }
  override def insert(unsaved: CurrencyRow)(implicit c: Connection): CurrencyRow = {
    val _ = if (map.contains(unsaved.currencycode))
      sys.error(s"id ${unsaved.currencycode} already exists")
    else
      map.put(unsaved.currencycode, unsaved)
    
    unsaved
  }
  override def insert(unsaved: CurrencyRowUnsaved)(implicit c: Connection): CurrencyRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[CurrencyFields, CurrencyRow] = {
    SelectBuilderMock(CurrencyFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[CurrencyRow] = {
    map.values.toList
  }
  override def selectById(currencycode: CurrencyId)(implicit c: Connection): Option[CurrencyRow] = {
    map.get(currencycode)
  }
  override def selectByIds(currencycodes: Array[CurrencyId])(implicit c: Connection): List[CurrencyRow] = {
    currencycodes.flatMap(map.get).toList
  }
  override def update(row: CurrencyRow)(implicit c: Connection): Boolean = {
    map.get(row.currencycode) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.currencycode, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[CurrencyFields, CurrencyRow] = {
    UpdateBuilderMock(UpdateParams.empty, CurrencyFields, map)
  }
  override def upsert(unsaved: CurrencyRow)(implicit c: Connection): CurrencyRow = {
    map.put(unsaved.currencycode, unsaved): @nowarn
    unsaved
  }
}
