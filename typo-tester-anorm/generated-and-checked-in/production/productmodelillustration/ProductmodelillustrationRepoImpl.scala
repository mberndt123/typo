/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object ProductmodelillustrationRepoImpl extends ProductmodelillustrationRepo {
  override def delete(compositeId: ProductmodelillustrationId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productmodelillustration where productmodelid = ${ParameterValue(compositeId.productmodelid, null, ProductmodelId.toStatement)} AND illustrationid = ${ParameterValue(compositeId.illustrationid, null, IllustrationId.toStatement)}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    DeleteBuilder("production.productmodelillustration", ProductmodelillustrationFields)
  }
  override def insert(unsaved: ProductmodelillustrationRow)(implicit c: Connection): ProductmodelillustrationRow = {
    SQL"""insert into production.productmodelillustration(productmodelid, illustrationid, modifieddate)
          values (${ParameterValue(unsaved.productmodelid, null, ProductmodelId.toStatement)}::int4, ${ParameterValue(unsaved.illustrationid, null, IllustrationId.toStatement)}::int4, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning productmodelid, illustrationid, modifieddate::text
       """
      .executeInsert(ProductmodelillustrationRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductmodelillustrationRowUnsaved)(implicit c: Connection): ProductmodelillustrationRow = {
    val namedParameters = List(
      Some((NamedParameter("productmodelid", ParameterValue(unsaved.productmodelid, null, ProductmodelId.toStatement)), "::int4")),
      Some((NamedParameter("illustrationid", ParameterValue(unsaved.illustrationid, null, IllustrationId.toStatement)), "::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productmodelillustration default values
            returning productmodelid, illustrationid, modifieddate::text
         """
        .executeInsert(ProductmodelillustrationRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productmodelillustration(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productmodelid, illustrationid, modifieddate::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ProductmodelillustrationRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    SelectBuilderSql("production.productmodelillustration", ProductmodelillustrationFields, ProductmodelillustrationRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductmodelillustrationRow] = {
    SQL"""select productmodelid, illustrationid, modifieddate::text
          from production.productmodelillustration
       """.as(ProductmodelillustrationRow.rowParser(1).*)
  }
  override def selectById(compositeId: ProductmodelillustrationId)(implicit c: Connection): Option[ProductmodelillustrationRow] = {
    SQL"""select productmodelid, illustrationid, modifieddate::text
          from production.productmodelillustration
          where productmodelid = ${ParameterValue(compositeId.productmodelid, null, ProductmodelId.toStatement)} AND illustrationid = ${ParameterValue(compositeId.illustrationid, null, IllustrationId.toStatement)}
       """.as(ProductmodelillustrationRow.rowParser(1).singleOpt)
  }
  override def update(row: ProductmodelillustrationRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.productmodelillustration
          set modifieddate = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where productmodelid = ${ParameterValue(compositeId.productmodelid, null, ProductmodelId.toStatement)} AND illustrationid = ${ParameterValue(compositeId.illustrationid, null, IllustrationId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    UpdateBuilder("production.productmodelillustration", ProductmodelillustrationFields, ProductmodelillustrationRow.rowParser)
  }
  override def upsert(unsaved: ProductmodelillustrationRow)(implicit c: Connection): ProductmodelillustrationRow = {
    SQL"""insert into production.productmodelillustration(productmodelid, illustrationid, modifieddate)
          values (
            ${ParameterValue(unsaved.productmodelid, null, ProductmodelId.toStatement)}::int4,
            ${ParameterValue(unsaved.illustrationid, null, IllustrationId.toStatement)}::int4,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict (productmodelid, illustrationid)
          do update set
            modifieddate = EXCLUDED.modifieddate
          returning productmodelid, illustrationid, modifieddate::text
       """
      .executeInsert(ProductmodelillustrationRow.rowParser(1).single)
    
  }
}
