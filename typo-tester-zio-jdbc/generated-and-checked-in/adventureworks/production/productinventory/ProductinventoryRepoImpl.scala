/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object ProductinventoryRepoImpl extends ProductinventoryRepo {
  override def delete(compositeId: ProductinventoryId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.productinventory where "productid" = ${Segment.paramSegment(compositeId.productid)(ProductId.setter)} AND "locationid" = ${Segment.paramSegment(compositeId.locationid)(LocationId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductinventoryFields, ProductinventoryRow] = {
    DeleteBuilder("production.productinventory", ProductinventoryFields)
  }
  override def insert(unsaved: ProductinventoryRow): ZIO[ZConnection, Throwable, ProductinventoryRow] = {
    sql"""insert into production.productinventory("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4, ${Segment.paramSegment(unsaved.locationid)(LocationId.setter)}::int2, ${Segment.paramSegment(unsaved.shelf)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.bin)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.quantity)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text
       """.insertReturning(ProductinventoryRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductinventoryRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productinventory("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductinventoryRow.text)
  }
  override def insert(unsaved: ProductinventoryRowUnsaved): ZIO[ZConnection, Throwable, ProductinventoryRow] = {
    val fs = List(
      Some((sql""""productid"""", sql"${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4")),
      Some((sql""""locationid"""", sql"${Segment.paramSegment(unsaved.locationid)(LocationId.setter)}::int2")),
      Some((sql""""shelf"""", sql"${Segment.paramSegment(unsaved.shelf)(Setter.stringSetter)}")),
      Some((sql""""bin"""", sql"${Segment.paramSegment(unsaved.bin)(TypoShort.setter)}::int2")),
      unsaved.quantity match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""quantity"""", sql"${Segment.paramSegment(value: TypoShort)(TypoShort.setter)}::int2"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""rowguid"""", sql"${Segment.paramSegment(value: TypoUUID)(TypoUUID.setter)}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productinventory default values
            returning "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.productinventory($names) values ($values) returning "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(ProductinventoryRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductinventoryRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productinventory("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductinventoryRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductinventoryFields, ProductinventoryRow] = {
    SelectBuilderSql("production.productinventory", ProductinventoryFields, ProductinventoryRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductinventoryRow] = {
    sql"""select "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text from production.productinventory""".query(ProductinventoryRow.jdbcDecoder).selectStream
  }
  override def selectById(compositeId: ProductinventoryId): ZIO[ZConnection, Throwable, Option[ProductinventoryRow]] = {
    sql"""select "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text from production.productinventory where "productid" = ${Segment.paramSegment(compositeId.productid)(ProductId.setter)} AND "locationid" = ${Segment.paramSegment(compositeId.locationid)(LocationId.setter)}""".query(ProductinventoryRow.jdbcDecoder).selectOne
  }
  override def update(row: ProductinventoryRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productinventory
          set "shelf" = ${Segment.paramSegment(row.shelf)(Setter.stringSetter)},
              "bin" = ${Segment.paramSegment(row.bin)(TypoShort.setter)}::int2,
              "quantity" = ${Segment.paramSegment(row.quantity)(TypoShort.setter)}::int2,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productid" = ${Segment.paramSegment(compositeId.productid)(ProductId.setter)} AND "locationid" = ${Segment.paramSegment(compositeId.locationid)(LocationId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[ProductinventoryFields, ProductinventoryRow] = {
    UpdateBuilder("production.productinventory", ProductinventoryFields, ProductinventoryRow.jdbcDecoder)
  }
  override def upsert(unsaved: ProductinventoryRow): ZIO[ZConnection, Throwable, UpdateResult[ProductinventoryRow]] = {
    sql"""insert into production.productinventory("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4,
            ${Segment.paramSegment(unsaved.locationid)(LocationId.setter)}::int2,
            ${Segment.paramSegment(unsaved.shelf)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.bin)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.quantity)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("productid", "locationid")
          do update set
            "shelf" = EXCLUDED."shelf",
            "bin" = EXCLUDED."bin",
            "quantity" = EXCLUDED."quantity",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text""".insertReturning(ProductinventoryRow.jdbcDecoder)
  }
}
