/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pe.cr;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.person.countryregion.CountryregionId;
import adventureworks.public_.Name;

/** View: pe.cr */
public record CrViewRow(
  /** Points to {@link adventureworks.person.countryregion.CountryregionRow.countryregioncode} */
  CountryregionId countryregioncode,
  /** Points to {@link adventureworks.person.countryregion.CountryregionRow.name} */
  Name name,
  /** Points to {@link adventureworks.person.countryregion.CountryregionRow.modifieddate} */
  TypoLocalDateTime modifieddate
) {
  
}