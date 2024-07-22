/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.vsalespersonsalesbyfiscalyears;

import doobie.enumerated.Nullability;
import doobie.util.Read;
import doobie.util.meta.Meta;
import io.circe.Decoder;
import io.circe.Encoder;
import java.sql.ResultSet;

/** View: sales.vsalespersonsalesbyfiscalyears */
case class VsalespersonsalesbyfiscalyearsViewRow(
  salesPersonID: /* nullability unknown */ Option[Int],
  fullName: /* nullability unknown */ Option[String],
  jobTitle: /* nullability unknown */ Option[String],
  salesTerritory: /* nullability unknown */ Option[String],
  `2012`: /* nullability unknown */ Option[BigDecimal],
  `2013`: /* nullability unknown */ Option[BigDecimal],
  `2014`: /* nullability unknown */ Option[BigDecimal]
)

object VsalespersonsalesbyfiscalyearsViewRow {
  implicit lazy val decoder: Decoder[VsalespersonsalesbyfiscalyearsViewRow] = Decoder.forProduct7[VsalespersonsalesbyfiscalyearsViewRow, /* nullability unknown */ Option[Int], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[BigDecimal], /* nullability unknown */ Option[BigDecimal], /* nullability unknown */ Option[BigDecimal]]("SalesPersonID", "FullName", "JobTitle", "SalesTerritory", "2012", "2013", "2014")(VsalespersonsalesbyfiscalyearsViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal))
  implicit lazy val encoder: Encoder[VsalespersonsalesbyfiscalyearsViewRow] = Encoder.forProduct7[VsalespersonsalesbyfiscalyearsViewRow, /* nullability unknown */ Option[Int], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[BigDecimal], /* nullability unknown */ Option[BigDecimal], /* nullability unknown */ Option[BigDecimal]]("SalesPersonID", "FullName", "JobTitle", "SalesTerritory", "2012", "2013", "2014")(x => (x.salesPersonID, x.fullName, x.jobTitle, x.salesTerritory, x.`2012`, x.`2013`, x.`2014`))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal))
  implicit lazy val read: Read[VsalespersonsalesbyfiscalyearsViewRow] = {
    new Read[VsalespersonsalesbyfiscalyearsViewRow](
      gets = List(
        (Meta.IntMeta.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable),
        (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
        (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
        (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => VsalespersonsalesbyfiscalyearsViewRow(
        salesPersonID = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
        fullName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
        jobTitle = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
        salesTerritory = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
        `2012` = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 4),
        `2013` = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 5),
        `2014` = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 6)
      )
    )
  
  }
}