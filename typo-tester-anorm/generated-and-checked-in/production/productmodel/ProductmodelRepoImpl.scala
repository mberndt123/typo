/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

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

object ProductmodelRepoImpl extends ProductmodelRepo {
  override def delete(productmodelid: ProductmodelId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productmodel where productmodelid = $productmodelid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[ProductmodelFields, ProductmodelRow] = {
    DeleteBuilder("production.productmodel", ProductmodelFields)
  }
  override def insert(unsaved: ProductmodelRow)(implicit c: Connection): ProductmodelRow = {
    SQL"""insert into production.productmodel(productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate)
          values (${unsaved.productmodelid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.catalogdescription}::xml, ${unsaved.instructions}::xml, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate::text
       """
      .executeInsert(ProductmodelRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductmodelRowUnsaved)(implicit c: Connection): ProductmodelRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      Some((NamedParameter("catalogdescription", ParameterValue.from(unsaved.catalogdescription)), "::xml")),
      Some((NamedParameter("instructions", ParameterValue.from(unsaved.instructions)), "::xml")),
      unsaved.productmodelid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("productmodelid", ParameterValue.from[ProductmodelId](value)), "::int4"))
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
      SQL"""insert into production.productmodel default values
            returning productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate::text
         """
        .executeInsert(ProductmodelRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productmodel(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(ProductmodelRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[ProductmodelFields, ProductmodelRow] = {
    SelectBuilderSql("production.productmodel", ProductmodelFields, ProductmodelRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductmodelRow] = {
    SQL"""select productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate::text
          from production.productmodel
       """.as(ProductmodelRow.rowParser(1).*)
  }
  override def selectById(productmodelid: ProductmodelId)(implicit c: Connection): Option[ProductmodelRow] = {
    SQL"""select productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate::text
          from production.productmodel
          where productmodelid = $productmodelid
       """.as(ProductmodelRow.rowParser(1).singleOpt)
  }
  override def selectByIds(productmodelids: Array[ProductmodelId])(implicit c: Connection): List[ProductmodelRow] = {
    SQL"""select productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate::text
          from production.productmodel
          where productmodelid = ANY($productmodelids)
       """.as(ProductmodelRow.rowParser(1).*)
    
  }
  override def update(row: ProductmodelRow)(implicit c: Connection): Boolean = {
    val productmodelid = row.productmodelid
    SQL"""update production.productmodel
          set "name" = ${row.name}::"public"."Name",
              catalogdescription = ${row.catalogdescription}::xml,
              instructions = ${row.instructions}::xml,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where productmodelid = $productmodelid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[ProductmodelFields, ProductmodelRow] = {
    UpdateBuilder("production.productmodel", ProductmodelFields, ProductmodelRow.rowParser)
  }
  override def upsert(unsaved: ProductmodelRow)(implicit c: Connection): ProductmodelRow = {
    SQL"""insert into production.productmodel(productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate)
          values (
            ${unsaved.productmodelid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.catalogdescription}::xml,
            ${unsaved.instructions}::xml,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productmodelid)
          do update set
            "name" = EXCLUDED."name",
            catalogdescription = EXCLUDED.catalogdescription,
            instructions = EXCLUDED.instructions,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate::text
       """
      .executeInsert(ProductmodelRow.rowParser(1).single)
    
  }
}
