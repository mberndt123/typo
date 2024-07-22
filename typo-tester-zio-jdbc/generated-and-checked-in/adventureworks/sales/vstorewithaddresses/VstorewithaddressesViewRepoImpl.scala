/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.vstorewithaddresses;

import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import zio.jdbc.ZConnection;
import zio.jdbc.sqlInterpolator;
import zio.stream.ZStream;

class VstorewithaddressesViewRepoImpl extends VstorewithaddressesViewRepo {
  def select: SelectBuilder[VstorewithaddressesViewFields, VstorewithaddressesViewRow] = SelectBuilderSql("sales.vstorewithaddresses", VstorewithaddressesViewFields.structure, VstorewithaddressesViewRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, VstorewithaddressesViewRow] = sql"""select "businessentityid", "name", "addresstype", "addressline1", "addressline2", "city", "stateprovincename", "postalcode", "countryregionname" from sales.vstorewithaddresses""".query(using VstorewithaddressesViewRow.jdbcDecoder).selectStream()
}