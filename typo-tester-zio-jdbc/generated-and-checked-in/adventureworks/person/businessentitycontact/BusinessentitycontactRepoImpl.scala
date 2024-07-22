/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.businessentitycontact;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.person.contacttype.ContacttypeId;
import adventureworks.streamingInsert;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import typo.dsl.UpdateBuilder;
import zio.ZIO;
import zio.jdbc.SqlFragment;
import zio.jdbc.SqlFragment.Segment;
import zio.jdbc.UpdateResult;
import zio.jdbc.ZConnection;
import zio.jdbc.sqlInterpolator;
import zio.stream.ZStream;

class BusinessentitycontactRepoImpl extends BusinessentitycontactRepo {
  def delete: DeleteBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = DeleteBuilder("person.businessentitycontact", BusinessentitycontactFields.structure)
  def deleteById(compositeId: BusinessentitycontactId): ZIO[ZConnection, Throwable, Boolean] = sql"""delete from person.businessentitycontact where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "personid" = ${Segment.paramSegment(compositeId.personid)(BusinessentityId.setter)} AND "contacttypeid" = ${Segment.paramSegment(compositeId.contacttypeid)(ContacttypeId.setter)}""".delete.map(_ > 0)
  def deleteByIds(compositeIds: Array[BusinessentitycontactId]): ZIO[ZConnection, Throwable, Long] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val personid = compositeIds.map(_.personid)
    val contacttypeid = compositeIds.map(_.contacttypeid)
    sql"""delete
          from person.businessentitycontact
          where ("businessentityid", "personid", "contacttypeid")
          in (select unnest(${Segment.paramSegment(businessentityid)(BusinessentityId.arraySetter)}), unnest(${Segment.paramSegment(personid)(BusinessentityId.arraySetter)}), unnest(${Segment.paramSegment(contacttypeid)(ContacttypeId.arraySetter)}))
       """.delete
  
  }
  def insert(unsaved: BusinessentitycontactRow): ZIO[ZConnection, Throwable, BusinessentitycontactRow] = {
    sql"""insert into person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.personid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.contacttypeid)(ContacttypeId.setter)}::int4, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
       """.insertReturning(using BusinessentitycontactRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  def insert(unsaved: BusinessentitycontactRowUnsaved): ZIO[ZConnection, Throwable, BusinessentitycontactRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
                      Some((sql""""personid"""", sql"${Segment.paramSegment(unsaved.personid)(BusinessentityId.setter)}::int4")),
                      Some((sql""""contacttypeid"""", sql"${Segment.paramSegment(unsaved.contacttypeid)(ContacttypeId.setter)}::int4")),
    unsaved.rowguid match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((sql""""rowguid"""", sql"${Segment.paramSegment(value: TypoUUID)(TypoUUID.setter)}::uuid"))
    },
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
    }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.businessentitycontact default values
                            returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
                         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into person.businessentitycontact($names) values ($values) returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using BusinessentitycontactRow.jdbcDecoder).map(_.updatedKeys.head)
  
  }
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentitycontactRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(BusinessentitycontactRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentitycontactRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(BusinessentitycontactRowUnsaved.text)
  def select: SelectBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = SelectBuilderSql("person.businessentitycontact", BusinessentitycontactFields.structure, BusinessentitycontactRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, BusinessentitycontactRow] = sql"""select "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text from person.businessentitycontact""".query(using BusinessentitycontactRow.jdbcDecoder).selectStream()
  def selectById(compositeId: BusinessentitycontactId): ZIO[ZConnection, Throwable, Option[BusinessentitycontactRow]] = sql"""select "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text from person.businessentitycontact where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "personid" = ${Segment.paramSegment(compositeId.personid)(BusinessentityId.setter)} AND "contacttypeid" = ${Segment.paramSegment(compositeId.contacttypeid)(ContacttypeId.setter)}""".query(using BusinessentitycontactRow.jdbcDecoder).selectOne
  def selectByIds(compositeIds: Array[BusinessentitycontactId]): ZStream[ZConnection, Throwable, BusinessentitycontactRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val personid = compositeIds.map(_.personid)
    val contacttypeid = compositeIds.map(_.contacttypeid)
    sql"""select "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
          from person.businessentitycontact
          where ("businessentityid", "personid", "contacttypeid")
          in (select unnest(${Segment.paramSegment(businessentityid)(BusinessentityId.arraySetter)}), unnest(${Segment.paramSegment(personid)(BusinessentityId.arraySetter)}), unnest(${Segment.paramSegment(contacttypeid)(ContacttypeId.arraySetter)}))
       """.query(using BusinessentitycontactRow.jdbcDecoder).selectStream()
  
  }
  def selectByIdsTracked(compositeIds: Array[BusinessentitycontactId]): ZIO[ZConnection, Throwable, Map[BusinessentitycontactId, BusinessentitycontactRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = UpdateBuilder("person.businessentitycontact", BusinessentitycontactFields.structure, BusinessentitycontactRow.jdbcDecoder)
  def update(row: BusinessentitycontactRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update person.businessentitycontact
          set "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "personid" = ${Segment.paramSegment(compositeId.personid)(BusinessentityId.setter)} AND "contacttypeid" = ${Segment.paramSegment(compositeId.contacttypeid)(ContacttypeId.setter)}""".update.map(_ > 0)
  }
  def upsert(unsaved: BusinessentitycontactRow): ZIO[ZConnection, Throwable, UpdateResult[BusinessentitycontactRow]] = {
    sql"""insert into person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.personid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.contacttypeid)(ContacttypeId.setter)}::int4,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid", "personid", "contacttypeid")
          do update set
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text""".insertReturning(using BusinessentitycontactRow.jdbcDecoder)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentitycontactRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table businessentitycontact_TEMP (like person.businessentitycontact) on commit drop".execute
    val copied = streamingInsert(s"""copy businessentitycontact_TEMP("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(BusinessentitycontactRow.text)
    val merged = sql"""insert into person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")
                       select * from businessentitycontact_TEMP
                       on conflict ("businessentityid", "personid", "contacttypeid")
                       do update set
                         "rowguid" = EXCLUDED."rowguid",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table businessentitycontact_TEMP;""".update
    created *> copied *> merged
  }
}