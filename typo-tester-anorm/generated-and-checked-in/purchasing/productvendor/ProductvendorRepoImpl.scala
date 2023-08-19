/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import anorm.NamedParameter
import anorm.ParameterMetaData
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object ProductvendorRepoImpl extends ProductvendorRepo {
  override def delete(compositeId: ProductvendorId)(implicit c: Connection): Boolean = {
    SQL"delete from purchasing.productvendor where productid = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND businessentityid = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[ProductvendorFields, ProductvendorRow] = {
    DeleteBuilder("purchasing.productvendor", ProductvendorFields)
  }
  override def insert(unsaved: ProductvendorRow)(implicit c: Connection): ProductvendorRow = {
    SQL"""insert into purchasing.productvendor(productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate)
          values (${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4, ${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.averageleadtime, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.standardprice, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.lastreceiptcost, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric, ${ParameterValue(unsaved.lastreceiptdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp, ${ParameterValue(unsaved.minorderqty, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.maxorderqty, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.onorderqty, null, ToStatement.optionToStatement(ToStatement.intToStatement, ParameterMetaData.IntParameterMetaData))}::int4, ${ParameterValue(unsaved.unitmeasurecode, null, UnitmeasureId.toStatement)}::bpchar, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
       """
      .executeInsert(ProductvendorRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductvendorRowUnsaved)(implicit c: Connection): ProductvendorRow = {
    val namedParameters = List(
      Some((NamedParameter("productid", ParameterValue(unsaved.productid, null, ProductId.toStatement)), "::int4")),
      Some((NamedParameter("businessentityid", ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("averageleadtime", ParameterValue(unsaved.averageleadtime, null, ToStatement.intToStatement)), "::int4")),
      Some((NamedParameter("standardprice", ParameterValue(unsaved.standardprice, null, ToStatement.scalaBigDecimalToStatement)), "::numeric")),
      Some((NamedParameter("lastreceiptcost", ParameterValue(unsaved.lastreceiptcost, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))), "::numeric")),
      Some((NamedParameter("lastreceiptdate", ParameterValue(unsaved.lastreceiptdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))), "::timestamp")),
      Some((NamedParameter("minorderqty", ParameterValue(unsaved.minorderqty, null, ToStatement.intToStatement)), "::int4")),
      Some((NamedParameter("maxorderqty", ParameterValue(unsaved.maxorderqty, null, ToStatement.intToStatement)), "::int4")),
      Some((NamedParameter("onorderqty", ParameterValue(unsaved.onorderqty, null, ToStatement.optionToStatement(ToStatement.intToStatement, ParameterMetaData.IntParameterMetaData))), "::int4")),
      Some((NamedParameter("unitmeasurecode", ParameterValue(unsaved.unitmeasurecode, null, UnitmeasureId.toStatement)), "::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into purchasing.productvendor default values
            returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
         """
        .executeInsert(ProductvendorRow.rowParser(1).single)
    } else {
      val q = s"""insert into purchasing.productvendor(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ProductvendorRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[ProductvendorFields, ProductvendorRow] = {
    SelectBuilderSql("purchasing.productvendor", ProductvendorFields, ProductvendorRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductvendorRow] = {
    SQL"""select productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
          from purchasing.productvendor
       """.as(ProductvendorRow.rowParser(1).*)
  }
  override def selectById(compositeId: ProductvendorId)(implicit c: Connection): Option[ProductvendorRow] = {
    SQL"""select productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
          from purchasing.productvendor
          where productid = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND businessentityid = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)}
       """.as(ProductvendorRow.rowParser(1).singleOpt)
  }
  override def update(row: ProductvendorRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update purchasing.productvendor
          set averageleadtime = ${ParameterValue(row.averageleadtime, null, ToStatement.intToStatement)}::int4,
              standardprice = ${ParameterValue(row.standardprice, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              lastreceiptcost = ${ParameterValue(row.lastreceiptcost, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric,
              lastreceiptdate = ${ParameterValue(row.lastreceiptdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
              minorderqty = ${ParameterValue(row.minorderqty, null, ToStatement.intToStatement)}::int4,
              maxorderqty = ${ParameterValue(row.maxorderqty, null, ToStatement.intToStatement)}::int4,
              onorderqty = ${ParameterValue(row.onorderqty, null, ToStatement.optionToStatement(ToStatement.intToStatement, ParameterMetaData.IntParameterMetaData))}::int4,
              unitmeasurecode = ${ParameterValue(row.unitmeasurecode, null, UnitmeasureId.toStatement)}::bpchar,
              modifieddate = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where productid = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND businessentityid = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[ProductvendorFields, ProductvendorRow] = {
    UpdateBuilder("purchasing.productvendor", ProductvendorFields, ProductvendorRow.rowParser)
  }
  override def upsert(unsaved: ProductvendorRow)(implicit c: Connection): ProductvendorRow = {
    SQL"""insert into purchasing.productvendor(productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate)
          values (
            ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4,
            ${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.averageleadtime, null, ToStatement.intToStatement)}::int4,
            ${ParameterValue(unsaved.standardprice, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.lastreceiptcost, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric,
            ${ParameterValue(unsaved.lastreceiptdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
            ${ParameterValue(unsaved.minorderqty, null, ToStatement.intToStatement)}::int4,
            ${ParameterValue(unsaved.maxorderqty, null, ToStatement.intToStatement)}::int4,
            ${ParameterValue(unsaved.onorderqty, null, ToStatement.optionToStatement(ToStatement.intToStatement, ParameterMetaData.IntParameterMetaData))}::int4,
            ${ParameterValue(unsaved.unitmeasurecode, null, UnitmeasureId.toStatement)}::bpchar,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict (productid, businessentityid)
          do update set
            averageleadtime = EXCLUDED.averageleadtime,
            standardprice = EXCLUDED.standardprice,
            lastreceiptcost = EXCLUDED.lastreceiptcost,
            lastreceiptdate = EXCLUDED.lastreceiptdate,
            minorderqty = EXCLUDED.minorderqty,
            maxorderqty = EXCLUDED.maxorderqty,
            onorderqty = EXCLUDED.onorderqty,
            unitmeasurecode = EXCLUDED.unitmeasurecode,
            modifieddate = EXCLUDED.modifieddate
          returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
       """
      .executeInsert(ProductvendorRow.rowParser(1).single)
    
  }
}
