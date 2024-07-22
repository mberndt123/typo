/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productmodelproductdescriptionculture;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.production.culture.CultureId;
import adventureworks.production.productdescription.ProductdescriptionId;
import adventureworks.production.productmodel.ProductmodelId;
import adventureworks.streamingInsert;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import typo.dsl.UpdateBuilder;
import zio.ZIO;
import zio.jdbc.SqlFragment;
import zio.jdbc.SqlFragment.Segment;
import zio.jdbc.UpdateResult;
import zio.jdbc.ZConnection;
import zio.jdbc.sqlInterpolator;
import zio.stream.ZStream;

class ProductmodelproductdescriptioncultureRepoImpl extends ProductmodelproductdescriptioncultureRepo {
  def delete: DeleteBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = DeleteBuilder("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields.structure)
  def deleteById(compositeId: ProductmodelproductdescriptioncultureId): ZIO[ZConnection, Throwable, Boolean] = sql"""delete from production.productmodelproductdescriptionculture where "productmodelid" = ${Segment.paramSegment(compositeId.productmodelid)(ProductmodelId.setter)} AND "productdescriptionid" = ${Segment.paramSegment(compositeId.productdescriptionid)(ProductdescriptionId.setter)} AND "cultureid" = ${Segment.paramSegment(compositeId.cultureid)(CultureId.setter)}""".delete.map(_ > 0)
  def deleteByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId]): ZIO[ZConnection, Throwable, Long] = {
    val productmodelid = compositeIds.map(_.productmodelid)
    val productdescriptionid = compositeIds.map(_.productdescriptionid)
    val cultureid = compositeIds.map(_.cultureid)
    sql"""delete
          from production.productmodelproductdescriptionculture
          where ("productmodelid", "productdescriptionid", "cultureid")
          in (select unnest(${Segment.paramSegment(productmodelid)(ProductmodelId.arraySetter)}), unnest(${Segment.paramSegment(productdescriptionid)(ProductdescriptionId.arraySetter)}), unnest(${Segment.paramSegment(cultureid)(CultureId.arraySetter)}))
       """.delete
  
  }
  def insert(unsaved: ProductmodelproductdescriptioncultureRow): ZIO[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow] = {
    sql"""insert into production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate")
          values (${Segment.paramSegment(unsaved.productmodelid)(ProductmodelId.setter)}::int4, ${Segment.paramSegment(unsaved.productdescriptionid)(ProductdescriptionId.setter)}::int4, ${Segment.paramSegment(unsaved.cultureid)(CultureId.setter)}::bpchar, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
       """.insertReturning(using ProductmodelproductdescriptioncultureRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  def insert(unsaved: ProductmodelproductdescriptioncultureRowUnsaved): ZIO[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow] = {
    val fs = List(
      Some((sql""""productmodelid"""", sql"${Segment.paramSegment(unsaved.productmodelid)(ProductmodelId.setter)}::int4")),
                      Some((sql""""productdescriptionid"""", sql"${Segment.paramSegment(unsaved.productdescriptionid)(ProductdescriptionId.setter)}::int4")),
                      Some((sql""""cultureid"""", sql"${Segment.paramSegment(unsaved.cultureid)(CultureId.setter)}::bpchar")),
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
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
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductmodelproductdescriptioncultureRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelproductdescriptioncultureRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductmodelproductdescriptioncultureRowUnsaved.text)
  def select: SelectBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = SelectBuilderSql("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields.structure, ProductmodelproductdescriptioncultureRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow] = sql"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text from production.productmodelproductdescriptionculture""".query(using ProductmodelproductdescriptioncultureRow.jdbcDecoder).selectStream()
  def selectById(compositeId: ProductmodelproductdescriptioncultureId): ZIO[ZConnection, Throwable, Option[ProductmodelproductdescriptioncultureRow]] = sql"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text from production.productmodelproductdescriptionculture where "productmodelid" = ${Segment.paramSegment(compositeId.productmodelid)(ProductmodelId.setter)} AND "productdescriptionid" = ${Segment.paramSegment(compositeId.productdescriptionid)(ProductdescriptionId.setter)} AND "cultureid" = ${Segment.paramSegment(compositeId.cultureid)(CultureId.setter)}""".query(using ProductmodelproductdescriptioncultureRow.jdbcDecoder).selectOne
  def selectByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId]): ZStream[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow] = {
    val productmodelid = compositeIds.map(_.productmodelid)
    val productdescriptionid = compositeIds.map(_.productdescriptionid)
    val cultureid = compositeIds.map(_.cultureid)
    sql"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
          from production.productmodelproductdescriptionculture
          where ("productmodelid", "productdescriptionid", "cultureid")
          in (select unnest(${Segment.paramSegment(productmodelid)(ProductmodelId.arraySetter)}), unnest(${Segment.paramSegment(productdescriptionid)(ProductdescriptionId.arraySetter)}), unnest(${Segment.paramSegment(cultureid)(CultureId.arraySetter)}))
       """.query(using ProductmodelproductdescriptioncultureRow.jdbcDecoder).selectStream()
  
  }
  def selectByIdsTracked(compositeIds: Array[ProductmodelproductdescriptioncultureId]): ZIO[ZConnection, Throwable, Map[ProductmodelproductdescriptioncultureId, ProductmodelproductdescriptioncultureRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = UpdateBuilder("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields.structure, ProductmodelproductdescriptioncultureRow.jdbcDecoder)
  def update(row: ProductmodelproductdescriptioncultureRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productmodelproductdescriptionculture
          set "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productmodelid" = ${Segment.paramSegment(compositeId.productmodelid)(ProductmodelId.setter)} AND "productdescriptionid" = ${Segment.paramSegment(compositeId.productdescriptionid)(ProductdescriptionId.setter)} AND "cultureid" = ${Segment.paramSegment(compositeId.cultureid)(CultureId.setter)}""".update.map(_ > 0)
  }
  def upsert(unsaved: ProductmodelproductdescriptioncultureRow): ZIO[ZConnection, Throwable, UpdateResult[ProductmodelproductdescriptioncultureRow]] = {
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
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table productmodelproductdescriptionculture_TEMP (like production.productmodelproductdescriptionculture) on commit drop".execute
    val copied = streamingInsert(s"""copy productmodelproductdescriptionculture_TEMP("productmodelid", "productdescriptionid", "cultureid", "modifieddate") from stdin""", batchSize, unsaved)(ProductmodelproductdescriptioncultureRow.text)
    val merged = sql"""insert into production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate")
                       select * from productmodelproductdescriptionculture_TEMP
                       on conflict ("productmodelid", "productdescriptionid", "cultureid")
                       do update set
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table productmodelproductdescriptionculture_TEMP;""".update
    created *> copied *> merged
  }
}