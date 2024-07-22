/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.purchaseorderheader

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.purchasing.shipmethod.ShipmethodId
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `purchasing.purchaseorderheader` which has not been persisted yet */
case class PurchaseorderheaderRowUnsaved(
  /** Employee who created the purchase order. Foreign key to Employee.BusinessEntityID.
      Points to [[adventureworks.humanresources.employee.EmployeeRow.businessentityid]] */
  employeeid: BusinessentityId,
  /** Vendor with whom the purchase order is placed. Foreign key to Vendor.BusinessEntityID.
      Points to [[adventureworks.purchasing.vendor.VendorRow.businessentityid]] */
  vendorid: BusinessentityId,
  /** Shipping method. Foreign key to ShipMethod.ShipMethodID.
      Points to [[adventureworks.purchasing.shipmethod.ShipmethodRow.shipmethodid]] */
  shipmethodid: ShipmethodId,
  /** Estimated shipment date from the vendor.
      Constraint CK_PurchaseOrderHeader_ShipDate affecting columns orderdate, shipdate:  (((shipdate >= orderdate) OR (shipdate IS NULL))) */
  shipdate: Option[TypoLocalDateTime],
  /** Default: nextval('purchasing.purchaseorderheader_purchaseorderid_seq'::regclass)
      Primary key. */
  purchaseorderid: Defaulted[PurchaseorderheaderId] = Defaulted.UseDefault,
  /** Default: 0
      Incremental number to track changes to the purchase order over time. */
  revisionnumber: Defaulted[TypoShort] = Defaulted.UseDefault,
  /** Default: 1
      Order current status. 1 = Pending; 2 = Approved; 3 = Rejected; 4 = Complete
      Constraint CK_PurchaseOrderHeader_Status affecting columns status:  (((status >= 1) AND (status <= 4))) */
  status: Defaulted[TypoShort] = Defaulted.UseDefault,
  /** Default: now()
      Purchase order creation date.
      Constraint CK_PurchaseOrderHeader_ShipDate affecting columns orderdate, shipdate:  (((shipdate >= orderdate) OR (shipdate IS NULL))) */
  orderdate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: 0.00
      Purchase order subtotal. Computed as SUM(PurchaseOrderDetail.LineTotal)for the appropriate PurchaseOrderID.
      Constraint CK_PurchaseOrderHeader_SubTotal affecting columns subtotal:  ((subtotal >= 0.00)) */
  subtotal: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Tax amount.
      Constraint CK_PurchaseOrderHeader_TaxAmt affecting columns taxamt:  ((taxamt >= 0.00)) */
  taxamt: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Shipping cost.
      Constraint CK_PurchaseOrderHeader_Freight affecting columns freight:  ((freight >= 0.00)) */
  freight: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(purchaseorderidDefault: => PurchaseorderheaderId, revisionnumberDefault: => TypoShort, statusDefault: => TypoShort, orderdateDefault: => TypoLocalDateTime, subtotalDefault: => BigDecimal, taxamtDefault: => BigDecimal, freightDefault: => BigDecimal, modifieddateDefault: => TypoLocalDateTime): PurchaseorderheaderRow =
    PurchaseorderheaderRow(
      employeeid = employeeid,
      vendorid = vendorid,
      shipmethodid = shipmethodid,
      shipdate = shipdate,
      purchaseorderid = purchaseorderid match {
                          case Defaulted.UseDefault => purchaseorderidDefault
                          case Defaulted.Provided(value) => value
                        },
      revisionnumber = revisionnumber match {
                         case Defaulted.UseDefault => revisionnumberDefault
                         case Defaulted.Provided(value) => value
                       },
      status = status match {
                 case Defaulted.UseDefault => statusDefault
                 case Defaulted.Provided(value) => value
               },
      orderdate = orderdate match {
                    case Defaulted.UseDefault => orderdateDefault
                    case Defaulted.Provided(value) => value
                  },
      subtotal = subtotal match {
                   case Defaulted.UseDefault => subtotalDefault
                   case Defaulted.Provided(value) => value
                 },
      taxamt = taxamt match {
                 case Defaulted.UseDefault => taxamtDefault
                 case Defaulted.Provided(value) => value
               },
      freight = freight match {
                  case Defaulted.UseDefault => freightDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object PurchaseorderheaderRowUnsaved {
  implicit lazy val decoder: Decoder[PurchaseorderheaderRowUnsaved] = Decoder.forProduct12[PurchaseorderheaderRowUnsaved, BusinessentityId, BusinessentityId, ShipmethodId, Option[TypoLocalDateTime], Defaulted[PurchaseorderheaderId], Defaulted[TypoShort], Defaulted[TypoShort], Defaulted[TypoLocalDateTime], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[TypoLocalDateTime]]("employeeid", "vendorid", "shipmethodid", "shipdate", "purchaseorderid", "revisionnumber", "status", "orderdate", "subtotal", "taxamt", "freight", "modifieddate")(PurchaseorderheaderRowUnsaved.apply)(BusinessentityId.decoder, BusinessentityId.decoder, ShipmethodId.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), Defaulted.decoder(PurchaseorderheaderId.decoder), Defaulted.decoder(TypoShort.decoder), Defaulted.decoder(TypoShort.decoder), Defaulted.decoder(TypoLocalDateTime.decoder), Defaulted.decoder(Decoder.decodeBigDecimal), Defaulted.decoder(Decoder.decodeBigDecimal), Defaulted.decoder(Decoder.decodeBigDecimal), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[PurchaseorderheaderRowUnsaved] = Encoder.forProduct12[PurchaseorderheaderRowUnsaved, BusinessentityId, BusinessentityId, ShipmethodId, Option[TypoLocalDateTime], Defaulted[PurchaseorderheaderId], Defaulted[TypoShort], Defaulted[TypoShort], Defaulted[TypoLocalDateTime], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[TypoLocalDateTime]]("employeeid", "vendorid", "shipmethodid", "shipdate", "purchaseorderid", "revisionnumber", "status", "orderdate", "subtotal", "taxamt", "freight", "modifieddate")(x => (x.employeeid, x.vendorid, x.shipmethodid, x.shipdate, x.purchaseorderid, x.revisionnumber, x.status, x.orderdate, x.subtotal, x.taxamt, x.freight, x.modifieddate))(BusinessentityId.encoder, BusinessentityId.encoder, ShipmethodId.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), Defaulted.encoder(PurchaseorderheaderId.encoder), Defaulted.encoder(TypoShort.encoder), Defaulted.encoder(TypoShort.encoder), Defaulted.encoder(TypoLocalDateTime.encoder), Defaulted.encoder(Encoder.encodeBigDecimal), Defaulted.encoder(Encoder.encodeBigDecimal), Defaulted.encoder(Encoder.encodeBigDecimal), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[PurchaseorderheaderRowUnsaved] = Text.instance[PurchaseorderheaderRowUnsaved]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.employeeid, sb)
    sb.append(Text.DELIMETER)
    BusinessentityId.text.unsafeEncode(row.vendorid, sb)
    sb.append(Text.DELIMETER)
    ShipmethodId.text.unsafeEncode(row.shipmethodid, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.shipdate, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(PurchaseorderheaderId.text).unsafeEncode(row.purchaseorderid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoShort.text).unsafeEncode(row.revisionnumber, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoShort.text).unsafeEncode(row.status, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.orderdate, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.subtotal, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.taxamt, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.freight, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
