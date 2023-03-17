package testdb.information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait RoutineSequenceUsageRepoImpl extends RoutineSequenceUsageRepo {
  override def selectAll(implicit c: Connection): List[RoutineSequenceUsageRow] = {
    SQL"""select specific_catalog, specific_schema, specific_name, routine_catalog, routine_schema, routine_name, sequence_catalog, sequence_schema, sequence_name from information_schema.routine_sequence_usage""".as(RoutineSequenceUsageRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[RoutineSequenceUsageFieldValue[_]])(implicit c: Connection): List[RoutineSequenceUsageRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case RoutineSequenceUsageFieldValue.specificCatalog(value) => NamedParameter("specific_catalog", ParameterValue.from(value))
          case RoutineSequenceUsageFieldValue.specificSchema(value) => NamedParameter("specific_schema", ParameterValue.from(value))
          case RoutineSequenceUsageFieldValue.specificName(value) => NamedParameter("specific_name", ParameterValue.from(value))
          case RoutineSequenceUsageFieldValue.routineCatalog(value) => NamedParameter("routine_catalog", ParameterValue.from(value))
          case RoutineSequenceUsageFieldValue.routineSchema(value) => NamedParameter("routine_schema", ParameterValue.from(value))
          case RoutineSequenceUsageFieldValue.routineName(value) => NamedParameter("routine_name", ParameterValue.from(value))
          case RoutineSequenceUsageFieldValue.sequenceCatalog(value) => NamedParameter("sequence_catalog", ParameterValue.from(value))
          case RoutineSequenceUsageFieldValue.sequenceSchema(value) => NamedParameter("sequence_schema", ParameterValue.from(value))
          case RoutineSequenceUsageFieldValue.sequenceName(value) => NamedParameter("sequence_name", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.routine_sequence_usage where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(RoutineSequenceUsageRow.rowParser.*)
    }

  }
}
