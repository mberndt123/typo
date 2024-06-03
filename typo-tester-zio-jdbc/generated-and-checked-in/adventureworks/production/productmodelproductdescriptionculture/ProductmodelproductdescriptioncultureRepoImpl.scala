/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelproductdescriptionculture

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.culture.CultureId
import adventureworks.production.productdescription.ProductdescriptionId
import adventureworks.production.productmodel.ProductmodelId
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

class ProductmodelproductdescriptioncultureRepoImpl extends ProductmodelproductdescriptioncultureRepo {
  override def delete: DeleteBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    DeleteBuilder("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields.structure)
  }
  override def deleteById(compositeId: ProductmodelproductdescriptioncultureId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.productmodelproductdescriptionculture where "productmodelid" = ${Segment.paramSegment(compositeId.productmodelid)(ProductmodelId.setter)} AND "productdescriptionid" = ${Segment.paramSegment(compositeId.productdescriptionid)(ProductdescriptionId.setter)} AND "cultureid" = ${Segment.paramSegment(compositeId.cultureid)(CultureId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId]): ZIO[ZConnection, Throwable, Long] = {
    val productmodelid = compositeIds.map(_.productmodelid)
    val productdescriptionid = compositeIds.map(_.productdescriptionid)
    val cultureid = compositeIds.map(_.cultureid)
    sql"""delete
          from production.productmodelproductdescriptionculture
          where ("productmodelid", "productdescriptionid", "cultureid")
          in (select unnest(${productmodelid}), unnest(${productdescriptionid}), unnest(${cultureid}))
       """.delete
    
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRow): ZIO[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow] = {
    sql"""insert into production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate")
          values (${Segment.paramSegment(unsaved.productmodelid)(ProductmodelId.setter)}::int4, ${Segment.paramSegment(unsaved.productdescriptionid)(ProductdescriptionId.setter)}::int4, ${Segment.paramSegment(unsaved.cultureid)(CultureId.setter)}::bpchar, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
       """.insertReturning(using ProductmodelproductdescriptioncultureRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRowUnsaved): ZIO[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow] = {
    val fs = List(
      Some((sql""""productmodelid"""", sql"${Segment.paramSegment(unsaved.productmodelid)(ProductmodelId.setter)}::int4")),
      Some((sql""""productdescriptionid"""", sql"${Segment.paramSegment(unsaved.productdescriptionid)(ProductdescriptionId.setter)}::int4")),
      Some((sql""""cultureid"""", sql"${Segment.paramSegment(unsaved.cultureid)(CultureId.setter)}::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productmodelproductdescriptionculture default values
            returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.productmodelproductdescriptionculture($names) values ($values) returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text"""
    }
    q.insertReturning(using ProductmodelproductdescriptioncultureRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductmodelproductdescriptioncultureRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelproductdescriptioncultureRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductmodelproductdescriptioncultureRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    SelectBuilderSql("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields.structure, ProductmodelproductdescriptioncultureRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow] = {
    sql"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text from production.productmodelproductdescriptionculture""".query(using ProductmodelproductdescriptioncultureRow.jdbcDecoder).selectStream()
  }
  override def selectById(compositeId: ProductmodelproductdescriptioncultureId): ZIO[ZConnection, Throwable, Option[ProductmodelproductdescriptioncultureRow]] = {
    sql"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text from production.productmodelproductdescriptionculture where "productmodelid" = ${Segment.paramSegment(compositeId.productmodelid)(ProductmodelId.setter)} AND "productdescriptionid" = ${Segment.paramSegment(compositeId.productdescriptionid)(ProductdescriptionId.setter)} AND "cultureid" = ${Segment.paramSegment(compositeId.cultureid)(CultureId.setter)}""".query(using ProductmodelproductdescriptioncultureRow.jdbcDecoder).selectOne
  }
  override def selectByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId]): ZStream[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow] = {
    val productmodelid = compositeIds.map(_.productmodelid)
    val productdescriptionid = compositeIds.map(_.productdescriptionid)
    val cultureid = compositeIds.map(_.cultureid)
    sql"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
          from production.productmodelproductdescriptionculture
          where ("productmodelid", "productdescriptionid", "cultureid")
          in (select unnest(${productmodelid}), unnest(${productdescriptionid}), unnest(${cultureid}))
       """.query(using ProductmodelproductdescriptioncultureRow.jdbcDecoder).selectStream()
    
  }
  override def selectByIdsTracked(compositeIds: Array[ProductmodelproductdescriptioncultureId]): ZIO[ZConnection, Throwable, Map[ProductmodelproductdescriptioncultureId, ProductmodelproductdescriptioncultureRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    UpdateBuilder("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields.structure, ProductmodelproductdescriptioncultureRow.jdbcDecoder)
  }
  override def update(row: ProductmodelproductdescriptioncultureRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productmodelproductdescriptionculture
          set "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productmodelid" = ${Segment.paramSegment(compositeId.productmodelid)(ProductmodelId.setter)} AND "productdescriptionid" = ${Segment.paramSegment(compositeId.productdescriptionid)(ProductdescriptionId.setter)} AND "cultureid" = ${Segment.paramSegment(compositeId.cultureid)(CultureId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: ProductmodelproductdescriptioncultureRow): ZIO[ZConnection, Throwable, UpdateResult[ProductmodelproductdescriptioncultureRow]] = {
    sql"""insert into production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.productmodelid)(ProductmodelId.setter)}::int4,
            ${Segment.paramSegment(unsaved.productdescriptionid)(ProductdescriptionId.setter)}::int4,
            ${Segment.paramSegment(unsaved.cultureid)(CultureId.setter)}::bpchar,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("productmodelid", "productdescriptionid", "cultureid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text""".insertReturning(using ProductmodelproductdescriptioncultureRow.jdbcDecoder)
  }
}
