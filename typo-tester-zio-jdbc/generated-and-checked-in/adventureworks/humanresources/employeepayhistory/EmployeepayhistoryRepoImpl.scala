/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.streamingInsert
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

class EmployeepayhistoryRepoImpl extends EmployeepayhistoryRepo {
  override def delete(compositeId: EmployeepayhistoryId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from humanresources.employeepayhistory where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "ratechangedate" = ${Segment.paramSegment(compositeId.ratechangedate)(TypoLocalDateTime.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    DeleteBuilder("humanresources.employeepayhistory", EmployeepayhistoryFields)
  }
  override def insert(unsaved: EmployeepayhistoryRow): ZIO[ZConnection, Throwable, EmployeepayhistoryRow] = {
    sql"""insert into humanresources.employeepayhistory("businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.ratechangedate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.rate)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.payfrequency)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
       """.insertReturning(EmployeepayhistoryRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeepayhistoryRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY humanresources.employeepayhistory("businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate") FROM STDIN""", batchSize, unsaved)(EmployeepayhistoryRow.text)
  }
  override def insert(unsaved: EmployeepayhistoryRowUnsaved): ZIO[ZConnection, Throwable, EmployeepayhistoryRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""ratechangedate"""", sql"${Segment.paramSegment(unsaved.ratechangedate)(TypoLocalDateTime.setter)}::timestamp")),
      Some((sql""""rate"""", sql"${Segment.paramSegment(unsaved.rate)(Setter.bigDecimalScalaSetter)}::numeric")),
      Some((sql""""payfrequency"""", sql"${Segment.paramSegment(unsaved.payfrequency)(TypoShort.setter)}::int2")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into humanresources.employeepayhistory default values
            returning "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into humanresources.employeepayhistory($names) values ($values) returning "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text"""
    }
    q.insertReturning(EmployeepayhistoryRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeepayhistoryRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY humanresources.employeepayhistory("businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(EmployeepayhistoryRowUnsaved.text)
  }
  override def select: SelectBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    SelectBuilderSql("humanresources.employeepayhistory", EmployeepayhistoryFields, EmployeepayhistoryRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, EmployeepayhistoryRow] = {
    sql"""select "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text from humanresources.employeepayhistory""".query(EmployeepayhistoryRow.jdbcDecoder).selectStream
  }
  override def selectById(compositeId: EmployeepayhistoryId): ZIO[ZConnection, Throwable, Option[EmployeepayhistoryRow]] = {
    sql"""select "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text from humanresources.employeepayhistory where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "ratechangedate" = ${Segment.paramSegment(compositeId.ratechangedate)(TypoLocalDateTime.setter)}""".query(EmployeepayhistoryRow.jdbcDecoder).selectOne
  }
  override def update(row: EmployeepayhistoryRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update humanresources.employeepayhistory
          set "rate" = ${Segment.paramSegment(row.rate)(Setter.bigDecimalScalaSetter)}::numeric,
              "payfrequency" = ${Segment.paramSegment(row.payfrequency)(TypoShort.setter)}::int2,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "ratechangedate" = ${Segment.paramSegment(compositeId.ratechangedate)(TypoLocalDateTime.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    UpdateBuilder("humanresources.employeepayhistory", EmployeepayhistoryFields, EmployeepayhistoryRow.jdbcDecoder)
  }
  override def upsert(unsaved: EmployeepayhistoryRow): ZIO[ZConnection, Throwable, UpdateResult[EmployeepayhistoryRow]] = {
    sql"""insert into humanresources.employeepayhistory("businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.ratechangedate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.rate)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.payfrequency)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid", "ratechangedate")
          do update set
            "rate" = EXCLUDED."rate",
            "payfrequency" = EXCLUDED."payfrequency",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text""".insertReturning(EmployeepayhistoryRow.jdbcDecoder)
  }
}
