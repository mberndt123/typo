/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.currencyrate;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.sales.currency.CurrencyId;
import doobie.enumerated.Nullability;
import doobie.postgres.Text;
import doobie.util.Read;
import doobie.util.Write;
import doobie.util.meta.Meta;
import io.circe.Decoder;
import io.circe.Encoder;
import java.sql.ResultSet;

/** Table: sales.currencyrate
  * Currency exchange rates.
  * Primary key: currencyrateid
  */
case class CurrencyrateRow(
  /** Primary key for CurrencyRate records.
    * Default: nextval('sales.currencyrate_currencyrateid_seq'::regclass)
    */
  currencyrateid: CurrencyrateId,
  /** Date and time the exchange rate was obtained. */
  currencyratedate: TypoLocalDateTime,
  /** Exchange rate was converted from this currency code.
    * Points to [[adventureworks.sales.currency.CurrencyRow.currencycode]]
    */
  fromcurrencycode: CurrencyId,
  /** Exchange rate was converted to this currency code.
    * Points to [[adventureworks.sales.currency.CurrencyRow.currencycode]]
    */
  tocurrencycode: CurrencyId,
  /** Average exchange rate for the day. */
  averagerate: BigDecimal,
  /** Final exchange rate for the day. */
  endofdayrate: BigDecimal,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
) {
  def id: CurrencyrateId = currencyrateid
  def toUnsavedRow(currencyrateid: Defaulted[CurrencyrateId], modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): CurrencyrateRowUnsaved = {
    new CurrencyrateRowUnsaved(
      currencyratedate,
      fromcurrencycode,
      tocurrencycode,
      averagerate,
      endofdayrate,
      currencyrateid,
      modifieddate
    )
  }
}

object CurrencyrateRow {
  implicit lazy val decoder: Decoder[CurrencyrateRow] = Decoder.forProduct7[CurrencyrateRow, CurrencyrateId, TypoLocalDateTime, CurrencyId, CurrencyId, BigDecimal, BigDecimal, TypoLocalDateTime]("currencyrateid", "currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate")(CurrencyrateRow.apply)(CurrencyrateId.decoder, TypoLocalDateTime.decoder, CurrencyId.decoder, CurrencyId.decoder, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[CurrencyrateRow] = Encoder.forProduct7[CurrencyrateRow, CurrencyrateId, TypoLocalDateTime, CurrencyId, CurrencyId, BigDecimal, BigDecimal, TypoLocalDateTime]("currencyrateid", "currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate")(x => (x.currencyrateid, x.currencyratedate, x.fromcurrencycode, x.tocurrencycode, x.averagerate, x.endofdayrate, x.modifieddate))(CurrencyrateId.encoder, TypoLocalDateTime.encoder, CurrencyId.encoder, CurrencyId.encoder, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[CurrencyrateRow] = {
    new Read[CurrencyrateRow](
      gets = List(
        (CurrencyrateId.get, Nullability.NoNulls),
        (TypoLocalDateTime.get, Nullability.NoNulls),
        (CurrencyId.get, Nullability.NoNulls),
        (CurrencyId.get, Nullability.NoNulls),
        (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
        (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
        (TypoLocalDateTime.get, Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => CurrencyrateRow(
        currencyrateid = CurrencyrateId.get.unsafeGetNonNullable(rs, i + 0),
        currencyratedate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 1),
        fromcurrencycode = CurrencyId.get.unsafeGetNonNullable(rs, i + 2),
        tocurrencycode = CurrencyId.get.unsafeGetNonNullable(rs, i + 3),
        averagerate = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 4),
        endofdayrate = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 5),
        modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6)
      )
    )
  
  }
  implicit lazy val text: Text[CurrencyrateRow] = {
    Text.instance[CurrencyrateRow]{ (row, sb) =>
      CurrencyrateId.text.unsafeEncode(row.currencyrateid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.currencyratedate, sb)
      sb.append(Text.DELIMETER)
      CurrencyId.text.unsafeEncode(row.fromcurrencycode, sb)
      sb.append(Text.DELIMETER)
      CurrencyId.text.unsafeEncode(row.tocurrencycode, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.averagerate, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.endofdayrate, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    }
  }
  implicit lazy val write: Write[CurrencyrateRow] = {
    new Write[CurrencyrateRow](
      puts = List((CurrencyrateId.put, Nullability.NoNulls),
                  (TypoLocalDateTime.put, Nullability.NoNulls),
                  (CurrencyId.put, Nullability.NoNulls),
                  (CurrencyId.put, Nullability.NoNulls),
                  (Meta.ScalaBigDecimalMeta.put, Nullability.NoNulls),
                  (Meta.ScalaBigDecimalMeta.put, Nullability.NoNulls),
                  (TypoLocalDateTime.put, Nullability.NoNulls)),
      toList = x => List(x.currencyrateid, x.currencyratedate, x.fromcurrencycode, x.tocurrencycode, x.averagerate, x.endofdayrate, x.modifieddate),
      unsafeSet = (rs, i, a) => {
                    CurrencyrateId.put.unsafeSetNonNullable(rs, i + 0, a.currencyrateid)
                    TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 1, a.currencyratedate)
                    CurrencyId.put.unsafeSetNonNullable(rs, i + 2, a.fromcurrencycode)
                    CurrencyId.put.unsafeSetNonNullable(rs, i + 3, a.tocurrencycode)
                    Meta.ScalaBigDecimalMeta.put.unsafeSetNonNullable(rs, i + 4, a.averagerate)
                    Meta.ScalaBigDecimalMeta.put.unsafeSetNonNullable(rs, i + 5, a.endofdayrate)
                    TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 6, a.modifieddate)
                  },
      unsafeUpdate = (ps, i, a) => {
                       CurrencyrateId.put.unsafeUpdateNonNullable(ps, i + 0, a.currencyrateid)
                       TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 1, a.currencyratedate)
                       CurrencyId.put.unsafeUpdateNonNullable(ps, i + 2, a.fromcurrencycode)
                       CurrencyId.put.unsafeUpdateNonNullable(ps, i + 3, a.tocurrencycode)
                       Meta.ScalaBigDecimalMeta.put.unsafeUpdateNonNullable(ps, i + 4, a.averagerate)
                       Meta.ScalaBigDecimalMeta.put.unsafeUpdateNonNullable(ps, i + 5, a.endofdayrate)
                       TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 6, a.modifieddate)
                     }
    )
  
  }
}