/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.vendor;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoShort;
import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.public.AccountNumber;
import adventureworks.public.Flag;
import adventureworks.public.Name;
import doobie.enumerated.Nullability;
import doobie.postgres.Text;
import doobie.util.Read;
import doobie.util.Write;
import doobie.util.meta.Meta;
import io.circe.Decoder;
import io.circe.Encoder;
import java.sql.ResultSet;

/** Table: purchasing.vendor
  * Companies from whom Adventure Works Cycles purchases parts or other goods.
  * Primary key: businessentityid
  */
case class VendorRow(
  /** Primary key for Vendor records.  Foreign key to BusinessEntity.BusinessEntityID
    * Points to [[adventureworks.person.businessentity.BusinessentityRow.businessentityid]]
    */
  businessentityid: BusinessentityId,
  /** Vendor account (identification) number. */
  accountnumber: AccountNumber,
  /** Company name. */
  name: Name,
  /** 1 = Superior, 2 = Excellent, 3 = Above average, 4 = Average, 5 = Below average
    * Constraint CK_Vendor_CreditRating affecting columns creditrating: (((creditrating >= 1) AND (creditrating <= 5)))
    */
  creditrating: TypoShort,
  /** 0 = Do not use if another vendor is available. 1 = Preferred over other vendors supplying the same product.
    * Default: true
    */
  preferredvendorstatus: Flag,
  /** 0 = Vendor no longer used. 1 = Vendor is actively used.
    * Default: true
    */
  activeflag: Flag,
  /** Vendor URL. */
  purchasingwebserviceurl: Option[/* max 1024 chars */ String],
  /** Default: now() */
  modifieddate: TypoLocalDateTime
) {
  def id: BusinessentityId = businessentityid
  def toUnsavedRow(preferredvendorstatus: Defaulted[Flag] = Defaulted.Provided(this.preferredvendorstatus), activeflag: Defaulted[Flag] = Defaulted.Provided(this.activeflag), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): VendorRowUnsaved = {
    new VendorRowUnsaved(
      businessentityid,
      accountnumber,
      name,
      creditrating,
      purchasingwebserviceurl,
      preferredvendorstatus,
      activeflag,
      modifieddate
    )
  }
}

object VendorRow {
  implicit lazy val decoder: Decoder[VendorRow] = Decoder.forProduct8[VendorRow, BusinessentityId, AccountNumber, Name, TypoShort, Flag, Flag, Option[/* max 1024 chars */ String], TypoLocalDateTime]("businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate")(VendorRow.apply)(BusinessentityId.decoder, AccountNumber.decoder, Name.decoder, TypoShort.decoder, Flag.decoder, Flag.decoder, Decoder.decodeOption(Decoder.decodeString), TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[VendorRow] = Encoder.forProduct8[VendorRow, BusinessentityId, AccountNumber, Name, TypoShort, Flag, Flag, Option[/* max 1024 chars */ String], TypoLocalDateTime]("businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate")(x => (x.businessentityid, x.accountnumber, x.name, x.creditrating, x.preferredvendorstatus, x.activeflag, x.purchasingwebserviceurl, x.modifieddate))(BusinessentityId.encoder, AccountNumber.encoder, Name.encoder, TypoShort.encoder, Flag.encoder, Flag.encoder, Encoder.encodeOption(Encoder.encodeString), TypoLocalDateTime.encoder)
  implicit lazy val read: Read[VendorRow] = {
    new Read[VendorRow](
      gets = List(
        (BusinessentityId.get, Nullability.NoNulls),
        (AccountNumber.get, Nullability.NoNulls),
        (Name.get, Nullability.NoNulls),
        (TypoShort.get, Nullability.NoNulls),
        (Flag.get, Nullability.NoNulls),
        (Flag.get, Nullability.NoNulls),
        (Meta.StringMeta.get, Nullability.Nullable),
        (TypoLocalDateTime.get, Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => VendorRow(
        businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
        accountnumber = AccountNumber.get.unsafeGetNonNullable(rs, i + 1),
        name = Name.get.unsafeGetNonNullable(rs, i + 2),
        creditrating = TypoShort.get.unsafeGetNonNullable(rs, i + 3),
        preferredvendorstatus = Flag.get.unsafeGetNonNullable(rs, i + 4),
        activeflag = Flag.get.unsafeGetNonNullable(rs, i + 5),
        purchasingwebserviceurl = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
        modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 7)
      )
    )
  
  }
  implicit lazy val text: Text[VendorRow] = {
    Text.instance[VendorRow]{ (row, sb) =>
      BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
      sb.append(Text.DELIMETER)
      AccountNumber.text.unsafeEncode(row.accountnumber, sb)
      sb.append(Text.DELIMETER)
      Name.text.unsafeEncode(row.name, sb)
      sb.append(Text.DELIMETER)
      TypoShort.text.unsafeEncode(row.creditrating, sb)
      sb.append(Text.DELIMETER)
      Flag.text.unsafeEncode(row.preferredvendorstatus, sb)
      sb.append(Text.DELIMETER)
      Flag.text.unsafeEncode(row.activeflag, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.purchasingwebserviceurl, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    }
  }
  implicit lazy val write: Write[VendorRow] = {
    new Write[VendorRow](
      puts = List((BusinessentityId.put, Nullability.NoNulls),
                  (AccountNumber.put, Nullability.NoNulls),
                  (Name.put, Nullability.NoNulls),
                  (TypoShort.put, Nullability.NoNulls),
                  (Flag.put, Nullability.NoNulls),
                  (Flag.put, Nullability.NoNulls),
                  (Meta.StringMeta.put, Nullability.Nullable),
                  (TypoLocalDateTime.put, Nullability.NoNulls)),
      toList = x => List(x.businessentityid, x.accountnumber, x.name, x.creditrating, x.preferredvendorstatus, x.activeflag, x.purchasingwebserviceurl, x.modifieddate),
      unsafeSet = (rs, i, a) => {
                    BusinessentityId.put.unsafeSetNonNullable(rs, i + 0, a.businessentityid)
                    AccountNumber.put.unsafeSetNonNullable(rs, i + 1, a.accountnumber)
                    Name.put.unsafeSetNonNullable(rs, i + 2, a.name)
                    TypoShort.put.unsafeSetNonNullable(rs, i + 3, a.creditrating)
                    Flag.put.unsafeSetNonNullable(rs, i + 4, a.preferredvendorstatus)
                    Flag.put.unsafeSetNonNullable(rs, i + 5, a.activeflag)
                    Meta.StringMeta.put.unsafeSetNullable(rs, i + 6, a.purchasingwebserviceurl)
                    TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 7, a.modifieddate)
                  },
      unsafeUpdate = (ps, i, a) => {
                       BusinessentityId.put.unsafeUpdateNonNullable(ps, i + 0, a.businessentityid)
                       AccountNumber.put.unsafeUpdateNonNullable(ps, i + 1, a.accountnumber)
                       Name.put.unsafeUpdateNonNullable(ps, i + 2, a.name)
                       TypoShort.put.unsafeUpdateNonNullable(ps, i + 3, a.creditrating)
                       Flag.put.unsafeUpdateNonNullable(ps, i + 4, a.preferredvendorstatus)
                       Flag.put.unsafeUpdateNonNullable(ps, i + 5, a.activeflag)
                       Meta.StringMeta.put.unsafeUpdateNullable(ps, i + 6, a.purchasingwebserviceurl)
                       TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 7, a.modifieddate)
                     }
    )
  
  }
}