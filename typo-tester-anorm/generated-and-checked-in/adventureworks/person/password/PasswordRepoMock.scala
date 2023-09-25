/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.person.businessentity.BusinessentityId
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

class PasswordRepoMock(toRow: Function1[PasswordRowUnsaved, PasswordRow],
                       map: scala.collection.mutable.Map[BusinessentityId, PasswordRow] = scala.collection.mutable.Map.empty) extends PasswordRepo {
  override def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean = {
    map.remove(businessentityid).isDefined
  }
  override def delete: DeleteBuilder[PasswordFields, PasswordRow] = {
    DeleteBuilderMock(DeleteParams.empty, PasswordFields, map)
  }
  override def insert(unsaved: PasswordRow)(implicit c: Connection): PasswordRow = {
    val _ = if (map.contains(unsaved.businessentityid))
      sys.error(s"id ${unsaved.businessentityid} already exists")
    else
      map.put(unsaved.businessentityid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: PasswordRowUnsaved)(implicit c: Connection): PasswordRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[PasswordFields, PasswordRow] = {
    SelectBuilderMock(PasswordFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PasswordRow] = {
    map.values.toList
  }
  override def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[PasswordRow] = {
    map.get(businessentityid)
  }
  override def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[PasswordRow] = {
    businessentityids.flatMap(map.get).toList
  }
  override def update(row: PasswordRow)(implicit c: Connection): Boolean = {
    map.get(row.businessentityid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.businessentityid, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PasswordFields, PasswordRow] = {
    UpdateBuilderMock(UpdateParams.empty, PasswordFields, map)
  }
  override def upsert(unsaved: PasswordRow)(implicit c: Connection): PasswordRow = {
    map.put(unsaved.businessentityid, unsaved): @nowarn
    unsaved
  }
}
