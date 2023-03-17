package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait TablesRepoImpl extends TablesRepo {
  override def selectAll(implicit c: Connection): List[TablesRow] = {
    SQL"""select table_catalog, table_schema, table_name, table_type, self_referencing_column_name, reference_generation, user_defined_type_catalog, user_defined_type_schema, user_defined_type_name, is_insertable_into, is_typed, commit_action from information_schema.tables""".as(TablesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[TablesFieldValue[_]])(implicit c: Connection): List[TablesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case TablesFieldValue.tableCatalog(value) => NamedParameter("table_catalog", ParameterValue.from(value))
          case TablesFieldValue.tableSchema(value) => NamedParameter("table_schema", ParameterValue.from(value))
          case TablesFieldValue.tableName(value) => NamedParameter("table_name", ParameterValue.from(value))
          case TablesFieldValue.tableType(value) => NamedParameter("table_type", ParameterValue.from(value))
          case TablesFieldValue.selfReferencingColumnName(value) => NamedParameter("self_referencing_column_name", ParameterValue.from(value))
          case TablesFieldValue.referenceGeneration(value) => NamedParameter("reference_generation", ParameterValue.from(value))
          case TablesFieldValue.userDefinedTypeCatalog(value) => NamedParameter("user_defined_type_catalog", ParameterValue.from(value))
          case TablesFieldValue.userDefinedTypeSchema(value) => NamedParameter("user_defined_type_schema", ParameterValue.from(value))
          case TablesFieldValue.userDefinedTypeName(value) => NamedParameter("user_defined_type_name", ParameterValue.from(value))
          case TablesFieldValue.isInsertableInto(value) => NamedParameter("is_insertable_into", ParameterValue.from(value))
          case TablesFieldValue.isTyped(value) => NamedParameter("is_typed", ParameterValue.from(value))
          case TablesFieldValue.commitAction(value) => NamedParameter("commit_action", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.tables where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(TablesRow.rowParser.*)
    }

  }
}
