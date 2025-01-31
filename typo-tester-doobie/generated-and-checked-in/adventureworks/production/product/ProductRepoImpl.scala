/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
import cats.instances.list.catsStdInstancesForList
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import doobie.util.update.Update
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class ProductRepoImpl extends ProductRepo {
  override def delete: DeleteBuilder[ProductFields, ProductRow] = {
    DeleteBuilder("production.product", ProductFields.structure)
  }
  override def deleteById(productid: ProductId): ConnectionIO[Boolean] = {
    sql"""delete from production.product where "productid" = ${fromWrite(productid)(Write.fromPut(ProductId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(productids: Array[ProductId]): ConnectionIO[Int] = {
    sql"""delete from production.product where "productid" = ANY(${productids})""".update.run
  }
  override def insert(unsaved: ProductRow): ConnectionIO[ProductRow] = {
    sql"""insert into production.product("productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.productnumber)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.makeflag)(Write.fromPut(Flag.put))}::bool, ${fromWrite(unsaved.finishedgoodsflag)(Write.fromPut(Flag.put))}::bool, ${fromWrite(unsaved.color)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.safetystocklevel)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.reorderpoint)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.standardcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.size)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.sizeunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar, ${fromWrite(unsaved.weightunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar, ${fromWrite(unsaved.weight)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.daystomanufacture)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.productline)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.`class`)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.style)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.productsubcategoryid)(Write.fromPutOption(ProductsubcategoryId.put))}::int4, ${fromWrite(unsaved.productmodelid)(Write.fromPutOption(ProductmodelId.put))}::int4, ${fromWrite(unsaved.sellstartdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.sellenddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.discontinueddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
       """.query(using ProductRow.read).unique
  }
  override def insert(unsaved: ProductRowUnsaved): ConnectionIO[ProductRow] = {
    val fs = List(
      Some((Fragment.const0(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      Some((Fragment.const0(s""""productnumber""""), fr"${fromWrite(unsaved.productnumber)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""color""""), fr"${fromWrite(unsaved.color)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""safetystocklevel""""), fr"${fromWrite(unsaved.safetystocklevel)(Write.fromPut(TypoShort.put))}::int2")),
      Some((Fragment.const0(s""""reorderpoint""""), fr"${fromWrite(unsaved.reorderpoint)(Write.fromPut(TypoShort.put))}::int2")),
      Some((Fragment.const0(s""""standardcost""""), fr"${fromWrite(unsaved.standardcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const0(s""""listprice""""), fr"${fromWrite(unsaved.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const0(s""""size""""), fr"${fromWrite(unsaved.size)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""sizeunitmeasurecode""""), fr"${fromWrite(unsaved.sizeunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar")),
      Some((Fragment.const0(s""""weightunitmeasurecode""""), fr"${fromWrite(unsaved.weightunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar")),
      Some((Fragment.const0(s""""weight""""), fr"${fromWrite(unsaved.weight)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const0(s""""daystomanufacture""""), fr"${fromWrite(unsaved.daystomanufacture)(Write.fromPut(Meta.IntMeta.put))}::int4")),
      Some((Fragment.const0(s""""productline""""), fr"${fromWrite(unsaved.productline)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const0(s""""class""""), fr"${fromWrite(unsaved.`class`)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const0(s""""style""""), fr"${fromWrite(unsaved.style)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const0(s""""productsubcategoryid""""), fr"${fromWrite(unsaved.productsubcategoryid)(Write.fromPutOption(ProductsubcategoryId.put))}::int4")),
      Some((Fragment.const0(s""""productmodelid""""), fr"${fromWrite(unsaved.productmodelid)(Write.fromPutOption(ProductmodelId.put))}::int4")),
      Some((Fragment.const0(s""""sellstartdate""""), fr"${fromWrite(unsaved.sellstartdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const0(s""""sellenddate""""), fr"${fromWrite(unsaved.sellenddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const0(s""""discontinueddate""""), fr"${fromWrite(unsaved.discontinueddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      unsaved.productid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""productid""""), fr"${fromWrite(value: ProductId)(Write.fromPut(ProductId.put))}::int4"))
      },
      unsaved.makeflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""makeflag""""), fr"${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::bool"))
      },
      unsaved.finishedgoodsflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""finishedgoodsflag""""), fr"${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::bool"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.product default values
            returning "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.product(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
         """
    }
    q.query(using ProductRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.product("productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using ProductRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.product("name", "productnumber", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "productid", "makeflag", "finishedgoodsflag", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using ProductRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductFields, ProductRow] = {
    SelectBuilderSql("production.product", ProductFields.structure, ProductRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductRow] = {
    sql"""select "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text from production.product""".query(using ProductRow.read).stream
  }
  override def selectById(productid: ProductId): ConnectionIO[Option[ProductRow]] = {
    sql"""select "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text from production.product where "productid" = ${fromWrite(productid)(Write.fromPut(ProductId.put))}""".query(using ProductRow.read).option
  }
  override def selectByIds(productids: Array[ProductId]): Stream[ConnectionIO, ProductRow] = {
    sql"""select "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text from production.product where "productid" = ANY(${productids})""".query(using ProductRow.read).stream
  }
  override def selectByIdsTracked(productids: Array[ProductId]): ConnectionIO[Map[ProductId, ProductRow]] = {
    selectByIds(productids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.productid, x)).toMap
      productids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ProductFields, ProductRow] = {
    UpdateBuilder("production.product", ProductFields.structure, ProductRow.read)
  }
  override def update(row: ProductRow): ConnectionIO[Boolean] = {
    val productid = row.productid
    sql"""update production.product
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "productnumber" = ${fromWrite(row.productnumber)(Write.fromPut(Meta.StringMeta.put))},
              "makeflag" = ${fromWrite(row.makeflag)(Write.fromPut(Flag.put))}::bool,
              "finishedgoodsflag" = ${fromWrite(row.finishedgoodsflag)(Write.fromPut(Flag.put))}::bool,
              "color" = ${fromWrite(row.color)(Write.fromPutOption(Meta.StringMeta.put))},
              "safetystocklevel" = ${fromWrite(row.safetystocklevel)(Write.fromPut(TypoShort.put))}::int2,
              "reorderpoint" = ${fromWrite(row.reorderpoint)(Write.fromPut(TypoShort.put))}::int2,
              "standardcost" = ${fromWrite(row.standardcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "listprice" = ${fromWrite(row.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "size" = ${fromWrite(row.size)(Write.fromPutOption(Meta.StringMeta.put))},
              "sizeunitmeasurecode" = ${fromWrite(row.sizeunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar,
              "weightunitmeasurecode" = ${fromWrite(row.weightunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar,
              "weight" = ${fromWrite(row.weight)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "daystomanufacture" = ${fromWrite(row.daystomanufacture)(Write.fromPut(Meta.IntMeta.put))}::int4,
              "productline" = ${fromWrite(row.productline)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar,
              "class" = ${fromWrite(row.`class`)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar,
              "style" = ${fromWrite(row.style)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar,
              "productsubcategoryid" = ${fromWrite(row.productsubcategoryid)(Write.fromPutOption(ProductsubcategoryId.put))}::int4,
              "productmodelid" = ${fromWrite(row.productmodelid)(Write.fromPutOption(ProductmodelId.put))}::int4,
              "sellstartdate" = ${fromWrite(row.sellstartdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              "sellenddate" = ${fromWrite(row.sellenddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              "discontinueddate" = ${fromWrite(row.discontinueddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "productid" = ${fromWrite(productid)(Write.fromPut(ProductId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductRow): ConnectionIO[ProductRow] = {
    sql"""insert into production.product("productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.productnumber)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.makeflag)(Write.fromPut(Flag.put))}::bool,
            ${fromWrite(unsaved.finishedgoodsflag)(Write.fromPut(Flag.put))}::bool,
            ${fromWrite(unsaved.color)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.safetystocklevel)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.reorderpoint)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.standardcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.size)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.sizeunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar,
            ${fromWrite(unsaved.weightunitmeasurecode)(Write.fromPutOption(UnitmeasureId.put))}::bpchar,
            ${fromWrite(unsaved.weight)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.daystomanufacture)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.productline)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.`class`)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.style)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.productsubcategoryid)(Write.fromPutOption(ProductsubcategoryId.put))}::int4,
            ${fromWrite(unsaved.productmodelid)(Write.fromPutOption(ProductmodelId.put))}::int4,
            ${fromWrite(unsaved.sellstartdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.sellenddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.discontinueddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("productid")
          do update set
            "name" = EXCLUDED."name",
            "productnumber" = EXCLUDED."productnumber",
            "makeflag" = EXCLUDED."makeflag",
            "finishedgoodsflag" = EXCLUDED."finishedgoodsflag",
            "color" = EXCLUDED."color",
            "safetystocklevel" = EXCLUDED."safetystocklevel",
            "reorderpoint" = EXCLUDED."reorderpoint",
            "standardcost" = EXCLUDED."standardcost",
            "listprice" = EXCLUDED."listprice",
            "size" = EXCLUDED."size",
            "sizeunitmeasurecode" = EXCLUDED."sizeunitmeasurecode",
            "weightunitmeasurecode" = EXCLUDED."weightunitmeasurecode",
            "weight" = EXCLUDED."weight",
            "daystomanufacture" = EXCLUDED."daystomanufacture",
            "productline" = EXCLUDED."productline",
            "class" = EXCLUDED."class",
            "style" = EXCLUDED."style",
            "productsubcategoryid" = EXCLUDED."productsubcategoryid",
            "productmodelid" = EXCLUDED."productmodelid",
            "sellstartdate" = EXCLUDED."sellstartdate",
            "sellenddate" = EXCLUDED."sellenddate",
            "discontinueddate" = EXCLUDED."discontinueddate",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
       """.query(using ProductRow.read).unique
  }
  override def upsertBatch(unsaved: List[ProductRow]): Stream[ConnectionIO, ProductRow] = {
    Update[ProductRow](
      s"""insert into production.product("productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "rowguid", "modifieddate")
          values (?::int4,?::varchar,?,?::bool,?::bool,?,?::int2,?::int2,?::numeric,?::numeric,?,?::bpchar,?::bpchar,?::numeric,?::int4,?::bpchar,?::bpchar,?::bpchar,?::int4,?::int4,?::timestamp,?::timestamp,?::timestamp,?::uuid,?::timestamp)
          on conflict ("productid")
          do update set
            "name" = EXCLUDED."name",
            "productnumber" = EXCLUDED."productnumber",
            "makeflag" = EXCLUDED."makeflag",
            "finishedgoodsflag" = EXCLUDED."finishedgoodsflag",
            "color" = EXCLUDED."color",
            "safetystocklevel" = EXCLUDED."safetystocklevel",
            "reorderpoint" = EXCLUDED."reorderpoint",
            "standardcost" = EXCLUDED."standardcost",
            "listprice" = EXCLUDED."listprice",
            "size" = EXCLUDED."size",
            "sizeunitmeasurecode" = EXCLUDED."sizeunitmeasurecode",
            "weightunitmeasurecode" = EXCLUDED."weightunitmeasurecode",
            "weight" = EXCLUDED."weight",
            "daystomanufacture" = EXCLUDED."daystomanufacture",
            "productline" = EXCLUDED."productline",
            "class" = EXCLUDED."class",
            "style" = EXCLUDED."style",
            "productsubcategoryid" = EXCLUDED."productsubcategoryid",
            "productmodelid" = EXCLUDED."productmodelid",
            "sellstartdate" = EXCLUDED."sellstartdate",
            "sellenddate" = EXCLUDED."sellenddate",
            "discontinueddate" = EXCLUDED."discontinueddate",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text"""
    )(using ProductRow.write)
    .updateManyWithGeneratedKeys[ProductRow]("productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "rowguid", "modifieddate")(unsaved)(using catsStdInstancesForList, ProductRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, ProductRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table product_TEMP (like production.product) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy product_TEMP("productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "rowguid", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using ProductRow.text)
      res <- sql"""insert into production.product("productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "rowguid", "modifieddate")
                   select * from product_TEMP
                   on conflict ("productid")
                   do update set
                     "name" = EXCLUDED."name",
                     "productnumber" = EXCLUDED."productnumber",
                     "makeflag" = EXCLUDED."makeflag",
                     "finishedgoodsflag" = EXCLUDED."finishedgoodsflag",
                     "color" = EXCLUDED."color",
                     "safetystocklevel" = EXCLUDED."safetystocklevel",
                     "reorderpoint" = EXCLUDED."reorderpoint",
                     "standardcost" = EXCLUDED."standardcost",
                     "listprice" = EXCLUDED."listprice",
                     "size" = EXCLUDED."size",
                     "sizeunitmeasurecode" = EXCLUDED."sizeunitmeasurecode",
                     "weightunitmeasurecode" = EXCLUDED."weightunitmeasurecode",
                     "weight" = EXCLUDED."weight",
                     "daystomanufacture" = EXCLUDED."daystomanufacture",
                     "productline" = EXCLUDED."productline",
                     "class" = EXCLUDED."class",
                     "style" = EXCLUDED."style",
                     "productsubcategoryid" = EXCLUDED."productsubcategoryid",
                     "productmodelid" = EXCLUDED."productmodelid",
                     "sellstartdate" = EXCLUDED."sellstartdate",
                     "sellenddate" = EXCLUDED."sellenddate",
                     "discontinueddate" = EXCLUDED."discontinueddate",
                     "rowguid" = EXCLUDED."rowguid",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table product_TEMP;""".update.run
    } yield res
  }
}
