/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package store

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait StoreFields[Row] {
  val businessentityid: IdField[BusinessentityId, Row]
  val name: Field[Name, Row]
  val salespersonid: OptField[BusinessentityId, Row]
  val demographics: OptField[TypoXml, Row]
  val rowguid: Field[UUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object StoreFields extends StoreStructure[StoreRow](None, identity, (_, x) => x)

