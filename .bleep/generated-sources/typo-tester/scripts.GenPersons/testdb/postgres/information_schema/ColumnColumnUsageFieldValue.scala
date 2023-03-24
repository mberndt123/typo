/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema



sealed abstract class ColumnColumnUsageFieldValue[T](val name: String, val value: T)

object ColumnColumnUsageFieldValue {
  case class tableCatalog(override val value: Option[String]) extends ColumnColumnUsageFieldValue("table_catalog", value)
  case class tableSchema(override val value: Option[String]) extends ColumnColumnUsageFieldValue("table_schema", value)
  case class tableName(override val value: Option[String]) extends ColumnColumnUsageFieldValue("table_name", value)
  case class columnName(override val value: Option[String]) extends ColumnColumnUsageFieldValue("column_name", value)
  case class dependentColumn(override val value: Option[String]) extends ColumnColumnUsageFieldValue("dependent_column", value)
}
