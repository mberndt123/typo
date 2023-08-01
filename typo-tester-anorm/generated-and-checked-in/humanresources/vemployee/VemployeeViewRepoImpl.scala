/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployee

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object VemployeeViewRepoImpl extends VemployeeViewRepo {
  override def select: SelectBuilder[VemployeeViewFields, VemployeeViewRow] = {
    SelectBuilderSql("humanresources.vemployee", VemployeeViewFields, VemployeeViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[VemployeeViewRow] = {
    SQL"""select businessentityid, title, firstname, middlename, lastname, suffix, jobtitle, phonenumber, phonenumbertype, emailaddress, emailpromotion, addressline1, addressline2, city, stateprovincename, postalcode, countryregionname, additionalcontactinfo
          from humanresources.vemployee
       """.as(VemployeeViewRow.rowParser(1).*)
  }
}
