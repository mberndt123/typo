/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.update_person_returning;

import adventureworks.customtypes.TypoLocalDateTime;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait UpdatePersonReturningSqlRepo {
  def apply(suffix: /* nullability unknown */ Option[String], cutoff: /* nullability unknown */ Option[TypoLocalDateTime]): ZStream[ZConnection, Throwable, UpdatePersonReturningSqlRow]
}