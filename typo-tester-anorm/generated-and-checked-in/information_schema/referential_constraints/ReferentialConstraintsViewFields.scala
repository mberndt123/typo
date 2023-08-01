/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package referential_constraints

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.OptField

trait ReferentialConstraintsViewFields[Row] {
  val constraintCatalog: OptField[SqlIdentifier, Row]
  val constraintSchema: OptField[SqlIdentifier, Row]
  val constraintName: OptField[SqlIdentifier, Row]
  val uniqueConstraintCatalog: OptField[SqlIdentifier, Row]
  val uniqueConstraintSchema: OptField[SqlIdentifier, Row]
  val uniqueConstraintName: OptField[SqlIdentifier, Row]
  val matchOption: OptField[CharacterData, Row]
  val updateRule: OptField[CharacterData, Row]
  val deleteRule: OptField[CharacterData, Row]
}
object ReferentialConstraintsViewFields extends ReferentialConstraintsViewStructure[ReferentialConstraintsViewRow](None, identity, (_, x) => x)

