/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productdocument;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.production.document.DocumentId;
import adventureworks.production.product.ProductId;
import adventureworks.streamingInsert;
import anorm.BatchSql;
import anorm.NamedParameter;
import anorm.ParameterValue;
import anorm.RowParser;
import anorm.SQL;
import anorm.SimpleSql;
import anorm.SqlStringInterpolation;
import java.sql.Connection;
import scala.annotation.nowarn;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import typo.dsl.UpdateBuilder;

class ProductdocumentRepoImpl extends ProductdocumentRepo {
  def delete: DeleteBuilder[ProductdocumentFields, ProductdocumentRow] = DeleteBuilder("production.productdocument", ProductdocumentFields.structure)
  def deleteById(compositeId: ProductdocumentId)(implicit c: Connection): Boolean = SQL"""delete from production.productdocument where "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND "documentnode" = ${ParameterValue(compositeId.documentnode, null, DocumentId.toStatement)}""".executeUpdate() > 0
  def deleteByIds(compositeIds: Array[ProductdocumentId])(implicit c: Connection): Int = {
    val productid = compositeIds.map(_.productid)
    val documentnode = compositeIds.map(_.documentnode)
    SQL"""delete
          from production.productdocument
          where ("productid", "documentnode")
          in (select unnest(${ParameterValue(productid, null, ProductId.arrayToStatement)}), unnest(${ParameterValue(documentnode, null, DocumentId.arrayToStatement)}))
       """.executeUpdate()
  
  }
  def insert(unsaved: ProductdocumentRow)(implicit c: Connection): ProductdocumentRow = {
    SQL"""insert into production.productdocument("productid", "modifieddate", "documentnode")
           values (${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.documentnode, null, DocumentId.toStatement)})
           returning "productid", "modifieddate"::text, "documentnode"
        """
      .executeInsert(ProductdocumentRow.rowParser(1).single)
  
  }
  def insert(unsaved: ProductdocumentRowUnsaved)(implicit c: Connection): ProductdocumentRow = {
    val namedParameters = List(
      Some((NamedParameter("productid", ParameterValue(unsaved.productid, null, ProductId.toStatement)), "::int4")),
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
    },
    unsaved.documentnode match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((NamedParameter("documentnode", ParameterValue(value, null, DocumentId.toStatement)), ""))
    }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productdocument default values
                            returning "productid", "modifieddate"::text, "documentnode"
                         """
        .executeInsert(ProductdocumentRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productdocument(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                                  returning "productid", "modifieddate"::text, "documentnode"
                               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ProductdocumentRow.rowParser(1).single)
    }
  
  }
  def insertStreaming(unsaved: Iterator[ProductdocumentRow], batchSize: Int = 10000)(implicit c: Connection): Long = streamingInsert(s"""COPY production.productdocument("productid", "modifieddate", "documentnode") FROM STDIN""", batchSize, unsaved)(ProductdocumentRow.text, c)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductdocumentRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = streamingInsert(s"""COPY production.productdocument("productid", "modifieddate", "documentnode") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductdocumentRowUnsaved.text, c)
  def select: SelectBuilder[ProductdocumentFields, ProductdocumentRow] = SelectBuilderSql("production.productdocument", ProductdocumentFields.structure, ProductdocumentRow.rowParser)
  def selectAll(implicit c: Connection): List[ProductdocumentRow] = {
    SQL"""select "productid", "modifieddate"::text, "documentnode"
          from production.productdocument
       """.as(ProductdocumentRow.rowParser(1).*)
  }
  def selectById(compositeId: ProductdocumentId)(implicit c: Connection): Option[ProductdocumentRow] = {
    SQL"""select "productid", "modifieddate"::text, "documentnode"
          from production.productdocument
          where "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND "documentnode" = ${ParameterValue(compositeId.documentnode, null, DocumentId.toStatement)}
       """.as(ProductdocumentRow.rowParser(1).singleOpt)
  }
  def selectByIds(compositeIds: Array[ProductdocumentId])(implicit c: Connection): List[ProductdocumentRow] = {
    val productid = compositeIds.map(_.productid)
    val documentnode = compositeIds.map(_.documentnode)
    SQL"""select "productid", "modifieddate"::text, "documentnode"
          from production.productdocument
          where ("productid", "documentnode")
          in (select unnest(${ParameterValue(productid, null, ProductId.arrayToStatement)}), unnest(${ParameterValue(documentnode, null, DocumentId.arrayToStatement)}))
       """.as(ProductdocumentRow.rowParser(1).*)
  
  }
  def selectByIdsTracked(compositeIds: Array[ProductdocumentId])(implicit c: Connection): Map[ProductdocumentId, ProductdocumentRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  def update: UpdateBuilder[ProductdocumentFields, ProductdocumentRow] = UpdateBuilder("production.productdocument", ProductdocumentFields.structure, ProductdocumentRow.rowParser)
  def update(row: ProductdocumentRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.productdocument
                          set "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
                          where "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND "documentnode" = ${ParameterValue(compositeId.documentnode, null, DocumentId.toStatement)}
                       """.executeUpdate() > 0
  }
  def upsert(unsaved: ProductdocumentRow)(implicit c: Connection): ProductdocumentRow = {
    SQL"""insert into production.productdocument("productid", "modifieddate", "documentnode")
           values (
             ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4,
             ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp,
             ${ParameterValue(unsaved.documentnode, null, DocumentId.toStatement)}
           )
           on conflict ("productid", "documentnode")
           do update set
             "modifieddate" = EXCLUDED."modifieddate"
           returning "productid", "modifieddate"::text, "documentnode"
        """
      .executeInsert(ProductdocumentRow.rowParser(1).single)
  
  }
  def upsertBatch(unsaved: Iterable[ProductdocumentRow])(implicit c: Connection): List[ProductdocumentRow] = {
    def toNamedParameter(row: ProductdocumentRow): List[NamedParameter] = List(
      NamedParameter("productid", ParameterValue(row.productid, null, ProductId.toStatement)),
      NamedParameter("modifieddate", ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)),
      NamedParameter("documentnode", ParameterValue(row.documentnode, null, DocumentId.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into production.productdocument("productid", "modifieddate", "documentnode")
                values ({productid}::int4, {modifieddate}::timestamp, {documentnode})
                on conflict ("productid", "documentnode")
                do update set
                  "modifieddate" = EXCLUDED."modifieddate"
                returning "productid", "modifieddate"::text, "documentnode"
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(ProductdocumentRow.rowParser(1).*)
    }
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[ProductdocumentRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"create temporary table productdocument_TEMP (like production.productdocument) on commit drop".execute(): @nowarn
    streamingInsert(s"""copy productdocument_TEMP("productid", "modifieddate", "documentnode") from stdin""", batchSize, unsaved)(ProductdocumentRow.text, c): @nowarn
    SQL"""insert into production.productdocument("productid", "modifieddate", "documentnode")
          select * from productdocument_TEMP
          on conflict ("productid", "documentnode")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          ;
          drop table productdocument_TEMP;""".executeUpdate()
  }
}