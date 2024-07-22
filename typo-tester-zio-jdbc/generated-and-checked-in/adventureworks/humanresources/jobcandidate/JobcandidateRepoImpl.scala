/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.jobcandidate;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoXml;
import adventureworks.person.businessentity.BusinessentityId;
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

class JobcandidateRepoImpl extends JobcandidateRepo {
  def delete: DeleteBuilder[JobcandidateFields, JobcandidateRow] = DeleteBuilder("humanresources.jobcandidate", JobcandidateFields.structure)
  def deleteById(jobcandidateid: JobcandidateId): ZIO[ZConnection, Throwable, Boolean] = sql"""delete from humanresources.jobcandidate where "jobcandidateid" = ${Segment.paramSegment(jobcandidateid)(JobcandidateId.setter)}""".delete.map(_ > 0)
  def deleteByIds(jobcandidateids: Array[JobcandidateId]): ZIO[ZConnection, Throwable, Long] = sql"""delete from humanresources.jobcandidate where "jobcandidateid" = ANY(${Segment.paramSegment(jobcandidateids)(JobcandidateId.arraySetter)})""".delete
  def insert(unsaved: JobcandidateRow): ZIO[ZConnection, Throwable, JobcandidateRow] = {
    sql"""insert into humanresources.jobcandidate("jobcandidateid", "businessentityid", "resume", "modifieddate")
          values (${Segment.paramSegment(unsaved.jobcandidateid)(JobcandidateId.setter)}::int4, ${Segment.paramSegment(unsaved.businessentityid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4, ${Segment.paramSegment(unsaved.resume)(Setter.optionParamSetter(TypoXml.setter))}::xml, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "jobcandidateid", "businessentityid", "resume", "modifieddate"::text
       """.insertReturning(using JobcandidateRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  def insert(unsaved: JobcandidateRowUnsaved): ZIO[ZConnection, Throwable, JobcandidateRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4")),
                      Some((sql""""resume"""", sql"${Segment.paramSegment(unsaved.resume)(Setter.optionParamSetter(TypoXml.setter))}::xml")),
    unsaved.jobcandidateid match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((sql""""jobcandidateid"""", sql"${Segment.paramSegment(value: JobcandidateId)(JobcandidateId.setter)}::int4"))
    },
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
    }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into humanresources.jobcandidate default values
                            returning "jobcandidateid", "businessentityid", "resume", "modifieddate"::text
                         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into humanresources.jobcandidate($names) values ($values) returning "jobcandidateid", "businessentityid", "resume", "modifieddate"::text"""
    }
    q.insertReturning(using JobcandidateRow.jdbcDecoder).map(_.updatedKeys.head)
  
  }
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, JobcandidateRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY humanresources.jobcandidate("jobcandidateid", "businessentityid", "resume", "modifieddate") FROM STDIN""", batchSize, unsaved)(JobcandidateRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, JobcandidateRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY humanresources.jobcandidate("businessentityid", "resume", "jobcandidateid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(JobcandidateRowUnsaved.text)
  def select: SelectBuilder[JobcandidateFields, JobcandidateRow] = SelectBuilderSql("humanresources.jobcandidate", JobcandidateFields.structure, JobcandidateRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, JobcandidateRow] = sql"""select "jobcandidateid", "businessentityid", "resume", "modifieddate"::text from humanresources.jobcandidate""".query(using JobcandidateRow.jdbcDecoder).selectStream()
  def selectById(jobcandidateid: JobcandidateId): ZIO[ZConnection, Throwable, Option[JobcandidateRow]] = sql"""select "jobcandidateid", "businessentityid", "resume", "modifieddate"::text from humanresources.jobcandidate where "jobcandidateid" = ${Segment.paramSegment(jobcandidateid)(JobcandidateId.setter)}""".query(using JobcandidateRow.jdbcDecoder).selectOne
  def selectByIds(jobcandidateids: Array[JobcandidateId]): ZStream[ZConnection, Throwable, JobcandidateRow] = sql"""select "jobcandidateid", "businessentityid", "resume", "modifieddate"::text from humanresources.jobcandidate where "jobcandidateid" = ANY(${Segment.paramSegment(jobcandidateids)(JobcandidateId.arraySetter)})""".query(using JobcandidateRow.jdbcDecoder).selectStream()
  def selectByIdsTracked(jobcandidateids: Array[JobcandidateId]): ZIO[ZConnection, Throwable, Map[JobcandidateId, JobcandidateRow]] = {
    selectByIds(jobcandidateids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.jobcandidateid, x)).toMap
      jobcandidateids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[JobcandidateFields, JobcandidateRow] = UpdateBuilder("humanresources.jobcandidate", JobcandidateFields.structure, JobcandidateRow.jdbcDecoder)
  def update(row: JobcandidateRow): ZIO[ZConnection, Throwable, Boolean] = {
    val jobcandidateid = row.jobcandidateid
    sql"""update humanresources.jobcandidate
          set "businessentityid" = ${Segment.paramSegment(row.businessentityid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
              "resume" = ${Segment.paramSegment(row.resume)(Setter.optionParamSetter(TypoXml.setter))}::xml,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "jobcandidateid" = ${Segment.paramSegment(jobcandidateid)(JobcandidateId.setter)}""".update.map(_ > 0)
  }
  def upsert(unsaved: JobcandidateRow): ZIO[ZConnection, Throwable, UpdateResult[JobcandidateRow]] = {
    sql"""insert into humanresources.jobcandidate("jobcandidateid", "businessentityid", "resume", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.jobcandidateid)(JobcandidateId.setter)}::int4,
            ${Segment.paramSegment(unsaved.businessentityid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
            ${Segment.paramSegment(unsaved.resume)(Setter.optionParamSetter(TypoXml.setter))}::xml,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("jobcandidateid")
          do update set
            "businessentityid" = EXCLUDED."businessentityid",
            "resume" = EXCLUDED."resume",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "jobcandidateid", "businessentityid", "resume", "modifieddate"::text""".insertReturning(using JobcandidateRow.jdbcDecoder)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, JobcandidateRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table jobcandidate_TEMP (like humanresources.jobcandidate) on commit drop".execute
    val copied = streamingInsert(s"""copy jobcandidate_TEMP("jobcandidateid", "businessentityid", "resume", "modifieddate") from stdin""", batchSize, unsaved)(JobcandidateRow.text)
    val merged = sql"""insert into humanresources.jobcandidate("jobcandidateid", "businessentityid", "resume", "modifieddate")
                       select * from jobcandidate_TEMP
                       on conflict ("jobcandidateid")
                       do update set
                         "businessentityid" = EXCLUDED."businessentityid",
                         "resume" = EXCLUDED."resume",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table jobcandidate_TEMP;""".update
    created *> copied *> merged
  }
}