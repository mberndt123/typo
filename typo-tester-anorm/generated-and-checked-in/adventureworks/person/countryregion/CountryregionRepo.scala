/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.countryregion

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait CountryregionRepo {
  def delete: DeleteBuilder[CountryregionFields, CountryregionRow]
  def deleteById(countryregioncode: CountryregionId)(implicit c: Connection): Boolean
  def deleteByIds(countryregioncodes: Array[CountryregionId])(implicit c: Connection): Int
  def insert(unsaved: CountryregionRow)(implicit c: Connection): CountryregionRow
  def insert(unsaved: CountryregionRowUnsaved)(implicit c: Connection): CountryregionRow
  def insertStreaming(unsaved: Iterator[CountryregionRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[CountryregionRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[CountryregionFields, CountryregionRow]
  def selectAll(implicit c: Connection): List[CountryregionRow]
  def selectById(countryregioncode: CountryregionId)(implicit c: Connection): Option[CountryregionRow]
  def selectByIds(countryregioncodes: Array[CountryregionId])(implicit c: Connection): List[CountryregionRow]
  def selectByIdsTracked(countryregioncodes: Array[CountryregionId])(implicit c: Connection): Map[CountryregionId, CountryregionRow]
  def update: UpdateBuilder[CountryregionFields, CountryregionRow]
  def update(row: CountryregionRow)(implicit c: Connection): Boolean
  def upsert(unsaved: CountryregionRow)(implicit c: Connection): CountryregionRow
  def upsertBatch(unsaved: Iterable[CountryregionRow])(implicit c: Connection): List[CountryregionRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[CountryregionRow], batchSize: Int = 10000)(implicit c: Connection): Int
}
