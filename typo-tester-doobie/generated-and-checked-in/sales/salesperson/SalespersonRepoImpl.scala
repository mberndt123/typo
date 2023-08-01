/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object SalespersonRepoImpl extends SalespersonRepo {
  override def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"delete from sales.salesperson where businessentityid = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[SalespersonFields, SalespersonRow] = {
    DeleteBuilder("sales.salesperson", SalespersonFields)
  }
  override def insert(unsaved: SalespersonRow): ConnectionIO[SalespersonRow] = {
    sql"""insert into sales.salesperson(businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate)
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4, ${fromWrite(unsaved.salesquota)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.bonus)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.commissionpct)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.salesytd)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.saleslastyear)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text
       """.query(SalespersonRow.read).unique
  }
  override def insert(unsaved: SalespersonRowUnsaved): ConnectionIO[SalespersonRow] = {
    val fs = List(
      Some((Fragment.const(s"businessentityid"), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s"territoryid"), fr"${fromWrite(unsaved.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4")),
      Some((Fragment.const(s"salesquota"), fr"${fromWrite(unsaved.salesquota)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      unsaved.bonus match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"bonus"), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.commissionpct match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"commissionpct"), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.salesytd match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"salesytd"), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.saleslastyear match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"saleslastyear"), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${fromWrite(value: UUID)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.salesperson default values
            returning businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.salesperson(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text
         """
    }
    q.query(SalespersonRow.read).unique
    
  }
  override def select: SelectBuilder[SalespersonFields, SalespersonRow] = {
    SelectBuilderSql("sales.salesperson", SalespersonFields, SalespersonRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SalespersonRow] = {
    sql"select businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text from sales.salesperson".query(SalespersonRow.read).stream
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[SalespersonRow]] = {
    sql"select businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text from sales.salesperson where businessentityid = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}".query(SalespersonRow.read).option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, SalespersonRow] = {
    sql"select businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text from sales.salesperson where businessentityid = ANY(${fromWrite(businessentityids)(Write.fromPut(BusinessentityId.arrayPut))})".query(SalespersonRow.read).stream
  }
  override def update(row: SalespersonRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update sales.salesperson
          set territoryid = ${fromWrite(row.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4,
              salesquota = ${fromWrite(row.salesquota)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
              bonus = ${fromWrite(row.bonus)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              commissionpct = ${fromWrite(row.commissionpct)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              salesytd = ${fromWrite(row.salesytd)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              saleslastyear = ${fromWrite(row.saleslastyear)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where businessentityid = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[SalespersonFields, SalespersonRow] = {
    UpdateBuilder("sales.salesperson", SalespersonFields, SalespersonRow.read)
  }
  override def upsert(unsaved: SalespersonRow): ConnectionIO[SalespersonRow] = {
    sql"""insert into sales.salesperson(businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4,
            ${fromWrite(unsaved.salesquota)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.bonus)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.commissionpct)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.salesytd)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.saleslastyear)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (businessentityid)
          do update set
            territoryid = EXCLUDED.territoryid,
            salesquota = EXCLUDED.salesquota,
            bonus = EXCLUDED.bonus,
            commissionpct = EXCLUDED.commissionpct,
            salesytd = EXCLUDED.salesytd,
            saleslastyear = EXCLUDED.saleslastyear,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate::text
       """.query(SalespersonRow.read).unique
  }
}
