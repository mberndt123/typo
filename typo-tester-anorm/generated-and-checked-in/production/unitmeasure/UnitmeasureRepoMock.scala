/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package unitmeasure

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

class UnitmeasureRepoMock(toRow: Function1[UnitmeasureRowUnsaved, UnitmeasureRow],
                          map: scala.collection.mutable.Map[UnitmeasureId, UnitmeasureRow] = scala.collection.mutable.Map.empty) extends UnitmeasureRepo {
  override def delete(unitmeasurecode: UnitmeasureId)(implicit c: Connection): Boolean = {
    map.remove(unitmeasurecode).isDefined
  }
  override def delete: DeleteBuilder[UnitmeasureFields, UnitmeasureRow] = {
    DeleteBuilderMock(DeleteParams.empty, UnitmeasureFields, map)
  }
  override def insert(unsaved: UnitmeasureRow)(implicit c: Connection): UnitmeasureRow = {
    if (map.contains(unsaved.unitmeasurecode))
      sys.error(s"id ${unsaved.unitmeasurecode} already exists")
    else
      map.put(unsaved.unitmeasurecode, unsaved)
    unsaved
  }
  override def insert(unsaved: UnitmeasureRowUnsaved)(implicit c: Connection): UnitmeasureRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[UnitmeasureFields, UnitmeasureRow] = {
    SelectBuilderMock(UnitmeasureFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[UnitmeasureRow] = {
    map.values.toList
  }
  override def selectById(unitmeasurecode: UnitmeasureId)(implicit c: Connection): Option[UnitmeasureRow] = {
    map.get(unitmeasurecode)
  }
  override def selectByIds(unitmeasurecodes: Array[UnitmeasureId])(implicit c: Connection): List[UnitmeasureRow] = {
    unitmeasurecodes.flatMap(map.get).toList
  }
  override def update(row: UnitmeasureRow)(implicit c: Connection): Boolean = {
    map.get(row.unitmeasurecode) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.unitmeasurecode, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[UnitmeasureFields, UnitmeasureRow] = {
    UpdateBuilderMock(UpdateParams.empty, UnitmeasureFields, map)
  }
  override def upsert(unsaved: UnitmeasureRow)(implicit c: Connection): UnitmeasureRow = {
    map.put(unsaved.unitmeasurecode, unsaved)
    unsaved
  }
}
