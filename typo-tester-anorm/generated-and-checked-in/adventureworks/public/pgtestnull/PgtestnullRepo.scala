/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.public.pgtestnull

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgtestnullRepo {
  def delete: DeleteBuilder[PgtestnullFields, PgtestnullRow]
  def insert(unsaved: PgtestnullRow)(implicit c: Connection): PgtestnullRow
  def insertStreaming(unsaved: Iterator[PgtestnullRow], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[PgtestnullFields, PgtestnullRow]
  def selectAll(implicit c: Connection): List[PgtestnullRow]
  def update: UpdateBuilder[PgtestnullFields, PgtestnullRow]
}
