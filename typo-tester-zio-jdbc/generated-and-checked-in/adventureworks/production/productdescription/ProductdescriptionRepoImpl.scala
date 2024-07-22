/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productdescription;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.streamingInsert;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import typo.dsl.UpdateBuilder;
import zio.ZIO;
import zio.jdbc.SqlFragment;
import zio.jdbc.SqlFragment.Segment;
import zio.jdbc.SqlFragment.Setter;
import zio.jdbc.UpdateResult;
import zio.jdbc.ZConnection;
import zio.jdbc.sqlInterpolator;
import zio.stream.ZStream;

class ProductdescriptionRepoImpl extends ProductdescriptionRepo {
  def delete: DeleteBuilder[ProductdescriptionFields, ProductdescriptionRow] = DeleteBuilder("production.productdescription", ProductdescriptionFields.structure)
  def deleteById(productdescriptionid: ProductdescriptionId): ZIO[ZConnection, Throwable, Boolean] = sql"""delete from production.productdescription where "productdescriptionid" = ${Segment.paramSegment(productdescriptionid)(ProductdescriptionId.setter)}""".delete.map(_ > 0)
  def deleteByIds(productdescriptionids: Array[ProductdescriptionId]): ZIO[ZConnection, Throwable, Long] = sql"""delete from production.productdescription where "productdescriptionid" = ANY(${Segment.paramSegment(productdescriptionids)(ProductdescriptionId.arraySetter)})""".delete
  def insert(unsaved: ProductdescriptionRow): ZIO[ZConnection, Throwable, ProductdescriptionRow] = {
    sql"""insert into production.productdescription("productdescriptionid", "description", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.productdescriptionid)(ProductdescriptionId.setter)}::int4, ${Segment.paramSegment(unsaved.description)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "productdescriptionid", "description", "rowguid", "modifieddate"::text
       """.insertReturning(using ProductdescriptionRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  def insert(unsaved: ProductdescriptionRowUnsaved): ZIO[ZConnection, Throwable, ProductdescriptionRow] = {
    val fs = List(
      Some((sql""""description"""", sql"${Segment.paramSegment(unsaved.description)(Setter.stringSetter)}")),
    unsaved.productdescriptionid match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((sql""""productdescriptionid"""", sql"${Segment.paramSegment(value: ProductdescriptionId)(ProductdescriptionId.setter)}::int4"))
    },
    unsaved.rowguid match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((sql""""rowguid"""", sql"${Segment.paramSegment(value: TypoUUID)(TypoUUID.setter)}::uuid"))
    },
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
    }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productdescription default values
                            returning "productdescriptionid", "description", "rowguid", "modifieddate"::text
                         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.productdescription($names) values ($values) returning "productdescriptionid", "description", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using ProductdescriptionRow.jdbcDecoder).map(_.updatedKeys.head)
  
  }
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductdescriptionRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY production.productdescription("productdescriptionid", "description", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductdescriptionRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductdescriptionRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY production.productdescription("description", "productdescriptionid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductdescriptionRowUnsaved.text)
  def select: SelectBuilder[ProductdescriptionFields, ProductdescriptionRow] = SelectBuilderSql("production.productdescription", ProductdescriptionFields.structure, ProductdescriptionRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, ProductdescriptionRow] = sql"""select "productdescriptionid", "description", "rowguid", "modifieddate"::text from production.productdescription""".query(using ProductdescriptionRow.jdbcDecoder).selectStream()
  def selectById(productdescriptionid: ProductdescriptionId): ZIO[ZConnection, Throwable, Option[ProductdescriptionRow]] = sql"""select "productdescriptionid", "description", "rowguid", "modifieddate"::text from production.productdescription where "productdescriptionid" = ${Segment.paramSegment(productdescriptionid)(ProductdescriptionId.setter)}""".query(using ProductdescriptionRow.jdbcDecoder).selectOne
  def selectByIds(productdescriptionids: Array[ProductdescriptionId]): ZStream[ZConnection, Throwable, ProductdescriptionRow] = sql"""select "productdescriptionid", "description", "rowguid", "modifieddate"::text from production.productdescription where "productdescriptionid" = ANY(${Segment.paramSegment(productdescriptionids)(ProductdescriptionId.arraySetter)})""".query(using ProductdescriptionRow.jdbcDecoder).selectStream()
  def selectByIdsTracked(productdescriptionids: Array[ProductdescriptionId]): ZIO[ZConnection, Throwable, Map[ProductdescriptionId, ProductdescriptionRow]] = {
    selectByIds(productdescriptionids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.productdescriptionid, x)).toMap
      productdescriptionids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[ProductdescriptionFields, ProductdescriptionRow] = UpdateBuilder("production.productdescription", ProductdescriptionFields.structure, ProductdescriptionRow.jdbcDecoder)
  def update(row: ProductdescriptionRow): ZIO[ZConnection, Throwable, Boolean] = {
    val productdescriptionid = row.productdescriptionid
    sql"""update production.productdescription
          set "description" = ${Segment.paramSegment(row.description)(Setter.stringSetter)},
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productdescriptionid" = ${Segment.paramSegment(productdescriptionid)(ProductdescriptionId.setter)}""".update.map(_ > 0)
  }
  def upsert(unsaved: ProductdescriptionRow): ZIO[ZConnection, Throwable, UpdateResult[ProductdescriptionRow]] = {
    sql"""insert into production.productdescription("productdescriptionid", "description", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.productdescriptionid)(ProductdescriptionId.setter)}::int4,
            ${Segment.paramSegment(unsaved.description)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("productdescriptionid")
          do update set
            "description" = EXCLUDED."description",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productdescriptionid", "description", "rowguid", "modifieddate"::text""".insertReturning(using ProductdescriptionRow.jdbcDecoder)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductdescriptionRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table productdescription_TEMP (like production.productdescription) on commit drop".execute
    val copied = streamingInsert(s"""copy productdescription_TEMP("productdescriptionid", "description", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(ProductdescriptionRow.text)
    val merged = sql"""insert into production.productdescription("productdescriptionid", "description", "rowguid", "modifieddate")
                       select * from productdescription_TEMP
                       on conflict ("productdescriptionid")
                       do update set
                         "description" = EXCLUDED."description",
                         "rowguid" = EXCLUDED."rowguid",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table productdescription_TEMP;""".update
    created *> copied *> merged
  }
}