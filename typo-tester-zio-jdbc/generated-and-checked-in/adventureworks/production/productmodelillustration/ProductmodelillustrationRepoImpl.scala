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

class ProductmodelillustrationRepoImpl extends ProductmodelillustrationRepo {
  override def delete(compositeId: ProductmodelillustrationId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.productmodelillustration where "productmodelid" = ${Segment.paramSegment(compositeId.productmodelid)(ProductmodelId.setter)} AND "illustrationid" = ${Segment.paramSegment(compositeId.illustrationid)(IllustrationId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    DeleteBuilder("production.productmodelillustration", ProductmodelillustrationFields)
  }
  override def insert(unsaved: ProductmodelillustrationRow): ZIO[ZConnection, Throwable, ProductmodelillustrationRow] = {
    sql"""insert into production.productmodelillustration("productmodelid", "illustrationid", "modifieddate")
          values (${Segment.paramSegment(unsaved.productmodelid)(ProductmodelId.setter)}::int4, ${Segment.paramSegment(unsaved.illustrationid)(IllustrationId.setter)}::int4, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "productmodelid", "illustrationid", "modifieddate"::text
       """.insertReturning(ProductmodelillustrationRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelillustrationRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productmodelillustration("productmodelid", "illustrationid", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductmodelillustrationRow.text)
  }
  override def insert(unsaved: ProductmodelillustrationRowUnsaved): ZIO[ZConnection, Throwable, ProductmodelillustrationRow] = {
    val fs = List(
      Some((sql""""productmodelid"""", sql"${Segment.paramSegment(unsaved.productmodelid)(ProductmodelId.setter)}::int4")),
      Some((sql""""illustrationid"""", sql"${Segment.paramSegment(unsaved.illustrationid)(IllustrationId.setter)}::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productmodelillustration default values
            returning "productmodelid", "illustrationid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.productmodelillustration($names) values ($values) returning "productmodelid", "illustrationid", "modifieddate"::text"""
    }
    q.insertReturning(ProductmodelillustrationRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelillustrationRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productmodelillustration("productmodelid", "illustrationid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductmodelillustrationRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    SelectBuilderSql("production.productmodelillustration", ProductmodelillustrationFields, ProductmodelillustrationRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductmodelillustrationRow] = {
    sql"""select "productmodelid", "illustrationid", "modifieddate"::text from production.productmodelillustration""".query(ProductmodelillustrationRow.jdbcDecoder).selectStream
  }
  override def selectById(compositeId: ProductmodelillustrationId): ZIO[ZConnection, Throwable, Option[ProductmodelillustrationRow]] = {
    sql"""select "productmodelid", "illustrationid", "modifieddate"::text from production.productmodelillustration where "productmodelid" = ${Segment.paramSegment(compositeId.productmodelid)(ProductmodelId.setter)} AND "illustrationid" = ${Segment.paramSegment(compositeId.illustrationid)(IllustrationId.setter)}""".query(ProductmodelillustrationRow.jdbcDecoder).selectOne
  }
  override def update(row: ProductmodelillustrationRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productmodelillustration
          set "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productmodelid" = ${Segment.paramSegment(compositeId.productmodelid)(ProductmodelId.setter)} AND "illustrationid" = ${Segment.paramSegment(compositeId.illustrationid)(IllustrationId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    UpdateBuilder("production.productmodelillustration", ProductmodelillustrationFields, ProductmodelillustrationRow.jdbcDecoder)
  }
  override def upsert(unsaved: ProductmodelillustrationRow): ZIO[ZConnection, Throwable, UpdateResult[ProductmodelillustrationRow]] = {
    sql"""insert into production.productmodelillustration("productmodelid", "illustrationid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.productmodelid)(ProductmodelId.setter)}::int4,
            ${Segment.paramSegment(unsaved.illustrationid)(IllustrationId.setter)}::int4,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("productmodelid", "illustrationid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productmodelid", "illustrationid", "modifieddate"::text""".insertReturning(ProductmodelillustrationRow.jdbcDecoder)
  }
}
