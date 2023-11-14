/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class ScrapreasonRepoImpl extends ScrapreasonRepo {
  override def delete(scrapreasonid: ScrapreasonId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.scrapreason where "scrapreasonid" = ${Segment.paramSegment(scrapreasonid)(ScrapreasonId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[ScrapreasonFields, ScrapreasonRow] = {
    DeleteBuilder("production.scrapreason", ScrapreasonFields)
  }
  override def insert(unsaved: ScrapreasonRow): ZIO[ZConnection, Throwable, ScrapreasonRow] = {
    sql"""insert into production.scrapreason("scrapreasonid", "name", "modifieddate")
          values (${Segment.paramSegment(unsaved.scrapreasonid)(ScrapreasonId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "scrapreasonid", "name", "modifieddate"::text
       """.insertReturning(ScrapreasonRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ScrapreasonRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.scrapreason("scrapreasonid", "name", "modifieddate") FROM STDIN""", batchSize, unsaved)(ScrapreasonRow.text)
  }
  override def insert(unsaved: ScrapreasonRowUnsaved): ZIO[ZConnection, Throwable, ScrapreasonRow] = {
    val fs = List(
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      unsaved.scrapreasonid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""scrapreasonid"""", sql"${Segment.paramSegment(value: ScrapreasonId)(ScrapreasonId.setter)}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.scrapreason default values
            returning "scrapreasonid", "name", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.scrapreason($names) values ($values) returning "scrapreasonid", "name", "modifieddate"::text"""
    }
    q.insertReturning(ScrapreasonRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ScrapreasonRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.scrapreason("name", "scrapreasonid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ScrapreasonRowUnsaved.text)
  }
  override def select: SelectBuilder[ScrapreasonFields, ScrapreasonRow] = {
    SelectBuilderSql("production.scrapreason", ScrapreasonFields, ScrapreasonRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ScrapreasonRow] = {
    sql"""select "scrapreasonid", "name", "modifieddate"::text from production.scrapreason""".query(ScrapreasonRow.jdbcDecoder).selectStream
  }
  override def selectById(scrapreasonid: ScrapreasonId): ZIO[ZConnection, Throwable, Option[ScrapreasonRow]] = {
    sql"""select "scrapreasonid", "name", "modifieddate"::text from production.scrapreason where "scrapreasonid" = ${Segment.paramSegment(scrapreasonid)(ScrapreasonId.setter)}""".query(ScrapreasonRow.jdbcDecoder).selectOne
  }
  override def selectByIds(scrapreasonids: Array[ScrapreasonId]): ZStream[ZConnection, Throwable, ScrapreasonRow] = {
    sql"""select "scrapreasonid", "name", "modifieddate"::text from production.scrapreason where "scrapreasonid" = ANY(${Segment.paramSegment(scrapreasonids)(ScrapreasonId.arraySetter)})""".query(ScrapreasonRow.jdbcDecoder).selectStream
  }
  override def update(row: ScrapreasonRow): ZIO[ZConnection, Throwable, Boolean] = {
    val scrapreasonid = row.scrapreasonid
    sql"""update production.scrapreason
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "scrapreasonid" = ${Segment.paramSegment(scrapreasonid)(ScrapreasonId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[ScrapreasonFields, ScrapreasonRow] = {
    UpdateBuilder("production.scrapreason", ScrapreasonFields, ScrapreasonRow.jdbcDecoder)
  }
  override def upsert(unsaved: ScrapreasonRow): ZIO[ZConnection, Throwable, UpdateResult[ScrapreasonRow]] = {
    sql"""insert into production.scrapreason("scrapreasonid", "name", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.scrapreasonid)(ScrapreasonId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("scrapreasonid")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "scrapreasonid", "name", "modifieddate"::text""".insertReturning(ScrapreasonRow.jdbcDecoder)
  }
}
