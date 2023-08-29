/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Flag
import adventureworks.public.Name
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

object StateprovinceRepoImpl extends StateprovinceRepo {
  override def delete(stateprovinceid: StateprovinceId): ConnectionIO[Boolean] = {
    sql"""delete from person.stateprovince where "stateprovinceid" = ${fromWrite(stateprovinceid)(Write.fromPut(StateprovinceId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[StateprovinceFields, StateprovinceRow] = {
    DeleteBuilder("person.stateprovince", StateprovinceFields)
  }
  override def insert(unsaved: StateprovinceRow): ConnectionIO[StateprovinceRow] = {
    sql"""insert into person.stateprovince("stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4, ${fromWrite(unsaved.stateprovincecode)(Write.fromPut(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.countryregioncode)(Write.fromPut(CountryregionId.put))}, ${fromWrite(unsaved.isonlystateprovinceflag)(Write.fromPut(Flag.put))}::bool, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.territoryid)(Write.fromPut(SalesterritoryId.put))}::int4, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate"::text
       """.query(StateprovinceRow.read).unique
  }
  override def insert(unsaved: StateprovinceRowUnsaved): ConnectionIO[StateprovinceRow] = {
    val fs = List(
      Some((Fragment.const(s""""stateprovincecode""""), fr"${fromWrite(unsaved.stateprovincecode)(Write.fromPut(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const(s""""countryregioncode""""), fr"${fromWrite(unsaved.countryregioncode)(Write.fromPut(CountryregionId.put))}")),
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      Some((Fragment.const(s""""territoryid""""), fr"${fromWrite(unsaved.territoryid)(Write.fromPut(SalesterritoryId.put))}::int4")),
      unsaved.stateprovinceid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""stateprovinceid""""), fr"${fromWrite(value: StateprovinceId)(Write.fromPut(StateprovinceId.put))}::int4"))
      },
      unsaved.isonlystateprovinceflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""isonlystateprovinceflag""""), fr"${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::bool"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""rowguid""""), fr"${fromWrite(value: UUID)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.stateprovince default values
            returning "stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate"::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.stateprovince(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning "stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate"::text
         """
    }
    q.query(StateprovinceRow.read).unique
    
  }
  override def select: SelectBuilder[StateprovinceFields, StateprovinceRow] = {
    SelectBuilderSql("person.stateprovince", StateprovinceFields, StateprovinceRow.read)
  }
  override def selectAll: Stream[ConnectionIO, StateprovinceRow] = {
    sql"""select "stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate"::text from person.stateprovince""".query(StateprovinceRow.read).stream
  }
  override def selectById(stateprovinceid: StateprovinceId): ConnectionIO[Option[StateprovinceRow]] = {
    sql"""select "stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate"::text from person.stateprovince where "stateprovinceid" = ${fromWrite(stateprovinceid)(Write.fromPut(StateprovinceId.put))}""".query(StateprovinceRow.read).option
  }
  override def selectByIds(stateprovinceids: Array[StateprovinceId]): Stream[ConnectionIO, StateprovinceRow] = {
    sql"""select "stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate"::text from person.stateprovince where "stateprovinceid" = ANY(${stateprovinceids})""".query(StateprovinceRow.read).stream
  }
  override def update(row: StateprovinceRow): ConnectionIO[Boolean] = {
    val stateprovinceid = row.stateprovinceid
    sql"""update person.stateprovince
          set "stateprovincecode" = ${fromWrite(row.stateprovincecode)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
              "countryregioncode" = ${fromWrite(row.countryregioncode)(Write.fromPut(CountryregionId.put))},
              "isonlystateprovinceflag" = ${fromWrite(row.isonlystateprovinceflag)(Write.fromPut(Flag.put))}::bool,
              "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "territoryid" = ${fromWrite(row.territoryid)(Write.fromPut(SalesterritoryId.put))}::int4,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "stateprovinceid" = ${fromWrite(stateprovinceid)(Write.fromPut(StateprovinceId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[StateprovinceFields, StateprovinceRow] = {
    UpdateBuilder("person.stateprovince", StateprovinceFields, StateprovinceRow.read)
  }
  override def upsert(unsaved: StateprovinceRow): ConnectionIO[StateprovinceRow] = {
    sql"""insert into person.stateprovince("stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4,
            ${fromWrite(unsaved.stateprovincecode)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.countryregioncode)(Write.fromPut(CountryregionId.put))},
            ${fromWrite(unsaved.isonlystateprovinceflag)(Write.fromPut(Flag.put))}::bool,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.territoryid)(Write.fromPut(SalesterritoryId.put))}::int4,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("stateprovinceid")
          do update set
            "stateprovincecode" = EXCLUDED."stateprovincecode",
            "countryregioncode" = EXCLUDED."countryregioncode",
            "isonlystateprovinceflag" = EXCLUDED."isonlystateprovinceflag",
            "name" = EXCLUDED."name",
            "territoryid" = EXCLUDED."territoryid",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate"::text
       """.query(StateprovinceRow.read).unique
  }
}
