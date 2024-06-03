/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package custom
package view_find_all

import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** SQL file: custom/view_find_all.sql */
case class ViewFindAllSqlRow(
  /** Points to [[pg_catalog.pg_namespace.PgNamespaceRow.oid]]
      debug: {"baseColumnName":"oid","baseRelationName":"pg_catalog.pg_namespace","columnClassName":"java.lang.Long","columnDisplaySize":10,"parsedColumnName":{"name":"table_oid","originalName":"table_oid"},"columnName":"table_oid","columnType":"BigInt","columnTypeName":"oid","format":0,"isAutoIncrement":false,"isCaseSensitive":false,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NoNulls","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":10,"scale":0,"tableName":"pg_namespace"} */
  tableOid: /* oid */ Long,
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"table_schema","originalName":"table_schema"},"columnName":"table_schema","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  tableSchema: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"table_name","originalName":"table_name"},"columnName":"table_name","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  tableName: /* nullability unknown */ Option[String],
  /** Points to [[pg_catalog.pg_class.PgClassRow.relkind]]
      debug: {"baseColumnName":"relkind","baseRelationName":"pg_catalog.pg_class","columnClassName":"java.lang.String","columnDisplaySize":1,"parsedColumnName":{"name":"relkind","originalName":"relkind"},"columnName":"relkind","columnType":"Char","columnTypeName":"char","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NoNulls","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":1,"scale":0,"tableName":"pg_class"} */
  relkind: String,
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"view_definition","originalName":"view_definition"},"columnName":"view_definition","columnType":"VarChar","columnTypeName":"varchar","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  viewDefinition: /* nullability unknown */ Option[String]
)

object ViewFindAllSqlRow {
  implicit lazy val reads: Reads[ViewFindAllSqlRow] = Reads[ViewFindAllSqlRow](json => JsResult.fromTry(
      Try(
        ViewFindAllSqlRow(
          tableOid = json.\("table_oid").as(Reads.LongReads),
          tableSchema = json.\("table_schema").toOption.map(_.as(Reads.StringReads)),
          tableName = json.\("table_name").toOption.map(_.as(Reads.StringReads)),
          relkind = json.\("relkind").as(Reads.StringReads),
          viewDefinition = json.\("view_definition").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ViewFindAllSqlRow] = RowParser[ViewFindAllSqlRow] { row =>
    Success(
      ViewFindAllSqlRow(
        tableOid = row(idx + 0)(Column.columnToLong),
        tableSchema = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        tableName = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        relkind = row(idx + 3)(Column.columnToString),
        viewDefinition = row(idx + 4)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[ViewFindAllSqlRow] = OWrites[ViewFindAllSqlRow](o =>
    new JsObject(ListMap[String, JsValue](
      "table_oid" -> Writes.LongWrites.writes(o.tableOid),
      "table_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableName),
      "relkind" -> Writes.StringWrites.writes(o.relkind),
      "view_definition" -> Writes.OptionWrites(Writes.StringWrites).writes(o.viewDefinition)
    ))
  )
}
