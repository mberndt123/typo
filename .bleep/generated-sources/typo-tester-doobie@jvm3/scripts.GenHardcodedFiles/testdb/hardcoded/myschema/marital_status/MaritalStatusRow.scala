/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class MaritalStatusRow(
  id: MaritalStatusId
)

object MaritalStatusRow {
  implicit lazy val decoder: Decoder[MaritalStatusRow] = Decoder.forProduct1[MaritalStatusRow, MaritalStatusId]("id")(MaritalStatusRow.apply)(MaritalStatusId.decoder)
  implicit lazy val encoder: Encoder[MaritalStatusRow] = Encoder.forProduct1[MaritalStatusRow, MaritalStatusId]("id")(x => (x.id))(MaritalStatusId.encoder)
  implicit lazy val read: Read[MaritalStatusRow] = new Read[MaritalStatusRow](
    gets = List(
      (MaritalStatusId.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => MaritalStatusRow(
      id = MaritalStatusId.get.unsafeGetNonNullable(rs, i + 0)
    )
  )
  implicit lazy val text: Text[MaritalStatusRow] = Text.instance[MaritalStatusRow]{ (row, sb) =>
    MaritalStatusId.text.unsafeEncode(row.id, sb)
  }
}
