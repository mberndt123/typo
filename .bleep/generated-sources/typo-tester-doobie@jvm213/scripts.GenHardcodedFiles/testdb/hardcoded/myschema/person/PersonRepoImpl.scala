/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import testdb.hardcoded.Defaulted
import testdb.hardcoded.myschema.Sector
import testdb.hardcoded.myschema.football_club.FootballClubId
import testdb.hardcoded.myschema.marital_status.MaritalStatusId
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PersonRepoImpl extends PersonRepo {
  override def delete(id: PersonId): ConnectionIO[Boolean] = {
    sql"""delete from myschema.person where "id" = ${fromWrite(id)(Write.fromPut(PersonId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilder("myschema.person", PersonFields)
  }
  override def insert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    sql"""insert into myschema.person("id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector)
          values (${fromWrite(unsaved.id)(Write.fromPut(PersonId.put))}::int8, ${fromWrite(unsaved.favouriteFootballClubId)(Write.fromPut(FootballClubId.put))}, ${fromWrite(unsaved.name)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.nickName)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.blogUrl)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.email)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.phone)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.likesPizza)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.maritalStatusId)(Write.fromPut(MaritalStatusId.put))}, ${fromWrite(unsaved.workEmail)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.sector)(Write.fromPut(Sector.put))}::myschema.sector)
          returning "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
       """.query(PersonRow.read).unique
  }
  override def insert(unsaved: PersonRowUnsaved): ConnectionIO[PersonRow] = {
    val fs = List(
      Some((Fragment.const(s"favourite_football_club_id"), fr"${fromWrite(unsaved.favouriteFootballClubId)(Write.fromPut(FootballClubId.put))}")),
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"nick_name"), fr"${fromWrite(unsaved.nickName)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"blog_url"), fr"${fromWrite(unsaved.blogUrl)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"email"), fr"${fromWrite(unsaved.email)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"phone"), fr"${fromWrite(unsaved.phone)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"likes_pizza"), fr"${fromWrite(unsaved.likesPizza)(Write.fromPut(Meta.BooleanMeta.put))}")),
      Some((Fragment.const(s"work_email"), fr"${fromWrite(unsaved.workEmail)(Write.fromPutOption(Meta.StringMeta.put))}")),
      unsaved.id match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""id""""), fr"${fromWrite(value: PersonId)(Write.fromPut(PersonId.put))}::int8"))
      },
      unsaved.maritalStatusId match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"marital_status_id"), fr"${fromWrite(value: MaritalStatusId)(Write.fromPut(MaritalStatusId.put))}"))
      },
      unsaved.sector match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"sector"), fr"${fromWrite(value: Sector)(Write.fromPut(Sector.put))}::myschema.sector"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into myschema.person default values
            returning "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into myschema.person(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
         """
    }
    q.query(PersonRow.read).unique
    
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderSql("myschema.person", PersonFields, PersonRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PersonRow] = {
    sql"""select "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector from myschema.person""".query(PersonRow.read).stream
  }
  override def selectById(id: PersonId): ConnectionIO[Option[PersonRow]] = {
    sql"""select "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector from myschema.person where "id" = ${fromWrite(id)(Write.fromPut(PersonId.put))}""".query(PersonRow.read).option
  }
  override def selectByIds(ids: Array[PersonId]): Stream[ConnectionIO, PersonRow] = {
    sql"""select "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector from myschema.person where "id" = ANY(${fromWrite(ids)(Write.fromPut(PersonId.arrayPut))})""".query(PersonRow.read).stream
  }
  override def update(row: PersonRow): ConnectionIO[Boolean] = {
    val id = row.id
    sql"""update myschema.person
          set favourite_football_club_id = ${fromWrite(row.favouriteFootballClubId)(Write.fromPut(FootballClubId.put))},
              "name" = ${fromWrite(row.name)(Write.fromPut(Meta.StringMeta.put))},
              nick_name = ${fromWrite(row.nickName)(Write.fromPutOption(Meta.StringMeta.put))},
              blog_url = ${fromWrite(row.blogUrl)(Write.fromPutOption(Meta.StringMeta.put))},
              email = ${fromWrite(row.email)(Write.fromPut(Meta.StringMeta.put))},
              phone = ${fromWrite(row.phone)(Write.fromPut(Meta.StringMeta.put))},
              likes_pizza = ${fromWrite(row.likesPizza)(Write.fromPut(Meta.BooleanMeta.put))},
              marital_status_id = ${fromWrite(row.maritalStatusId)(Write.fromPut(MaritalStatusId.put))},
              work_email = ${fromWrite(row.workEmail)(Write.fromPutOption(Meta.StringMeta.put))},
              sector = ${fromWrite(row.sector)(Write.fromPut(Sector.put))}::myschema.sector
          where "id" = ${fromWrite(id)(Write.fromPut(PersonId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilder("myschema.person", PersonFields, PersonRow.read)
  }
  override def upsert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    sql"""insert into myschema.person("id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector)
          values (
            ${fromWrite(unsaved.id)(Write.fromPut(PersonId.put))}::int8,
            ${fromWrite(unsaved.favouriteFootballClubId)(Write.fromPut(FootballClubId.put))},
            ${fromWrite(unsaved.name)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.nickName)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.blogUrl)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.email)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.phone)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.likesPizza)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.maritalStatusId)(Write.fromPut(MaritalStatusId.put))},
            ${fromWrite(unsaved.workEmail)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.sector)(Write.fromPut(Sector.put))}::myschema.sector
          )
          on conflict ("id")
          do update set
            favourite_football_club_id = EXCLUDED.favourite_football_club_id,
            "name" = EXCLUDED."name",
            nick_name = EXCLUDED.nick_name,
            blog_url = EXCLUDED.blog_url,
            email = EXCLUDED.email,
            phone = EXCLUDED.phone,
            likes_pizza = EXCLUDED.likes_pizza,
            marital_status_id = EXCLUDED.marital_status_id,
            work_email = EXCLUDED.work_email,
            sector = EXCLUDED.sector
          returning "id", favourite_football_club_id, "name", nick_name, blog_url, email, phone, likes_pizza, marital_status_id, work_email, sector
       """.query(PersonRow.read).unique
  }
}
