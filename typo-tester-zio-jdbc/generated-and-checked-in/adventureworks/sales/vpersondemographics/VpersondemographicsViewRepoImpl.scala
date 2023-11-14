/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vpersondemographics

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class VpersondemographicsViewRepoImpl extends VpersondemographicsViewRepo {
  override def select: SelectBuilder[VpersondemographicsViewFields, VpersondemographicsViewRow] = {
    SelectBuilderSql("sales.vpersondemographics", VpersondemographicsViewFields, VpersondemographicsViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, VpersondemographicsViewRow] = {
    sql"""select "businessentityid", "totalpurchaseytd"::numeric, "datefirstpurchase"::text, "birthdate"::text, "maritalstatus", "yearlyincome", "gender", "totalchildren", "numberchildrenathome", "education", "occupation", "homeownerflag", "numbercarsowned" from sales.vpersondemographics""".query(VpersondemographicsViewRow.jdbcDecoder).selectStream
  }
}
