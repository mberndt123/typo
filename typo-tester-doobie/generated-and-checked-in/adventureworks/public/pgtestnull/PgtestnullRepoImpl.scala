/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package pgtestnull

import adventureworks.customtypes.TypoBox
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoCircle
import adventureworks.customtypes.TypoHStore
import adventureworks.customtypes.TypoInet
import adventureworks.customtypes.TypoInstant
import adventureworks.customtypes.TypoInt2Vector
import adventureworks.customtypes.TypoInterval
import adventureworks.customtypes.TypoJson
import adventureworks.customtypes.TypoJsonb
import adventureworks.customtypes.TypoLine
import adventureworks.customtypes.TypoLineSegment
import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoLocalTime
import adventureworks.customtypes.TypoMoney
import adventureworks.customtypes.TypoOffsetTime
import adventureworks.customtypes.TypoPath
import adventureworks.customtypes.TypoPoint
import adventureworks.customtypes.TypoPolygon
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoVector
import adventureworks.customtypes.TypoXml
import adventureworks.public.Mydomain
import adventureworks.public.Myenum
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class PgtestnullRepoImpl extends PgtestnullRepo {
  override def delete: DeleteBuilder[PgtestnullFields, PgtestnullRow] = {
    DeleteBuilder("public.pgtestnull", PgtestnullFields.structure)
  }
  override def insert(unsaved: PgtestnullRow): ConnectionIO[PgtestnullRow] = {
    sql"""insert into public.pgtestnull("bool", "box", "bpchar", "bytea", "char", "circle", "date", "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money", "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time", "timestamp", "timestampz", "timez", "uuid", "varchar", "vector", "xml", "boxes", "bpchares", "chares", "circlees", "datees", "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes", "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees", "timestampes", "timestampzes", "timezes", "uuides", "varchares", "xmles")
          values (${fromWrite(unsaved.bool)(Write.fromPutOption(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.box)(Write.fromPutOption(TypoBox.put))}::box, ${fromWrite(unsaved.bpchar)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.bytea)(Write.fromPutOption(TypoBytea.put))}::bytea, ${fromWrite(unsaved.char)(Write.fromPutOption(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.circle)(Write.fromPutOption(TypoCircle.put))}::circle, ${fromWrite(unsaved.date)(Write.fromPutOption(TypoLocalDate.put))}::date, ${fromWrite(unsaved.float4)(Write.fromPutOption(Meta.FloatMeta.put))}::float4, ${fromWrite(unsaved.float8)(Write.fromPutOption(Meta.DoubleMeta.put))}::float8, ${fromWrite(unsaved.hstore)(Write.fromPutOption(TypoHStore.put))}::hstore, ${fromWrite(unsaved.inet)(Write.fromPutOption(TypoInet.put))}::inet, ${fromWrite(unsaved.int2)(Write.fromPutOption(TypoShort.put))}::int2, ${fromWrite(unsaved.int2vector)(Write.fromPutOption(TypoInt2Vector.put))}::int2vector, ${fromWrite(unsaved.int4)(Write.fromPutOption(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.int8)(Write.fromPutOption(Meta.LongMeta.put))}::int8, ${fromWrite(unsaved.interval)(Write.fromPutOption(TypoInterval.put))}::interval, ${fromWrite(unsaved.json)(Write.fromPutOption(TypoJson.put))}::json, ${fromWrite(unsaved.jsonb)(Write.fromPutOption(TypoJsonb.put))}::jsonb, ${fromWrite(unsaved.line)(Write.fromPutOption(TypoLine.put))}::line, ${fromWrite(unsaved.lseg)(Write.fromPutOption(TypoLineSegment.put))}::lseg, ${fromWrite(unsaved.money)(Write.fromPutOption(TypoMoney.put))}::money, ${fromWrite(unsaved.mydomain)(Write.fromPutOption(Mydomain.put))}::text, ${fromWrite(unsaved.myenum)(Write.fromPutOption(Myenum.put))}::public.myenum, ${fromWrite(unsaved.name)(Write.fromPutOption(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.numeric)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.path)(Write.fromPutOption(TypoPath.put))}::path, ${fromWrite(unsaved.point)(Write.fromPutOption(TypoPoint.put))}::point, ${fromWrite(unsaved.polygon)(Write.fromPutOption(TypoPolygon.put))}::polygon, ${fromWrite(unsaved.text)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.time)(Write.fromPutOption(TypoLocalTime.put))}::time, ${fromWrite(unsaved.timestamp)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.timestampz)(Write.fromPutOption(TypoInstant.put))}::timestamptz, ${fromWrite(unsaved.timez)(Write.fromPutOption(TypoOffsetTime.put))}::timetz, ${fromWrite(unsaved.uuid)(Write.fromPutOption(TypoUUID.put))}::uuid, ${fromWrite(unsaved.varchar)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.vector)(Write.fromPutOption(TypoVector.put))}::vector, ${fromWrite(unsaved.xml)(Write.fromPutOption(TypoXml.put))}::xml, ${fromWrite(unsaved.boxes)(Write.fromPutOption(TypoBox.arrayPut))}::box[], ${fromWrite(unsaved.bpchares)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::bpchar[], ${fromWrite(unsaved.chares)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::bpchar[], ${fromWrite(unsaved.circlees)(Write.fromPutOption(TypoCircle.arrayPut))}::circle[], ${fromWrite(unsaved.datees)(Write.fromPutOption(TypoLocalDate.arrayPut))}::date[], ${fromWrite(unsaved.float4es)(Write.fromPutOption(adventureworks.FloatArrayMeta.put))}::float4[], ${fromWrite(unsaved.float8es)(Write.fromPutOption(adventureworks.DoubleArrayMeta.put))}::float8[], ${fromWrite(unsaved.inetes)(Write.fromPutOption(TypoInet.arrayPut))}::inet[], ${fromWrite(unsaved.int2es)(Write.fromPutOption(TypoShort.arrayPut))}::int2[], ${fromWrite(unsaved.int2vectores)(Write.fromPutOption(TypoInt2Vector.arrayPut))}::int2vector[], ${fromWrite(unsaved.int4es)(Write.fromPutOption(adventureworks.IntegerArrayMeta.put))}::int4[], ${fromWrite(unsaved.int8es)(Write.fromPutOption(adventureworks.LongArrayMeta.put))}::int8[], ${fromWrite(unsaved.intervales)(Write.fromPutOption(TypoInterval.arrayPut))}::interval[], ${fromWrite(unsaved.jsones)(Write.fromPutOption(TypoJson.arrayPut))}::json[], ${fromWrite(unsaved.jsonbes)(Write.fromPutOption(TypoJsonb.arrayPut))}::jsonb[], ${fromWrite(unsaved.linees)(Write.fromPutOption(TypoLine.arrayPut))}::line[], ${fromWrite(unsaved.lseges)(Write.fromPutOption(TypoLineSegment.arrayPut))}::lseg[], ${fromWrite(unsaved.moneyes)(Write.fromPutOption(TypoMoney.arrayPut))}::money[], ${fromWrite(unsaved.myenumes)(Write.fromPutOption(Myenum.arrayPut))}::myenum[], ${fromWrite(unsaved.namees)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::name[], ${fromWrite(unsaved.numerices)(Write.fromPutOption(adventureworks.BigDecimalMeta.put))}::numeric[], ${fromWrite(unsaved.pathes)(Write.fromPutOption(TypoPath.arrayPut))}::path[], ${fromWrite(unsaved.pointes)(Write.fromPutOption(TypoPoint.arrayPut))}::point[], ${fromWrite(unsaved.polygones)(Write.fromPutOption(TypoPolygon.arrayPut))}::polygon[], ${fromWrite(unsaved.textes)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::text[], ${fromWrite(unsaved.timees)(Write.fromPutOption(TypoLocalTime.arrayPut))}::time[], ${fromWrite(unsaved.timestampes)(Write.fromPutOption(TypoLocalDateTime.arrayPut))}::timestamp[], ${fromWrite(unsaved.timestampzes)(Write.fromPutOption(TypoInstant.arrayPut))}::timestamptz[], ${fromWrite(unsaved.timezes)(Write.fromPutOption(TypoOffsetTime.arrayPut))}::timetz[], ${fromWrite(unsaved.uuides)(Write.fromPutOption(TypoUUID.arrayPut))}::uuid[], ${fromWrite(unsaved.varchares)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::varchar[], ${fromWrite(unsaved.xmles)(Write.fromPutOption(TypoXml.arrayPut))}::xml[])
          returning "bool", "box", "bpchar", "bytea", "char", "circle", "date"::text, "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money"::numeric, "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time"::text, "timestamp"::text, "timestampz"::text, "timez"::text, "uuid", "varchar", "vector"::float4[], "xml", "boxes", "bpchares", "chares", "circlees", "datees"::text[], "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes"::numeric[], "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees"::text[], "timestampes"::text[], "timestampzes"::text[], "timezes"::text[], "uuides", "varchares", "xmles"
       """.query(using PgtestnullRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, PgtestnullRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY public.pgtestnull("bool", "box", "bpchar", "bytea", "char", "circle", "date", "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money", "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time", "timestamp", "timestampz", "timez", "uuid", "varchar", "vector", "xml", "boxes", "bpchares", "chares", "circlees", "datees", "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes", "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees", "timestampes", "timestampzes", "timezes", "uuides", "varchares", "xmles") FROM STDIN""").copyIn(unsaved, batchSize)(using PgtestnullRow.text)
  }
  override def select: SelectBuilder[PgtestnullFields, PgtestnullRow] = {
    SelectBuilderSql("public.pgtestnull", PgtestnullFields.structure, PgtestnullRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgtestnullRow] = {
    sql"""select "bool", "box", "bpchar", "bytea", "char", "circle", "date"::text, "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money"::numeric, "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time"::text, "timestamp"::text, "timestampz"::text, "timez"::text, "uuid", "varchar", "vector"::float4[], "xml", "boxes", "bpchares", "chares", "circlees", "datees"::text[], "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes"::numeric[], "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees"::text[], "timestampes"::text[], "timestampzes"::text[], "timezes"::text[], "uuides", "varchares", "xmles" from public.pgtestnull""".query(using PgtestnullRow.read).stream
  }
  override def update: UpdateBuilder[PgtestnullFields, PgtestnullRow] = {
    UpdateBuilder("public.pgtestnull", PgtestnullFields.structure, PgtestnullRow.read)
  }
}
