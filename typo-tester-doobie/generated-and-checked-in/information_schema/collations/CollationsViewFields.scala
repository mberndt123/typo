/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package collations

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.OptField

trait CollationsViewFields[Row] {
  val collationCatalog: OptField[SqlIdentifier, Row]
  val collationSchema: OptField[SqlIdentifier, Row]
  val collationName: OptField[SqlIdentifier, Row]
  val padAttribute: OptField[CharacterData, Row]
}
object CollationsViewFields extends CollationsViewStructure[CollationsViewRow](None, identity, (_, x) => x)

