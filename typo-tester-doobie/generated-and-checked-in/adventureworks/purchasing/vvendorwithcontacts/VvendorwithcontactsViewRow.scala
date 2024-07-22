/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.vvendorwithcontacts;

import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.public.Name;
import adventureworks.public.Phone;
import adventureworks.userdefined.FirstName;
import doobie.enumerated.Nullability;
import doobie.util.Read;
import doobie.util.meta.Meta;
import io.circe.Decoder;
import io.circe.Encoder;
import java.sql.ResultSet;

/** View: purchasing.vvendorwithcontacts */
case class VvendorwithcontactsViewRow(
  /** Points to [[adventureworks.purchasing.vendor.VendorRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[adventureworks.purchasing.vendor.VendorRow.name]] */
  name: Name,
  /** Points to [[adventureworks.person.contacttype.ContacttypeRow.name]] */
  contacttype: Name,
  /** Points to [[adventureworks.person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[adventureworks.person.person.PersonRow.firstname]] */
  firstname: /* user-picked */ FirstName,
  /** Points to [[adventureworks.person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[adventureworks.person.person.PersonRow.lastname]] */
  lastname: Name,
  /** Points to [[adventureworks.person.person.PersonRow.suffix]] */
  suffix: Option[/* max 10 chars */ String],
  /** Points to [[adventureworks.person.personphone.PersonphoneRow.phonenumber]] */
  phonenumber: Option[Phone],
  /** Points to [[adventureworks.person.phonenumbertype.PhonenumbertypeRow.name]] */
  phonenumbertype: Option[Name],
  /** Points to [[adventureworks.person.emailaddress.EmailaddressRow.emailaddress]] */
  emailaddress: Option[/* max 50 chars */ String],
  /** Points to [[adventureworks.person.person.PersonRow.emailpromotion]] */
  emailpromotion: Int
)

object VvendorwithcontactsViewRow {
  implicit lazy val decoder: Decoder[VvendorwithcontactsViewRow] = Decoder.forProduct12[VvendorwithcontactsViewRow, BusinessentityId, Name, Name, Option[/* max 8 chars */ String], /* user-picked */ FirstName, Option[Name], Name, Option[/* max 10 chars */ String], Option[Phone], Option[Name], Option[/* max 50 chars */ String], Int]("businessentityid", "name", "contacttype", "title", "firstname", "middlename", "lastname", "suffix", "phonenumber", "phonenumbertype", "emailaddress", "emailpromotion")(VvendorwithcontactsViewRow.apply)(BusinessentityId.decoder, Name.decoder, Name.decoder, Decoder.decodeOption(Decoder.decodeString), FirstName.decoder, Decoder.decodeOption(Name.decoder), Name.decoder, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Phone.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeInt)
  implicit lazy val encoder: Encoder[VvendorwithcontactsViewRow] = Encoder.forProduct12[VvendorwithcontactsViewRow, BusinessentityId, Name, Name, Option[/* max 8 chars */ String], /* user-picked */ FirstName, Option[Name], Name, Option[/* max 10 chars */ String], Option[Phone], Option[Name], Option[/* max 50 chars */ String], Int]("businessentityid", "name", "contacttype", "title", "firstname", "middlename", "lastname", "suffix", "phonenumber", "phonenumbertype", "emailaddress", "emailpromotion")(x => (x.businessentityid, x.name, x.contacttype, x.title, x.firstname, x.middlename, x.lastname, x.suffix, x.phonenumber, x.phonenumbertype, x.emailaddress, x.emailpromotion))(BusinessentityId.encoder, Name.encoder, Name.encoder, Encoder.encodeOption(Encoder.encodeString), FirstName.encoder, Encoder.encodeOption(Name.encoder), Name.encoder, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Phone.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeInt)
  implicit lazy val read: Read[VvendorwithcontactsViewRow] = {
    new Read[VvendorwithcontactsViewRow](
      gets = List(
        (BusinessentityId.get, Nullability.NoNulls),
        (Name.get, Nullability.NoNulls),
        (Name.get, Nullability.NoNulls),
        (Meta.StringMeta.get, Nullability.Nullable),
        (/* user-picked */ FirstName.get, Nullability.NoNulls),
        (Name.get, Nullability.Nullable),
        (Name.get, Nullability.NoNulls),
        (Meta.StringMeta.get, Nullability.Nullable),
        (Phone.get, Nullability.Nullable),
        (Name.get, Nullability.Nullable),
        (Meta.StringMeta.get, Nullability.Nullable),
        (Meta.IntMeta.get, Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => VvendorwithcontactsViewRow(
        businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
        name = Name.get.unsafeGetNonNullable(rs, i + 1),
        contacttype = Name.get.unsafeGetNonNullable(rs, i + 2),
        title = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
        firstname = /* user-picked */ FirstName.get.unsafeGetNonNullable(rs, i + 4),
        middlename = Name.get.unsafeGetNullable(rs, i + 5),
        lastname = Name.get.unsafeGetNonNullable(rs, i + 6),
        suffix = Meta.StringMeta.get.unsafeGetNullable(rs, i + 7),
        phonenumber = Phone.get.unsafeGetNullable(rs, i + 8),
        phonenumbertype = Name.get.unsafeGetNullable(rs, i + 9),
        emailaddress = Meta.StringMeta.get.unsafeGetNullable(rs, i + 10),
        emailpromotion = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 11)
      )
    )
  
  }
}