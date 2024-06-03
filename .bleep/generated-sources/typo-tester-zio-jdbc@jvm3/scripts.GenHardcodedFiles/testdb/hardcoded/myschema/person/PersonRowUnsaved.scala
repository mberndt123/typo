/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import testdb.hardcoded.customtypes.Defaulted
import testdb.hardcoded.myschema.football_club.FootballClubId
import testdb.hardcoded.myschema.marital_status.MaritalStatusId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `myschema.person` which has not been persisted yet */
case class PersonRowUnsaved(
  /** Points to [[football_club.FootballClubRow.id]] */
  favouriteFootballClubId: FootballClubId,
  name: /* max 100 chars */ String,
  nickName: Option[/* max 30 chars */ String],
  blogUrl: Option[/* max 100 chars */ String],
  email: /* max 254 chars */ String,
  phone: /* max 8 chars */ String,
  likesPizza: Boolean,
  workEmail: Option[/* max 254 chars */ String],
  /** Default: auto-increment */
  id: Defaulted[PersonId] = Defaulted.UseDefault,
  /** Default: some-value
      Points to [[marital_status.MaritalStatusRow.id]] */
  maritalStatusId: Defaulted[MaritalStatusId] = Defaulted.UseDefault,
  /** Default: PUBLIC */
  sector: Defaulted[Sector] = Defaulted.UseDefault,
  /** Default: one */
  favoriteNumber: Defaulted[Number] = Defaulted.UseDefault
) {
  def toRow(idDefault: => PersonId, maritalStatusIdDefault: => MaritalStatusId, sectorDefault: => Sector, favoriteNumberDefault: => Number): PersonRow =
    PersonRow(
      favouriteFootballClubId = favouriteFootballClubId,
      name = name,
      nickName = nickName,
      blogUrl = blogUrl,
      email = email,
      phone = phone,
      likesPizza = likesPizza,
      workEmail = workEmail,
      id = id match {
             case Defaulted.UseDefault => idDefault
             case Defaulted.Provided(value) => value
           },
      maritalStatusId = maritalStatusId match {
                          case Defaulted.UseDefault => maritalStatusIdDefault
                          case Defaulted.Provided(value) => value
                        },
      sector = sector match {
                 case Defaulted.UseDefault => sectorDefault
                 case Defaulted.Provided(value) => value
               },
      favoriteNumber = favoriteNumber match {
                         case Defaulted.UseDefault => favoriteNumberDefault
                         case Defaulted.Provided(value) => value
                       }
    )
}
object PersonRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[PersonRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val favouriteFootballClubId = jsonObj.get("favourite_football_club_id").toRight("Missing field 'favourite_football_club_id'").flatMap(_.as(FootballClubId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(JsonDecoder.string))
    val nickName = jsonObj.get("nick_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val blogUrl = jsonObj.get("blog_url").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val email = jsonObj.get("email").toRight("Missing field 'email'").flatMap(_.as(JsonDecoder.string))
    val phone = jsonObj.get("phone").toRight("Missing field 'phone'").flatMap(_.as(JsonDecoder.string))
    val likesPizza = jsonObj.get("likes_pizza").toRight("Missing field 'likes_pizza'").flatMap(_.as(JsonDecoder.boolean))
    val workEmail = jsonObj.get("work_email").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(Defaulted.jsonDecoder(PersonId.jsonDecoder)))
    val maritalStatusId = jsonObj.get("marital_status_id").toRight("Missing field 'marital_status_id'").flatMap(_.as(Defaulted.jsonDecoder(MaritalStatusId.jsonDecoder)))
    val sector = jsonObj.get("sector").toRight("Missing field 'sector'").flatMap(_.as(Defaulted.jsonDecoder(Sector.jsonDecoder)))
    val favoriteNumber = jsonObj.get("favorite_number").toRight("Missing field 'favorite_number'").flatMap(_.as(Defaulted.jsonDecoder(Number.jsonDecoder)))
    if (favouriteFootballClubId.isRight && name.isRight && nickName.isRight && blogUrl.isRight && email.isRight && phone.isRight && likesPizza.isRight && workEmail.isRight && id.isRight && maritalStatusId.isRight && sector.isRight && favoriteNumber.isRight)
      Right(PersonRowUnsaved(favouriteFootballClubId = favouriteFootballClubId.toOption.get, name = name.toOption.get, nickName = nickName.toOption.get, blogUrl = blogUrl.toOption.get, email = email.toOption.get, phone = phone.toOption.get, likesPizza = likesPizza.toOption.get, workEmail = workEmail.toOption.get, id = id.toOption.get, maritalStatusId = maritalStatusId.toOption.get, sector = sector.toOption.get, favoriteNumber = favoriteNumber.toOption.get))
    else Left(List[Either[String, Any]](favouriteFootballClubId, name, nickName, blogUrl, email, phone, likesPizza, workEmail, id, maritalStatusId, sector, favoriteNumber).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PersonRowUnsaved] = new JsonEncoder[PersonRowUnsaved] {
    override def unsafeEncode(a: PersonRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""favourite_football_club_id":""")
      FootballClubId.jsonEncoder.unsafeEncode(a.favouriteFootballClubId, indent, out)
      out.write(",")
      out.write(""""name":""")
      JsonEncoder.string.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""nick_name":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.nickName, indent, out)
      out.write(",")
      out.write(""""blog_url":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.blogUrl, indent, out)
      out.write(",")
      out.write(""""email":""")
      JsonEncoder.string.unsafeEncode(a.email, indent, out)
      out.write(",")
      out.write(""""phone":""")
      JsonEncoder.string.unsafeEncode(a.phone, indent, out)
      out.write(",")
      out.write(""""likes_pizza":""")
      JsonEncoder.boolean.unsafeEncode(a.likesPizza, indent, out)
      out.write(",")
      out.write(""""work_email":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.workEmail, indent, out)
      out.write(",")
      out.write(""""id":""")
      Defaulted.jsonEncoder(PersonId.jsonEncoder).unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""marital_status_id":""")
      Defaulted.jsonEncoder(MaritalStatusId.jsonEncoder).unsafeEncode(a.maritalStatusId, indent, out)
      out.write(",")
      out.write(""""sector":""")
      Defaulted.jsonEncoder(Sector.jsonEncoder).unsafeEncode(a.sector, indent, out)
      out.write(",")
      out.write(""""favorite_number":""")
      Defaulted.jsonEncoder(Number.jsonEncoder).unsafeEncode(a.favoriteNumber, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[PersonRowUnsaved] = Text.instance[PersonRowUnsaved]{ (row, sb) =>
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
