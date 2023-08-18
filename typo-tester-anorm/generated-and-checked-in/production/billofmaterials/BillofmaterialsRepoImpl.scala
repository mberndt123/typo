/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object BillofmaterialsRepoImpl extends BillofmaterialsRepo {
  override def delete(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Boolean = {
    SQL"delete from production.billofmaterials where billofmaterialsid = $billofmaterialsid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    DeleteBuilder("production.billofmaterials", BillofmaterialsFields)
  }
  override def insert(unsaved: BillofmaterialsRow)(implicit c: Connection): BillofmaterialsRow = {
    SQL"""insert into production.billofmaterials(billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate)
          values (${unsaved.billofmaterialsid}::int4, ${unsaved.productassemblyid}::int4, ${unsaved.componentid}::int4, ${unsaved.startdate}::timestamp, ${unsaved.enddate}::timestamp, ${unsaved.unitmeasurecode}::bpchar, ${unsaved.bomlevel}::int2, ${unsaved.perassemblyqty}::numeric, ${unsaved.modifieddate}::timestamp)
          returning billofmaterialsid, productassemblyid, componentid, startdate::text, enddate::text, unitmeasurecode, bomlevel, perassemblyqty, modifieddate::text
       """
      .executeInsert(BillofmaterialsRow.rowParser(1).single)
    
  }
  override def insert(unsaved: BillofmaterialsRowUnsaved)(implicit c: Connection): BillofmaterialsRow = {
    val namedParameters = List(
      Some((NamedParameter("productassemblyid", ParameterValue.from(unsaved.productassemblyid)), "::int4")),
      Some((NamedParameter("componentid", ParameterValue.from(unsaved.componentid)), "::int4")),
      Some((NamedParameter("enddate", ParameterValue.from(unsaved.enddate)), "::timestamp")),
      Some((NamedParameter("unitmeasurecode", ParameterValue.from(unsaved.unitmeasurecode)), "::bpchar")),
      Some((NamedParameter("bomlevel", ParameterValue.from(unsaved.bomlevel)), "::int2")),
      unsaved.billofmaterialsid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("billofmaterialsid", ParameterValue.from[BillofmaterialsId](value)), "::int4"))
      },
      unsaved.startdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("startdate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      },
      unsaved.perassemblyqty match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("perassemblyqty", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.billofmaterials default values
            returning billofmaterialsid, productassemblyid, componentid, startdate::text, enddate::text, unitmeasurecode, bomlevel, perassemblyqty, modifieddate::text
         """
        .executeInsert(BillofmaterialsRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.billofmaterials(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning billofmaterialsid, productassemblyid, componentid, startdate::text, enddate::text, unitmeasurecode, bomlevel, perassemblyqty, modifieddate::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser(Success(_)))
        .executeInsert(BillofmaterialsRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    SelectBuilderSql("production.billofmaterials", BillofmaterialsFields, BillofmaterialsRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[BillofmaterialsRow] = {
    SQL"""select billofmaterialsid, productassemblyid, componentid, startdate::text, enddate::text, unitmeasurecode, bomlevel, perassemblyqty, modifieddate::text
          from production.billofmaterials
       """.as(BillofmaterialsRow.rowParser(1).*)
  }
  override def selectById(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Option[BillofmaterialsRow] = {
    SQL"""select billofmaterialsid, productassemblyid, componentid, startdate::text, enddate::text, unitmeasurecode, bomlevel, perassemblyqty, modifieddate::text
          from production.billofmaterials
          where billofmaterialsid = $billofmaterialsid
       """.as(BillofmaterialsRow.rowParser(1).singleOpt)
  }
  override def selectByIds(billofmaterialsids: Array[BillofmaterialsId])(implicit c: Connection): List[BillofmaterialsRow] = {
    SQL"""select billofmaterialsid, productassemblyid, componentid, startdate::text, enddate::text, unitmeasurecode, bomlevel, perassemblyqty, modifieddate::text
          from production.billofmaterials
          where billofmaterialsid = ANY($billofmaterialsids)
       """.as(BillofmaterialsRow.rowParser(1).*)
    
  }
  override def update(row: BillofmaterialsRow)(implicit c: Connection): Boolean = {
    val billofmaterialsid = row.billofmaterialsid
    SQL"""update production.billofmaterials
          set productassemblyid = ${row.productassemblyid}::int4,
              componentid = ${row.componentid}::int4,
              startdate = ${row.startdate}::timestamp,
              enddate = ${row.enddate}::timestamp,
              unitmeasurecode = ${row.unitmeasurecode}::bpchar,
              bomlevel = ${row.bomlevel}::int2,
              perassemblyqty = ${row.perassemblyqty}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where billofmaterialsid = $billofmaterialsid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    UpdateBuilder("production.billofmaterials", BillofmaterialsFields, BillofmaterialsRow.rowParser)
  }
  override def upsert(unsaved: BillofmaterialsRow)(implicit c: Connection): BillofmaterialsRow = {
    SQL"""insert into production.billofmaterials(billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate)
          values (
            ${unsaved.billofmaterialsid}::int4,
            ${unsaved.productassemblyid}::int4,
            ${unsaved.componentid}::int4,
            ${unsaved.startdate}::timestamp,
            ${unsaved.enddate}::timestamp,
            ${unsaved.unitmeasurecode}::bpchar,
            ${unsaved.bomlevel}::int2,
            ${unsaved.perassemblyqty}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (billofmaterialsid)
          do update set
            productassemblyid = EXCLUDED.productassemblyid,
            componentid = EXCLUDED.componentid,
            startdate = EXCLUDED.startdate,
            enddate = EXCLUDED.enddate,
            unitmeasurecode = EXCLUDED.unitmeasurecode,
            bomlevel = EXCLUDED.bomlevel,
            perassemblyqty = EXCLUDED.perassemblyqty,
            modifieddate = EXCLUDED.modifieddate
          returning billofmaterialsid, productassemblyid, componentid, startdate::text, enddate::text, unitmeasurecode, bomlevel, perassemblyqty, modifieddate::text
       """
      .executeInsert(BillofmaterialsRow.rowParser(1).single)
    
  }
}
