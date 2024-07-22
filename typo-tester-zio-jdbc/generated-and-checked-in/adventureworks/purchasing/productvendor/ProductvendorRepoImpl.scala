/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.productvendor;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.production.product.ProductId;
import adventureworks.production.unitmeasure.UnitmeasureId;
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

class ProductvendorRepoImpl extends ProductvendorRepo {
  def delete: DeleteBuilder[ProductvendorFields, ProductvendorRow] = DeleteBuilder("purchasing.productvendor", ProductvendorFields.structure)
  def deleteById(compositeId: ProductvendorId): ZIO[ZConnection, Throwable, Boolean] = sql"""delete from purchasing.productvendor where "productid" = ${Segment.paramSegment(compositeId.productid)(ProductId.setter)} AND "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)}""".delete.map(_ > 0)
  def deleteByIds(compositeIds: Array[ProductvendorId]): ZIO[ZConnection, Throwable, Long] = {
    val productid = compositeIds.map(_.productid)
    val businessentityid = compositeIds.map(_.businessentityid)
    sql"""delete
          from purchasing.productvendor
          where ("productid", "businessentityid")
          in (select unnest(${Segment.paramSegment(productid)(ProductId.arraySetter)}), unnest(${Segment.paramSegment(businessentityid)(BusinessentityId.arraySetter)}))
       """.delete
  
  }
  def insert(unsaved: ProductvendorRow): ZIO[ZConnection, Throwable, ProductvendorRow] = {
    sql"""insert into purchasing.productvendor("productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate")
          values (${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4, ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.averageleadtime)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.standardprice)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.lastreceiptcost)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric, ${Segment.paramSegment(unsaved.lastreceiptdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp, ${Segment.paramSegment(unsaved.minorderqty)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.maxorderqty)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.onorderqty)(Setter.optionParamSetter(Setter.intSetter))}::int4, ${Segment.paramSegment(unsaved.unitmeasurecode)(UnitmeasureId.setter)}::bpchar, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate"::text, "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate"::text
       """.insertReturning(using ProductvendorRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  def insert(unsaved: ProductvendorRowUnsaved): ZIO[ZConnection, Throwable, ProductvendorRow] = {
    val fs = List(
      Some((sql""""productid"""", sql"${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4")),
                      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
                      Some((sql""""averageleadtime"""", sql"${Segment.paramSegment(unsaved.averageleadtime)(Setter.intSetter)}::int4")),
                      Some((sql""""standardprice"""", sql"${Segment.paramSegment(unsaved.standardprice)(Setter.bigDecimalScalaSetter)}::numeric")),
                      Some((sql""""lastreceiptcost"""", sql"${Segment.paramSegment(unsaved.lastreceiptcost)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric")),
                      Some((sql""""lastreceiptdate"""", sql"${Segment.paramSegment(unsaved.lastreceiptdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp")),
                      Some((sql""""minorderqty"""", sql"${Segment.paramSegment(unsaved.minorderqty)(Setter.intSetter)}::int4")),
                      Some((sql""""maxorderqty"""", sql"${Segment.paramSegment(unsaved.maxorderqty)(Setter.intSetter)}::int4")),
                      Some((sql""""onorderqty"""", sql"${Segment.paramSegment(unsaved.onorderqty)(Setter.optionParamSetter(Setter.intSetter))}::int4")),
                      Some((sql""""unitmeasurecode"""", sql"${Segment.paramSegment(unsaved.unitmeasurecode)(UnitmeasureId.setter)}::bpchar")),
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
    }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into purchasing.productvendor default values
                            returning "productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate"::text, "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate"::text
                         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into purchasing.productvendor($names) values ($values) returning "productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate"::text, "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate"::text"""
    }
    q.insertReturning(using ProductvendorRow.jdbcDecoder).map(_.updatedKeys.head)
  
  }
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductvendorRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY purchasing.productvendor("productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductvendorRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductvendorRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = streamingInsert(s"""COPY purchasing.productvendor("productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductvendorRowUnsaved.text)
  def select: SelectBuilder[ProductvendorFields, ProductvendorRow] = SelectBuilderSql("purchasing.productvendor", ProductvendorFields.structure, ProductvendorRow.jdbcDecoder)
  def selectAll: ZStream[ZConnection, Throwable, ProductvendorRow] = sql"""select "productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate"::text, "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate"::text from purchasing.productvendor""".query(using ProductvendorRow.jdbcDecoder).selectStream()
  def selectById(compositeId: ProductvendorId): ZIO[ZConnection, Throwable, Option[ProductvendorRow]] = sql"""select "productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate"::text, "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate"::text from purchasing.productvendor where "productid" = ${Segment.paramSegment(compositeId.productid)(ProductId.setter)} AND "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)}""".query(using ProductvendorRow.jdbcDecoder).selectOne
  def selectByIds(compositeIds: Array[ProductvendorId]): ZStream[ZConnection, Throwable, ProductvendorRow] = {
    val productid = compositeIds.map(_.productid)
    val businessentityid = compositeIds.map(_.businessentityid)
    sql"""select "productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate"::text, "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate"::text
          from purchasing.productvendor
          where ("productid", "businessentityid")
          in (select unnest(${Segment.paramSegment(productid)(ProductId.arraySetter)}), unnest(${Segment.paramSegment(businessentityid)(BusinessentityId.arraySetter)}))
       """.query(using ProductvendorRow.jdbcDecoder).selectStream()
  
  }
  def selectByIdsTracked(compositeIds: Array[ProductvendorId]): ZIO[ZConnection, Throwable, Map[ProductvendorId, ProductvendorRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[ProductvendorFields, ProductvendorRow] = UpdateBuilder("purchasing.productvendor", ProductvendorFields.structure, ProductvendorRow.jdbcDecoder)
  def update(row: ProductvendorRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update purchasing.productvendor
          set "averageleadtime" = ${Segment.paramSegment(row.averageleadtime)(Setter.intSetter)}::int4,
              "standardprice" = ${Segment.paramSegment(row.standardprice)(Setter.bigDecimalScalaSetter)}::numeric,
              "lastreceiptcost" = ${Segment.paramSegment(row.lastreceiptcost)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric,
              "lastreceiptdate" = ${Segment.paramSegment(row.lastreceiptdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
              "minorderqty" = ${Segment.paramSegment(row.minorderqty)(Setter.intSetter)}::int4,
              "maxorderqty" = ${Segment.paramSegment(row.maxorderqty)(Setter.intSetter)}::int4,
              "onorderqty" = ${Segment.paramSegment(row.onorderqty)(Setter.optionParamSetter(Setter.intSetter))}::int4,
              "unitmeasurecode" = ${Segment.paramSegment(row.unitmeasurecode)(UnitmeasureId.setter)}::bpchar,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productid" = ${Segment.paramSegment(compositeId.productid)(ProductId.setter)} AND "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)}""".update.map(_ > 0)
  }
  def upsert(unsaved: ProductvendorRow): ZIO[ZConnection, Throwable, UpdateResult[ProductvendorRow]] = {
    sql"""insert into purchasing.productvendor("productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4,
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.averageleadtime)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.standardprice)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.lastreceiptcost)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric,
            ${Segment.paramSegment(unsaved.lastreceiptdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
            ${Segment.paramSegment(unsaved.minorderqty)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.maxorderqty)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.onorderqty)(Setter.optionParamSetter(Setter.intSetter))}::int4,
            ${Segment.paramSegment(unsaved.unitmeasurecode)(UnitmeasureId.setter)}::bpchar,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("productid", "businessentityid")
          do update set
            "averageleadtime" = EXCLUDED."averageleadtime",
            "standardprice" = EXCLUDED."standardprice",
            "lastreceiptcost" = EXCLUDED."lastreceiptcost",
            "lastreceiptdate" = EXCLUDED."lastreceiptdate",
            "minorderqty" = EXCLUDED."minorderqty",
            "maxorderqty" = EXCLUDED."maxorderqty",
            "onorderqty" = EXCLUDED."onorderqty",
            "unitmeasurecode" = EXCLUDED."unitmeasurecode",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate"::text, "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate"::text""".insertReturning(using ProductvendorRow.jdbcDecoder)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductvendorRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table productvendor_TEMP (like purchasing.productvendor) on commit drop".execute
    val copied = streamingInsert(s"""copy productvendor_TEMP("productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate") from stdin""", batchSize, unsaved)(ProductvendorRow.text)
    val merged = sql"""insert into purchasing.productvendor("productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate")
                       select * from productvendor_TEMP
                       on conflict ("productid", "businessentityid")
                       do update set
                         "averageleadtime" = EXCLUDED."averageleadtime",
                         "standardprice" = EXCLUDED."standardprice",
                         "lastreceiptcost" = EXCLUDED."lastreceiptcost",
                         "lastreceiptdate" = EXCLUDED."lastreceiptdate",
                         "minorderqty" = EXCLUDED."minorderqty",
                         "maxorderqty" = EXCLUDED."maxorderqty",
                         "onorderqty" = EXCLUDED."onorderqty",
                         "unitmeasurecode" = EXCLUDED."unitmeasurecode",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table productvendor_TEMP;""".update
    created *> copied *> merged
  }
}