/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.stateprovince.StateprovinceId
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

class AddressRepoImpl extends AddressRepo {
  override def delete: DeleteBuilder[AddressFields, AddressRow] = {
    DeleteBuilder("person.address", AddressFields.structure)
  }
  override def deleteById(addressid: AddressId): ConnectionIO[Boolean] = {
    sql"""delete from person.address where "addressid" = ${fromWrite(addressid)(Write.fromPut(AddressId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(addressids: Array[AddressId]): ConnectionIO[Int] = {
    sql"""delete from person.address where "addressid" = ANY(${addressids})""".update.run
  }
  override def insert(unsaved: AddressRow): ConnectionIO[AddressRow] = {
    sql"""insert into person.address("addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.addressid)(Write.fromPut(AddressId.put))}::int4, ${fromWrite(unsaved.addressline1)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.addressline2)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.city)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4, ${fromWrite(unsaved.postalcode)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.spatiallocation)(Write.fromPutOption(TypoBytea.put))}::bytea, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text
       """.query(using AddressRow.read).unique
  }
  override def insert(unsaved: AddressRowUnsaved): ConnectionIO[AddressRow] = {
    val fs = List(
      Some((Fragment.const0(s""""addressline1""""), fr"${fromWrite(unsaved.addressline1)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""addressline2""""), fr"${fromWrite(unsaved.addressline2)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""city""""), fr"${fromWrite(unsaved.city)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""stateprovinceid""""), fr"${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4")),
      Some((Fragment.const0(s""""postalcode""""), fr"${fromWrite(unsaved.postalcode)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""spatiallocation""""), fr"${fromWrite(unsaved.spatiallocation)(Write.fromPutOption(TypoBytea.put))}::bytea")),
      unsaved.addressid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""addressid""""), fr"${fromWrite(value: AddressId)(Write.fromPut(AddressId.put))}::int4"))
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
      sql"""insert into person.address default values
            returning "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into person.address(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text
         """
    }
    q.query(using AddressRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, AddressRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.address("addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using AddressRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, AddressRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.address("addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "addressid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using AddressRowUnsaved.text)
  }
  override def select: SelectBuilder[AddressFields, AddressRow] = {
    SelectBuilderSql("person.address", AddressFields.structure, AddressRow.read)
  }
  override def selectAll: Stream[ConnectionIO, AddressRow] = {
    sql"""select "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text from person.address""".query(using AddressRow.read).stream
  }
  override def selectById(addressid: AddressId): ConnectionIO[Option[AddressRow]] = {
    sql"""select "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text from person.address where "addressid" = ${fromWrite(addressid)(Write.fromPut(AddressId.put))}""".query(using AddressRow.read).option
  }
  override def selectByIds(addressids: Array[AddressId]): Stream[ConnectionIO, AddressRow] = {
    sql"""select "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text from person.address where "addressid" = ANY(${addressids})""".query(using AddressRow.read).stream
  }
  override def selectByIdsTracked(addressids: Array[AddressId]): ConnectionIO[Map[AddressId, AddressRow]] = {
    selectByIds(addressids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.addressid, x)).toMap
      addressids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[AddressFields, AddressRow] = {
    UpdateBuilder("person.address", AddressFields.structure, AddressRow.read)
  }
  override def update(row: AddressRow): ConnectionIO[Boolean] = {
    val addressid = row.addressid
    sql"""update person.address
          set "addressline1" = ${fromWrite(row.addressline1)(Write.fromPut(Meta.StringMeta.put))},
              "addressline2" = ${fromWrite(row.addressline2)(Write.fromPutOption(Meta.StringMeta.put))},
              "city" = ${fromWrite(row.city)(Write.fromPut(Meta.StringMeta.put))},
              "stateprovinceid" = ${fromWrite(row.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4,
              "postalcode" = ${fromWrite(row.postalcode)(Write.fromPut(Meta.StringMeta.put))},
              "spatiallocation" = ${fromWrite(row.spatiallocation)(Write.fromPutOption(TypoBytea.put))}::bytea,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "addressid" = ${fromWrite(addressid)(Write.fromPut(AddressId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: AddressRow): ConnectionIO[AddressRow] = {
    sql"""insert into person.address("addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.addressid)(Write.fromPut(AddressId.put))}::int4,
            ${fromWrite(unsaved.addressline1)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.addressline2)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.city)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4,
            ${fromWrite(unsaved.postalcode)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.spatiallocation)(Write.fromPutOption(TypoBytea.put))}::bytea,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("addressid")
          do update set
            "addressline1" = EXCLUDED."addressline1",
            "addressline2" = EXCLUDED."addressline2",
            "city" = EXCLUDED."city",
            "stateprovinceid" = EXCLUDED."stateprovinceid",
            "postalcode" = EXCLUDED."postalcode",
            "spatiallocation" = EXCLUDED."spatiallocation",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text
       """.query(using AddressRow.read).unique
  }
  override def upsertBatch(unsaved: List[AddressRow]): Stream[ConnectionIO, AddressRow] = {
    Update[AddressRow](
      s"""insert into person.address("addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate")
          values (?::int4,?,?,?,?::int4,?,?::bytea,?::uuid,?::timestamp)
          on conflict ("addressid")
          do update set
            "addressline1" = EXCLUDED."addressline1",
            "addressline2" = EXCLUDED."addressline2",
            "city" = EXCLUDED."city",
            "stateprovinceid" = EXCLUDED."stateprovinceid",
            "postalcode" = EXCLUDED."postalcode",
            "spatiallocation" = EXCLUDED."spatiallocation",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text"""
    )(using AddressRow.write)
    .updateManyWithGeneratedKeys[AddressRow]("addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate")(unsaved)(using catsStdInstancesForList, AddressRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, AddressRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table address_TEMP (like person.address) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy address_TEMP("addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using AddressRow.text)
      res <- sql"""insert into person.address("addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate")
                   select * from address_TEMP
                   on conflict ("addressid")
                   do update set
                     "addressline1" = EXCLUDED."addressline1",
                     "addressline2" = EXCLUDED."addressline2",
                     "city" = EXCLUDED."city",
                     "stateprovinceid" = EXCLUDED."stateprovinceid",
                     "postalcode" = EXCLUDED."postalcode",
                     "spatiallocation" = EXCLUDED."spatiallocation",
                     "rowguid" = EXCLUDED."rowguid",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table address_TEMP;""".update.run
    } yield res
  }
}
