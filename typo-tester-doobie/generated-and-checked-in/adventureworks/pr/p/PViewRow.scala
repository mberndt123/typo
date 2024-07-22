/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.p

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.product.ProductId
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.DecodingFailure
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import scala.util.Try

/** View: pr.p */
case class PViewRow(
  /** Points to [[adventureworks.production.product.ProductRow.productid]] */
  id: ProductId,
  /** Points to [[adventureworks.production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Points to [[adventureworks.production.product.ProductRow.name]] */
  name: Name,
  /** Points to [[adventureworks.production.product.ProductRow.productnumber]] */
  productnumber: /* max 25 chars */ String,
  /** Points to [[adventureworks.production.product.ProductRow.makeflag]] */
  makeflag: Flag,
  /** Points to [[adventureworks.production.product.ProductRow.finishedgoodsflag]] */
  finishedgoodsflag: Flag,
  /** Points to [[adventureworks.production.product.ProductRow.color]] */
  color: Option[/* max 15 chars */ String],
  /** Points to [[adventureworks.production.product.ProductRow.safetystocklevel]] */
  safetystocklevel: TypoShort,
  /** Points to [[adventureworks.production.product.ProductRow.reorderpoint]] */
  reorderpoint: TypoShort,
  /** Points to [[adventureworks.production.product.ProductRow.standardcost]] */
  standardcost: BigDecimal,
  /** Points to [[adventureworks.production.product.ProductRow.listprice]] */
  listprice: BigDecimal,
  /** Points to [[adventureworks.production.product.ProductRow.size]] */
  size: Option[/* max 5 chars */ String],
  /** Points to [[adventureworks.production.product.ProductRow.sizeunitmeasurecode]] */
  sizeunitmeasurecode: Option[UnitmeasureId],
  /** Points to [[adventureworks.production.product.ProductRow.weightunitmeasurecode]] */
  weightunitmeasurecode: Option[UnitmeasureId],
  /** Points to [[adventureworks.production.product.ProductRow.weight]] */
  weight: Option[BigDecimal],
  /** Points to [[adventureworks.production.product.ProductRow.daystomanufacture]] */
  daystomanufacture: Int,
  /** Points to [[adventureworks.production.product.ProductRow.productline]] */
  productline: Option[/* bpchar, max 2 chars */ String],
  /** Points to [[adventureworks.production.product.ProductRow.class]] */
  `class`: Option[/* bpchar, max 2 chars */ String],
  /** Points to [[adventureworks.production.product.ProductRow.style]] */
  style: Option[/* bpchar, max 2 chars */ String],
  /** Points to [[adventureworks.production.product.ProductRow.productsubcategoryid]] */
  productsubcategoryid: Option[ProductsubcategoryId],
  /** Points to [[adventureworks.production.product.ProductRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[adventureworks.production.product.ProductRow.sellstartdate]] */
  sellstartdate: TypoLocalDateTime,
  /** Points to [[adventureworks.production.product.ProductRow.sellenddate]] */
  sellenddate: Option[TypoLocalDateTime],
  /** Points to [[adventureworks.production.product.ProductRow.discontinueddate]] */
  discontinueddate: Option[TypoLocalDateTime],
  /** Points to [[adventureworks.production.product.ProductRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[adventureworks.production.product.ProductRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PViewRow {
  implicit lazy val decoder: Decoder[PViewRow] = Decoder.instanceTry[PViewRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      PViewRow(
        id = orThrow(c.get("id")(ProductId.decoder)),
        productid = orThrow(c.get("productid")(ProductId.decoder)),
        name = orThrow(c.get("name")(Name.decoder)),
        productnumber = orThrow(c.get("productnumber")(Decoder.decodeString)),
        makeflag = orThrow(c.get("makeflag")(Flag.decoder)),
        finishedgoodsflag = orThrow(c.get("finishedgoodsflag")(Flag.decoder)),
        color = orThrow(c.get("color")(Decoder.decodeOption(Decoder.decodeString))),
        safetystocklevel = orThrow(c.get("safetystocklevel")(TypoShort.decoder)),
        reorderpoint = orThrow(c.get("reorderpoint")(TypoShort.decoder)),
        standardcost = orThrow(c.get("standardcost")(Decoder.decodeBigDecimal)),
        listprice = orThrow(c.get("listprice")(Decoder.decodeBigDecimal)),
        size = orThrow(c.get("size")(Decoder.decodeOption(Decoder.decodeString))),
        sizeunitmeasurecode = orThrow(c.get("sizeunitmeasurecode")(Decoder.decodeOption(UnitmeasureId.decoder))),
        weightunitmeasurecode = orThrow(c.get("weightunitmeasurecode")(Decoder.decodeOption(UnitmeasureId.decoder))),
        weight = orThrow(c.get("weight")(Decoder.decodeOption(Decoder.decodeBigDecimal))),
        daystomanufacture = orThrow(c.get("daystomanufacture")(Decoder.decodeInt)),
        productline = orThrow(c.get("productline")(Decoder.decodeOption(Decoder.decodeString))),
        `class` = orThrow(c.get("class")(Decoder.decodeOption(Decoder.decodeString))),
        style = orThrow(c.get("style")(Decoder.decodeOption(Decoder.decodeString))),
        productsubcategoryid = orThrow(c.get("productsubcategoryid")(Decoder.decodeOption(ProductsubcategoryId.decoder))),
        productmodelid = orThrow(c.get("productmodelid")(Decoder.decodeOption(ProductmodelId.decoder))),
        sellstartdate = orThrow(c.get("sellstartdate")(TypoLocalDateTime.decoder)),
        sellenddate = orThrow(c.get("sellenddate")(Decoder.decodeOption(TypoLocalDateTime.decoder))),
        discontinueddate = orThrow(c.get("discontinueddate")(Decoder.decodeOption(TypoLocalDateTime.decoder))),
        rowguid = orThrow(c.get("rowguid")(TypoUUID.decoder)),
        modifieddate = orThrow(c.get("modifieddate")(TypoLocalDateTime.decoder))
      )
    }
  )
  implicit lazy val encoder: Encoder[PViewRow] = Encoder[PViewRow](row =>
    Json.obj(
      "id" -> ProductId.encoder.apply(row.id),
      "productid" -> ProductId.encoder.apply(row.productid),
      "name" -> Name.encoder.apply(row.name),
      "productnumber" -> Encoder.encodeString.apply(row.productnumber),
      "makeflag" -> Flag.encoder.apply(row.makeflag),
      "finishedgoodsflag" -> Flag.encoder.apply(row.finishedgoodsflag),
      "color" -> Encoder.encodeOption(Encoder.encodeString).apply(row.color),
      "safetystocklevel" -> TypoShort.encoder.apply(row.safetystocklevel),
      "reorderpoint" -> TypoShort.encoder.apply(row.reorderpoint),
      "standardcost" -> Encoder.encodeBigDecimal.apply(row.standardcost),
      "listprice" -> Encoder.encodeBigDecimal.apply(row.listprice),
      "size" -> Encoder.encodeOption(Encoder.encodeString).apply(row.size),
      "sizeunitmeasurecode" -> Encoder.encodeOption(UnitmeasureId.encoder).apply(row.sizeunitmeasurecode),
      "weightunitmeasurecode" -> Encoder.encodeOption(UnitmeasureId.encoder).apply(row.weightunitmeasurecode),
      "weight" -> Encoder.encodeOption(Encoder.encodeBigDecimal).apply(row.weight),
      "daystomanufacture" -> Encoder.encodeInt.apply(row.daystomanufacture),
      "productline" -> Encoder.encodeOption(Encoder.encodeString).apply(row.productline),
      "class" -> Encoder.encodeOption(Encoder.encodeString).apply(row.`class`),
      "style" -> Encoder.encodeOption(Encoder.encodeString).apply(row.style),
      "productsubcategoryid" -> Encoder.encodeOption(ProductsubcategoryId.encoder).apply(row.productsubcategoryid),
      "productmodelid" -> Encoder.encodeOption(ProductmodelId.encoder).apply(row.productmodelid),
      "sellstartdate" -> TypoLocalDateTime.encoder.apply(row.sellstartdate),
      "sellenddate" -> Encoder.encodeOption(TypoLocalDateTime.encoder).apply(row.sellenddate),
      "discontinueddate" -> Encoder.encodeOption(TypoLocalDateTime.encoder).apply(row.discontinueddate),
      "rowguid" -> TypoUUID.encoder.apply(row.rowguid),
      "modifieddate" -> TypoLocalDateTime.encoder.apply(row.modifieddate)
    )
  )
  implicit lazy val read: Read[PViewRow] = new Read[PViewRow](
    gets = List(
      (ProductId.get, Nullability.NoNulls),
      (ProductId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Flag.get, Nullability.NoNulls),
      (Flag.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoShort.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (UnitmeasureId.get, Nullability.Nullable),
      (UnitmeasureId.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (ProductsubcategoryId.get, Nullability.Nullable),
      (ProductmodelId.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PViewRow(
      id = ProductId.get.unsafeGetNonNullable(rs, i + 0),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 1),
      name = Name.get.unsafeGetNonNullable(rs, i + 2),
      productnumber = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      makeflag = Flag.get.unsafeGetNonNullable(rs, i + 4),
      finishedgoodsflag = Flag.get.unsafeGetNonNullable(rs, i + 5),
      color = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      safetystocklevel = TypoShort.get.unsafeGetNonNullable(rs, i + 7),
      reorderpoint = TypoShort.get.unsafeGetNonNullable(rs, i + 8),
      standardcost = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 9),
      listprice = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 10),
      size = Meta.StringMeta.get.unsafeGetNullable(rs, i + 11),
      sizeunitmeasurecode = UnitmeasureId.get.unsafeGetNullable(rs, i + 12),
      weightunitmeasurecode = UnitmeasureId.get.unsafeGetNullable(rs, i + 13),
      weight = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 14),
      daystomanufacture = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 15),
      productline = Meta.StringMeta.get.unsafeGetNullable(rs, i + 16),
      `class` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 17),
      style = Meta.StringMeta.get.unsafeGetNullable(rs, i + 18),
      productsubcategoryid = ProductsubcategoryId.get.unsafeGetNullable(rs, i + 19),
      productmodelid = ProductmodelId.get.unsafeGetNullable(rs, i + 20),
      sellstartdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 21),
      sellenddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 22),
      discontinueddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 23),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 24),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 25)
    )
  )
}
