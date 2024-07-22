/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.culture;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.public_.Name;

/** Table: production.culture
  * Lookup table containing the languages in which some AdventureWorks data is stored.
  * Primary key: cultureid
  */
public record CultureRow(
  /** Primary key for Culture records. */
  CultureId cultureid,
  /** Culture description. */
  Name name,
  /** Default: now() */
  TypoLocalDateTime modifieddate
) {
  public CultureId id() {
    return cultureid;
  };
  public CultureRowUnsaved toUnsavedRow(Defaulted<TypoLocalDateTime> modifieddate) {
    return new CultureRowUnsaved(cultureid, name, modifieddate);
  };
}