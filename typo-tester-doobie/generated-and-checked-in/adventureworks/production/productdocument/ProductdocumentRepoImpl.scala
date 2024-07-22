/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productdocument;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.production.document.DocumentId;
import adventureworks.production.product.ProductId;
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

class ProductdocumentRepoImpl extends ProductdocumentRepo {
  def delete: DeleteBuilder[ProductdocumentFields, ProductdocumentRow] = DeleteBuilder("production.productdocument", ProductdocumentFields.structure)
  def deleteById(compositeId: ProductdocumentId): ConnectionIO[Boolean] = sql"""delete from production.productdocument where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "documentnode" = ${fromWrite(compositeId.documentnode)(Write.fromPut(DocumentId.put))}""".update.run.map(_ > 0)
  def deleteByIds(compositeIds: Array[ProductdocumentId]): ConnectionIO[Int] = {
    val productid = compositeIds.map(_.productid)
    val documentnode = compositeIds.map(_.documentnode)
    sql"""delete
          from production.productdocument
          where ("productid", "documentnode")
          in (select unnest(${fromWrite(productid)(Write.fromPut(ProductId.arrayPut))}), unnest(${fromWrite(documentnode)(Write.fromPut(DocumentId.arrayPut))}))
       """.update.run
  
  }
  def insert(unsaved: ProductdocumentRow): ConnectionIO[ProductdocumentRow] = {
    sql"""insert into production.productdocument("productid", "modifieddate", "documentnode")
          values (${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.documentnode)(Write.fromPut(DocumentId.put))})
          returning "productid", "modifieddate"::text, "documentnode"
       """.query(using ProductdocumentRow.read).unique
  }
  def insert(unsaved: ProductdocumentRowUnsaved): ConnectionIO[ProductdocumentRow] = {
    val fs = List(
      Some((Fragment.const0(s""""productid""""), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
    },
    unsaved.documentnode match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((Fragment.const0(s""""documentnode""""), fr"${fromWrite(value: DocumentId)(Write.fromPut(DocumentId.put))}"))
    }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productdocument default values
                            returning "productid", "modifieddate"::text, "documentnode"
                         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.productdocument(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
                            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
                            returning "productid", "modifieddate"::text, "documentnode"
                         """
    }
    q.query(using ProductdocumentRow.read).unique
  
  }
  def insertStreaming(unsaved: Stream[ConnectionIO, ProductdocumentRow], batchSize: Int = 10000): ConnectionIO[Long] = new FragmentOps(sql"""COPY production.productdocument("productid", "modifieddate", "documentnode") FROM STDIN""").copyIn(unsaved, batchSize)(using ProductdocumentRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductdocumentRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = new FragmentOps(sql"""COPY production.productdocument("productid", "modifieddate", "documentnode") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using ProductdocumentRowUnsaved.text)
  def select: SelectBuilder[ProductdocumentFields, ProductdocumentRow] = SelectBuilderSql("production.productdocument", ProductdocumentFields.structure, ProductdocumentRow.read)
  def selectAll: Stream[ConnectionIO, ProductdocumentRow] = sql"""select "productid", "modifieddate"::text, "documentnode" from production.productdocument""".query(using ProductdocumentRow.read).stream
  def selectById(compositeId: ProductdocumentId): ConnectionIO[Option[ProductdocumentRow]] = sql"""select "productid", "modifieddate"::text, "documentnode" from production.productdocument where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "documentnode" = ${fromWrite(compositeId.documentnode)(Write.fromPut(DocumentId.put))}""".query(using ProductdocumentRow.read).option
  def selectByIds(compositeIds: Array[ProductdocumentId]): Stream[ConnectionIO, ProductdocumentRow] = {
    val productid = compositeIds.map(_.productid)
    val documentnode = compositeIds.map(_.documentnode)
    sql"""select "productid", "modifieddate"::text, "documentnode"
          from production.productdocument
          where ("productid", "documentnode")
          in (select unnest(${fromWrite(productid)(Write.fromPut(ProductId.arrayPut))}), unnest(${fromWrite(documentnode)(Write.fromPut(DocumentId.arrayPut))}))
       """.query(using ProductdocumentRow.read).stream
  
  }
  def selectByIdsTracked(compositeIds: Array[ProductdocumentId]): ConnectionIO[Map[ProductdocumentId, ProductdocumentRow]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[ProductdocumentFields, ProductdocumentRow] = UpdateBuilder("production.productdocument", ProductdocumentFields.structure, ProductdocumentRow.read)
  def update(row: ProductdocumentRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productdocument
                          set "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
                          where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "documentnode" = ${fromWrite(compositeId.documentnode)(Write.fromPut(DocumentId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  def upsert(unsaved: ProductdocumentRow): ConnectionIO[ProductdocumentRow] = {
    sql"""insert into production.productdocument("productid", "modifieddate", "documentnode")
          values (
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.documentnode)(Write.fromPut(DocumentId.put))}
          )
          on conflict ("productid", "documentnode")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "modifieddate"::text, "documentnode"
       """.query(using ProductdocumentRow.read).unique
  }
  def upsertBatch(unsaved: List[ProductdocumentRow]): Stream[ConnectionIO, ProductdocumentRow] = {
    Update[ProductdocumentRow](
      s"""insert into production.productdocument("productid", "modifieddate", "documentnode")
          values (?::int4,?::timestamp,?)
          on conflict ("productid", "documentnode")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "modifieddate"::text, "documentnode""""
    )(using ProductdocumentRow.write)
    .updateManyWithGeneratedKeys[ProductdocumentRow]("productid", "modifieddate", "documentnode")(unsaved)(using catsStdInstancesForList, ProductdocumentRow.read)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, ProductdocumentRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table productdocument_TEMP (like production.productdocument) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy productdocument_TEMP("productid", "modifieddate", "documentnode") from stdin""").copyIn(unsaved, batchSize)(using ProductdocumentRow.text)
      res <- sql"""insert into production.productdocument("productid", "modifieddate", "documentnode")
                   select * from productdocument_TEMP
                   on conflict ("productid", "documentnode")
                   do update set
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table productdocument_TEMP;""".update.run
    } yield res
  }
}