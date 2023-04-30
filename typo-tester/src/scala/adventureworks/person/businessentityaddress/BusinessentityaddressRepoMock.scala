/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentityaddress

import java.sql.Connection
import scala.Function1

class BusinessentityaddressRepoMock(toRow: Function1[BusinessentityaddressRowUnsaved, BusinessentityaddressRow],
                                    map: scala.collection.mutable.Map[BusinessentityaddressId, BusinessentityaddressRow] = scala.collection.mutable.Map.empty) extends BusinessentityaddressRepo {
  override def delete(compositeId: BusinessentityaddressId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def insert(unsaved: BusinessentityaddressRow)(implicit c: Connection): BusinessentityaddressRow = {
    if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    unsaved
  }
  override def insert(unsaved: BusinessentityaddressRowUnsaved)(implicit c: Connection): BusinessentityaddressRow = {
    insert(toRow(unsaved))
  }
  override def selectAll(implicit c: Connection): List[BusinessentityaddressRow] = {
    map.values.toList
  }
  override def selectByFieldValues(fieldValues: List[BusinessentityaddressFieldOrIdValue[_]])(implicit c: Connection): List[BusinessentityaddressRow] = {
    fieldValues.foldLeft(map.values) {
      case (acc, BusinessentityaddressFieldValue.businessentityid(value)) => acc.filter(_.businessentityid == value)
      case (acc, BusinessentityaddressFieldValue.addressid(value)) => acc.filter(_.addressid == value)
      case (acc, BusinessentityaddressFieldValue.addresstypeid(value)) => acc.filter(_.addresstypeid == value)
      case (acc, BusinessentityaddressFieldValue.rowguid(value)) => acc.filter(_.rowguid == value)
      case (acc, BusinessentityaddressFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
    }.toList
  }
  override def selectById(compositeId: BusinessentityaddressId)(implicit c: Connection): Option[BusinessentityaddressRow] = {
    map.get(compositeId)
  }
  override def update(row: BusinessentityaddressRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row)
        true
      case None => false
    }
  }
  override def updateFieldValues(compositeId: BusinessentityaddressId, fieldValues: List[BusinessentityaddressFieldValue[_]])(implicit c: Connection): Boolean = {
    map.get(compositeId) match {
      case Some(oldRow) =>
        val updatedRow = fieldValues.foldLeft(oldRow) {
          case (acc, BusinessentityaddressFieldValue.rowguid(value)) => acc.copy(rowguid = value)
          case (acc, BusinessentityaddressFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
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
  override def upsert(unsaved: BusinessentityaddressRow)(implicit c: Connection): BusinessentityaddressRow = {
    map.put(unsaved.compositeId, unsaved)
    unsaved
  }
}
