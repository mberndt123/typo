/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.store;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.customtypes.TypoXml;
import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.public.Name;
import adventureworks.streamingInsert;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import typo.dsl.UpdateBuilder;
import zio.ZIO;
import zio.jdbc.SqlFragment;
import zio.jdbc.SqlFragment.Segment;
import zio.jdbc.SqlFragment.Setter;
import zio.jdbc.UpdateResult;
import zio.jdbc.ZConnection;
import zio.jdbc.sqlInterpolator;
import zio.stream.ZStream;

class StoreRepoImpl extends StoreRepo {
  def delete: DeleteBuilder[StoreFields, StoreRow] = DeleteBuilder("sales.store", StoreFields.structure)
  def deleteById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean] = sql"""delete from sales.store where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".delete.map(_ > 0)
  def deleteByIds(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Long] = sql"""delete from sales.store where "businessentityid" = ANY(${Segment.paramSegment(businessentityids)(BusinessentityId.arraySetter)})""".delete
  def insert(unsaved: StoreRow): ZIO[ZConnection, Throwable, StoreRow] = {
    sql"""insert into sales.store("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.salespersonid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4, ${Segment.paramSegment(unsaved.demographics)(Setter.optionParamSetter(TypoXml.setter))}::xml, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text
       """.insertReturning(using StoreRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  def insert(unsaved: StoreRowUnsaved): ZIO[ZConnection, Throwable, StoreRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
                      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
                      Some((sql""""salespersonid"""", sql"${Segment.paramSegment(unsaved.salespersonid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4")),
                      Some((sql""""demographics"""", sql"${Segment.paramSegment(unsaved.demographics)(Setter.optionParamSetter(TypoXml.setter))}::xml")),
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
      sql"""insert into sales.store default values
                            returning "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text
                         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into sales.store($names) values ($values) returning "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using StoreRow.jdbcDecoder).map(_.updatedKeys.head)
  
  }
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, StoreRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY sales.store("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(StoreRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, StoreRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY sales.store("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(StoreRowUnsaved.text)
  def select: SelectBuilder[StoreFields, StoreRow] = SelectBuilderSql("sales.store", StoreFields.structure, StoreRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, StoreRow] = sql"""select "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text from sales.store""".query(using StoreRow.jdbcDecoder).selectStream()
  def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[StoreRow]] = sql"""select "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text from sales.store where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".query(using StoreRow.jdbcDecoder).selectOne
  def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, StoreRow] = sql"""select "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text from sales.store where "businessentityid" = ANY(${Segment.paramSegment(businessentityids)(BusinessentityId.arraySetter)})""".query(using StoreRow.jdbcDecoder).selectStream()
  def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Map[BusinessentityId, StoreRow]] = {
    selectByIds(businessentityids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.businessentityid, x)).toMap
      businessentityids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[StoreFields, StoreRow] = UpdateBuilder("sales.store", StoreFields.structure, StoreRow.jdbcDecoder)
  def update(row: StoreRow): ZIO[ZConnection, Throwable, Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update sales.store
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "salespersonid" = ${Segment.paramSegment(row.salespersonid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
              "demographics" = ${Segment.paramSegment(row.demographics)(Setter.optionParamSetter(TypoXml.setter))}::xml,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".update.map(_ > 0)
  }
  def upsert(unsaved: StoreRow): ZIO[ZConnection, Throwable, UpdateResult[StoreRow]] = {
    sql"""insert into sales.store("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.salespersonid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
            ${Segment.paramSegment(unsaved.demographics)(Setter.optionParamSetter(TypoXml.setter))}::xml,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "name" = EXCLUDED."name",
            "salespersonid" = EXCLUDED."salespersonid",
            "demographics" = EXCLUDED."demographics",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text""".insertReturning(using StoreRow.jdbcDecoder)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, StoreRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table store_TEMP (like sales.store) on commit drop".execute
    val copied = streamingInsert(s"""copy store_TEMP("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(StoreRow.text)
    val merged = sql"""insert into sales.store("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate")
                       select * from store_TEMP
                       on conflict ("businessentityid")
                       do update set
                         "name" = EXCLUDED."name",
                         "salespersonid" = EXCLUDED."salespersonid",
                         "demographics" = EXCLUDED."demographics",
                         "rowguid" = EXCLUDED."rowguid",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table store_TEMP;""".update
    created *> copied *> merged
  }
}