/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object ShipmethodRepoImpl extends ShipmethodRepo {
  override def delete(shipmethodid: ShipmethodId)(implicit c: Connection): Boolean = {
    SQL"delete from purchasing.shipmethod where shipmethodid = $shipmethodid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[ShipmethodFields, ShipmethodRow] = {
    DeleteBuilder("purchasing.shipmethod", ShipmethodFields)
  }
  override def insert(unsaved: ShipmethodRow)(implicit c: Connection): ShipmethodRow = {
    SQL"""insert into purchasing.shipmethod(shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate)
          values (${unsaved.shipmethodid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.shipbase}::numeric, ${unsaved.shiprate}::numeric, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
       """
      .executeInsert(ShipmethodRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ShipmethodRowUnsaved)(implicit c: Connection): ShipmethodRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.shipmethodid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("shipmethodid", ParameterValue.from[ShipmethodId](value)), "::int4"))
      },
      unsaved.shipbase match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("shipbase", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.shiprate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("shiprate", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into purchasing.shipmethod default values
            returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
         """
        .executeInsert(ShipmethodRow.rowParser(1).single)
    } else {
      val q = s"""insert into purchasing.shipmethod(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(ShipmethodRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[ShipmethodFields, ShipmethodRow] = {
    SelectBuilderSql("purchasing.shipmethod", ShipmethodFields, ShipmethodRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ShipmethodRow] = {
    SQL"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
          from purchasing.shipmethod
       """.as(ShipmethodRow.rowParser(1).*)
  }
  override def selectById(shipmethodid: ShipmethodId)(implicit c: Connection): Option[ShipmethodRow] = {
    SQL"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
          from purchasing.shipmethod
          where shipmethodid = $shipmethodid
       """.as(ShipmethodRow.rowParser(1).singleOpt)
  }
  override def selectByIds(shipmethodids: Array[ShipmethodId])(implicit c: Connection): List[ShipmethodRow] = {
    SQL"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
          from purchasing.shipmethod
          where shipmethodid = ANY($shipmethodids)
       """.as(ShipmethodRow.rowParser(1).*)
    
  }
  override def update(row: ShipmethodRow)(implicit c: Connection): Boolean = {
    val shipmethodid = row.shipmethodid
    SQL"""update purchasing.shipmethod
          set "name" = ${row.name}::"public"."Name",
              shipbase = ${row.shipbase}::numeric,
              shiprate = ${row.shiprate}::numeric,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where shipmethodid = $shipmethodid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[ShipmethodFields, ShipmethodRow] = {
    UpdateBuilder("purchasing.shipmethod", ShipmethodFields, ShipmethodRow.rowParser)
  }
  override def upsert(unsaved: ShipmethodRow)(implicit c: Connection): ShipmethodRow = {
    SQL"""insert into purchasing.shipmethod(shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate)
          values (
            ${unsaved.shipmethodid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.shipbase}::numeric,
            ${unsaved.shiprate}::numeric,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (shipmethodid)
          do update set
            "name" = EXCLUDED."name",
            shipbase = EXCLUDED.shipbase,
            shiprate = EXCLUDED.shiprate,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
       """
      .executeInsert(ShipmethodRow.rowParser(1).single)
    
  }
}
