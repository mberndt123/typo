/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.unitmeasure;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.public_.Name;

/** This class corresponds to a row in table `production.unitmeasure` which has not been persisted yet */
public record UnitmeasureRowUnsaved(
  /** Primary key. */
  UnitmeasureId unitmeasurecode,
  /** Unit of measure description. */
  Name name,
  /** Default: now() */
  Defaulted<TypoLocalDateTime> modifieddate
) {
  public UnitmeasureRow toRow(java.util.function.Supplier<TypoLocalDateTime> modifieddateDefault) {
    return new UnitmeasureRow(unitmeasurecode, name, modifieddate.getOrElse(modifieddateDefault));
  };
}