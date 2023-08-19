/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.public.Name
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object ProductsubcategoryRepoImpl extends ProductsubcategoryRepo {
  override def delete(productsubcategoryid: ProductsubcategoryId): ConnectionIO[Boolean] = {
    sql"delete from production.productsubcategory where productsubcategoryid = ${fromWrite(productsubcategoryid)(Write.fromPut(ProductsubcategoryId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    DeleteBuilder("production.productsubcategory", ProductsubcategoryFields)
  }
  override def insert(unsaved: ProductsubcategoryRow): ConnectionIO[ProductsubcategoryRow] = {
    sql"""insert into production.productsubcategory(productsubcategoryid, productcategoryid, "name", rowguid, modifieddate)
          values (${fromWrite(unsaved.productsubcategoryid)(Write.fromPut(ProductsubcategoryId.put))}::int4, ${fromWrite(unsaved.productcategoryid)(Write.fromPut(ProductcategoryId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name", ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
       """.query(ProductsubcategoryRow.read).unique
  }
  override def insert(unsaved: ProductsubcategoryRowUnsaved): ConnectionIO[ProductsubcategoryRow] = {
    val fs = List(
      Some((Fragment.const(s"productcategoryid"), fr"${fromWrite(unsaved.productcategoryid)(Write.fromPut(ProductcategoryId.put))}::int4")),
      Some((Fragment.const(s""""name""""), fr"""${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name"""")),
      unsaved.productsubcategoryid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"productsubcategoryid"), fr"${fromWrite(value: ProductsubcategoryId)(Write.fromPut(ProductsubcategoryId.put))}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${fromWrite(value: UUID)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productsubcategory default values
            returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productsubcategory(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
         """
    }
    q.query(ProductsubcategoryRow.read).unique
    
  }
  override def select: SelectBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    SelectBuilderSql("production.productsubcategory", ProductsubcategoryFields, ProductsubcategoryRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductsubcategoryRow] = {
    sql"""select productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text from production.productsubcategory""".query(ProductsubcategoryRow.read).stream
  }
  override def selectById(productsubcategoryid: ProductsubcategoryId): ConnectionIO[Option[ProductsubcategoryRow]] = {
    sql"""select productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text from production.productsubcategory where productsubcategoryid = ${fromWrite(productsubcategoryid)(Write.fromPut(ProductsubcategoryId.put))}""".query(ProductsubcategoryRow.read).option
  }
  override def selectByIds(productsubcategoryids: Array[ProductsubcategoryId]): Stream[ConnectionIO, ProductsubcategoryRow] = {
    sql"""select productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text from production.productsubcategory where productsubcategoryid = ANY(${productsubcategoryids})""".query(ProductsubcategoryRow.read).stream
  }
  override def update(row: ProductsubcategoryRow): ConnectionIO[Boolean] = {
    val productsubcategoryid = row.productsubcategoryid
    sql"""update production.productsubcategory
          set productcategoryid = ${fromWrite(row.productcategoryid)(Write.fromPut(ProductcategoryId.put))}::int4,
              "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::"public"."Name",
              rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where productsubcategoryid = ${fromWrite(productsubcategoryid)(Write.fromPut(ProductsubcategoryId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    UpdateBuilder("production.productsubcategory", ProductsubcategoryFields, ProductsubcategoryRow.read)
  }
  override def upsert(unsaved: ProductsubcategoryRow): ConnectionIO[ProductsubcategoryRow] = {
    sql"""insert into production.productsubcategory(productsubcategoryid, productcategoryid, "name", rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.productsubcategoryid)(Write.fromPut(ProductsubcategoryId.put))}::int4,
            ${fromWrite(unsaved.productcategoryid)(Write.fromPut(ProductcategoryId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::"public"."Name",
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (productsubcategoryid)
          do update set
            productcategoryid = EXCLUDED.productcategoryid,
            "name" = EXCLUDED."name",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
       """.query(ProductsubcategoryRow.read).unique
  }
}
