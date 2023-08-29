/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentityaddress

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.address.AddressId
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.person.businessentity.BusinessentityId
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

object BusinessentityaddressRepoImpl extends BusinessentityaddressRepo {
  override def delete(compositeId: BusinessentityaddressId)(implicit c: Connection): Boolean = {
    SQL"""delete from person.businessentityaddress where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "addressid" = ${ParameterValue(compositeId.addressid, null, AddressId.toStatement)} AND "addresstypeid" = ${ParameterValue(compositeId.addresstypeid, null, AddresstypeId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    DeleteBuilder("person.businessentityaddress", BusinessentityaddressFields)
  }
  override def insert(unsaved: BusinessentityaddressRow)(implicit c: Connection): BusinessentityaddressRow = {
    SQL"""insert into person.businessentityaddress("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.addressid, null, AddressId.toStatement)}::int4, ${ParameterValue(unsaved.addresstypeid, null, AddresstypeId.toStatement)}::int4, ${ParameterValue(unsaved.rowguid, null, ToStatement.uuidToStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
       """
      .executeInsert(BusinessentityaddressRow.rowParser(1).single)
    
  }
  override def insert(unsaved: BusinessentityaddressRowUnsaved)(implicit c: Connection): BusinessentityaddressRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("addressid", ParameterValue(unsaved.addressid, null, AddressId.toStatement)), "::int4")),
      Some((NamedParameter("addresstypeid", ParameterValue(unsaved.addresstypeid, null, AddresstypeId.toStatement)), "::int4")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue(value, null, ToStatement.uuidToStatement)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into person.businessentityaddress default values
            returning "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
         """
        .executeInsert(BusinessentityaddressRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.businessentityaddress(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(BusinessentityaddressRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    SelectBuilderSql("person.businessentityaddress", BusinessentityaddressFields, BusinessentityaddressRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[BusinessentityaddressRow] = {
    SQL"""select "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
          from person.businessentityaddress
       """.as(BusinessentityaddressRow.rowParser(1).*)
  }
  override def selectById(compositeId: BusinessentityaddressId)(implicit c: Connection): Option[BusinessentityaddressRow] = {
    SQL"""select "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
          from person.businessentityaddress
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "addressid" = ${ParameterValue(compositeId.addressid, null, AddressId.toStatement)} AND "addresstypeid" = ${ParameterValue(compositeId.addresstypeid, null, AddresstypeId.toStatement)}
       """.as(BusinessentityaddressRow.rowParser(1).singleOpt)
  }
  override def update(row: BusinessentityaddressRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update person.businessentityaddress
          set "rowguid" = ${ParameterValue(row.rowguid, null, ToStatement.uuidToStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "addressid" = ${ParameterValue(compositeId.addressid, null, AddressId.toStatement)} AND "addresstypeid" = ${ParameterValue(compositeId.addresstypeid, null, AddresstypeId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    UpdateBuilder("person.businessentityaddress", BusinessentityaddressFields, BusinessentityaddressRow.rowParser)
  }
  override def upsert(unsaved: BusinessentityaddressRow)(implicit c: Connection): BusinessentityaddressRow = {
    SQL"""insert into person.businessentityaddress("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.addressid, null, AddressId.toStatement)}::int4,
            ${ParameterValue(unsaved.addresstypeid, null, AddresstypeId.toStatement)}::int4,
            ${ParameterValue(unsaved.rowguid, null, ToStatement.uuidToStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("businessentityid", "addressid", "addresstypeid")
          do update set
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
       """
      .executeInsert(BusinessentityaddressRow.rowParser(1).single)
    
  }
}
