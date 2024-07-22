/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.vendor

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `purchasing.vendor` which has not been persisted yet */
case class VendorRowUnsaved(
  /** Primary key for Vendor records.  Foreign key to BusinessEntity.BusinessEntityID
      Points to [[adventureworks.person.businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Vendor account (identification) number. */
  accountnumber: AccountNumber,
  /** Company name. */
  name: Name,
  /** 1 = Superior, 2 = Excellent, 3 = Above average, 4 = Average, 5 = Below average
      Constraint CK_Vendor_CreditRating affecting columns creditrating:  (((creditrating >= 1) AND (creditrating <= 5))) */
  creditrating: TypoShort,
  /** Vendor URL. */
  purchasingwebserviceurl: Option[/* max 1024 chars */ String],
  /** Default: true
      0 = Do not use if another vendor is available. 1 = Preferred over other vendors supplying the same product. */
  preferredvendorstatus: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: true
      0 = Vendor no longer used. 1 = Vendor is actively used. */
  activeflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(preferredvendorstatusDefault: => Flag, activeflagDefault: => Flag, modifieddateDefault: => TypoLocalDateTime): VendorRow =
    VendorRow(
      businessentityid = businessentityid,
      accountnumber = accountnumber,
      name = name,
      creditrating = creditrating,
      purchasingwebserviceurl = purchasingwebserviceurl,
      preferredvendorstatus = preferredvendorstatus match {
                                case Defaulted.UseDefault => preferredvendorstatusDefault
                                case Defaulted.Provided(value) => value
                              },
      activeflag = activeflag match {
                     case Defaulted.UseDefault => activeflagDefault
                     case Defaulted.Provided(value) => value
                   },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object VendorRowUnsaved {
  implicit lazy val decoder: Decoder[VendorRowUnsaved] = Decoder.forProduct8[VendorRowUnsaved, BusinessentityId, AccountNumber, Name, TypoShort, Option[/* max 1024 chars */ String], Defaulted[Flag], Defaulted[Flag], Defaulted[TypoLocalDateTime]]("businessentityid", "accountnumber", "name", "creditrating", "purchasingwebserviceurl", "preferredvendorstatus", "activeflag", "modifieddate")(VendorRowUnsaved.apply)(BusinessentityId.decoder, AccountNumber.decoder, Name.decoder, TypoShort.decoder, Decoder.decodeOption(Decoder.decodeString), Defaulted.decoder(Flag.decoder), Defaulted.decoder(Flag.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[VendorRowUnsaved] = Encoder.forProduct8[VendorRowUnsaved, BusinessentityId, AccountNumber, Name, TypoShort, Option[/* max 1024 chars */ String], Defaulted[Flag], Defaulted[Flag], Defaulted[TypoLocalDateTime]]("businessentityid", "accountnumber", "name", "creditrating", "purchasingwebserviceurl", "preferredvendorstatus", "activeflag", "modifieddate")(x => (x.businessentityid, x.accountnumber, x.name, x.creditrating, x.purchasingwebserviceurl, x.preferredvendorstatus, x.activeflag, x.modifieddate))(BusinessentityId.encoder, AccountNumber.encoder, Name.encoder, TypoShort.encoder, Encoder.encodeOption(Encoder.encodeString), Defaulted.encoder(Flag.encoder), Defaulted.encoder(Flag.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[VendorRowUnsaved] = Text.instance[VendorRowUnsaved]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    AccountNumber.text.unsafeEncode(row.accountnumber, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.creditrating, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.purchasingwebserviceurl, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Flag.text).unsafeEncode(row.preferredvendorstatus, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Flag.text).unsafeEncode(row.activeflag, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
