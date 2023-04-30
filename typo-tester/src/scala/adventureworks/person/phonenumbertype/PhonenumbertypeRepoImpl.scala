/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

import adventureworks.Defaulted
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToStatement
import java.lang.Integer
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object PhonenumbertypeRepoImpl extends PhonenumbertypeRepo {
  override def delete(phonenumbertypeid: PhonenumbertypeId)(implicit c: Connection): Boolean = {
    SQL"delete from person.phonenumbertype where phonenumbertypeid = $phonenumbertypeid".executeUpdate() > 0
  }
  override def insert(unsaved: PhonenumbertypeRow)(implicit c: Connection): PhonenumbertypeRow = {
    SQL"""insert into person.phonenumbertype(phonenumbertypeid, "name", modifieddate)
          values (${unsaved.phonenumbertypeid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.modifieddate}::timestamp)
          returning phonenumbertypeid, "name", modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  override def insert(unsaved: PhonenumbertypeRowUnsaved)(implicit c: Connection): PhonenumbertypeRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.phonenumbertypeid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("phonenumbertypeid", ParameterValue.from[PhonenumbertypeId](value)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into person.phonenumbertype default values
            returning phonenumbertypeid, "name", modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into person.phonenumbertype(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning phonenumbertypeid, "name", modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[PhonenumbertypeRow] = {
    SQL"""select phonenumbertypeid, "name", modifieddate
          from person.phonenumbertype
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PhonenumbertypeFieldOrIdValue[_]])(implicit c: Connection): List[PhonenumbertypeRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PhonenumbertypeFieldValue.phonenumbertypeid(value) => NamedParameter("phonenumbertypeid", ParameterValue.from(value))
          case PhonenumbertypeFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PhonenumbertypeFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select phonenumbertypeid, "name", modifieddate
                    from person.phonenumbertype
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(phonenumbertypeid: PhonenumbertypeId)(implicit c: Connection): Option[PhonenumbertypeRow] = {
    SQL"""select phonenumbertypeid, "name", modifieddate
          from person.phonenumbertype
          where phonenumbertypeid = $phonenumbertypeid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(phonenumbertypeids: Array[PhonenumbertypeId])(implicit c: Connection): List[PhonenumbertypeRow] = {
    implicit val toStatement: ToStatement[Array[PhonenumbertypeId]] =
      (s: PreparedStatement, index: Int, v: Array[PhonenumbertypeId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select phonenumbertypeid, "name", modifieddate
          from person.phonenumbertype
          where phonenumbertypeid = ANY($phonenumbertypeids)
       """.as(rowParser.*)
  
  }
  override def update(row: PhonenumbertypeRow)(implicit c: Connection): Boolean = {
    val phonenumbertypeid = row.phonenumbertypeid
    SQL"""update person.phonenumbertype
          set "name" = ${row.name}::"public"."Name",
              modifieddate = ${row.modifieddate}::timestamp
          where phonenumbertypeid = $phonenumbertypeid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(phonenumbertypeid: PhonenumbertypeId, fieldValues: List[PhonenumbertypeFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PhonenumbertypeFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PhonenumbertypeFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update person.phonenumbertype
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where phonenumbertypeid = {phonenumbertypeid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("phonenumbertypeid", ParameterValue.from(phonenumbertypeid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: PhonenumbertypeRow)(implicit c: Connection): PhonenumbertypeRow = {
    SQL"""insert into person.phonenumbertype(phonenumbertypeid, "name", modifieddate)
          values (
            ${unsaved.phonenumbertypeid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (phonenumbertypeid)
          do update set
            "name" = EXCLUDED."name",
            modifieddate = EXCLUDED.modifieddate
          returning phonenumbertypeid, "name", modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  val rowParser: RowParser[PhonenumbertypeRow] =
    RowParser[PhonenumbertypeRow] { row =>
      Success(
        PhonenumbertypeRow(
          phonenumbertypeid = row[PhonenumbertypeId]("phonenumbertypeid"),
          name = row[Name]("name"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
