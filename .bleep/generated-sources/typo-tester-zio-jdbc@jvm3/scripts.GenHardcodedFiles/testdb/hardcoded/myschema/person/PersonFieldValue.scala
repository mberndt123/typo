/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded.myschema.person;

import testdb.hardcoded.myschema.Number;
import testdb.hardcoded.myschema.Sector;
import testdb.hardcoded.myschema.football_club.FootballClubId;
import testdb.hardcoded.myschema.marital_status.MaritalStatusId;

sealed trait PersonFieldValue[T] {
  def name: String
  def value: T
}

object PersonFieldValue {
  case class blogUrl(value: Option[/* max 100 chars */ String]) extends PersonFieldValue[Option[/* max 100 chars */ String]] {
    def name: String = "blog_url"
  }
  case class email(value: /* max 254 chars */ String) extends PersonFieldValue[/* max 254 chars */ String] {
    def name: String = "email"
  }
  case class favoriteNumber(value: Number) extends PersonFieldValue[Number] {
    def name: String = "favorite_number"
  }
  case class favouriteFootballClubId(value: FootballClubId) extends PersonFieldValue[FootballClubId] {
    def name: String = "favourite_football_club_id"
  }
  case class id(value: PersonId) extends PersonFieldValue[PersonId] {
    def name: String = "id"
  }
  case class likesPizza(value: Boolean) extends PersonFieldValue[Boolean] {
    def name: String = "likes_pizza"
  }
  case class maritalStatusId(value: MaritalStatusId) extends PersonFieldValue[MaritalStatusId] {
    def name: String = "marital_status_id"
  }
  case class name(value: /* max 100 chars */ String) extends PersonFieldValue[/* max 100 chars */ String] {
    def name: String = "name"
  }
  case class nickName(value: Option[/* max 30 chars */ String]) extends PersonFieldValue[Option[/* max 30 chars */ String]] {
    def name: String = "nick_name"
  }
  case class phone(value: /* max 8 chars */ String) extends PersonFieldValue[/* max 8 chars */ String] {
    def name: String = "phone"
  }
  case class sector(value: Sector) extends PersonFieldValue[Sector] {
    def name: String = "sector"
  }
  case class workEmail(value: Option[/* max 254 chars */ String]) extends PersonFieldValue[Option[/* max 254 chars */ String]] {
    def name: String = "work_email"
  }
}