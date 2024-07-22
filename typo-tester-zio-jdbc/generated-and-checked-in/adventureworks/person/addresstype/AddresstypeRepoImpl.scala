/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.addresstype

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
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

class AddresstypeRepoImpl extends AddresstypeRepo {
  override def delete: DeleteBuilder[AddresstypeFields, AddresstypeRow] = {
    DeleteBuilder("person.addresstype", AddresstypeFields.structure)
  }
  override def deleteById(addresstypeid: AddresstypeId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from person.addresstype where "addresstypeid" = ${Segment.paramSegment(addresstypeid)(AddresstypeId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(addresstypeids: Array[AddresstypeId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from person.addresstype where "addresstypeid" = ANY(${Segment.paramSegment(addresstypeids)(AddresstypeId.arraySetter)})""".delete
  }
  override def insert(unsaved: AddresstypeRow): ZIO[ZConnection, Throwable, AddresstypeRow] = {
    sql"""insert into person.addresstype("addresstypeid", "name", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.addresstypeid)(AddresstypeId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "addresstypeid", "name", "rowguid", "modifieddate"::text
       """.insertReturning(using AddresstypeRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: AddresstypeRowUnsaved): ZIO[ZConnection, Throwable, AddresstypeRow] = {
    val fs = List(
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      unsaved.addresstypeid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""addresstypeid"""", sql"${Segment.paramSegment(value: AddresstypeId)(AddresstypeId.setter)}::int4"))
      },
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
      sql"""insert into person.addresstype default values
            returning "addresstypeid", "name", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into person.addresstype($names) values ($values) returning "addresstypeid", "name", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using AddresstypeRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, AddresstypeRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.addresstype("addresstypeid", "name", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(AddresstypeRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, AddresstypeRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.addresstype("name", "addresstypeid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(AddresstypeRowUnsaved.text)
  }
  override def select: SelectBuilder[AddresstypeFields, AddresstypeRow] = {
    SelectBuilderSql("person.addresstype", AddresstypeFields.structure, AddresstypeRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, AddresstypeRow] = {
    sql"""select "addresstypeid", "name", "rowguid", "modifieddate"::text from person.addresstype""".query(using AddresstypeRow.jdbcDecoder).selectStream()
  }
  override def selectById(addresstypeid: AddresstypeId): ZIO[ZConnection, Throwable, Option[AddresstypeRow]] = {
    sql"""select "addresstypeid", "name", "rowguid", "modifieddate"::text from person.addresstype where "addresstypeid" = ${Segment.paramSegment(addresstypeid)(AddresstypeId.setter)}""".query(using AddresstypeRow.jdbcDecoder).selectOne
  }
  override def selectByIds(addresstypeids: Array[AddresstypeId]): ZStream[ZConnection, Throwable, AddresstypeRow] = {
    sql"""select "addresstypeid", "name", "rowguid", "modifieddate"::text from person.addresstype where "addresstypeid" = ANY(${Segment.paramSegment(addresstypeids)(AddresstypeId.arraySetter)})""".query(using AddresstypeRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(addresstypeids: Array[AddresstypeId]): ZIO[ZConnection, Throwable, Map[AddresstypeId, AddresstypeRow]] = {
    selectByIds(addresstypeids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.addresstypeid, x)).toMap
      addresstypeids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[AddresstypeFields, AddresstypeRow] = {
    UpdateBuilder("person.addresstype", AddresstypeFields.structure, AddresstypeRow.jdbcDecoder)
  }
  override def update(row: AddresstypeRow): ZIO[ZConnection, Throwable, Boolean] = {
    val addresstypeid = row.addresstypeid
    sql"""update person.addresstype
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "addresstypeid" = ${Segment.paramSegment(addresstypeid)(AddresstypeId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: AddresstypeRow): ZIO[ZConnection, Throwable, UpdateResult[AddresstypeRow]] = {
    sql"""insert into person.addresstype("addresstypeid", "name", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.addresstypeid)(AddresstypeId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("addresstypeid")
          do update set
            "name" = EXCLUDED."name",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "addresstypeid", "name", "rowguid", "modifieddate"::text""".insertReturning(using AddresstypeRow.jdbcDecoder)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, AddresstypeRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table addresstype_TEMP (like person.addresstype) on commit drop".execute
    val copied = streamingInsert(s"""copy addresstype_TEMP("addresstypeid", "name", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(AddresstypeRow.text)
    val merged = sql"""insert into person.addresstype("addresstypeid", "name", "rowguid", "modifieddate")
                       select * from addresstype_TEMP
                       on conflict ("addresstypeid")
                       do update set
                         "name" = EXCLUDED."name",
                         "rowguid" = EXCLUDED."rowguid",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table addresstype_TEMP;""".update
    created *> copied *> merged
  }
}
