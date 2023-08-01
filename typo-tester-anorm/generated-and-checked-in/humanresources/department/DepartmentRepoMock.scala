/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class DepartmentRepoMock(toRow: Function1[DepartmentRowUnsaved, DepartmentRow],
                         map: scala.collection.mutable.Map[DepartmentId, DepartmentRow] = scala.collection.mutable.Map.empty) extends DepartmentRepo {
  override def delete(departmentid: DepartmentId)(implicit c: Connection): Boolean = {
    map.remove(departmentid).isDefined
  }
  override def delete: DeleteBuilder[DepartmentFields, DepartmentRow] = {
    DeleteBuilderMock(DeleteParams.empty, DepartmentFields, map)
  }
  override def insert(unsaved: DepartmentRow)(implicit c: Connection): DepartmentRow = {
    if (map.contains(unsaved.departmentid))
      sys.error(s"id ${unsaved.departmentid} already exists")
    else
      map.put(unsaved.departmentid, unsaved)
    unsaved
  }
  override def insert(unsaved: DepartmentRowUnsaved)(implicit c: Connection): DepartmentRow = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[DepartmentFields, DepartmentRow] = {
    SelectBuilderMock(DepartmentFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[DepartmentRow] = {
    map.values.toList
  }
  override def selectById(departmentid: DepartmentId)(implicit c: Connection): Option[DepartmentRow] = {
    map.get(departmentid)
  }
  override def selectByIds(departmentids: Array[DepartmentId])(implicit c: Connection): List[DepartmentRow] = {
    departmentids.flatMap(map.get).toList
  }
  override def update(row: DepartmentRow)(implicit c: Connection): Boolean = {
    map.get(row.departmentid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.departmentid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[DepartmentFields, DepartmentRow] = {
    UpdateBuilderMock(UpdateParams.empty, DepartmentFields, map)
  }
  override def upsert(unsaved: DepartmentRow)(implicit c: Connection): DepartmentRow = {
    map.put(unsaved.departmentid, unsaved)
    unsaved
  }
}
