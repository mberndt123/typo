/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.crc;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.person.countryregion.CountryregionId;
import adventureworks.sales.currency.CurrencyId;

/** View: sa.crc */
public record CrcViewRow(
  /** Points to {@link adventureworks.sales.countryregioncurrency.CountryregioncurrencyRow.countryregioncode} */
  CountryregionId countryregioncode,
  /** Points to {@link adventureworks.sales.countryregioncurrency.CountryregioncurrencyRow.currencycode} */
  CurrencyId currencycode,
  /** Points to {@link adventureworks.sales.countryregioncurrency.CountryregioncurrencyRow.modifieddate} */
  TypoLocalDateTime modifieddate
) {
  
}