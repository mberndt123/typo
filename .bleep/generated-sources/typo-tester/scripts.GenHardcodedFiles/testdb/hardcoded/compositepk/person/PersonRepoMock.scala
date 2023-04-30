/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package compositepk
package person

import java.sql.Connection
import scala.Function1

class PersonRepoMock(toRow: Function1[PersonRowUnsaved, PersonRow],
                     map: scala.collection.mutable.Map[PersonId, PersonRow] = scala.collection.mutable.Map.empty) extends PersonRepo {
  override def delete(compositeId: PersonId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def insert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    unsaved
  }
  override def insert(unsaved: PersonRowUnsaved)(implicit c: Connection): PersonRow = {
    insert(toRow(unsaved))
  }
  override def selectAll(implicit c: Connection): List[PersonRow] = {
    map.values.toList
  }
  override def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[_]])(implicit c: Connection): List[PersonRow] = {
    fieldValues.foldLeft(map.values) {
      case (acc, PersonFieldValue.one(value)) => acc.filter(_.one == value)
      case (acc, PersonFieldValue.two(value)) => acc.filter(_.two == value)
      case (acc, PersonFieldValue.name(value)) => acc.filter(_.name == value)
    }.toList
  }
  override def selectById(compositeId: PersonId)(implicit c: Connection): Option[PersonRow] = {
    map.get(compositeId)
  }
  override def update(row: PersonRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row)
        true
      case None => false
    }
  }
  override def updateFieldValues(compositeId: PersonId, fieldValues: List[PersonFieldValue[_]])(implicit c: Connection): Boolean = {
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
  override def upsert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    map.put(unsaved.compositeId, unsaved)
    unsaved
  }
}
