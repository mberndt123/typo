/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vindividualcustomer

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class VindividualcustomerViewRepoImpl extends VindividualcustomerViewRepo {
  override def select: SelectBuilder[VindividualcustomerViewFields, VindividualcustomerViewRow] = {
    SelectBuilderSql("sales.vindividualcustomer", VindividualcustomerViewFields, VindividualcustomerViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, VindividualcustomerViewRow] = {
    sql"""select "businessentityid", "title", "firstname", "middlename", "lastname", "suffix", "phonenumber", "phonenumbertype", "emailaddress", "emailpromotion", "addresstype", "addressline1", "addressline2", "city", "stateprovincename", "postalcode", "countryregionname", "demographics" from sales.vindividualcustomer""".query(VindividualcustomerViewRow.jdbcDecoder).selectStream
  }
}
