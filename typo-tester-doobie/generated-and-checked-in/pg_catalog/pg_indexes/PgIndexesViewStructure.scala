/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_indexes

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgIndexesViewStructure[Row](val prefix: Option[String], val extract: Row => PgIndexesViewRow, val merge: (Row, PgIndexesViewRow) => Row)
  extends Relation[PgIndexesViewFields, PgIndexesViewRow, Row]
    with PgIndexesViewFields[Row] { outer =>

  override val schemaname = new OptField[String, Row](prefix, "schemaname", None, Some("name"))(x => extract(x).schemaname, (row, value) => merge(row, extract(row).copy(schemaname = value)))
  override val tablename = new OptField[String, Row](prefix, "tablename", None, Some("name"))(x => extract(x).tablename, (row, value) => merge(row, extract(row).copy(tablename = value)))
  override val indexname = new OptField[String, Row](prefix, "indexname", None, Some("name"))(x => extract(x).indexname, (row, value) => merge(row, extract(row).copy(indexname = value)))
  override val tablespace = new OptField[String, Row](prefix, "tablespace", None, Some("name"))(x => extract(x).tablespace, (row, value) => merge(row, extract(row).copy(tablespace = value)))
  override val indexdef = new OptField[String, Row](prefix, "indexdef", None, None)(x => extract(x).indexdef, (row, value) => merge(row, extract(row).copy(indexdef = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](schemaname, tablename, indexname, tablespace, indexdef)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgIndexesViewRow, merge: (NewRow, PgIndexesViewRow) => NewRow): PgIndexesViewStructure[NewRow] =
    new PgIndexesViewStructure(prefix, extract, merge)
}
