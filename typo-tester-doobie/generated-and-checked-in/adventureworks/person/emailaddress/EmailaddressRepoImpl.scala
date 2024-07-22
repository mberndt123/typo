/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.emailaddress

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
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

class EmailaddressRepoImpl extends EmailaddressRepo {
  override def delete: DeleteBuilder[EmailaddressFields, EmailaddressRow] = {
    DeleteBuilder("person.emailaddress", EmailaddressFields.structure)
  }
  override def deleteById(compositeId: EmailaddressId): ConnectionIO[Boolean] = {
    sql"""delete from person.emailaddress where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "emailaddressid" = ${fromWrite(compositeId.emailaddressid)(Write.fromPut(Meta.IntMeta.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[EmailaddressId]): ConnectionIO[Int] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val emailaddressid = compositeIds.map(_.emailaddressid)
    sql"""delete
          from person.emailaddress
          where ("businessentityid", "emailaddressid")
          in (select unnest(${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.arrayPut))}), unnest(${fromWrite(emailaddressid)(Write.fromPut(adventureworks.IntegerArrayMeta.put))}))
       """.update.run
    
  }
  override def insert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow] = {
    sql"""insert into person.emailaddress("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.emailaddressid)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.emailaddress)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text
       """.query(using EmailaddressRow.read).unique
  }
  override def insert(unsaved: EmailaddressRowUnsaved): ConnectionIO[EmailaddressRow] = {
    val fs = List(
      Some((Fragment.const0(s""""businessentityid""""), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const0(s""""emailaddress""""), fr"${fromWrite(unsaved.emailaddress)(Write.fromPutOption(Meta.StringMeta.put))}")),
      unsaved.emailaddressid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""emailaddressid""""), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int4"))
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
      sql"""insert into person.emailaddress default values
            returning "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into person.emailaddress(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text
         """
    }
    q.query(using EmailaddressRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, EmailaddressRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.emailaddress("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using EmailaddressRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, EmailaddressRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.emailaddress("businessentityid", "emailaddress", "emailaddressid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using EmailaddressRowUnsaved.text)
  }
  override def select: SelectBuilder[EmailaddressFields, EmailaddressRow] = {
    SelectBuilderSql("person.emailaddress", EmailaddressFields.structure, EmailaddressRow.read)
  }
  override def selectAll: Stream[ConnectionIO, EmailaddressRow] = {
    sql"""select "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text from person.emailaddress""".query(using EmailaddressRow.read).stream
  }
  override def selectById(compositeId: EmailaddressId): ConnectionIO[Option[EmailaddressRow]] = {
    sql"""select "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text from person.emailaddress where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "emailaddressid" = ${fromWrite(compositeId.emailaddressid)(Write.fromPut(Meta.IntMeta.put))}""".query(using EmailaddressRow.read).option
  }
  override def selectByIds(compositeIds: Array[EmailaddressId]): Stream[ConnectionIO, EmailaddressRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val emailaddressid = compositeIds.map(_.emailaddressid)
    sql"""select "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text
          from person.emailaddress
          where ("businessentityid", "emailaddressid") 
          in (select unnest(${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.arrayPut))}), unnest(${fromWrite(emailaddressid)(Write.fromPut(adventureworks.IntegerArrayMeta.put))}))
       """.query(using EmailaddressRow.read).stream
    
  }
  override def selectByIdsTracked(compositeIds: Array[EmailaddressId]): ConnectionIO[Map[EmailaddressId, EmailaddressRow]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[EmailaddressFields, EmailaddressRow] = {
    UpdateBuilder("person.emailaddress", EmailaddressFields.structure, EmailaddressRow.read)
  }
  override def update(row: EmailaddressRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update person.emailaddress
          set "emailaddress" = ${fromWrite(row.emailaddress)(Write.fromPutOption(Meta.StringMeta.put))},
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "emailaddressid" = ${fromWrite(compositeId.emailaddressid)(Write.fromPut(Meta.IntMeta.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow] = {
    sql"""insert into person.emailaddress("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.emailaddressid)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.emailaddress)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("businessentityid", "emailaddressid")
          do update set
            "emailaddress" = EXCLUDED."emailaddress",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text
       """.query(using EmailaddressRow.read).unique
  }
  override def upsertBatch(unsaved: List[EmailaddressRow]): Stream[ConnectionIO, EmailaddressRow] = {
    Update[EmailaddressRow](
      s"""insert into person.emailaddress("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")
          values (?::int4,?::int4,?,?::uuid,?::timestamp)
          on conflict ("businessentityid", "emailaddressid")
          do update set
            "emailaddress" = EXCLUDED."emailaddress",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text"""
    )(using EmailaddressRow.write)
    .updateManyWithGeneratedKeys[EmailaddressRow]("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")(unsaved)(using catsStdInstancesForList, EmailaddressRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, EmailaddressRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table emailaddress_TEMP (like person.emailaddress) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy emailaddress_TEMP("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using EmailaddressRow.text)
      res <- sql"""insert into person.emailaddress("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")
                   select * from emailaddress_TEMP
                   on conflict ("businessentityid", "emailaddressid")
                   do update set
                     "emailaddress" = EXCLUDED."emailaddress",
                     "rowguid" = EXCLUDED."rowguid",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table emailaddress_TEMP;""".update.run
    } yield res
  }
}
