package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgSettingsRepoImpl extends PgSettingsRepo {
  override def selectAll(implicit c: Connection): List[PgSettingsRow] = {
    SQL"""select name, setting, unit, category, short_desc, extra_desc, context, vartype, source, min_val, max_val, enumvals, boot_val, reset_val, sourcefile, sourceline, pending_restart from pg_catalog.pg_settings""".as(PgSettingsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgSettingsFieldValue[_]])(implicit c: Connection): List[PgSettingsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgSettingsFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PgSettingsFieldValue.setting(value) => NamedParameter("setting", ParameterValue.from(value))
          case PgSettingsFieldValue.unit(value) => NamedParameter("unit", ParameterValue.from(value))
          case PgSettingsFieldValue.category(value) => NamedParameter("category", ParameterValue.from(value))
          case PgSettingsFieldValue.shortDesc(value) => NamedParameter("short_desc", ParameterValue.from(value))
          case PgSettingsFieldValue.extraDesc(value) => NamedParameter("extra_desc", ParameterValue.from(value))
          case PgSettingsFieldValue.context(value) => NamedParameter("context", ParameterValue.from(value))
          case PgSettingsFieldValue.vartype(value) => NamedParameter("vartype", ParameterValue.from(value))
          case PgSettingsFieldValue.source(value) => NamedParameter("source", ParameterValue.from(value))
          case PgSettingsFieldValue.minVal(value) => NamedParameter("min_val", ParameterValue.from(value))
          case PgSettingsFieldValue.maxVal(value) => NamedParameter("max_val", ParameterValue.from(value))
          case PgSettingsFieldValue.enumvals(value) => NamedParameter("enumvals", ParameterValue.from(value))
          case PgSettingsFieldValue.bootVal(value) => NamedParameter("boot_val", ParameterValue.from(value))
          case PgSettingsFieldValue.resetVal(value) => NamedParameter("reset_val", ParameterValue.from(value))
          case PgSettingsFieldValue.sourcefile(value) => NamedParameter("sourcefile", ParameterValue.from(value))
          case PgSettingsFieldValue.sourceline(value) => NamedParameter("sourceline", ParameterValue.from(value))
          case PgSettingsFieldValue.pendingRestart(value) => NamedParameter("pending_restart", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_settings where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgSettingsRow.rowParser.*)
    }

  }
}
