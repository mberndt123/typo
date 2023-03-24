/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema



sealed abstract class KeyColumnUsageFieldValue[T](val name: String, val value: T)

object KeyColumnUsageFieldValue {
  case class constraintCatalog(override val value: Option[String]) extends KeyColumnUsageFieldValue("constraint_catalog", value)
  case class constraintSchema(override val value: Option[String]) extends KeyColumnUsageFieldValue("constraint_schema", value)
  case class constraintName(override val value: Option[String]) extends KeyColumnUsageFieldValue("constraint_name", value)
  case class tableCatalog(override val value: Option[String]) extends KeyColumnUsageFieldValue("table_catalog", value)
  case class tableSchema(override val value: Option[String]) extends KeyColumnUsageFieldValue("table_schema", value)
  case class tableName(override val value: Option[String]) extends KeyColumnUsageFieldValue("table_name", value)
  case class columnName(override val value: Option[String]) extends KeyColumnUsageFieldValue("column_name", value)
  case class ordinalPosition(override val value: Option[Int]) extends KeyColumnUsageFieldValue("ordinal_position", value)
  case class positionInUniqueConstraint(override val value: Option[Int]) extends KeyColumnUsageFieldValue("position_in_unique_constraint", value)
}
