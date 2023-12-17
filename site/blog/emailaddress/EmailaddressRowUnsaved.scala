/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId

/** This class corresponds to a row in table `person.emailaddress` which has not been persisted yet */
case class EmailaddressRowUnsaved(
  /** Primary key. Person associated with this email address.  Foreign key to Person.BusinessEntityID
    * Points to [[person.PersonRow.businessentityid]]
    */
  businessentityid: BusinessentityId,
  /** E-mail address for the person. */
  emailaddress: Option[/* max 50 chars */ String],
  /** Default: nextval('person.emailaddress_emailaddressid_seq'::regclass)
    * Primary key. ID of this email address.
    */
  emailaddressid: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(emailaddressidDefault: => Int, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): EmailaddressRow =
    EmailaddressRow(
      businessentityid = businessentityid,
      emailaddress = emailaddress,
      emailaddressid = emailaddressid match {
                         case Defaulted.UseDefault => emailaddressidDefault
                         case Defaulted.Provided(value) => value
                       },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}