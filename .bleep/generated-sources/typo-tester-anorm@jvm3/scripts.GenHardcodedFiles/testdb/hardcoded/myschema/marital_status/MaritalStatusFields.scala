/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded.myschema.marital_status

import typo.dsl.Path
import typo.dsl.SqlExpr.FieldLike
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait MaritalStatusFields {
  def id: IdField[MaritalStatusId, MaritalStatusRow]
}

object MaritalStatusFields {
  lazy val structure: Relation[MaritalStatusFields, MaritalStatusRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[MaritalStatusFields, MaritalStatusRow] {
  
    override lazy val fields: MaritalStatusFields = new MaritalStatusFields {
      override def id = IdField[MaritalStatusId, MaritalStatusRow](_path, "id", None, Some("int8"), x => x.id, (row, value) => row.copy(id = value))
    }
  
    override lazy val columns: List[FieldLike[?, MaritalStatusRow]] =
      List[FieldLike[?, MaritalStatusRow]](fields.id)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
