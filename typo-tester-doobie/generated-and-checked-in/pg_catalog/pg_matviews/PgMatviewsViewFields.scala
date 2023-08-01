/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_matviews

import typo.dsl.SqlExpr.OptField

trait PgMatviewsViewFields[Row] {
  val schemaname: OptField[String, Row]
  val matviewname: OptField[String, Row]
  val matviewowner: OptField[String, Row]
  val tablespace: OptField[String, Row]
  val hasindexes: OptField[Boolean, Row]
  val ispopulated: OptField[Boolean, Row]
  val definition: OptField[String, Row]
}
object PgMatviewsViewFields extends PgMatviewsViewStructure[PgMatviewsViewRow](None, identity, (_, x) => x)

