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
import adventureworks.streamingInsert
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class PhonenumbertypeRepoImpl extends PhonenumbertypeRepo {
  override def delete(phonenumbertypeid: PhonenumbertypeId)(implicit c: Connection): Boolean = {
    SQL"""delete from person.phonenumbertype where "phonenumbertypeid" = ${ParameterValue(phonenumbertypeid, null, PhonenumbertypeId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[PhonenumbertypeFields, PhonenumbertypeRow] = {
    DeleteBuilder("person.phonenumbertype", PhonenumbertypeFields)
  }
  override def insert(unsaved: PhonenumbertypeRow)(implicit c: Connection): PhonenumbertypeRow = {
    SQL"""insert into person.phonenumbertype("phonenumbertypeid", "name", "modifieddate")
          values (${ParameterValue(unsaved.phonenumbertypeid, null, PhonenumbertypeId.toStatement)}::int4, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "phonenumbertypeid", "name", "modifieddate"::text
       """
      .executeInsert(PhonenumbertypeRow.rowParser(1).single)
    
  }
  override def insertStreaming(unsaved: Iterator[PhonenumbertypeRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY person.phonenumbertype("phonenumbertypeid", "name", "modifieddate") FROM STDIN""", batchSize, unsaved)(PhonenumbertypeRow.text, c)
  }
  override def insert(unsaved: PhonenumbertypeRowUnsaved)(implicit c: Connection): PhonenumbertypeRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      unsaved.phonenumbertypeid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("phonenumbertypeid", ParameterValue(value, null, PhonenumbertypeId.toStatement)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into person.phonenumbertype default values
            returning "phonenumbertypeid", "name", "modifieddate"::text
         """
        .executeInsert(PhonenumbertypeRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.phonenumbertype(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "phonenumbertypeid", "name", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(PhonenumbertypeRow.rowParser(1).single)
    }
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[PhonenumbertypeRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY person.phonenumbertype("name", "phonenumbertypeid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(PhonenumbertypeRowUnsaved.text, c)
  }
  override def select: SelectBuilder[PhonenumbertypeFields, PhonenumbertypeRow] = {
    SelectBuilderSql("person.phonenumbertype", PhonenumbertypeFields, PhonenumbertypeRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PhonenumbertypeRow] = {
    SQL"""select "phonenumbertypeid", "name", "modifieddate"::text
          from person.phonenumbertype
       """.as(PhonenumbertypeRow.rowParser(1).*)
  }
  override def selectById(phonenumbertypeid: PhonenumbertypeId)(implicit c: Connection): Option[PhonenumbertypeRow] = {
    SQL"""select "phonenumbertypeid", "name", "modifieddate"::text
          from person.phonenumbertype
          where "phonenumbertypeid" = ${ParameterValue(phonenumbertypeid, null, PhonenumbertypeId.toStatement)}
       """.as(PhonenumbertypeRow.rowParser(1).singleOpt)
  }
  override def selectByIds(phonenumbertypeids: Array[PhonenumbertypeId])(implicit c: Connection): List[PhonenumbertypeRow] = {
    SQL"""select "phonenumbertypeid", "name", "modifieddate"::text
          from person.phonenumbertype
          where "phonenumbertypeid" = ANY(${phonenumbertypeids})
       """.as(PhonenumbertypeRow.rowParser(1).*)
    
  }
  override def update(row: PhonenumbertypeRow)(implicit c: Connection): Boolean = {
    val phonenumbertypeid = row.phonenumbertypeid
    SQL"""update person.phonenumbertype
          set "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "phonenumbertypeid" = ${ParameterValue(phonenumbertypeid, null, PhonenumbertypeId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PhonenumbertypeFields, PhonenumbertypeRow] = {
    UpdateBuilder("person.phonenumbertype", PhonenumbertypeFields, PhonenumbertypeRow.rowParser)
  }
  override def upsert(unsaved: PhonenumbertypeRow)(implicit c: Connection): PhonenumbertypeRow = {
    SQL"""insert into person.phonenumbertype("phonenumbertypeid", "name", "modifieddate")
          values (
            ${ParameterValue(unsaved.phonenumbertypeid, null, PhonenumbertypeId.toStatement)}::int4,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("phonenumbertypeid")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "phonenumbertypeid", "name", "modifieddate"::text
       """
      .executeInsert(PhonenumbertypeRow.rowParser(1).single)
    
  }
}
