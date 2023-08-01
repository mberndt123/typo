/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

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

class ShipmethodRepoMock(toRow: Function1[ShipmethodRowUnsaved, ShipmethodRow],
                         map: scala.collection.mutable.Map[ShipmethodId, ShipmethodRow] = scala.collection.mutable.Map.empty) extends ShipmethodRepo {
  override def delete(shipmethodid: ShipmethodId)(implicit c: Connection): Boolean = {
    map.remove(shipmethodid).isDefined
  }
  override def delete: DeleteBuilder[ShipmethodFields, ShipmethodRow] = {
    DeleteBuilderMock(DeleteParams.empty, ShipmethodFields, map)
  }
  override def insert(unsaved: ShipmethodRow)(implicit c: Connection): ShipmethodRow = {
    if (map.contains(unsaved.shipmethodid))
      sys.error(s"id ${unsaved.shipmethodid} already exists")
    else
      map.put(unsaved.shipmethodid, unsaved)
    unsaved
  }
  override def insert(unsaved: ShipmethodRowUnsaved)(implicit c: Connection): ShipmethodRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[ShipmethodFields, ShipmethodRow] = {
    SelectBuilderMock(ShipmethodFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ShipmethodRow] = {
    map.values.toList
  }
  override def selectById(shipmethodid: ShipmethodId)(implicit c: Connection): Option[ShipmethodRow] = {
    map.get(shipmethodid)
  }
  override def selectByIds(shipmethodids: Array[ShipmethodId])(implicit c: Connection): List[ShipmethodRow] = {
    shipmethodids.flatMap(map.get).toList
  }
  override def update(row: ShipmethodRow)(implicit c: Connection): Boolean = {
    map.get(row.shipmethodid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.shipmethodid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[ShipmethodFields, ShipmethodRow] = {
    UpdateBuilderMock(UpdateParams.empty, ShipmethodFields, map)
  }
  override def upsert(unsaved: ShipmethodRow)(implicit c: Connection): ShipmethodRow = {
    map.put(unsaved.shipmethodid, unsaved)
    unsaved
  }
}
