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

case class PgTypeRow(
  oid: PgTypeId,
  typname: String,
  typnamespace: Long,
  typowner: Long,
  typlen: Short,
  typbyval: Boolean,
  typtype: String,
  typcategory: String,
  typispreferred: Boolean,
  typisdefined: Boolean,
  typdelim: String,
  typrelid: Long,
  typsubscript: String,
  typelem: Long,
  typarray: Long,
  typinput: String,
  typoutput: String,
  typreceive: String,
  typsend: String,
  typmodin: String,
  typmodout: String,
  typanalyze: String,
  typalign: String,
  typstorage: String,
  typnotnull: Boolean,
  typbasetype: Long,
  typtypmod: Int,
  typndims: Int,
  typcollation: Long,
  typdefaultbin: Option[String],
  typdefault: Option[String],
  typacl: Option[Array[String]]
)

object PgTypeRow {
  implicit val rowParser: RowParser[PgTypeRow] = { row =>
    Success(
      PgTypeRow(
        oid = row[PgTypeId]("oid"),
        typname = row[String]("typname"),
        typnamespace = row[Long]("typnamespace"),
        typowner = row[Long]("typowner"),
        typlen = row[Short]("typlen"),
        typbyval = row[Boolean]("typbyval"),
        typtype = row[String]("typtype"),
        typcategory = row[String]("typcategory"),
        typispreferred = row[Boolean]("typispreferred"),
        typisdefined = row[Boolean]("typisdefined"),
        typdelim = row[String]("typdelim"),
        typrelid = row[Long]("typrelid"),
        typsubscript = row[String]("typsubscript"),
        typelem = row[Long]("typelem"),
        typarray = row[Long]("typarray"),
        typinput = row[String]("typinput"),
        typoutput = row[String]("typoutput"),
        typreceive = row[String]("typreceive"),
        typsend = row[String]("typsend"),
        typmodin = row[String]("typmodin"),
        typmodout = row[String]("typmodout"),
        typanalyze = row[String]("typanalyze"),
        typalign = row[String]("typalign"),
        typstorage = row[String]("typstorage"),
        typnotnull = row[Boolean]("typnotnull"),
        typbasetype = row[Long]("typbasetype"),
        typtypmod = row[Int]("typtypmod"),
        typndims = row[Int]("typndims"),
        typcollation = row[Long]("typcollation"),
        typdefaultbin = row[Option[String]]("typdefaultbin"),
        typdefault = row[Option[String]]("typdefault"),
        typacl = row[Option[Array[String]]]("typacl")
      )
    )
  }

  
}
