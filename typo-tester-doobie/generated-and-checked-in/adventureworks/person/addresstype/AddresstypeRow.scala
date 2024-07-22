/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.addresstype;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.public.Name;
import doobie.enumerated.Nullability;
import doobie.postgres.Text;
import doobie.util.Read;
import doobie.util.Write;
import io.circe.Decoder;
import io.circe.Encoder;
import java.sql.ResultSet;

/** Table: person.addresstype
  * Types of addresses stored in the Address table.
  * Primary key: addresstypeid
  */
case class AddresstypeRow(
  /** Primary key for AddressType records.
    * Default: nextval('person.addresstype_addresstypeid_seq'::regclass)
    */
  addresstypeid: AddresstypeId,
  /** Address type description. For example, Billing, Home, or Shipping. */
  name: Name,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
) {
  def id: AddresstypeId = addresstypeid
  def toUnsavedRow(addresstypeid: Defaulted[AddresstypeId], rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): AddresstypeRowUnsaved = {
    new AddresstypeRowUnsaved(
      name,
      addresstypeid,
      rowguid,
      modifieddate
    )
  }
}

object AddresstypeRow {
  implicit lazy val decoder: Decoder[AddresstypeRow] = Decoder.forProduct4[AddresstypeRow, AddresstypeId, Name, TypoUUID, TypoLocalDateTime]("addresstypeid", "name", "rowguid", "modifieddate")(AddresstypeRow.apply)(AddresstypeId.decoder, Name.decoder, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[AddresstypeRow] = Encoder.forProduct4[AddresstypeRow, AddresstypeId, Name, TypoUUID, TypoLocalDateTime]("addresstypeid", "name", "rowguid", "modifieddate")(x => (x.addresstypeid, x.name, x.rowguid, x.modifieddate))(AddresstypeId.encoder, Name.encoder, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[AddresstypeRow] = {
    new Read[AddresstypeRow](
      gets = List(
        (AddresstypeId.get, Nullability.NoNulls),
        (Name.get, Nullability.NoNulls),
        (TypoUUID.get, Nullability.NoNulls),
        (TypoLocalDateTime.get, Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => AddresstypeRow(
        addresstypeid = AddresstypeId.get.unsafeGetNonNullable(rs, i + 0),
        name = Name.get.unsafeGetNonNullable(rs, i + 1),
        rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 2),
        modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3)
      )
    )
  
  }
  implicit lazy val text: Text[AddresstypeRow] = {
    Text.instance[AddresstypeRow]{ (row, sb) =>
      AddresstypeId.text.unsafeEncode(row.addresstypeid, sb)
      sb.append(Text.DELIMETER)
      Name.text.unsafeEncode(row.name, sb)
      sb.append(Text.DELIMETER)
      TypoUUID.text.unsafeEncode(row.rowguid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    }
  }
  implicit lazy val write: Write[AddresstypeRow] = {
    new Write[AddresstypeRow](
      puts = List((AddresstypeId.put, Nullability.NoNulls),
                  (Name.put, Nullability.NoNulls),
                  (TypoUUID.put, Nullability.NoNulls),
                  (TypoLocalDateTime.put, Nullability.NoNulls)),
      toList = x => List(x.addresstypeid, x.name, x.rowguid, x.modifieddate),
      unsafeSet = (rs, i, a) => {
                    AddresstypeId.put.unsafeSetNonNullable(rs, i + 0, a.addresstypeid)
                    Name.put.unsafeSetNonNullable(rs, i + 1, a.name)
                    TypoUUID.put.unsafeSetNonNullable(rs, i + 2, a.rowguid)
                    TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 3, a.modifieddate)
                  },
      unsafeUpdate = (ps, i, a) => {
                       AddresstypeId.put.unsafeUpdateNonNullable(ps, i + 0, a.addresstypeid)
                       Name.put.unsafeUpdateNonNullable(ps, i + 1, a.name)
                       TypoUUID.put.unsafeUpdateNonNullable(ps, i + 2, a.rowguid)
                       TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 3, a.modifieddate)
                     }
    )
  
  }
}