/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package check_constraint_routine_usage

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.OptField

trait CheckConstraintRoutineUsageViewFields[Row] {
  val constraintCatalog: OptField[SqlIdentifier, Row]
  val constraintSchema: OptField[SqlIdentifier, Row]
  val constraintName: OptField[SqlIdentifier, Row]
  val specificCatalog: OptField[SqlIdentifier, Row]
  val specificSchema: OptField[SqlIdentifier, Row]
  val specificName: OptField[SqlIdentifier, Row]
}
object CheckConstraintRoutineUsageViewFields extends CheckConstraintRoutineUsageViewStructure[CheckConstraintRoutineUsageViewRow](None, identity, (_, x) => x)

