/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.pr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.productreview.ProductreviewId
import adventureworks.public.Name
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLike
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait PrViewFields {
  def id: Field[ProductreviewId, PrViewRow]
  def productreviewid: Field[ProductreviewId, PrViewRow]
  def productid: Field[ProductId, PrViewRow]
  def reviewername: Field[Name, PrViewRow]
  def reviewdate: Field[TypoLocalDateTime, PrViewRow]
  def emailaddress: Field[/* max 50 chars */ String, PrViewRow]
  def rating: Field[Int, PrViewRow]
  def comments: OptField[/* max 3850 chars */ String, PrViewRow]
  def modifieddate: Field[TypoLocalDateTime, PrViewRow]
}

object PrViewFields {
  lazy val structure: Relation[PrViewFields, PrViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[PrViewFields, PrViewRow] {
  
    override lazy val fields: PrViewFields = new PrViewFields {
      override def id = Field[ProductreviewId, PrViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def productreviewid = Field[ProductreviewId, PrViewRow](_path, "productreviewid", None, None, x => x.productreviewid, (row, value) => row.copy(productreviewid = value))
      override def productid = Field[ProductId, PrViewRow](_path, "productid", None, None, x => x.productid, (row, value) => row.copy(productid = value))
      override def reviewername = Field[Name, PrViewRow](_path, "reviewername", None, None, x => x.reviewername, (row, value) => row.copy(reviewername = value))
      override def reviewdate = Field[TypoLocalDateTime, PrViewRow](_path, "reviewdate", Some("text"), None, x => x.reviewdate, (row, value) => row.copy(reviewdate = value))
      override def emailaddress = Field[/* max 50 chars */ String, PrViewRow](_path, "emailaddress", None, None, x => x.emailaddress, (row, value) => row.copy(emailaddress = value))
      override def rating = Field[Int, PrViewRow](_path, "rating", None, None, x => x.rating, (row, value) => row.copy(rating = value))
      override def comments = OptField[/* max 3850 chars */ String, PrViewRow](_path, "comments", None, None, x => x.comments, (row, value) => row.copy(comments = value))
      override def modifieddate = Field[TypoLocalDateTime, PrViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLike[?, PrViewRow]] =
      List[FieldLike[?, PrViewRow]](fields.id, fields.productreviewid, fields.productid, fields.reviewername, fields.reviewdate, fields.emailaddress, fields.rating, fields.comments, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
