/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

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

class AddresstypeRepoMock(toRow: Function1[AddresstypeRowUnsaved, AddresstypeRow],
                          map: scala.collection.mutable.Map[AddresstypeId, AddresstypeRow] = scala.collection.mutable.Map.empty) extends AddresstypeRepo {
  override def delete(addresstypeid: AddresstypeId)(implicit c: Connection): Boolean = {
    map.remove(addresstypeid).isDefined
  }
  override def delete: DeleteBuilder[AddresstypeFields, AddresstypeRow] = {
    DeleteBuilderMock(DeleteParams.empty, AddresstypeFields, map)
  }
  override def insert(unsaved: AddresstypeRow)(implicit c: Connection): AddresstypeRow = {
    val _ = if (map.contains(unsaved.addresstypeid))
      sys.error(s"id ${unsaved.addresstypeid} already exists")
    else
      map.put(unsaved.addresstypeid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: AddresstypeRowUnsaved)(implicit c: Connection): AddresstypeRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[AddresstypeFields, AddresstypeRow] = {
    SelectBuilderMock(AddresstypeFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[AddresstypeRow] = {
    map.values.toList
  }
  override def selectById(addresstypeid: AddresstypeId)(implicit c: Connection): Option[AddresstypeRow] = {
    map.get(addresstypeid)
  }
  override def selectByIds(addresstypeids: Array[AddresstypeId])(implicit c: Connection): List[AddresstypeRow] = {
    addresstypeids.flatMap(map.get).toList
  }
  override def update(row: AddresstypeRow)(implicit c: Connection): Boolean = {
    map.get(row.addresstypeid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.addresstypeid, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[AddresstypeFields, AddresstypeRow] = {
    UpdateBuilderMock(UpdateParams.empty, AddresstypeFields, map)
  }
  override def upsert(unsaved: AddresstypeRow)(implicit c: Connection): AddresstypeRow = {
    map.put(unsaved.addresstypeid, unsaved): @nowarn
    unsaved
  }
}
