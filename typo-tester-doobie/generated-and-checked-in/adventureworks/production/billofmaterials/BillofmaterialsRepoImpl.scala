/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.billofmaterials;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoShort;
import adventureworks.production.product.ProductId;
import adventureworks.production.unitmeasure.UnitmeasureId;
import cats.instances.list.catsStdInstancesForList;
import doobie.free.connection.ConnectionIO;
import doobie.postgres.syntax.FragmentOps;
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite;
import doobie.syntax.string.toSqlInterpolator;
import doobie.util.Write;
import doobie.util.fragment.Fragment;
import doobie.util.meta.Meta;
import doobie.util.update.Update;
import fs2.Stream;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import typo.dsl.UpdateBuilder;

class BillofmaterialsRepoImpl extends BillofmaterialsRepo {
  def delete: DeleteBuilder[BillofmaterialsFields, BillofmaterialsRow] = DeleteBuilder("production.billofmaterials", BillofmaterialsFields.structure)
  def deleteById(billofmaterialsid: Int): ConnectionIO[Boolean] = sql"""delete from production.billofmaterials where "billofmaterialsid" = ${fromWrite(billofmaterialsid)(Write.fromPut(Meta.IntMeta.put))}""".update.run.map(_ > 0)
  def deleteByIds(billofmaterialsids: Array[Int]): ConnectionIO[Int] = sql"""delete from production.billofmaterials where "billofmaterialsid" = ANY(${fromWrite(billofmaterialsids)(Write.fromPut(adventureworks.IntegerArrayMeta.put))})""".update.run
  def insert(unsaved: BillofmaterialsRow): ConnectionIO[BillofmaterialsRow] = {
    sql"""insert into production.billofmaterials("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate")
          values (${fromWrite(unsaved.billofmaterialsid)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.productassemblyid)(Write.fromPutOption(ProductId.put))}::int4, ${fromWrite(unsaved.componentid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.unitmeasurecode)(Write.fromPut(UnitmeasureId.put))}::bpchar, ${fromWrite(unsaved.bomlevel)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.perassemblyqty)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
       """.query(using BillofmaterialsRow.read).unique
  }
  def insert(unsaved: BillofmaterialsRowUnsaved): ConnectionIO[BillofmaterialsRow] = {
    val fs = List(
      Some((Fragment.const0(s""""productassemblyid""""), fr"${fromWrite(unsaved.productassemblyid)(Write.fromPutOption(ProductId.put))}::int4")),
                      Some((Fragment.const0(s""""componentid""""), fr"${fromWrite(unsaved.componentid)(Write.fromPut(ProductId.put))}::int4")),
                      Some((Fragment.const0(s""""enddate""""), fr"${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
                      Some((Fragment.const0(s""""unitmeasurecode""""), fr"${fromWrite(unsaved.unitmeasurecode)(Write.fromPut(UnitmeasureId.put))}::bpchar")),
                      Some((Fragment.const0(s""""bomlevel""""), fr"${fromWrite(unsaved.bomlevel)(Write.fromPut(TypoShort.put))}::int2")),
    unsaved.billofmaterialsid match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((Fragment.const0(s""""billofmaterialsid""""), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int4"))
    },
    unsaved.startdate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((Fragment.const0(s""""startdate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
    },
    unsaved.perassemblyqty match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((Fragment.const0(s""""perassemblyqty""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
    },
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
    }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.billofmaterials default values
                            returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
                         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.billofmaterials(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
                            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
                            returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
                         """
    }
    q.query(using BillofmaterialsRow.read).unique
  
  }
  def insertStreaming(unsaved: Stream[ConnectionIO, BillofmaterialsRow], batchSize: Int = 10000): ConnectionIO[Long] = new FragmentOps(sql"""COPY production.billofmaterials("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using BillofmaterialsRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, BillofmaterialsRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = new FragmentOps(sql"""COPY production.billofmaterials("productassemblyid", "componentid", "enddate", "unitmeasurecode", "bomlevel", "billofmaterialsid", "startdate", "perassemblyqty", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using BillofmaterialsRowUnsaved.text)
  def select: SelectBuilder[BillofmaterialsFields, BillofmaterialsRow] = SelectBuilderSql("production.billofmaterials", BillofmaterialsFields.structure, BillofmaterialsRow.read)
  def selectAll: Stream[ConnectionIO, BillofmaterialsRow] = sql"""select "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text from production.billofmaterials""".query(using BillofmaterialsRow.read).stream
  def selectById(billofmaterialsid: Int): ConnectionIO[Option[BillofmaterialsRow]] = sql"""select "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text from production.billofmaterials where "billofmaterialsid" = ${fromWrite(billofmaterialsid)(Write.fromPut(Meta.IntMeta.put))}""".query(using BillofmaterialsRow.read).option
  def selectByIds(billofmaterialsids: Array[Int]): Stream[ConnectionIO, BillofmaterialsRow] = sql"""select "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text from production.billofmaterials where "billofmaterialsid" = ANY(${fromWrite(billofmaterialsids)(Write.fromPut(adventureworks.IntegerArrayMeta.put))})""".query(using BillofmaterialsRow.read).stream
  def selectByIdsTracked(billofmaterialsids: Array[Int]): ConnectionIO[Map[Int, BillofmaterialsRow]] = {
    selectByIds(billofmaterialsids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.billofmaterialsid, x)).toMap
      billofmaterialsids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[BillofmaterialsFields, BillofmaterialsRow] = UpdateBuilder("production.billofmaterials", BillofmaterialsFields.structure, BillofmaterialsRow.read)
  def update(row: BillofmaterialsRow): ConnectionIO[Boolean] = {
    val billofmaterialsid = row.billofmaterialsid
    sql"""update production.billofmaterials
                          set "productassemblyid" = ${fromWrite(row.productassemblyid)(Write.fromPutOption(ProductId.put))}::int4,
                              "componentid" = ${fromWrite(row.componentid)(Write.fromPut(ProductId.put))}::int4,
                              "startdate" = ${fromWrite(row.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
                              "enddate" = ${fromWrite(row.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
                              "unitmeasurecode" = ${fromWrite(row.unitmeasurecode)(Write.fromPut(UnitmeasureId.put))}::bpchar,
                              "bomlevel" = ${fromWrite(row.bomlevel)(Write.fromPut(TypoShort.put))}::int2,
                              "perassemblyqty" = ${fromWrite(row.perassemblyqty)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
                              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
                          where "billofmaterialsid" = ${fromWrite(billofmaterialsid)(Write.fromPut(Meta.IntMeta.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  def upsert(unsaved: BillofmaterialsRow): ConnectionIO[BillofmaterialsRow] = {
    sql"""insert into production.billofmaterials("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate")
          values (
            ${fromWrite(unsaved.billofmaterialsid)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.productassemblyid)(Write.fromPutOption(ProductId.put))}::int4,
            ${fromWrite(unsaved.componentid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.unitmeasurecode)(Write.fromPut(UnitmeasureId.put))}::bpchar,
            ${fromWrite(unsaved.bomlevel)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.perassemblyqty)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("billofmaterialsid")
          do update set
            "productassemblyid" = EXCLUDED."productassemblyid",
            "componentid" = EXCLUDED."componentid",
            "startdate" = EXCLUDED."startdate",
            "enddate" = EXCLUDED."enddate",
            "unitmeasurecode" = EXCLUDED."unitmeasurecode",
            "bomlevel" = EXCLUDED."bomlevel",
            "perassemblyqty" = EXCLUDED."perassemblyqty",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
       """.query(using BillofmaterialsRow.read).unique
  }
  def upsertBatch(unsaved: List[BillofmaterialsRow]): Stream[ConnectionIO, BillofmaterialsRow] = {
    Update[BillofmaterialsRow](
      s"""insert into production.billofmaterials("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate")
          values (?::int4,?::int4,?::int4,?::timestamp,?::timestamp,?::bpchar,?::int2,?::numeric,?::timestamp)
          on conflict ("billofmaterialsid")
          do update set
            "productassemblyid" = EXCLUDED."productassemblyid",
            "componentid" = EXCLUDED."componentid",
            "startdate" = EXCLUDED."startdate",
            "enddate" = EXCLUDED."enddate",
            "unitmeasurecode" = EXCLUDED."unitmeasurecode",
            "bomlevel" = EXCLUDED."bomlevel",
            "perassemblyqty" = EXCLUDED."perassemblyqty",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text"""
    )(using BillofmaterialsRow.write)
    .updateManyWithGeneratedKeys[BillofmaterialsRow]("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate")(unsaved)(using catsStdInstancesForList, BillofmaterialsRow.read)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, BillofmaterialsRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table billofmaterials_TEMP (like production.billofmaterials) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy billofmaterials_TEMP("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using BillofmaterialsRow.text)
      res <- sql"""insert into production.billofmaterials("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate")
                   select * from billofmaterials_TEMP
                   on conflict ("billofmaterialsid")
                   do update set
                     "productassemblyid" = EXCLUDED."productassemblyid",
                     "componentid" = EXCLUDED."componentid",
                     "startdate" = EXCLUDED."startdate",
                     "enddate" = EXCLUDED."enddate",
                     "unitmeasurecode" = EXCLUDED."unitmeasurecode",
                     "bomlevel" = EXCLUDED."bomlevel",
                     "perassemblyqty" = EXCLUDED."perassemblyqty",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table billofmaterials_TEMP;""".update.run
    } yield res
  }
}