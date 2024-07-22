/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.location

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait LocationFields {
  def locationid: IdField[LocationId, LocationRow]
  def name: Field[Name, LocationRow]
  def costrate: Field[BigDecimal, LocationRow]
  def availability: Field[BigDecimal, LocationRow]
  def modifieddate: Field[TypoLocalDateTime, LocationRow]
}

object LocationFields {
  lazy val structure: Relation[LocationFields, LocationRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[LocationFields, LocationRow] {
  
    override lazy val fields: LocationFields = new LocationFields {
      override def locationid = IdField[LocationId, LocationRow](_path, "locationid", None, Some("int4"), x => x.locationid, (row, value) => row.copy(locationid = value))
      override def name = Field[Name, LocationRow](_path, "name", None, Some("varchar"), x => x.name, (row, value) => row.copy(name = value))
      override def costrate = Field[BigDecimal, LocationRow](_path, "costrate", None, Some("numeric"), x => x.costrate, (row, value) => row.copy(costrate = value))
      override def availability = Field[BigDecimal, LocationRow](_path, "availability", None, Some("numeric"), x => x.availability, (row, value) => row.copy(availability = value))
      override def modifieddate = Field[TypoLocalDateTime, LocationRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, LocationRow]] =
      List[FieldLikeNoHkt[?, LocationRow]](fields.locationid, fields.name, fields.costrate, fields.availability, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
