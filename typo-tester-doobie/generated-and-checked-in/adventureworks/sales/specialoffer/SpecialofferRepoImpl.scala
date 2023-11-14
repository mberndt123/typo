/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class SpecialofferRepoImpl extends SpecialofferRepo {
  override def delete(specialofferid: SpecialofferId): ConnectionIO[Boolean] = {
    sql"""delete from sales.specialoffer where "specialofferid" = ${fromWrite(specialofferid)(Write.fromPut(SpecialofferId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[SpecialofferFields, SpecialofferRow] = {
    DeleteBuilder("sales.specialoffer", SpecialofferFields)
  }
  override def insert(unsaved: SpecialofferRow): ConnectionIO[SpecialofferRow] = {
    sql"""insert into sales.specialoffer("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.specialofferid)(Write.fromPut(SpecialofferId.put))}::int4, ${fromWrite(unsaved.description)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.discountpct)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.`type`)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.category)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.enddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.minqty)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.maxqty)(Write.fromPutOption(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
       """.query(SpecialofferRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, SpecialofferRow], batchSize: Int): ConnectionIO[Long] = {
    doobie.postgres.syntax.fragment.toFragmentOps(sql"""COPY sales.specialoffer("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(SpecialofferRow.text)
  }
  override def insert(unsaved: SpecialofferRowUnsaved): ConnectionIO[SpecialofferRow] = {
    val fs = List(
      Some((Fragment.const(s""""description""""), fr"${fromWrite(unsaved.description)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s""""type""""), fr"${fromWrite(unsaved.`type`)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s""""category""""), fr"${fromWrite(unsaved.category)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s""""startdate""""), fr"${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s""""enddate""""), fr"${fromWrite(unsaved.enddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s""""maxqty""""), fr"${fromWrite(unsaved.maxqty)(Write.fromPutOption(Meta.IntMeta.put))}::int4")),
      unsaved.specialofferid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""specialofferid""""), fr"${fromWrite(value: SpecialofferId)(Write.fromPut(SpecialofferId.put))}::int4"))
      },
      unsaved.discountpct match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""discountpct""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.minqty match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""minqty""""), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.specialoffer default values
            returning "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.specialoffer(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
         """
    }
    q.query(SpecialofferRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SpecialofferRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    doobie.postgres.syntax.fragment.toFragmentOps(sql"""COPY sales.specialoffer("description", "type", "category", "startdate", "enddate", "maxqty", "specialofferid", "discountpct", "minqty", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(SpecialofferRowUnsaved.text)
  }
  override def select: SelectBuilder[SpecialofferFields, SpecialofferRow] = {
    SelectBuilderSql("sales.specialoffer", SpecialofferFields, SpecialofferRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SpecialofferRow] = {
    sql"""select "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text from sales.specialoffer""".query(SpecialofferRow.read).stream
  }
  override def selectById(specialofferid: SpecialofferId): ConnectionIO[Option[SpecialofferRow]] = {
    sql"""select "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text from sales.specialoffer where "specialofferid" = ${fromWrite(specialofferid)(Write.fromPut(SpecialofferId.put))}""".query(SpecialofferRow.read).option
  }
  override def selectByIds(specialofferids: Array[SpecialofferId]): Stream[ConnectionIO, SpecialofferRow] = {
    sql"""select "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text from sales.specialoffer where "specialofferid" = ANY(${specialofferids})""".query(SpecialofferRow.read).stream
  }
  override def update(row: SpecialofferRow): ConnectionIO[Boolean] = {
    val specialofferid = row.specialofferid
    sql"""update sales.specialoffer
          set "description" = ${fromWrite(row.description)(Write.fromPut(Meta.StringMeta.put))},
              "discountpct" = ${fromWrite(row.discountpct)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "type" = ${fromWrite(row.`type`)(Write.fromPut(Meta.StringMeta.put))},
              "category" = ${fromWrite(row.category)(Write.fromPut(Meta.StringMeta.put))},
              "startdate" = ${fromWrite(row.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              "enddate" = ${fromWrite(row.enddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              "minqty" = ${fromWrite(row.minqty)(Write.fromPut(Meta.IntMeta.put))}::int4,
              "maxqty" = ${fromWrite(row.maxqty)(Write.fromPutOption(Meta.IntMeta.put))}::int4,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "specialofferid" = ${fromWrite(specialofferid)(Write.fromPut(SpecialofferId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[SpecialofferFields, SpecialofferRow] = {
    UpdateBuilder("sales.specialoffer", SpecialofferFields, SpecialofferRow.read)
  }
  override def upsert(unsaved: SpecialofferRow): ConnectionIO[SpecialofferRow] = {
    sql"""insert into sales.specialoffer("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.specialofferid)(Write.fromPut(SpecialofferId.put))}::int4,
            ${fromWrite(unsaved.description)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.discountpct)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.`type`)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.category)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.enddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.minqty)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.maxqty)(Write.fromPutOption(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("specialofferid")
          do update set
            "description" = EXCLUDED."description",
            "discountpct" = EXCLUDED."discountpct",
            "type" = EXCLUDED."type",
            "category" = EXCLUDED."category",
            "startdate" = EXCLUDED."startdate",
            "enddate" = EXCLUDED."enddate",
            "minqty" = EXCLUDED."minqty",
            "maxqty" = EXCLUDED."maxqty",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
       """.query(SpecialofferRow.read).unique
  }
}
