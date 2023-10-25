/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

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

object CultureRepoImpl extends CultureRepo {
  override def delete(cultureid: CultureId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.culture where "cultureid" = ${Segment.paramSegment(cultureid)(CultureId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[CultureFields, CultureRow] = {
    DeleteBuilder("production.culture", CultureFields)
  }
  override def insert(unsaved: CultureRow): ZIO[ZConnection, Throwable, CultureRow] = {
    sql"""insert into production.culture("cultureid", "name", "modifieddate")
          values (${Segment.paramSegment(unsaved.cultureid)(CultureId.setter)}::bpchar, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "cultureid", "name", "modifieddate"::text
       """.insertReturning(CultureRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CultureRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.culture("cultureid", "name", "modifieddate") FROM STDIN""", batchSize, unsaved)(CultureRow.text)
  }
  override def insert(unsaved: CultureRowUnsaved): ZIO[ZConnection, Throwable, CultureRow] = {
    val fs = List(
      Some((sql""""cultureid"""", sql"${Segment.paramSegment(unsaved.cultureid)(CultureId.setter)}::bpchar")),
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.culture default values
            returning "cultureid", "name", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.culture($names) values ($values) returning "cultureid", "name", "modifieddate"::text"""
    }
    q.insertReturning(CultureRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CultureRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.culture("cultureid", "name", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(CultureRowUnsaved.text)
  }
  override def select: SelectBuilder[CultureFields, CultureRow] = {
    SelectBuilderSql("production.culture", CultureFields, CultureRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CultureRow] = {
    sql"""select "cultureid", "name", "modifieddate"::text from production.culture""".query(CultureRow.jdbcDecoder).selectStream
  }
  override def selectById(cultureid: CultureId): ZIO[ZConnection, Throwable, Option[CultureRow]] = {
    sql"""select "cultureid", "name", "modifieddate"::text from production.culture where "cultureid" = ${Segment.paramSegment(cultureid)(CultureId.setter)}""".query(CultureRow.jdbcDecoder).selectOne
  }
  override def selectByIds(cultureids: Array[CultureId]): ZStream[ZConnection, Throwable, CultureRow] = {
    sql"""select "cultureid", "name", "modifieddate"::text from production.culture where "cultureid" = ANY(${Segment.paramSegment(cultureids)(CultureId.arraySetter)})""".query(CultureRow.jdbcDecoder).selectStream
  }
  override def update(row: CultureRow): ZIO[ZConnection, Throwable, Boolean] = {
    val cultureid = row.cultureid
    sql"""update production.culture
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "cultureid" = ${Segment.paramSegment(cultureid)(CultureId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[CultureFields, CultureRow] = {
    UpdateBuilder("production.culture", CultureFields, CultureRow.jdbcDecoder)
  }
  override def upsert(unsaved: CultureRow): ZIO[ZConnection, Throwable, UpdateResult[CultureRow]] = {
    sql"""insert into production.culture("cultureid", "name", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.cultureid)(CultureId.setter)}::bpchar,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("cultureid")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "cultureid", "name", "modifieddate"::text""".insertReturning(CultureRow.jdbcDecoder)
  }
}
