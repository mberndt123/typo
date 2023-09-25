/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream
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

class PersonRepoMock(toRow: Function1[PersonRowUnsaved, PersonRow],
                     map: scala.collection.mutable.Map[PersonId, PersonRow] = scala.collection.mutable.Map.empty) extends PersonRepo {
  override def delete(id: PersonId): ConnectionIO[Boolean] = {
    delay(map.remove(id).isDefined)
  }
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilderMock(DeleteParams.empty, PersonFields, map)
  }
  override def insert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    delay {
      val _ = if (map.contains(unsaved.id))
        sys.error(s"id ${unsaved.id} already exists")
      else
        map.put(unsaved.id, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: PersonRowUnsaved): ConnectionIO[PersonRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderMock(PersonFields, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PersonRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(id: PersonId): ConnectionIO[Option[PersonRow]] = {
    delay(map.get(id))
  }
  override def selectByIds(ids: Array[PersonId]): Stream[ConnectionIO, PersonRow] = {
    Stream.emits(ids.flatMap(map.get).toList)
  }
  override def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[?]]): Stream[ConnectionIO, PersonRow] = {
    Stream.emits {
      fieldValues.foldLeft(map.values) {
        case (acc, PersonFieldValue.id(value)) => acc.filter(_.id == value)
        case (acc, PersonFieldValue.favouriteFootballClubId(value)) => acc.filter(_.favouriteFootballClubId == value)
        case (acc, PersonFieldValue.name(value)) => acc.filter(_.name == value)
        case (acc, PersonFieldValue.nickName(value)) => acc.filter(_.nickName == value)
        case (acc, PersonFieldValue.blogUrl(value)) => acc.filter(_.blogUrl == value)
        case (acc, PersonFieldValue.email(value)) => acc.filter(_.email == value)
        case (acc, PersonFieldValue.phone(value)) => acc.filter(_.phone == value)
        case (acc, PersonFieldValue.likesPizza(value)) => acc.filter(_.likesPizza == value)
        case (acc, PersonFieldValue.maritalStatusId(value)) => acc.filter(_.maritalStatusId == value)
        case (acc, PersonFieldValue.workEmail(value)) => acc.filter(_.workEmail == value)
        case (acc, PersonFieldValue.sector(value)) => acc.filter(_.sector == value)
        case (acc, PersonFieldValue.favoriteNumber(value)) => acc.filter(_.favoriteNumber == value)
      }.toList
    }
  }
  override def update(row: PersonRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.id) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.id, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilderMock(UpdateParams.empty, PersonFields, map)
  }
  override def updateFieldValues(id: PersonId, fieldValues: List[PersonFieldValue[?]]): ConnectionIO[Boolean] = {
    delay {
      map.get(id) match {
        case Some(oldRow) =>
          val updatedRow = fieldValues.foldLeft(oldRow) {
            case (acc, PersonFieldValue.favouriteFootballClubId(value)) => acc.copy(favouriteFootballClubId = value)
            case (acc, PersonFieldValue.name(value)) => acc.copy(name = value)
            case (acc, PersonFieldValue.nickName(value)) => acc.copy(nickName = value)
            case (acc, PersonFieldValue.blogUrl(value)) => acc.copy(blogUrl = value)
            case (acc, PersonFieldValue.email(value)) => acc.copy(email = value)
            case (acc, PersonFieldValue.phone(value)) => acc.copy(phone = value)
            case (acc, PersonFieldValue.likesPizza(value)) => acc.copy(likesPizza = value)
            case (acc, PersonFieldValue.maritalStatusId(value)) => acc.copy(maritalStatusId = value)
            case (acc, PersonFieldValue.workEmail(value)) => acc.copy(workEmail = value)
            case (acc, PersonFieldValue.sector(value)) => acc.copy(sector = value)
            case (acc, PersonFieldValue.favoriteNumber(value)) => acc.copy(favoriteNumber = value)
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
  }
  override def upsert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    delay {
      map.put(unsaved.id, unsaved): @nowarn
      unsaved
    }
  }
}
