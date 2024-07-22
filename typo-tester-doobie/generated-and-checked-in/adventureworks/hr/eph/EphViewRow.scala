/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.hr.eph;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoShort;
import adventureworks.person.businessentity.BusinessentityId;
import doobie.enumerated.Nullability;
import doobie.util.Read;
import doobie.util.meta.Meta;
import io.circe.Decoder;
import io.circe.Encoder;
import java.sql.ResultSet;

/** View: hr.eph */
case class EphViewRow(
  /** Points to [[adventureworks.humanresources.employeepayhistory.EmployeepayhistoryRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[adventureworks.humanresources.employeepayhistory.EmployeepayhistoryRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[adventureworks.humanresources.employeepayhistory.EmployeepayhistoryRow.ratechangedate]] */
  ratechangedate: TypoLocalDateTime,
  /** Points to [[adventureworks.humanresources.employeepayhistory.EmployeepayhistoryRow.rate]] */
  rate: BigDecimal,
  /** Points to [[adventureworks.humanresources.employeepayhistory.EmployeepayhistoryRow.payfrequency]] */
  payfrequency: TypoShort,
  /** Points to [[adventureworks.humanresources.employeepayhistory.EmployeepayhistoryRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object EphViewRow {
  implicit lazy val decoder: Decoder[EphViewRow] = Decoder.forProduct6[EphViewRow, BusinessentityId, BusinessentityId, TypoLocalDateTime, BigDecimal, TypoShort, TypoLocalDateTime]("id", "businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate")(EphViewRow.apply)(BusinessentityId.decoder, BusinessentityId.decoder, TypoLocalDateTime.decoder, Decoder.decodeBigDecimal, TypoShort.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[EphViewRow] = Encoder.forProduct6[EphViewRow, BusinessentityId, BusinessentityId, TypoLocalDateTime, BigDecimal, TypoShort, TypoLocalDateTime]("id", "businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate")(x => (x.id, x.businessentityid, x.ratechangedate, x.rate, x.payfrequency, x.modifieddate))(BusinessentityId.encoder, BusinessentityId.encoder, TypoLocalDateTime.encoder, Encoder.encodeBigDecimal, TypoShort.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[EphViewRow] = {
    new Read[EphViewRow](
      gets = List(
        (BusinessentityId.get, Nullability.NoNulls),
        (BusinessentityId.get, Nullability.NoNulls),
        (TypoLocalDateTime.get, Nullability.NoNulls),
        (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
        (TypoShort.get, Nullability.NoNulls),
        (TypoLocalDateTime.get, Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => EphViewRow(
        id = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
        businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 1),
        ratechangedate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2),
        rate = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 3),
        payfrequency = TypoShort.get.unsafeGetNonNullable(rs, i + 4),
        modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
      )
    )
  
  }
}