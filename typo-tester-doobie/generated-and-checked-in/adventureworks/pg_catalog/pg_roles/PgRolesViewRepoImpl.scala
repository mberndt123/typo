/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_roles

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object PgRolesViewRepoImpl extends PgRolesViewRepo {
  override def select: SelectBuilder[PgRolesViewFields, PgRolesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_roles", PgRolesViewFields, PgRolesViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgRolesViewRow] = {
    sql"""select "rolname", "rolsuper", "rolinherit", "rolcreaterole", "rolcreatedb", "rolcanlogin", "rolreplication", "rolconnlimit", "rolpassword", "rolvaliduntil"::text, "rolbypassrls", "rolconfig", "oid" from pg_catalog.pg_roles""".query(PgRolesViewRow.read).stream
  }
}
