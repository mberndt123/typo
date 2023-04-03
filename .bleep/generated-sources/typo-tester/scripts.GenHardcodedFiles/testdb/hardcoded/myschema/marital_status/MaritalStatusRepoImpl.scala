/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object MaritalStatusRepoImpl extends MaritalStatusRepo {
  override def delete(id: MaritalStatusId)(implicit c: Connection): Boolean = {
    SQL"""delete from myschema.marital_status where id = $id""".executeUpdate() > 0
  }
  override def insert(id: MaritalStatusId)(implicit c: Connection): Boolean = {
    SQL"""insert into myschema.marital_status(id)
          values (${id})
    """.execute()
  }
  override def selectAll(implicit c: Connection): List[MaritalStatusRow] = {
    SQL"""select id from myschema.marital_status""".as(MaritalStatusRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[MaritalStatusFieldOrIdValue[_]])(implicit c: Connection): List[MaritalStatusRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case MaritalStatusFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
        }
        val q = s"""select * from myschema.marital_status where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(MaritalStatusRow.rowParser("").*)
    }
  
  }
  override def selectById(id: MaritalStatusId)(implicit c: Connection): Option[MaritalStatusRow] = {
    SQL"""select id from myschema.marital_status where id = $id""".as(MaritalStatusRow.rowParser("").singleOpt)
  }
  override def selectByIds(ids: List[MaritalStatusId])(implicit c: Connection): List[MaritalStatusRow] = {
    SQL"""select id from myschema.marital_status where id in $ids""".as(MaritalStatusRow.rowParser("").*)
  }
}
