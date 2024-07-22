/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productphoto;

import adventureworks.Text;
import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoBytea;
import adventureworks.customtypes.TypoLocalDateTime;
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;
import zio.json.ast.Json;
import zio.json.internal.Write;

/** This class corresponds to a row in table `production.productphoto` which has not been persisted yet */
case class ProductphotoRowUnsaved(
  /** Small image of the product. */
  thumbnailphoto: Option[TypoBytea],
  /** Small image file name. */
  thumbnailphotofilename: Option[/* max 50 chars */ String],
  /** Large image of the product. */
  largephoto: Option[TypoBytea],
  /** Large image file name. */
  largephotofilename: Option[/* max 50 chars */ String],
  /** Default: nextval('production.productphoto_productphotoid_seq'::regclass)
    * Primary key for ProductPhoto records.
    */
  productphotoid: Defaulted[ProductphotoId] = Defaulted.UseDefault(),
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault()
) {
  def toRow(productphotoidDefault: => ProductphotoId, modifieddateDefault: => TypoLocalDateTime): ProductphotoRow = {
    new ProductphotoRow(
      productphotoid = productphotoid.getOrElse(productphotoidDefault),
      thumbnailphoto = thumbnailphoto,
      thumbnailphotofilename = thumbnailphotofilename,
      largephoto = largephoto,
      largephotofilename = largephotofilename,
      modifieddate = modifieddate.getOrElse(modifieddateDefault)
    )
  }
}

object ProductphotoRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[ProductphotoRowUnsaved] = {
    JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
      val thumbnailphoto = jsonObj.get("thumbnailphoto").fold[Either[String, Option[TypoBytea]]](Right(None))(_.as(JsonDecoder.option(using TypoBytea.jsonDecoder)))
      val thumbnailphotofilename = jsonObj.get("thumbnailphotofilename").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
      val largephoto = jsonObj.get("largephoto").fold[Either[String, Option[TypoBytea]]](Right(None))(_.as(JsonDecoder.option(using TypoBytea.jsonDecoder)))
      val largephotofilename = jsonObj.get("largephotofilename").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
      val productphotoid = jsonObj.get("productphotoid").toRight("Missing field 'productphotoid'").flatMap(_.as(Defaulted.jsonDecoder(ProductphotoId.jsonDecoder)))
      val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
      if (thumbnailphoto.isRight && thumbnailphotofilename.isRight && largephoto.isRight && largephotofilename.isRight && productphotoid.isRight && modifieddate.isRight)
        Right(ProductphotoRowUnsaved(thumbnailphoto = thumbnailphoto.toOption.get, thumbnailphotofilename = thumbnailphotofilename.toOption.get, largephoto = largephoto.toOption.get, largephotofilename = largephotofilename.toOption.get, productphotoid = productphotoid.toOption.get, modifieddate = modifieddate.toOption.get))
      else Left(List[Either[String, Any]](thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, productphotoid, modifieddate).flatMap(_.left.toOption).mkString(", "))
    }
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductphotoRowUnsaved] = {
    new JsonEncoder[ProductphotoRowUnsaved] {
      override def unsafeEncode(a: ProductphotoRowUnsaved, indent: Option[Int], out: Write): Unit = {
        out.write("{")
        out.write(""""thumbnailphoto":""")
        JsonEncoder.option(using TypoBytea.jsonEncoder).unsafeEncode(a.thumbnailphoto, indent, out)
        out.write(",")
        out.write(""""thumbnailphotofilename":""")
        JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.thumbnailphotofilename, indent, out)
        out.write(",")
        out.write(""""largephoto":""")
        JsonEncoder.option(using TypoBytea.jsonEncoder).unsafeEncode(a.largephoto, indent, out)
        out.write(",")
        out.write(""""largephotofilename":""")
        JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.largephotofilename, indent, out)
        out.write(",")
        out.write(""""productphotoid":""")
        Defaulted.jsonEncoder(ProductphotoId.jsonEncoder).unsafeEncode(a.productphotoid, indent, out)
        out.write(",")
        out.write(""""modifieddate":""")
        Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
        out.write("}")
      }
    }
  }
  implicit lazy val text: Text[ProductphotoRowUnsaved] = {
    Text.instance[ProductphotoRowUnsaved]{ (row, sb) =>
      Text.option(TypoBytea.text).unsafeEncode(row.thumbnailphoto, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.thumbnailphotofilename, sb)
      sb.append(Text.DELIMETER)
      Text.option(TypoBytea.text).unsafeEncode(row.largephoto, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.largephotofilename, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(ProductphotoId.text).unsafeEncode(row.productphotoid, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
    }
  }
}