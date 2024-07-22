/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.workorderrouting;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoShort;
import adventureworks.production.location.LocationFields;
import adventureworks.production.location.LocationId;
import adventureworks.production.location.LocationRow;
import adventureworks.production.workorder.WorkorderFields;
import adventureworks.production.workorder.WorkorderId;
import adventureworks.production.workorder.WorkorderRow;
import typo.dsl.ForeignKey;
import typo.dsl.Path;
import typo.dsl.SqlExpr;
import typo.dsl.SqlExpr.CompositeIn;
import typo.dsl.SqlExpr.CompositeIn.TuplePart;
import typo.dsl.SqlExpr.Const.As.as;
import typo.dsl.SqlExpr.Field;
import typo.dsl.SqlExpr.FieldLike;
import typo.dsl.SqlExpr.IdField;
import typo.dsl.SqlExpr.OptField;
import typo.dsl.Structure.Relation;

trait WorkorderroutingFields {
  def workorderid: IdField[WorkorderId, WorkorderroutingRow]
  def productid: IdField[Int, WorkorderroutingRow]
  def operationsequence: IdField[TypoShort, WorkorderroutingRow]
  def locationid: Field[LocationId, WorkorderroutingRow]
  def scheduledstartdate: Field[TypoLocalDateTime, WorkorderroutingRow]
  def scheduledenddate: Field[TypoLocalDateTime, WorkorderroutingRow]
  def actualstartdate: OptField[TypoLocalDateTime, WorkorderroutingRow]
  def actualenddate: OptField[TypoLocalDateTime, WorkorderroutingRow]
  def actualresourcehrs: OptField[BigDecimal, WorkorderroutingRow]
  def plannedcost: Field[BigDecimal, WorkorderroutingRow]
  def actualcost: OptField[BigDecimal, WorkorderroutingRow]
  def modifieddate: Field[TypoLocalDateTime, WorkorderroutingRow]
  def fkLocation: ForeignKey[LocationFields, LocationRow] =
    ForeignKey[LocationFields, LocationRow]("production.FK_WorkOrderRouting_Location_LocationID", Nil)
      .withColumnPair(locationid, _.locationid)
  def fkWorkorder: ForeignKey[WorkorderFields, WorkorderRow] =
    ForeignKey[WorkorderFields, WorkorderRow]("production.FK_WorkOrderRouting_WorkOrder_WorkOrderID", Nil)
      .withColumnPair(workorderid, _.workorderid)
  def compositeIdIs(compositeId: WorkorderroutingId): SqlExpr[Boolean] =
    workorderid.isEqual(compositeId.workorderid).and(productid.isEqual(compositeId.productid)).and(operationsequence.isEqual(compositeId.operationsequence))
  def compositeIdIn(compositeIds: Array[WorkorderroutingId]): SqlExpr[Boolean] =
    new CompositeIn(compositeIds)(TuplePart[WorkorderroutingId](workorderid)(_.workorderid)(using as[Array[WorkorderId]](WorkorderId.arrayPut), implicitly), TuplePart[WorkorderroutingId](productid)(_.productid)(using as[Array[Int]](adventureworks.IntegerArrayMeta.put), implicitly), TuplePart[WorkorderroutingId](operationsequence)(_.operationsequence)(using as[Array[TypoShort]](TypoShort.arrayPut), implicitly))
  
}

object WorkorderroutingFields {
  lazy val structure: Relation[WorkorderroutingFields, WorkorderroutingRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[WorkorderroutingFields, WorkorderroutingRow] {
  
    override lazy val fields: WorkorderroutingFields = new WorkorderroutingFields {
      override def workorderid = IdField[WorkorderId, WorkorderroutingRow](_path, "workorderid", None, Some("int4"), x => x.workorderid, (row, value) => row.copy(workorderid = value))
      override def productid = IdField[Int, WorkorderroutingRow](_path, "productid", None, Some("int4"), x => x.productid, (row, value) => row.copy(productid = value))
      override def operationsequence = IdField[TypoShort, WorkorderroutingRow](_path, "operationsequence", None, Some("int2"), x => x.operationsequence, (row, value) => row.copy(operationsequence = value))
      override def locationid = Field[LocationId, WorkorderroutingRow](_path, "locationid", None, Some("int2"), x => x.locationid, (row, value) => row.copy(locationid = value))
      override def scheduledstartdate = Field[TypoLocalDateTime, WorkorderroutingRow](_path, "scheduledstartdate", Some("text"), Some("timestamp"), x => x.scheduledstartdate, (row, value) => row.copy(scheduledstartdate = value))
      override def scheduledenddate = Field[TypoLocalDateTime, WorkorderroutingRow](_path, "scheduledenddate", Some("text"), Some("timestamp"), x => x.scheduledenddate, (row, value) => row.copy(scheduledenddate = value))
      override def actualstartdate = OptField[TypoLocalDateTime, WorkorderroutingRow](_path, "actualstartdate", Some("text"), Some("timestamp"), x => x.actualstartdate, (row, value) => row.copy(actualstartdate = value))
      override def actualenddate = OptField[TypoLocalDateTime, WorkorderroutingRow](_path, "actualenddate", Some("text"), Some("timestamp"), x => x.actualenddate, (row, value) => row.copy(actualenddate = value))
      override def actualresourcehrs = OptField[BigDecimal, WorkorderroutingRow](_path, "actualresourcehrs", None, Some("numeric"), x => x.actualresourcehrs, (row, value) => row.copy(actualresourcehrs = value))
      override def plannedcost = Field[BigDecimal, WorkorderroutingRow](_path, "plannedcost", None, Some("numeric"), x => x.plannedcost, (row, value) => row.copy(plannedcost = value))
      override def actualcost = OptField[BigDecimal, WorkorderroutingRow](_path, "actualcost", None, Some("numeric"), x => x.actualcost, (row, value) => row.copy(actualcost = value))
      override def modifieddate = Field[TypoLocalDateTime, WorkorderroutingRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, WorkorderroutingRow]] =
      List[FieldLike[?, WorkorderroutingRow]](fields.workorderid, fields.productid, fields.operationsequence, fields.locationid, fields.scheduledstartdate, fields.scheduledenddate, fields.actualstartdate, fields.actualenddate, fields.actualresourcehrs, fields.plannedcost, fields.actualcost, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
