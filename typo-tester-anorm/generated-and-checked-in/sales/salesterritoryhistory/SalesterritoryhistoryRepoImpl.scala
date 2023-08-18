/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritoryhistory

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object SalesterritoryhistoryRepoImpl extends SalesterritoryhistoryRepo {
  override def delete(compositeId: SalesterritoryhistoryId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.salesterritoryhistory where businessentityid = ${compositeId.businessentityid} AND startdate = ${compositeId.startdate} AND territoryid = ${compositeId.territoryid}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    DeleteBuilder("sales.salesterritoryhistory", SalesterritoryhistoryFields)
  }
  override def insert(unsaved: SalesterritoryhistoryRow)(implicit c: Connection): SalesterritoryhistoryRow = {
    SQL"""insert into sales.salesterritoryhistory(businessentityid, territoryid, startdate, enddate, rowguid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.territoryid}::int4, ${unsaved.startdate}::timestamp, ${unsaved.enddate}::timestamp, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, territoryid, startdate::text, enddate::text, rowguid, modifieddate::text
       """
      .executeInsert(SalesterritoryhistoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SalesterritoryhistoryRowUnsaved)(implicit c: Connection): SalesterritoryhistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("territoryid", ParameterValue.from(unsaved.territoryid)), "::int4")),
      Some((NamedParameter("startdate", ParameterValue.from(unsaved.startdate)), "::timestamp")),
      Some((NamedParameter("enddate", ParameterValue.from(unsaved.enddate)), "::timestamp")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.salesterritoryhistory default values
            returning businessentityid, territoryid, startdate::text, enddate::text, rowguid, modifieddate::text
         """
        .executeInsert(SalesterritoryhistoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.salesterritoryhistory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, territoryid, startdate::text, enddate::text, rowguid, modifieddate::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser(Success(_)))
        .executeInsert(SalesterritoryhistoryRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    SelectBuilderSql("sales.salesterritoryhistory", SalesterritoryhistoryFields, SalesterritoryhistoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SalesterritoryhistoryRow] = {
    SQL"""select businessentityid, territoryid, startdate::text, enddate::text, rowguid, modifieddate::text
          from sales.salesterritoryhistory
       """.as(SalesterritoryhistoryRow.rowParser(1).*)
  }
  override def selectById(compositeId: SalesterritoryhistoryId)(implicit c: Connection): Option[SalesterritoryhistoryRow] = {
    SQL"""select businessentityid, territoryid, startdate::text, enddate::text, rowguid, modifieddate::text
          from sales.salesterritoryhistory
          where businessentityid = ${compositeId.businessentityid} AND startdate = ${compositeId.startdate} AND territoryid = ${compositeId.territoryid}
       """.as(SalesterritoryhistoryRow.rowParser(1).singleOpt)
  }
  override def update(row: SalesterritoryhistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update sales.salesterritoryhistory
          set enddate = ${row.enddate}::timestamp,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND startdate = ${compositeId.startdate} AND territoryid = ${compositeId.territoryid}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    UpdateBuilder("sales.salesterritoryhistory", SalesterritoryhistoryFields, SalesterritoryhistoryRow.rowParser)
  }
  override def upsert(unsaved: SalesterritoryhistoryRow)(implicit c: Connection): SalesterritoryhistoryRow = {
    SQL"""insert into sales.salesterritoryhistory(businessentityid, territoryid, startdate, enddate, rowguid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.territoryid}::int4,
            ${unsaved.startdate}::timestamp,
            ${unsaved.enddate}::timestamp,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid, startdate, territoryid)
          do update set
            enddate = EXCLUDED.enddate,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, territoryid, startdate::text, enddate::text, rowguid, modifieddate::text
       """
      .executeInsert(SalesterritoryhistoryRow.rowParser(1).single)
    
  }
}
