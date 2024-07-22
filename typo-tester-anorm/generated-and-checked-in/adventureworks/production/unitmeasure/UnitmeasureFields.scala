/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.unitmeasure;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.public.Name;
import typo.dsl.Path;
import typo.dsl.SqlExpr.Field;
import typo.dsl.SqlExpr.FieldLike;
import typo.dsl.SqlExpr.IdField;
import typo.dsl.Structure.Relation;

trait UnitmeasureFields {
  def unitmeasurecode: IdField[UnitmeasureId, UnitmeasureRow]
  def name: Field[Name, UnitmeasureRow]
  def modifieddate: Field[TypoLocalDateTime, UnitmeasureRow]
}

object UnitmeasureFields {
  lazy val structure: Relation[UnitmeasureFields, UnitmeasureRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[UnitmeasureFields, UnitmeasureRow] {
  
    override lazy val fields: UnitmeasureFields = new UnitmeasureFields {
      override def unitmeasurecode = IdField[UnitmeasureId, UnitmeasureRow](_path, "unitmeasurecode", None, Some("bpchar"), x => x.unitmeasurecode, (row, value) => row.copy(unitmeasurecode = value))
      override def name = Field[Name, UnitmeasureRow](_path, "name", None, Some("varchar"), x => x.name, (row, value) => row.copy(name = value))
      override def modifieddate = Field[TypoLocalDateTime, UnitmeasureRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, UnitmeasureRow]] =
      List[FieldLike[?, UnitmeasureRow]](fields.unitmeasurecode, fields.name, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
