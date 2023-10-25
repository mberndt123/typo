/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import adventureworks.streamingInsert
import anorm.NamedParameter
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

object CustomerRepoImpl extends CustomerRepo {
  override def delete(customerid: CustomerId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.customer where "customerid" = ${ParameterValue(customerid, null, CustomerId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[CustomerFields, CustomerRow] = {
    DeleteBuilder("sales.customer", CustomerFields)
  }
  override def insert(unsaved: CustomerRow)(implicit c: Connection): CustomerRow = {
    SQL"""insert into sales.customer("customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.customerid, null, CustomerId.toStatement)}::int4, ${ParameterValue(unsaved.personid, null, ToStatement.optionToStatement(BusinessentityId.toStatement, BusinessentityId.parameterMetadata))}::int4, ${ParameterValue(unsaved.storeid, null, ToStatement.optionToStatement(BusinessentityId.toStatement, BusinessentityId.parameterMetadata))}::int4, ${ParameterValue(unsaved.territoryid, null, ToStatement.optionToStatement(SalesterritoryId.toStatement, SalesterritoryId.parameterMetadata))}::int4, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text
       """
      .executeInsert(CustomerRow.rowParser(1).single)
    
  }
  override def insertStreaming(unsaved: Iterator[CustomerRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.customer("customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(CustomerRow.text, c)
  }
  override def insert(unsaved: CustomerRowUnsaved)(implicit c: Connection): CustomerRow = {
    val namedParameters = List(
      Some((NamedParameter("personid", ParameterValue(unsaved.personid, null, ToStatement.optionToStatement(BusinessentityId.toStatement, BusinessentityId.parameterMetadata))), "::int4")),
      Some((NamedParameter("storeid", ParameterValue(unsaved.storeid, null, ToStatement.optionToStatement(BusinessentityId.toStatement, BusinessentityId.parameterMetadata))), "::int4")),
      Some((NamedParameter("territoryid", ParameterValue(unsaved.territoryid, null, ToStatement.optionToStatement(SalesterritoryId.toStatement, SalesterritoryId.parameterMetadata))), "::int4")),
      unsaved.customerid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("customerid", ParameterValue(value, null, CustomerId.toStatement)), "::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue(value, null, TypoUUID.toStatement)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.customer default values
            returning "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text
         """
        .executeInsert(CustomerRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.customer(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(CustomerRow.rowParser(1).single)
    }
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[CustomerRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.customer("personid", "storeid", "territoryid", "customerid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(CustomerRowUnsaved.text, c)
  }
  override def select: SelectBuilder[CustomerFields, CustomerRow] = {
    SelectBuilderSql("sales.customer", CustomerFields, CustomerRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[CustomerRow] = {
    SQL"""select "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text
          from sales.customer
       """.as(CustomerRow.rowParser(1).*)
  }
  override def selectById(customerid: CustomerId)(implicit c: Connection): Option[CustomerRow] = {
    SQL"""select "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text
          from sales.customer
          where "customerid" = ${ParameterValue(customerid, null, CustomerId.toStatement)}
       """.as(CustomerRow.rowParser(1).singleOpt)
  }
  override def selectByIds(customerids: Array[CustomerId])(implicit c: Connection): List[CustomerRow] = {
    SQL"""select "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text
          from sales.customer
          where "customerid" = ANY(${customerids})
       """.as(CustomerRow.rowParser(1).*)
    
  }
  override def update(row: CustomerRow)(implicit c: Connection): Boolean = {
    val customerid = row.customerid
    SQL"""update sales.customer
          set "personid" = ${ParameterValue(row.personid, null, ToStatement.optionToStatement(BusinessentityId.toStatement, BusinessentityId.parameterMetadata))}::int4,
              "storeid" = ${ParameterValue(row.storeid, null, ToStatement.optionToStatement(BusinessentityId.toStatement, BusinessentityId.parameterMetadata))}::int4,
              "territoryid" = ${ParameterValue(row.territoryid, null, ToStatement.optionToStatement(SalesterritoryId.toStatement, SalesterritoryId.parameterMetadata))}::int4,
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "customerid" = ${ParameterValue(customerid, null, CustomerId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[CustomerFields, CustomerRow] = {
    UpdateBuilder("sales.customer", CustomerFields, CustomerRow.rowParser)
  }
  override def upsert(unsaved: CustomerRow)(implicit c: Connection): CustomerRow = {
    SQL"""insert into sales.customer("customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.customerid, null, CustomerId.toStatement)}::int4,
            ${ParameterValue(unsaved.personid, null, ToStatement.optionToStatement(BusinessentityId.toStatement, BusinessentityId.parameterMetadata))}::int4,
            ${ParameterValue(unsaved.storeid, null, ToStatement.optionToStatement(BusinessentityId.toStatement, BusinessentityId.parameterMetadata))}::int4,
            ${ParameterValue(unsaved.territoryid, null, ToStatement.optionToStatement(SalesterritoryId.toStatement, SalesterritoryId.parameterMetadata))}::int4,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("customerid")
          do update set
            "personid" = EXCLUDED."personid",
            "storeid" = EXCLUDED."storeid",
            "territoryid" = EXCLUDED."territoryid",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text
       """
      .executeInsert(CustomerRow.rowParser(1).single)
    
  }
}
