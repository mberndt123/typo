/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.vstateprovincecountryregion;

import adventureworks.person.countryregion.CountryregionId;
import adventureworks.person.stateprovince.StateprovinceId;
import adventureworks.public_.Flag;
import adventureworks.public_.Name;
import adventureworks.sales.salesterritory.SalesterritoryId;

/** Materialized View: person.vstateprovincecountryregion */
public record VstateprovincecountryregionMVRow(
  /** Points to {@link adventureworks.person.stateprovince.StateprovinceRow.stateprovinceid} */
  StateprovinceId stateprovinceid,
  /** Points to {@link adventureworks.person.stateprovince.StateprovinceRow.stateprovincecode} */
  /* bpchar, max 3 chars */ String stateprovincecode,
  /** Points to {@link adventureworks.person.stateprovince.StateprovinceRow.isonlystateprovinceflag} */
  Flag isonlystateprovinceflag,
  /** Points to {@link adventureworks.person.stateprovince.StateprovinceRow.name} */
  Name stateprovincename,
  /** Points to {@link adventureworks.person.stateprovince.StateprovinceRow.territoryid} */
  SalesterritoryId territoryid,
  /** Points to {@link adventureworks.person.countryregion.CountryregionRow.countryregioncode} */
  CountryregionId countryregioncode,
  /** Points to {@link adventureworks.person.countryregion.CountryregionRow.name} */
  Name countryregionname
) {
  
}