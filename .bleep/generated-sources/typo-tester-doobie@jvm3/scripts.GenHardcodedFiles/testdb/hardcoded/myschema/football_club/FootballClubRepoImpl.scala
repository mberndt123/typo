/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package football_club

import cats.data.NonEmptyList
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragments
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object FootballClubRepoImpl extends FootballClubRepo {
  override def delete(id: FootballClubId): ConnectionIO[Boolean] = {
    sql"""delete from myschema.football_club where "id" = ${fromWrite(id)(Write.fromPut(FootballClubId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[FootballClubFields, FootballClubRow] = {
    DeleteBuilder("myschema.football_club", FootballClubFields)
  }
  override def insert(unsaved: FootballClubRow): ConnectionIO[FootballClubRow] = {
    sql"""insert into myschema.football_club("id", "name")
          values (${fromWrite(unsaved.id)(Write.fromPut(FootballClubId.put))}::int8, ${fromWrite(unsaved.name)(Write.fromPut(Meta.StringMeta.put))})
          returning "id", "name"
       """.query(FootballClubRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, FootballClubRow], batchSize: Int): ConnectionIO[Long] = {
    doobie.postgres.syntax.fragment.toFragmentOps(sql"""COPY myschema.football_club("id", "name") FROM STDIN""").copyIn(unsaved, batchSize)(FootballClubRow.text)
  }
  override def select: SelectBuilder[FootballClubFields, FootballClubRow] = {
    SelectBuilderSql("myschema.football_club", FootballClubFields, FootballClubRow.read)
  }
  override def selectAll: Stream[ConnectionIO, FootballClubRow] = {
    sql"""select "id", "name" from myschema.football_club""".query(FootballClubRow.read).stream
  }
  override def selectById(id: FootballClubId): ConnectionIO[Option[FootballClubRow]] = {
    sql"""select "id", "name" from myschema.football_club where "id" = ${fromWrite(id)(Write.fromPut(FootballClubId.put))}""".query(FootballClubRow.read).option
  }
  override def selectByIds(ids: Array[FootballClubId]): Stream[ConnectionIO, FootballClubRow] = {
    sql"""select "id", "name" from myschema.football_club where "id" = ANY(${ids})""".query(FootballClubRow.read).stream
  }
  override def selectByFieldValues(fieldValues: List[FootballClubFieldOrIdValue[?]]): Stream[ConnectionIO, FootballClubRow] = {
    val where = fragments.whereAndOpt(
      fieldValues.map {
        case FootballClubFieldValue.id(value) => fr""""id" = ${fromWrite(value)(Write.fromPut(FootballClubId.put))}"""
        case FootballClubFieldValue.name(value) => fr""""name" = ${fromWrite(value)(Write.fromPut(Meta.StringMeta.put))}"""
      }
    )
    sql"""select "id", "name" from myschema.football_club $where""".query(FootballClubRow.read).stream
  }
  override def update(row: FootballClubRow): ConnectionIO[Boolean] = {
    val id = row.id
    sql"""update myschema.football_club
          set "name" = ${fromWrite(row.name)(Write.fromPut(Meta.StringMeta.put))}
          where "id" = ${fromWrite(id)(Write.fromPut(FootballClubId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[FootballClubFields, FootballClubRow] = {
    UpdateBuilder("myschema.football_club", FootballClubFields, FootballClubRow.read)
  }
  override def updateFieldValues(id: FootballClubId, fieldValues: List[FootballClubFieldValue[?]]): ConnectionIO[Boolean] = {
    NonEmptyList.fromList(fieldValues) match {
      case None => pure(false)
      case Some(nonEmpty) =>
        val updates = fragments.set(
          nonEmpty.map {
            case FootballClubFieldValue.name(value) => fr""""name" = ${fromWrite(value)(Write.fromPut(Meta.StringMeta.put))}"""
          }
        )
        sql"""update myschema.football_club
              $updates
              where "id" = ${fromWrite(id)(Write.fromPut(FootballClubId.put))}""".update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: FootballClubRow): ConnectionIO[FootballClubRow] = {
    sql"""insert into myschema.football_club("id", "name")
          values (
            ${fromWrite(unsaved.id)(Write.fromPut(FootballClubId.put))}::int8,
            ${fromWrite(unsaved.name)(Write.fromPut(Meta.StringMeta.put))}
          )
          on conflict ("id")
          do update set
            "name" = EXCLUDED."name"
          returning "id", "name"
       """.query(FootballClubRow.read).unique
  }
}
