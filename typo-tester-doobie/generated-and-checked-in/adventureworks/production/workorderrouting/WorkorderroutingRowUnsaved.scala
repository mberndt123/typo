/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.workorderrouting;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoShort;
import adventureworks.production.location.LocationId;
import adventureworks.production.workorder.WorkorderId;
import doobie.postgres.Text;
import io.circe.Decoder;
import io.circe.Encoder;

/** This class corresponds to a row in table `production.workorderrouting` which has not been persisted yet */
case class WorkorderroutingRowUnsaved(
  /** Primary key. Foreign key to WorkOrder.WorkOrderID.
    * Points to [[adventureworks.production.workorder.WorkorderRow.workorderid]]
    */
  workorderid: WorkorderId,
  /** Primary key. Foreign key to Product.ProductID. */
  productid: Int,
  /** Primary key. Indicates the manufacturing process sequence. */
  operationsequence: TypoShort,
  /** Manufacturing location where the part is processed. Foreign key to Location.LocationID.
    * Points to [[adventureworks.production.location.LocationRow.locationid]]
    */
  locationid: LocationId,
  /** Planned manufacturing start date.
    * Constraint CK_WorkOrderRouting_ScheduledEndDate affecting columns scheduledenddate, scheduledstartdate:  ((scheduledenddate >= scheduledstartdate))
    */
  scheduledstartdate: TypoLocalDateTime,
  /** Planned manufacturing end date.
    * Constraint CK_WorkOrderRouting_ScheduledEndDate affecting columns scheduledenddate, scheduledstartdate:  ((scheduledenddate >= scheduledstartdate))
    */
  scheduledenddate: TypoLocalDateTime,
  /** Actual start date.
    * Constraint CK_WorkOrderRouting_ActualEndDate affecting columns actualenddate, actualstartdate:  (((actualenddate >= actualstartdate) OR (actualenddate IS NULL) OR (actualstartdate IS NULL)))
    */
  actualstartdate: Option[TypoLocalDateTime],
  /** Actual end date.
    * Constraint CK_WorkOrderRouting_ActualEndDate affecting columns actualenddate, actualstartdate:  (((actualenddate >= actualstartdate) OR (actualenddate IS NULL) OR (actualstartdate IS NULL)))
    */
  actualenddate: Option[TypoLocalDateTime],
  /** Number of manufacturing hours used.
    * Constraint CK_WorkOrderRouting_ActualResourceHrs affecting columns actualresourcehrs:  ((actualresourcehrs >= 0.0000))
    */
  actualresourcehrs: Option[BigDecimal],
  /** Estimated manufacturing cost.
    * Constraint CK_WorkOrderRouting_PlannedCost affecting columns plannedcost:  ((plannedcost > 0.00))
    */
  plannedcost: BigDecimal,
  /** Actual manufacturing cost.
    * Constraint CK_WorkOrderRouting_ActualCost affecting columns actualcost:  ((actualcost > 0.00))
    */
  actualcost: Option[BigDecimal],
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault()
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): WorkorderroutingRow = {
    new WorkorderroutingRow(
      workorderid = workorderid,
      productid = productid,
      operationsequence = operationsequence,
      locationid = locationid,
      scheduledstartdate = scheduledstartdate,
      scheduledenddate = scheduledenddate,
      actualstartdate = actualstartdate,
      actualenddate = actualenddate,
      actualresourcehrs = actualresourcehrs,
      plannedcost = plannedcost,
      actualcost = actualcost,
      modifieddate = modifieddate.getOrElse(modifieddateDefault)
    )
  }
}

object WorkorderroutingRowUnsaved {
  implicit lazy val decoder: Decoder[WorkorderroutingRowUnsaved] = Decoder.forProduct12[WorkorderroutingRowUnsaved, WorkorderId, Int, TypoShort, LocationId, TypoLocalDateTime, TypoLocalDateTime, Option[TypoLocalDateTime], Option[TypoLocalDateTime], Option[BigDecimal], BigDecimal, Option[BigDecimal], Defaulted[TypoLocalDateTime]]("workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate", "scheduledenddate", "actualstartdate", "actualenddate", "actualresourcehrs", "plannedcost", "actualcost", "modifieddate")(WorkorderroutingRowUnsaved.apply)(WorkorderId.decoder, Decoder.decodeInt, TypoShort.decoder, LocationId.decoder, TypoLocalDateTime.decoder, TypoLocalDateTime.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeBigDecimal, Decoder.decodeOption(Decoder.decodeBigDecimal), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[WorkorderroutingRowUnsaved] = Encoder.forProduct12[WorkorderroutingRowUnsaved, WorkorderId, Int, TypoShort, LocationId, TypoLocalDateTime, TypoLocalDateTime, Option[TypoLocalDateTime], Option[TypoLocalDateTime], Option[BigDecimal], BigDecimal, Option[BigDecimal], Defaulted[TypoLocalDateTime]]("workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate", "scheduledenddate", "actualstartdate", "actualenddate", "actualresourcehrs", "plannedcost", "actualcost", "modifieddate")(x => (x.workorderid, x.productid, x.operationsequence, x.locationid, x.scheduledstartdate, x.scheduledenddate, x.actualstartdate, x.actualenddate, x.actualresourcehrs, x.plannedcost, x.actualcost, x.modifieddate))(WorkorderId.encoder, Encoder.encodeInt, TypoShort.encoder, LocationId.encoder, TypoLocalDateTime.encoder, TypoLocalDateTime.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeBigDecimal, Encoder.encodeOption(Encoder.encodeBigDecimal), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[WorkorderroutingRowUnsaved] = {
    Text.instance[WorkorderroutingRowUnsaved]{ (row, sb) =>
      WorkorderId.text.unsafeEncode(row.workorderid, sb)
      sb.append(Text.DELIMETER)
      Text.intInstance.unsafeEncode(row.productid, sb)
      sb.append(Text.DELIMETER)
      TypoShort.text.unsafeEncode(row.operationsequence, sb)
      sb.append(Text.DELIMETER)
      LocationId.text.unsafeEncode(row.locationid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.scheduledstartdate, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.scheduledenddate, sb)
      sb.append(Text.DELIMETER)
      Text.option(TypoLocalDateTime.text).unsafeEncode(row.actualstartdate, sb)
      sb.append(Text.DELIMETER)
      Text.option(TypoLocalDateTime.text).unsafeEncode(row.actualenddate, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.bigDecimalInstance).unsafeEncode(row.actualresourcehrs, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.plannedcost, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.bigDecimalInstance).unsafeEncode(row.actualcost, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
    }
  }
}