/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.pr.pdoc;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.production.document.DocumentId;
import adventureworks.production.product.ProductId;
import typo.dsl.Path;
import typo.dsl.SqlExpr.Field;
import typo.dsl.SqlExpr.FieldLike;
import typo.dsl.Structure.Relation;

trait PdocViewFields {
  def id: Field[ProductId, PdocViewRow]
  def productid: Field[ProductId, PdocViewRow]
  def modifieddate: Field[TypoLocalDateTime, PdocViewRow]
  def documentnode: Field[DocumentId, PdocViewRow]
}

object PdocViewFields {
  lazy val structure: Relation[PdocViewFields, PdocViewRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[PdocViewFields, PdocViewRow] {
  
    override lazy val fields: PdocViewFields = new PdocViewFields {
      override def id = Field[ProductId, PdocViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def productid = Field[ProductId, PdocViewRow](_path, "productid", None, None, x => x.productid, (row, value) => row.copy(productid = value))
      override def modifieddate = Field[TypoLocalDateTime, PdocViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
      override def documentnode = Field[DocumentId, PdocViewRow](_path, "documentnode", None, None, x => x.documentnode, (row, value) => row.copy(documentnode = value))
    }
  
    override lazy val columns: List[FieldLike[?, PdocViewRow]] =
      List[FieldLike[?, PdocViewRow]](fields.id, fields.productid, fields.modifieddate, fields.documentnode)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
