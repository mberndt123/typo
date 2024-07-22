/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesorderheadersalesreason

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesreason.SalesreasonId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.Write
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: sales.salesorderheadersalesreason
    Cross-reference table mapping sales orders to sales reason codes.
    Composite primary key: salesorderid, salesreasonid */
case class SalesorderheadersalesreasonRow(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
      Points to [[adventureworks.sales.salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Primary key. Foreign key to SalesReason.SalesReasonID.
      Points to [[adventureworks.sales.salesreason.SalesreasonRow.salesreasonid]] */
  salesreasonid: SalesreasonId,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalesorderheadersalesreasonId = SalesorderheadersalesreasonId(salesorderid, salesreasonid)
   val id = compositeId
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): SalesorderheadersalesreasonRowUnsaved =
     SalesorderheadersalesreasonRowUnsaved(salesorderid, salesreasonid, modifieddate)
 }

object SalesorderheadersalesreasonRow {
  def apply(compositeId: SalesorderheadersalesreasonId, modifieddate: TypoLocalDateTime) =
    new SalesorderheadersalesreasonRow(compositeId.salesorderid, compositeId.salesreasonid, modifieddate)
  implicit lazy val decoder: Decoder[SalesorderheadersalesreasonRow] = Decoder.forProduct3[SalesorderheadersalesreasonRow, SalesorderheaderId, SalesreasonId, TypoLocalDateTime]("salesorderid", "salesreasonid", "modifieddate")(SalesorderheadersalesreasonRow.apply)(SalesorderheaderId.decoder, SalesreasonId.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SalesorderheadersalesreasonRow] = Encoder.forProduct3[SalesorderheadersalesreasonRow, SalesorderheaderId, SalesreasonId, TypoLocalDateTime]("salesorderid", "salesreasonid", "modifieddate")(x => (x.salesorderid, x.salesreasonid, x.modifieddate))(SalesorderheaderId.encoder, SalesreasonId.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SalesorderheadersalesreasonRow] = new Read[SalesorderheadersalesreasonRow](
    gets = List(
      (SalesorderheaderId.get, Nullability.NoNulls),
      (SalesreasonId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SalesorderheadersalesreasonRow(
      salesorderid = SalesorderheaderId.get.unsafeGetNonNullable(rs, i + 0),
      salesreasonid = SalesreasonId.get.unsafeGetNonNullable(rs, i + 1),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2)
    )
  )
  implicit lazy val text: Text[SalesorderheadersalesreasonRow] = Text.instance[SalesorderheadersalesreasonRow]{ (row, sb) =>
    SalesorderheaderId.text.unsafeEncode(row.salesorderid, sb)
    sb.append(Text.DELIMETER)
    SalesreasonId.text.unsafeEncode(row.salesreasonid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val write: Write[SalesorderheadersalesreasonRow] = new Write[SalesorderheadersalesreasonRow](
    puts = List((SalesorderheaderId.put, Nullability.NoNulls),
                (SalesreasonId.put, Nullability.NoNulls),
                (TypoLocalDateTime.put, Nullability.NoNulls)),
    toList = x => List(x.salesorderid, x.salesreasonid, x.modifieddate),
    unsafeSet = (rs, i, a) => {
                  SalesorderheaderId.put.unsafeSetNonNullable(rs, i + 0, a.salesorderid)
                  SalesreasonId.put.unsafeSetNonNullable(rs, i + 1, a.salesreasonid)
                  TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 2, a.modifieddate)
                },
    unsafeUpdate = (ps, i, a) => {
                     SalesorderheaderId.put.unsafeUpdateNonNullable(ps, i + 0, a.salesorderid)
                     SalesreasonId.put.unsafeUpdateNonNullable(ps, i + 1, a.salesreasonid)
                     TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 2, a.modifieddate)
                   }
  )
}
