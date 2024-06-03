/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
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

class PhonenumbertypeRepoImpl extends PhonenumbertypeRepo {
  override def delete: DeleteBuilder[PhonenumbertypeFields, PhonenumbertypeRow] = {
    DeleteBuilder("person.phonenumbertype", PhonenumbertypeFields.structure)
  }
  override def deleteById(phonenumbertypeid: PhonenumbertypeId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from person.phonenumbertype where "phonenumbertypeid" = ${Segment.paramSegment(phonenumbertypeid)(PhonenumbertypeId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(phonenumbertypeids: Array[PhonenumbertypeId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from person.phonenumbertype where "phonenumbertypeid" = ANY(${phonenumbertypeids})""".delete
  }
  override def insert(unsaved: PhonenumbertypeRow): ZIO[ZConnection, Throwable, PhonenumbertypeRow] = {
    sql"""insert into person.phonenumbertype("phonenumbertypeid", "name", "modifieddate")
          values (${Segment.paramSegment(unsaved.phonenumbertypeid)(PhonenumbertypeId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "phonenumbertypeid", "name", "modifieddate"::text
       """.insertReturning(using PhonenumbertypeRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: PhonenumbertypeRowUnsaved): ZIO[ZConnection, Throwable, PhonenumbertypeRow] = {
    val fs = List(
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      unsaved.phonenumbertypeid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""phonenumbertypeid"""", sql"${Segment.paramSegment(value: PhonenumbertypeId)(PhonenumbertypeId.setter)}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.phonenumbertype default values
            returning "phonenumbertypeid", "name", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into person.phonenumbertype($names) values ($values) returning "phonenumbertypeid", "name", "modifieddate"::text"""
    }
    q.insertReturning(using PhonenumbertypeRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PhonenumbertypeRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.phonenumbertype("phonenumbertypeid", "name", "modifieddate") FROM STDIN""", batchSize, unsaved)(PhonenumbertypeRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PhonenumbertypeRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.phonenumbertype("name", "phonenumbertypeid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(PhonenumbertypeRowUnsaved.text)
  }
  override def select: SelectBuilder[PhonenumbertypeFields, PhonenumbertypeRow] = {
    SelectBuilderSql("person.phonenumbertype", PhonenumbertypeFields.structure, PhonenumbertypeRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PhonenumbertypeRow] = {
    sql"""select "phonenumbertypeid", "name", "modifieddate"::text from person.phonenumbertype""".query(using PhonenumbertypeRow.jdbcDecoder).selectStream()
  }
  override def selectById(phonenumbertypeid: PhonenumbertypeId): ZIO[ZConnection, Throwable, Option[PhonenumbertypeRow]] = {
    sql"""select "phonenumbertypeid", "name", "modifieddate"::text from person.phonenumbertype where "phonenumbertypeid" = ${Segment.paramSegment(phonenumbertypeid)(PhonenumbertypeId.setter)}""".query(using PhonenumbertypeRow.jdbcDecoder).selectOne
  }
  override def selectByIds(phonenumbertypeids: Array[PhonenumbertypeId]): ZStream[ZConnection, Throwable, PhonenumbertypeRow] = {
    sql"""select "phonenumbertypeid", "name", "modifieddate"::text from person.phonenumbertype where "phonenumbertypeid" = ANY(${Segment.paramSegment(phonenumbertypeids)(PhonenumbertypeId.arraySetter)})""".query(using PhonenumbertypeRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(phonenumbertypeids: Array[PhonenumbertypeId]): ZIO[ZConnection, Throwable, Map[PhonenumbertypeId, PhonenumbertypeRow]] = {
    selectByIds(phonenumbertypeids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.phonenumbertypeid, x)).toMap
      phonenumbertypeids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[PhonenumbertypeFields, PhonenumbertypeRow] = {
    UpdateBuilder("person.phonenumbertype", PhonenumbertypeFields.structure, PhonenumbertypeRow.jdbcDecoder)
  }
  override def update(row: PhonenumbertypeRow): ZIO[ZConnection, Throwable, Boolean] = {
    val phonenumbertypeid = row.phonenumbertypeid
    sql"""update person.phonenumbertype
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "phonenumbertypeid" = ${Segment.paramSegment(phonenumbertypeid)(PhonenumbertypeId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: PhonenumbertypeRow): ZIO[ZConnection, Throwable, UpdateResult[PhonenumbertypeRow]] = {
    sql"""insert into person.phonenumbertype("phonenumbertypeid", "name", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.phonenumbertypeid)(PhonenumbertypeId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("phonenumbertypeid")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "phonenumbertypeid", "name", "modifieddate"::text""".insertReturning(using PhonenumbertypeRow.jdbcDecoder)
  }
}
