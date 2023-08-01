/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistoryarchive

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

class TransactionhistoryarchiveRepoMock(toRow: Function1[TransactionhistoryarchiveRowUnsaved, TransactionhistoryarchiveRow],
                                        map: scala.collection.mutable.Map[TransactionhistoryarchiveId, TransactionhistoryarchiveRow] = scala.collection.mutable.Map.empty) extends TransactionhistoryarchiveRepo {
  override def delete(transactionid: TransactionhistoryarchiveId)(implicit c: Connection): Boolean = {
    map.remove(transactionid).isDefined
  }
  override def delete: DeleteBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = {
    DeleteBuilderMock(DeleteParams.empty, TransactionhistoryarchiveFields, map)
  }
  override def insert(unsaved: TransactionhistoryarchiveRow)(implicit c: Connection): TransactionhistoryarchiveRow = {
    if (map.contains(unsaved.transactionid))
      sys.error(s"id ${unsaved.transactionid} already exists")
    else
      map.put(unsaved.transactionid, unsaved)
    unsaved
  }
  override def insert(unsaved: TransactionhistoryarchiveRowUnsaved)(implicit c: Connection): TransactionhistoryarchiveRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = {
    SelectBuilderMock(TransactionhistoryarchiveFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[TransactionhistoryarchiveRow] = {
    map.values.toList
  }
  override def selectById(transactionid: TransactionhistoryarchiveId)(implicit c: Connection): Option[TransactionhistoryarchiveRow] = {
    map.get(transactionid)
  }
  override def selectByIds(transactionids: Array[TransactionhistoryarchiveId])(implicit c: Connection): List[TransactionhistoryarchiveRow] = {
    transactionids.flatMap(map.get).toList
  }
  override def update(row: TransactionhistoryarchiveRow)(implicit c: Connection): Boolean = {
    map.get(row.transactionid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.transactionid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = {
    UpdateBuilderMock(UpdateParams.empty, TransactionhistoryarchiveFields, map)
  }
  override def upsert(unsaved: TransactionhistoryarchiveRow)(implicit c: Connection): TransactionhistoryarchiveRow = {
    map.put(unsaved.transactionid, unsaved)
    unsaved
  }
}
