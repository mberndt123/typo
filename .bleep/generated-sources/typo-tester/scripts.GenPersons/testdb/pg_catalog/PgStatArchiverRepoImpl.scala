package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatArchiverRepoImpl extends PgStatArchiverRepo {
  override def selectAll(implicit c: Connection): List[PgStatArchiverRow] = {
    SQL"""select archived_count, last_archived_wal, last_archived_time, failed_count, last_failed_wal, last_failed_time, stats_reset from pg_catalog.pg_stat_archiver""".as(PgStatArchiverRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatArchiverFieldValue[_]])(implicit c: Connection): List[PgStatArchiverRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatArchiverFieldValue.archivedCount(value) => NamedParameter("archived_count", ParameterValue.from(value))
          case PgStatArchiverFieldValue.lastArchivedWal(value) => NamedParameter("last_archived_wal", ParameterValue.from(value))
          case PgStatArchiverFieldValue.lastArchivedTime(value) => NamedParameter("last_archived_time", ParameterValue.from(value))
          case PgStatArchiverFieldValue.failedCount(value) => NamedParameter("failed_count", ParameterValue.from(value))
          case PgStatArchiverFieldValue.lastFailedWal(value) => NamedParameter("last_failed_wal", ParameterValue.from(value))
          case PgStatArchiverFieldValue.lastFailedTime(value) => NamedParameter("last_failed_time", ParameterValue.from(value))
          case PgStatArchiverFieldValue.statsReset(value) => NamedParameter("stats_reset", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_stat_archiver where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatArchiverRow.rowParser.*)
    }

  }
}
