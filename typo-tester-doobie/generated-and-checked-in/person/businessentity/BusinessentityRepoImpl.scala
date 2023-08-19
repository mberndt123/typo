/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object BusinessentityRepoImpl extends BusinessentityRepo {
  override def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"delete from person.businessentity where businessentityid = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[BusinessentityFields, BusinessentityRow] = {
    DeleteBuilder("person.businessentity", BusinessentityFields)
  }
  override def insert(unsaved: BusinessentityRow): ConnectionIO[BusinessentityRow] = {
    sql"""insert into person.businessentity(businessentityid, rowguid, modifieddate)
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning businessentityid, rowguid, modifieddate::text
       """.query(BusinessentityRow.read).unique
  }
  override def insert(unsaved: BusinessentityRowUnsaved): ConnectionIO[BusinessentityRow] = {
    val fs = List(
      unsaved.businessentityid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"businessentityid"), fr"${fromWrite(value: BusinessentityId)(Write.fromPut(BusinessentityId.put))}::int4"))
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
      sql"""insert into person.businessentity default values
            returning businessentityid, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.businessentity(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning businessentityid, rowguid, modifieddate::text
         """
    }
    q.query(BusinessentityRow.read).unique
    
  }
  override def select: SelectBuilder[BusinessentityFields, BusinessentityRow] = {
    SelectBuilderSql("person.businessentity", BusinessentityFields, BusinessentityRow.read)
  }
  override def selectAll: Stream[ConnectionIO, BusinessentityRow] = {
    sql"select businessentityid, rowguid, modifieddate::text from person.businessentity".query(BusinessentityRow.read).stream
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[BusinessentityRow]] = {
    sql"select businessentityid, rowguid, modifieddate::text from person.businessentity where businessentityid = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}".query(BusinessentityRow.read).option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, BusinessentityRow] = {
    sql"select businessentityid, rowguid, modifieddate::text from person.businessentity where businessentityid = ANY(${businessentityids})".query(BusinessentityRow.read).stream
  }
  override def update(row: BusinessentityRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update person.businessentity
          set rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where businessentityid = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[BusinessentityFields, BusinessentityRow] = {
    UpdateBuilder("person.businessentity", BusinessentityFields, BusinessentityRow.read)
  }
  override def upsert(unsaved: BusinessentityRow): ConnectionIO[BusinessentityRow] = {
    sql"""insert into person.businessentity(businessentityid, rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (businessentityid)
          do update set
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, rowguid, modifieddate::text
       """.query(BusinessentityRow.read).unique
  }
}
