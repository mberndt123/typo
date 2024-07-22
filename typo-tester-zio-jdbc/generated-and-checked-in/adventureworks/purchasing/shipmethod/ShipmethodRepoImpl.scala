/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.shipmethod;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
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

class ShipmethodRepoImpl extends ShipmethodRepo {
  def delete: DeleteBuilder[ShipmethodFields, ShipmethodRow] = DeleteBuilder("purchasing.shipmethod", ShipmethodFields.structure)
  def deleteById(shipmethodid: ShipmethodId): ZIO[ZConnection, Throwable, Boolean] = sql"""delete from purchasing.shipmethod where "shipmethodid" = ${Segment.paramSegment(shipmethodid)(ShipmethodId.setter)}""".delete.map(_ > 0)
  def deleteByIds(shipmethodids: Array[ShipmethodId]): ZIO[ZConnection, Throwable, Long] = sql"""delete from purchasing.shipmethod where "shipmethodid" = ANY(${Segment.paramSegment(shipmethodids)(ShipmethodId.arraySetter)})""".delete
  def insert(unsaved: ShipmethodRow): ZIO[ZConnection, Throwable, ShipmethodRow] = {
    sql"""insert into purchasing.shipmethod("shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.shipmethodid)(ShipmethodId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.shipbase)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.shiprate)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text
       """.insertReturning(using ShipmethodRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  def insert(unsaved: ShipmethodRowUnsaved): ZIO[ZConnection, Throwable, ShipmethodRow] = {
    val fs = List(
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
    unsaved.shipmethodid match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((sql""""shipmethodid"""", sql"${Segment.paramSegment(value: ShipmethodId)(ShipmethodId.setter)}::int4"))
    },
    unsaved.shipbase match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((sql""""shipbase"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
    },
    unsaved.shiprate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((sql""""shiprate"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
    },
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
      sql"""insert into purchasing.shipmethod default values
                            returning "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text
                         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into purchasing.shipmethod($names) values ($values) returning "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using ShipmethodRow.jdbcDecoder).map(_.updatedKeys.head)
  
  }
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ShipmethodRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY purchasing.shipmethod("shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(ShipmethodRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ShipmethodRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY purchasing.shipmethod("name", "shipmethodid", "shipbase", "shiprate", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ShipmethodRowUnsaved.text)
  def select: SelectBuilder[ShipmethodFields, ShipmethodRow] = SelectBuilderSql("purchasing.shipmethod", ShipmethodFields.structure, ShipmethodRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, ShipmethodRow] = sql"""select "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text from purchasing.shipmethod""".query(using ShipmethodRow.jdbcDecoder).selectStream()
  def selectById(shipmethodid: ShipmethodId): ZIO[ZConnection, Throwable, Option[ShipmethodRow]] = sql"""select "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text from purchasing.shipmethod where "shipmethodid" = ${Segment.paramSegment(shipmethodid)(ShipmethodId.setter)}""".query(using ShipmethodRow.jdbcDecoder).selectOne
  def selectByIds(shipmethodids: Array[ShipmethodId]): ZStream[ZConnection, Throwable, ShipmethodRow] = sql"""select "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text from purchasing.shipmethod where "shipmethodid" = ANY(${Segment.paramSegment(shipmethodids)(ShipmethodId.arraySetter)})""".query(using ShipmethodRow.jdbcDecoder).selectStream()
  def selectByIdsTracked(shipmethodids: Array[ShipmethodId]): ZIO[ZConnection, Throwable, Map[ShipmethodId, ShipmethodRow]] = {
    selectByIds(shipmethodids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.shipmethodid, x)).toMap
      shipmethodids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[ShipmethodFields, ShipmethodRow] = UpdateBuilder("purchasing.shipmethod", ShipmethodFields.structure, ShipmethodRow.jdbcDecoder)
  def update(row: ShipmethodRow): ZIO[ZConnection, Throwable, Boolean] = {
    val shipmethodid = row.shipmethodid
    sql"""update purchasing.shipmethod
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "shipbase" = ${Segment.paramSegment(row.shipbase)(Setter.bigDecimalScalaSetter)}::numeric,
              "shiprate" = ${Segment.paramSegment(row.shiprate)(Setter.bigDecimalScalaSetter)}::numeric,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "shipmethodid" = ${Segment.paramSegment(shipmethodid)(ShipmethodId.setter)}""".update.map(_ > 0)
  }
  def upsert(unsaved: ShipmethodRow): ZIO[ZConnection, Throwable, UpdateResult[ShipmethodRow]] = {
    sql"""insert into purchasing.shipmethod("shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.shipmethodid)(ShipmethodId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.shipbase)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.shiprate)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("shipmethodid")
          do update set
            "name" = EXCLUDED."name",
            "shipbase" = EXCLUDED."shipbase",
            "shiprate" = EXCLUDED."shiprate",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text""".insertReturning(using ShipmethodRow.jdbcDecoder)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, ShipmethodRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table shipmethod_TEMP (like purchasing.shipmethod) on commit drop".execute
    val copied = streamingInsert(s"""copy shipmethod_TEMP("shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(ShipmethodRow.text)
    val merged = sql"""insert into purchasing.shipmethod("shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate")
                       select * from shipmethod_TEMP
                       on conflict ("shipmethodid")
                       do update set
                         "name" = EXCLUDED."name",
                         "shipbase" = EXCLUDED."shipbase",
                         "shiprate" = EXCLUDED."shiprate",
                         "rowguid" = EXCLUDED."rowguid",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table shipmethod_TEMP;""".update
    created *> copied *> merged
  }
}