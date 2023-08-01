/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package sequences

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.OptField

trait SequencesViewFields[Row] {
  val sequenceCatalog: OptField[SqlIdentifier, Row]
  val sequenceSchema: OptField[SqlIdentifier, Row]
  val sequenceName: OptField[SqlIdentifier, Row]
  val dataType: OptField[CharacterData, Row]
  val numericPrecision: OptField[CardinalNumber, Row]
  val numericPrecisionRadix: OptField[CardinalNumber, Row]
  val numericScale: OptField[CardinalNumber, Row]
  val startValue: OptField[CharacterData, Row]
  val minimumValue: OptField[CharacterData, Row]
  val maximumValue: OptField[CharacterData, Row]
  val increment: OptField[CharacterData, Row]
  val cycleOption: OptField[YesOrNo, Row]
}
object SequencesViewFields extends SequencesViewStructure[SequencesViewRow](None, identity, (_, x) => x)

