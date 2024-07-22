/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productcategory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
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

class ProductcategoryRepoImpl extends ProductcategoryRepo {
  override def delete: DeleteBuilder[ProductcategoryFields, ProductcategoryRow] = {
    DeleteBuilder("production.productcategory", ProductcategoryFields.structure)
  }
  override def deleteById(productcategoryid: ProductcategoryId): ConnectionIO[Boolean] = {
    sql"""delete from production.productcategory where "productcategoryid" = ${fromWrite(productcategoryid)(Write.fromPut(ProductcategoryId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(productcategoryids: Array[ProductcategoryId]): ConnectionIO[Int] = {
    sql"""delete from production.productcategory where "productcategoryid" = ANY(${fromWrite(productcategoryids)(Write.fromPut(ProductcategoryId.arrayPut))})""".update.run
  }
  override def insert(unsaved: ProductcategoryRow): ConnectionIO[ProductcategoryRow] = {
    sql"""insert into production.productcategory("productcategoryid", "name", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.productcategoryid)(Write.fromPut(ProductcategoryId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "productcategoryid", "name", "rowguid", "modifieddate"::text
       """.query(using ProductcategoryRow.read).unique
  }
  override def insert(unsaved: ProductcategoryRowUnsaved): ConnectionIO[ProductcategoryRow] = {
    val fs = List(
      Some((Fragment.const0(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      unsaved.productcategoryid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""productcategoryid""""), fr"${fromWrite(value: ProductcategoryId)(Write.fromPut(ProductcategoryId.put))}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productcategory default values
            returning "productcategoryid", "name", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.productcategory(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "productcategoryid", "name", "rowguid", "modifieddate"::text
         """
    }
    q.query(using ProductcategoryRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductcategoryRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productcategory("productcategoryid", "name", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using ProductcategoryRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductcategoryRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productcategory("name", "productcategoryid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using ProductcategoryRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductcategoryFields, ProductcategoryRow] = {
    SelectBuilderSql("production.productcategory", ProductcategoryFields.structure, ProductcategoryRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductcategoryRow] = {
    sql"""select "productcategoryid", "name", "rowguid", "modifieddate"::text from production.productcategory""".query(using ProductcategoryRow.read).stream
  }
  override def selectById(productcategoryid: ProductcategoryId): ConnectionIO[Option[ProductcategoryRow]] = {
    sql"""select "productcategoryid", "name", "rowguid", "modifieddate"::text from production.productcategory where "productcategoryid" = ${fromWrite(productcategoryid)(Write.fromPut(ProductcategoryId.put))}""".query(using ProductcategoryRow.read).option
  }
  override def selectByIds(productcategoryids: Array[ProductcategoryId]): Stream[ConnectionIO, ProductcategoryRow] = {
    sql"""select "productcategoryid", "name", "rowguid", "modifieddate"::text from production.productcategory where "productcategoryid" = ANY(${fromWrite(productcategoryids)(Write.fromPut(ProductcategoryId.arrayPut))})""".query(using ProductcategoryRow.read).stream
  }
  override def selectByIdsTracked(productcategoryids: Array[ProductcategoryId]): ConnectionIO[Map[ProductcategoryId, ProductcategoryRow]] = {
    selectByIds(productcategoryids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.productcategoryid, x)).toMap
      productcategoryids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ProductcategoryFields, ProductcategoryRow] = {
    UpdateBuilder("production.productcategory", ProductcategoryFields.structure, ProductcategoryRow.read)
  }
  override def update(row: ProductcategoryRow): ConnectionIO[Boolean] = {
    val productcategoryid = row.productcategoryid
    sql"""update production.productcategory
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "productcategoryid" = ${fromWrite(productcategoryid)(Write.fromPut(ProductcategoryId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductcategoryRow): ConnectionIO[ProductcategoryRow] = {
    sql"""insert into production.productcategory("productcategoryid", "name", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.productcategoryid)(Write.fromPut(ProductcategoryId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("productcategoryid")
          do update set
            "name" = EXCLUDED."name",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productcategoryid", "name", "rowguid", "modifieddate"::text
       """.query(using ProductcategoryRow.read).unique
  }
  override def upsertBatch(unsaved: List[ProductcategoryRow]): Stream[ConnectionIO, ProductcategoryRow] = {
    Update[ProductcategoryRow](
      s"""insert into production.productcategory("productcategoryid", "name", "rowguid", "modifieddate")
          values (?::int4,?::varchar,?::uuid,?::timestamp)
          on conflict ("productcategoryid")
          do update set
            "name" = EXCLUDED."name",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productcategoryid", "name", "rowguid", "modifieddate"::text"""
    )(using ProductcategoryRow.write)
    .updateManyWithGeneratedKeys[ProductcategoryRow]("productcategoryid", "name", "rowguid", "modifieddate")(unsaved)(using catsStdInstancesForList, ProductcategoryRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, ProductcategoryRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table productcategory_TEMP (like production.productcategory) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy productcategory_TEMP("productcategoryid", "name", "rowguid", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using ProductcategoryRow.text)
      res <- sql"""insert into production.productcategory("productcategoryid", "name", "rowguid", "modifieddate")
                   select * from productcategory_TEMP
                   on conflict ("productcategoryid")
                   do update set
                     "name" = EXCLUDED."name",
                     "rowguid" = EXCLUDED."rowguid",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table productcategory_TEMP;""".update.run
    } yield res
  }
}
