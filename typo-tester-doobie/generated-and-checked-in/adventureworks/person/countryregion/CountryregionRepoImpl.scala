/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class CountryregionRepoImpl extends CountryregionRepo {
  override def delete(countryregioncode: CountryregionId): ConnectionIO[Boolean] = {
    sql"""delete from person.countryregion where "countryregioncode" = ${fromWrite(countryregioncode)(Write.fromPut(CountryregionId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[CountryregionFields, CountryregionRow] = {
    DeleteBuilder("person.countryregion", CountryregionFields)
  }
  override def insert(unsaved: CountryregionRow): ConnectionIO[CountryregionRow] = {
    sql"""insert into person.countryregion("countryregioncode", "name", "modifieddate")
          values (${fromWrite(unsaved.countryregioncode)(Write.fromPut(CountryregionId.put))}, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "countryregioncode", "name", "modifieddate"::text
       """.query(CountryregionRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, CountryregionRow], batchSize: Int): ConnectionIO[Long] = {
    doobie.postgres.syntax.fragment.toFragmentOps(sql"""COPY person.countryregion("countryregioncode", "name", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(CountryregionRow.text)
  }
  override def insert(unsaved: CountryregionRowUnsaved): ConnectionIO[CountryregionRow] = {
    val fs = List(
      Some((Fragment.const(s""""countryregioncode""""), fr"${fromWrite(unsaved.countryregioncode)(Write.fromPut(CountryregionId.put))}")),
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.countryregion default values
            returning "countryregioncode", "name", "modifieddate"::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.countryregion(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning "countryregioncode", "name", "modifieddate"::text
         """
    }
    q.query(CountryregionRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CountryregionRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    doobie.postgres.syntax.fragment.toFragmentOps(sql"""COPY person.countryregion("countryregioncode", "name", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(CountryregionRowUnsaved.text)
  }
  override def select: SelectBuilder[CountryregionFields, CountryregionRow] = {
    SelectBuilderSql("person.countryregion", CountryregionFields, CountryregionRow.read)
  }
  override def selectAll: Stream[ConnectionIO, CountryregionRow] = {
    sql"""select "countryregioncode", "name", "modifieddate"::text from person.countryregion""".query(CountryregionRow.read).stream
  }
  override def selectById(countryregioncode: CountryregionId): ConnectionIO[Option[CountryregionRow]] = {
    sql"""select "countryregioncode", "name", "modifieddate"::text from person.countryregion where "countryregioncode" = ${fromWrite(countryregioncode)(Write.fromPut(CountryregionId.put))}""".query(CountryregionRow.read).option
  }
  override def selectByIds(countryregioncodes: Array[CountryregionId]): Stream[ConnectionIO, CountryregionRow] = {
    sql"""select "countryregioncode", "name", "modifieddate"::text from person.countryregion where "countryregioncode" = ANY(${countryregioncodes})""".query(CountryregionRow.read).stream
  }
  override def update(row: CountryregionRow): ConnectionIO[Boolean] = {
    val countryregioncode = row.countryregioncode
    sql"""update person.countryregion
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "countryregioncode" = ${fromWrite(countryregioncode)(Write.fromPut(CountryregionId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[CountryregionFields, CountryregionRow] = {
    UpdateBuilder("person.countryregion", CountryregionFields, CountryregionRow.read)
  }
  override def upsert(unsaved: CountryregionRow): ConnectionIO[CountryregionRow] = {
    sql"""insert into person.countryregion("countryregioncode", "name", "modifieddate")
          values (
            ${fromWrite(unsaved.countryregioncode)(Write.fromPut(CountryregionId.put))},
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("countryregioncode")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "countryregioncode", "name", "modifieddate"::text
       """.query(CountryregionRow.read).unique
  }
}
