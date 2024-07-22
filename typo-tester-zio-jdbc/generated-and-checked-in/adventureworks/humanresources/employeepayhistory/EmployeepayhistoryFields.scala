/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.employeepayhistory

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.humanresources.employee.EmployeeFields
import adventureworks.humanresources.employee.EmployeeRow
import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.ForeignKey
import typo.dsl.PGType
import typo.dsl.Path
import typo.dsl.SqlExpr
import typo.dsl.SqlExpr.CompositeIn
import typo.dsl.SqlExpr.CompositeIn.TuplePart
import typo.dsl.SqlExpr.Const.As.as
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLike
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait EmployeepayhistoryFields {
  def businessentityid: IdField[BusinessentityId, EmployeepayhistoryRow]
  def ratechangedate: IdField[TypoLocalDateTime, EmployeepayhistoryRow]
  def rate: Field[BigDecimal, EmployeepayhistoryRow]
  def payfrequency: Field[TypoShort, EmployeepayhistoryRow]
  def modifieddate: Field[TypoLocalDateTime, EmployeepayhistoryRow]
  def fkEmployee: ForeignKey[EmployeeFields, EmployeeRow] =
    ForeignKey[EmployeeFields, EmployeeRow]("humanresources.FK_EmployeePayHistory_Employee_BusinessEntityID", Nil)
      .withColumnPair(businessentityid, _.businessentityid)
  def compositeIdIs(compositeId: EmployeepayhistoryId): SqlExpr[Boolean] =
    businessentityid.isEqual(compositeId.businessentityid).and(ratechangedate.isEqual(compositeId.ratechangedate))
  def compositeIdIn(compositeIds: Array[EmployeepayhistoryId]): SqlExpr[Boolean] =
    new CompositeIn(compositeIds)(TuplePart[EmployeepayhistoryId](businessentityid)(_.businessentityid)(using as[Array[BusinessentityId]](BusinessentityId.arrayJdbcEncoder, PGType.forArray(BusinessentityId.pgType)), implicitly), TuplePart[EmployeepayhistoryId](ratechangedate)(_.ratechangedate)(using as[Array[TypoLocalDateTime]](TypoLocalDateTime.arrayJdbcEncoder, PGType.forArray(TypoLocalDateTime.pgType)), implicitly))
  
}

object EmployeepayhistoryFields {
  lazy val structure: Relation[EmployeepayhistoryFields, EmployeepayhistoryRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[EmployeepayhistoryFields, EmployeepayhistoryRow] {
  
    override lazy val fields: EmployeepayhistoryFields = new EmployeepayhistoryFields {
      override def businessentityid = IdField[BusinessentityId, EmployeepayhistoryRow](_path, "businessentityid", None, Some("int4"), x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def ratechangedate = IdField[TypoLocalDateTime, EmployeepayhistoryRow](_path, "ratechangedate", Some("text"), Some("timestamp"), x => x.ratechangedate, (row, value) => row.copy(ratechangedate = value))
      override def rate = Field[BigDecimal, EmployeepayhistoryRow](_path, "rate", None, Some("numeric"), x => x.rate, (row, value) => row.copy(rate = value))
      override def payfrequency = Field[TypoShort, EmployeepayhistoryRow](_path, "payfrequency", None, Some("int2"), x => x.payfrequency, (row, value) => row.copy(payfrequency = value))
      override def modifieddate = Field[TypoLocalDateTime, EmployeepayhistoryRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, EmployeepayhistoryRow]] =
      List[FieldLike[?, EmployeepayhistoryRow]](fields.businessentityid, fields.ratechangedate, fields.rate, fields.payfrequency, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
