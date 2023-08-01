/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package constraint_column_usage

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.OptField

trait ConstraintColumnUsageViewFields[Row] {
  val tableCatalog: OptField[SqlIdentifier, Row]
  val tableSchema: OptField[SqlIdentifier, Row]
  val tableName: OptField[SqlIdentifier, Row]
  val columnName: OptField[SqlIdentifier, Row]
  val constraintCatalog: OptField[SqlIdentifier, Row]
  val constraintSchema: OptField[SqlIdentifier, Row]
  val constraintName: OptField[SqlIdentifier, Row]
}
object ConstraintColumnUsageViewFields extends ConstraintColumnUsageViewStructure[ConstraintColumnUsageViewRow](None, identity, (_, x) => x)

