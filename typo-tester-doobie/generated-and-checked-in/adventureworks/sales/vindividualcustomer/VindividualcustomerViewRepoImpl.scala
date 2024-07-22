/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.vindividualcustomer

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class VindividualcustomerViewRepoImpl extends VindividualcustomerViewRepo {
  override def select: SelectBuilder[VindividualcustomerViewFields, VindividualcustomerViewRow] = {
    SelectBuilderSql("sales.vindividualcustomer", VindividualcustomerViewFields.structure, VindividualcustomerViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, VindividualcustomerViewRow] = {
    sql"""select "businessentityid", "title", "firstname", "middlename", "lastname", "suffix", "phonenumber", "phonenumbertype", "emailaddress", "emailpromotion", "addresstype", "addressline1", "addressline2", "city", "stateprovincename", "postalcode", "countryregionname", "demographics" from sales.vindividualcustomer""".query(using VindividualcustomerViewRow.read).stream
  }
}
