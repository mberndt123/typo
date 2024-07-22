/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.stateprovince

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `person.stateprovince` which has not been persisted yet */
case class StateprovinceRowUnsaved(
  /** ISO standard state or province code. */
  stateprovincecode: /* bpchar, max 3 chars */ String,
  /** ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[adventureworks.person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** State or province description. */
  name: Name,
  /** ID of the territory in which the state or province is located. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[adventureworks.sales.salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Default: nextval('person.stateprovince_stateprovinceid_seq'::regclass)
      Primary key for StateProvince records. */
  stateprovinceid: Defaulted[StateprovinceId] = Defaulted.UseDefault,
  /** Default: true
      0 = StateProvinceCode exists. 1 = StateProvinceCode unavailable, using CountryRegionCode. */
  isonlystateprovinceflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(stateprovinceidDefault: => StateprovinceId, isonlystateprovinceflagDefault: => Flag, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): StateprovinceRow =
    StateprovinceRow(
      stateprovinceid = stateprovinceid match {
                          case Defaulted.UseDefault => stateprovinceidDefault
                          case Defaulted.Provided(value) => value
                        },
      stateprovincecode = stateprovincecode,
      countryregioncode = countryregioncode,
      isonlystateprovinceflag = isonlystateprovinceflag match {
                                  case Defaulted.UseDefault => isonlystateprovinceflagDefault
                                  case Defaulted.Provided(value) => value
                                },
      name = name,
      territoryid = territoryid,
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object StateprovinceRowUnsaved {
  implicit lazy val decoder: Decoder[StateprovinceRowUnsaved] = Decoder.forProduct8[StateprovinceRowUnsaved, /* bpchar, max 3 chars */ String, CountryregionId, Name, SalesterritoryId, Defaulted[StateprovinceId], Defaulted[Flag], Defaulted[TypoUUID], Defaulted[TypoLocalDateTime]]("stateprovincecode", "countryregioncode", "name", "territoryid", "stateprovinceid", "isonlystateprovinceflag", "rowguid", "modifieddate")(StateprovinceRowUnsaved.apply)(Decoder.decodeString, CountryregionId.decoder, Name.decoder, SalesterritoryId.decoder, Defaulted.decoder(StateprovinceId.decoder), Defaulted.decoder(Flag.decoder), Defaulted.decoder(TypoUUID.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[StateprovinceRowUnsaved] = Encoder.forProduct8[StateprovinceRowUnsaved, /* bpchar, max 3 chars */ String, CountryregionId, Name, SalesterritoryId, Defaulted[StateprovinceId], Defaulted[Flag], Defaulted[TypoUUID], Defaulted[TypoLocalDateTime]]("stateprovincecode", "countryregioncode", "name", "territoryid", "stateprovinceid", "isonlystateprovinceflag", "rowguid", "modifieddate")(x => (x.stateprovincecode, x.countryregioncode, x.name, x.territoryid, x.stateprovinceid, x.isonlystateprovinceflag, x.rowguid, x.modifieddate))(Encoder.encodeString, CountryregionId.encoder, Name.encoder, SalesterritoryId.encoder, Defaulted.encoder(StateprovinceId.encoder), Defaulted.encoder(Flag.encoder), Defaulted.encoder(TypoUUID.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[StateprovinceRowUnsaved] = Text.instance[StateprovinceRowUnsaved]{ (row, sb) =>
    Text.stringInstance.unsafeEncode(row.stateprovincecode, sb)
    sb.append(Text.DELIMETER)
    CountryregionId.text.unsafeEncode(row.countryregioncode, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    SalesterritoryId.text.unsafeEncode(row.territoryid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(StateprovinceId.text).unsafeEncode(row.stateprovinceid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Flag.text).unsafeEncode(row.isonlystateprovinceflag, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
