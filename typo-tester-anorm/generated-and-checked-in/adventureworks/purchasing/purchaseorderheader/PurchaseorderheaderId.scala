/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.purchaseorderheader

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `purchasing.purchaseorderheader` */
case class PurchaseorderheaderId(value: Int) extends AnyVal
object PurchaseorderheaderId {
  implicit lazy val arrayColumn: Column[Array[PurchaseorderheaderId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PurchaseorderheaderId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PurchaseorderheaderId, Int] = Bijection[PurchaseorderheaderId, Int](_.value)(PurchaseorderheaderId.apply)
  implicit lazy val column: Column[PurchaseorderheaderId] = Column.columnToInt.map(PurchaseorderheaderId.apply)
  implicit lazy val ordering: Ordering[PurchaseorderheaderId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PurchaseorderheaderId] = new ParameterMetaData[PurchaseorderheaderId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[PurchaseorderheaderId] = Reads.IntReads.map(PurchaseorderheaderId.apply)
  implicit lazy val text: Text[PurchaseorderheaderId] = new Text[PurchaseorderheaderId] {
    override def unsafeEncode(v: PurchaseorderheaderId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: PurchaseorderheaderId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[PurchaseorderheaderId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[PurchaseorderheaderId] = Writes.IntWrites.contramap(_.value)
}
