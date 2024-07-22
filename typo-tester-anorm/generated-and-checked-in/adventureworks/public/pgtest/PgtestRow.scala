/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public.pgtest;

import adventureworks.Text;
import adventureworks.customtypes.TypoBox;
import adventureworks.customtypes.TypoBytea;
import adventureworks.customtypes.TypoCircle;
import adventureworks.customtypes.TypoHStore;
import adventureworks.customtypes.TypoInet;
import adventureworks.customtypes.TypoInstant;
import adventureworks.customtypes.TypoInt2Vector;
import adventureworks.customtypes.TypoInterval;
import adventureworks.customtypes.TypoJson;
import adventureworks.customtypes.TypoJsonb;
import adventureworks.customtypes.TypoLine;
import adventureworks.customtypes.TypoLineSegment;
import adventureworks.customtypes.TypoLocalDate;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoLocalTime;
import adventureworks.customtypes.TypoMoney;
import adventureworks.customtypes.TypoOffsetTime;
import adventureworks.customtypes.TypoPath;
import adventureworks.customtypes.TypoPoint;
import adventureworks.customtypes.TypoPolygon;
import adventureworks.customtypes.TypoShort;
import adventureworks.customtypes.TypoUUID;
import adventureworks.customtypes.TypoVector;
import adventureworks.customtypes.TypoXml;
import adventureworks.public.Mydomain;
import adventureworks.public.Myenum;
import anorm.Column;
import anorm.RowParser;
import anorm.Success;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import play.api.libs.json.Writes;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** Table: public.pgtest */
case class PgtestRow(
  bool: Boolean,
  box: TypoBox,
  bpchar: /* bpchar, max 3 chars */ String,
  bytea: TypoBytea,
  char: /* bpchar, max 1 chars */ String,
  circle: TypoCircle,
  date: TypoLocalDate,
  float4: Float,
  float8: Double,
  hstore: TypoHStore,
  inet: TypoInet,
  int2: TypoShort,
  int2vector: TypoInt2Vector,
  int4: Int,
  int8: Long,
  interval: TypoInterval,
  json: TypoJson,
  jsonb: TypoJsonb,
  line: TypoLine,
  lseg: TypoLineSegment,
  money: TypoMoney,
  mydomain: Mydomain,
  myenum: Myenum,
  name: String,
  numeric: BigDecimal,
  path: TypoPath,
  point: TypoPoint,
  polygon: TypoPolygon,
  text: String,
  time: TypoLocalTime,
  timestamp: TypoLocalDateTime,
  timestampz: TypoInstant,
  timez: TypoOffsetTime,
  uuid: TypoUUID,
  varchar: String,
  vector: TypoVector,
  xml: TypoXml,
  boxes: Array[TypoBox],
  bpchares: Array[/* bpchar */ String],
  chares: Array[/* bpchar */ String],
  circlees: Array[TypoCircle],
  datees: Array[TypoLocalDate],
  float4es: Array[Float],
  float8es: Array[Double],
  inetes: Array[TypoInet],
  int2es: Array[TypoShort],
  int2vectores: Array[TypoInt2Vector],
  int4es: Array[Int],
  int8es: Array[Long],
  intervales: Array[TypoInterval],
  jsones: Array[TypoJson],
  jsonbes: Array[TypoJsonb],
  linees: Array[TypoLine],
  lseges: Array[TypoLineSegment],
  moneyes: Array[TypoMoney],
  mydomaines: Array[Mydomain],
  myenumes: Array[Myenum],
  namees: Array[String],
  numerices: Array[BigDecimal],
  pathes: Array[TypoPath],
  pointes: Array[TypoPoint],
  polygones: Array[TypoPolygon],
  textes: Array[String],
  timees: Array[TypoLocalTime],
  timestampes: Array[TypoLocalDateTime],
  timestampzes: Array[TypoInstant],
  timezes: Array[TypoOffsetTime],
  uuides: Array[TypoUUID],
  varchares: Array[String],
  xmles: Array[TypoXml]
)

object PgtestRow {
  implicit lazy val reads: Reads[PgtestRow] = {
    Reads[PgtestRow](json => JsResult.fromTry(
        Try(
          PgtestRow(
            bool = json.\("bool").as(Reads.BooleanReads),
            box = json.\("box").as(TypoBox.reads),
            bpchar = json.\("bpchar").as(Reads.StringReads),
            bytea = json.\("bytea").as(TypoBytea.reads),
            char = json.\("char").as(Reads.StringReads),
            circle = json.\("circle").as(TypoCircle.reads),
            date = json.\("date").as(TypoLocalDate.reads),
            float4 = json.\("float4").as(Reads.FloatReads),
            float8 = json.\("float8").as(Reads.DoubleReads),
            hstore = json.\("hstore").as(TypoHStore.reads),
            inet = json.\("inet").as(TypoInet.reads),
            int2 = json.\("int2").as(TypoShort.reads),
            int2vector = json.\("int2vector").as(TypoInt2Vector.reads),
            int4 = json.\("int4").as(Reads.IntReads),
            int8 = json.\("int8").as(Reads.LongReads),
            interval = json.\("interval").as(TypoInterval.reads),
            json = json.\("json").as(TypoJson.reads),
            jsonb = json.\("jsonb").as(TypoJsonb.reads),
            line = json.\("line").as(TypoLine.reads),
            lseg = json.\("lseg").as(TypoLineSegment.reads),
            money = json.\("money").as(TypoMoney.reads),
            mydomain = json.\("mydomain").as(Mydomain.reads),
            myenum = json.\("myenum").as(Myenum.reads),
            name = json.\("name").as(Reads.StringReads),
            numeric = json.\("numeric").as(Reads.bigDecReads),
            path = json.\("path").as(TypoPath.reads),
            point = json.\("point").as(TypoPoint.reads),
            polygon = json.\("polygon").as(TypoPolygon.reads),
            text = json.\("text").as(Reads.StringReads),
            time = json.\("time").as(TypoLocalTime.reads),
            timestamp = json.\("timestamp").as(TypoLocalDateTime.reads),
            timestampz = json.\("timestampz").as(TypoInstant.reads),
            timez = json.\("timez").as(TypoOffsetTime.reads),
            uuid = json.\("uuid").as(TypoUUID.reads),
            varchar = json.\("varchar").as(Reads.StringReads),
            vector = json.\("vector").as(TypoVector.reads),
            xml = json.\("xml").as(TypoXml.reads),
            boxes = json.\("boxes").as(Reads.ArrayReads[TypoBox](using TypoBox.reads, implicitly)),
            bpchares = json.\("bpchares").as(Reads.ArrayReads[String](using Reads.StringReads, implicitly)),
            chares = json.\("chares").as(Reads.ArrayReads[String](using Reads.StringReads, implicitly)),
            circlees = json.\("circlees").as(Reads.ArrayReads[TypoCircle](using TypoCircle.reads, implicitly)),
            datees = json.\("datees").as(Reads.ArrayReads[TypoLocalDate](using TypoLocalDate.reads, implicitly)),
            float4es = json.\("float4es").as(Reads.ArrayReads[Float](using Reads.FloatReads, implicitly)),
            float8es = json.\("float8es").as(Reads.ArrayReads[Double](using Reads.DoubleReads, implicitly)),
            inetes = json.\("inetes").as(Reads.ArrayReads[TypoInet](using TypoInet.reads, implicitly)),
            int2es = json.\("int2es").as(Reads.ArrayReads[TypoShort](using TypoShort.reads, implicitly)),
            int2vectores = json.\("int2vectores").as(Reads.ArrayReads[TypoInt2Vector](using TypoInt2Vector.reads, implicitly)),
            int4es = json.\("int4es").as(Reads.ArrayReads[Int](using Reads.IntReads, implicitly)),
            int8es = json.\("int8es").as(Reads.ArrayReads[Long](using Reads.LongReads, implicitly)),
            intervales = json.\("intervales").as(Reads.ArrayReads[TypoInterval](using TypoInterval.reads, implicitly)),
            jsones = json.\("jsones").as(Reads.ArrayReads[TypoJson](using TypoJson.reads, implicitly)),
            jsonbes = json.\("jsonbes").as(Reads.ArrayReads[TypoJsonb](using TypoJsonb.reads, implicitly)),
            linees = json.\("linees").as(Reads.ArrayReads[TypoLine](using TypoLine.reads, implicitly)),
            lseges = json.\("lseges").as(Reads.ArrayReads[TypoLineSegment](using TypoLineSegment.reads, implicitly)),
            moneyes = json.\("moneyes").as(Reads.ArrayReads[TypoMoney](using TypoMoney.reads, implicitly)),
            mydomaines = json.\("mydomaines").as(Reads.ArrayReads[Mydomain](using Mydomain.reads, implicitly)),
            myenumes = json.\("myenumes").as(Reads.ArrayReads[Myenum](using Myenum.reads, implicitly)),
            namees = json.\("namees").as(Reads.ArrayReads[String](using Reads.StringReads, implicitly)),
            numerices = json.\("numerices").as(Reads.ArrayReads[BigDecimal](using Reads.bigDecReads, implicitly)),
            pathes = json.\("pathes").as(Reads.ArrayReads[TypoPath](using TypoPath.reads, implicitly)),
            pointes = json.\("pointes").as(Reads.ArrayReads[TypoPoint](using TypoPoint.reads, implicitly)),
            polygones = json.\("polygones").as(Reads.ArrayReads[TypoPolygon](using TypoPolygon.reads, implicitly)),
            textes = json.\("textes").as(Reads.ArrayReads[String](using Reads.StringReads, implicitly)),
            timees = json.\("timees").as(Reads.ArrayReads[TypoLocalTime](using TypoLocalTime.reads, implicitly)),
            timestampes = json.\("timestampes").as(Reads.ArrayReads[TypoLocalDateTime](using TypoLocalDateTime.reads, implicitly)),
            timestampzes = json.\("timestampzes").as(Reads.ArrayReads[TypoInstant](using TypoInstant.reads, implicitly)),
            timezes = json.\("timezes").as(Reads.ArrayReads[TypoOffsetTime](using TypoOffsetTime.reads, implicitly)),
            uuides = json.\("uuides").as(Reads.ArrayReads[TypoUUID](using TypoUUID.reads, implicitly)),
            varchares = json.\("varchares").as(Reads.ArrayReads[String](using Reads.StringReads, implicitly)),
            xmles = json.\("xmles").as(Reads.ArrayReads[TypoXml](using TypoXml.reads, implicitly))
          )
        )
      ),
    )
  }
  def rowParser(idx: Int): RowParser[PgtestRow] = {
    RowParser[PgtestRow] { row =>
      Success(
        PgtestRow(
          bool = row(idx + 0)(Column.columnToBoolean),
          box = row(idx + 1)(TypoBox.column),
          bpchar = row(idx + 2)(Column.columnToString),
          bytea = row(idx + 3)(TypoBytea.column),
          char = row(idx + 4)(Column.columnToString),
          circle = row(idx + 5)(TypoCircle.column),
          date = row(idx + 6)(TypoLocalDate.column),
          float4 = row(idx + 7)(Column.columnToFloat),
          float8 = row(idx + 8)(Column.columnToDouble),
          hstore = row(idx + 9)(TypoHStore.column),
          inet = row(idx + 10)(TypoInet.column),
          int2 = row(idx + 11)(TypoShort.column),
          int2vector = row(idx + 12)(TypoInt2Vector.column),
          int4 = row(idx + 13)(Column.columnToInt),
          int8 = row(idx + 14)(Column.columnToLong),
          interval = row(idx + 15)(TypoInterval.column),
          json = row(idx + 16)(TypoJson.column),
          jsonb = row(idx + 17)(TypoJsonb.column),
          line = row(idx + 18)(TypoLine.column),
          lseg = row(idx + 19)(TypoLineSegment.column),
          money = row(idx + 20)(TypoMoney.column),
          mydomain = row(idx + 21)(Mydomain.column),
          myenum = row(idx + 22)(Myenum.column),
          name = row(idx + 23)(Column.columnToString),
          numeric = row(idx + 24)(Column.columnToScalaBigDecimal),
          path = row(idx + 25)(TypoPath.column),
          point = row(idx + 26)(TypoPoint.column),
          polygon = row(idx + 27)(TypoPolygon.column),
          text = row(idx + 28)(Column.columnToString),
          time = row(idx + 29)(TypoLocalTime.column),
          timestamp = row(idx + 30)(TypoLocalDateTime.column),
          timestampz = row(idx + 31)(TypoInstant.column),
          timez = row(idx + 32)(TypoOffsetTime.column),
          uuid = row(idx + 33)(TypoUUID.column),
          varchar = row(idx + 34)(Column.columnToString),
          vector = row(idx + 35)(TypoVector.column),
          xml = row(idx + 36)(TypoXml.column),
          boxes = row(idx + 37)(TypoBox.arrayColumn),
          bpchares = row(idx + 38)(Column.columnToArray[String](Column.columnToString, implicitly)),
          chares = row(idx + 39)(Column.columnToArray[String](Column.columnToString, implicitly)),
          circlees = row(idx + 40)(TypoCircle.arrayColumn),
          datees = row(idx + 41)(TypoLocalDate.arrayColumn),
          float4es = row(idx + 42)(Column.columnToArray[Float](Column.columnToFloat, implicitly)),
          float8es = row(idx + 43)(Column.columnToArray[Double](Column.columnToDouble, implicitly)),
          inetes = row(idx + 44)(TypoInet.arrayColumn),
          int2es = row(idx + 45)(TypoShort.arrayColumn),
          int2vectores = row(idx + 46)(TypoInt2Vector.arrayColumn),
          int4es = row(idx + 47)(Column.columnToArray[Int](Column.columnToInt, implicitly)),
          int8es = row(idx + 48)(Column.columnToArray[Long](Column.columnToLong, implicitly)),
          intervales = row(idx + 49)(TypoInterval.arrayColumn),
          jsones = row(idx + 50)(TypoJson.arrayColumn),
          jsonbes = row(idx + 51)(TypoJsonb.arrayColumn),
          linees = row(idx + 52)(TypoLine.arrayColumn),
          lseges = row(idx + 53)(TypoLineSegment.arrayColumn),
          moneyes = row(idx + 54)(TypoMoney.arrayColumn),
          mydomaines = row(idx + 55)(Mydomain.arrayColumn),
          myenumes = row(idx + 56)(Myenum.arrayColumn),
          namees = row(idx + 57)(Column.columnToArray[String](Column.columnToString, implicitly)),
          numerices = row(idx + 58)(Column.columnToArray[BigDecimal](Column.columnToScalaBigDecimal, implicitly)),
          pathes = row(idx + 59)(TypoPath.arrayColumn),
          pointes = row(idx + 60)(TypoPoint.arrayColumn),
          polygones = row(idx + 61)(TypoPolygon.arrayColumn),
          textes = row(idx + 62)(Column.columnToArray[String](Column.columnToString, implicitly)),
          timees = row(idx + 63)(TypoLocalTime.arrayColumn),
          timestampes = row(idx + 64)(TypoLocalDateTime.arrayColumn),
          timestampzes = row(idx + 65)(TypoInstant.arrayColumn),
          timezes = row(idx + 66)(TypoOffsetTime.arrayColumn),
          uuides = row(idx + 67)(TypoUUID.arrayColumn),
          varchares = row(idx + 68)(Column.columnToArray[String](Column.columnToString, implicitly)),
          xmles = row(idx + 69)(TypoXml.arrayColumn)
        )
      )
    }
  }
  implicit lazy val text: Text[PgtestRow] = {
    Text.instance[PgtestRow]{ (row, sb) =>
      Text.booleanInstance.unsafeEncode(row.bool, sb)
      sb.append(Text.DELIMETER)
      TypoBox.text.unsafeEncode(row.box, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.bpchar, sb)
      sb.append(Text.DELIMETER)
      TypoBytea.text.unsafeEncode(row.bytea, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.char, sb)
      sb.append(Text.DELIMETER)
      TypoCircle.text.unsafeEncode(row.circle, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDate.text.unsafeEncode(row.date, sb)
      sb.append(Text.DELIMETER)
      Text.floatInstance.unsafeEncode(row.float4, sb)
      sb.append(Text.DELIMETER)
      Text.doubleInstance.unsafeEncode(row.float8, sb)
      sb.append(Text.DELIMETER)
      TypoHStore.text.unsafeEncode(row.hstore, sb)
      sb.append(Text.DELIMETER)
      TypoInet.text.unsafeEncode(row.inet, sb)
      sb.append(Text.DELIMETER)
      TypoShort.text.unsafeEncode(row.int2, sb)
      sb.append(Text.DELIMETER)
      TypoInt2Vector.text.unsafeEncode(row.int2vector, sb)
      sb.append(Text.DELIMETER)
      Text.intInstance.unsafeEncode(row.int4, sb)
      sb.append(Text.DELIMETER)
      Text.longInstance.unsafeEncode(row.int8, sb)
      sb.append(Text.DELIMETER)
      TypoInterval.text.unsafeEncode(row.interval, sb)
      sb.append(Text.DELIMETER)
      TypoJson.text.unsafeEncode(row.json, sb)
      sb.append(Text.DELIMETER)
      TypoJsonb.text.unsafeEncode(row.jsonb, sb)
      sb.append(Text.DELIMETER)
      TypoLine.text.unsafeEncode(row.line, sb)
      sb.append(Text.DELIMETER)
      TypoLineSegment.text.unsafeEncode(row.lseg, sb)
      sb.append(Text.DELIMETER)
      TypoMoney.text.unsafeEncode(row.money, sb)
      sb.append(Text.DELIMETER)
      Mydomain.text.unsafeEncode(row.mydomain, sb)
      sb.append(Text.DELIMETER)
      Myenum.text.unsafeEncode(row.myenum, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.name, sb)
      sb.append(Text.DELIMETER)
      Text.bigDecimalInstance.unsafeEncode(row.numeric, sb)
      sb.append(Text.DELIMETER)
      TypoPath.text.unsafeEncode(row.path, sb)
      sb.append(Text.DELIMETER)
      TypoPoint.text.unsafeEncode(row.point, sb)
      sb.append(Text.DELIMETER)
      TypoPolygon.text.unsafeEncode(row.polygon, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.text, sb)
      sb.append(Text.DELIMETER)
      TypoLocalTime.text.unsafeEncode(row.time, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.timestamp, sb)
      sb.append(Text.DELIMETER)
      TypoInstant.text.unsafeEncode(row.timestampz, sb)
      sb.append(Text.DELIMETER)
      TypoOffsetTime.text.unsafeEncode(row.timez, sb)
      sb.append(Text.DELIMETER)
      TypoUUID.text.unsafeEncode(row.uuid, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.varchar, sb)
      sb.append(Text.DELIMETER)
      TypoVector.text.unsafeEncode(row.vector, sb)
      sb.append(Text.DELIMETER)
      TypoXml.text.unsafeEncode(row.xml, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoBox](TypoBox.text, implicitly).unsafeEncode(row.boxes, sb)
      sb.append(Text.DELIMETER)
      Text[Array[String]].unsafeEncode(row.bpchares, sb)
      sb.append(Text.DELIMETER)
      Text[Array[String]].unsafeEncode(row.chares, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoCircle](TypoCircle.text, implicitly).unsafeEncode(row.circlees, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoLocalDate](TypoLocalDate.text, implicitly).unsafeEncode(row.datees, sb)
      sb.append(Text.DELIMETER)
      Text[Array[Float]].unsafeEncode(row.float4es, sb)
      sb.append(Text.DELIMETER)
      Text[Array[Double]].unsafeEncode(row.float8es, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoInet](TypoInet.text, implicitly).unsafeEncode(row.inetes, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoShort](TypoShort.text, implicitly).unsafeEncode(row.int2es, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoInt2Vector](TypoInt2Vector.text, implicitly).unsafeEncode(row.int2vectores, sb)
      sb.append(Text.DELIMETER)
      Text[Array[Int]].unsafeEncode(row.int4es, sb)
      sb.append(Text.DELIMETER)
      Text[Array[Long]].unsafeEncode(row.int8es, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoInterval](TypoInterval.text, implicitly).unsafeEncode(row.intervales, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoJson](TypoJson.text, implicitly).unsafeEncode(row.jsones, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoJsonb](TypoJsonb.text, implicitly).unsafeEncode(row.jsonbes, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoLine](TypoLine.text, implicitly).unsafeEncode(row.linees, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoLineSegment](TypoLineSegment.text, implicitly).unsafeEncode(row.lseges, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoMoney](TypoMoney.text, implicitly).unsafeEncode(row.moneyes, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, Mydomain](Mydomain.text, implicitly).unsafeEncode(row.mydomaines, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, Myenum](Myenum.text, implicitly).unsafeEncode(row.myenumes, sb)
      sb.append(Text.DELIMETER)
      Text[Array[String]].unsafeEncode(row.namees, sb)
      sb.append(Text.DELIMETER)
      Text[Array[BigDecimal]].unsafeEncode(row.numerices, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoPath](TypoPath.text, implicitly).unsafeEncode(row.pathes, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoPoint](TypoPoint.text, implicitly).unsafeEncode(row.pointes, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoPolygon](TypoPolygon.text, implicitly).unsafeEncode(row.polygones, sb)
      sb.append(Text.DELIMETER)
      Text[Array[String]].unsafeEncode(row.textes, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoLocalTime](TypoLocalTime.text, implicitly).unsafeEncode(row.timees, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoLocalDateTime](TypoLocalDateTime.text, implicitly).unsafeEncode(row.timestampes, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoInstant](TypoInstant.text, implicitly).unsafeEncode(row.timestampzes, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoOffsetTime](TypoOffsetTime.text, implicitly).unsafeEncode(row.timezes, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoUUID](TypoUUID.text, implicitly).unsafeEncode(row.uuides, sb)
      sb.append(Text.DELIMETER)
      Text[Array[String]].unsafeEncode(row.varchares, sb)
      sb.append(Text.DELIMETER)
      Text.iterableInstance[Array, TypoXml](TypoXml.text, implicitly).unsafeEncode(row.xmles, sb)
    }
  }
  implicit lazy val writes: OWrites[PgtestRow] = {
    OWrites[PgtestRow](o =>
      new JsObject(ListMap[String, JsValue](
        "bool" -> Writes.BooleanWrites.writes(o.bool),
        "box" -> TypoBox.writes.writes(o.box),
        "bpchar" -> Writes.StringWrites.writes(o.bpchar),
        "bytea" -> TypoBytea.writes.writes(o.bytea),
        "char" -> Writes.StringWrites.writes(o.char),
        "circle" -> TypoCircle.writes.writes(o.circle),
        "date" -> TypoLocalDate.writes.writes(o.date),
        "float4" -> Writes.FloatWrites.writes(o.float4),
        "float8" -> Writes.DoubleWrites.writes(o.float8),
        "hstore" -> TypoHStore.writes.writes(o.hstore),
        "inet" -> TypoInet.writes.writes(o.inet),
        "int2" -> TypoShort.writes.writes(o.int2),
        "int2vector" -> TypoInt2Vector.writes.writes(o.int2vector),
        "int4" -> Writes.IntWrites.writes(o.int4),
        "int8" -> Writes.LongWrites.writes(o.int8),
        "interval" -> TypoInterval.writes.writes(o.interval),
        "json" -> TypoJson.writes.writes(o.json),
        "jsonb" -> TypoJsonb.writes.writes(o.jsonb),
        "line" -> TypoLine.writes.writes(o.line),
        "lseg" -> TypoLineSegment.writes.writes(o.lseg),
        "money" -> TypoMoney.writes.writes(o.money),
        "mydomain" -> Mydomain.writes.writes(o.mydomain),
        "myenum" -> Myenum.writes.writes(o.myenum),
        "name" -> Writes.StringWrites.writes(o.name),
        "numeric" -> Writes.BigDecimalWrites.writes(o.numeric),
        "path" -> TypoPath.writes.writes(o.path),
        "point" -> TypoPoint.writes.writes(o.point),
        "polygon" -> TypoPolygon.writes.writes(o.polygon),
        "text" -> Writes.StringWrites.writes(o.text),
        "time" -> TypoLocalTime.writes.writes(o.time),
        "timestamp" -> TypoLocalDateTime.writes.writes(o.timestamp),
        "timestampz" -> TypoInstant.writes.writes(o.timestampz),
        "timez" -> TypoOffsetTime.writes.writes(o.timez),
        "uuid" -> TypoUUID.writes.writes(o.uuid),
        "varchar" -> Writes.StringWrites.writes(o.varchar),
        "vector" -> TypoVector.writes.writes(o.vector),
        "xml" -> TypoXml.writes.writes(o.xml),
        "boxes" -> Writes.arrayWrites[TypoBox](using implicitly, TypoBox.writes).writes(o.boxes),
        "bpchares" -> Writes.arrayWrites[String](using implicitly, Writes.StringWrites).writes(o.bpchares),
        "chares" -> Writes.arrayWrites[String](using implicitly, Writes.StringWrites).writes(o.chares),
        "circlees" -> Writes.arrayWrites[TypoCircle](using implicitly, TypoCircle.writes).writes(o.circlees),
        "datees" -> Writes.arrayWrites[TypoLocalDate](using implicitly, TypoLocalDate.writes).writes(o.datees),
        "float4es" -> Writes.arrayWrites[Float](using implicitly, Writes.FloatWrites).writes(o.float4es),
        "float8es" -> Writes.arrayWrites[Double](using implicitly, Writes.DoubleWrites).writes(o.float8es),
        "inetes" -> Writes.arrayWrites[TypoInet](using implicitly, TypoInet.writes).writes(o.inetes),
        "int2es" -> Writes.arrayWrites[TypoShort](using implicitly, TypoShort.writes).writes(o.int2es),
        "int2vectores" -> Writes.arrayWrites[TypoInt2Vector](using implicitly, TypoInt2Vector.writes).writes(o.int2vectores),
        "int4es" -> Writes.arrayWrites[Int](using implicitly, Writes.IntWrites).writes(o.int4es),
        "int8es" -> Writes.arrayWrites[Long](using implicitly, Writes.LongWrites).writes(o.int8es),
        "intervales" -> Writes.arrayWrites[TypoInterval](using implicitly, TypoInterval.writes).writes(o.intervales),
        "jsones" -> Writes.arrayWrites[TypoJson](using implicitly, TypoJson.writes).writes(o.jsones),
        "jsonbes" -> Writes.arrayWrites[TypoJsonb](using implicitly, TypoJsonb.writes).writes(o.jsonbes),
        "linees" -> Writes.arrayWrites[TypoLine](using implicitly, TypoLine.writes).writes(o.linees),
        "lseges" -> Writes.arrayWrites[TypoLineSegment](using implicitly, TypoLineSegment.writes).writes(o.lseges),
        "moneyes" -> Writes.arrayWrites[TypoMoney](using implicitly, TypoMoney.writes).writes(o.moneyes),
        "mydomaines" -> Writes.arrayWrites[Mydomain](using implicitly, Mydomain.writes).writes(o.mydomaines),
        "myenumes" -> Writes.arrayWrites[Myenum](using implicitly, Myenum.writes).writes(o.myenumes),
        "namees" -> Writes.arrayWrites[String](using implicitly, Writes.StringWrites).writes(o.namees),
        "numerices" -> Writes.arrayWrites[BigDecimal](using implicitly, Writes.BigDecimalWrites).writes(o.numerices),
        "pathes" -> Writes.arrayWrites[TypoPath](using implicitly, TypoPath.writes).writes(o.pathes),
        "pointes" -> Writes.arrayWrites[TypoPoint](using implicitly, TypoPoint.writes).writes(o.pointes),
        "polygones" -> Writes.arrayWrites[TypoPolygon](using implicitly, TypoPolygon.writes).writes(o.polygones),
        "textes" -> Writes.arrayWrites[String](using implicitly, Writes.StringWrites).writes(o.textes),
        "timees" -> Writes.arrayWrites[TypoLocalTime](using implicitly, TypoLocalTime.writes).writes(o.timees),
        "timestampes" -> Writes.arrayWrites[TypoLocalDateTime](using implicitly, TypoLocalDateTime.writes).writes(o.timestampes),
        "timestampzes" -> Writes.arrayWrites[TypoInstant](using implicitly, TypoInstant.writes).writes(o.timestampzes),
        "timezes" -> Writes.arrayWrites[TypoOffsetTime](using implicitly, TypoOffsetTime.writes).writes(o.timezes),
        "uuides" -> Writes.arrayWrites[TypoUUID](using implicitly, TypoUUID.writes).writes(o.uuides),
        "varchares" -> Writes.arrayWrites[String](using implicitly, Writes.StringWrites).writes(o.varchares),
        "xmles" -> Writes.arrayWrites[TypoXml](using implicitly, TypoXml.writes).writes(o.xmles)
      ))
    )
  }
}