/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithcontacts

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class VstorewithcontactsViewRepoImpl extends VstorewithcontactsViewRepo {
  override def select: SelectBuilder[VstorewithcontactsViewFields, VstorewithcontactsViewRow] = {
    SelectBuilderSql("sales.vstorewithcontacts", VstorewithcontactsViewFields, VstorewithcontactsViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, VstorewithcontactsViewRow] = {
    sql"""select "businessentityid", "name", "contacttype", "title", "firstname", "middlename", "lastname", "suffix", "phonenumber", "phonenumbertype", "emailaddress", "emailpromotion" from sales.vstorewithcontacts""".query(VstorewithcontactsViewRow.jdbcDecoder).selectStream
  }
}
