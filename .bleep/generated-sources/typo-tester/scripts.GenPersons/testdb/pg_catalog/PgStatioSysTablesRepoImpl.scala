package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatioSysTablesRepoImpl extends PgStatioSysTablesRepo {
  override def selectAll(implicit c: Connection): List[PgStatioSysTablesRow] = {
    SQL"""select relid, schemaname, relname, heap_blks_read, heap_blks_hit, idx_blks_read, idx_blks_hit, toast_blks_read, toast_blks_hit, tidx_blks_read, tidx_blks_hit from pg_catalog.pg_statio_sys_tables""".as(PgStatioSysTablesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatioSysTablesFieldValue[_]])(implicit c: Connection): List[PgStatioSysTablesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatioSysTablesFieldValue.relid(value) => NamedParameter("relid", ParameterValue.from(value))
          case PgStatioSysTablesFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgStatioSysTablesFieldValue.relname(value) => NamedParameter("relname", ParameterValue.from(value))
          case PgStatioSysTablesFieldValue.heapBlksRead(value) => NamedParameter("heap_blks_read", ParameterValue.from(value))
          case PgStatioSysTablesFieldValue.heapBlksHit(value) => NamedParameter("heap_blks_hit", ParameterValue.from(value))
          case PgStatioSysTablesFieldValue.idxBlksRead(value) => NamedParameter("idx_blks_read", ParameterValue.from(value))
          case PgStatioSysTablesFieldValue.idxBlksHit(value) => NamedParameter("idx_blks_hit", ParameterValue.from(value))
          case PgStatioSysTablesFieldValue.toastBlksRead(value) => NamedParameter("toast_blks_read", ParameterValue.from(value))
          case PgStatioSysTablesFieldValue.toastBlksHit(value) => NamedParameter("toast_blks_hit", ParameterValue.from(value))
          case PgStatioSysTablesFieldValue.tidxBlksRead(value) => NamedParameter("tidx_blks_read", ParameterValue.from(value))
          case PgStatioSysTablesFieldValue.tidxBlksHit(value) => NamedParameter("tidx_blks_hit", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_statio_sys_tables where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatioSysTablesRow.rowParser.*)
    }

  }
}
