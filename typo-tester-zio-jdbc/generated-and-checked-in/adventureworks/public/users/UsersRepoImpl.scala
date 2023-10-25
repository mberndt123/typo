/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package users

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoInstant
import adventureworks.customtypes.TypoUnknownCitext
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

object UsersRepoImpl extends UsersRepo {
  override def delete(userId: UsersId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from public.users where "user_id" = ${Segment.paramSegment(userId)(UsersId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[UsersFields, UsersRow] = {
    DeleteBuilder("public.users", UsersFields)
  }
  override def insert(unsaved: UsersRow): ZIO[ZConnection, Throwable, UsersRow] = {
    sql"""insert into public.users("user_id", "name", "last_name", "email", "password", "created_at", "verified_on")
          values (${Segment.paramSegment(unsaved.userId)(UsersId.setter)}::uuid, ${Segment.paramSegment(unsaved.name)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.lastName)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.email)(TypoUnknownCitext.setter)}::citext, ${Segment.paramSegment(unsaved.password)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.createdAt)(TypoInstant.setter)}::timestamptz, ${Segment.paramSegment(unsaved.verifiedOn)(Setter.optionParamSetter(TypoInstant.setter))}::timestamptz)
          returning "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text
       """.insertReturning(UsersRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, UsersRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY public.users("user_id", "name", "last_name", "email", "password", "created_at", "verified_on") FROM STDIN""", batchSize, unsaved)(UsersRow.text)
  }
  override def insert(unsaved: UsersRowUnsaved): ZIO[ZConnection, Throwable, UsersRow] = {
    val fs = List(
      Some((sql""""user_id"""", sql"${Segment.paramSegment(unsaved.userId)(UsersId.setter)}::uuid")),
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Setter.stringSetter)}")),
      Some((sql""""last_name"""", sql"${Segment.paramSegment(unsaved.lastName)(Setter.optionParamSetter(Setter.stringSetter))}")),
      Some((sql""""email"""", sql"${Segment.paramSegment(unsaved.email)(TypoUnknownCitext.setter)}::citext")),
      Some((sql""""password"""", sql"${Segment.paramSegment(unsaved.password)(Setter.stringSetter)}")),
      Some((sql""""verified_on"""", sql"${Segment.paramSegment(unsaved.verifiedOn)(Setter.optionParamSetter(TypoInstant.setter))}::timestamptz")),
      unsaved.createdAt match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""created_at"""", sql"${Segment.paramSegment(value: TypoInstant)(TypoInstant.setter)}::timestamptz"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into public.users default values
            returning "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into public.users($names) values ($values) returning "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text"""
    }
    q.insertReturning(UsersRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, UsersRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY public.users("user_id", "name", "last_name", "email", "password", "verified_on", "created_at") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(UsersRowUnsaved.text)
  }
  override def select: SelectBuilder[UsersFields, UsersRow] = {
    SelectBuilderSql("public.users", UsersFields, UsersRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, UsersRow] = {
    sql"""select "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text from public.users""".query(UsersRow.jdbcDecoder).selectStream
  }
  override def selectById(userId: UsersId): ZIO[ZConnection, Throwable, Option[UsersRow]] = {
    sql"""select "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text from public.users where "user_id" = ${Segment.paramSegment(userId)(UsersId.setter)}""".query(UsersRow.jdbcDecoder).selectOne
  }
  override def selectByIds(userIds: Array[UsersId]): ZStream[ZConnection, Throwable, UsersRow] = {
    sql"""select "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text from public.users where "user_id" = ANY(${Segment.paramSegment(userIds)(UsersId.arraySetter)})""".query(UsersRow.jdbcDecoder).selectStream
  }
  override def selectByUnique(email: TypoUnknownCitext): ZIO[ZConnection, Throwable, Option[UsersRow]] = {
    sql"""select "email"::text
          from public.users
          where "email" = ${Segment.paramSegment(email)(TypoUnknownCitext.setter)}
       """.query(UsersRow.jdbcDecoder).selectOne
  }
  override def update(row: UsersRow): ZIO[ZConnection, Throwable, Boolean] = {
    val userId = row.userId
    sql"""update public.users
          set "name" = ${Segment.paramSegment(row.name)(Setter.stringSetter)},
              "last_name" = ${Segment.paramSegment(row.lastName)(Setter.optionParamSetter(Setter.stringSetter))},
              "email" = ${Segment.paramSegment(row.email)(TypoUnknownCitext.setter)}::citext,
              "password" = ${Segment.paramSegment(row.password)(Setter.stringSetter)},
              "created_at" = ${Segment.paramSegment(row.createdAt)(TypoInstant.setter)}::timestamptz,
              "verified_on" = ${Segment.paramSegment(row.verifiedOn)(Setter.optionParamSetter(TypoInstant.setter))}::timestamptz
          where "user_id" = ${Segment.paramSegment(userId)(UsersId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[UsersFields, UsersRow] = {
    UpdateBuilder("public.users", UsersFields, UsersRow.jdbcDecoder)
  }
  override def upsert(unsaved: UsersRow): ZIO[ZConnection, Throwable, UpdateResult[UsersRow]] = {
    sql"""insert into public.users("user_id", "name", "last_name", "email", "password", "created_at", "verified_on")
          values (
            ${Segment.paramSegment(unsaved.userId)(UsersId.setter)}::uuid,
            ${Segment.paramSegment(unsaved.name)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.lastName)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.email)(TypoUnknownCitext.setter)}::citext,
            ${Segment.paramSegment(unsaved.password)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.createdAt)(TypoInstant.setter)}::timestamptz,
            ${Segment.paramSegment(unsaved.verifiedOn)(Setter.optionParamSetter(TypoInstant.setter))}::timestamptz
          )
          on conflict ("user_id")
          do update set
            "name" = EXCLUDED."name",
            "last_name" = EXCLUDED."last_name",
            "email" = EXCLUDED."email",
            "password" = EXCLUDED."password",
            "created_at" = EXCLUDED."created_at",
            "verified_on" = EXCLUDED."verified_on"
          returning "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text""".insertReturning(UsersRow.jdbcDecoder)
  }
}
