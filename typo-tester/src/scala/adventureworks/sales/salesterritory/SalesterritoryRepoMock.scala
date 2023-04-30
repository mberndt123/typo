/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import java.sql.Connection
import scala.Function1

class SalesterritoryRepoMock(toRow: Function1[SalesterritoryRowUnsaved, SalesterritoryRow],
                             map: scala.collection.mutable.Map[SalesterritoryId, SalesterritoryRow] = scala.collection.mutable.Map.empty) extends SalesterritoryRepo {
  override def delete(territoryid: SalesterritoryId)(implicit c: Connection): Boolean = {
    map.remove(territoryid).isDefined
  }
  override def insert(unsaved: SalesterritoryRow)(implicit c: Connection): SalesterritoryRow = {
    if (map.contains(unsaved.territoryid))
      sys.error(s"id ${unsaved.territoryid} already exists")
    else
      map.put(unsaved.territoryid, unsaved)
    unsaved
  }
  override def insert(unsaved: SalesterritoryRowUnsaved)(implicit c: Connection): SalesterritoryRow = {
    insert(toRow(unsaved))
  }
  override def selectAll(implicit c: Connection): List[SalesterritoryRow] = {
    map.values.toList
  }
  override def selectByFieldValues(fieldValues: List[SalesterritoryFieldOrIdValue[_]])(implicit c: Connection): List[SalesterritoryRow] = {
    fieldValues.foldLeft(map.values) {
      case (acc, SalesterritoryFieldValue.territoryid(value)) => acc.filter(_.territoryid == value)
      case (acc, SalesterritoryFieldValue.name(value)) => acc.filter(_.name == value)
      case (acc, SalesterritoryFieldValue.countryregioncode(value)) => acc.filter(_.countryregioncode == value)
      case (acc, SalesterritoryFieldValue.group(value)) => acc.filter(_.group == value)
      case (acc, SalesterritoryFieldValue.salesytd(value)) => acc.filter(_.salesytd == value)
      case (acc, SalesterritoryFieldValue.saleslastyear(value)) => acc.filter(_.saleslastyear == value)
      case (acc, SalesterritoryFieldValue.costytd(value)) => acc.filter(_.costytd == value)
      case (acc, SalesterritoryFieldValue.costlastyear(value)) => acc.filter(_.costlastyear == value)
      case (acc, SalesterritoryFieldValue.rowguid(value)) => acc.filter(_.rowguid == value)
      case (acc, SalesterritoryFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
    }.toList
  }
  override def selectById(territoryid: SalesterritoryId)(implicit c: Connection): Option[SalesterritoryRow] = {
    map.get(territoryid)
  }
  override def selectByIds(territoryids: Array[SalesterritoryId])(implicit c: Connection): List[SalesterritoryRow] = {
    territoryids.flatMap(map.get).toList
  }
  override def update(row: SalesterritoryRow)(implicit c: Connection): Boolean = {
    map.get(row.territoryid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.territoryid, row)
        true
      case None => false
    }
  }
  override def updateFieldValues(territoryid: SalesterritoryId, fieldValues: List[SalesterritoryFieldValue[_]])(implicit c: Connection): Boolean = {
    map.get(territoryid) match {
      case Some(oldRow) =>
        val updatedRow = fieldValues.foldLeft(oldRow) {
          case (acc, SalesterritoryFieldValue.name(value)) => acc.copy(name = value)
          case (acc, SalesterritoryFieldValue.countryregioncode(value)) => acc.copy(countryregioncode = value)
          case (acc, SalesterritoryFieldValue.group(value)) => acc.copy(group = value)
          case (acc, SalesterritoryFieldValue.salesytd(value)) => acc.copy(salesytd = value)
          case (acc, SalesterritoryFieldValue.saleslastyear(value)) => acc.copy(saleslastyear = value)
          case (acc, SalesterritoryFieldValue.costytd(value)) => acc.copy(costytd = value)
          case (acc, SalesterritoryFieldValue.costlastyear(value)) => acc.copy(costlastyear = value)
          case (acc, SalesterritoryFieldValue.rowguid(value)) => acc.copy(rowguid = value)
          case (acc, SalesterritoryFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
        }
        if (updatedRow != oldRow) {
          map.put(territoryid, updatedRow)
          true
        } else {
          false
        }
      case None => false
    }
  }
  override def upsert(unsaved: SalesterritoryRow)(implicit c: Connection): SalesterritoryRow = {
    map.put(unsaved.territoryid, unsaved)
    unsaved
  }
}
