/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication_tables

import typo.dsl.SqlExpr.OptField

trait PgPublicationTablesViewFields[Row] {
  val pubname: OptField[String, Row]
  val schemaname: OptField[String, Row]
  val tablename: OptField[String, Row]
}
object PgPublicationTablesViewFields extends PgPublicationTablesViewStructure[PgPublicationTablesViewRow](None, identity, (_, x) => x)

