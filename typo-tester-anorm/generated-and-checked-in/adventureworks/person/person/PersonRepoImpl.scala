/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.person

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import adventureworks.streamingInsert
import adventureworks.userdefined.FirstName
import anorm.BatchSql
import anorm.NamedParameter
import anorm.ParameterMetaData
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class PersonRepoImpl extends PersonRepo {
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilder("person.person", PersonFields.structure)
  }
  override def deleteById(businessentityid: BusinessentityId)(implicit c: Connection): Boolean = {
    SQL"""delete from person.person where "businessentityid" = ${ParameterValue(businessentityid, null, BusinessentityId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): Int = {
    SQL"""delete
          from person.person
          where "businessentityid" = ANY(${ParameterValue(businessentityids, null, BusinessentityId.arrayToStatement)})
       """.executeUpdate()
    
  }
  override def insert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    SQL"""insert into person.person("businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.persontype, null, ToStatement.stringToStatement)}::bpchar, ${ParameterValue(unsaved.namestyle, null, NameStyle.toStatement)}::bool, ${ParameterValue(unsaved.title, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.firstname, null, /* user-picked */ FirstName.toStatement)}::varchar, ${ParameterValue(unsaved.middlename, null, ToStatement.optionToStatement(Name.toStatement, Name.parameterMetadata))}::varchar, ${ParameterValue(unsaved.lastname, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.suffix, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.emailpromotion, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.additionalcontactinfo, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml, ${ParameterValue(unsaved.demographics, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
       """
      .executeInsert(PersonRow.rowParser(1).single)
    
  }
  override def insert(unsaved: PersonRowUnsaved)(implicit c: Connection): PersonRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("persontype", ParameterValue(unsaved.persontype, null, ToStatement.stringToStatement)), "::bpchar")),
      Some((NamedParameter("title", ParameterValue(unsaved.title, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "")),
      Some((NamedParameter("firstname", ParameterValue(unsaved.firstname, null, /* user-picked */ FirstName.toStatement)), "::varchar")),
      Some((NamedParameter("middlename", ParameterValue(unsaved.middlename, null, ToStatement.optionToStatement(Name.toStatement, Name.parameterMetadata))), "::varchar")),
      Some((NamedParameter("lastname", ParameterValue(unsaved.lastname, null, Name.toStatement)), "::varchar")),
      Some((NamedParameter("suffix", ParameterValue(unsaved.suffix, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "")),
      Some((NamedParameter("additionalcontactinfo", ParameterValue(unsaved.additionalcontactinfo, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))), "::xml")),
      Some((NamedParameter("demographics", ParameterValue(unsaved.demographics, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))), "::xml")),
      unsaved.namestyle match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("namestyle", ParameterValue(value, null, NameStyle.toStatement)), "::bool"))
      },
      unsaved.emailpromotion match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("emailpromotion", ParameterValue(value, null, ToStatement.intToStatement)), "::int4"))
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
      SQL"""insert into person.person default values
            returning "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
         """
        .executeInsert(PersonRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.person(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(PersonRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[PersonRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY person.person("businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(PersonRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[PersonRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY person.person("businessentityid", "persontype", "title", "firstname", "middlename", "lastname", "suffix", "additionalcontactinfo", "demographics", "namestyle", "emailpromotion", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(PersonRowUnsaved.text, c)
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderSql("person.person", PersonFields.structure, PersonRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PersonRow] = {
    SQL"""select "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
          from person.person
       """.as(PersonRow.rowParser(1).*)
  }
  override def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[PersonRow] = {
    SQL"""select "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
          from person.person
          where "businessentityid" = ${ParameterValue(businessentityid, null, BusinessentityId.toStatement)}
       """.as(PersonRow.rowParser(1).singleOpt)
  }
  override def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[PersonRow] = {
    SQL"""select "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
          from person.person
          where "businessentityid" = ANY(${ParameterValue(businessentityids, null, BusinessentityId.arrayToStatement)})
       """.as(PersonRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(businessentityids: Array[BusinessentityId])(implicit c: Connection): Map[BusinessentityId, PersonRow] = {
    val byId = selectByIds(businessentityids).view.map(x => (x.businessentityid, x)).toMap
    businessentityids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilder("person.person", PersonFields.structure, PersonRow.rowParser)
  }
  override def update(row: PersonRow)(implicit c: Connection): Boolean = {
    val businessentityid = row.businessentityid
    SQL"""update person.person
          set "persontype" = ${ParameterValue(row.persontype, null, ToStatement.stringToStatement)}::bpchar,
              "namestyle" = ${ParameterValue(row.namestyle, null, NameStyle.toStatement)}::bool,
              "title" = ${ParameterValue(row.title, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
              "firstname" = ${ParameterValue(row.firstname, null, /* user-picked */ FirstName.toStatement)}::varchar,
              "middlename" = ${ParameterValue(row.middlename, null, ToStatement.optionToStatement(Name.toStatement, Name.parameterMetadata))}::varchar,
              "lastname" = ${ParameterValue(row.lastname, null, Name.toStatement)}::varchar,
              "suffix" = ${ParameterValue(row.suffix, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
              "emailpromotion" = ${ParameterValue(row.emailpromotion, null, ToStatement.intToStatement)}::int4,
              "additionalcontactinfo" = ${ParameterValue(row.additionalcontactinfo, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml,
              "demographics" = ${ParameterValue(row.demographics, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml,
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "businessentityid" = ${ParameterValue(businessentityid, null, BusinessentityId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    SQL"""insert into person.person("businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.persontype, null, ToStatement.stringToStatement)}::bpchar,
            ${ParameterValue(unsaved.namestyle, null, NameStyle.toStatement)}::bool,
            ${ParameterValue(unsaved.title, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.firstname, null, /* user-picked */ FirstName.toStatement)}::varchar,
            ${ParameterValue(unsaved.middlename, null, ToStatement.optionToStatement(Name.toStatement, Name.parameterMetadata))}::varchar,
            ${ParameterValue(unsaved.lastname, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.suffix, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.emailpromotion, null, ToStatement.intToStatement)}::int4,
            ${ParameterValue(unsaved.additionalcontactinfo, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml,
            ${ParameterValue(unsaved.demographics, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "persontype" = EXCLUDED."persontype",
            "namestyle" = EXCLUDED."namestyle",
            "title" = EXCLUDED."title",
            "firstname" = EXCLUDED."firstname",
            "middlename" = EXCLUDED."middlename",
            "lastname" = EXCLUDED."lastname",
            "suffix" = EXCLUDED."suffix",
            "emailpromotion" = EXCLUDED."emailpromotion",
            "additionalcontactinfo" = EXCLUDED."additionalcontactinfo",
            "demographics" = EXCLUDED."demographics",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
       """
      .executeInsert(PersonRow.rowParser(1).single)
    
  }
  override def upsertBatch(unsaved: Iterable[PersonRow])(implicit c: Connection): List[PersonRow] = {
    def toNamedParameter(row: PersonRow): List[NamedParameter] = List(
      NamedParameter("businessentityid", ParameterValue(row.businessentityid, null, BusinessentityId.toStatement)),
      NamedParameter("persontype", ParameterValue(row.persontype, null, ToStatement.stringToStatement)),
      NamedParameter("namestyle", ParameterValue(row.namestyle, null, NameStyle.toStatement)),
      NamedParameter("title", ParameterValue(row.title, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))),
      NamedParameter("firstname", ParameterValue(row.firstname, null, /* user-picked */ FirstName.toStatement)),
      NamedParameter("middlename", ParameterValue(row.middlename, null, ToStatement.optionToStatement(Name.toStatement, Name.parameterMetadata))),
      NamedParameter("lastname", ParameterValue(row.lastname, null, Name.toStatement)),
      NamedParameter("suffix", ParameterValue(row.suffix, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))),
      NamedParameter("emailpromotion", ParameterValue(row.emailpromotion, null, ToStatement.intToStatement)),
      NamedParameter("additionalcontactinfo", ParameterValue(row.additionalcontactinfo, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))),
      NamedParameter("demographics", ParameterValue(row.demographics, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))),
      NamedParameter("rowguid", ParameterValue(row.rowguid, null, TypoUUID.toStatement)),
      NamedParameter("modifieddate", ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into person.person("businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate")
                values ({businessentityid}::int4, {persontype}::bpchar, {namestyle}::bool, {title}, {firstname}::varchar, {middlename}::varchar, {lastname}::varchar, {suffix}, {emailpromotion}::int4, {additionalcontactinfo}::xml, {demographics}::xml, {rowguid}::uuid, {modifieddate}::timestamp)
                on conflict ("businessentityid")
                do update set
                  "persontype" = EXCLUDED."persontype",
                  "namestyle" = EXCLUDED."namestyle",
                  "title" = EXCLUDED."title",
                  "firstname" = EXCLUDED."firstname",
                  "middlename" = EXCLUDED."middlename",
                  "lastname" = EXCLUDED."lastname",
                  "suffix" = EXCLUDED."suffix",
                  "emailpromotion" = EXCLUDED."emailpromotion",
                  "additionalcontactinfo" = EXCLUDED."additionalcontactinfo",
                  "demographics" = EXCLUDED."demographics",
                  "rowguid" = EXCLUDED."rowguid",
                  "modifieddate" = EXCLUDED."modifieddate"
                returning "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(PersonRow.rowParser(1).*)
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[PersonRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"create temporary table person_TEMP (like person.person) on commit drop".execute(): @nowarn
    streamingInsert(s"""copy person_TEMP("businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(PersonRow.text, c): @nowarn
    SQL"""insert into person.person("businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate")
          select * from person_TEMP
          on conflict ("businessentityid")
          do update set
            "persontype" = EXCLUDED."persontype",
            "namestyle" = EXCLUDED."namestyle",
            "title" = EXCLUDED."title",
            "firstname" = EXCLUDED."firstname",
            "middlename" = EXCLUDED."middlename",
            "lastname" = EXCLUDED."lastname",
            "suffix" = EXCLUDED."suffix",
            "emailpromotion" = EXCLUDED."emailpromotion",
            "additionalcontactinfo" = EXCLUDED."additionalcontactinfo",
            "demographics" = EXCLUDED."demographics",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          ;
          drop table person_TEMP;""".executeUpdate()
  }
}
