/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.stateprovince;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.person.countryregion.CountryregionId;
import adventureworks.public_.Flag;
import adventureworks.public_.Name;
import adventureworks.sales.salesterritory.SalesterritoryId;

/** This class corresponds to a row in table `person.stateprovince` which has not been persisted yet */
public record StateprovinceRowUnsaved(
  /** ISO standard state or province code. */
  /* bpchar, max 3 chars */ String stateprovincecode,
  /** ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode.
    * Points to {@link adventureworks.person.countryregion.CountryregionRow.countryregioncode}
    */
  CountryregionId countryregioncode,
  /** State or province description. */
  Name name,
  /** ID of the territory in which the state or province is located. Foreign key to SalesTerritory.SalesTerritoryID.
    * Points to {@link adventureworks.sales.salesterritory.SalesterritoryRow.territoryid}
    */
  SalesterritoryId territoryid,
  /** Default: nextval('person.stateprovince_stateprovinceid_seq'::regclass)
    * Primary key for StateProvince records.
    */
  Defaulted<StateprovinceId> stateprovinceid,
  /** Default: true
    * 0 = StateProvinceCode exists. 1 = StateProvinceCode unavailable, using CountryRegionCode.
    */
  Defaulted<Flag> isonlystateprovinceflag,
  /** Default: uuid_generate_v1() */
  Defaulted<TypoUUID> rowguid,
  /** Default: now() */
  Defaulted<TypoLocalDateTime> modifieddate
) {
  public StateprovinceRow toRow(
                                 java.util.function.Supplier<StateprovinceId> stateprovinceidDefault,
                                 java.util.function.Supplier<Flag> isonlystateprovinceflagDefault,
                                 java.util.function.Supplier<TypoUUID> rowguidDefault,
                                 java.util.function.Supplier<TypoLocalDateTime> modifieddateDefault
                               ) {
    return new StateprovinceRow(stateprovinceid.getOrElse(stateprovinceidDefault), stateprovincecode, countryregioncode, isonlystateprovinceflag.getOrElse(isonlystateprovinceflagDefault), name, territoryid, rowguid.getOrElse(rowguidDefault), modifieddate.getOrElse(modifieddateDefault));
  };
}