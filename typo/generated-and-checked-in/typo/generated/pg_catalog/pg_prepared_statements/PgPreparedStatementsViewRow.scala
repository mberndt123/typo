/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog
package pg_prepared_statements

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
import typo.generated.customtypes.TypoInstant
import typo.generated.customtypes.TypoRegtype

/** View: pg_catalog.pg_prepared_statements */
case class PgPreparedStatementsViewRow(
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"name","originalName":"name"},"columnName":"name","columnType":"VarChar","columnTypeName":"text","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  name: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"statement","originalName":"statement"},"columnName":"statement","columnType":"VarChar","columnTypeName":"text","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  statement: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.sql.Timestamp","columnDisplaySize":35,"parsedColumnName":{"name":"prepare_time","originalName":"prepare_time"},"columnName":"prepare_time","columnType":"Timestamp","columnTypeName":"timestamptz","format":0,"isAutoIncrement":false,"isCaseSensitive":false,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":35,"scale":6} */
  prepareTime: /* nullability unknown */ Option[TypoInstant],
  /** debug: {"columnClassName":"java.sql.Array","columnDisplaySize":2147483647,"parsedColumnName":{"name":"parameter_types","originalName":"parameter_types"},"columnName":"parameter_types","columnType":"Array","columnTypeName":"_regtype","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  parameterTypes: /* nullability unknown */ Option[Array[TypoRegtype]],
  /** debug: {"columnClassName":"java.lang.Boolean","columnDisplaySize":1,"parsedColumnName":{"name":"from_sql","originalName":"from_sql"},"columnName":"from_sql","columnType":"Bit","columnTypeName":"bool","format":0,"isAutoIncrement":false,"isCaseSensitive":false,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":1,"scale":0} */
  fromSql: /* nullability unknown */ Option[Boolean]
)

object PgPreparedStatementsViewRow {
  implicit lazy val reads: Reads[PgPreparedStatementsViewRow] = Reads[PgPreparedStatementsViewRow](json => JsResult.fromTry(
      Try(
        PgPreparedStatementsViewRow(
          name = json.\("name").toOption.map(_.as(Reads.StringReads)),
          statement = json.\("statement").toOption.map(_.as(Reads.StringReads)),
          prepareTime = json.\("prepare_time").toOption.map(_.as(TypoInstant.reads)),
          parameterTypes = json.\("parameter_types").toOption.map(_.as(Reads.ArrayReads[TypoRegtype](using TypoRegtype.reads, implicitly))),
          fromSql = json.\("from_sql").toOption.map(_.as(Reads.BooleanReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgPreparedStatementsViewRow] = RowParser[PgPreparedStatementsViewRow] { row =>
    Success(
      PgPreparedStatementsViewRow(
        name = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        statement = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        prepareTime = row(idx + 2)(Column.columnToOption(TypoInstant.column)),
        parameterTypes = row(idx + 3)(Column.columnToOption(TypoRegtype.arrayColumn)),
        fromSql = row(idx + 4)(Column.columnToOption(Column.columnToBoolean))
      )
    )
  }
  implicit lazy val writes: OWrites[PgPreparedStatementsViewRow] = OWrites[PgPreparedStatementsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.name),
      "statement" -> Writes.OptionWrites(Writes.StringWrites).writes(o.statement),
      "prepare_time" -> Writes.OptionWrites(TypoInstant.writes).writes(o.prepareTime),
      "parameter_types" -> Writes.OptionWrites(Writes.arrayWrites[TypoRegtype](using implicitly, TypoRegtype.writes)).writes(o.parameterTypes),
      "from_sql" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.fromSql)
    ))
  )
}
