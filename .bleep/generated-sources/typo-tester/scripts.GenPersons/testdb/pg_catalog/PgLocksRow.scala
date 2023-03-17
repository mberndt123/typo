package testdb.pg_catalog

import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class PgLocksRow(
  locktype: /* unknown nullability */ Option[String],
  database: /* unknown nullability */ Option[Long],
  relation: /* unknown nullability */ Option[Long],
  page: /* unknown nullability */ Option[Int],
  tuple: /* unknown nullability */ Option[Short],
  virtualxid: /* unknown nullability */ Option[String],
  transactionid: /* unknown nullability */ Option[/* xid */ String],
  classid: /* unknown nullability */ Option[Long],
  objid: /* unknown nullability */ Option[Long],
  objsubid: /* unknown nullability */ Option[Short],
  virtualtransaction: /* unknown nullability */ Option[String],
  pid: /* unknown nullability */ Option[Int],
  mode: /* unknown nullability */ Option[String],
  granted: /* unknown nullability */ Option[Boolean],
  fastpath: /* unknown nullability */ Option[Boolean],
  waitstart: /* unknown nullability */ Option[LocalDateTime]
)

object PgLocksRow {
  implicit val rowParser: RowParser[PgLocksRow] = { row =>
    Success(
      PgLocksRow(
        locktype = row[/* unknown nullability */ Option[String]]("locktype"),
        database = row[/* unknown nullability */ Option[Long]]("database"),
        relation = row[/* unknown nullability */ Option[Long]]("relation"),
        page = row[/* unknown nullability */ Option[Int]]("page"),
        tuple = row[/* unknown nullability */ Option[Short]]("tuple"),
        virtualxid = row[/* unknown nullability */ Option[String]]("virtualxid"),
        transactionid = row[/* unknown nullability */ Option[/* xid */ String]]("transactionid"),
        classid = row[/* unknown nullability */ Option[Long]]("classid"),
        objid = row[/* unknown nullability */ Option[Long]]("objid"),
        objsubid = row[/* unknown nullability */ Option[Short]]("objsubid"),
        virtualtransaction = row[/* unknown nullability */ Option[String]]("virtualtransaction"),
        pid = row[/* unknown nullability */ Option[Int]]("pid"),
        mode = row[/* unknown nullability */ Option[String]]("mode"),
        granted = row[/* unknown nullability */ Option[Boolean]]("granted"),
        fastpath = row[/* unknown nullability */ Option[Boolean]]("fastpath"),
        waitstart = row[/* unknown nullability */ Option[LocalDateTime]]("waitstart")
      )
    )
  }

  implicit val oFormat: OFormat[PgLocksRow] = Json.format
}
