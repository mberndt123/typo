/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.update_person

import adventureworks.customtypes.TypoLocalDateTime
import doobie.free.connection.ConnectionIO

trait UpdatePersonSqlRepo {
  def apply(suffix: String, cutoff: Option[TypoLocalDateTime]): ConnectionIO[Int]
}
