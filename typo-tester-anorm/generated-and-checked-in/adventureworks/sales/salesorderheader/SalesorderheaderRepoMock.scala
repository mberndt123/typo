/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesorderheader;

import java.sql.Connection;
import scala.annotation.nowarn;
import typo.dsl.DeleteBuilder;
import typo.dsl.DeleteBuilder.DeleteBuilderMock;
import typo.dsl.DeleteParams;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderMock;
import typo.dsl.SelectParams;
import typo.dsl.UpdateBuilder;
import typo.dsl.UpdateBuilder.UpdateBuilderMock;
import typo.dsl.UpdateParams;

class SalesorderheaderRepoMock(val toRow: Function1[SalesorderheaderRowUnsaved, SalesorderheaderRow], val map: scala.collection.mutable.Map[SalesorderheaderId, SalesorderheaderRow] = scala.collection.mutable.Map.empty) extends SalesorderheaderRepo {
  def delete: DeleteBuilder[SalesorderheaderFields, SalesorderheaderRow] = DeleteBuilderMock(DeleteParams.empty, SalesorderheaderFields.structure, map)
  def deleteById(salesorderid: SalesorderheaderId)(implicit c: Connection): Boolean = map.remove(salesorderid).isDefined
  def deleteByIds(salesorderids: Array[SalesorderheaderId])(implicit c: Connection): Int = salesorderids.map(id => map.remove(id)).count(_.isDefined)
  def insert(unsaved: SalesorderheaderRow)(implicit c: Connection): SalesorderheaderRow = {
    val _ = if (map.contains(unsaved.salesorderid))
      sys.error(s"id ${unsaved.salesorderid} already exists")
    else
      map.put(unsaved.salesorderid, unsaved)
    
    unsaved
  }
  def insert(unsaved: SalesorderheaderRowUnsaved)(implicit c: Connection): SalesorderheaderRow = insert(toRow(unsaved))
  def insertStreaming(unsaved: Iterator[SalesorderheaderRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.salesorderid -> row)
    }
    unsaved.size.toLong
  }
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[SalesorderheaderRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.salesorderid -> row)
    }
    unsaved.size.toLong
  }
  def select: SelectBuilder[SalesorderheaderFields, SalesorderheaderRow] = SelectBuilderMock(SalesorderheaderFields.structure, () => map.values.toList, SelectParams.empty)
  def selectAll(implicit c: Connection): List[SalesorderheaderRow] = map.values.toList
  def selectById(salesorderid: SalesorderheaderId)(implicit c: Connection): Option[SalesorderheaderRow] = map.get(salesorderid)
  def selectByIds(salesorderids: Array[SalesorderheaderId])(implicit c: Connection): List[SalesorderheaderRow] = salesorderids.flatMap(map.get).toList
  def selectByIdsTracked(salesorderids: Array[SalesorderheaderId])(implicit c: Connection): Map[SalesorderheaderId, SalesorderheaderRow] = {
    val byId = selectByIds(salesorderids).view.map(x => (x.salesorderid, x)).toMap
    salesorderids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  def update: UpdateBuilder[SalesorderheaderFields, SalesorderheaderRow] = UpdateBuilderMock(UpdateParams.empty, SalesorderheaderFields.structure, map)
  def update(row: SalesorderheaderRow)(implicit c: Connection): Boolean = {
    map.get(row.salesorderid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.salesorderid, row): @nowarn
        true
      case None => false
    }
  }
  def upsert(unsaved: SalesorderheaderRow)(implicit c: Connection): SalesorderheaderRow = {
    map.put(unsaved.salesorderid, unsaved): @nowarn
    unsaved
  }
  def upsertBatch(unsaved: Iterable[SalesorderheaderRow])(implicit c: Connection): List[SalesorderheaderRow] = {
    unsaved.map { row =>
      map += (row.salesorderid -> row)
      row
    }.toList
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[SalesorderheaderRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.salesorderid -> row)
    }
    unsaved.size
  }
}