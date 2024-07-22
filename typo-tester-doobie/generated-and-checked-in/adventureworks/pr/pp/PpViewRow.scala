/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.pp;

import adventureworks.customtypes.TypoBytea;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.production.productphoto.ProductphotoId;
import doobie.enumerated.Nullability;
import doobie.util.Read;
import doobie.util.meta.Meta;
import io.circe.Decoder;
import io.circe.Encoder;
import java.sql.ResultSet;

/** View: pr.pp */
case class PpViewRow(
  /** Points to [[adventureworks.production.productphoto.ProductphotoRow.productphotoid]] */
  id: ProductphotoId,
  /** Points to [[adventureworks.production.productphoto.ProductphotoRow.productphotoid]] */
  productphotoid: ProductphotoId,
  /** Points to [[adventureworks.production.productphoto.ProductphotoRow.thumbnailphoto]] */
  thumbnailphoto: Option[TypoBytea],
  /** Points to [[adventureworks.production.productphoto.ProductphotoRow.thumbnailphotofilename]] */
  thumbnailphotofilename: Option[/* max 50 chars */ String],
  /** Points to [[adventureworks.production.productphoto.ProductphotoRow.largephoto]] */
  largephoto: Option[TypoBytea],
  /** Points to [[adventureworks.production.productphoto.ProductphotoRow.largephotofilename]] */
  largephotofilename: Option[/* max 50 chars */ String],
  /** Points to [[adventureworks.production.productphoto.ProductphotoRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PpViewRow {
  implicit lazy val decoder: Decoder[PpViewRow] = Decoder.forProduct7[PpViewRow, ProductphotoId, ProductphotoId, Option[TypoBytea], Option[/* max 50 chars */ String], Option[TypoBytea], Option[/* max 50 chars */ String], TypoLocalDateTime]("id", "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate")(PpViewRow.apply)(ProductphotoId.decoder, ProductphotoId.decoder, Decoder.decodeOption(TypoBytea.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoBytea.decoder), Decoder.decodeOption(Decoder.decodeString), TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PpViewRow] = Encoder.forProduct7[PpViewRow, ProductphotoId, ProductphotoId, Option[TypoBytea], Option[/* max 50 chars */ String], Option[TypoBytea], Option[/* max 50 chars */ String], TypoLocalDateTime]("id", "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate")(x => (x.id, x.productphotoid, x.thumbnailphoto, x.thumbnailphotofilename, x.largephoto, x.largephotofilename, x.modifieddate))(ProductphotoId.encoder, ProductphotoId.encoder, Encoder.encodeOption(TypoBytea.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoBytea.encoder), Encoder.encodeOption(Encoder.encodeString), TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PpViewRow] = {
    new Read[PpViewRow](
      gets = List(
        (ProductphotoId.get, Nullability.NoNulls),
        (ProductphotoId.get, Nullability.NoNulls),
        (TypoBytea.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable),
        (TypoBytea.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable),
        (TypoLocalDateTime.get, Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PpViewRow(
        id = ProductphotoId.get.unsafeGetNonNullable(rs, i + 0),
        productphotoid = ProductphotoId.get.unsafeGetNonNullable(rs, i + 1),
        thumbnailphoto = TypoBytea.get.unsafeGetNullable(rs, i + 2),
        thumbnailphotofilename = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
        largephoto = TypoBytea.get.unsafeGetNullable(rs, i + 4),
        largephotofilename = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
        modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6)
      )
    )
  
  }
}