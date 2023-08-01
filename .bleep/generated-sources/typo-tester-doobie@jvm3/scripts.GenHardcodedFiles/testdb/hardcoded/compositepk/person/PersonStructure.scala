/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package compositepk
package person

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PersonStructure[Row](val prefix: Option[String], val extract: Row => PersonRow, val merge: (Row, PersonRow) => Row)
  extends Relation[PersonFields, PersonRow, Row]
    with PersonFields[Row] { outer =>

  override val one = new IdField[Long, Row](prefix, "one", None, Some("int8"))(x => extract(x).one, (row, value) => merge(row, extract(row).copy(one = value)))
  override val two = new IdField[Option[String], Row](prefix, "two", None, None)(x => extract(x).two, (row, value) => merge(row, extract(row).copy(two = value)))
  override val name = new OptField[String, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](one, two, name)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PersonRow, merge: (NewRow, PersonRow) => NewRow): PersonStructure[NewRow] =
    new PersonStructure(prefix, extract, merge)
}
