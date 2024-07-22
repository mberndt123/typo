/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sa.cc;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoShort;
import adventureworks.userdefined.CustomCreditcardId;
import typo.dsl.Path;
import typo.dsl.SqlExpr.Field;
import typo.dsl.SqlExpr.FieldLike;
import typo.dsl.Structure.Relation;

trait CcViewFields {
  def id: Field[/* user-picked */ CustomCreditcardId, CcViewRow]
  def creditcardid: Field[/* user-picked */ CustomCreditcardId, CcViewRow]
  def cardtype: Field[/* max 50 chars */ String, CcViewRow]
  def cardnumber: Field[/* max 25 chars */ String, CcViewRow]
  def expmonth: Field[TypoShort, CcViewRow]
  def expyear: Field[TypoShort, CcViewRow]
  def modifieddate: Field[TypoLocalDateTime, CcViewRow]
}

object CcViewFields {
  lazy val structure: Relation[CcViewFields, CcViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[CcViewFields, CcViewRow] {
  
    override lazy val fields: CcViewFields = new CcViewFields {
      override def id = Field[/* user-picked */ CustomCreditcardId, CcViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def creditcardid = Field[/* user-picked */ CustomCreditcardId, CcViewRow](_path, "creditcardid", None, None, x => x.creditcardid, (row, value) => row.copy(creditcardid = value))
      override def cardtype = Field[/* max 50 chars */ String, CcViewRow](_path, "cardtype", None, None, x => x.cardtype, (row, value) => row.copy(cardtype = value))
      override def cardnumber = Field[/* max 25 chars */ String, CcViewRow](_path, "cardnumber", None, None, x => x.cardnumber, (row, value) => row.copy(cardnumber = value))
      override def expmonth = Field[TypoShort, CcViewRow](_path, "expmonth", None, None, x => x.expmonth, (row, value) => row.copy(expmonth = value))
      override def expyear = Field[TypoShort, CcViewRow](_path, "expyear", None, None, x => x.expyear, (row, value) => row.copy(expyear = value))
      override def modifieddate = Field[TypoLocalDateTime, CcViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, CcViewRow]] =
      List[FieldLike[?, CcViewRow]](fields.id, fields.creditcardid, fields.cardtype, fields.cardnumber, fields.expmonth, fields.expyear, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
