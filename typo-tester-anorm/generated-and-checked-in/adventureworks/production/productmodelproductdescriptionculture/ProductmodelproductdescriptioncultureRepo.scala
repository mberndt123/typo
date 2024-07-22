/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productmodelproductdescriptionculture

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductmodelproductdescriptioncultureRepo {
  def delete: DeleteBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow]
  def deleteById(compositeId: ProductmodelproductdescriptioncultureId)(implicit c: Connection): Boolean
  def deleteByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId])(implicit c: Connection): Int
  def insert(unsaved: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): ProductmodelproductdescriptioncultureRow
  def insert(unsaved: ProductmodelproductdescriptioncultureRowUnsaved)(implicit c: Connection): ProductmodelproductdescriptioncultureRow
  def insertStreaming(unsaved: Iterator[ProductmodelproductdescriptioncultureRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductmodelproductdescriptioncultureRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow]
  def selectAll(implicit c: Connection): List[ProductmodelproductdescriptioncultureRow]
  def selectById(compositeId: ProductmodelproductdescriptioncultureId)(implicit c: Connection): Option[ProductmodelproductdescriptioncultureRow]
  def selectByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId])(implicit c: Connection): List[ProductmodelproductdescriptioncultureRow]
  def selectByIdsTracked(compositeIds: Array[ProductmodelproductdescriptioncultureId])(implicit c: Connection): Map[ProductmodelproductdescriptioncultureId, ProductmodelproductdescriptioncultureRow]
  def update: UpdateBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow]
  def update(row: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): Boolean
  def upsert(unsaved: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): ProductmodelproductdescriptioncultureRow
  def upsertBatch(unsaved: Iterable[ProductmodelproductdescriptioncultureRow])(implicit c: Connection): List[ProductmodelproductdescriptioncultureRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[ProductmodelproductdescriptioncultureRow], batchSize: Int = 10000)(implicit c: Connection): Int
}
