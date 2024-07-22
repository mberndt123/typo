/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.cr;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.sales.currency.CurrencyId;
import adventureworks.sales.currencyrate.CurrencyrateId;
import java.math.BigDecimal;

/** View: sa.cr */
public record CrViewRow(
  /** Points to {@link adventureworks.sales.currencyrate.CurrencyrateRow.currencyrateid} */
  CurrencyrateId currencyrateid,
  /** Points to {@link adventureworks.sales.currencyrate.CurrencyrateRow.currencyratedate} */
  TypoLocalDateTime currencyratedate,
  /** Points to {@link adventureworks.sales.currencyrate.CurrencyrateRow.fromcurrencycode} */
  CurrencyId fromcurrencycode,
  /** Points to {@link adventureworks.sales.currencyrate.CurrencyrateRow.tocurrencycode} */
  CurrencyId tocurrencycode,
  /** Points to {@link adventureworks.sales.currencyrate.CurrencyrateRow.averagerate} */
  BigDecimal averagerate,
  /** Points to {@link adventureworks.sales.currencyrate.CurrencyrateRow.endofdayrate} */
  BigDecimal endofdayrate,
  /** Points to {@link adventureworks.sales.currencyrate.CurrencyrateRow.modifieddate} */
  TypoLocalDateTime modifieddate
) {
  
}