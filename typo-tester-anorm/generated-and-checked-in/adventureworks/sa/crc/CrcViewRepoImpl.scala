/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.crc

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class CrcViewRepoImpl extends CrcViewRepo {
  override def select: SelectBuilder[CrcViewFields, CrcViewRow] = {
    SelectBuilderSql("sa.crc", CrcViewFields.structure, CrcViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[CrcViewRow] = {
    SQL"""select "countryregioncode", "currencycode", "modifieddate"::text
          from sa.crc
       """.as(CrcViewRow.rowParser(1).*)
  }
}
