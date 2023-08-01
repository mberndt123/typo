/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package st

import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import java.util.UUID
import typo.dsl.SqlExpr.OptField

trait StViewFields[Row] {
  val id: OptField[Int, Row]
  val territoryid: OptField[SalesterritoryId, Row]
  val name: OptField[Name, Row]
  val countryregioncode: OptField[CountryregionId, Row]
  val group: OptField[/* max 50 chars */ String, Row]
  val salesytd: OptField[BigDecimal, Row]
  val saleslastyear: OptField[BigDecimal, Row]
  val costytd: OptField[BigDecimal, Row]
  val costlastyear: OptField[BigDecimal, Row]
  val rowguid: OptField[UUID, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object StViewFields extends StViewStructure[StViewRow](None, identity, (_, x) => x)

