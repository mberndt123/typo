/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object ScrapreasonRepoImpl extends ScrapreasonRepo {
  override def delete(scrapreasonid: ScrapreasonId)(implicit c: Connection): Boolean = {
    SQL"delete from production.scrapreason where scrapreasonid = $scrapreasonid".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[ScrapreasonFields, ScrapreasonRow] = {
    DeleteBuilder("production.scrapreason", ScrapreasonFields)
  }
  override def insert(unsaved: ScrapreasonRow)(implicit c: Connection): ScrapreasonRow = {
    SQL"""insert into production.scrapreason(scrapreasonid, "name", modifieddate)
          values (${unsaved.scrapreasonid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.modifieddate}::timestamp)
          returning scrapreasonid, "name", modifieddate::text
       """
      .executeInsert(ScrapreasonRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ScrapreasonRowUnsaved)(implicit c: Connection): ScrapreasonRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.scrapreasonid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("scrapreasonid", ParameterValue.from[ScrapreasonId](value)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.scrapreason default values
            returning scrapreasonid, "name", modifieddate::text
         """
        .executeInsert(ScrapreasonRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.scrapreason(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning scrapreasonid, "name", modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(ScrapreasonRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[ScrapreasonFields, ScrapreasonRow] = {
    SelectBuilderSql("production.scrapreason", ScrapreasonFields, ScrapreasonRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ScrapreasonRow] = {
    SQL"""select scrapreasonid, "name", modifieddate::text
          from production.scrapreason
       """.as(ScrapreasonRow.rowParser(1).*)
  }
  override def selectById(scrapreasonid: ScrapreasonId)(implicit c: Connection): Option[ScrapreasonRow] = {
    SQL"""select scrapreasonid, "name", modifieddate::text
          from production.scrapreason
          where scrapreasonid = $scrapreasonid
       """.as(ScrapreasonRow.rowParser(1).singleOpt)
  }
  override def selectByIds(scrapreasonids: Array[ScrapreasonId])(implicit c: Connection): List[ScrapreasonRow] = {
    SQL"""select scrapreasonid, "name", modifieddate::text
          from production.scrapreason
          where scrapreasonid = ANY($scrapreasonids)
       """.as(ScrapreasonRow.rowParser(1).*)
    
  }
  override def update(row: ScrapreasonRow)(implicit c: Connection): Boolean = {
    val scrapreasonid = row.scrapreasonid
    SQL"""update production.scrapreason
          set "name" = ${row.name}::"public"."Name",
              modifieddate = ${row.modifieddate}::timestamp
          where scrapreasonid = $scrapreasonid
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[ScrapreasonFields, ScrapreasonRow] = {
    UpdateBuilder("production.scrapreason", ScrapreasonFields, ScrapreasonRow.rowParser)
  }
  override def upsert(unsaved: ScrapreasonRow)(implicit c: Connection): ScrapreasonRow = {
    SQL"""insert into production.scrapreason(scrapreasonid, "name", modifieddate)
          values (
            ${unsaved.scrapreasonid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (scrapreasonid)
          do update set
            "name" = EXCLUDED."name",
            modifieddate = EXCLUDED.modifieddate
          returning scrapreasonid, "name", modifieddate::text
       """
      .executeInsert(ScrapreasonRow.rowParser(1).single)
    
  }
}
