/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package data_type_privileges

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object DataTypePrivilegesViewRepoImpl extends DataTypePrivilegesViewRepo {
  override def select: SelectBuilder[DataTypePrivilegesViewFields, DataTypePrivilegesViewRow] = {
    SelectBuilderSql("information_schema.data_type_privileges", DataTypePrivilegesViewFields, DataTypePrivilegesViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, DataTypePrivilegesViewRow] = {
    sql"""select "object_catalog", "object_schema", "object_name", "object_type", "dtd_identifier" from information_schema.data_type_privileges""".query(DataTypePrivilegesViewRow.read).stream
  }
}
