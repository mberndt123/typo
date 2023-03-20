/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.RowParser
import anorm.Success

case class PgClassRow(
  oid: PgClassId,
  relname: String,
  relnamespace: Long,
  reltype: Long,
  reloftype: Long,
  relowner: Long,
  relam: Long,
  relfilenode: Long,
  reltablespace: Long,
  relpages: Int,
  reltuples: Float,
  relallvisible: Int,
  reltoastrelid: Long,
  relhasindex: Boolean,
  relisshared: Boolean,
  relpersistence: String,
  relkind: String,
  relnatts: Short,
  relchecks: Short,
  relhasrules: Boolean,
  relhastriggers: Boolean,
  relhassubclass: Boolean,
  relrowsecurity: Boolean,
  relforcerowsecurity: Boolean,
  relispopulated: Boolean,
  relreplident: String,
  relispartition: Boolean,
  relrewrite: Long,
  relfrozenxid: String,
  relminmxid: String,
  relacl: Option[Array[String]],
  reloptions: Option[Array[String]],
  relpartbound: Option[String]
)

object PgClassRow {
  implicit val rowParser: RowParser[PgClassRow] = { row =>
    Success(
      PgClassRow(
        oid = row[PgClassId]("oid"),
        relname = row[String]("relname"),
        relnamespace = row[Long]("relnamespace"),
        reltype = row[Long]("reltype"),
        reloftype = row[Long]("reloftype"),
        relowner = row[Long]("relowner"),
        relam = row[Long]("relam"),
        relfilenode = row[Long]("relfilenode"),
        reltablespace = row[Long]("reltablespace"),
        relpages = row[Int]("relpages"),
        reltuples = row[Float]("reltuples"),
        relallvisible = row[Int]("relallvisible"),
        reltoastrelid = row[Long]("reltoastrelid"),
        relhasindex = row[Boolean]("relhasindex"),
        relisshared = row[Boolean]("relisshared"),
        relpersistence = row[String]("relpersistence"),
        relkind = row[String]("relkind"),
        relnatts = row[Short]("relnatts"),
        relchecks = row[Short]("relchecks"),
        relhasrules = row[Boolean]("relhasrules"),
        relhastriggers = row[Boolean]("relhastriggers"),
        relhassubclass = row[Boolean]("relhassubclass"),
        relrowsecurity = row[Boolean]("relrowsecurity"),
        relforcerowsecurity = row[Boolean]("relforcerowsecurity"),
        relispopulated = row[Boolean]("relispopulated"),
        relreplident = row[String]("relreplident"),
        relispartition = row[Boolean]("relispartition"),
        relrewrite = row[Long]("relrewrite"),
        relfrozenxid = row[String]("relfrozenxid"),
        relminmxid = row[String]("relminmxid"),
        relacl = row[Option[Array[String]]]("relacl"),
        reloptions = row[Option[Array[String]]]("reloptions"),
        relpartbound = row[Option[String]]("relpartbound")
      )
    )
  }

  
}
