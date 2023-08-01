/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package eph

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object EphViewRepoImpl extends EphViewRepo {
  override def select: SelectBuilder[EphViewFields, EphViewRow] = {
    SelectBuilderSql("hr.eph", EphViewFields, EphViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[EphViewRow] = {
    SQL"""select "id", businessentityid, ratechangedate::text, rate, payfrequency, modifieddate::text
          from hr.eph
       """.as(EphViewRow.rowParser(1).*)
  }
}
