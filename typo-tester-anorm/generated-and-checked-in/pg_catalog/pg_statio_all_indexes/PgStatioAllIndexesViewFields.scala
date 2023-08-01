/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_all_indexes

import typo.dsl.SqlExpr.OptField

trait PgStatioAllIndexesViewFields[Row] {
  val relid: OptField[/* oid */ Long, Row]
  val indexrelid: OptField[/* oid */ Long, Row]
  val schemaname: OptField[String, Row]
  val relname: OptField[String, Row]
  val indexrelname: OptField[String, Row]
  val idxBlksRead: OptField[Long, Row]
  val idxBlksHit: OptField[Long, Row]
}
object PgStatioAllIndexesViewFields extends PgStatioAllIndexesViewStructure[PgStatioAllIndexesViewRow](None, identity, (_, x) => x)

