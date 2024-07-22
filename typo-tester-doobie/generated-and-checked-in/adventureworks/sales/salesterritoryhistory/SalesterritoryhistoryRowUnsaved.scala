/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesterritoryhistory;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.sales.salesterritory.SalesterritoryId;
import doobie.postgres.Text;
import io.circe.Decoder;
import io.circe.Encoder;

/** This class corresponds to a row in table `sales.salesterritoryhistory` which has not been persisted yet */
case class SalesterritoryhistoryRowUnsaved(
  /** Primary key. The sales rep.  Foreign key to SalesPerson.BusinessEntityID.
    * Points to [[adventureworks.sales.salesperson.SalespersonRow.businessentityid]]
    */
  businessentityid: BusinessentityId,
  /** Primary key. Territory identification number. Foreign key to SalesTerritory.SalesTerritoryID.
    * Points to [[adventureworks.sales.salesterritory.SalesterritoryRow.territoryid]]
    */
  territoryid: SalesterritoryId,
  /** Primary key. Date the sales representive started work in the territory.
    * Constraint CK_SalesTerritoryHistory_EndDate affecting columns enddate, startdate:  (((enddate >= startdate) OR (enddate IS NULL)))
    */
  startdate: TypoLocalDateTime,
  /** Date the sales representative left work in the territory.
    * Constraint CK_SalesTerritoryHistory_EndDate affecting columns enddate, startdate:  (((enddate >= startdate) OR (enddate IS NULL)))
    */
  enddate: Option[TypoLocalDateTime],
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault(),
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault()
) {
  def toRow(rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): SalesterritoryhistoryRow = {
    new SalesterritoryhistoryRow(
      businessentityid = businessentityid,
      territoryid = territoryid,
      startdate = startdate,
      enddate = enddate,
      rowguid = rowguid.getOrElse(rowguidDefault),
      modifieddate = modifieddate.getOrElse(modifieddateDefault)
    )
  }
}

object SalesterritoryhistoryRowUnsaved {
  implicit lazy val decoder: Decoder[SalesterritoryhistoryRowUnsaved] = Decoder.forProduct6[SalesterritoryhistoryRowUnsaved, BusinessentityId, SalesterritoryId, TypoLocalDateTime, Option[TypoLocalDateTime], Defaulted[TypoUUID], Defaulted[TypoLocalDateTime]]("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate")(SalesterritoryhistoryRowUnsaved.apply)(BusinessentityId.decoder, SalesterritoryId.decoder, TypoLocalDateTime.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), Defaulted.decoder(TypoUUID.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[SalesterritoryhistoryRowUnsaved] = Encoder.forProduct6[SalesterritoryhistoryRowUnsaved, BusinessentityId, SalesterritoryId, TypoLocalDateTime, Option[TypoLocalDateTime], Defaulted[TypoUUID], Defaulted[TypoLocalDateTime]]("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate")(x => (x.businessentityid, x.territoryid, x.startdate, x.enddate, x.rowguid, x.modifieddate))(BusinessentityId.encoder, SalesterritoryId.encoder, TypoLocalDateTime.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), Defaulted.encoder(TypoUUID.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[SalesterritoryhistoryRowUnsaved] = {
    Text.instance[SalesterritoryhistoryRowUnsaved]{ (row, sb) =>
      BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
      sb.append(Text.DELIMETER)
      SalesterritoryId.text.unsafeEncode(row.territoryid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
      sb.append(Text.DELIMETER)
      Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
    }
  }
}