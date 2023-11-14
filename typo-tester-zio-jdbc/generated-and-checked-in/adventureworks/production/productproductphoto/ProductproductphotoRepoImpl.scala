/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productproductphoto

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import adventureworks.public.Flag
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class ProductproductphotoRepoImpl extends ProductproductphotoRepo {
  override def delete(compositeId: ProductproductphotoId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.productproductphoto where "productid" = ${Segment.paramSegment(compositeId.productid)(ProductId.setter)} AND "productphotoid" = ${Segment.paramSegment(compositeId.productphotoid)(ProductphotoId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductproductphotoFields, ProductproductphotoRow] = {
    DeleteBuilder("production.productproductphoto", ProductproductphotoFields)
  }
  override def insert(unsaved: ProductproductphotoRow): ZIO[ZConnection, Throwable, ProductproductphotoRow] = {
    sql"""insert into production.productproductphoto("productid", "productphotoid", "primary", "modifieddate")
          values (${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4, ${Segment.paramSegment(unsaved.productphotoid)(ProductphotoId.setter)}::int4, ${Segment.paramSegment(unsaved.primary)(Flag.setter)}::bool, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "productid", "productphotoid", "primary", "modifieddate"::text
       """.insertReturning(ProductproductphotoRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductproductphotoRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productproductphoto("productid", "productphotoid", "primary", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductproductphotoRow.text)
  }
  override def insert(unsaved: ProductproductphotoRowUnsaved): ZIO[ZConnection, Throwable, ProductproductphotoRow] = {
    val fs = List(
      Some((sql""""productid"""", sql"${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4")),
      Some((sql""""productphotoid"""", sql"${Segment.paramSegment(unsaved.productphotoid)(ProductphotoId.setter)}::int4")),
      unsaved.primary match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""primary"""", sql"${Segment.paramSegment(value: Flag)(Flag.setter)}::bool"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productproductphoto default values
            returning "productid", "productphotoid", "primary", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.productproductphoto($names) values ($values) returning "productid", "productphotoid", "primary", "modifieddate"::text"""
    }
    q.insertReturning(ProductproductphotoRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductproductphotoRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productproductphoto("productid", "productphotoid", "primary", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductproductphotoRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductproductphotoFields, ProductproductphotoRow] = {
    SelectBuilderSql("production.productproductphoto", ProductproductphotoFields, ProductproductphotoRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductproductphotoRow] = {
    sql"""select "productid", "productphotoid", "primary", "modifieddate"::text from production.productproductphoto""".query(ProductproductphotoRow.jdbcDecoder).selectStream
  }
  override def selectById(compositeId: ProductproductphotoId): ZIO[ZConnection, Throwable, Option[ProductproductphotoRow]] = {
    sql"""select "productid", "productphotoid", "primary", "modifieddate"::text from production.productproductphoto where "productid" = ${Segment.paramSegment(compositeId.productid)(ProductId.setter)} AND "productphotoid" = ${Segment.paramSegment(compositeId.productphotoid)(ProductphotoId.setter)}""".query(ProductproductphotoRow.jdbcDecoder).selectOne
  }
  override def update(row: ProductproductphotoRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productproductphoto
          set "primary" = ${Segment.paramSegment(row.primary)(Flag.setter)}::bool,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productid" = ${Segment.paramSegment(compositeId.productid)(ProductId.setter)} AND "productphotoid" = ${Segment.paramSegment(compositeId.productphotoid)(ProductphotoId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[ProductproductphotoFields, ProductproductphotoRow] = {
    UpdateBuilder("production.productproductphoto", ProductproductphotoFields, ProductproductphotoRow.jdbcDecoder)
  }
  override def upsert(unsaved: ProductproductphotoRow): ZIO[ZConnection, Throwable, UpdateResult[ProductproductphotoRow]] = {
    sql"""insert into production.productproductphoto("productid", "productphotoid", "primary", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4,
            ${Segment.paramSegment(unsaved.productphotoid)(ProductphotoId.setter)}::int4,
            ${Segment.paramSegment(unsaved.primary)(Flag.setter)}::bool,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("productid", "productphotoid")
          do update set
            "primary" = EXCLUDED."primary",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "productphotoid", "primary", "modifieddate"::text""".insertReturning(ProductproductphotoRow.jdbcDecoder)
  }
}
