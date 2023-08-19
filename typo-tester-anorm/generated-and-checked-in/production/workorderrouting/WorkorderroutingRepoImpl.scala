/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import anorm.NamedParameter
import anorm.ParameterMetaData
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object WorkorderroutingRepoImpl extends WorkorderroutingRepo {
  override def delete(compositeId: WorkorderroutingId)(implicit c: Connection): Boolean = {
    SQL"delete from production.workorderrouting where workorderid = ${ParameterValue(compositeId.workorderid, null, WorkorderId.toStatement)} AND productid = ${ParameterValue(compositeId.productid, null, ToStatement.intToStatement)} AND operationsequence = ${ParameterValue(compositeId.operationsequence, null, ToStatement.intToStatement)}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    DeleteBuilder("production.workorderrouting", WorkorderroutingFields)
  }
  override def insert(unsaved: WorkorderroutingRow)(implicit c: Connection): WorkorderroutingRow = {
    SQL"""insert into production.workorderrouting(workorderid, productid, operationsequence, locationid, scheduledstartdate, scheduledenddate, actualstartdate, actualenddate, actualresourcehrs, plannedcost, actualcost, modifieddate)
          values (${ParameterValue(unsaved.workorderid, null, WorkorderId.toStatement)}::int4, ${ParameterValue(unsaved.productid, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.operationsequence, null, ToStatement.intToStatement)}::int2, ${ParameterValue(unsaved.locationid, null, LocationId.toStatement)}::int2, ${ParameterValue(unsaved.scheduledstartdate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.scheduledenddate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.actualstartdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp, ${ParameterValue(unsaved.actualenddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp, ${ParameterValue(unsaved.actualresourcehrs, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric, ${ParameterValue(unsaved.plannedcost, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.actualcost, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning workorderid, productid, operationsequence, locationid, scheduledstartdate::text, scheduledenddate::text, actualstartdate::text, actualenddate::text, actualresourcehrs, plannedcost, actualcost, modifieddate::text
       """
      .executeInsert(WorkorderroutingRow.rowParser(1).single)
    
  }
  override def insert(unsaved: WorkorderroutingRowUnsaved)(implicit c: Connection): WorkorderroutingRow = {
    val namedParameters = List(
      Some((NamedParameter("workorderid", ParameterValue(unsaved.workorderid, null, WorkorderId.toStatement)), "::int4")),
      Some((NamedParameter("productid", ParameterValue(unsaved.productid, null, ToStatement.intToStatement)), "::int4")),
      Some((NamedParameter("operationsequence", ParameterValue(unsaved.operationsequence, null, ToStatement.intToStatement)), "::int2")),
      Some((NamedParameter("locationid", ParameterValue(unsaved.locationid, null, LocationId.toStatement)), "::int2")),
      Some((NamedParameter("scheduledstartdate", ParameterValue(unsaved.scheduledstartdate, null, TypoLocalDateTime.toStatement)), "::timestamp")),
      Some((NamedParameter("scheduledenddate", ParameterValue(unsaved.scheduledenddate, null, TypoLocalDateTime.toStatement)), "::timestamp")),
      Some((NamedParameter("actualstartdate", ParameterValue(unsaved.actualstartdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))), "::timestamp")),
      Some((NamedParameter("actualenddate", ParameterValue(unsaved.actualenddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))), "::timestamp")),
      Some((NamedParameter("actualresourcehrs", ParameterValue(unsaved.actualresourcehrs, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))), "::numeric")),
      Some((NamedParameter("plannedcost", ParameterValue(unsaved.plannedcost, null, ToStatement.scalaBigDecimalToStatement)), "::numeric")),
      Some((NamedParameter("actualcost", ParameterValue(unsaved.actualcost, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))), "::numeric")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.workorderrouting default values
            returning workorderid, productid, operationsequence, locationid, scheduledstartdate::text, scheduledenddate::text, actualstartdate::text, actualenddate::text, actualresourcehrs, plannedcost, actualcost, modifieddate::text
         """
        .executeInsert(WorkorderroutingRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.workorderrouting(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning workorderid, productid, operationsequence, locationid, scheduledstartdate::text, scheduledenddate::text, actualstartdate::text, actualenddate::text, actualresourcehrs, plannedcost, actualcost, modifieddate::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(WorkorderroutingRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    SelectBuilderSql("production.workorderrouting", WorkorderroutingFields, WorkorderroutingRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[WorkorderroutingRow] = {
    SQL"""select workorderid, productid, operationsequence, locationid, scheduledstartdate::text, scheduledenddate::text, actualstartdate::text, actualenddate::text, actualresourcehrs, plannedcost, actualcost, modifieddate::text
          from production.workorderrouting
       """.as(WorkorderroutingRow.rowParser(1).*)
  }
  override def selectById(compositeId: WorkorderroutingId)(implicit c: Connection): Option[WorkorderroutingRow] = {
    SQL"""select workorderid, productid, operationsequence, locationid, scheduledstartdate::text, scheduledenddate::text, actualstartdate::text, actualenddate::text, actualresourcehrs, plannedcost, actualcost, modifieddate::text
          from production.workorderrouting
          where workorderid = ${ParameterValue(compositeId.workorderid, null, WorkorderId.toStatement)} AND productid = ${ParameterValue(compositeId.productid, null, ToStatement.intToStatement)} AND operationsequence = ${ParameterValue(compositeId.operationsequence, null, ToStatement.intToStatement)}
       """.as(WorkorderroutingRow.rowParser(1).singleOpt)
  }
  override def update(row: WorkorderroutingRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.workorderrouting
          set locationid = ${ParameterValue(row.locationid, null, LocationId.toStatement)}::int2,
              scheduledstartdate = ${ParameterValue(row.scheduledstartdate, null, TypoLocalDateTime.toStatement)}::timestamp,
              scheduledenddate = ${ParameterValue(row.scheduledenddate, null, TypoLocalDateTime.toStatement)}::timestamp,
              actualstartdate = ${ParameterValue(row.actualstartdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
              actualenddate = ${ParameterValue(row.actualenddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
              actualresourcehrs = ${ParameterValue(row.actualresourcehrs, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric,
              plannedcost = ${ParameterValue(row.plannedcost, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              actualcost = ${ParameterValue(row.actualcost, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric,
              modifieddate = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where workorderid = ${ParameterValue(compositeId.workorderid, null, WorkorderId.toStatement)} AND productid = ${ParameterValue(compositeId.productid, null, ToStatement.intToStatement)} AND operationsequence = ${ParameterValue(compositeId.operationsequence, null, ToStatement.intToStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    UpdateBuilder("production.workorderrouting", WorkorderroutingFields, WorkorderroutingRow.rowParser)
  }
  override def upsert(unsaved: WorkorderroutingRow)(implicit c: Connection): WorkorderroutingRow = {
    SQL"""insert into production.workorderrouting(workorderid, productid, operationsequence, locationid, scheduledstartdate, scheduledenddate, actualstartdate, actualenddate, actualresourcehrs, plannedcost, actualcost, modifieddate)
          values (
            ${ParameterValue(unsaved.workorderid, null, WorkorderId.toStatement)}::int4,
            ${ParameterValue(unsaved.productid, null, ToStatement.intToStatement)}::int4,
            ${ParameterValue(unsaved.operationsequence, null, ToStatement.intToStatement)}::int2,
            ${ParameterValue(unsaved.locationid, null, LocationId.toStatement)}::int2,
            ${ParameterValue(unsaved.scheduledstartdate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.scheduledenddate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.actualstartdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
            ${ParameterValue(unsaved.actualenddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
            ${ParameterValue(unsaved.actualresourcehrs, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric,
            ${ParameterValue(unsaved.plannedcost, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.actualcost, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict (workorderid, productid, operationsequence)
          do update set
            locationid = EXCLUDED.locationid,
            scheduledstartdate = EXCLUDED.scheduledstartdate,
            scheduledenddate = EXCLUDED.scheduledenddate,
            actualstartdate = EXCLUDED.actualstartdate,
            actualenddate = EXCLUDED.actualenddate,
            actualresourcehrs = EXCLUDED.actualresourcehrs,
            plannedcost = EXCLUDED.plannedcost,
            actualcost = EXCLUDED.actualcost,
            modifieddate = EXCLUDED.modifieddate
          returning workorderid, productid, operationsequence, locationid, scheduledstartdate::text, scheduledenddate::text, actualstartdate::text, actualenddate::text, actualresourcehrs, plannedcost, actualcost, modifieddate::text
       """
      .executeInsert(WorkorderroutingRow.rowParser(1).single)
    
  }
}
