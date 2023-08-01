/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package l

import adventureworks.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.public.Name
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class LViewStructure[Row](val prefix: Option[String], val extract: Row => LViewRow, val merge: (Row, LViewRow) => Row)
  extends Relation[LViewFields, LViewRow, Row]
    with LViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val locationid = new OptField[LocationId, Row](prefix, "locationid", None, Some("int4"))(x => extract(x).locationid, (row, value) => merge(row, extract(row).copy(locationid = value)))
  override val name = new OptField[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val costrate = new OptField[BigDecimal, Row](prefix, "costrate", None, Some("numeric"))(x => extract(x).costrate, (row, value) => merge(row, extract(row).copy(costrate = value)))
  override val availability = new OptField[BigDecimal, Row](prefix, "availability", None, Some("numeric"))(x => extract(x).availability, (row, value) => merge(row, extract(row).copy(availability = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, locationid, name, costrate, availability, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => LViewRow, merge: (NewRow, LViewRow) => NewRow): LViewStructure[NewRow] =
    new LViewStructure(prefix, extract, merge)
}
