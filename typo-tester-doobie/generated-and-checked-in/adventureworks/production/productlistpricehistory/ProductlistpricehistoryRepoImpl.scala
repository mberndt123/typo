/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productlistpricehistory;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.production.product.ProductId;
import cats.instances.list.catsStdInstancesForList;
import doobie.free.connection.ConnectionIO;
import doobie.postgres.syntax.FragmentOps;
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite;
import doobie.syntax.string.toSqlInterpolator;
import doobie.util.Write;
import doobie.util.fragment.Fragment;
import doobie.util.meta.Meta;
import doobie.util.update.Update;
import fs2.Stream;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import typo.dsl.UpdateBuilder;

class ProductlistpricehistoryRepoImpl extends ProductlistpricehistoryRepo {
  def delete: DeleteBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = DeleteBuilder("production.productlistpricehistory", ProductlistpricehistoryFields.structure)
  def deleteById(compositeId: ProductlistpricehistoryId): ConnectionIO[Boolean] = sql"""delete from production.productlistpricehistory where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "startdate" = ${fromWrite(compositeId.startdate)(Write.fromPut(TypoLocalDateTime.put))}""".update.run.map(_ > 0)
  def deleteByIds(compositeIds: Array[ProductlistpricehistoryId]): ConnectionIO[Int] = {
    val productid = compositeIds.map(_.productid)
    val startdate = compositeIds.map(_.startdate)
    sql"""delete
          from production.productlistpricehistory
          where ("productid", "startdate")
          in (select unnest(${fromWrite(productid)(Write.fromPut(ProductId.arrayPut))}), unnest(${fromWrite(startdate)(Write.fromPut(TypoLocalDateTime.arrayPut))}))
       """.update.run
  
  }
  def insert(unsaved: ProductlistpricehistoryRow): ConnectionIO[ProductlistpricehistoryRow] = {
    sql"""insert into production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate")
          values (${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
       """.query(using ProductlistpricehistoryRow.read).unique
  }
  def insert(unsaved: ProductlistpricehistoryRowUnsaved): ConnectionIO[ProductlistpricehistoryRow] = {
    val fs = List(
      Some((Fragment.const0(s""""productid""""), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
                      Some((Fragment.const0(s""""startdate""""), fr"${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
                      Some((Fragment.const0(s""""enddate""""), fr"${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
                      Some((Fragment.const0(s""""listprice""""), fr"${fromWrite(unsaved.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric")),
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
    }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productlistpricehistory default values
                            returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
                         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.productlistpricehistory(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
                            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
                            returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
                         """
    }
    q.query(using ProductlistpricehistoryRow.read).unique
  
  }
  def insertStreaming(unsaved: Stream[ConnectionIO, ProductlistpricehistoryRow], batchSize: Int = 10000): ConnectionIO[Long] = new FragmentOps(sql"""COPY production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using ProductlistpricehistoryRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductlistpricehistoryRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = new FragmentOps(sql"""COPY production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using ProductlistpricehistoryRowUnsaved.text)
  def select: SelectBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = SelectBuilderSql("production.productlistpricehistory", ProductlistpricehistoryFields.structure, ProductlistpricehistoryRow.read)
  def selectAll: Stream[ConnectionIO, ProductlistpricehistoryRow] = sql"""select "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text from production.productlistpricehistory""".query(using ProductlistpricehistoryRow.read).stream
  def selectById(compositeId: ProductlistpricehistoryId): ConnectionIO[Option[ProductlistpricehistoryRow]] = sql"""select "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text from production.productlistpricehistory where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "startdate" = ${fromWrite(compositeId.startdate)(Write.fromPut(TypoLocalDateTime.put))}""".query(using ProductlistpricehistoryRow.read).option
  def selectByIds(compositeIds: Array[ProductlistpricehistoryId]): Stream[ConnectionIO, ProductlistpricehistoryRow] = {
    val productid = compositeIds.map(_.productid)
    val startdate = compositeIds.map(_.startdate)
    sql"""select "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
          from production.productlistpricehistory
          where ("productid", "startdate")
          in (select unnest(${fromWrite(productid)(Write.fromPut(ProductId.arrayPut))}), unnest(${fromWrite(startdate)(Write.fromPut(TypoLocalDateTime.arrayPut))}))
       """.query(using ProductlistpricehistoryRow.read).stream
  
  }
  def selectByIdsTracked(compositeIds: Array[ProductlistpricehistoryId]): ConnectionIO[Map[ProductlistpricehistoryId, ProductlistpricehistoryRow]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = UpdateBuilder("production.productlistpricehistory", ProductlistpricehistoryFields.structure, ProductlistpricehistoryRow.read)
  def update(row: ProductlistpricehistoryRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productlistpricehistory
                          set "enddate" = ${fromWrite(row.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
                              "listprice" = ${fromWrite(row.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
                              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
                          where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "startdate" = ${fromWrite(compositeId.startdate)(Write.fromPut(TypoLocalDateTime.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  def upsert(unsaved: ProductlistpricehistoryRow): ConnectionIO[ProductlistpricehistoryRow] = {
    sql"""insert into production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate")
          values (
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("productid", "startdate")
          do update set
            "enddate" = EXCLUDED."enddate",
            "listprice" = EXCLUDED."listprice",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
       """.query(using ProductlistpricehistoryRow.read).unique
  }
  def upsertBatch(unsaved: List[ProductlistpricehistoryRow]): Stream[ConnectionIO, ProductlistpricehistoryRow] = {
    Update[ProductlistpricehistoryRow](
      s"""insert into production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate")
          values (?::int4,?::timestamp,?::timestamp,?::numeric,?::timestamp)
          on conflict ("productid", "startdate")
          do update set
            "enddate" = EXCLUDED."enddate",
            "listprice" = EXCLUDED."listprice",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text"""
    )(using ProductlistpricehistoryRow.write)
    .updateManyWithGeneratedKeys[ProductlistpricehistoryRow]("productid", "startdate", "enddate", "listprice", "modifieddate")(unsaved)(using catsStdInstancesForList, ProductlistpricehistoryRow.read)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, ProductlistpricehistoryRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table productlistpricehistory_TEMP (like production.productlistpricehistory) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy productlistpricehistory_TEMP("productid", "startdate", "enddate", "listprice", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using ProductlistpricehistoryRow.text)
      res <- sql"""insert into production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate")
                   select * from productlistpricehistory_TEMP
                   on conflict ("productid", "startdate")
                   do update set
                     "enddate" = EXCLUDED."enddate",
                     "listprice" = EXCLUDED."listprice",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table productlistpricehistory_TEMP;""".update.run
    } yield res
  }
}