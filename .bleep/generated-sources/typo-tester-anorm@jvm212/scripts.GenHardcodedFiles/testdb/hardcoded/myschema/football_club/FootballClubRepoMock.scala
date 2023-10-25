/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package football_club

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

class FootballClubRepoMock(map: scala.collection.mutable.Map[FootballClubId, FootballClubRow] = scala.collection.mutable.Map.empty) extends FootballClubRepo {
  override def delete(id: FootballClubId)(implicit c: Connection): Boolean = {
    map.remove(id).isDefined
  }
  override def delete: DeleteBuilder[FootballClubFields, FootballClubRow] = {
    DeleteBuilderMock(DeleteParams.empty, FootballClubFields, map)
  }
  override def insert(unsaved: FootballClubRow)(implicit c: Connection): FootballClubRow = {
    val _ = if (map.contains(unsaved.id))
      sys.error(s"id ${unsaved.id} already exists")
    else
      map.put(unsaved.id, unsaved)
    
    unsaved
  }
  override def insertStreaming(unsaved: Iterator[FootballClubRow], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.id -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[FootballClubFields, FootballClubRow] = {
    SelectBuilderMock(FootballClubFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[FootballClubRow] = {
    map.values.toList
  }
  override def selectById(id: FootballClubId)(implicit c: Connection): Option[FootballClubRow] = {
    map.get(id)
  }
  override def selectByIds(ids: Array[FootballClubId])(implicit c: Connection): List[FootballClubRow] = {
    ids.flatMap(map.get).toList
  }
  override def selectByFieldValues(fieldValues: List[FootballClubFieldOrIdValue[?]])(implicit c: Connection): List[FootballClubRow] = {
    fieldValues.foldLeft(map.values) {
      case (acc, FootballClubFieldValue.id(value)) => acc.filter(_.id == value)
      case (acc, FootballClubFieldValue.name(value)) => acc.filter(_.name == value)
    }.toList
  }
  override def update(row: FootballClubRow)(implicit c: Connection): Boolean = {
    map.get(row.id) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.id, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[FootballClubFields, FootballClubRow] = {
    UpdateBuilderMock(UpdateParams.empty, FootballClubFields, map)
  }
  override def updateFieldValues(id: FootballClubId, fieldValues: List[FootballClubFieldValue[?]])(implicit c: Connection): Boolean = {
    map.get(id) match {
      case Some(oldRow) =>
        val updatedRow = fieldValues.foldLeft(oldRow) {
          case (acc, FootballClubFieldValue.name(value)) => acc.copy(name = value)
        }
        if (updatedRow != oldRow) {
          map.put(id, updatedRow): @nowarn
          true
        } else {
          false
        }
      case None => false
    }
  }
  override def upsert(unsaved: FootballClubRow)(implicit c: Connection): FootballClubRow = {
    map.put(unsaved.id, unsaved): @nowarn
    unsaved
  }
}
