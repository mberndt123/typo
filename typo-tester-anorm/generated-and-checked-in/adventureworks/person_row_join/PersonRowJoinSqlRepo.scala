/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person_row_join

import java.sql.Connection

trait PersonRowJoinSqlRepo {
  def apply()(implicit c: Connection): List[PersonRowJoinSqlRow]
}
