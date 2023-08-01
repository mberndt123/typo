/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package check_constraint_routine_usage

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class CheckConstraintRoutineUsageViewStructure[Row](val prefix: Option[String], val extract: Row => CheckConstraintRoutineUsageViewRow, val merge: (Row, CheckConstraintRoutineUsageViewRow) => Row)
  extends Relation[CheckConstraintRoutineUsageViewFields, CheckConstraintRoutineUsageViewRow, Row]
    with CheckConstraintRoutineUsageViewFields[Row] { outer =>

  override val constraintCatalog = new OptField[SqlIdentifier, Row](prefix, "constraint_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).constraintCatalog, (row, value) => merge(row, extract(row).copy(constraintCatalog = value)))
  override val constraintSchema = new OptField[SqlIdentifier, Row](prefix, "constraint_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).constraintSchema, (row, value) => merge(row, extract(row).copy(constraintSchema = value)))
  override val constraintName = new OptField[SqlIdentifier, Row](prefix, "constraint_name", None, Some("information_schema.sql_identifier"))(x => extract(x).constraintName, (row, value) => merge(row, extract(row).copy(constraintName = value)))
  override val specificCatalog = new OptField[SqlIdentifier, Row](prefix, "specific_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).specificCatalog, (row, value) => merge(row, extract(row).copy(specificCatalog = value)))
  override val specificSchema = new OptField[SqlIdentifier, Row](prefix, "specific_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).specificSchema, (row, value) => merge(row, extract(row).copy(specificSchema = value)))
  override val specificName = new OptField[SqlIdentifier, Row](prefix, "specific_name", None, Some("information_schema.sql_identifier"))(x => extract(x).specificName, (row, value) => merge(row, extract(row).copy(specificName = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](constraintCatalog, constraintSchema, constraintName, specificCatalog, specificSchema, specificName)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => CheckConstraintRoutineUsageViewRow, merge: (NewRow, CheckConstraintRoutineUsageViewRow) => NewRow): CheckConstraintRoutineUsageViewStructure[NewRow] =
    new CheckConstraintRoutineUsageViewStructure(prefix, extract, merge)
}
