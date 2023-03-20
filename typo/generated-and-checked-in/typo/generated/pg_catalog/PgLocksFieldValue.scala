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

import java.time.LocalDateTime

sealed abstract class PgLocksFieldValue[T](val name: String, val value: T)

object PgLocksFieldValue {
  case class locktype(override val value: /* unknown nullability */ Option[String]) extends PgLocksFieldValue("locktype", value)
  case class database(override val value: /* unknown nullability */ Option[Long]) extends PgLocksFieldValue("database", value)
  case class relation(override val value: /* unknown nullability */ Option[Long]) extends PgLocksFieldValue("relation", value)
  case class page(override val value: /* unknown nullability */ Option[Int]) extends PgLocksFieldValue("page", value)
  case class tuple(override val value: /* unknown nullability */ Option[Short]) extends PgLocksFieldValue("tuple", value)
  case class virtualxid(override val value: /* unknown nullability */ Option[String]) extends PgLocksFieldValue("virtualxid", value)
  case class transactionid(override val value: /* unknown nullability */ Option[/* xid */ String]) extends PgLocksFieldValue("transactionid", value)
  case class classid(override val value: /* unknown nullability */ Option[Long]) extends PgLocksFieldValue("classid", value)
  case class objid(override val value: /* unknown nullability */ Option[Long]) extends PgLocksFieldValue("objid", value)
  case class objsubid(override val value: /* unknown nullability */ Option[Short]) extends PgLocksFieldValue("objsubid", value)
  case class virtualtransaction(override val value: /* unknown nullability */ Option[String]) extends PgLocksFieldValue("virtualtransaction", value)
  case class pid(override val value: /* unknown nullability */ Option[Int]) extends PgLocksFieldValue("pid", value)
  case class mode(override val value: /* unknown nullability */ Option[String]) extends PgLocksFieldValue("mode", value)
  case class granted(override val value: /* unknown nullability */ Option[Boolean]) extends PgLocksFieldValue("granted", value)
  case class fastpath(override val value: /* unknown nullability */ Option[Boolean]) extends PgLocksFieldValue("fastpath", value)
  case class waitstart(override val value: /* unknown nullability */ Option[LocalDateTime]) extends PgLocksFieldValue("waitstart", value)
}
