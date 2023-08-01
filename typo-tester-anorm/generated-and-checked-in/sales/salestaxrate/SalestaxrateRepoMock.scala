/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class SalestaxrateRepoMock(toRow: Function1[SalestaxrateRowUnsaved, SalestaxrateRow],
                           map: scala.collection.mutable.Map[SalestaxrateId, SalestaxrateRow] = scala.collection.mutable.Map.empty) extends SalestaxrateRepo {
  override def delete(salestaxrateid: SalestaxrateId)(implicit c: Connection): Boolean = {
    map.remove(salestaxrateid).isDefined
  }
  override def delete: DeleteBuilder[SalestaxrateFields, SalestaxrateRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalestaxrateFields, map)
  }
  override def insert(unsaved: SalestaxrateRow)(implicit c: Connection): SalestaxrateRow = {
    if (map.contains(unsaved.salestaxrateid))
      sys.error(s"id ${unsaved.salestaxrateid} already exists")
    else
      map.put(unsaved.salestaxrateid, unsaved)
    unsaved
  }
  override def insert(unsaved: SalestaxrateRowUnsaved)(implicit c: Connection): SalestaxrateRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[SalestaxrateFields, SalestaxrateRow] = {
    SelectBuilderMock(SalestaxrateFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[SalestaxrateRow] = {
    map.values.toList
  }
  override def selectById(salestaxrateid: SalestaxrateId)(implicit c: Connection): Option[SalestaxrateRow] = {
    map.get(salestaxrateid)
  }
  override def selectByIds(salestaxrateids: Array[SalestaxrateId])(implicit c: Connection): List[SalestaxrateRow] = {
    salestaxrateids.flatMap(map.get).toList
  }
  override def update(row: SalestaxrateRow)(implicit c: Connection): Boolean = {
    map.get(row.salestaxrateid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.salestaxrateid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[SalestaxrateFields, SalestaxrateRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalestaxrateFields, map)
  }
  override def upsert(unsaved: SalestaxrateRow)(implicit c: Connection): SalestaxrateRow = {
    map.put(unsaved.salestaxrateid, unsaved)
    unsaved
  }
}
