/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vvendorwithcontacts

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class VvendorwithcontactsViewRepoImpl extends VvendorwithcontactsViewRepo {
  override def select: SelectBuilder[VvendorwithcontactsViewFields, VvendorwithcontactsViewRow] = {
    SelectBuilderSql("purchasing.vvendorwithcontacts", VvendorwithcontactsViewFields, VvendorwithcontactsViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, VvendorwithcontactsViewRow] = {
    sql"""select "businessentityid", "name", "contacttype", "title", "firstname", "middlename", "lastname", "suffix", "phonenumber", "phonenumbertype", "emailaddress", "emailpromotion" from purchasing.vvendorwithcontacts""".query(VvendorwithcontactsViewRow.jdbcDecoder).selectStream
  }
}
