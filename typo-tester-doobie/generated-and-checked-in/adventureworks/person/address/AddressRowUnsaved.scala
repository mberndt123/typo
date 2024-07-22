/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.address

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.stateprovince.StateprovinceId
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `person.address` which has not been persisted yet */
case class AddressRowUnsaved(
  /** First street address line. */
  addressline1: /* max 60 chars */ String,
  /** Second street address line. */
  addressline2: Option[/* max 60 chars */ String],
  /** Name of the city. */
  city: /* max 30 chars */ String,
  /** Unique identification number for the state or province. Foreign key to StateProvince table.
      Points to [[adventureworks.person.stateprovince.StateprovinceRow.stateprovinceid]] */
  stateprovinceid: StateprovinceId,
  /** Postal code for the street address. */
  postalcode: /* max 15 chars */ String,
  /** Latitude and longitude of this address. */
  spatiallocation: Option[TypoBytea],
  /** Default: nextval('person.address_addressid_seq'::regclass)
      Primary key for Address records. */
  addressid: Defaulted[AddressId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(addressidDefault: => AddressId, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): AddressRow =
    AddressRow(
      addressline1 = addressline1,
      addressline2 = addressline2,
      city = city,
      stateprovinceid = stateprovinceid,
      postalcode = postalcode,
      spatiallocation = spatiallocation,
      addressid = addressid match {
                    case Defaulted.UseDefault => addressidDefault
                    case Defaulted.Provided(value) => value
                  },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object AddressRowUnsaved {
  implicit lazy val decoder: Decoder[AddressRowUnsaved] = Decoder.forProduct9[AddressRowUnsaved, /* max 60 chars */ String, Option[/* max 60 chars */ String], /* max 30 chars */ String, StateprovinceId, /* max 15 chars */ String, Option[TypoBytea], Defaulted[AddressId], Defaulted[TypoUUID], Defaulted[TypoLocalDateTime]]("addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "addressid", "rowguid", "modifieddate")(AddressRowUnsaved.apply)(Decoder.decodeString, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, StateprovinceId.decoder, Decoder.decodeString, Decoder.decodeOption(TypoBytea.decoder), Defaulted.decoder(AddressId.decoder), Defaulted.decoder(TypoUUID.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[AddressRowUnsaved] = Encoder.forProduct9[AddressRowUnsaved, /* max 60 chars */ String, Option[/* max 60 chars */ String], /* max 30 chars */ String, StateprovinceId, /* max 15 chars */ String, Option[TypoBytea], Defaulted[AddressId], Defaulted[TypoUUID], Defaulted[TypoLocalDateTime]]("addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "addressid", "rowguid", "modifieddate")(x => (x.addressline1, x.addressline2, x.city, x.stateprovinceid, x.postalcode, x.spatiallocation, x.addressid, x.rowguid, x.modifieddate))(Encoder.encodeString, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, StateprovinceId.encoder, Encoder.encodeString, Encoder.encodeOption(TypoBytea.encoder), Defaulted.encoder(AddressId.encoder), Defaulted.encoder(TypoUUID.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[AddressRowUnsaved] = Text.instance[AddressRowUnsaved]{ (row, sb) =>
    Text.stringInstance.unsafeEncode(row.addressline1, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.addressline2, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.city, sb)
    sb.append(Text.DELIMETER)
    StateprovinceId.text.unsafeEncode(row.stateprovinceid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.postalcode, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoBytea.text).unsafeEncode(row.spatiallocation, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(AddressId.text).unsafeEncode(row.addressid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
