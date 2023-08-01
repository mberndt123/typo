/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package sp

import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait SpViewFields[Row] {
  val id: OptField[Int, Row]
  val stateprovinceid: OptField[StateprovinceId, Row]
  val stateprovincecode: OptField[/* bpchar */ String, Row]
  val countryregioncode: OptField[CountryregionId, Row]
  val isonlystateprovinceflag: Field[Flag, Row]
  val name: OptField[Name, Row]
  val territoryid: OptField[SalesterritoryId, Row]
  val rowguid: OptField[UUID, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object SpViewFields extends SpViewStructure[SpViewRow](None, identity, (_, x) => x)

