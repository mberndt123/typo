/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait CountryregionRepo {
  def delete(countryregioncode: CountryregionId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[CountryregionFields, CountryregionRow]
  def insert(unsaved: CountryregionRow)(implicit c: Connection): CountryregionRow
  def insert(unsaved: CountryregionRowUnsaved)(implicit c: Connection): CountryregionRow
  def select: SelectBuilder[CountryregionFields, CountryregionRow]
  def selectAll(implicit c: Connection): List[CountryregionRow]
  def selectById(countryregioncode: CountryregionId)(implicit c: Connection): Option[CountryregionRow]
  def selectByIds(countryregioncodes: Array[CountryregionId])(implicit c: Connection): List[CountryregionRow]
  def update(row: CountryregionRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[CountryregionFields, CountryregionRow]
  def upsert(unsaved: CountryregionRow)(implicit c: Connection): CountryregionRow
}
