/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.public.Name
import anorm.NamedParameter
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

object ProductsubcategoryRepoImpl extends ProductsubcategoryRepo {
  override def delete(productsubcategoryid: ProductsubcategoryId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productsubcategory where productsubcategoryid = ${ParameterValue(productsubcategoryid, null, ProductsubcategoryId.toStatement)}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    DeleteBuilder("production.productsubcategory", ProductsubcategoryFields)
  }
  override def insert(unsaved: ProductsubcategoryRow)(implicit c: Connection): ProductsubcategoryRow = {
    SQL"""insert into production.productsubcategory(productsubcategoryid, productcategoryid, "name", rowguid, modifieddate)
          values (${ParameterValue(unsaved.productsubcategoryid, null, ProductsubcategoryId.toStatement)}::int4, ${ParameterValue(unsaved.productcategoryid, null, ProductcategoryId.toStatement)}::int4, ${ParameterValue(unsaved.name, null, Name.toStatement)}::"public"."Name", ${ParameterValue(unsaved.rowguid, null, ToStatement.uuidToStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
       """
      .executeInsert(ProductsubcategoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductsubcategoryRowUnsaved)(implicit c: Connection): ProductsubcategoryRow = {
    val namedParameters = List(
      Some((NamedParameter("productcategoryid", ParameterValue(unsaved.productcategoryid, null, ProductcategoryId.toStatement)), "::int4")),
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), """::"public"."Name"""")),
      unsaved.productsubcategoryid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("productsubcategoryid", ParameterValue(value, null, ProductsubcategoryId.toStatement)), "::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue(value, null, ToStatement.uuidToStatement)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productsubcategory default values
            returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
         """
        .executeInsert(ProductsubcategoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productsubcategory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ProductsubcategoryRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    SelectBuilderSql("production.productsubcategory", ProductsubcategoryFields, ProductsubcategoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductsubcategoryRow] = {
    SQL"""select productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
          from production.productsubcategory
       """.as(ProductsubcategoryRow.rowParser(1).*)
  }
  override def selectById(productsubcategoryid: ProductsubcategoryId)(implicit c: Connection): Option[ProductsubcategoryRow] = {
    SQL"""select productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
          from production.productsubcategory
          where productsubcategoryid = ${ParameterValue(productsubcategoryid, null, ProductsubcategoryId.toStatement)}
       """.as(ProductsubcategoryRow.rowParser(1).singleOpt)
  }
  override def selectByIds(productsubcategoryids: Array[ProductsubcategoryId])(implicit c: Connection): List[ProductsubcategoryRow] = {
    SQL"""select productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
          from production.productsubcategory
          where productsubcategoryid = ANY(${productsubcategoryids})
       """.as(ProductsubcategoryRow.rowParser(1).*)
    
  }
  override def update(row: ProductsubcategoryRow)(implicit c: Connection): Boolean = {
    val productsubcategoryid = row.productsubcategoryid
    SQL"""update production.productsubcategory
          set productcategoryid = ${ParameterValue(row.productcategoryid, null, ProductcategoryId.toStatement)}::int4,
              "name" = ${ParameterValue(row.name, null, Name.toStatement)}::"public"."Name",
              rowguid = ${ParameterValue(row.rowguid, null, ToStatement.uuidToStatement)}::uuid,
              modifieddate = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where productsubcategoryid = ${ParameterValue(productsubcategoryid, null, ProductsubcategoryId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    UpdateBuilder("production.productsubcategory", ProductsubcategoryFields, ProductsubcategoryRow.rowParser)
  }
  override def upsert(unsaved: ProductsubcategoryRow)(implicit c: Connection): ProductsubcategoryRow = {
    SQL"""insert into production.productsubcategory(productsubcategoryid, productcategoryid, "name", rowguid, modifieddate)
          values (
            ${ParameterValue(unsaved.productsubcategoryid, null, ProductsubcategoryId.toStatement)}::int4,
            ${ParameterValue(unsaved.productcategoryid, null, ProductcategoryId.toStatement)}::int4,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::"public"."Name",
            ${ParameterValue(unsaved.rowguid, null, ToStatement.uuidToStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict (productsubcategoryid)
          do update set
            productcategoryid = EXCLUDED.productcategoryid,
            "name" = EXCLUDED."name",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
       """
      .executeInsert(ProductsubcategoryRow.rowParser(1).single)
    
  }
}
