/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.addresstype

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import adventureworks.streamingInsert
import anorm.BatchSql
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import java.sql.Connection
import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class AddresstypeRepoImpl extends AddresstypeRepo {
  override def delete: DeleteBuilder[AddresstypeFields, AddresstypeRow] = {
    DeleteBuilder("person.addresstype", AddresstypeFields.structure)
  }
  override def deleteById(addresstypeid: AddresstypeId)(implicit c: Connection): Boolean = {
    SQL"""delete from person.addresstype where "addresstypeid" = ${ParameterValue(addresstypeid, null, AddresstypeId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(addresstypeids: Array[AddresstypeId])(implicit c: Connection): Int = {
    SQL"""delete
          from person.addresstype
          where "addresstypeid" = ANY(${ParameterValue(addresstypeids, null, AddresstypeId.arrayToStatement)})
       """.executeUpdate()
    
  }
  override def insert(unsaved: AddresstypeRow)(implicit c: Connection): AddresstypeRow = {
    SQL"""insert into person.addresstype("addresstypeid", "name", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.addresstypeid, null, AddresstypeId.toStatement)}::int4, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "addresstypeid", "name", "rowguid", "modifieddate"::text
       """
      .executeInsert(AddresstypeRow.rowParser(1).single)
    
  }
  override def insert(unsaved: AddresstypeRowUnsaved)(implicit c: Connection): AddresstypeRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      unsaved.addresstypeid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("addresstypeid", ParameterValue(value, null, AddresstypeId.toStatement)), "::int4"))
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
      SQL"""insert into person.addresstype default values
            returning "addresstypeid", "name", "rowguid", "modifieddate"::text
         """
        .executeInsert(AddresstypeRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.addresstype(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "addresstypeid", "name", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(AddresstypeRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[AddresstypeRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY person.addresstype("addresstypeid", "name", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(AddresstypeRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[AddresstypeRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY person.addresstype("name", "addresstypeid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(AddresstypeRowUnsaved.text, c)
  }
  override def select: SelectBuilder[AddresstypeFields, AddresstypeRow] = {
    SelectBuilderSql("person.addresstype", AddresstypeFields.structure, AddresstypeRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[AddresstypeRow] = {
    SQL"""select "addresstypeid", "name", "rowguid", "modifieddate"::text
          from person.addresstype
       """.as(AddresstypeRow.rowParser(1).*)
  }
  override def selectById(addresstypeid: AddresstypeId)(implicit c: Connection): Option[AddresstypeRow] = {
    SQL"""select "addresstypeid", "name", "rowguid", "modifieddate"::text
          from person.addresstype
          where "addresstypeid" = ${ParameterValue(addresstypeid, null, AddresstypeId.toStatement)}
       """.as(AddresstypeRow.rowParser(1).singleOpt)
  }
  override def selectByIds(addresstypeids: Array[AddresstypeId])(implicit c: Connection): List[AddresstypeRow] = {
    SQL"""select "addresstypeid", "name", "rowguid", "modifieddate"::text
          from person.addresstype
          where "addresstypeid" = ANY(${ParameterValue(addresstypeids, null, AddresstypeId.arrayToStatement)})
       """.as(AddresstypeRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(addresstypeids: Array[AddresstypeId])(implicit c: Connection): Map[AddresstypeId, AddresstypeRow] = {
    val byId = selectByIds(addresstypeids).view.map(x => (x.addresstypeid, x)).toMap
    addresstypeids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[AddresstypeFields, AddresstypeRow] = {
    UpdateBuilder("person.addresstype", AddresstypeFields.structure, AddresstypeRow.rowParser)
  }
  override def update(row: AddresstypeRow)(implicit c: Connection): Boolean = {
    val addresstypeid = row.addresstypeid
    SQL"""update person.addresstype
          set "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "addresstypeid" = ${ParameterValue(addresstypeid, null, AddresstypeId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: AddresstypeRow)(implicit c: Connection): AddresstypeRow = {
    SQL"""insert into person.addresstype("addresstypeid", "name", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.addresstypeid, null, AddresstypeId.toStatement)}::int4,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("addresstypeid")
          do update set
            "name" = EXCLUDED."name",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "addresstypeid", "name", "rowguid", "modifieddate"::text
       """
      .executeInsert(AddresstypeRow.rowParser(1).single)
    
  }
  override def upsertBatch(unsaved: Iterable[AddresstypeRow])(implicit c: Connection): List[AddresstypeRow] = {
    def toNamedParameter(row: AddresstypeRow): List[NamedParameter] = List(
      NamedParameter("addresstypeid", ParameterValue(row.addresstypeid, null, AddresstypeId.toStatement)),
      NamedParameter("name", ParameterValue(row.name, null, Name.toStatement)),
      NamedParameter("rowguid", ParameterValue(row.rowguid, null, TypoUUID.toStatement)),
      NamedParameter("modifieddate", ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into person.addresstype("addresstypeid", "name", "rowguid", "modifieddate")
                values ({addresstypeid}::int4, {name}::varchar, {rowguid}::uuid, {modifieddate}::timestamp)
                on conflict ("addresstypeid")
                do update set
                  "name" = EXCLUDED."name",
                  "rowguid" = EXCLUDED."rowguid",
                  "modifieddate" = EXCLUDED."modifieddate"
                returning "addresstypeid", "name", "rowguid", "modifieddate"::text
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(AddresstypeRow.rowParser(1).*)
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[AddresstypeRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"create temporary table addresstype_TEMP (like person.addresstype) on commit drop".execute(): @nowarn
    streamingInsert(s"""copy addresstype_TEMP("addresstypeid", "name", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(AddresstypeRow.text, c): @nowarn
    SQL"""insert into person.addresstype("addresstypeid", "name", "rowguid", "modifieddate")
          select * from addresstype_TEMP
          on conflict ("addresstypeid")
          do update set
            "name" = EXCLUDED."name",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          ;
          drop table addresstype_TEMP;""".executeUpdate()
  }
}
