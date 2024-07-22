/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.d

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class DViewRepoImpl extends DViewRepo {
  override def select: SelectBuilder[DViewFields, DViewRow] = {
    SelectBuilderSql("pr.d", DViewFields.structure, DViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, DViewRow] = {
    sql"""select "title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate"::text, "documentnode" from pr.d""".query(using DViewRow.read).stream
  }
}
