/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.vproductmodelcatalogdescription

import java.sql.Connection
import typo.dsl.SelectBuilder

trait VproductmodelcatalogdescriptionViewRepo {
  def select: SelectBuilder[VproductmodelcatalogdescriptionViewFields, VproductmodelcatalogdescriptionViewRow]
  def selectAll(implicit c: Connection): List[VproductmodelcatalogdescriptionViewRow]
}
