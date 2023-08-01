/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import adventureworks.TypoLocalDateTime
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class ContacttypeStructure[Row](val prefix: Option[String], val extract: Row => ContacttypeRow, val merge: (Row, ContacttypeRow) => Row)
  extends Relation[ContacttypeFields, ContacttypeRow, Row]
    with ContacttypeFields[Row] { outer =>

  override val contacttypeid = new IdField[ContacttypeId, Row](prefix, "contacttypeid", None, Some("int4"))(x => extract(x).contacttypeid, (row, value) => merge(row, extract(row).copy(contacttypeid = value)))
  override val name = new Field[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](contacttypeid, name, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => ContacttypeRow, merge: (NewRow, ContacttypeRow) => NewRow): ContacttypeStructure[NewRow] =
    new ContacttypeStructure(prefix, extract, merge)
}
