/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdocument

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.document.DocumentId
import adventureworks.production.product.ProductId
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

object ProductdocumentRepoImpl extends ProductdocumentRepo {
  override def delete(compositeId: ProductdocumentId): ConnectionIO[Boolean] = {
    sql"""delete from production.productdocument where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "documentnode" = ${fromWrite(compositeId.documentnode)(Write.fromPut(DocumentId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductdocumentFields, ProductdocumentRow] = {
    DeleteBuilder("production.productdocument", ProductdocumentFields)
  }
  override def insert(unsaved: ProductdocumentRow): ConnectionIO[ProductdocumentRow] = {
    sql"""insert into production.productdocument("productid", "modifieddate", "documentnode")
          values (${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.documentnode)(Write.fromPut(DocumentId.put))})
          returning "productid", "modifieddate"::text, "documentnode"
       """.query(ProductdocumentRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductdocumentRow], batchSize: Int): ConnectionIO[Long] = {
    doobie.postgres.syntax.fragment.toFragmentOps(sql"""COPY production.productdocument("productid", "modifieddate", "documentnode") FROM STDIN""").copyIn(unsaved, batchSize)(ProductdocumentRow.text)
  }
  override def insert(unsaved: ProductdocumentRowUnsaved): ConnectionIO[ProductdocumentRow] = {
    val fs = List(
      Some((Fragment.const(s""""productid""""), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      },
      unsaved.documentnode match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""documentnode""""), fr"${fromWrite(value: DocumentId)(Write.fromPut(DocumentId.put))}"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productdocument default values
            returning "productid", "modifieddate"::text, "documentnode"
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productdocument(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning "productid", "modifieddate"::text, "documentnode"
         """
    }
    q.query(ProductdocumentRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductdocumentRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    doobie.postgres.syntax.fragment.toFragmentOps(sql"""COPY production.productdocument("productid", "modifieddate", "documentnode") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(ProductdocumentRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductdocumentFields, ProductdocumentRow] = {
    SelectBuilderSql("production.productdocument", ProductdocumentFields, ProductdocumentRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductdocumentRow] = {
    sql"""select "productid", "modifieddate"::text, "documentnode" from production.productdocument""".query(ProductdocumentRow.read).stream
  }
  override def selectById(compositeId: ProductdocumentId): ConnectionIO[Option[ProductdocumentRow]] = {
    sql"""select "productid", "modifieddate"::text, "documentnode" from production.productdocument where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "documentnode" = ${fromWrite(compositeId.documentnode)(Write.fromPut(DocumentId.put))}""".query(ProductdocumentRow.read).option
  }
  override def update(row: ProductdocumentRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productdocument
          set "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "documentnode" = ${fromWrite(compositeId.documentnode)(Write.fromPut(DocumentId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[ProductdocumentFields, ProductdocumentRow] = {
    UpdateBuilder("production.productdocument", ProductdocumentFields, ProductdocumentRow.read)
  }
  override def upsert(unsaved: ProductdocumentRow): ConnectionIO[ProductdocumentRow] = {
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
       """.query(ProductdocumentRow.read).unique
  }
}
