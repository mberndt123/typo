/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productmodelproductdescriptionculture

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.culture.CultureId
import adventureworks.production.productdescription.ProductdescriptionId
import adventureworks.production.productmodel.ProductmodelId
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

class ProductmodelproductdescriptioncultureRepoImpl extends ProductmodelproductdescriptioncultureRepo {
  override def delete: DeleteBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    DeleteBuilder("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields.structure)
  }
  override def deleteById(compositeId: ProductmodelproductdescriptioncultureId): ConnectionIO[Boolean] = {
    sql"""delete from production.productmodelproductdescriptionculture where "productmodelid" = ${fromWrite(compositeId.productmodelid)(Write.fromPut(ProductmodelId.put))} AND "productdescriptionid" = ${fromWrite(compositeId.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))} AND "cultureid" = ${fromWrite(compositeId.cultureid)(Write.fromPut(CultureId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId]): ConnectionIO[Int] = {
    val productmodelid = compositeIds.map(_.productmodelid)
    val productdescriptionid = compositeIds.map(_.productdescriptionid)
    val cultureid = compositeIds.map(_.cultureid)
    sql"""delete
          from production.productmodelproductdescriptionculture
          where ("productmodelid", "productdescriptionid", "cultureid")
          in (select unnest(${fromWrite(productmodelid)(Write.fromPut(ProductmodelId.arrayPut))}), unnest(${fromWrite(productdescriptionid)(Write.fromPut(ProductdescriptionId.arrayPut))}), unnest(${fromWrite(cultureid)(Write.fromPut(CultureId.arrayPut))}))
       """.update.run
    
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRow): ConnectionIO[ProductmodelproductdescriptioncultureRow] = {
    sql"""insert into production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate")
          values (${fromWrite(unsaved.productmodelid)(Write.fromPut(ProductmodelId.put))}::int4, ${fromWrite(unsaved.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}::int4, ${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
       """.query(using ProductmodelproductdescriptioncultureRow.read).unique
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRowUnsaved): ConnectionIO[ProductmodelproductdescriptioncultureRow] = {
    val fs = List(
      Some((Fragment.const0(s""""productmodelid""""), fr"${fromWrite(unsaved.productmodelid)(Write.fromPut(ProductmodelId.put))}::int4")),
      Some((Fragment.const0(s""""productdescriptionid""""), fr"${fromWrite(unsaved.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}::int4")),
      Some((Fragment.const0(s""""cultureid""""), fr"${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productmodelproductdescriptionculture default values
            returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.productmodelproductdescriptionculture(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
         """
    }
    q.query(using ProductmodelproductdescriptioncultureRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductmodelproductdescriptioncultureRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using ProductmodelproductdescriptioncultureRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductmodelproductdescriptioncultureRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using ProductmodelproductdescriptioncultureRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    SelectBuilderSql("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields.structure, ProductmodelproductdescriptioncultureRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductmodelproductdescriptioncultureRow] = {
    sql"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text from production.productmodelproductdescriptionculture""".query(using ProductmodelproductdescriptioncultureRow.read).stream
  }
  override def selectById(compositeId: ProductmodelproductdescriptioncultureId): ConnectionIO[Option[ProductmodelproductdescriptioncultureRow]] = {
    sql"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text from production.productmodelproductdescriptionculture where "productmodelid" = ${fromWrite(compositeId.productmodelid)(Write.fromPut(ProductmodelId.put))} AND "productdescriptionid" = ${fromWrite(compositeId.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))} AND "cultureid" = ${fromWrite(compositeId.cultureid)(Write.fromPut(CultureId.put))}""".query(using ProductmodelproductdescriptioncultureRow.read).option
  }
  override def selectByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId]): Stream[ConnectionIO, ProductmodelproductdescriptioncultureRow] = {
    val productmodelid = compositeIds.map(_.productmodelid)
    val productdescriptionid = compositeIds.map(_.productdescriptionid)
    val cultureid = compositeIds.map(_.cultureid)
    sql"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
          from production.productmodelproductdescriptionculture
          where ("productmodelid", "productdescriptionid", "cultureid") 
          in (select unnest(${fromWrite(productmodelid)(Write.fromPut(ProductmodelId.arrayPut))}), unnest(${fromWrite(productdescriptionid)(Write.fromPut(ProductdescriptionId.arrayPut))}), unnest(${fromWrite(cultureid)(Write.fromPut(CultureId.arrayPut))}))
       """.query(using ProductmodelproductdescriptioncultureRow.read).stream
    
  }
  override def selectByIdsTracked(compositeIds: Array[ProductmodelproductdescriptioncultureId]): ConnectionIO[Map[ProductmodelproductdescriptioncultureId, ProductmodelproductdescriptioncultureRow]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    UpdateBuilder("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields.structure, ProductmodelproductdescriptioncultureRow.read)
  }
  override def update(row: ProductmodelproductdescriptioncultureRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productmodelproductdescriptionculture
          set "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "productmodelid" = ${fromWrite(compositeId.productmodelid)(Write.fromPut(ProductmodelId.put))} AND "productdescriptionid" = ${fromWrite(compositeId.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))} AND "cultureid" = ${fromWrite(compositeId.cultureid)(Write.fromPut(CultureId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductmodelproductdescriptioncultureRow): ConnectionIO[ProductmodelproductdescriptioncultureRow] = {
    sql"""insert into production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate")
          values (
            ${fromWrite(unsaved.productmodelid)(Write.fromPut(ProductmodelId.put))}::int4,
            ${fromWrite(unsaved.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}::int4,
            ${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("productmodelid", "productdescriptionid", "cultureid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
       """.query(using ProductmodelproductdescriptioncultureRow.read).unique
  }
  override def upsertBatch(unsaved: List[ProductmodelproductdescriptioncultureRow]): Stream[ConnectionIO, ProductmodelproductdescriptioncultureRow] = {
    Update[ProductmodelproductdescriptioncultureRow](
      s"""insert into production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate")
          values (?::int4,?::int4,?::bpchar,?::timestamp)
          on conflict ("productmodelid", "productdescriptionid", "cultureid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text"""
    )(using ProductmodelproductdescriptioncultureRow.write)
    .updateManyWithGeneratedKeys[ProductmodelproductdescriptioncultureRow]("productmodelid", "productdescriptionid", "cultureid", "modifieddate")(unsaved)(using catsStdInstancesForList, ProductmodelproductdescriptioncultureRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, ProductmodelproductdescriptioncultureRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table productmodelproductdescriptionculture_TEMP (like production.productmodelproductdescriptionculture) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy productmodelproductdescriptionculture_TEMP("productmodelid", "productdescriptionid", "cultureid", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using ProductmodelproductdescriptioncultureRow.text)
      res <- sql"""insert into production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate")
                   select * from productmodelproductdescriptionculture_TEMP
                   on conflict ("productmodelid", "productdescriptionid", "cultureid")
                   do update set
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table productmodelproductdescriptionculture_TEMP;""".update.run
    } yield res
  }
}
