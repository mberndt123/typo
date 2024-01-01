/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `production.billofmaterials` which has not been persisted yet */
case class BillofmaterialsRowUnsaved(
  /** Parent product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]]
      Constraint CK_BillOfMaterials_BOMLevel affecting columns b, o, m, l, e, v, e, l, ,,  , p, e, r, a, s, s, e, m, b, l, y, q, t, y, ,,  , p, r, o, d, u, c, t, a, s, s, e, m, b, l, y, i, d:  ((((productassemblyid IS NULL) AND (bomlevel = 0) AND (perassemblyqty = 1.00)) OR ((productassemblyid IS NOT NULL) AND (bomlevel >= 1))))
      Constraint CK_BillOfMaterials_ProductAssemblyID affecting columns c, o, m, p, o, n, e, n, t, i, d, ,,  , p, r, o, d, u, c, t, a, s, s, e, m, b, l, y, i, d:  ((productassemblyid <> componentid)) */
  productassemblyid: Option[ProductId],
  /** Component identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]]
      Constraint CK_BillOfMaterials_ProductAssemblyID affecting columns c, o, m, p, o, n, e, n, t, i, d, ,,  , p, r, o, d, u, c, t, a, s, s, e, m, b, l, y, i, d:  ((productassemblyid <> componentid)) */
  componentid: ProductId,
  /** Date the component stopped being used in the assembly item.
      Constraint CK_BillOfMaterials_EndDate affecting columns e, n, d, d, a, t, e, ,,  , s, t, a, r, t, d, a, t, e:  (((enddate > startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Standard code identifying the unit of measure for the quantity.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Indicates the depth the component is from its parent (AssemblyID).
      Constraint CK_BillOfMaterials_BOMLevel affecting columns b, o, m, l, e, v, e, l, ,,  , p, e, r, a, s, s, e, m, b, l, y, q, t, y, ,,  , p, r, o, d, u, c, t, a, s, s, e, m, b, l, y, i, d:  ((((productassemblyid IS NULL) AND (bomlevel = 0) AND (perassemblyqty = 1.00)) OR ((productassemblyid IS NOT NULL) AND (bomlevel >= 1)))) */
  bomlevel: TypoShort,
  /** Default: nextval('production.billofmaterials_billofmaterialsid_seq'::regclass)
      Primary key for BillOfMaterials records. */
  billofmaterialsid: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: now()
      Date the component started being used in the assembly item.
      Constraint CK_BillOfMaterials_EndDate affecting columns e, n, d, d, a, t, e, ,,  , s, t, a, r, t, d, a, t, e:  (((enddate > startdate) OR (enddate IS NULL))) */
  startdate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: 1.00
      Quantity of the component needed to create the assembly.
      Constraint CK_BillOfMaterials_BOMLevel affecting columns b, o, m, l, e, v, e, l, ,,  , p, e, r, a, s, s, e, m, b, l, y, q, t, y, ,,  , p, r, o, d, u, c, t, a, s, s, e, m, b, l, y, i, d:  ((((productassemblyid IS NULL) AND (bomlevel = 0) AND (perassemblyqty = 1.00)) OR ((productassemblyid IS NOT NULL) AND (bomlevel >= 1))))
      Constraint CK_BillOfMaterials_PerAssemblyQty affecting columns p, e, r, a, s, s, e, m, b, l, y, q, t, y:  ((perassemblyqty >= 1.00)) */
  perassemblyqty: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(billofmaterialsidDefault: => Int, startdateDefault: => TypoLocalDateTime, perassemblyqtyDefault: => BigDecimal, modifieddateDefault: => TypoLocalDateTime): BillofmaterialsRow =
    BillofmaterialsRow(
      productassemblyid = productassemblyid,
      componentid = componentid,
      enddate = enddate,
      unitmeasurecode = unitmeasurecode,
      bomlevel = bomlevel,
      billofmaterialsid = billofmaterialsid match {
                            case Defaulted.UseDefault => billofmaterialsidDefault
                            case Defaulted.Provided(value) => value
                          },
      startdate = startdate match {
                    case Defaulted.UseDefault => startdateDefault
                    case Defaulted.Provided(value) => value
                  },
      perassemblyqty = perassemblyqty match {
                         case Defaulted.UseDefault => perassemblyqtyDefault
                         case Defaulted.Provided(value) => value
                       },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object BillofmaterialsRowUnsaved {
  implicit lazy val decoder: Decoder[BillofmaterialsRowUnsaved] = Decoder.forProduct9[BillofmaterialsRowUnsaved, Option[ProductId], ProductId, Option[TypoLocalDateTime], UnitmeasureId, TypoShort, Defaulted[Int], Defaulted[TypoLocalDateTime], Defaulted[BigDecimal], Defaulted[TypoLocalDateTime]]("productassemblyid", "componentid", "enddate", "unitmeasurecode", "bomlevel", "billofmaterialsid", "startdate", "perassemblyqty", "modifieddate")(BillofmaterialsRowUnsaved.apply)(Decoder.decodeOption(ProductId.decoder), ProductId.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), UnitmeasureId.decoder, TypoShort.decoder, Defaulted.decoder(Decoder.decodeInt), Defaulted.decoder(TypoLocalDateTime.decoder), Defaulted.decoder(Decoder.decodeBigDecimal), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[BillofmaterialsRowUnsaved] = Encoder.forProduct9[BillofmaterialsRowUnsaved, Option[ProductId], ProductId, Option[TypoLocalDateTime], UnitmeasureId, TypoShort, Defaulted[Int], Defaulted[TypoLocalDateTime], Defaulted[BigDecimal], Defaulted[TypoLocalDateTime]]("productassemblyid", "componentid", "enddate", "unitmeasurecode", "bomlevel", "billofmaterialsid", "startdate", "perassemblyqty", "modifieddate")(x => (x.productassemblyid, x.componentid, x.enddate, x.unitmeasurecode, x.bomlevel, x.billofmaterialsid, x.startdate, x.perassemblyqty, x.modifieddate))(Encoder.encodeOption(ProductId.encoder), ProductId.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), UnitmeasureId.encoder, TypoShort.encoder, Defaulted.encoder(Encoder.encodeInt), Defaulted.encoder(TypoLocalDateTime.encoder), Defaulted.encoder(Encoder.encodeBigDecimal), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[BillofmaterialsRowUnsaved] = Text.instance[BillofmaterialsRowUnsaved]{ (row, sb) =>
    Text.option(ProductId.text).unsafeEncode(row.productassemblyid, sb)
    sb.append(Text.DELIMETER)
    ProductId.text.unsafeEncode(row.componentid, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    UnitmeasureId.text.unsafeEncode(row.unitmeasurecode, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.bomlevel, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.intInstance).unsafeEncode(row.billofmaterialsid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.perassemblyqty, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
