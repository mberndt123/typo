/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.customtypes;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/** This is `java.time.LocalTime`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */
public record TypoLocalTime(LocalTime value) {
  static public TypoLocalTime apply(LocalTime value) {
           return new TypoLocalTime(value.truncatedTo(ChronoUnit.MICROS));
         };
  static public TypoLocalTime apply(String str) {
           return apply(LocalTime.parse(str));
         };
  static public TypoLocalTime now() {
           return new TypoLocalTime(LocalTime.now());
         };
}