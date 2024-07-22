/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.personphone;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.person.phonenumbertype.PhonenumbertypeId;
import adventureworks.public.Phone;
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

class PersonphoneRepoImpl extends PersonphoneRepo {
  def delete: DeleteBuilder[PersonphoneFields, PersonphoneRow] = DeleteBuilder("person.personphone", PersonphoneFields.structure)
  def deleteById(compositeId: PersonphoneId): ZIO[ZConnection, Throwable, Boolean] = sql"""delete from person.personphone where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "phonenumber" = ${Segment.paramSegment(compositeId.phonenumber)(Phone.setter)} AND "phonenumbertypeid" = ${Segment.paramSegment(compositeId.phonenumbertypeid)(PhonenumbertypeId.setter)}""".delete.map(_ > 0)
  def deleteByIds(compositeIds: Array[PersonphoneId]): ZIO[ZConnection, Throwable, Long] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val phonenumber = compositeIds.map(_.phonenumber)
    val phonenumbertypeid = compositeIds.map(_.phonenumbertypeid)
    sql"""delete
          from person.personphone
          where ("businessentityid", "phonenumber", "phonenumbertypeid")
          in (select unnest(${Segment.paramSegment(businessentityid)(BusinessentityId.arraySetter)}), unnest(${Segment.paramSegment(phonenumber)(Phone.arraySetter)}), unnest(${Segment.paramSegment(phonenumbertypeid)(PhonenumbertypeId.arraySetter)}))
       """.delete
  
  }
  def insert(unsaved: PersonphoneRow): ZIO[ZConnection, Throwable, PersonphoneRow] = {
    sql"""insert into person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.phonenumber)(Phone.setter)}::varchar, ${Segment.paramSegment(unsaved.phonenumbertypeid)(PhonenumbertypeId.setter)}::int4, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
       """.insertReturning(using PersonphoneRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  def insert(unsaved: PersonphoneRowUnsaved): ZIO[ZConnection, Throwable, PersonphoneRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
                      Some((sql""""phonenumber"""", sql"${Segment.paramSegment(unsaved.phonenumber)(Phone.setter)}::varchar")),
                      Some((sql""""phonenumbertypeid"""", sql"${Segment.paramSegment(unsaved.phonenumbertypeid)(PhonenumbertypeId.setter)}::int4")),
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
    }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.personphone default values
                            returning "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
                         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into person.personphone($names) values ($values) returning "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text"""
    }
    q.insertReturning(using PersonphoneRow.jdbcDecoder).map(_.updatedKeys.head)
  
  }
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PersonphoneRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate") FROM STDIN""", batchSize, unsaved)(PersonphoneRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PersonphoneRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(PersonphoneRowUnsaved.text)
  def select: SelectBuilder[PersonphoneFields, PersonphoneRow] = SelectBuilderSql("person.personphone", PersonphoneFields.structure, PersonphoneRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, PersonphoneRow] = sql"""select "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text from person.personphone""".query(using PersonphoneRow.jdbcDecoder).selectStream()
  def selectById(compositeId: PersonphoneId): ZIO[ZConnection, Throwable, Option[PersonphoneRow]] = sql"""select "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text from person.personphone where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "phonenumber" = ${Segment.paramSegment(compositeId.phonenumber)(Phone.setter)} AND "phonenumbertypeid" = ${Segment.paramSegment(compositeId.phonenumbertypeid)(PhonenumbertypeId.setter)}""".query(using PersonphoneRow.jdbcDecoder).selectOne
  def selectByIds(compositeIds: Array[PersonphoneId]): ZStream[ZConnection, Throwable, PersonphoneRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val phonenumber = compositeIds.map(_.phonenumber)
    val phonenumbertypeid = compositeIds.map(_.phonenumbertypeid)
    sql"""select "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
          from person.personphone
          where ("businessentityid", "phonenumber", "phonenumbertypeid")
          in (select unnest(${Segment.paramSegment(businessentityid)(BusinessentityId.arraySetter)}), unnest(${Segment.paramSegment(phonenumber)(Phone.arraySetter)}), unnest(${Segment.paramSegment(phonenumbertypeid)(PhonenumbertypeId.arraySetter)}))
       """.query(using PersonphoneRow.jdbcDecoder).selectStream()
  
  }
  def selectByIdsTracked(compositeIds: Array[PersonphoneId]): ZIO[ZConnection, Throwable, Map[PersonphoneId, PersonphoneRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[PersonphoneFields, PersonphoneRow] = UpdateBuilder("person.personphone", PersonphoneFields.structure, PersonphoneRow.jdbcDecoder)
  def update(row: PersonphoneRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update person.personphone
          set "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "phonenumber" = ${Segment.paramSegment(compositeId.phonenumber)(Phone.setter)} AND "phonenumbertypeid" = ${Segment.paramSegment(compositeId.phonenumbertypeid)(PhonenumbertypeId.setter)}""".update.map(_ > 0)
  }
  def upsert(unsaved: PersonphoneRow): ZIO[ZConnection, Throwable, UpdateResult[PersonphoneRow]] = {
    sql"""insert into person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.phonenumber)(Phone.setter)}::varchar,
            ${Segment.paramSegment(unsaved.phonenumbertypeid)(PhonenumbertypeId.setter)}::int4,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid", "phonenumber", "phonenumbertypeid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text""".insertReturning(using PersonphoneRow.jdbcDecoder)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, PersonphoneRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table personphone_TEMP (like person.personphone) on commit drop".execute
    val copied = streamingInsert(s"""copy personphone_TEMP("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate") from stdin""", batchSize, unsaved)(PersonphoneRow.text)
    val merged = sql"""insert into person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")
                       select * from personphone_TEMP
                       on conflict ("businessentityid", "phonenumber", "phonenumbertypeid")
                       do update set
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table personphone_TEMP;""".update
    created *> copied *> merged
  }
}