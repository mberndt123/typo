/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.humanresources.shift;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoLocalTime;
import adventureworks.public.Name;
import adventureworks.streamingInsert;
import anorm.BatchSql;
import anorm.NamedParameter;
import anorm.ParameterValue;
import anorm.RowParser;
import anorm.SQL;
import anorm.SimpleSql;
import anorm.SqlStringInterpolation;
import java.sql.Connection;
import scala.annotation.nowarn;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import typo.dsl.UpdateBuilder;

class ShiftRepoImpl extends ShiftRepo {
  def delete: DeleteBuilder[ShiftFields, ShiftRow] = DeleteBuilder("humanresources.shift", ShiftFields.structure)
  def deleteById(shiftid: ShiftId)(implicit c: Connection): Boolean = SQL"""delete from humanresources.shift where "shiftid" = ${ParameterValue(shiftid, null, ShiftId.toStatement)}""".executeUpdate() > 0
  def deleteByIds(shiftids: Array[ShiftId])(implicit c: Connection): Int = {
    SQL"""delete
          from humanresources.shift
          where "shiftid" = ANY(${ParameterValue(shiftids, null, ShiftId.arrayToStatement)})
       """.executeUpdate()
  
  }
  def insert(unsaved: ShiftRow)(implicit c: Connection): ShiftRow = {
    SQL"""insert into humanresources.shift("shiftid", "name", "starttime", "endtime", "modifieddate")
           values (${ParameterValue(unsaved.shiftid, null, ShiftId.toStatement)}::int4, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.starttime, null, TypoLocalTime.toStatement)}::time, ${ParameterValue(unsaved.endtime, null, TypoLocalTime.toStatement)}::time, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
           returning "shiftid", "name", "starttime"::text, "endtime"::text, "modifieddate"::text
        """
      .executeInsert(ShiftRow.rowParser(1).single)
  
  }
  def insert(unsaved: ShiftRowUnsaved)(implicit c: Connection): ShiftRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
                      Some((NamedParameter("starttime", ParameterValue(unsaved.starttime, null, TypoLocalTime.toStatement)), "::time")),
                      Some((NamedParameter("endtime", ParameterValue(unsaved.endtime, null, TypoLocalTime.toStatement)), "::time")),
    unsaved.shiftid match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((NamedParameter("shiftid", ParameterValue(value, null, ShiftId.toStatement)), "::int4"))
    },
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
    }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into humanresources.shift default values
                            returning "shiftid", "name", "starttime"::text, "endtime"::text, "modifieddate"::text
                         """
        .executeInsert(ShiftRow.rowParser(1).single)
    } else {
      val q = s"""insert into humanresources.shift(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                                  returning "shiftid", "name", "starttime"::text, "endtime"::text, "modifieddate"::text
                               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ShiftRow.rowParser(1).single)
    }
  
  }
  def insertStreaming(unsaved: Iterator[ShiftRow], batchSize: Int = 10000)(implicit c: Connection): Long = streamingInsert(s"""COPY humanresources.shift("shiftid", "name", "starttime", "endtime", "modifieddate") FROM STDIN""", batchSize, unsaved)(ShiftRow.text, c)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ShiftRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = streamingInsert(s"""COPY humanresources.shift("name", "starttime", "endtime", "shiftid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ShiftRowUnsaved.text, c)
  def select: SelectBuilder[ShiftFields, ShiftRow] = SelectBuilderSql("humanresources.shift", ShiftFields.structure, ShiftRow.rowParser)
  def selectAll(implicit c: Connection): List[ShiftRow] = {
    SQL"""select "shiftid", "name", "starttime"::text, "endtime"::text, "modifieddate"::text
          from humanresources.shift
       """.as(ShiftRow.rowParser(1).*)
  }
  def selectById(shiftid: ShiftId)(implicit c: Connection): Option[ShiftRow] = {
    SQL"""select "shiftid", "name", "starttime"::text, "endtime"::text, "modifieddate"::text
          from humanresources.shift
          where "shiftid" = ${ParameterValue(shiftid, null, ShiftId.toStatement)}
       """.as(ShiftRow.rowParser(1).singleOpt)
  }
  def selectByIds(shiftids: Array[ShiftId])(implicit c: Connection): List[ShiftRow] = {
    SQL"""select "shiftid", "name", "starttime"::text, "endtime"::text, "modifieddate"::text
          from humanresources.shift
          where "shiftid" = ANY(${ParameterValue(shiftids, null, ShiftId.arrayToStatement)})
       """.as(ShiftRow.rowParser(1).*)
  
  }
  def selectByIdsTracked(shiftids: Array[ShiftId])(implicit c: Connection): Map[ShiftId, ShiftRow] = {
    val byId = selectByIds(shiftids).view.map(x => (x.shiftid, x)).toMap
    shiftids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  def update: UpdateBuilder[ShiftFields, ShiftRow] = UpdateBuilder("humanresources.shift", ShiftFields.structure, ShiftRow.rowParser)
  def update(row: ShiftRow)(implicit c: Connection): Boolean = {
    val shiftid = row.shiftid
    SQL"""update humanresources.shift
                          set "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
                              "starttime" = ${ParameterValue(row.starttime, null, TypoLocalTime.toStatement)}::time,
                              "endtime" = ${ParameterValue(row.endtime, null, TypoLocalTime.toStatement)}::time,
                              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
                          where "shiftid" = ${ParameterValue(shiftid, null, ShiftId.toStatement)}
                       """.executeUpdate() > 0
  }
  def upsert(unsaved: ShiftRow)(implicit c: Connection): ShiftRow = {
    SQL"""insert into humanresources.shift("shiftid", "name", "starttime", "endtime", "modifieddate")
           values (
             ${ParameterValue(unsaved.shiftid, null, ShiftId.toStatement)}::int4,
             ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
             ${ParameterValue(unsaved.starttime, null, TypoLocalTime.toStatement)}::time,
             ${ParameterValue(unsaved.endtime, null, TypoLocalTime.toStatement)}::time,
             ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
           )
           on conflict ("shiftid")
           do update set
             "name" = EXCLUDED."name",
             "starttime" = EXCLUDED."starttime",
             "endtime" = EXCLUDED."endtime",
             "modifieddate" = EXCLUDED."modifieddate"
           returning "shiftid", "name", "starttime"::text, "endtime"::text, "modifieddate"::text
        """
      .executeInsert(ShiftRow.rowParser(1).single)
  
  }
  def upsertBatch(unsaved: Iterable[ShiftRow])(implicit c: Connection): List[ShiftRow] = {
    def toNamedParameter(row: ShiftRow): List[NamedParameter] = List(
      NamedParameter("shiftid", ParameterValue(row.shiftid, null, ShiftId.toStatement)),
      NamedParameter("name", ParameterValue(row.name, null, Name.toStatement)),
      NamedParameter("starttime", ParameterValue(row.starttime, null, TypoLocalTime.toStatement)),
      NamedParameter("endtime", ParameterValue(row.endtime, null, TypoLocalTime.toStatement)),
      NamedParameter("modifieddate", ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into humanresources.shift("shiftid", "name", "starttime", "endtime", "modifieddate")
                values ({shiftid}::int4, {name}::varchar, {starttime}::time, {endtime}::time, {modifieddate}::timestamp)
                on conflict ("shiftid")
                do update set
                  "name" = EXCLUDED."name",
                  "starttime" = EXCLUDED."starttime",
                  "endtime" = EXCLUDED."endtime",
                  "modifieddate" = EXCLUDED."modifieddate"
                returning "shiftid", "name", "starttime"::text, "endtime"::text, "modifieddate"::text
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(ShiftRow.rowParser(1).*)
    }
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Iterator[ShiftRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"create temporary table shift_TEMP (like humanresources.shift) on commit drop".execute(): @nowarn
    streamingInsert(s"""copy shift_TEMP("shiftid", "name", "starttime", "endtime", "modifieddate") from stdin""", batchSize, unsaved)(ShiftRow.text, c): @nowarn
    SQL"""insert into humanresources.shift("shiftid", "name", "starttime", "endtime", "modifieddate")
          select * from shift_TEMP
          on conflict ("shiftid")
          do update set
            "name" = EXCLUDED."name",
            "starttime" = EXCLUDED."starttime",
            "endtime" = EXCLUDED."endtime",
            "modifieddate" = EXCLUDED."modifieddate"
          ;
          drop table shift_TEMP;""".executeUpdate()
  }
}