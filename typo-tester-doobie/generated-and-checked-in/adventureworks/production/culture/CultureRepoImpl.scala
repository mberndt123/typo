/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.culture

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import cats.instances.list.catsStdInstancesForList
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.update.Update
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class CultureRepoImpl extends CultureRepo {
  override def delete: DeleteBuilder[CultureFields, CultureRow] = {
    DeleteBuilder("production.culture", CultureFields.structure)
  }
  override def deleteById(cultureid: CultureId): ConnectionIO[Boolean] = {
    sql"""delete from production.culture where "cultureid" = ${fromWrite(cultureid)(Write.fromPut(CultureId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(cultureids: Array[CultureId]): ConnectionIO[Int] = {
    sql"""delete from production.culture where "cultureid" = ANY(${fromWrite(cultureids)(Write.fromPut(CultureId.arrayPut))})""".update.run
  }
  override def insert(unsaved: CultureRow): ConnectionIO[CultureRow] = {
    sql"""insert into production.culture("cultureid", "name", "modifieddate")
          values (${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "cultureid", "name", "modifieddate"::text
       """.query(using CultureRow.read).unique
  }
  override def insert(unsaved: CultureRowUnsaved): ConnectionIO[CultureRow] = {
    val fs = List(
      Some((Fragment.const0(s""""cultureid""""), fr"${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar")),
      Some((Fragment.const0(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.culture default values
            returning "cultureid", "name", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.culture(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "cultureid", "name", "modifieddate"::text
         """
    }
    q.query(using CultureRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, CultureRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.culture("cultureid", "name", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using CultureRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CultureRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.culture("cultureid", "name", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using CultureRowUnsaved.text)
  }
  override def select: SelectBuilder[CultureFields, CultureRow] = {
    SelectBuilderSql("production.culture", CultureFields.structure, CultureRow.read)
  }
  override def selectAll: Stream[ConnectionIO, CultureRow] = {
    sql"""select "cultureid", "name", "modifieddate"::text from production.culture""".query(using CultureRow.read).stream
  }
  override def selectById(cultureid: CultureId): ConnectionIO[Option[CultureRow]] = {
    sql"""select "cultureid", "name", "modifieddate"::text from production.culture where "cultureid" = ${fromWrite(cultureid)(Write.fromPut(CultureId.put))}""".query(using CultureRow.read).option
  }
  override def selectByIds(cultureids: Array[CultureId]): Stream[ConnectionIO, CultureRow] = {
    sql"""select "cultureid", "name", "modifieddate"::text from production.culture where "cultureid" = ANY(${fromWrite(cultureids)(Write.fromPut(CultureId.arrayPut))})""".query(using CultureRow.read).stream
  }
  override def selectByIdsTracked(cultureids: Array[CultureId]): ConnectionIO[Map[CultureId, CultureRow]] = {
    selectByIds(cultureids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.cultureid, x)).toMap
      cultureids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[CultureFields, CultureRow] = {
    UpdateBuilder("production.culture", CultureFields.structure, CultureRow.read)
  }
  override def update(row: CultureRow): ConnectionIO[Boolean] = {
    val cultureid = row.cultureid
    sql"""update production.culture
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "cultureid" = ${fromWrite(cultureid)(Write.fromPut(CultureId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: CultureRow): ConnectionIO[CultureRow] = {
    sql"""insert into production.culture("cultureid", "name", "modifieddate")
          values (
            ${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("cultureid")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "cultureid", "name", "modifieddate"::text
       """.query(using CultureRow.read).unique
  }
  override def upsertBatch(unsaved: List[CultureRow]): Stream[ConnectionIO, CultureRow] = {
    Update[CultureRow](
      s"""insert into production.culture("cultureid", "name", "modifieddate")
          values (?::bpchar,?::varchar,?::timestamp)
          on conflict ("cultureid")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "cultureid", "name", "modifieddate"::text"""
    )(using CultureRow.write)
    .updateManyWithGeneratedKeys[CultureRow]("cultureid", "name", "modifieddate")(unsaved)(using catsStdInstancesForList, CultureRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, CultureRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table culture_TEMP (like production.culture) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy culture_TEMP("cultureid", "name", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using CultureRow.text)
      res <- sql"""insert into production.culture("cultureid", "name", "modifieddate")
                   select * from culture_TEMP
                   on conflict ("cultureid")
                   do update set
                     "name" = EXCLUDED."name",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table culture_TEMP;""".update.run
    } yield res
  }
}
