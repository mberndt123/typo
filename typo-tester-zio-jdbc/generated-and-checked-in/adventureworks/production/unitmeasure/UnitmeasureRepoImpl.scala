/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.unitmeasure;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.public.Name;
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

class UnitmeasureRepoImpl extends UnitmeasureRepo {
  def delete: DeleteBuilder[UnitmeasureFields, UnitmeasureRow] = DeleteBuilder("production.unitmeasure", UnitmeasureFields.structure)
  def deleteById(unitmeasurecode: UnitmeasureId): ZIO[ZConnection, Throwable, Boolean] = sql"""delete from production.unitmeasure where "unitmeasurecode" = ${Segment.paramSegment(unitmeasurecode)(UnitmeasureId.setter)}""".delete.map(_ > 0)
  def deleteByIds(unitmeasurecodes: Array[UnitmeasureId]): ZIO[ZConnection, Throwable, Long] = sql"""delete from production.unitmeasure where "unitmeasurecode" = ANY(${Segment.paramSegment(unitmeasurecodes)(UnitmeasureId.arraySetter)})""".delete
  def insert(unsaved: UnitmeasureRow): ZIO[ZConnection, Throwable, UnitmeasureRow] = {
    sql"""insert into production.unitmeasure("unitmeasurecode", "name", "modifieddate")
          values (${Segment.paramSegment(unsaved.unitmeasurecode)(UnitmeasureId.setter)}::bpchar, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "unitmeasurecode", "name", "modifieddate"::text
       """.insertReturning(using UnitmeasureRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  def insert(unsaved: UnitmeasureRowUnsaved): ZIO[ZConnection, Throwable, UnitmeasureRow] = {
    val fs = List(
      Some((sql""""unitmeasurecode"""", sql"${Segment.paramSegment(unsaved.unitmeasurecode)(UnitmeasureId.setter)}::bpchar")),
                      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
    }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.unitmeasure default values
                            returning "unitmeasurecode", "name", "modifieddate"::text
                         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.unitmeasure($names) values ($values) returning "unitmeasurecode", "name", "modifieddate"::text"""
    }
    q.insertReturning(using UnitmeasureRow.jdbcDecoder).map(_.updatedKeys.head)
  
  }
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, UnitmeasureRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY production.unitmeasure("unitmeasurecode", "name", "modifieddate") FROM STDIN""", batchSize, unsaved)(UnitmeasureRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, UnitmeasureRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY production.unitmeasure("unitmeasurecode", "name", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(UnitmeasureRowUnsaved.text)
  def select: SelectBuilder[UnitmeasureFields, UnitmeasureRow] = SelectBuilderSql("production.unitmeasure", UnitmeasureFields.structure, UnitmeasureRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, UnitmeasureRow] = sql"""select "unitmeasurecode", "name", "modifieddate"::text from production.unitmeasure""".query(using UnitmeasureRow.jdbcDecoder).selectStream()
  def selectById(unitmeasurecode: UnitmeasureId): ZIO[ZConnection, Throwable, Option[UnitmeasureRow]] = sql"""select "unitmeasurecode", "name", "modifieddate"::text from production.unitmeasure where "unitmeasurecode" = ${Segment.paramSegment(unitmeasurecode)(UnitmeasureId.setter)}""".query(using UnitmeasureRow.jdbcDecoder).selectOne
  def selectByIds(unitmeasurecodes: Array[UnitmeasureId]): ZStream[ZConnection, Throwable, UnitmeasureRow] = sql"""select "unitmeasurecode", "name", "modifieddate"::text from production.unitmeasure where "unitmeasurecode" = ANY(${Segment.paramSegment(unitmeasurecodes)(UnitmeasureId.arraySetter)})""".query(using UnitmeasureRow.jdbcDecoder).selectStream()
  def selectByIdsTracked(unitmeasurecodes: Array[UnitmeasureId]): ZIO[ZConnection, Throwable, Map[UnitmeasureId, UnitmeasureRow]] = {
    selectByIds(unitmeasurecodes).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.unitmeasurecode, x)).toMap
      unitmeasurecodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[UnitmeasureFields, UnitmeasureRow] = UpdateBuilder("production.unitmeasure", UnitmeasureFields.structure, UnitmeasureRow.jdbcDecoder)
  def update(row: UnitmeasureRow): ZIO[ZConnection, Throwable, Boolean] = {
    val unitmeasurecode = row.unitmeasurecode
    sql"""update production.unitmeasure
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "unitmeasurecode" = ${Segment.paramSegment(unitmeasurecode)(UnitmeasureId.setter)}""".update.map(_ > 0)
  }
  def upsert(unsaved: UnitmeasureRow): ZIO[ZConnection, Throwable, UpdateResult[UnitmeasureRow]] = {
    sql"""insert into production.unitmeasure("unitmeasurecode", "name", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.unitmeasurecode)(UnitmeasureId.setter)}::bpchar,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("unitmeasurecode")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "unitmeasurecode", "name", "modifieddate"::text""".insertReturning(using UnitmeasureRow.jdbcDecoder)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, UnitmeasureRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table unitmeasure_TEMP (like production.unitmeasure) on commit drop".execute
    val copied = streamingInsert(s"""copy unitmeasure_TEMP("unitmeasurecode", "name", "modifieddate") from stdin""", batchSize, unsaved)(UnitmeasureRow.text)
    val merged = sql"""insert into production.unitmeasure("unitmeasurecode", "name", "modifieddate")
                       select * from unitmeasure_TEMP
                       on conflict ("unitmeasurecode")
                       do update set
                         "name" = EXCLUDED."name",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table unitmeasure_TEMP;""".update
    created *> copied *> merged
  }
}