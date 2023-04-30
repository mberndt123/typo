/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import java.sql.Connection
import scala.Function1

class BillofmaterialsRepoMock(toRow: Function1[BillofmaterialsRowUnsaved, BillofmaterialsRow],
                              map: scala.collection.mutable.Map[BillofmaterialsId, BillofmaterialsRow] = scala.collection.mutable.Map.empty) extends BillofmaterialsRepo {
  override def delete(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Boolean = {
    map.remove(billofmaterialsid).isDefined
  }
  override def insert(unsaved: BillofmaterialsRow)(implicit c: Connection): BillofmaterialsRow = {
    if (map.contains(unsaved.billofmaterialsid))
      sys.error(s"id ${unsaved.billofmaterialsid} already exists")
    else
      map.put(unsaved.billofmaterialsid, unsaved)
    unsaved
  }
  override def insert(unsaved: BillofmaterialsRowUnsaved)(implicit c: Connection): BillofmaterialsRow = {
    insert(toRow(unsaved))
  }
  override def selectAll(implicit c: Connection): List[BillofmaterialsRow] = {
    map.values.toList
  }
  override def selectByFieldValues(fieldValues: List[BillofmaterialsFieldOrIdValue[_]])(implicit c: Connection): List[BillofmaterialsRow] = {
    fieldValues.foldLeft(map.values) {
      case (acc, BillofmaterialsFieldValue.billofmaterialsid(value)) => acc.filter(_.billofmaterialsid == value)
      case (acc, BillofmaterialsFieldValue.productassemblyid(value)) => acc.filter(_.productassemblyid == value)
      case (acc, BillofmaterialsFieldValue.componentid(value)) => acc.filter(_.componentid == value)
      case (acc, BillofmaterialsFieldValue.startdate(value)) => acc.filter(_.startdate == value)
      case (acc, BillofmaterialsFieldValue.enddate(value)) => acc.filter(_.enddate == value)
      case (acc, BillofmaterialsFieldValue.unitmeasurecode(value)) => acc.filter(_.unitmeasurecode == value)
      case (acc, BillofmaterialsFieldValue.bomlevel(value)) => acc.filter(_.bomlevel == value)
      case (acc, BillofmaterialsFieldValue.perassemblyqty(value)) => acc.filter(_.perassemblyqty == value)
      case (acc, BillofmaterialsFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
    }.toList
  }
  override def selectById(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Option[BillofmaterialsRow] = {
    map.get(billofmaterialsid)
  }
  override def selectByIds(billofmaterialsids: Array[BillofmaterialsId])(implicit c: Connection): List[BillofmaterialsRow] = {
    billofmaterialsids.flatMap(map.get).toList
  }
  override def update(row: BillofmaterialsRow)(implicit c: Connection): Boolean = {
    map.get(row.billofmaterialsid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.billofmaterialsid, row)
        true
      case None => false
    }
  }
  override def updateFieldValues(billofmaterialsid: BillofmaterialsId, fieldValues: List[BillofmaterialsFieldValue[_]])(implicit c: Connection): Boolean = {
    map.get(billofmaterialsid) match {
      case Some(oldRow) =>
        val updatedRow = fieldValues.foldLeft(oldRow) {
          case (acc, BillofmaterialsFieldValue.productassemblyid(value)) => acc.copy(productassemblyid = value)
          case (acc, BillofmaterialsFieldValue.componentid(value)) => acc.copy(componentid = value)
          case (acc, BillofmaterialsFieldValue.startdate(value)) => acc.copy(startdate = value)
          case (acc, BillofmaterialsFieldValue.enddate(value)) => acc.copy(enddate = value)
          case (acc, BillofmaterialsFieldValue.unitmeasurecode(value)) => acc.copy(unitmeasurecode = value)
          case (acc, BillofmaterialsFieldValue.bomlevel(value)) => acc.copy(bomlevel = value)
          case (acc, BillofmaterialsFieldValue.perassemblyqty(value)) => acc.copy(perassemblyqty = value)
          case (acc, BillofmaterialsFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
        }
        if (updatedRow != oldRow) {
          map.put(billofmaterialsid, updatedRow)
          true
        } else {
          false
        }
      case None => false
    }
  }
  override def upsert(unsaved: BillofmaterialsRow)(implicit c: Connection): BillofmaterialsRow = {
    map.put(unsaved.billofmaterialsid, unsaved)
    unsaved
  }
}
