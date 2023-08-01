/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_server

import adventureworks.TypoAclItem
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait PgForeignServerFields[Row] {
  val oid: IdField[PgForeignServerId, Row]
  val srvname: Field[String, Row]
  val srvowner: Field[/* oid */ Long, Row]
  val srvfdw: Field[/* oid */ Long, Row]
  val srvtype: OptField[String, Row]
  val srvversion: OptField[String, Row]
  val srvacl: OptField[Array[TypoAclItem], Row]
  val srvoptions: OptField[Array[String], Row]
}
object PgForeignServerFields extends PgForeignServerStructure[PgForeignServerRow](None, identity, (_, x) => x)

