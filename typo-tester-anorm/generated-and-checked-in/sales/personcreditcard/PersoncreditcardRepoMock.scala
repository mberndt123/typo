/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

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

class PersoncreditcardRepoMock(toRow: Function1[PersoncreditcardRowUnsaved, PersoncreditcardRow],
                               map: scala.collection.mutable.Map[PersoncreditcardId, PersoncreditcardRow] = scala.collection.mutable.Map.empty) extends PersoncreditcardRepo {
  override def delete(compositeId: PersoncreditcardId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def delete: DeleteBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    DeleteBuilderMock(DeleteParams.empty, PersoncreditcardFields, map)
  }
  override def insert(unsaved: PersoncreditcardRow)(implicit c: Connection): PersoncreditcardRow = {
    if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    unsaved
  }
  override def insert(unsaved: PersoncreditcardRowUnsaved)(implicit c: Connection): PersoncreditcardRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    SelectBuilderMock(PersoncreditcardFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PersoncreditcardRow] = {
    map.values.toList
  }
  override def selectById(compositeId: PersoncreditcardId)(implicit c: Connection): Option[PersoncreditcardRow] = {
    map.get(compositeId)
  }
  override def update(row: PersoncreditcardRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    UpdateBuilderMock(UpdateParams.empty, PersoncreditcardFields, map)
  }
  override def upsert(unsaved: PersoncreditcardRow)(implicit c: Connection): PersoncreditcardRow = {
    map.put(unsaved.compositeId, unsaved)
    unsaved
  }
}
