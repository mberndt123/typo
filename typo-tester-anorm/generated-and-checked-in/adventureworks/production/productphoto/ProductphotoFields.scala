/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productphoto

import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait ProductphotoFields {
  def productphotoid: IdField[ProductphotoId, ProductphotoRow]
  def thumbnailphoto: OptField[TypoBytea, ProductphotoRow]
  def thumbnailphotofilename: OptField[/* max 50 chars */ String, ProductphotoRow]
  def largephoto: OptField[TypoBytea, ProductphotoRow]
  def largephotofilename: OptField[/* max 50 chars */ String, ProductphotoRow]
  def modifieddate: Field[TypoLocalDateTime, ProductphotoRow]
}

object ProductphotoFields {
  lazy val structure: Relation[ProductphotoFields, ProductphotoRow] =
    new Impl(Nil)

  private final class Impl(val _path: List[Path])
    extends Relation[ProductphotoFields, ProductphotoRow] {
  
    override lazy val fields: ProductphotoFields = new ProductphotoFields {
      override def productphotoid = IdField[ProductphotoId, ProductphotoRow](_path, "productphotoid", None, Some("int4"), x => x.productphotoid, (row, value) => row.copy(productphotoid = value))
      override def thumbnailphoto = OptField[TypoBytea, ProductphotoRow](_path, "thumbnailphoto", None, Some("bytea"), x => x.thumbnailphoto, (row, value) => row.copy(thumbnailphoto = value))
      override def thumbnailphotofilename = OptField[/* max 50 chars */ String, ProductphotoRow](_path, "thumbnailphotofilename", None, None, x => x.thumbnailphotofilename, (row, value) => row.copy(thumbnailphotofilename = value))
      override def largephoto = OptField[TypoBytea, ProductphotoRow](_path, "largephoto", None, Some("bytea"), x => x.largephoto, (row, value) => row.copy(largephoto = value))
      override def largephotofilename = OptField[/* max 50 chars */ String, ProductphotoRow](_path, "largephotofilename", None, None, x => x.largephotofilename, (row, value) => row.copy(largephotofilename = value))
      override def modifieddate = Field[TypoLocalDateTime, ProductphotoRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, ProductphotoRow]] =
      List[FieldLikeNoHkt[?, ProductphotoRow]](fields.productphotoid, fields.thumbnailphoto, fields.thumbnailphotofilename, fields.largephoto, fields.largephotofilename, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
