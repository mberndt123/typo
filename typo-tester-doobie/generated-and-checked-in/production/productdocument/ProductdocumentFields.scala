/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdocument

import adventureworks.TypoLocalDateTime
import adventureworks.production.document.DocumentId
import adventureworks.production.product.ProductId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait ProductdocumentFields[Row] {
  val productid: IdField[ProductId, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
  val documentnode: IdField[DocumentId, Row]
}
object ProductdocumentFields extends ProductdocumentStructure[ProductdocumentRow](None, identity, (_, x) => x)

