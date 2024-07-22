/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.transactionhistoryarchive

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.transactionhistoryarchive` which has not been persisted yet */
case class TransactionhistoryarchiveRowUnsaved(
  /** Primary key for TransactionHistoryArchive records. */
  transactionid: TransactionhistoryarchiveId,
  /** Product identification number. Foreign key to Product.ProductID. */
  productid: Int,
  /** Purchase order, sales order, or work order identification number. */
  referenceorderid: Int,
  /** W = Work Order, S = Sales Order, P = Purchase Order
      Constraint CK_TransactionHistoryArchive_TransactionType affecting columns transactiontype:  ((upper((transactiontype)::text) = ANY (ARRAY['W'::text, 'S'::text, 'P'::text]))) */
  transactiontype: /* bpchar, max 1 chars */ String,
  /** Product quantity. */
  quantity: Int,
  /** Product cost. */
  actualcost: BigDecimal,
  /** Default: 0
      Line number associated with the purchase order, sales order, or work order. */
  referenceorderlineid: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: now()
      Date and time of the transaction. */
  transactiondate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(referenceorderlineidDefault: => Int, transactiondateDefault: => TypoLocalDateTime, modifieddateDefault: => TypoLocalDateTime): TransactionhistoryarchiveRow =
    TransactionhistoryarchiveRow(
      transactionid = transactionid,
      productid = productid,
      referenceorderid = referenceorderid,
      referenceorderlineid = referenceorderlineid match {
                               case Defaulted.UseDefault => referenceorderlineidDefault
                               case Defaulted.Provided(value) => value
                             },
      transactiondate = transactiondate match {
                          case Defaulted.UseDefault => transactiondateDefault
                          case Defaulted.Provided(value) => value
                        },
      transactiontype = transactiontype,
      quantity = quantity,
      actualcost = actualcost,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object TransactionhistoryarchiveRowUnsaved {
  implicit lazy val decoder: Decoder[TransactionhistoryarchiveRowUnsaved] = Decoder.forProduct9[TransactionhistoryarchiveRowUnsaved, TransactionhistoryarchiveId, Int, Int, /* bpchar, max 1 chars */ String, Int, BigDecimal, Defaulted[Int], Defaulted[TypoLocalDateTime], Defaulted[TypoLocalDateTime]]("transactionid", "productid", "referenceorderid", "transactiontype", "quantity", "actualcost", "referenceorderlineid", "transactiondate", "modifieddate")(TransactionhistoryarchiveRowUnsaved.apply)(TransactionhistoryarchiveId.decoder, Decoder.decodeInt, Decoder.decodeInt, Decoder.decodeString, Decoder.decodeInt, Decoder.decodeBigDecimal, Defaulted.decoder(Decoder.decodeInt), Defaulted.decoder(TypoLocalDateTime.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[TransactionhistoryarchiveRowUnsaved] = Encoder.forProduct9[TransactionhistoryarchiveRowUnsaved, TransactionhistoryarchiveId, Int, Int, /* bpchar, max 1 chars */ String, Int, BigDecimal, Defaulted[Int], Defaulted[TypoLocalDateTime], Defaulted[TypoLocalDateTime]]("transactionid", "productid", "referenceorderid", "transactiontype", "quantity", "actualcost", "referenceorderlineid", "transactiondate", "modifieddate")(x => (x.transactionid, x.productid, x.referenceorderid, x.transactiontype, x.quantity, x.actualcost, x.referenceorderlineid, x.transactiondate, x.modifieddate))(TransactionhistoryarchiveId.encoder, Encoder.encodeInt, Encoder.encodeInt, Encoder.encodeString, Encoder.encodeInt, Encoder.encodeBigDecimal, Defaulted.encoder(Encoder.encodeInt), Defaulted.encoder(TypoLocalDateTime.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[TransactionhistoryarchiveRowUnsaved] = Text.instance[TransactionhistoryarchiveRowUnsaved]{ (row, sb) =>
    TransactionhistoryarchiveId.text.unsafeEncode(row.transactionid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.referenceorderid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.transactiontype, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.quantity, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.actualcost, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.intInstance).unsafeEncode(row.referenceorderlineid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.transactiondate, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
