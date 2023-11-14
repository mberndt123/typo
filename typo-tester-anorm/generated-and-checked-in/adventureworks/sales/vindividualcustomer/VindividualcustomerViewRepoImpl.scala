/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vindividualcustomer

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class VindividualcustomerViewRepoImpl extends VindividualcustomerViewRepo {
  override def select: SelectBuilder[VindividualcustomerViewFields, VindividualcustomerViewRow] = {
    SelectBuilderSql("sales.vindividualcustomer", VindividualcustomerViewFields, VindividualcustomerViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[VindividualcustomerViewRow] = {
    SQL"""select "businessentityid", "title", "firstname", "middlename", "lastname", "suffix", "phonenumber", "phonenumbertype", "emailaddress", "emailpromotion", "addresstype", "addressline1", "addressline2", "city", "stateprovincename", "postalcode", "countryregionname", "demographics"
          from sales.vindividualcustomer
       """.as(VindividualcustomerViewRow.rowParser(1).*)
  }
}
