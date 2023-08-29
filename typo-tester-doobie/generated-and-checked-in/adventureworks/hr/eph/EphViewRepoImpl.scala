/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package eph

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object EphViewRepoImpl extends EphViewRepo {
  override def select: SelectBuilder[EphViewFields, EphViewRow] = {
    SelectBuilderSql("hr.eph", EphViewFields, EphViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, EphViewRow] = {
    sql"""select "id", "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text from hr.eph""".query(EphViewRow.read).stream
  }
}
