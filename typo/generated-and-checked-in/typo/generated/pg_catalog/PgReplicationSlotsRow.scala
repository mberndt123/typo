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
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgReplicationSlotsRow(
  slotName: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"slot_name","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  plugin: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"plugin","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  slotType: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"slot_type","ordinal_position":3,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  datoid: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"datoid","ordinal_position":4,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  database: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"database","ordinal_position":5,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  temporary: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"temporary","ordinal_position":6,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  active: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"active","ordinal_position":7,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  activePid: Option[Int] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"active_pid","ordinal_position":8,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  xmin: Option[PGobject] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"xmin","ordinal_position":9,"is_nullable":"YES","data_type":"xid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"xid","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  catalogXmin: Option[PGobject] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"catalog_xmin","ordinal_position":10,"is_nullable":"YES","data_type":"xid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"xid","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  restartLsn: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"restart_lsn","ordinal_position":11,"is_nullable":"YES","data_type":"pg_lsn","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"pg_lsn","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  confirmedFlushLsn: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"confirmed_flush_lsn","ordinal_position":12,"is_nullable":"YES","data_type":"pg_lsn","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"pg_lsn","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  walStatus: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"wal_status","ordinal_position":13,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  safeWalSize: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"safe_wal_size","ordinal_position":14,"is_nullable":"YES","data_type":"bigint","numeric_precision":64,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int8","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  twoPhase: Option[Boolean] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_slots","column_name":"two_phase","ordinal_position":15,"is_nullable":"YES","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgReplicationSlotsRow {
  implicit val rowParser: RowParser[PgReplicationSlotsRow] = { row =>
    Success(
      PgReplicationSlotsRow(
        slotName = row[Option[String]]("slot_name"),
        plugin = row[Option[String]]("plugin"),
        slotType = row[Option[String]]("slot_type"),
        datoid = row[Option[Long]]("datoid"),
        database = row[Option[String]]("database"),
        temporary = row[Option[Boolean]]("temporary"),
        active = row[Option[Boolean]]("active"),
        activePid = row[Option[Int]]("active_pid"),
        xmin = row[Option[PGobject]]("xmin"),
        catalogXmin = row[Option[PGobject]]("catalog_xmin"),
        restartLsn = row[Option[String]]("restart_lsn"),
        confirmedFlushLsn = row[Option[String]]("confirmed_flush_lsn"),
        walStatus = row[Option[String]]("wal_status"),
        safeWalSize = row[Option[Long]]("safe_wal_size"),
        twoPhase = row[Option[Boolean]]("two_phase")
      )
    )
  }

  implicit val oFormat: OFormat[PgReplicationSlotsRow] = new OFormat[PgReplicationSlotsRow]{
    override def writes(o: PgReplicationSlotsRow): JsObject =
      Json.obj(
        "slot_name" -> o.slotName,
      "plugin" -> o.plugin,
      "slot_type" -> o.slotType,
      "datoid" -> o.datoid,
      "database" -> o.database,
      "temporary" -> o.temporary,
      "active" -> o.active,
      "active_pid" -> o.activePid,
      "xmin" -> o.xmin,
      "catalog_xmin" -> o.catalogXmin,
      "restart_lsn" -> o.restartLsn,
      "confirmed_flush_lsn" -> o.confirmedFlushLsn,
      "wal_status" -> o.walStatus,
      "safe_wal_size" -> o.safeWalSize,
      "two_phase" -> o.twoPhase
      )

    override def reads(json: JsValue): JsResult[PgReplicationSlotsRow] = {
      JsResult.fromTry(
        Try(
          PgReplicationSlotsRow(
            slotName = json.\("slot_name").toOption.map(_.as[String]),
            plugin = json.\("plugin").toOption.map(_.as[String]),
            slotType = json.\("slot_type").toOption.map(_.as[String]),
            datoid = json.\("datoid").toOption.map(_.as[Long]),
            database = json.\("database").toOption.map(_.as[String]),
            temporary = json.\("temporary").toOption.map(_.as[Boolean]),
            active = json.\("active").toOption.map(_.as[Boolean]),
            activePid = json.\("active_pid").toOption.map(_.as[Int]),
            xmin = json.\("xmin").toOption.map(_.as[PGobject]),
            catalogXmin = json.\("catalog_xmin").toOption.map(_.as[PGobject]),
            restartLsn = json.\("restart_lsn").toOption.map(_.as[String]),
            confirmedFlushLsn = json.\("confirmed_flush_lsn").toOption.map(_.as[String]),
            walStatus = json.\("wal_status").toOption.map(_.as[String]),
            safeWalSize = json.\("safe_wal_size").toOption.map(_.as[Long]),
            twoPhase = json.\("two_phase").toOption.map(_.as[Boolean])
          )
        )
      )
    }
  }
}
