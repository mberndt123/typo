/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public.identity_test;

import doobie.free.connection.ConnectionIO;
import doobie.free.connection.delay;
import fs2.Stream;
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

class IdentityTestRepoMock(val toRow: Function1[IdentityTestRowUnsaved, IdentityTestRow], val map: scala.collection.mutable.Map[IdentityTestId, IdentityTestRow] = scala.collection.mutable.Map.empty) extends IdentityTestRepo {
  def delete: DeleteBuilder[IdentityTestFields, IdentityTestRow] = DeleteBuilderMock(DeleteParams.empty, IdentityTestFields.structure, map)
  def deleteById(name: IdentityTestId): ConnectionIO[Boolean] = delay(map.remove(name).isDefined)
  def deleteByIds(names: Array[IdentityTestId]): ConnectionIO[Int] = delay(names.map(id => map.remove(id)).count(_.isDefined))
  def insert(unsaved: IdentityTestRow): ConnectionIO[IdentityTestRow] = {
    delay {
      val _ = if (map.contains(unsaved.name))
        sys.error(s"id ${unsaved.name} already exists")
      else
        map.put(unsaved.name, unsaved)
    
      unsaved
    }
  }
  def insert(unsaved: IdentityTestRowUnsaved): ConnectionIO[IdentityTestRow] = insert(toRow(unsaved))
  def insertStreaming(unsaved: Stream[ConnectionIO, IdentityTestRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.name -> row)
        num += 1
      }
      num
    }
  }
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, IdentityTestRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.name -> row)
        num += 1
      }
      num
    }
  }
  def select: SelectBuilder[IdentityTestFields, IdentityTestRow] = SelectBuilderMock(IdentityTestFields.structure, delay(map.values.toList), SelectParams.empty)
  def selectAll: Stream[ConnectionIO, IdentityTestRow] = Stream.emits(map.values.toList)
  def selectById(name: IdentityTestId): ConnectionIO[Option[IdentityTestRow]] = delay(map.get(name))
  def selectByIds(names: Array[IdentityTestId]): Stream[ConnectionIO, IdentityTestRow] = Stream.emits(names.flatMap(map.get).toList)
  def selectByIdsTracked(names: Array[IdentityTestId]): ConnectionIO[Map[IdentityTestId, IdentityTestRow]] = {
    selectByIds(names).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.name, x)).toMap
      names.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[IdentityTestFields, IdentityTestRow] = UpdateBuilderMock(UpdateParams.empty, IdentityTestFields.structure, map)
  def update(row: IdentityTestRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.name) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.name, row): @nowarn
          true
        case None => false
      }
    }
  }
  def upsert(unsaved: IdentityTestRow): ConnectionIO[IdentityTestRow] = {
    delay {
      map.put(unsaved.name, unsaved): @nowarn
      unsaved
    }
  }
  def upsertBatch(unsaved: List[IdentityTestRow]): Stream[ConnectionIO, IdentityTestRow] = {
    Stream.emits {
      unsaved.map { row =>
        map += (row.name -> row)
        row
      }
    }
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, IdentityTestRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    unsaved.compile.toList.map { rows =>
      var num = 0
      rows.foreach { row =>
        map += (row.name -> row)
        num += 1
      }
      num
    }
  }
}