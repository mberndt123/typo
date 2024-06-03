/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import testdb.hardcoded.myschema.football_club.FootballClubFields
import testdb.hardcoded.myschema.football_club.FootballClubId
import testdb.hardcoded.myschema.football_club.FootballClubRow
import testdb.hardcoded.myschema.marital_status.MaritalStatusFields
import testdb.hardcoded.myschema.marital_status.MaritalStatusId
import testdb.hardcoded.myschema.marital_status.MaritalStatusRow
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait PersonFields {
  def id: IdField[PersonId, PersonRow]
  def favouriteFootballClubId: Field[FootballClubId, PersonRow]
  def name: Field[/* max 100 chars */ String, PersonRow]
  def nickName: OptField[/* max 30 chars */ String, PersonRow]
  def blogUrl: OptField[/* max 100 chars */ String, PersonRow]
  def email: Field[/* max 254 chars */ String, PersonRow]
  def phone: Field[/* max 8 chars */ String, PersonRow]
  def likesPizza: Field[Boolean, PersonRow]
  def maritalStatusId: Field[MaritalStatusId, PersonRow]
  def workEmail: OptField[/* max 254 chars */ String, PersonRow]
  def sector: Field[Sector, PersonRow]
  def favoriteNumber: Field[Number, PersonRow]
  def fkFootballClub: ForeignKey[FootballClubFields, FootballClubRow] =
    ForeignKey[FootballClubFields, FootballClubRow]("myschema.person_favourite_football_club_id_fkey", Nil)
      .withColumnPair(favouriteFootballClubId, _.id)
  def fkMaritalStatus: ForeignKey[MaritalStatusFields, MaritalStatusRow] =
    ForeignKey[MaritalStatusFields, MaritalStatusRow]("myschema.person_marital_status_id_fkey", Nil)
      .withColumnPair(maritalStatusId, _.id)
}

object PersonFields {
  lazy val structure: Relation[PersonFields, PersonRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[PersonFields, PersonRow] {
  
    override lazy val fields: PersonFields = new PersonFields {
      override def id = IdField[PersonId, PersonRow](_path, "id", None, Some("int8"), x => x.id, (row, value) => row.copy(id = value))
      override def favouriteFootballClubId = Field[FootballClubId, PersonRow](_path, "favourite_football_club_id", None, None, x => x.favouriteFootballClubId, (row, value) => row.copy(favouriteFootballClubId = value))
      override def name = Field[/* max 100 chars */ String, PersonRow](_path, "name", None, None, x => x.name, (row, value) => row.copy(name = value))
      override def nickName = OptField[/* max 30 chars */ String, PersonRow](_path, "nick_name", None, None, x => x.nickName, (row, value) => row.copy(nickName = value))
      override def blogUrl = OptField[/* max 100 chars */ String, PersonRow](_path, "blog_url", None, None, x => x.blogUrl, (row, value) => row.copy(blogUrl = value))
      override def email = Field[/* max 254 chars */ String, PersonRow](_path, "email", None, None, x => x.email, (row, value) => row.copy(email = value))
      override def phone = Field[/* max 8 chars */ String, PersonRow](_path, "phone", None, None, x => x.phone, (row, value) => row.copy(phone = value))
      override def likesPizza = Field[Boolean, PersonRow](_path, "likes_pizza", None, None, x => x.likesPizza, (row, value) => row.copy(likesPizza = value))
      override def maritalStatusId = Field[MaritalStatusId, PersonRow](_path, "marital_status_id", None, None, x => x.maritalStatusId, (row, value) => row.copy(maritalStatusId = value))
      override def workEmail = OptField[/* max 254 chars */ String, PersonRow](_path, "work_email", None, None, x => x.workEmail, (row, value) => row.copy(workEmail = value))
      override def sector = Field[Sector, PersonRow](_path, "sector", None, Some("myschema.sector"), x => x.sector, (row, value) => row.copy(sector = value))
      override def favoriteNumber = Field[Number, PersonRow](_path, "favorite_number", None, Some("myschema.number"), x => x.favoriteNumber, (row, value) => row.copy(favoriteNumber = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, PersonRow]] =
      List[FieldLikeNoHkt[?, PersonRow]](fields.id, fields.favouriteFootballClubId, fields.name, fields.nickName, fields.blogUrl, fields.email, fields.phone, fields.likesPizza, fields.maritalStatusId, fields.workEmail, fields.sector, fields.favoriteNumber)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
