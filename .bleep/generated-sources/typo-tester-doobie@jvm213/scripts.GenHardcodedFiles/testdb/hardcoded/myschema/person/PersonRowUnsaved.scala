/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded.myschema.person;

import doobie.postgres.Text;
import io.circe.Decoder;
import io.circe.Encoder;
import testdb.hardcoded.customtypes.Defaulted;
import testdb.hardcoded.myschema.Number;
import testdb.hardcoded.myschema.Sector;
import testdb.hardcoded.myschema.football_club.FootballClubId;
import testdb.hardcoded.myschema.marital_status.MaritalStatusId;

/** This class corresponds to a row in table `myschema.person` which has not been persisted yet */
case class PersonRowUnsaved(
  /** Points to [[testdb.hardcoded.myschema.football_club.FootballClubRow.id]] */
  favouriteFootballClubId: FootballClubId,
  name: /* max 100 chars */ String,
  nickName: Option[/* max 30 chars */ String],
  blogUrl: Option[/* max 100 chars */ String],
  email: /* max 254 chars */ String,
  phone: /* max 8 chars */ String,
  likesPizza: Boolean,
  workEmail: Option[/* max 254 chars */ String],
  /** Default: auto-increment */
  id: Defaulted[PersonId] = Defaulted.UseDefault(),
  /** Default: some-value
    * Points to [[testdb.hardcoded.myschema.marital_status.MaritalStatusRow.id]]
    */
  maritalStatusId: Defaulted[MaritalStatusId] = Defaulted.UseDefault(),
  /** Default: PUBLIC */
  sector: Defaulted[Sector] = Defaulted.UseDefault(),
  /** Default: one */
  favoriteNumber: Defaulted[Number] = Defaulted.UseDefault()
) {
  def toRow(
    idDefault: => PersonId,
    maritalStatusIdDefault: => MaritalStatusId,
    sectorDefault: => Sector,
    favoriteNumberDefault: => Number
  ): PersonRow = {
    new PersonRow(
      id = id.getOrElse(idDefault),
      favouriteFootballClubId = favouriteFootballClubId,
      name = name,
      nickName = nickName,
      blogUrl = blogUrl,
      email = email,
      phone = phone,
      likesPizza = likesPizza,
      maritalStatusId = maritalStatusId.getOrElse(maritalStatusIdDefault),
      workEmail = workEmail,
      sector = sector.getOrElse(sectorDefault),
      favoriteNumber = favoriteNumber.getOrElse(favoriteNumberDefault)
    )
  }
}

object PersonRowUnsaved {
  implicit lazy val decoder: Decoder[PersonRowUnsaved] = Decoder.forProduct12[PersonRowUnsaved, FootballClubId, /* max 100 chars */ String, Option[/* max 30 chars */ String], Option[/* max 100 chars */ String], /* max 254 chars */ String, /* max 8 chars */ String, Boolean, Option[/* max 254 chars */ String], Defaulted[PersonId], Defaulted[MaritalStatusId], Defaulted[Sector], Defaulted[Number]]("favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "work_email", "id", "marital_status_id", "sector", "favorite_number")(PersonRowUnsaved.apply)(FootballClubId.decoder, Decoder.decodeString, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, Decoder.decodeString, Decoder.decodeBoolean, Decoder.decodeOption(Decoder.decodeString), Defaulted.decoder(PersonId.decoder), Defaulted.decoder(MaritalStatusId.decoder), Defaulted.decoder(Sector.decoder), Defaulted.decoder(Number.decoder))
  implicit lazy val encoder: Encoder[PersonRowUnsaved] = Encoder.forProduct12[PersonRowUnsaved, FootballClubId, /* max 100 chars */ String, Option[/* max 30 chars */ String], Option[/* max 100 chars */ String], /* max 254 chars */ String, /* max 8 chars */ String, Boolean, Option[/* max 254 chars */ String], Defaulted[PersonId], Defaulted[MaritalStatusId], Defaulted[Sector], Defaulted[Number]]("favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "work_email", "id", "marital_status_id", "sector", "favorite_number")(x => (x.favouriteFootballClubId, x.name, x.nickName, x.blogUrl, x.email, x.phone, x.likesPizza, x.workEmail, x.id, x.maritalStatusId, x.sector, x.favoriteNumber))(FootballClubId.encoder, Encoder.encodeString, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, Encoder.encodeString, Encoder.encodeBoolean, Encoder.encodeOption(Encoder.encodeString), Defaulted.encoder(PersonId.encoder), Defaulted.encoder(MaritalStatusId.encoder), Defaulted.encoder(Sector.encoder), Defaulted.encoder(Number.encoder))
  implicit lazy val text: Text[PersonRowUnsaved] = {
    Text.instance[PersonRowUnsaved]{ (row, sb) =>
      FootballClubId.text.unsafeEncode(row.favouriteFootballClubId, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.name, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.nickName, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.blogUrl, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.email, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.phone, sb)
      sb.append(Text.DELIMETER)
      Text.booleanInstance.unsafeEncode(row.likesPizza, sb)
      sb.append(Text.DELIMETER)
      Text.option(Text.stringInstance).unsafeEncode(row.workEmail, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(PersonId.text).unsafeEncode(row.id, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(MaritalStatusId.text).unsafeEncode(row.maritalStatusId, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(Sector.text).unsafeEncode(row.sector, sb)
      sb.append(Text.DELIMETER)
      Defaulted.text(Number.text).unsafeEncode(row.favoriteNumber, sb)
    }
  }
}