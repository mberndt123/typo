/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.transactionhistory;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.production.product.ProductFields;
import adventureworks.production.product.ProductId;
import adventureworks.production.product.ProductRow;
import typo.dsl.ForeignKey;
import typo.dsl.Path;
import typo.dsl.SqlExpr.Field;
import typo.dsl.SqlExpr.FieldLike;
import typo.dsl.SqlExpr.IdField;
import typo.dsl.Structure.Relation;

trait TransactionhistoryFields {
  def transactionid: IdField[TransactionhistoryId, TransactionhistoryRow]
  def productid: Field[ProductId, TransactionhistoryRow]
  def referenceorderid: Field[Int, TransactionhistoryRow]
  def referenceorderlineid: Field[Int, TransactionhistoryRow]
  def transactiondate: Field[TypoLocalDateTime, TransactionhistoryRow]
  def transactiontype: Field[/* bpchar, max 1 chars */ String, TransactionhistoryRow]
  def quantity: Field[Int, TransactionhistoryRow]
  def actualcost: Field[BigDecimal, TransactionhistoryRow]
  def modifieddate: Field[TypoLocalDateTime, TransactionhistoryRow]
  def fkProduct: ForeignKey[ProductFields, ProductRow] =
    ForeignKey[ProductFields, ProductRow]("production.FK_TransactionHistory_Product_ProductID", Nil)
      .withColumnPair(productid, _.productid)
}

object TransactionhistoryFields {
  lazy val structure: Relation[TransactionhistoryFields, TransactionhistoryRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[TransactionhistoryFields, TransactionhistoryRow] {
  
    override lazy val fields: TransactionhistoryFields = new TransactionhistoryFields {
      override def transactionid = IdField[TransactionhistoryId, TransactionhistoryRow](_path, "transactionid", None, Some("int4"), x => x.transactionid, (row, value) => row.copy(transactionid = value))
      override def productid = Field[ProductId, TransactionhistoryRow](_path, "productid", None, Some("int4"), x => x.productid, (row, value) => row.copy(productid = value))
      override def referenceorderid = Field[Int, TransactionhistoryRow](_path, "referenceorderid", None, Some("int4"), x => x.referenceorderid, (row, value) => row.copy(referenceorderid = value))
      override def referenceorderlineid = Field[Int, TransactionhistoryRow](_path, "referenceorderlineid", None, Some("int4"), x => x.referenceorderlineid, (row, value) => row.copy(referenceorderlineid = value))
      override def transactiondate = Field[TypoLocalDateTime, TransactionhistoryRow](_path, "transactiondate", Some("text"), Some("timestamp"), x => x.transactiondate, (row, value) => row.copy(transactiondate = value))
      override def transactiontype = Field[/* bpchar, max 1 chars */ String, TransactionhistoryRow](_path, "transactiontype", None, Some("bpchar"), x => x.transactiontype, (row, value) => row.copy(transactiontype = value))
      override def quantity = Field[Int, TransactionhistoryRow](_path, "quantity", None, Some("int4"), x => x.quantity, (row, value) => row.copy(quantity = value))
      override def actualcost = Field[BigDecimal, TransactionhistoryRow](_path, "actualcost", None, Some("numeric"), x => x.actualcost, (row, value) => row.copy(actualcost = value))
      override def modifieddate = Field[TypoLocalDateTime, TransactionhistoryRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, TransactionhistoryRow]] =
      List[FieldLike[?, TransactionhistoryRow]](fields.transactionid, fields.productid, fields.referenceorderid, fields.referenceorderlineid, fields.transactiondate, fields.transactiontype, fields.quantity, fields.actualcost, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
