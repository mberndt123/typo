/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import adventureworks.customtypes.TypoUUID
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

class DocumentRepoMock(toRow: Function1[DocumentRowUnsaved, DocumentRow],
                       map: scala.collection.mutable.Map[DocumentId, DocumentRow] = scala.collection.mutable.Map.empty) extends DocumentRepo {
  override def delete(documentnode: DocumentId)(implicit c: Connection): Boolean = {
    map.remove(documentnode).isDefined
  }
  override def delete: DeleteBuilder[DocumentFields, DocumentRow] = {
    DeleteBuilderMock(DeleteParams.empty, DocumentFields, map)
  }
  override def insert(unsaved: DocumentRow)(implicit c: Connection): DocumentRow = {
    val _ = if (map.contains(unsaved.documentnode))
      sys.error(s"id ${unsaved.documentnode} already exists")
    else
      map.put(unsaved.documentnode, unsaved)
    
    unsaved
  }
  override def insertStreaming(unsaved: Iterator[DocumentRow], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.documentnode -> row)
    }
    unsaved.size.toLong
  }
  override def insert(unsaved: DocumentRowUnsaved)(implicit c: Connection): DocumentRow = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[DocumentRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.documentnode -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[DocumentFields, DocumentRow] = {
    SelectBuilderMock(DocumentFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[DocumentRow] = {
    map.values.toList
  }
  override def selectById(documentnode: DocumentId)(implicit c: Connection): Option[DocumentRow] = {
    map.get(documentnode)
  }
  override def selectByIds(documentnodes: Array[DocumentId])(implicit c: Connection): List[DocumentRow] = {
    documentnodes.flatMap(map.get).toList
  }
  override def selectByUnique(rowguid: TypoUUID)(implicit c: Connection): Option[DocumentRow] = {
    map.values.find(v => rowguid == v.rowguid)
  }
  override def update(row: DocumentRow)(implicit c: Connection): Boolean = {
    map.get(row.documentnode) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.documentnode, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[DocumentFields, DocumentRow] = {
    UpdateBuilderMock(UpdateParams.empty, DocumentFields, map)
  }
  override def upsert(unsaved: DocumentRow)(implicit c: Connection): DocumentRow = {
    map.put(unsaved.documentnode, unsaved): @nowarn
    unsaved
  }
}
