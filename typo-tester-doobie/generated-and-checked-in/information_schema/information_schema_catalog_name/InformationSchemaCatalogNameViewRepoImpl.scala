/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package information_schema_catalog_name

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object InformationSchemaCatalogNameViewRepoImpl extends InformationSchemaCatalogNameViewRepo {
  override def select: SelectBuilder[InformationSchemaCatalogNameViewFields, InformationSchemaCatalogNameViewRow] = {
    SelectBuilderSql("information_schema.information_schema_catalog_name", InformationSchemaCatalogNameViewFields, InformationSchemaCatalogNameViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, InformationSchemaCatalogNameViewRow] = {
    sql"""select "catalog_name" from information_schema.information_schema_catalog_name""".query(InformationSchemaCatalogNameViewRow.read).stream
  }
}
