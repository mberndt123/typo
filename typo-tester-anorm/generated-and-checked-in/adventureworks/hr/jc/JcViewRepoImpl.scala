/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package jc

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object JcViewRepoImpl extends JcViewRepo {
  override def select: SelectBuilder[JcViewFields, JcViewRow] = {
    SelectBuilderSql("hr.jc", JcViewFields, JcViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[JcViewRow] = {
    SQL"""select "id", "jobcandidateid", "businessentityid", "resume", "modifieddate"::text
          from hr.jc
       """.as(JcViewRow.rowParser(1).*)
  }
}
