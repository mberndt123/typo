/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

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

object SalesorderdetailRepoImpl extends SalesorderdetailRepo {
  override def delete(compositeId: SalesorderdetailId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.salesorderdetail where salesorderid = ${compositeId.salesorderid} AND salesorderdetailid = ${compositeId.salesorderdetailid}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[SalesorderdetailFields, SalesorderdetailRow] = {
    DeleteBuilder("sales.salesorderdetail", SalesorderdetailFields)
  }
  override def insert(unsaved: SalesorderdetailRow)(implicit c: Connection): SalesorderdetailRow = {
    SQL"""insert into sales.salesorderdetail(salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate)
          values (${unsaved.salesorderid}::int4, ${unsaved.salesorderdetailid}::int4, ${unsaved.carriertrackingnumber}, ${unsaved.orderqty}::int2, ${unsaved.productid}::int4, ${unsaved.specialofferid}::int4, ${unsaved.unitprice}::numeric, ${unsaved.unitpricediscount}::numeric, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate::text
       """
      .executeInsert(SalesorderdetailRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SalesorderdetailRowUnsaved)(implicit c: Connection): SalesorderdetailRow = {
    val namedParameters = List(
      Some((NamedParameter("salesorderid", ParameterValue.from(unsaved.salesorderid)), "::int4")),
      Some((NamedParameter("carriertrackingnumber", ParameterValue.from(unsaved.carriertrackingnumber)), "")),
      Some((NamedParameter("orderqty", ParameterValue.from(unsaved.orderqty)), "::int2")),
      Some((NamedParameter("productid", ParameterValue.from(unsaved.productid)), "::int4")),
      Some((NamedParameter("specialofferid", ParameterValue.from(unsaved.specialofferid)), "::int4")),
      Some((NamedParameter("unitprice", ParameterValue.from(unsaved.unitprice)), "::numeric")),
      unsaved.salesorderdetailid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("salesorderdetailid", ParameterValue.from[Int](value)), "::int4"))
      },
      unsaved.unitpricediscount match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("unitpricediscount", ParameterValue.from[BigDecimal](value)), "::numeric"))
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
      SQL"""insert into sales.salesorderdetail default values
            returning salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate::text
         """
        .executeInsert(SalesorderdetailRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.salesorderdetail(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(SalesorderdetailRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[SalesorderdetailFields, SalesorderdetailRow] = {
    SelectBuilderSql("sales.salesorderdetail", SalesorderdetailFields, SalesorderdetailRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SalesorderdetailRow] = {
    SQL"""select salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate::text
          from sales.salesorderdetail
       """.as(SalesorderdetailRow.rowParser(1).*)
  }
  override def selectById(compositeId: SalesorderdetailId)(implicit c: Connection): Option[SalesorderdetailRow] = {
    SQL"""select salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate::text
          from sales.salesorderdetail
          where salesorderid = ${compositeId.salesorderid} AND salesorderdetailid = ${compositeId.salesorderdetailid}
       """.as(SalesorderdetailRow.rowParser(1).singleOpt)
  }
  override def update(row: SalesorderdetailRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update sales.salesorderdetail
          set carriertrackingnumber = ${row.carriertrackingnumber},
              orderqty = ${row.orderqty}::int2,
              productid = ${row.productid}::int4,
              specialofferid = ${row.specialofferid}::int4,
              unitprice = ${row.unitprice}::numeric,
              unitpricediscount = ${row.unitpricediscount}::numeric,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where salesorderid = ${compositeId.salesorderid} AND salesorderdetailid = ${compositeId.salesorderdetailid}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[SalesorderdetailFields, SalesorderdetailRow] = {
    UpdateBuilder("sales.salesorderdetail", SalesorderdetailFields, SalesorderdetailRow.rowParser)
  }
  override def upsert(unsaved: SalesorderdetailRow)(implicit c: Connection): SalesorderdetailRow = {
    SQL"""insert into sales.salesorderdetail(salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate)
          values (
            ${unsaved.salesorderid}::int4,
            ${unsaved.salesorderdetailid}::int4,
            ${unsaved.carriertrackingnumber},
            ${unsaved.orderqty}::int2,
            ${unsaved.productid}::int4,
            ${unsaved.specialofferid}::int4,
            ${unsaved.unitprice}::numeric,
            ${unsaved.unitpricediscount}::numeric,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (salesorderid, salesorderdetailid)
          do update set
            carriertrackingnumber = EXCLUDED.carriertrackingnumber,
            orderqty = EXCLUDED.orderqty,
            productid = EXCLUDED.productid,
            specialofferid = EXCLUDED.specialofferid,
            unitprice = EXCLUDED.unitprice,
            unitpricediscount = EXCLUDED.unitpricediscount,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate::text
       """
      .executeInsert(SalesorderdetailRow.rowParser(1).single)
    
  }
}
