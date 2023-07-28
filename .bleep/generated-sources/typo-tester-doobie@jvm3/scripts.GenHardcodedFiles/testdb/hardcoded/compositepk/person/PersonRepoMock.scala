/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package compositepk
package person

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class PersonRepoMock(toRow: Function1[PersonRowUnsaved, PersonRow],
                     map: scala.collection.mutable.Map[PersonId, PersonRow] = scala.collection.mutable.Map.empty) extends PersonRepo {
  override def delete(compositeId: PersonId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def insert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    delay {
      if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: PersonRowUnsaved): ConnectionIO[PersonRow] = {
    insert(toRow(unsaved))
  }
  override def selectAll: Stream[ConnectionIO, PersonRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[_]]): Stream[ConnectionIO, PersonRow] = {
    Stream.emits {
      fieldValues.foldLeft(map.values) {
        case (acc, PersonFieldValue.one(value)) => acc.filter(_.one == value)
        case (acc, PersonFieldValue.two(value)) => acc.filter(_.two == value)
        case (acc, PersonFieldValue.name(value)) => acc.filter(_.name == value)
      }.toList
    }
  }
  override def selectById(compositeId: PersonId): ConnectionIO[Option[PersonRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: PersonRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.compositeId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.compositeId, row)
          true
        case None => false
      }
    }
  }
  override def updateFieldValues(compositeId: PersonId, fieldValues: List[PersonFieldValue[_]]): ConnectionIO[Boolean] = {
    delay {
      map.get(compositeId) match {
        case Some(oldRow) =>
          val updatedRow = fieldValues.foldLeft(oldRow) {
            case (acc, PersonFieldValue.name(value)) => acc.copy(name = value)
          }
          if (updatedRow != oldRow) {
            map.put(compositeId, updatedRow)
            true
          } else {
            false
          }
        case None => false
      }
    }
  }
  override def upsert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
}
