/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.businessentityaddress

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.address.AddressId
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class BusinessentityaddressRepoImpl extends BusinessentityaddressRepo {
  override def delete: DeleteBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    DeleteBuilder("person.businessentityaddress", BusinessentityaddressFields.structure)
  }
  override def deleteById(compositeId: BusinessentityaddressId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from person.businessentityaddress where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "addressid" = ${Segment.paramSegment(compositeId.addressid)(AddressId.setter)} AND "addresstypeid" = ${Segment.paramSegment(compositeId.addresstypeid)(AddresstypeId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[BusinessentityaddressId]): ZIO[ZConnection, Throwable, Long] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val addressid = compositeIds.map(_.addressid)
    val addresstypeid = compositeIds.map(_.addresstypeid)
    sql"""delete
          from person.businessentityaddress
          where ("businessentityid", "addressid", "addresstypeid")
          in (select unnest(${Segment.paramSegment(businessentityid)(BusinessentityId.arraySetter)}), unnest(${Segment.paramSegment(addressid)(AddressId.arraySetter)}), unnest(${Segment.paramSegment(addresstypeid)(AddresstypeId.arraySetter)}))
       """.delete
    
  }
  override def insert(unsaved: BusinessentityaddressRow): ZIO[ZConnection, Throwable, BusinessentityaddressRow] = {
    sql"""insert into person.businessentityaddress("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.addressid)(AddressId.setter)}::int4, ${Segment.paramSegment(unsaved.addresstypeid)(AddresstypeId.setter)}::int4, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
       """.insertReturning(using BusinessentityaddressRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: BusinessentityaddressRowUnsaved): ZIO[ZConnection, Throwable, BusinessentityaddressRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""addressid"""", sql"${Segment.paramSegment(unsaved.addressid)(AddressId.setter)}::int4")),
      Some((sql""""addresstypeid"""", sql"${Segment.paramSegment(unsaved.addresstypeid)(AddresstypeId.setter)}::int4")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""rowguid"""", sql"${Segment.paramSegment(value: TypoUUID)(TypoUUID.setter)}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.businessentityaddress default values
            returning "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into person.businessentityaddress($names) values ($values) returning "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using BusinessentityaddressRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentityaddressRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.businessentityaddress("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(BusinessentityaddressRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentityaddressRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.businessentityaddress("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(BusinessentityaddressRowUnsaved.text)
  }
  override def select: SelectBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    SelectBuilderSql("person.businessentityaddress", BusinessentityaddressFields.structure, BusinessentityaddressRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, BusinessentityaddressRow] = {
    sql"""select "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text from person.businessentityaddress""".query(using BusinessentityaddressRow.jdbcDecoder).selectStream()
  }
  override def selectById(compositeId: BusinessentityaddressId): ZIO[ZConnection, Throwable, Option[BusinessentityaddressRow]] = {
    sql"""select "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text from person.businessentityaddress where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "addressid" = ${Segment.paramSegment(compositeId.addressid)(AddressId.setter)} AND "addresstypeid" = ${Segment.paramSegment(compositeId.addresstypeid)(AddresstypeId.setter)}""".query(using BusinessentityaddressRow.jdbcDecoder).selectOne
  }
  override def selectByIds(compositeIds: Array[BusinessentityaddressId]): ZStream[ZConnection, Throwable, BusinessentityaddressRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val addressid = compositeIds.map(_.addressid)
    val addresstypeid = compositeIds.map(_.addresstypeid)
    sql"""select "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
          from person.businessentityaddress
          where ("businessentityid", "addressid", "addresstypeid")
          in (select unnest(${Segment.paramSegment(businessentityid)(BusinessentityId.arraySetter)}), unnest(${Segment.paramSegment(addressid)(AddressId.arraySetter)}), unnest(${Segment.paramSegment(addresstypeid)(AddresstypeId.arraySetter)}))
       """.query(using BusinessentityaddressRow.jdbcDecoder).selectStream()
    
  }
  override def selectByIdsTracked(compositeIds: Array[BusinessentityaddressId]): ZIO[ZConnection, Throwable, Map[BusinessentityaddressId, BusinessentityaddressRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    UpdateBuilder("person.businessentityaddress", BusinessentityaddressFields.structure, BusinessentityaddressRow.jdbcDecoder)
  }
  override def update(row: BusinessentityaddressRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update person.businessentityaddress
          set "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "addressid" = ${Segment.paramSegment(compositeId.addressid)(AddressId.setter)} AND "addresstypeid" = ${Segment.paramSegment(compositeId.addresstypeid)(AddresstypeId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: BusinessentityaddressRow): ZIO[ZConnection, Throwable, UpdateResult[BusinessentityaddressRow]] = {
    sql"""insert into person.businessentityaddress("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.addressid)(AddressId.setter)}::int4,
            ${Segment.paramSegment(unsaved.addresstypeid)(AddresstypeId.setter)}::int4,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid", "addressid", "addresstypeid")
          do update set
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text""".insertReturning(using BusinessentityaddressRow.jdbcDecoder)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentityaddressRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table businessentityaddress_TEMP (like person.businessentityaddress) on commit drop".execute
    val copied = streamingInsert(s"""copy businessentityaddress_TEMP("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(BusinessentityaddressRow.text)
    val merged = sql"""insert into person.businessentityaddress("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")
                       select * from businessentityaddress_TEMP
                       on conflict ("businessentityid", "addressid", "addresstypeid")
                       do update set
                         "rowguid" = EXCLUDED."rowguid",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table businessentityaddress_TEMP;""".update
    created *> copied *> merged
  }
}
