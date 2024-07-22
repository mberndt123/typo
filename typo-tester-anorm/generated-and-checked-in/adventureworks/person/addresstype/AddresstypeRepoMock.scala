/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.addresstype

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
  override def delete: DeleteBuilder[AddresstypeFields, AddresstypeRow] = {
    DeleteBuilderMock(DeleteParams.empty, AddresstypeFields.structure, map)
  }
  override def deleteById(addresstypeid: AddresstypeId)(implicit c: Connection): Boolean = {
    map.remove(addresstypeid).isDefined
  }
  override def deleteByIds(addresstypeids: Array[AddresstypeId])(implicit c: Connection): Int = {
    addresstypeids.map(id => map.remove(id)).count(_.isDefined)
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
  override def insertStreaming(unsaved: Iterator[AddresstypeRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.addresstypeid -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[AddresstypeRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.addresstypeid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[AddresstypeFields, AddresstypeRow] = {
    SelectBuilderMock(AddresstypeFields.structure, () => map.values.toList, SelectParams.empty)
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
  override def selectByIdsTracked(addresstypeids: Array[AddresstypeId])(implicit c: Connection): Map[AddresstypeId, AddresstypeRow] = {
    val byId = selectByIds(addresstypeids).view.map(x => (x.addresstypeid, x)).toMap
    addresstypeids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[AddresstypeFields, AddresstypeRow] = {
    UpdateBuilderMock(UpdateParams.empty, AddresstypeFields.structure, map)
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
  override def upsert(unsaved: AddresstypeRow)(implicit c: Connection): AddresstypeRow = {
    map.put(unsaved.addresstypeid, unsaved): @nowarn
    unsaved
  }
  override def upsertBatch(unsaved: Iterable[AddresstypeRow])(implicit c: Connection): List[AddresstypeRow] = {
    unsaved.map { row =>
      map += (row.addresstypeid -> row)
      row
    }.toList
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[AddresstypeRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.addresstypeid -> row)
    }
    unsaved.size
  }
}
