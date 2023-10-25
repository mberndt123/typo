/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

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

class EmailaddressRepoMock(toRow: Function1[EmailaddressRowUnsaved, EmailaddressRow],
                           map: scala.collection.mutable.Map[EmailaddressId, EmailaddressRow] = scala.collection.mutable.Map.empty) extends EmailaddressRepo {
  override def delete(compositeId: EmailaddressId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def delete: DeleteBuilder[EmailaddressFields, EmailaddressRow] = {
    DeleteBuilderMock(DeleteParams.empty, EmailaddressFields, map)
  }
  override def insert(unsaved: EmailaddressRow)(implicit c: Connection): EmailaddressRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def insertStreaming(unsaved: Iterator[EmailaddressRow], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def insert(unsaved: EmailaddressRowUnsaved)(implicit c: Connection): EmailaddressRow = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[EmailaddressRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[EmailaddressFields, EmailaddressRow] = {
    SelectBuilderMock(EmailaddressFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[EmailaddressRow] = {
    map.values.toList
  }
  override def selectById(compositeId: EmailaddressId)(implicit c: Connection): Option[EmailaddressRow] = {
    map.get(compositeId)
  }
  override def update(row: EmailaddressRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[EmailaddressFields, EmailaddressRow] = {
    UpdateBuilderMock(UpdateParams.empty, EmailaddressFields, map)
  }
  override def upsert(unsaved: EmailaddressRow)(implicit c: Connection): EmailaddressRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
}
