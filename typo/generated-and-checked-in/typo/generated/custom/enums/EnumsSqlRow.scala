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
package enums

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

case class EnumsSqlRow(
  /** Points to [[pg_catalog.pg_namespace.PgNamespaceRow.nspname]]
      debug: {"baseColumnName":"nspname","baseRelationName":"pg_catalog.pg_namespace","columnClassName":"java.lang.String","columnDisplaySize":2147483647,"columnLabel":"enum_schema","columnName":"enum_schema","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NoNulls","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0,"tableName":"pg_namespace"} */
  enumSchema: String,
  /** Points to [[pg_catalog.pg_type.PgTypeRow.typname]]
      debug: {"baseColumnName":"typname","baseRelationName":"pg_catalog.pg_type","columnClassName":"java.lang.String","columnDisplaySize":2147483647,"columnLabel":"enum_name","columnName":"enum_name","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NoNulls","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0,"tableName":"pg_type"} */
  enumName: String,
  /** Points to [[pg_catalog.pg_enum.PgEnumRow.enumsortorder]]
      debug: {"baseColumnName":"enumsortorder","baseRelationName":"pg_catalog.pg_enum","columnClassName":"java.lang.Float","columnDisplaySize":15,"columnLabel":"enum_sort_order","columnName":"enum_sort_order","columnType":"Real","columnTypeName":"float4","format":0,"isAutoIncrement":false,"isCaseSensitive":false,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NoNulls","isReadOnly":false,"isSearchable":true,"isSigned":true,"isWritable":true,"precision":8,"scale":8,"tableName":"pg_enum"} */
  enumSortOrder: Float,
  /** Points to [[pg_catalog.pg_enum.PgEnumRow.enumlabel]]
      debug: {"baseColumnName":"enumlabel","baseRelationName":"pg_catalog.pg_enum","columnClassName":"java.lang.String","columnDisplaySize":2147483647,"columnLabel":"enum_value","columnName":"enum_value","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NoNulls","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0,"tableName":"pg_enum"} */
  enumValue: String
)

object EnumsSqlRow {
  implicit lazy val reads: Reads[EnumsSqlRow] = Reads[EnumsSqlRow](json => JsResult.fromTry(
      Try(
        EnumsSqlRow(
          enumSchema = json.\("enum_schema").as(Reads.StringReads),
          enumName = json.\("enum_name").as(Reads.StringReads),
          enumSortOrder = json.\("enum_sort_order").as(Reads.FloatReads),
          enumValue = json.\("enum_value").as(Reads.StringReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[EnumsSqlRow] = RowParser[EnumsSqlRow] { row =>
    Success(
      EnumsSqlRow(
        enumSchema = row(idx + 0)(Column.columnToString),
        enumName = row(idx + 1)(Column.columnToString),
        enumSortOrder = row(idx + 2)(Column.columnToFloat),
        enumValue = row(idx + 3)(Column.columnToString)
      )
    )
  }
  implicit lazy val writes: OWrites[EnumsSqlRow] = OWrites[EnumsSqlRow](o =>
    new JsObject(ListMap[String, JsValue](
      "enum_schema" -> Writes.StringWrites.writes(o.enumSchema),
      "enum_name" -> Writes.StringWrites.writes(o.enumName),
      "enum_sort_order" -> Writes.FloatWrites.writes(o.enumSortOrder),
      "enum_value" -> Writes.StringWrites.writes(o.enumValue)
    ))
  )
}
