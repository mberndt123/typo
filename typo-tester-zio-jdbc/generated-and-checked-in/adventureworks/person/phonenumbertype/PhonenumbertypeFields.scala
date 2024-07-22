/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.phonenumbertype;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.public.Name;
import typo.dsl.Path;
import typo.dsl.SqlExpr.Field;
import typo.dsl.SqlExpr.FieldLike;
import typo.dsl.SqlExpr.IdField;
import typo.dsl.Structure.Relation;

trait PhonenumbertypeFields {
  def phonenumbertypeid: IdField[PhonenumbertypeId, PhonenumbertypeRow]
  def name: Field[Name, PhonenumbertypeRow]
  def modifieddate: Field[TypoLocalDateTime, PhonenumbertypeRow]
}

object PhonenumbertypeFields {
  lazy val structure: Relation[PhonenumbertypeFields, PhonenumbertypeRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[PhonenumbertypeFields, PhonenumbertypeRow] {
  
    override lazy val fields: PhonenumbertypeFields = new PhonenumbertypeFields {
      override def phonenumbertypeid = IdField[PhonenumbertypeId, PhonenumbertypeRow](_path, "phonenumbertypeid", None, Some("int4"), x => x.phonenumbertypeid, (row, value) => row.copy(phonenumbertypeid = value))
      override def name = Field[Name, PhonenumbertypeRow](_path, "name", None, Some("varchar"), x => x.name, (row, value) => row.copy(name = value))
      override def modifieddate = Field[TypoLocalDateTime, PhonenumbertypeRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, PhonenumbertypeRow]] =
      List[FieldLike[?, PhonenumbertypeRow]](fields.phonenumbertypeid, fields.name, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
