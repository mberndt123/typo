/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.userdefined.CustomCreditcardId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class CreditcardRow(
  /** Primary key for CreditCard records. */
  creditcardid: /* user-picked */ CustomCreditcardId,
  /** Credit card name. */
  cardtype: /* max 50 chars */ String,
  /** Credit card number. */
  cardnumber: /* max 25 chars */ String,
  /** Credit card expiration month. */
  expmonth: TypoShort,
  /** Credit card expiration year. */
  expyear: TypoShort,
  modifieddate: TypoLocalDateTime
)

object CreditcardRow {
  implicit lazy val reads: Reads[CreditcardRow] = Reads[CreditcardRow](json => JsResult.fromTry(
      Try(
        CreditcardRow(
          creditcardid = json.\("creditcardid").as(CustomCreditcardId.reads),
          cardtype = json.\("cardtype").as(Reads.StringReads),
          cardnumber = json.\("cardnumber").as(Reads.StringReads),
          expmonth = json.\("expmonth").as(TypoShort.reads),
          expyear = json.\("expyear").as(TypoShort.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CreditcardRow] = RowParser[CreditcardRow] { row =>
    Success(
      CreditcardRow(
        creditcardid = row(idx + 0)(/* user-picked */ CustomCreditcardId.column),
        cardtype = row(idx + 1)(Column.columnToString),
        cardnumber = row(idx + 2)(Column.columnToString),
        expmonth = row(idx + 3)(TypoShort.column),
        expyear = row(idx + 4)(TypoShort.column),
        modifieddate = row(idx + 5)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[CreditcardRow] = Text.instance[CreditcardRow]{ (row, sb) =>
    /* user-picked */ CustomCreditcardId.text.unsafeEncode(row.creditcardid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.cardtype, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.cardnumber, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.expmonth, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.expyear, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[CreditcardRow] = OWrites[CreditcardRow](o =>
    new JsObject(ListMap[String, JsValue](
      "creditcardid" -> CustomCreditcardId.writes.writes(o.creditcardid),
      "cardtype" -> Writes.StringWrites.writes(o.cardtype),
      "cardnumber" -> Writes.StringWrites.writes(o.cardnumber),
      "expmonth" -> TypoShort.writes.writes(o.expmonth),
      "expyear" -> TypoShort.writes.writes(o.expyear),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
