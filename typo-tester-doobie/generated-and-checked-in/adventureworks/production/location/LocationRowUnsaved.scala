/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.location;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.public.Name;
import doobie.postgres.Text;
import io.circe.Decoder;
import io.circe.Encoder;

/** This class corresponds to a row in table `production.location` which has not been persisted yet */
case class LocationRowUnsaved(
  /** Location description. */
  name: Name,
  /** Default: nextval('production.location_locationid_seq'::regclass)
    * Primary key for Location records.
    */
  locationid: Defaulted[LocationId] = Defaulted.UseDefault(),
  /** Default: 0.00
    * Standard hourly cost of the manufacturing location.
    * Constraint CK_Location_CostRate affecting columns costrate:  ((costrate >= 0.00))
    */
  costrate: Defaulted[BigDecimal] = Defaulted.UseDefault(),
  /** Default: 0.00
    * Work capacity (in hours) of the manufacturing location.
    * Constraint CK_Location_Availability affecting columns availability:  ((availability >= 0.00))
    */
  availability: Defaulted[BigDecimal] = Defaulted.UseDefault(),
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault()
) {
  def toRow(
    locationidDefault: => LocationId,
    costrateDefault: => BigDecimal,
    availabilityDefault: => BigDecimal,
    modifieddateDefault: => TypoLocalDateTime
  ): LocationRow = {
    new LocationRow(
      locationid = locationid.getOrElse(locationidDefault),
      name = name,
      costrate = costrate.getOrElse(costrateDefault),
      availability = availability.getOrElse(availabilityDefault),
      modifieddate = modifieddate.getOrElse(modifieddateDefault)
    )
  }
}

object LocationRowUnsaved {
  implicit lazy val decoder: Decoder[LocationRowUnsaved] = Decoder.forProduct5[LocationRowUnsaved, Name, Defaulted[LocationId], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[TypoLocalDateTime]]("name", "locationid", "costrate", "availability", "modifieddate")(LocationRowUnsaved.apply)(Name.decoder, Defaulted.decoder(LocationId.decoder), Defaulted.decoder(Decoder.decodeBigDecimal), Defaulted.decoder(Decoder.decodeBigDecimal), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[LocationRowUnsaved] = Encoder.forProduct5[LocationRowUnsaved, Name, Defaulted[LocationId], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[TypoLocalDateTime]]("name", "locationid", "costrate", "availability", "modifieddate")(x => (x.name, x.locationid, x.costrate, x.availability, x.modifieddate))(Name.encoder, Defaulted.encoder(LocationId.encoder), Defaulted.encoder(Encoder.encodeBigDecimal), Defaulted.encoder(Encoder.encodeBigDecimal), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[LocationRowUnsaved] = {
    Text.instance[LocationRowUnsaved]{ (row, sb) =>
      Name.text.unsafeEncode(row.name, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(LocationId.text).unsafeEncode(row.locationid, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.costrate, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.availability, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
    }
  }
}