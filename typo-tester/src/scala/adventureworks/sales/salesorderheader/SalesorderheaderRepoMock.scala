/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import java.sql.Connection
import scala.Function1

class SalesorderheaderRepoMock(toRow: Function1[SalesorderheaderRowUnsaved, SalesorderheaderRow],
                               map: scala.collection.mutable.Map[SalesorderheaderId, SalesorderheaderRow] = scala.collection.mutable.Map.empty) extends SalesorderheaderRepo {
  override def delete(salesorderid: SalesorderheaderId)(implicit c: Connection): Boolean = {
    map.remove(salesorderid).isDefined
  }
  override def insert(unsaved: SalesorderheaderRow)(implicit c: Connection): SalesorderheaderRow = {
    if (map.contains(unsaved.salesorderid))
      sys.error(s"id ${unsaved.salesorderid} already exists")
    else
      map.put(unsaved.salesorderid, unsaved)
    unsaved
  }
  override def insert(unsaved: SalesorderheaderRowUnsaved)(implicit c: Connection): SalesorderheaderRow = {
    insert(toRow(unsaved))
  }
  override def selectAll(implicit c: Connection): List[SalesorderheaderRow] = {
    map.values.toList
  }
  override def selectByFieldValues(fieldValues: List[SalesorderheaderFieldOrIdValue[_]])(implicit c: Connection): List[SalesorderheaderRow] = {
    fieldValues.foldLeft(map.values) {
      case (acc, SalesorderheaderFieldValue.salesorderid(value)) => acc.filter(_.salesorderid == value)
      case (acc, SalesorderheaderFieldValue.revisionnumber(value)) => acc.filter(_.revisionnumber == value)
      case (acc, SalesorderheaderFieldValue.orderdate(value)) => acc.filter(_.orderdate == value)
      case (acc, SalesorderheaderFieldValue.duedate(value)) => acc.filter(_.duedate == value)
      case (acc, SalesorderheaderFieldValue.shipdate(value)) => acc.filter(_.shipdate == value)
      case (acc, SalesorderheaderFieldValue.status(value)) => acc.filter(_.status == value)
      case (acc, SalesorderheaderFieldValue.onlineorderflag(value)) => acc.filter(_.onlineorderflag == value)
      case (acc, SalesorderheaderFieldValue.purchaseordernumber(value)) => acc.filter(_.purchaseordernumber == value)
      case (acc, SalesorderheaderFieldValue.accountnumber(value)) => acc.filter(_.accountnumber == value)
      case (acc, SalesorderheaderFieldValue.customerid(value)) => acc.filter(_.customerid == value)
      case (acc, SalesorderheaderFieldValue.salespersonid(value)) => acc.filter(_.salespersonid == value)
      case (acc, SalesorderheaderFieldValue.territoryid(value)) => acc.filter(_.territoryid == value)
      case (acc, SalesorderheaderFieldValue.billtoaddressid(value)) => acc.filter(_.billtoaddressid == value)
      case (acc, SalesorderheaderFieldValue.shiptoaddressid(value)) => acc.filter(_.shiptoaddressid == value)
      case (acc, SalesorderheaderFieldValue.shipmethodid(value)) => acc.filter(_.shipmethodid == value)
      case (acc, SalesorderheaderFieldValue.creditcardid(value)) => acc.filter(_.creditcardid == value)
      case (acc, SalesorderheaderFieldValue.creditcardapprovalcode(value)) => acc.filter(_.creditcardapprovalcode == value)
      case (acc, SalesorderheaderFieldValue.currencyrateid(value)) => acc.filter(_.currencyrateid == value)
      case (acc, SalesorderheaderFieldValue.subtotal(value)) => acc.filter(_.subtotal == value)
      case (acc, SalesorderheaderFieldValue.taxamt(value)) => acc.filter(_.taxamt == value)
      case (acc, SalesorderheaderFieldValue.freight(value)) => acc.filter(_.freight == value)
      case (acc, SalesorderheaderFieldValue.totaldue(value)) => acc.filter(_.totaldue == value)
      case (acc, SalesorderheaderFieldValue.comment(value)) => acc.filter(_.comment == value)
      case (acc, SalesorderheaderFieldValue.rowguid(value)) => acc.filter(_.rowguid == value)
      case (acc, SalesorderheaderFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
    }.toList
  }
  override def selectById(salesorderid: SalesorderheaderId)(implicit c: Connection): Option[SalesorderheaderRow] = {
    map.get(salesorderid)
  }
  override def selectByIds(salesorderids: Array[SalesorderheaderId])(implicit c: Connection): List[SalesorderheaderRow] = {
    salesorderids.flatMap(map.get).toList
  }
  override def update(row: SalesorderheaderRow)(implicit c: Connection): Boolean = {
    map.get(row.salesorderid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.salesorderid, row)
        true
      case None => false
    }
  }
  override def updateFieldValues(salesorderid: SalesorderheaderId, fieldValues: List[SalesorderheaderFieldValue[_]])(implicit c: Connection): Boolean = {
    map.get(salesorderid) match {
      case Some(oldRow) =>
        val updatedRow = fieldValues.foldLeft(oldRow) {
          case (acc, SalesorderheaderFieldValue.revisionnumber(value)) => acc.copy(revisionnumber = value)
          case (acc, SalesorderheaderFieldValue.orderdate(value)) => acc.copy(orderdate = value)
          case (acc, SalesorderheaderFieldValue.duedate(value)) => acc.copy(duedate = value)
          case (acc, SalesorderheaderFieldValue.shipdate(value)) => acc.copy(shipdate = value)
          case (acc, SalesorderheaderFieldValue.status(value)) => acc.copy(status = value)
          case (acc, SalesorderheaderFieldValue.onlineorderflag(value)) => acc.copy(onlineorderflag = value)
          case (acc, SalesorderheaderFieldValue.purchaseordernumber(value)) => acc.copy(purchaseordernumber = value)
          case (acc, SalesorderheaderFieldValue.accountnumber(value)) => acc.copy(accountnumber = value)
          case (acc, SalesorderheaderFieldValue.customerid(value)) => acc.copy(customerid = value)
          case (acc, SalesorderheaderFieldValue.salespersonid(value)) => acc.copy(salespersonid = value)
          case (acc, SalesorderheaderFieldValue.territoryid(value)) => acc.copy(territoryid = value)
          case (acc, SalesorderheaderFieldValue.billtoaddressid(value)) => acc.copy(billtoaddressid = value)
          case (acc, SalesorderheaderFieldValue.shiptoaddressid(value)) => acc.copy(shiptoaddressid = value)
          case (acc, SalesorderheaderFieldValue.shipmethodid(value)) => acc.copy(shipmethodid = value)
          case (acc, SalesorderheaderFieldValue.creditcardid(value)) => acc.copy(creditcardid = value)
          case (acc, SalesorderheaderFieldValue.creditcardapprovalcode(value)) => acc.copy(creditcardapprovalcode = value)
          case (acc, SalesorderheaderFieldValue.currencyrateid(value)) => acc.copy(currencyrateid = value)
          case (acc, SalesorderheaderFieldValue.subtotal(value)) => acc.copy(subtotal = value)
          case (acc, SalesorderheaderFieldValue.taxamt(value)) => acc.copy(taxamt = value)
          case (acc, SalesorderheaderFieldValue.freight(value)) => acc.copy(freight = value)
          case (acc, SalesorderheaderFieldValue.totaldue(value)) => acc.copy(totaldue = value)
          case (acc, SalesorderheaderFieldValue.comment(value)) => acc.copy(comment = value)
          case (acc, SalesorderheaderFieldValue.rowguid(value)) => acc.copy(rowguid = value)
          case (acc, SalesorderheaderFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
        }
        if (updatedRow != oldRow) {
          map.put(salesorderid, updatedRow)
          true
        } else {
          false
        }
      case None => false
    }
  }
  override def upsert(unsaved: SalesorderheaderRow)(implicit c: Connection): SalesorderheaderRow = {
    map.put(unsaved.salesorderid, unsaved)
    unsaved
  }
}
