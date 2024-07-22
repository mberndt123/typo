/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.emailaddress;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.person.person.PersonFields;
import adventureworks.person.person.PersonRow;
import anorm.ParameterMetaData;
import anorm.ToParameterValue;
import typo.dsl.ForeignKey;
import typo.dsl.Path;
import typo.dsl.SqlExpr;
import typo.dsl.SqlExpr.CompositeIn;
import typo.dsl.SqlExpr.CompositeIn.TuplePart;
import typo.dsl.SqlExpr.Const.As.as;
import typo.dsl.SqlExpr.Field;
import typo.dsl.SqlExpr.FieldLike;
import typo.dsl.SqlExpr.IdField;
import typo.dsl.SqlExpr.OptField;
import typo.dsl.Structure.Relation;

trait EmailaddressFields {
  def businessentityid: IdField[BusinessentityId, EmailaddressRow]
  def emailaddressid: IdField[Int, EmailaddressRow]
  def emailaddress: OptField[/* max 50 chars */ String, EmailaddressRow]
  def rowguid: Field[TypoUUID, EmailaddressRow]
  def modifieddate: Field[TypoLocalDateTime, EmailaddressRow]
  def fkPerson: ForeignKey[PersonFields, PersonRow] =
    ForeignKey[PersonFields, PersonRow]("person.FK_EmailAddress_Person_BusinessEntityID", Nil)
      .withColumnPair(businessentityid, _.businessentityid)
  def compositeIdIs(compositeId: EmailaddressId): SqlExpr[Boolean] =
    businessentityid.isEqual(compositeId.businessentityid).and(emailaddressid.isEqual(compositeId.emailaddressid))
  def compositeIdIn(compositeIds: Array[EmailaddressId]): SqlExpr[Boolean] =
    new CompositeIn(compositeIds)(TuplePart[EmailaddressId](businessentityid)(_.businessentityid)(using as[Array[BusinessentityId]](ToParameterValue(null, BusinessentityId.arrayToStatement), adventureworks.arrayParameterMetaData(BusinessentityId.parameterMetadata)), implicitly), TuplePart[EmailaddressId](emailaddressid)(_.emailaddressid)(using as[Array[Int]](ToParameterValue(null, adventureworks.IntArrayToStatement), adventureworks.arrayParameterMetaData(ParameterMetaData.IntParameterMetaData)), implicitly))
  
}

object EmailaddressFields {
  lazy val structure: Relation[EmailaddressFields, EmailaddressRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[EmailaddressFields, EmailaddressRow] {
  
    override lazy val fields: EmailaddressFields = new EmailaddressFields {
      override def businessentityid = IdField[BusinessentityId, EmailaddressRow](_path, "businessentityid", None, Some("int4"), x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def emailaddressid = IdField[Int, EmailaddressRow](_path, "emailaddressid", None, Some("int4"), x => x.emailaddressid, (row, value) => row.copy(emailaddressid = value))
      override def emailaddress = OptField[/* max 50 chars */ String, EmailaddressRow](_path, "emailaddress", None, None, x => x.emailaddress, (row, value) => row.copy(emailaddress = value))
      override def rowguid = Field[TypoUUID, EmailaddressRow](_path, "rowguid", None, Some("uuid"), x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, EmailaddressRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, EmailaddressRow]] =
      List[FieldLike[?, EmailaddressRow]](fields.businessentityid, fields.emailaddressid, fields.emailaddress, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
