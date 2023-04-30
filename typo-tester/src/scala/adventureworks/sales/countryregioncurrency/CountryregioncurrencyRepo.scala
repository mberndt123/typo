/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import java.sql.Connection

trait CountryregioncurrencyRepo {
  def delete(compositeId: CountryregioncurrencyId)(implicit c: Connection): Boolean
  def insert(unsaved: CountryregioncurrencyRow)(implicit c: Connection): CountryregioncurrencyRow
  def insert(unsaved: CountryregioncurrencyRowUnsaved)(implicit c: Connection): CountryregioncurrencyRow
  def selectAll(implicit c: Connection): List[CountryregioncurrencyRow]
  def selectByFieldValues(fieldValues: List[CountryregioncurrencyFieldOrIdValue[_]])(implicit c: Connection): List[CountryregioncurrencyRow]
  def selectById(compositeId: CountryregioncurrencyId)(implicit c: Connection): Option[CountryregioncurrencyRow]
  def update(row: CountryregioncurrencyRow)(implicit c: Connection): Boolean
  def updateFieldValues(compositeId: CountryregioncurrencyId, fieldValues: List[CountryregioncurrencyFieldValue[_]])(implicit c: Connection): Boolean
  def upsert(unsaved: CountryregioncurrencyRow)(implicit c: Connection): CountryregioncurrencyRow
}
