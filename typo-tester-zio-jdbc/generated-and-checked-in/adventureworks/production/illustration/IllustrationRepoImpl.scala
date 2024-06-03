/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package illustration

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoXml
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

class IllustrationRepoImpl extends IllustrationRepo {
  override def delete: DeleteBuilder[IllustrationFields, IllustrationRow] = {
    DeleteBuilder("production.illustration", IllustrationFields.structure)
  }
  override def deleteById(illustrationid: IllustrationId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.illustration where "illustrationid" = ${Segment.paramSegment(illustrationid)(IllustrationId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(illustrationids: Array[IllustrationId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from production.illustration where "illustrationid" = ANY(${illustrationids})""".delete
  }
  override def insert(unsaved: IllustrationRow): ZIO[ZConnection, Throwable, IllustrationRow] = {
    sql"""insert into production.illustration("illustrationid", "diagram", "modifieddate")
          values (${Segment.paramSegment(unsaved.illustrationid)(IllustrationId.setter)}::int4, ${Segment.paramSegment(unsaved.diagram)(Setter.optionParamSetter(TypoXml.setter))}::xml, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "illustrationid", "diagram", "modifieddate"::text
       """.insertReturning(using IllustrationRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: IllustrationRowUnsaved): ZIO[ZConnection, Throwable, IllustrationRow] = {
    val fs = List(
      Some((sql""""diagram"""", sql"${Segment.paramSegment(unsaved.diagram)(Setter.optionParamSetter(TypoXml.setter))}::xml")),
      unsaved.illustrationid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""illustrationid"""", sql"${Segment.paramSegment(value: IllustrationId)(IllustrationId.setter)}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.illustration default values
            returning "illustrationid", "diagram", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.illustration($names) values ($values) returning "illustrationid", "diagram", "modifieddate"::text"""
    }
    q.insertReturning(using IllustrationRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, IllustrationRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.illustration("illustrationid", "diagram", "modifieddate") FROM STDIN""", batchSize, unsaved)(IllustrationRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, IllustrationRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.illustration("diagram", "illustrationid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(IllustrationRowUnsaved.text)
  }
  override def select: SelectBuilder[IllustrationFields, IllustrationRow] = {
    SelectBuilderSql("production.illustration", IllustrationFields.structure, IllustrationRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, IllustrationRow] = {
    sql"""select "illustrationid", "diagram", "modifieddate"::text from production.illustration""".query(using IllustrationRow.jdbcDecoder).selectStream()
  }
  override def selectById(illustrationid: IllustrationId): ZIO[ZConnection, Throwable, Option[IllustrationRow]] = {
    sql"""select "illustrationid", "diagram", "modifieddate"::text from production.illustration where "illustrationid" = ${Segment.paramSegment(illustrationid)(IllustrationId.setter)}""".query(using IllustrationRow.jdbcDecoder).selectOne
  }
  override def selectByIds(illustrationids: Array[IllustrationId]): ZStream[ZConnection, Throwable, IllustrationRow] = {
    sql"""select "illustrationid", "diagram", "modifieddate"::text from production.illustration where "illustrationid" = ANY(${Segment.paramSegment(illustrationids)(IllustrationId.arraySetter)})""".query(using IllustrationRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(illustrationids: Array[IllustrationId]): ZIO[ZConnection, Throwable, Map[IllustrationId, IllustrationRow]] = {
    selectByIds(illustrationids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.illustrationid, x)).toMap
      illustrationids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[IllustrationFields, IllustrationRow] = {
    UpdateBuilder("production.illustration", IllustrationFields.structure, IllustrationRow.jdbcDecoder)
  }
  override def update(row: IllustrationRow): ZIO[ZConnection, Throwable, Boolean] = {
    val illustrationid = row.illustrationid
    sql"""update production.illustration
          set "diagram" = ${Segment.paramSegment(row.diagram)(Setter.optionParamSetter(TypoXml.setter))}::xml,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "illustrationid" = ${Segment.paramSegment(illustrationid)(IllustrationId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: IllustrationRow): ZIO[ZConnection, Throwable, UpdateResult[IllustrationRow]] = {
    sql"""insert into production.illustration("illustrationid", "diagram", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.illustrationid)(IllustrationId.setter)}::int4,
            ${Segment.paramSegment(unsaved.diagram)(Setter.optionParamSetter(TypoXml.setter))}::xml,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("illustrationid")
          do update set
            "diagram" = EXCLUDED."diagram",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "illustrationid", "diagram", "modifieddate"::text""".insertReturning(using IllustrationRow.jdbcDecoder)
  }
}
