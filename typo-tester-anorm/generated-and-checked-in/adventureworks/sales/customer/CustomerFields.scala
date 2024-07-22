/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.customer

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.person.PersonFields
import adventureworks.person.person.PersonRow
import adventureworks.sales.salesterritory.SalesterritoryFields
import adventureworks.sales.salesterritory.SalesterritoryId
import adventureworks.sales.salesterritory.SalesterritoryRow
import adventureworks.sales.store.StoreFields
import adventureworks.sales.store.StoreRow
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLike
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait CustomerFields {
  def customerid: IdField[CustomerId, CustomerRow]
  def personid: OptField[BusinessentityId, CustomerRow]
  def storeid: OptField[BusinessentityId, CustomerRow]
  def territoryid: OptField[SalesterritoryId, CustomerRow]
  def rowguid: Field[TypoUUID, CustomerRow]
  def modifieddate: Field[TypoLocalDateTime, CustomerRow]
  def fkPersonPerson: ForeignKey[PersonFields, PersonRow] =
    ForeignKey[PersonFields, PersonRow]("sales.FK_Customer_Person_PersonID", Nil)
      .withColumnPair(personid, _.businessentityid)
  def fkSalesterritory: ForeignKey[SalesterritoryFields, SalesterritoryRow] =
    ForeignKey[SalesterritoryFields, SalesterritoryRow]("sales.FK_Customer_SalesTerritory_TerritoryID", Nil)
      .withColumnPair(territoryid, _.territoryid)
  def fkStore: ForeignKey[StoreFields, StoreRow] =
    ForeignKey[StoreFields, StoreRow]("sales.FK_Customer_Store_StoreID", Nil)
      .withColumnPair(storeid, _.businessentityid)
}

object CustomerFields {
  lazy val structure: Relation[CustomerFields, CustomerRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[CustomerFields, CustomerRow] {
  
    override lazy val fields: CustomerFields = new CustomerFields {
      override def customerid = IdField[CustomerId, CustomerRow](_path, "customerid", None, Some("int4"), x => x.customerid, (row, value) => row.copy(customerid = value))
      override def personid = OptField[BusinessentityId, CustomerRow](_path, "personid", None, Some("int4"), x => x.personid, (row, value) => row.copy(personid = value))
      override def storeid = OptField[BusinessentityId, CustomerRow](_path, "storeid", None, Some("int4"), x => x.storeid, (row, value) => row.copy(storeid = value))
      override def territoryid = OptField[SalesterritoryId, CustomerRow](_path, "territoryid", None, Some("int4"), x => x.territoryid, (row, value) => row.copy(territoryid = value))
      override def rowguid = Field[TypoUUID, CustomerRow](_path, "rowguid", None, Some("uuid"), x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, CustomerRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, CustomerRow]] =
      List[FieldLike[?, CustomerRow]](fields.customerid, fields.personid, fields.storeid, fields.territoryid, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
