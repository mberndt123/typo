package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait TableConstraintsRepoImpl extends TableConstraintsRepo {
  override def selectAll(implicit c: Connection): List[TableConstraintsRow] = {
    SQL"""select constraint_catalog, constraint_schema, constraint_name, table_catalog, table_schema, table_name, constraint_type, is_deferrable, initially_deferred, enforced from information_schema.table_constraints""".as(TableConstraintsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[TableConstraintsFieldValue[_]])(implicit c: Connection): List[TableConstraintsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case TableConstraintsFieldValue.constraintCatalog(value) => NamedParameter("constraint_catalog", ParameterValue.from(value))
          case TableConstraintsFieldValue.constraintSchema(value) => NamedParameter("constraint_schema", ParameterValue.from(value))
          case TableConstraintsFieldValue.constraintName(value) => NamedParameter("constraint_name", ParameterValue.from(value))
          case TableConstraintsFieldValue.tableCatalog(value) => NamedParameter("table_catalog", ParameterValue.from(value))
          case TableConstraintsFieldValue.tableSchema(value) => NamedParameter("table_schema", ParameterValue.from(value))
          case TableConstraintsFieldValue.tableName(value) => NamedParameter("table_name", ParameterValue.from(value))
          case TableConstraintsFieldValue.constraintType(value) => NamedParameter("constraint_type", ParameterValue.from(value))
          case TableConstraintsFieldValue.isDeferrable(value) => NamedParameter("is_deferrable", ParameterValue.from(value))
          case TableConstraintsFieldValue.initiallyDeferred(value) => NamedParameter("initially_deferred", ParameterValue.from(value))
          case TableConstraintsFieldValue.enforced(value) => NamedParameter("enforced", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.table_constraints where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(TableConstraintsRow.rowParser.*)
    }

  }
}
