/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.userdefined.CustomCreditcardId
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `sales.personcreditcard` which has not been persisted yet */
case class PersoncreditcardRowUnsaved(
  /** Business entity identification number. Foreign key to Person.BusinessEntityID.
      Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Credit card identification number. Foreign key to CreditCard.CreditCardID.
      Points to [[creditcard.CreditcardRow.creditcardid]] */
  creditcardid: /* user-picked */ CustomCreditcardId,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): PersoncreditcardRow =
    PersoncreditcardRow(
      businessentityid = businessentityid,
      creditcardid = creditcardid,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object PersoncreditcardRowUnsaved {
  implicit lazy val decoder: Decoder[PersoncreditcardRowUnsaved] = Decoder.forProduct3[PersoncreditcardRowUnsaved, BusinessentityId, /* user-picked */ CustomCreditcardId, Defaulted[TypoLocalDateTime]]("businessentityid", "creditcardid", "modifieddate")(PersoncreditcardRowUnsaved.apply)(BusinessentityId.decoder, CustomCreditcardId.decoder, Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[PersoncreditcardRowUnsaved] = Encoder.forProduct3[PersoncreditcardRowUnsaved, BusinessentityId, /* user-picked */ CustomCreditcardId, Defaulted[TypoLocalDateTime]]("businessentityid", "creditcardid", "modifieddate")(x => (x.businessentityid, x.creditcardid, x.modifieddate))(BusinessentityId.encoder, CustomCreditcardId.encoder, Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[PersoncreditcardRowUnsaved] = Text.instance[PersoncreditcardRowUnsaved]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    /* user-picked */ CustomCreditcardId.text.unsafeEncode(row.creditcardid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
