/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package person

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

class PersonRepoMock(toRow: Function1[PersonRowUnsaved, PersonRow],
                     map: scala.collection.mutable.Map[BusinessentityId, PersonRow] = scala.collection.mutable.Map.empty) extends PersonRepo {
  override def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean = {
    map.remove(businessentityid).isDefined
  }
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilderMock(DeleteParams.empty, PersonFields, map)
  }
  override def insert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    val _ = if (map.contains(unsaved.businessentityid))
      sys.error(s"id ${unsaved.businessentityid} already exists")
    else
      map.put(unsaved.businessentityid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: PersonRowUnsaved)(implicit c: Connection): PersonRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderMock(PersonFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PersonRow] = {
    map.values.toList
  }
  override def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[PersonRow] = {
    map.get(businessentityid)
  }
  override def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[PersonRow] = {
    businessentityids.flatMap(map.get).toList
  }
  override def update(row: PersonRow)(implicit c: Connection): Boolean = {
    map.get(row.businessentityid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.businessentityid, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilderMock(UpdateParams.empty, PersonFields, map)
  }
  override def upsert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    map.put(unsaved.businessentityid, unsaved): @nowarn
    unsaved
  }
}
