/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package sm

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import adventureworks.purchasing.shipmethod.ShipmethodId
import java.util.UUID
import typo.dsl.SqlExpr.OptField

trait SmViewFields[Row] {
  val id: OptField[Int, Row]
  val shipmethodid: OptField[ShipmethodId, Row]
  val name: OptField[Name, Row]
  val shipbase: OptField[BigDecimal, Row]
  val shiprate: OptField[BigDecimal, Row]
  val rowguid: OptField[UUID, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
}
object SmViewFields extends SmViewStructure[SmViewRow](None, identity, (_, x) => x)

