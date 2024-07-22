/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded.myschema

import anorm.Column
import anorm.ParameterMetaData
import anorm.SqlMappingError
import anorm.ToStatement
import java.sql.Types
import play.api.libs.json.JsError
import play.api.libs.json.JsSuccess
import play.api.libs.json.JsValue
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import testdb.hardcoded.Text

/** Enum `myschema.number`
  *  - one
  *  - two
  *  - three
  */
sealed abstract class Number(val value: String)

object Number {
  def apply(str: String): Either[String, Number] =
    ByName.get(str).toRight(s"'$str' does not match any of the following legal values: $Names")
  def force(str: String): Number =
    apply(str) match {
      case Left(msg) => sys.error(msg)
      case Right(value) => value
    }
  case object `_one` extends Number("one")
  case object `_two` extends Number("two")
  case object `_three` extends Number("three")
  val All: List[Number] = List(`_one`, `_two`, `_three`)
  val Names: String = All.map(_.value).mkString(", ")
  val ByName: Map[String, Number] = All.map(x => (x.value, x)).toMap
              
  implicit lazy val arrayColumn: Column[Array[Number]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[Number]] = ToStatement[Array[Number]]((ps, i, arr) => ps.setArray(i, ps.getConnection.createArrayOf("myschema.number", arr.map[AnyRef](_.value))))
  implicit lazy val column: Column[Number] = Column.columnToString.mapResult(str => Number(str).left.map(SqlMappingError.apply))
  implicit lazy val parameterMetadata: ParameterMetaData[Number] = new ParameterMetaData[Number] {
    override def sqlType: String = "myschema.number"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[Number] = Reads[Number]{(value: JsValue) => value.validate(Reads.StringReads).flatMap(str => Number(str).fold(JsError.apply, JsSuccess(_)))}
  implicit lazy val text: Text[Number] = new Text[Number] {
    override def unsafeEncode(v: Number, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: Number, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[Number] = ToStatement.stringToStatement.contramap(_.value)
  implicit lazy val writes: Writes[Number] = Writes[Number](value => Writes.StringWrites.writes(value.value))
}
