/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderheader

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.purchasing.shipmethod.ShipmethodId
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

object PurchaseorderheaderRepoImpl extends PurchaseorderheaderRepo {
  override def delete(purchaseorderid: PurchaseorderheaderId): ConnectionIO[Boolean] = {
    sql"""delete from purchasing.purchaseorderheader where "purchaseorderid" = ${fromWrite(purchaseorderid)(Write.fromPut(PurchaseorderheaderId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    DeleteBuilder("purchasing.purchaseorderheader", PurchaseorderheaderFields)
  }
  override def insert(unsaved: PurchaseorderheaderRow): ConnectionIO[PurchaseorderheaderRow] = {
    sql"""insert into purchasing.purchaseorderheader("purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate")
          values (${fromWrite(unsaved.purchaseorderid)(Write.fromPut(PurchaseorderheaderId.put))}::int4, ${fromWrite(unsaved.revisionnumber)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.status)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.employeeid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.vendorid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4, ${fromWrite(unsaved.orderdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.shipdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.subtotal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.taxamt)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.freight)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text
       """.query(PurchaseorderheaderRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, PurchaseorderheaderRow], batchSize: Int): ConnectionIO[Long] = {
    doobie.postgres.syntax.fragment.toFragmentOps(sql"""COPY purchasing.purchaseorderheader("purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(PurchaseorderheaderRow.text)
  }
  override def insert(unsaved: PurchaseorderheaderRowUnsaved): ConnectionIO[PurchaseorderheaderRow] = {
    val fs = List(
      Some((Fragment.const(s""""employeeid""""), fr"${fromWrite(unsaved.employeeid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s""""vendorid""""), fr"${fromWrite(unsaved.vendorid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s""""shipmethodid""""), fr"${fromWrite(unsaved.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4")),
      Some((Fragment.const(s""""shipdate""""), fr"${fromWrite(unsaved.shipdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      unsaved.purchaseorderid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""purchaseorderid""""), fr"${fromWrite(value: PurchaseorderheaderId)(Write.fromPut(PurchaseorderheaderId.put))}::int4"))
      },
      unsaved.revisionnumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""revisionnumber""""), fr"${fromWrite(value: TypoShort)(Write.fromPut(TypoShort.put))}::int2"))
      },
      unsaved.status match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""status""""), fr"${fromWrite(value: TypoShort)(Write.fromPut(TypoShort.put))}::int2"))
      },
      unsaved.orderdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""orderdate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      },
      unsaved.subtotal match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""subtotal""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.taxamt match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""taxamt""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.freight match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""freight""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into purchasing.purchaseorderheader default values
            returning "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into purchasing.purchaseorderheader(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text
         """
    }
    q.query(PurchaseorderheaderRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PurchaseorderheaderRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    doobie.postgres.syntax.fragment.toFragmentOps(sql"""COPY purchasing.purchaseorderheader("employeeid", "vendorid", "shipmethodid", "shipdate", "purchaseorderid", "revisionnumber", "status", "orderdate", "subtotal", "taxamt", "freight", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(PurchaseorderheaderRowUnsaved.text)
  }
  override def select: SelectBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    SelectBuilderSql("purchasing.purchaseorderheader", PurchaseorderheaderFields, PurchaseorderheaderRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PurchaseorderheaderRow] = {
    sql"""select "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text from purchasing.purchaseorderheader""".query(PurchaseorderheaderRow.read).stream
  }
  override def selectById(purchaseorderid: PurchaseorderheaderId): ConnectionIO[Option[PurchaseorderheaderRow]] = {
    sql"""select "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text from purchasing.purchaseorderheader where "purchaseorderid" = ${fromWrite(purchaseorderid)(Write.fromPut(PurchaseorderheaderId.put))}""".query(PurchaseorderheaderRow.read).option
  }
  override def selectByIds(purchaseorderids: Array[PurchaseorderheaderId]): Stream[ConnectionIO, PurchaseorderheaderRow] = {
    sql"""select "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text from purchasing.purchaseorderheader where "purchaseorderid" = ANY(${purchaseorderids})""".query(PurchaseorderheaderRow.read).stream
  }
  override def update(row: PurchaseorderheaderRow): ConnectionIO[Boolean] = {
    val purchaseorderid = row.purchaseorderid
    sql"""update purchasing.purchaseorderheader
          set "revisionnumber" = ${fromWrite(row.revisionnumber)(Write.fromPut(TypoShort.put))}::int2,
              "status" = ${fromWrite(row.status)(Write.fromPut(TypoShort.put))}::int2,
              "employeeid" = ${fromWrite(row.employeeid)(Write.fromPut(BusinessentityId.put))}::int4,
              "vendorid" = ${fromWrite(row.vendorid)(Write.fromPut(BusinessentityId.put))}::int4,
              "shipmethodid" = ${fromWrite(row.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4,
              "orderdate" = ${fromWrite(row.orderdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              "shipdate" = ${fromWrite(row.shipdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              "subtotal" = ${fromWrite(row.subtotal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "taxamt" = ${fromWrite(row.taxamt)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "freight" = ${fromWrite(row.freight)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "purchaseorderid" = ${fromWrite(purchaseorderid)(Write.fromPut(PurchaseorderheaderId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    UpdateBuilder("purchasing.purchaseorderheader", PurchaseorderheaderFields, PurchaseorderheaderRow.read)
  }
  override def upsert(unsaved: PurchaseorderheaderRow): ConnectionIO[PurchaseorderheaderRow] = {
    sql"""insert into purchasing.purchaseorderheader("purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate")
          values (
            ${fromWrite(unsaved.purchaseorderid)(Write.fromPut(PurchaseorderheaderId.put))}::int4,
            ${fromWrite(unsaved.revisionnumber)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.status)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.employeeid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.vendorid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4,
            ${fromWrite(unsaved.orderdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.shipdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.subtotal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.taxamt)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.freight)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("purchaseorderid")
          do update set
            "revisionnumber" = EXCLUDED."revisionnumber",
            "status" = EXCLUDED."status",
            "employeeid" = EXCLUDED."employeeid",
            "vendorid" = EXCLUDED."vendorid",
            "shipmethodid" = EXCLUDED."shipmethodid",
            "orderdate" = EXCLUDED."orderdate",
            "shipdate" = EXCLUDED."shipdate",
            "subtotal" = EXCLUDED."subtotal",
            "taxamt" = EXCLUDED."taxamt",
            "freight" = EXCLUDED."freight",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text
       """.query(PurchaseorderheaderRow.read).unique
  }
}
