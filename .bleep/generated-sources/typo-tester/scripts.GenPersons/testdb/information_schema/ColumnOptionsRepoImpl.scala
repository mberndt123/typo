package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait ColumnOptionsRepoImpl extends ColumnOptionsRepo {
  override def selectAll(implicit c: Connection): List[ColumnOptionsRow] = {
    SQL"""select table_catalog, table_schema, table_name, column_name, option_name, option_value from information_schema.column_options""".as(ColumnOptionsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ColumnOptionsFieldValue[_]])(implicit c: Connection): List[ColumnOptionsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ColumnOptionsFieldValue.tableCatalog(value) => NamedParameter("table_catalog", ParameterValue.from(value))
          case ColumnOptionsFieldValue.tableSchema(value) => NamedParameter("table_schema", ParameterValue.from(value))
          case ColumnOptionsFieldValue.tableName(value) => NamedParameter("table_name", ParameterValue.from(value))
          case ColumnOptionsFieldValue.columnName(value) => NamedParameter("column_name", ParameterValue.from(value))
          case ColumnOptionsFieldValue.optionName(value) => NamedParameter("option_name", ParameterValue.from(value))
          case ColumnOptionsFieldValue.optionValue(value) => NamedParameter("option_value", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.column_options where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(ColumnOptionsRow.rowParser.*)
    }

  }
}
