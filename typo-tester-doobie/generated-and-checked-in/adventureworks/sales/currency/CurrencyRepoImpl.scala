/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.currency;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.public.Name;
import cats.instances.list.catsStdInstancesForList;
import doobie.free.connection.ConnectionIO;
import doobie.postgres.syntax.FragmentOps;
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite;
import doobie.syntax.string.toSqlInterpolator;
import doobie.util.Write;
import doobie.util.fragment.Fragment;
import doobie.util.update.Update;
import fs2.Stream;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import typo.dsl.UpdateBuilder;

class CurrencyRepoImpl extends CurrencyRepo {
  def delete: DeleteBuilder[CurrencyFields, CurrencyRow] = DeleteBuilder("sales.currency", CurrencyFields.structure)
  def deleteById(currencycode: CurrencyId): ConnectionIO[Boolean] = sql"""delete from sales.currency where "currencycode" = ${fromWrite(currencycode)(Write.fromPut(CurrencyId.put))}""".update.run.map(_ > 0)
  def deleteByIds(currencycodes: Array[CurrencyId]): ConnectionIO[Int] = sql"""delete from sales.currency where "currencycode" = ANY(${fromWrite(currencycodes)(Write.fromPut(CurrencyId.arrayPut))})""".update.run
  def insert(unsaved: CurrencyRow): ConnectionIO[CurrencyRow] = {
    sql"""insert into sales.currency("currencycode", "name", "modifieddate")
          values (${fromWrite(unsaved.currencycode)(Write.fromPut(CurrencyId.put))}::bpchar, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "currencycode", "name", "modifieddate"::text
       """.query(using CurrencyRow.read).unique
  }
  def insert(unsaved: CurrencyRowUnsaved): ConnectionIO[CurrencyRow] = {
    val fs = List(
      Some((Fragment.const0(s""""currencycode""""), fr"${fromWrite(unsaved.currencycode)(Write.fromPut(CurrencyId.put))}::bpchar")),
                      Some((Fragment.const0(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
    }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.currency default values
                            returning "currencycode", "name", "modifieddate"::text
                         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into sales.currency(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
                            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
                            returning "currencycode", "name", "modifieddate"::text
                         """
    }
    q.query(using CurrencyRow.read).unique
  
  }
  def insertStreaming(unsaved: Stream[ConnectionIO, CurrencyRow], batchSize: Int = 10000): ConnectionIO[Long] = new FragmentOps(sql"""COPY sales.currency("currencycode", "name", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using CurrencyRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CurrencyRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = new FragmentOps(sql"""COPY sales.currency("currencycode", "name", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using CurrencyRowUnsaved.text)
  def select: SelectBuilder[CurrencyFields, CurrencyRow] = SelectBuilderSql("sales.currency", CurrencyFields.structure, CurrencyRow.read)
  def selectAll: Stream[ConnectionIO, CurrencyRow] = sql"""select "currencycode", "name", "modifieddate"::text from sales.currency""".query(using CurrencyRow.read).stream
  def selectById(currencycode: CurrencyId): ConnectionIO[Option[CurrencyRow]] = sql"""select "currencycode", "name", "modifieddate"::text from sales.currency where "currencycode" = ${fromWrite(currencycode)(Write.fromPut(CurrencyId.put))}""".query(using CurrencyRow.read).option
  def selectByIds(currencycodes: Array[CurrencyId]): Stream[ConnectionIO, CurrencyRow] = sql"""select "currencycode", "name", "modifieddate"::text from sales.currency where "currencycode" = ANY(${fromWrite(currencycodes)(Write.fromPut(CurrencyId.arrayPut))})""".query(using CurrencyRow.read).stream
  def selectByIdsTracked(currencycodes: Array[CurrencyId]): ConnectionIO[Map[CurrencyId, CurrencyRow]] = {
    selectByIds(currencycodes).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.currencycode, x)).toMap
      currencycodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[CurrencyFields, CurrencyRow] = UpdateBuilder("sales.currency", CurrencyFields.structure, CurrencyRow.read)
  def update(row: CurrencyRow): ConnectionIO[Boolean] = {
    val currencycode = row.currencycode
    sql"""update sales.currency
                          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
                              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
                          where "currencycode" = ${fromWrite(currencycode)(Write.fromPut(CurrencyId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  def upsert(unsaved: CurrencyRow): ConnectionIO[CurrencyRow] = {
    sql"""insert into sales.currency("currencycode", "name", "modifieddate")
          values (
            ${fromWrite(unsaved.currencycode)(Write.fromPut(CurrencyId.put))}::bpchar,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("currencycode")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "currencycode", "name", "modifieddate"::text
       """.query(using CurrencyRow.read).unique
  }
  def upsertBatch(unsaved: List[CurrencyRow]): Stream[ConnectionIO, CurrencyRow] = {
    Update[CurrencyRow](
      s"""insert into sales.currency("currencycode", "name", "modifieddate")
          values (?::bpchar,?::varchar,?::timestamp)
          on conflict ("currencycode")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "currencycode", "name", "modifieddate"::text"""
    )(using CurrencyRow.write)
    .updateManyWithGeneratedKeys[CurrencyRow]("currencycode", "name", "modifieddate")(unsaved)(using catsStdInstancesForList, CurrencyRow.read)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, CurrencyRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table currency_TEMP (like sales.currency) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy currency_TEMP("currencycode", "name", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using CurrencyRow.text)
      res <- sql"""insert into sales.currency("currencycode", "name", "modifieddate")
                   select * from currency_TEMP
                   on conflict ("currencycode")
                   do update set
                     "name" = EXCLUDED."name",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table currency_TEMP;""".update.run
    } yield res
  }
}