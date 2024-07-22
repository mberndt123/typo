/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.workorder

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.Write
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: production.workorder
    Manufacturing work orders.
    Primary key: workorderid */
case class WorkorderRow(
  /** Primary key for WorkOrder records.
      Default: nextval('production.workorder_workorderid_seq'::regclass) */
  workorderid: WorkorderId,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[adventureworks.production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Product quantity to build.
      Constraint CK_WorkOrder_OrderQty affecting columns orderqty: ((orderqty > 0)) */
  orderqty: Int,
  /** Quantity that failed inspection.
      Constraint CK_WorkOrder_ScrappedQty affecting columns scrappedqty: ((scrappedqty >= 0)) */
  scrappedqty: TypoShort,
  /** Work order start date.
      Constraint CK_WorkOrder_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** Work order end date.
      Constraint CK_WorkOrder_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Work order due date. */
  duedate: TypoLocalDateTime,
  /** Reason for inspection failure.
      Points to [[adventureworks.production.scrapreason.ScrapreasonRow.scrapreasonid]] */
  scrapreasonid: Option[ScrapreasonId],
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = workorderid
   def toUnsavedRow(workorderid: Defaulted[WorkorderId], modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): WorkorderRowUnsaved =
     WorkorderRowUnsaved(productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, workorderid, modifieddate)
 }

object WorkorderRow {
  implicit lazy val decoder: Decoder[WorkorderRow] = Decoder.forProduct9[WorkorderRow, WorkorderId, ProductId, Int, TypoShort, TypoLocalDateTime, Option[TypoLocalDateTime], TypoLocalDateTime, Option[ScrapreasonId], TypoLocalDateTime]("workorderid", "productid", "orderqty", "scrappedqty", "startdate", "enddate", "duedate", "scrapreasonid", "modifieddate")(WorkorderRow.apply)(WorkorderId.decoder, ProductId.decoder, Decoder.decodeInt, TypoShort.decoder, TypoLocalDateTime.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), TypoLocalDateTime.decoder, Decoder.decodeOption(ScrapreasonId.decoder), TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[WorkorderRow] = Encoder.forProduct9[WorkorderRow, WorkorderId, ProductId, Int, TypoShort, TypoLocalDateTime, Option[TypoLocalDateTime], TypoLocalDateTime, Option[ScrapreasonId], TypoLocalDateTime]("workorderid", "productid", "orderqty", "scrappedqty", "startdate", "enddate", "duedate", "scrapreasonid", "modifieddate")(x => (x.workorderid, x.productid, x.orderqty, x.scrappedqty, x.startdate, x.enddate, x.duedate, x.scrapreasonid, x.modifieddate))(WorkorderId.encoder, ProductId.encoder, Encoder.encodeInt, TypoShort.encoder, TypoLocalDateTime.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), TypoLocalDateTime.encoder, Encoder.encodeOption(ScrapreasonId.encoder), TypoLocalDateTime.encoder)
  implicit lazy val read: Read[WorkorderRow] = new Read[WorkorderRow](
    gets = List(
      (WorkorderId.get, Nullability.NoNulls),
      (ProductId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (ScrapreasonId.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => WorkorderRow(
      workorderid = WorkorderId.get.unsafeGetNonNullable(rs, i + 0),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 1),
      orderqty = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 2),
      scrappedqty = TypoShort.get.unsafeGetNonNullable(rs, i + 3),
      startdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4),
      enddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 5),
      duedate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6),
      scrapreasonid = ScrapreasonId.get.unsafeGetNullable(rs, i + 7),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
  implicit lazy val text: Text[WorkorderRow] = Text.instance[WorkorderRow]{ (row, sb) =>
    WorkorderId.text.unsafeEncode(row.workorderid, sb)
    sb.append(Text.DELIMETER)
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.orderqty, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.scrappedqty, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.duedate, sb)
    sb.append(Text.DELIMETER)
    Text.option(ScrapreasonId.text).unsafeEncode(row.scrapreasonid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val write: Write[WorkorderRow] = new Write[WorkorderRow](
    puts = List((WorkorderId.put, Nullability.NoNulls),
                (ProductId.put, Nullability.NoNulls),
                (Meta.IntMeta.put, Nullability.NoNulls),
                (TypoShort.put, Nullability.NoNulls),
                (TypoLocalDateTime.put, Nullability.NoNulls),
                (TypoLocalDateTime.put, Nullability.Nullable),
                (TypoLocalDateTime.put, Nullability.NoNulls),
                (ScrapreasonId.put, Nullability.Nullable),
                (TypoLocalDateTime.put, Nullability.NoNulls)),
    toList = x => List(x.workorderid, x.productid, x.orderqty, x.scrappedqty, x.startdate, x.enddate, x.duedate, x.scrapreasonid, x.modifieddate),
    unsafeSet = (rs, i, a) => {
                  WorkorderId.put.unsafeSetNonNullable(rs, i + 0, a.workorderid)
                  ProductId.put.unsafeSetNonNullable(rs, i + 1, a.productid)
                  Meta.IntMeta.put.unsafeSetNonNullable(rs, i + 2, a.orderqty)
                  TypoShort.put.unsafeSetNonNullable(rs, i + 3, a.scrappedqty)
                  TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 4, a.startdate)
                  TypoLocalDateTime.put.unsafeSetNullable(rs, i + 5, a.enddate)
                  TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 6, a.duedate)
                  ScrapreasonId.put.unsafeSetNullable(rs, i + 7, a.scrapreasonid)
                  TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 8, a.modifieddate)
                },
    unsafeUpdate = (ps, i, a) => {
                     WorkorderId.put.unsafeUpdateNonNullable(ps, i + 0, a.workorderid)
                     ProductId.put.unsafeUpdateNonNullable(ps, i + 1, a.productid)
                     Meta.IntMeta.put.unsafeUpdateNonNullable(ps, i + 2, a.orderqty)
                     TypoShort.put.unsafeUpdateNonNullable(ps, i + 3, a.scrappedqty)
                     TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 4, a.startdate)
                     TypoLocalDateTime.put.unsafeUpdateNullable(ps, i + 5, a.enddate)
                     TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 6, a.duedate)
                     ScrapreasonId.put.unsafeUpdateNullable(ps, i + 7, a.scrapreasonid)
                     TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 8, a.modifieddate)
                   }
  )
}
