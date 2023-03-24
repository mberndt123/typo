/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema



sealed abstract class ViewColumnUsageFieldValue[T](val name: String, val value: T)

object ViewColumnUsageFieldValue {
  case class viewCatalog(override val value: Option[String]) extends ViewColumnUsageFieldValue("view_catalog", value)
  case class viewSchema(override val value: Option[String]) extends ViewColumnUsageFieldValue("view_schema", value)
  case class viewName(override val value: Option[String]) extends ViewColumnUsageFieldValue("view_name", value)
  case class tableCatalog(override val value: Option[String]) extends ViewColumnUsageFieldValue("table_catalog", value)
  case class tableSchema(override val value: Option[String]) extends ViewColumnUsageFieldValue("table_schema", value)
  case class tableName(override val value: Option[String]) extends ViewColumnUsageFieldValue("table_name", value)
  case class columnName(override val value: Option[String]) extends ViewColumnUsageFieldValue("column_name", value)
}
