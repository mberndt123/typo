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



case class PgIndexRowUnsaved(
  indrelid: Long,
  indnatts: Short,
  indnkeyatts: Short,
  indisunique: Boolean,
  indisprimary: Boolean,
  indisexclusion: Boolean,
  indimmediate: Boolean,
  indisclustered: Boolean,
  indisvalid: Boolean,
  indcheckxmin: Boolean,
  indisready: Boolean,
  indislive: Boolean,
  indisreplident: Boolean,
  indkey: String,
  indcollation: Array[Long],
  indclass: Array[Long],
  indoption: String,
  indexprs: Option[String],
  indpred: Option[String]
)
object PgIndexRowUnsaved {
  
}
