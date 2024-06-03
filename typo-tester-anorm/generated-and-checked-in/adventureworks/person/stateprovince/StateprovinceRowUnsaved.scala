/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `person.stateprovince` which has not been persisted yet */
case class StateprovinceRowUnsaved(
  /** ISO standard state or province code. */
  stateprovincecode: /* bpchar, max 3 chars */ String,
  /** ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** State or province description. */
  name: Name,
  /** ID of the territory in which the state or province is located. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[sales.salesterritory.SalesterritoryRow.territoryid]] */
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
      stateprovincecode = stateprovincecode,
      countryregioncode = countryregioncode,
      name = name,
      territoryid = territoryid,
      stateprovinceid = stateprovinceid match {
                          case Defaulted.UseDefault => stateprovinceidDefault
                          case Defaulted.Provided(value) => value
                        },
      isonlystateprovinceflag = isonlystateprovinceflag match {
                                  case Defaulted.UseDefault => isonlystateprovinceflagDefault
                                  case Defaulted.Provided(value) => value
                                },
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
  implicit lazy val reads: Reads[StateprovinceRowUnsaved] = Reads[StateprovinceRowUnsaved](json => JsResult.fromTry(
      Try(
        StateprovinceRowUnsaved(
          stateprovincecode = json.\("stateprovincecode").as(Reads.StringReads),
          countryregioncode = json.\("countryregioncode").as(CountryregionId.reads),
          name = json.\("name").as(Name.reads),
          territoryid = json.\("territoryid").as(SalesterritoryId.reads),
          stateprovinceid = json.\("stateprovinceid").as(Defaulted.reads(StateprovinceId.reads)),
          isonlystateprovinceflag = json.\("isonlystateprovinceflag").as(Defaulted.reads(Flag.reads)),
          rowguid = json.\("rowguid").as(Defaulted.reads(TypoUUID.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
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
  implicit lazy val writes: OWrites[StateprovinceRowUnsaved] = OWrites[StateprovinceRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "stateprovincecode" -> Writes.StringWrites.writes(o.stateprovincecode),
      "countryregioncode" -> CountryregionId.writes.writes(o.countryregioncode),
      "name" -> Name.writes.writes(o.name),
      "territoryid" -> SalesterritoryId.writes.writes(o.territoryid),
      "stateprovinceid" -> Defaulted.writes(StateprovinceId.writes).writes(o.stateprovinceid),
      "isonlystateprovinceflag" -> Defaulted.writes(Flag.writes).writes(o.isonlystateprovinceflag),
      "rowguid" -> Defaulted.writes(TypoUUID.writes).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
