/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vpersondemographics

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object VpersondemographicsViewRepoImpl extends VpersondemographicsViewRepo {
  override def select: SelectBuilder[VpersondemographicsViewFields, VpersondemographicsViewRow] = {
    SelectBuilderSql("sales.vpersondemographics", VpersondemographicsViewFields, VpersondemographicsViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, VpersondemographicsViewRow] = {
    sql"""select "businessentityid", "totalpurchaseytd"::numeric, "datefirstpurchase"::text, "birthdate"::text, "maritalstatus", "yearlyincome", "gender", "totalchildren", "numberchildrenathome", "education", "occupation", "homeownerflag", "numbercarsowned" from sales.vpersondemographics""".query(VpersondemographicsViewRow.read).stream
  }
}
