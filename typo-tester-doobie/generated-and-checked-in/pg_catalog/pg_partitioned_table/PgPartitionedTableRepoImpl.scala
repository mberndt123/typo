/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_partitioned_table

import adventureworks.TypoInt2Vector
import adventureworks.TypoOidVector
import adventureworks.TypoPgNodeTree
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgPartitionedTableRepoImpl extends PgPartitionedTableRepo {
  override def delete(partrelid: PgPartitionedTableId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_partitioned_table where partrelid = ${fromWrite(partrelid)(Write.fromPut(PgPartitionedTableId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgPartitionedTableFields, PgPartitionedTableRow] = {
    DeleteBuilder("pg_catalog.pg_partitioned_table", PgPartitionedTableFields)
  }
  override def insert(unsaved: PgPartitionedTableRow): ConnectionIO[PgPartitionedTableRow] = {
    sql"""insert into pg_catalog.pg_partitioned_table(partrelid, partstrat, partnatts, partdefid, partattrs, partclass, partcollation, partexprs)
          values (${fromWrite(unsaved.partrelid)(Write.fromPut(PgPartitionedTableId.put))}::oid, ${fromWrite(unsaved.partstrat)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.partnatts)(Write.fromPut(Meta.IntMeta.put))}::int2, ${fromWrite(unsaved.partdefid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.partattrs)(Write.fromPut(TypoInt2Vector.put))}::int2vector, ${fromWrite(unsaved.partclass)(Write.fromPut(TypoOidVector.put))}::oidvector, ${fromWrite(unsaved.partcollation)(Write.fromPut(TypoOidVector.put))}::oidvector, ${fromWrite(unsaved.partexprs)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree)
          returning partrelid, partstrat, partnatts, partdefid, partattrs, partclass, partcollation, partexprs
       """.query(PgPartitionedTableRow.read).unique
  }
  override def select: SelectBuilder[PgPartitionedTableFields, PgPartitionedTableRow] = {
    SelectBuilderSql("pg_catalog.pg_partitioned_table", PgPartitionedTableFields, PgPartitionedTableRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgPartitionedTableRow] = {
    sql"select partrelid, partstrat, partnatts, partdefid, partattrs, partclass, partcollation, partexprs from pg_catalog.pg_partitioned_table".query(PgPartitionedTableRow.read).stream
  }
  override def selectById(partrelid: PgPartitionedTableId): ConnectionIO[Option[PgPartitionedTableRow]] = {
    sql"select partrelid, partstrat, partnatts, partdefid, partattrs, partclass, partcollation, partexprs from pg_catalog.pg_partitioned_table where partrelid = ${fromWrite(partrelid)(Write.fromPut(PgPartitionedTableId.put))}".query(PgPartitionedTableRow.read).option
  }
  override def selectByIds(partrelids: Array[PgPartitionedTableId]): Stream[ConnectionIO, PgPartitionedTableRow] = {
    sql"select partrelid, partstrat, partnatts, partdefid, partattrs, partclass, partcollation, partexprs from pg_catalog.pg_partitioned_table where partrelid = ANY(${partrelids})".query(PgPartitionedTableRow.read).stream
  }
  override def update(row: PgPartitionedTableRow): ConnectionIO[Boolean] = {
    val partrelid = row.partrelid
    sql"""update pg_catalog.pg_partitioned_table
          set partstrat = ${fromWrite(row.partstrat)(Write.fromPut(Meta.StringMeta.put))}::char,
              partnatts = ${fromWrite(row.partnatts)(Write.fromPut(Meta.IntMeta.put))}::int2,
              partdefid = ${fromWrite(row.partdefid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              partattrs = ${fromWrite(row.partattrs)(Write.fromPut(TypoInt2Vector.put))}::int2vector,
              partclass = ${fromWrite(row.partclass)(Write.fromPut(TypoOidVector.put))}::oidvector,
              partcollation = ${fromWrite(row.partcollation)(Write.fromPut(TypoOidVector.put))}::oidvector,
              partexprs = ${fromWrite(row.partexprs)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree
          where partrelid = ${fromWrite(partrelid)(Write.fromPut(PgPartitionedTableId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgPartitionedTableFields, PgPartitionedTableRow] = {
    UpdateBuilder("pg_catalog.pg_partitioned_table", PgPartitionedTableFields, PgPartitionedTableRow.read)
  }
  override def upsert(unsaved: PgPartitionedTableRow): ConnectionIO[PgPartitionedTableRow] = {
    sql"""insert into pg_catalog.pg_partitioned_table(partrelid, partstrat, partnatts, partdefid, partattrs, partclass, partcollation, partexprs)
          values (
            ${fromWrite(unsaved.partrelid)(Write.fromPut(PgPartitionedTableId.put))}::oid,
            ${fromWrite(unsaved.partstrat)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.partnatts)(Write.fromPut(Meta.IntMeta.put))}::int2,
            ${fromWrite(unsaved.partdefid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.partattrs)(Write.fromPut(TypoInt2Vector.put))}::int2vector,
            ${fromWrite(unsaved.partclass)(Write.fromPut(TypoOidVector.put))}::oidvector,
            ${fromWrite(unsaved.partcollation)(Write.fromPut(TypoOidVector.put))}::oidvector,
            ${fromWrite(unsaved.partexprs)(Write.fromPutOption(TypoPgNodeTree.put))}::pg_node_tree
          )
          on conflict (partrelid)
          do update set
            partstrat = EXCLUDED.partstrat,
            partnatts = EXCLUDED.partnatts,
            partdefid = EXCLUDED.partdefid,
            partattrs = EXCLUDED.partattrs,
            partclass = EXCLUDED.partclass,
            partcollation = EXCLUDED.partcollation,
            partexprs = EXCLUDED.partexprs
          returning partrelid, partstrat, partnatts, partdefid, partattrs, partclass, partcollation, partexprs
       """.query(PgPartitionedTableRow.read).unique
  }
}
