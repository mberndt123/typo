/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import java.sql.Connection
import scala.Function1

class ProductphotoRepoMock(toRow: Function1[ProductphotoRowUnsaved, ProductphotoRow],
                           map: scala.collection.mutable.Map[ProductphotoId, ProductphotoRow] = scala.collection.mutable.Map.empty) extends ProductphotoRepo {
  override def delete(productphotoid: ProductphotoId)(implicit c: Connection): Boolean = {
    map.remove(productphotoid).isDefined
  }
  override def insert(unsaved: ProductphotoRow)(implicit c: Connection): ProductphotoRow = {
    if (map.contains(unsaved.productphotoid))
      sys.error(s"id ${unsaved.productphotoid} already exists")
    else
      map.put(unsaved.productphotoid, unsaved)
    unsaved
  }
  override def insert(unsaved: ProductphotoRowUnsaved)(implicit c: Connection): ProductphotoRow = {
    insert(toRow(unsaved))
  }
  override def selectAll(implicit c: Connection): List[ProductphotoRow] = {
    map.values.toList
  }
  override def selectByFieldValues(fieldValues: List[ProductphotoFieldOrIdValue[_]])(implicit c: Connection): List[ProductphotoRow] = {
    fieldValues.foldLeft(map.values) {
      case (acc, ProductphotoFieldValue.productphotoid(value)) => acc.filter(_.productphotoid == value)
      case (acc, ProductphotoFieldValue.thumbnailphoto(value)) => acc.filter(_.thumbnailphoto == value)
      case (acc, ProductphotoFieldValue.thumbnailphotofilename(value)) => acc.filter(_.thumbnailphotofilename == value)
      case (acc, ProductphotoFieldValue.largephoto(value)) => acc.filter(_.largephoto == value)
      case (acc, ProductphotoFieldValue.largephotofilename(value)) => acc.filter(_.largephotofilename == value)
      case (acc, ProductphotoFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
    }.toList
  }
  override def selectById(productphotoid: ProductphotoId)(implicit c: Connection): Option[ProductphotoRow] = {
    map.get(productphotoid)
  }
  override def selectByIds(productphotoids: Array[ProductphotoId])(implicit c: Connection): List[ProductphotoRow] = {
    productphotoids.flatMap(map.get).toList
  }
  override def update(row: ProductphotoRow)(implicit c: Connection): Boolean = {
    map.get(row.productphotoid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.productphotoid, row)
        true
      case None => false
    }
  }
  override def updateFieldValues(productphotoid: ProductphotoId, fieldValues: List[ProductphotoFieldValue[_]])(implicit c: Connection): Boolean = {
    map.get(productphotoid) match {
      case Some(oldRow) =>
        val updatedRow = fieldValues.foldLeft(oldRow) {
          case (acc, ProductphotoFieldValue.thumbnailphoto(value)) => acc.copy(thumbnailphoto = value)
          case (acc, ProductphotoFieldValue.thumbnailphotofilename(value)) => acc.copy(thumbnailphotofilename = value)
          case (acc, ProductphotoFieldValue.largephoto(value)) => acc.copy(largephoto = value)
          case (acc, ProductphotoFieldValue.largephotofilename(value)) => acc.copy(largephotofilename = value)
          case (acc, ProductphotoFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
        }
        if (updatedRow != oldRow) {
          map.put(productphotoid, updatedRow)
          true
        } else {
          false
        }
      case None => false
    }
  }
  override def upsert(unsaved: ProductphotoRow)(implicit c: Connection): ProductphotoRow = {
    map.put(unsaved.productphotoid, unsaved)
    unsaved
  }
}
