/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
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

class ProductmodelillustrationRepoImpl extends ProductmodelillustrationRepo {
  override def delete(compositeId: ProductmodelillustrationId): ConnectionIO[Boolean] = {
    sql"""delete from production.productmodelillustration where "productmodelid" = ${fromWrite(compositeId.productmodelid)(Write.fromPut(ProductmodelId.put))} AND "illustrationid" = ${fromWrite(compositeId.illustrationid)(Write.fromPut(IllustrationId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    DeleteBuilder("production.productmodelillustration", ProductmodelillustrationFields)
  }
  override def insert(unsaved: ProductmodelillustrationRow): ConnectionIO[ProductmodelillustrationRow] = {
    sql"""insert into production.productmodelillustration("productmodelid", "illustrationid", "modifieddate")
          values (${fromWrite(unsaved.productmodelid)(Write.fromPut(ProductmodelId.put))}::int4, ${fromWrite(unsaved.illustrationid)(Write.fromPut(IllustrationId.put))}::int4, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "productmodelid", "illustrationid", "modifieddate"::text
       """.query(ProductmodelillustrationRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductmodelillustrationRow], batchSize: Int): ConnectionIO[Long] = {
    doobie.postgres.syntax.fragment.toFragmentOps(sql"""COPY production.productmodelillustration("productmodelid", "illustrationid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(ProductmodelillustrationRow.text)
  }
  override def insert(unsaved: ProductmodelillustrationRowUnsaved): ConnectionIO[ProductmodelillustrationRow] = {
    val fs = List(
      Some((Fragment.const(s""""productmodelid""""), fr"${fromWrite(unsaved.productmodelid)(Write.fromPut(ProductmodelId.put))}::int4")),
      Some((Fragment.const(s""""illustrationid""""), fr"${fromWrite(unsaved.illustrationid)(Write.fromPut(IllustrationId.put))}::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productmodelillustration default values
            returning "productmodelid", "illustrationid", "modifieddate"::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productmodelillustration(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning "productmodelid", "illustrationid", "modifieddate"::text
         """
    }
    q.query(ProductmodelillustrationRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductmodelillustrationRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    doobie.postgres.syntax.fragment.toFragmentOps(sql"""COPY production.productmodelillustration("productmodelid", "illustrationid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(ProductmodelillustrationRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    SelectBuilderSql("production.productmodelillustration", ProductmodelillustrationFields, ProductmodelillustrationRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductmodelillustrationRow] = {
    sql"""select "productmodelid", "illustrationid", "modifieddate"::text from production.productmodelillustration""".query(ProductmodelillustrationRow.read).stream
  }
  override def selectById(compositeId: ProductmodelillustrationId): ConnectionIO[Option[ProductmodelillustrationRow]] = {
    sql"""select "productmodelid", "illustrationid", "modifieddate"::text from production.productmodelillustration where "productmodelid" = ${fromWrite(compositeId.productmodelid)(Write.fromPut(ProductmodelId.put))} AND "illustrationid" = ${fromWrite(compositeId.illustrationid)(Write.fromPut(IllustrationId.put))}""".query(ProductmodelillustrationRow.read).option
  }
  override def update(row: ProductmodelillustrationRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productmodelillustration
          set "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "productmodelid" = ${fromWrite(compositeId.productmodelid)(Write.fromPut(ProductmodelId.put))} AND "illustrationid" = ${fromWrite(compositeId.illustrationid)(Write.fromPut(IllustrationId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    UpdateBuilder("production.productmodelillustration", ProductmodelillustrationFields, ProductmodelillustrationRow.read)
  }
  override def upsert(unsaved: ProductmodelillustrationRow): ConnectionIO[ProductmodelillustrationRow] = {
    sql"""insert into production.productmodelillustration("productmodelid", "illustrationid", "modifieddate")
          values (
            ${fromWrite(unsaved.productmodelid)(Write.fromPut(ProductmodelId.put))}::int4,
            ${fromWrite(unsaved.illustrationid)(Write.fromPut(IllustrationId.put))}::int4,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("productmodelid", "illustrationid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productmodelid", "illustrationid", "modifieddate"::text
       """.query(ProductmodelillustrationRow.read).unique
  }
}
