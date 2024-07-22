/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded.myschema.person;

import cats.data.NonEmptyList;
import cats.instances.list.catsStdInstancesForList;
import doobie.free.connection.ConnectionIO;
import doobie.free.connection.pure;
import doobie.postgres.syntax.FragmentOps;
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite;
import doobie.syntax.string.toSqlInterpolator;
import doobie.util.Write;
import doobie.util.fragment.Fragment;
import doobie.util.fragments;
import doobie.util.meta.Meta;
import doobie.util.update.Update;
import fs2.Stream;
import testdb.hardcoded.customtypes.Defaulted;
import testdb.hardcoded.myschema.Number;
import testdb.hardcoded.myschema.Sector;
import testdb.hardcoded.myschema.football_club.FootballClubId;
import testdb.hardcoded.myschema.marital_status.MaritalStatusId;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import typo.dsl.UpdateBuilder;

class PersonRepoImpl extends PersonRepo {
  def delete: DeleteBuilder[PersonFields, PersonRow] = DeleteBuilder("myschema.person", PersonFields.structure)
  def deleteById(id: PersonId): ConnectionIO[Boolean] = sql"""delete from myschema.person where "id" = ${fromWrite(id)(Write.fromPut(PersonId.put))}""".update.run.map(_ > 0)
  def deleteByIds(ids: Array[PersonId]): ConnectionIO[Int] = sql"""delete from myschema.person where "id" = ANY(${fromWrite(ids)(Write.fromPut(PersonId.arrayPut))})""".update.run
  def insert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    sql"""insert into myschema.person("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number")
          values (${fromWrite(unsaved.id)(Write.fromPut(PersonId.put))}::int8, ${fromWrite(unsaved.favouriteFootballClubId)(Write.fromPut(FootballClubId.put))}, ${fromWrite(unsaved.name)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.nickName)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.blogUrl)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.email)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.phone)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.likesPizza)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.maritalStatusId)(Write.fromPut(MaritalStatusId.put))}, ${fromWrite(unsaved.workEmail)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.sector)(Write.fromPut(Sector.put))}::myschema.sector, ${fromWrite(unsaved.favoriteNumber)(Write.fromPut(Number.put))}::myschema.number)
          returning "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
       """.query(using PersonRow.read).unique
  }
  def insert(unsaved: PersonRowUnsaved): ConnectionIO[PersonRow] = {
    val fs = List(
      Some((Fragment.const0(s""""favourite_football_club_id""""), fr"${fromWrite(unsaved.favouriteFootballClubId)(Write.fromPut(FootballClubId.put))}")),
                      Some((Fragment.const0(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Meta.StringMeta.put))}")),
                      Some((Fragment.const0(s""""nick_name""""), fr"${fromWrite(unsaved.nickName)(Write.fromPutOption(Meta.StringMeta.put))}")),
                      Some((Fragment.const0(s""""blog_url""""), fr"${fromWrite(unsaved.blogUrl)(Write.fromPutOption(Meta.StringMeta.put))}")),
                      Some((Fragment.const0(s""""email""""), fr"${fromWrite(unsaved.email)(Write.fromPut(Meta.StringMeta.put))}")),
                      Some((Fragment.const0(s""""phone""""), fr"${fromWrite(unsaved.phone)(Write.fromPut(Meta.StringMeta.put))}")),
                      Some((Fragment.const0(s""""likes_pizza""""), fr"${fromWrite(unsaved.likesPizza)(Write.fromPut(Meta.BooleanMeta.put))}")),
                      Some((Fragment.const0(s""""work_email""""), fr"${fromWrite(unsaved.workEmail)(Write.fromPutOption(Meta.StringMeta.put))}")),
    unsaved.id match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((Fragment.const0(s""""id""""), fr"${fromWrite(value: PersonId)(Write.fromPut(PersonId.put))}::int8"))
    },
    unsaved.maritalStatusId match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((Fragment.const0(s""""marital_status_id""""), fr"${fromWrite(value: MaritalStatusId)(Write.fromPut(MaritalStatusId.put))}"))
    },
    unsaved.sector match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((Fragment.const0(s""""sector""""), fr"${fromWrite(value: Sector)(Write.fromPut(Sector.put))}::myschema.sector"))
    },
    unsaved.favoriteNumber match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((Fragment.const0(s""""favorite_number""""), fr"${fromWrite(value: Number)(Write.fromPut(Number.put))}::myschema.number"))
    }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into myschema.person default values
                            returning "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
                         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into myschema.person(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
                            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
                            returning "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
                         """
    }
    q.query(using PersonRow.read).unique
  
  }
  def insertStreaming(unsaved: Stream[ConnectionIO, PersonRow], batchSize: Int = 10000): ConnectionIO[Long] = new FragmentOps(sql"""COPY myschema.person("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number") FROM STDIN""").copyIn(unsaved, batchSize)(using PersonRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PersonRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = new FragmentOps(sql"""COPY myschema.person("favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "work_email", "id", "marital_status_id", "sector", "favorite_number") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using PersonRowUnsaved.text)
  def select: SelectBuilder[PersonFields, PersonRow] = SelectBuilderSql("myschema.person", PersonFields.structure, PersonRow.read)
  def selectAll: Stream[ConnectionIO, PersonRow] = sql"""select "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number" from myschema.person""".query(using PersonRow.read).stream
  def selectByFieldValues(fieldValues: List[PersonFieldValue[?]]): Stream[ConnectionIO, PersonRow] = {
    val where = fragments.whereAndOpt(
      fieldValues.map {
        case PersonFieldValue.id(value) => fr""""id" = ${fromWrite(value)(Write.fromPut(PersonId.put))}"""
        case PersonFieldValue.favouriteFootballClubId(value) => fr""""favourite_football_club_id" = ${fromWrite(value)(Write.fromPut(FootballClubId.put))}"""
        case PersonFieldValue.name(value) => fr""""name" = ${fromWrite(value)(Write.fromPut(Meta.StringMeta.put))}"""
        case PersonFieldValue.nickName(value) => fr""""nick_name" = ${fromWrite(value)(Write.fromPutOption(Meta.StringMeta.put))}"""
        case PersonFieldValue.blogUrl(value) => fr""""blog_url" = ${fromWrite(value)(Write.fromPutOption(Meta.StringMeta.put))}"""
        case PersonFieldValue.email(value) => fr""""email" = ${fromWrite(value)(Write.fromPut(Meta.StringMeta.put))}"""
        case PersonFieldValue.phone(value) => fr""""phone" = ${fromWrite(value)(Write.fromPut(Meta.StringMeta.put))}"""
        case PersonFieldValue.likesPizza(value) => fr""""likes_pizza" = ${fromWrite(value)(Write.fromPut(Meta.BooleanMeta.put))}"""
        case PersonFieldValue.maritalStatusId(value) => fr""""marital_status_id" = ${fromWrite(value)(Write.fromPut(MaritalStatusId.put))}"""
        case PersonFieldValue.workEmail(value) => fr""""work_email" = ${fromWrite(value)(Write.fromPutOption(Meta.StringMeta.put))}"""
        case PersonFieldValue.sector(value) => fr""""sector" = ${fromWrite(value)(Write.fromPut(Sector.put))}"""
        case PersonFieldValue.favoriteNumber(value) => fr""""favorite_number" = ${fromWrite(value)(Write.fromPut(Number.put))}"""
      }
    )
    sql"""select "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number" from myschema.person $where""".query(using PersonRow.read).stream
  }
  def selectById(id: PersonId): ConnectionIO[Option[PersonRow]] = sql"""select "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number" from myschema.person where "id" = ${fromWrite(id)(Write.fromPut(PersonId.put))}""".query(using PersonRow.read).option
  def selectByIds(ids: Array[PersonId]): Stream[ConnectionIO, PersonRow] = sql"""select "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number" from myschema.person where "id" = ANY(${fromWrite(ids)(Write.fromPut(PersonId.arrayPut))})""".query(using PersonRow.read).stream
  def selectByIdsTracked(ids: Array[PersonId]): ConnectionIO[Map[PersonId, PersonRow]] = {
    selectByIds(ids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.id, x)).toMap
      ids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[PersonFields, PersonRow] = UpdateBuilder("myschema.person", PersonFields.structure, PersonRow.read)
  def update(row: PersonRow): ConnectionIO[Boolean] = {
    val id = row.id
    sql"""update myschema.person
                          set "favourite_football_club_id" = ${fromWrite(row.favouriteFootballClubId)(Write.fromPut(FootballClubId.put))},
                              "name" = ${fromWrite(row.name)(Write.fromPut(Meta.StringMeta.put))},
                              "nick_name" = ${fromWrite(row.nickName)(Write.fromPutOption(Meta.StringMeta.put))},
                              "blog_url" = ${fromWrite(row.blogUrl)(Write.fromPutOption(Meta.StringMeta.put))},
                              "email" = ${fromWrite(row.email)(Write.fromPut(Meta.StringMeta.put))},
                              "phone" = ${fromWrite(row.phone)(Write.fromPut(Meta.StringMeta.put))},
                              "likes_pizza" = ${fromWrite(row.likesPizza)(Write.fromPut(Meta.BooleanMeta.put))},
                              "marital_status_id" = ${fromWrite(row.maritalStatusId)(Write.fromPut(MaritalStatusId.put))},
                              "work_email" = ${fromWrite(row.workEmail)(Write.fromPutOption(Meta.StringMeta.put))},
                              "sector" = ${fromWrite(row.sector)(Write.fromPut(Sector.put))}::myschema.sector,
                              "favorite_number" = ${fromWrite(row.favoriteNumber)(Write.fromPut(Number.put))}::myschema.number
                          where "id" = ${fromWrite(id)(Write.fromPut(PersonId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  def updateFieldValues(id: PersonId, fieldValues: List[PersonFieldValue[?]]): ConnectionIO[Boolean] = {
    NonEmptyList.fromList(fieldValues) match {
      case None => pure(false)
      case Some(nonEmpty) =>
        val updates = fragments.set(
          nonEmpty.map {
            case PersonFieldValue.id(value) => fr""""id" = ${fromWrite(value)(Write.fromPut(PersonId.put))}::int8"""
            case PersonFieldValue.favouriteFootballClubId(value) => fr""""favourite_football_club_id" = ${fromWrite(value)(Write.fromPut(FootballClubId.put))}"""
            case PersonFieldValue.name(value) => fr""""name" = ${fromWrite(value)(Write.fromPut(Meta.StringMeta.put))}"""
            case PersonFieldValue.nickName(value) => fr""""nick_name" = ${fromWrite(value)(Write.fromPutOption(Meta.StringMeta.put))}"""
            case PersonFieldValue.blogUrl(value) => fr""""blog_url" = ${fromWrite(value)(Write.fromPutOption(Meta.StringMeta.put))}"""
            case PersonFieldValue.email(value) => fr""""email" = ${fromWrite(value)(Write.fromPut(Meta.StringMeta.put))}"""
            case PersonFieldValue.phone(value) => fr""""phone" = ${fromWrite(value)(Write.fromPut(Meta.StringMeta.put))}"""
            case PersonFieldValue.likesPizza(value) => fr""""likes_pizza" = ${fromWrite(value)(Write.fromPut(Meta.BooleanMeta.put))}"""
            case PersonFieldValue.maritalStatusId(value) => fr""""marital_status_id" = ${fromWrite(value)(Write.fromPut(MaritalStatusId.put))}"""
            case PersonFieldValue.workEmail(value) => fr""""work_email" = ${fromWrite(value)(Write.fromPutOption(Meta.StringMeta.put))}"""
            case PersonFieldValue.sector(value) => fr""""sector" = ${fromWrite(value)(Write.fromPut(Sector.put))}::myschema.sector"""
            case PersonFieldValue.favoriteNumber(value) => fr""""favorite_number" = ${fromWrite(value)(Write.fromPut(Number.put))}::myschema.number"""
          }
        )
        sql"""update myschema.person
              $updates
              where "id" = ${fromWrite(id)(Write.fromPut(PersonId.put))}""".update.run.map(_ > 0)
    }
  }
  def upsert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    sql"""insert into myschema.person("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number")
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
            ${fromWrite(unsaved.sector)(Write.fromPut(Sector.put))}::myschema.sector,
            ${fromWrite(unsaved.favoriteNumber)(Write.fromPut(Number.put))}::myschema.number
          )
          on conflict ("id")
          do update set
            "favourite_football_club_id" = EXCLUDED."favourite_football_club_id",
            "name" = EXCLUDED."name",
            "nick_name" = EXCLUDED."nick_name",
            "blog_url" = EXCLUDED."blog_url",
            "email" = EXCLUDED."email",
            "phone" = EXCLUDED."phone",
            "likes_pizza" = EXCLUDED."likes_pizza",
            "marital_status_id" = EXCLUDED."marital_status_id",
            "work_email" = EXCLUDED."work_email",
            "sector" = EXCLUDED."sector",
            "favorite_number" = EXCLUDED."favorite_number"
          returning "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
       """.query(using PersonRow.read).unique
  }
  def upsertBatch(unsaved: List[PersonRow]): Stream[ConnectionIO, PersonRow] = {
    Update[PersonRow](
      s"""insert into myschema.person("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number")
          values (?::int8,?,?,?,?,?,?,?,?,?,?::myschema.sector,?::myschema.number)
          on conflict ("id")
          do update set
            "favourite_football_club_id" = EXCLUDED."favourite_football_club_id",
            "name" = EXCLUDED."name",
            "nick_name" = EXCLUDED."nick_name",
            "blog_url" = EXCLUDED."blog_url",
            "email" = EXCLUDED."email",
            "phone" = EXCLUDED."phone",
            "likes_pizza" = EXCLUDED."likes_pizza",
            "marital_status_id" = EXCLUDED."marital_status_id",
            "work_email" = EXCLUDED."work_email",
            "sector" = EXCLUDED."sector",
            "favorite_number" = EXCLUDED."favorite_number"
          returning "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number""""
    )(using PersonRow.write)
    .updateManyWithGeneratedKeys[PersonRow]("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number")(unsaved)(using catsStdInstancesForList, PersonRow.read)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, PersonRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table person_TEMP (like myschema.person) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy person_TEMP("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number") from stdin""").copyIn(unsaved, batchSize)(using PersonRow.text)
      res <- sql"""insert into myschema.person("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number")
                   select * from person_TEMP
                   on conflict ("id")
                   do update set
                     "favourite_football_club_id" = EXCLUDED."favourite_football_club_id",
                     "name" = EXCLUDED."name",
                     "nick_name" = EXCLUDED."nick_name",
                     "blog_url" = EXCLUDED."blog_url",
                     "email" = EXCLUDED."email",
                     "phone" = EXCLUDED."phone",
                     "likes_pizza" = EXCLUDED."likes_pizza",
                     "marital_status_id" = EXCLUDED."marital_status_id",
                     "work_email" = EXCLUDED."work_email",
                     "sector" = EXCLUDED."sector",
                     "favorite_number" = EXCLUDED."favorite_number"
                   ;
                   drop table person_TEMP;""".update.run
    } yield res
  }
}