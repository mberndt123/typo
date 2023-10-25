/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package person

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import adventureworks.streamingInsert
import adventureworks.userdefined.FirstName
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PersonRepoImpl extends PersonRepo {
  override def delete(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from person.person where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilder("person.person", PersonFields)
  }
  override def insert(unsaved: PersonRow): ZIO[ZConnection, Throwable, PersonRow] = {
    sql"""insert into person.person("businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.persontype)(Setter.stringSetter)}::bpchar, ${Segment.paramSegment(unsaved.namestyle)(NameStyle.setter)}::bool, ${Segment.paramSegment(unsaved.title)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.firstname)(/* user-picked */ FirstName.setter)}::varchar, ${Segment.paramSegment(unsaved.middlename)(Setter.optionParamSetter(Name.setter))}::varchar, ${Segment.paramSegment(unsaved.lastname)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.suffix)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.emailpromotion)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.additionalcontactinfo)(Setter.optionParamSetter(TypoXml.setter))}::xml, ${Segment.paramSegment(unsaved.demographics)(Setter.optionParamSetter(TypoXml.setter))}::xml, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
       """.insertReturning(PersonRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.person("businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(PersonRow.text)
  }
  override def insert(unsaved: PersonRowUnsaved): ZIO[ZConnection, Throwable, PersonRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""persontype"""", sql"${Segment.paramSegment(unsaved.persontype)(Setter.stringSetter)}::bpchar")),
      Some((sql""""title"""", sql"${Segment.paramSegment(unsaved.title)(Setter.optionParamSetter(Setter.stringSetter))}")),
      Some((sql""""firstname"""", sql"${Segment.paramSegment(unsaved.firstname)(/* user-picked */ FirstName.setter)}::varchar")),
      Some((sql""""middlename"""", sql"${Segment.paramSegment(unsaved.middlename)(Setter.optionParamSetter(Name.setter))}::varchar")),
      Some((sql""""lastname"""", sql"${Segment.paramSegment(unsaved.lastname)(Name.setter)}::varchar")),
      Some((sql""""suffix"""", sql"${Segment.paramSegment(unsaved.suffix)(Setter.optionParamSetter(Setter.stringSetter))}")),
      Some((sql""""additionalcontactinfo"""", sql"${Segment.paramSegment(unsaved.additionalcontactinfo)(Setter.optionParamSetter(TypoXml.setter))}::xml")),
      Some((sql""""demographics"""", sql"${Segment.paramSegment(unsaved.demographics)(Setter.optionParamSetter(TypoXml.setter))}::xml")),
      unsaved.namestyle match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""namestyle"""", sql"${Segment.paramSegment(value: NameStyle)(NameStyle.setter)}::bool"))
      },
      unsaved.emailpromotion match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""emailpromotion"""", sql"${Segment.paramSegment(value: Int)(Setter.intSetter)}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""rowguid"""", sql"${Segment.paramSegment(value: TypoUUID)(TypoUUID.setter)}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.person default values
            returning "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into person.person($names) values ($values) returning "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(PersonRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.person("businessentityid", "persontype", "title", "firstname", "middlename", "lastname", "suffix", "additionalcontactinfo", "demographics", "namestyle", "emailpromotion", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(PersonRowUnsaved.text)
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderSql("person.person", PersonFields, PersonRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PersonRow] = {
    sql"""select "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text from person.person""".query(PersonRow.jdbcDecoder).selectStream
  }
  override def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[PersonRow]] = {
    sql"""select "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text from person.person where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".query(PersonRow.jdbcDecoder).selectOne
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, PersonRow] = {
    sql"""select "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text from person.person where "businessentityid" = ANY(${Segment.paramSegment(businessentityids)(BusinessentityId.arraySetter)})""".query(PersonRow.jdbcDecoder).selectStream
  }
  override def update(row: PersonRow): ZIO[ZConnection, Throwable, Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update person.person
          set "persontype" = ${Segment.paramSegment(row.persontype)(Setter.stringSetter)}::bpchar,
              "namestyle" = ${Segment.paramSegment(row.namestyle)(NameStyle.setter)}::bool,
              "title" = ${Segment.paramSegment(row.title)(Setter.optionParamSetter(Setter.stringSetter))},
              "firstname" = ${Segment.paramSegment(row.firstname)(/* user-picked */ FirstName.setter)}::varchar,
              "middlename" = ${Segment.paramSegment(row.middlename)(Setter.optionParamSetter(Name.setter))}::varchar,
              "lastname" = ${Segment.paramSegment(row.lastname)(Name.setter)}::varchar,
              "suffix" = ${Segment.paramSegment(row.suffix)(Setter.optionParamSetter(Setter.stringSetter))},
              "emailpromotion" = ${Segment.paramSegment(row.emailpromotion)(Setter.intSetter)}::int4,
              "additionalcontactinfo" = ${Segment.paramSegment(row.additionalcontactinfo)(Setter.optionParamSetter(TypoXml.setter))}::xml,
              "demographics" = ${Segment.paramSegment(row.demographics)(Setter.optionParamSetter(TypoXml.setter))}::xml,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilder("person.person", PersonFields, PersonRow.jdbcDecoder)
  }
  override def upsert(unsaved: PersonRow): ZIO[ZConnection, Throwable, UpdateResult[PersonRow]] = {
    sql"""insert into person.person("businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.persontype)(Setter.stringSetter)}::bpchar,
            ${Segment.paramSegment(unsaved.namestyle)(NameStyle.setter)}::bool,
            ${Segment.paramSegment(unsaved.title)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.firstname)(/* user-picked */ FirstName.setter)}::varchar,
            ${Segment.paramSegment(unsaved.middlename)(Setter.optionParamSetter(Name.setter))}::varchar,
            ${Segment.paramSegment(unsaved.lastname)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.suffix)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.emailpromotion)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.additionalcontactinfo)(Setter.optionParamSetter(TypoXml.setter))}::xml,
            ${Segment.paramSegment(unsaved.demographics)(Setter.optionParamSetter(TypoXml.setter))}::xml,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
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
          returning "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text""".insertReturning(PersonRow.jdbcDecoder)
  }
}
