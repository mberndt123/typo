/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorder

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
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

object WorkorderRepoImpl extends WorkorderRepo {
  override def delete(workorderid: WorkorderId): ConnectionIO[Boolean] = {
    sql"delete from production.workorder where workorderid = ${fromWrite(workorderid)(Write.fromPut(WorkorderId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[WorkorderFields, WorkorderRow] = {
    DeleteBuilder("production.workorder", WorkorderFields)
  }
  override def insert(unsaved: WorkorderRow): ConnectionIO[WorkorderRow] = {
    sql"""insert into production.workorder(workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate)
          values (${fromWrite(unsaved.workorderid)(Write.fromPut(WorkorderId.put))}::int4, ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.orderqty)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.scrappedqty)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.duedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.scrapreasonid)(Write.fromPutOption(ScrapreasonId.put))}::int2, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning workorderid, productid, orderqty, scrappedqty, startdate::text, enddate::text, duedate::text, scrapreasonid, modifieddate::text
       """.query(WorkorderRow.read).unique
  }
  override def insert(unsaved: WorkorderRowUnsaved): ConnectionIO[WorkorderRow] = {
    val fs = List(
      Some((Fragment.const(s"productid"), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
      Some((Fragment.const(s"orderqty"), fr"${fromWrite(unsaved.orderqty)(Write.fromPut(Meta.IntMeta.put))}::int4")),
      Some((Fragment.const(s"scrappedqty"), fr"${fromWrite(unsaved.scrappedqty)(Write.fromPut(Meta.IntMeta.put))}::int2")),
      Some((Fragment.const(s"startdate"), fr"${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s"enddate"), fr"${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s"duedate"), fr"${fromWrite(unsaved.duedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s"scrapreasonid"), fr"${fromWrite(unsaved.scrapreasonid)(Write.fromPutOption(ScrapreasonId.put))}::int2")),
      unsaved.workorderid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"workorderid"), fr"${fromWrite(value: WorkorderId)(Write.fromPut(WorkorderId.put))}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.workorder default values
            returning workorderid, productid, orderqty, scrappedqty, startdate::text, enddate::text, duedate::text, scrapreasonid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.workorder(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning workorderid, productid, orderqty, scrappedqty, startdate::text, enddate::text, duedate::text, scrapreasonid, modifieddate::text
         """
    }
    q.query(WorkorderRow.read).unique
    
  }
  override def select: SelectBuilder[WorkorderFields, WorkorderRow] = {
    SelectBuilderSql("production.workorder", WorkorderFields, WorkorderRow.read)
  }
  override def selectAll: Stream[ConnectionIO, WorkorderRow] = {
    sql"select workorderid, productid, orderqty, scrappedqty, startdate::text, enddate::text, duedate::text, scrapreasonid, modifieddate::text from production.workorder".query(WorkorderRow.read).stream
  }
  override def selectById(workorderid: WorkorderId): ConnectionIO[Option[WorkorderRow]] = {
    sql"select workorderid, productid, orderqty, scrappedqty, startdate::text, enddate::text, duedate::text, scrapreasonid, modifieddate::text from production.workorder where workorderid = ${fromWrite(workorderid)(Write.fromPut(WorkorderId.put))}".query(WorkorderRow.read).option
  }
  override def selectByIds(workorderids: Array[WorkorderId]): Stream[ConnectionIO, WorkorderRow] = {
    sql"select workorderid, productid, orderqty, scrappedqty, startdate::text, enddate::text, duedate::text, scrapreasonid, modifieddate::text from production.workorder where workorderid = ANY(${workorderids})".query(WorkorderRow.read).stream
  }
  override def update(row: WorkorderRow): ConnectionIO[Boolean] = {
    val workorderid = row.workorderid
    sql"""update production.workorder
          set productid = ${fromWrite(row.productid)(Write.fromPut(ProductId.put))}::int4,
              orderqty = ${fromWrite(row.orderqty)(Write.fromPut(Meta.IntMeta.put))}::int4,
              scrappedqty = ${fromWrite(row.scrappedqty)(Write.fromPut(Meta.IntMeta.put))}::int2,
              startdate = ${fromWrite(row.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              enddate = ${fromWrite(row.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              duedate = ${fromWrite(row.duedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              scrapreasonid = ${fromWrite(row.scrapreasonid)(Write.fromPutOption(ScrapreasonId.put))}::int2,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where workorderid = ${fromWrite(workorderid)(Write.fromPut(WorkorderId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[WorkorderFields, WorkorderRow] = {
    UpdateBuilder("production.workorder", WorkorderFields, WorkorderRow.read)
  }
  override def upsert(unsaved: WorkorderRow): ConnectionIO[WorkorderRow] = {
    sql"""insert into production.workorder(workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate)
          values (
            ${fromWrite(unsaved.workorderid)(Write.fromPut(WorkorderId.put))}::int4,
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.orderqty)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.scrappedqty)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.duedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.scrapreasonid)(Write.fromPutOption(ScrapreasonId.put))}::int2,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (workorderid)
          do update set
            productid = EXCLUDED.productid,
            orderqty = EXCLUDED.orderqty,
            scrappedqty = EXCLUDED.scrappedqty,
            startdate = EXCLUDED.startdate,
            enddate = EXCLUDED.enddate,
            duedate = EXCLUDED.duedate,
            scrapreasonid = EXCLUDED.scrapreasonid,
            modifieddate = EXCLUDED.modifieddate
          returning workorderid, productid, orderqty, scrappedqty, startdate::text, enddate::text, duedate::text, scrapreasonid, modifieddate::text
       """.query(WorkorderRow.read).unique
  }
}
