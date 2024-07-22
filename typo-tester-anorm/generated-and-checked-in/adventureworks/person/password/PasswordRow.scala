/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.password;

import adventureworks.Text;
import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.person.businessentity.BusinessentityId;
import anorm.Column;
import anorm.RowParser;
import anorm.Success;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import play.api.libs.json.Writes;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** Table: person.password
  * One way hashed authentication information
  * Primary key: businessentityid
  */
case class PasswordRow(
  /** Points to [[adventureworks.person.person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Password for the e-mail account. */
  passwordhash: /* max 128 chars */ String,
  /** Random value concatenated with the password string before the password is hashed. */
  passwordsalt: /* max 10 chars */ String,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
) {
  def id: BusinessentityId = businessentityid
  def toUnsavedRow(rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): PasswordRowUnsaved = {
    new PasswordRowUnsaved(
      businessentityid,
      passwordhash,
      passwordsalt,
      rowguid,
      modifieddate
    )
  }
}

object PasswordRow {
  implicit lazy val reads: Reads[PasswordRow] = {
    Reads[PasswordRow](json => JsResult.fromTry(
        Try(
          PasswordRow(
            businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
            passwordhash = json.\("passwordhash").as(Reads.StringReads),
            passwordsalt = json.\("passwordsalt").as(Reads.StringReads),
            rowguid = json.\("rowguid").as(TypoUUID.reads),
            modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
          )
        )
      ),
    )
  }
  def rowParser(idx: Int): RowParser[PasswordRow] = {
    RowParser[PasswordRow] { row =>
      Success(
        PasswordRow(
          businessentityid = row(idx + 0)(BusinessentityId.column),
          passwordhash = row(idx + 1)(Column.columnToString),
          passwordsalt = row(idx + 2)(Column.columnToString),
          rowguid = row(idx + 3)(TypoUUID.column),
          modifieddate = row(idx + 4)(TypoLocalDateTime.column)
        )
      )
    }
  }
  implicit lazy val text: Text[PasswordRow] = {
    Text.instance[PasswordRow]{ (row, sb) =>
      BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.passwordhash, sb)
      sb.append(Text.DELIMETER)
      Text.stringInstance.unsafeEncode(row.passwordsalt, sb)
      sb.append(Text.DELIMETER)
      TypoUUID.text.unsafeEncode(row.rowguid, sb)
      sb.append(Text.DELIMETER)
      TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    }
  }
  implicit lazy val writes: OWrites[PasswordRow] = {
    OWrites[PasswordRow](o =>
      new JsObject(ListMap[String, JsValue](
        "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
        "passwordhash" -> Writes.StringWrites.writes(o.passwordhash),
        "passwordsalt" -> Writes.StringWrites.writes(o.passwordsalt),
        "rowguid" -> TypoUUID.writes.writes(o.rowguid),
        "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
      ))
    )
  }
}