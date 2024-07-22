/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.vvendorwithaddresses

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** View: purchasing.vvendorwithaddresses */
case class VvendorwithaddressesViewRow(
  /** Points to [[adventureworks.purchasing.vendor.VendorRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[adventureworks.purchasing.vendor.VendorRow.name]] */
  name: Name,
  /** Points to [[adventureworks.person.addresstype.AddresstypeRow.name]] */
  addresstype: Name,
  /** Points to [[adventureworks.person.address.AddressRow.addressline1]] */
  addressline1: /* max 60 chars */ String,
  /** Points to [[adventureworks.person.address.AddressRow.addressline2]] */
  addressline2: Option[/* max 60 chars */ String],
  /** Points to [[adventureworks.person.address.AddressRow.city]] */
  city: /* max 30 chars */ String,
  /** Points to [[adventureworks.person.stateprovince.StateprovinceRow.name]] */
  stateprovincename: Name,
  /** Points to [[adventureworks.person.address.AddressRow.postalcode]] */
  postalcode: /* max 15 chars */ String,
  /** Points to [[adventureworks.person.countryregion.CountryregionRow.name]] */
  countryregionname: Name
)

object VvendorwithaddressesViewRow {
  implicit lazy val decoder: Decoder[VvendorwithaddressesViewRow] = Decoder.forProduct9[VvendorwithaddressesViewRow, BusinessentityId, Name, Name, /* max 60 chars */ String, Option[/* max 60 chars */ String], /* max 30 chars */ String, Name, /* max 15 chars */ String, Name]("businessentityid", "name", "addresstype", "addressline1", "addressline2", "city", "stateprovincename", "postalcode", "countryregionname")(VvendorwithaddressesViewRow.apply)(BusinessentityId.decoder, Name.decoder, Name.decoder, Decoder.decodeString, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, Name.decoder, Decoder.decodeString, Name.decoder)
  implicit lazy val encoder: Encoder[VvendorwithaddressesViewRow] = Encoder.forProduct9[VvendorwithaddressesViewRow, BusinessentityId, Name, Name, /* max 60 chars */ String, Option[/* max 60 chars */ String], /* max 30 chars */ String, Name, /* max 15 chars */ String, Name]("businessentityid", "name", "addresstype", "addressline1", "addressline2", "city", "stateprovincename", "postalcode", "countryregionname")(x => (x.businessentityid, x.name, x.addresstype, x.addressline1, x.addressline2, x.city, x.stateprovincename, x.postalcode, x.countryregionname))(BusinessentityId.encoder, Name.encoder, Name.encoder, Encoder.encodeString, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, Name.encoder, Encoder.encodeString, Name.encoder)
  implicit lazy val read: Read[VvendorwithaddressesViewRow] = new Read[VvendorwithaddressesViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VvendorwithaddressesViewRow(
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      name = Name.get.unsafeGetNonNullable(rs, i + 1),
      addresstype = Name.get.unsafeGetNonNullable(rs, i + 2),
      addressline1 = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      addressline2 = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      city = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 5),
      stateprovincename = Name.get.unsafeGetNonNullable(rs, i + 6),
      postalcode = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 7),
      countryregionname = Name.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
}
