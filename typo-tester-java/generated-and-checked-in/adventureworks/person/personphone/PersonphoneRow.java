/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.personphone;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.person.phonenumbertype.PhonenumbertypeId;
import adventureworks.public_.Phone;

/** Table: person.personphone
  * Telephone number and type of a person.
  * Composite primary key: businessentityid, phonenumber, phonenumbertypeid
  */
public record PersonphoneRow(
  /** Business entity identification number. Foreign key to Person.BusinessEntityID.
    * Points to {@link adventureworks.person.person.PersonRow.businessentityid}
    */
  BusinessentityId businessentityid,
  /** Telephone number identification number. */
  Phone phonenumber,
  /** Kind of phone number. Foreign key to PhoneNumberType.PhoneNumberTypeID.
    * Points to {@link adventureworks.person.phonenumbertype.PhonenumbertypeRow.phonenumbertypeid}
    */
  PhonenumbertypeId phonenumbertypeid,
  /** Default: now() */
  TypoLocalDateTime modifieddate
) {
  static public PersonphoneRow apply(PersonphoneId compositeId, TypoLocalDateTime modifieddate) {
           return new PersonphoneRow(compositeId.businessentityid(), compositeId.phonenumber(), compositeId.phonenumbertypeid(), modifieddate);
         };
  public PersonphoneId compositeId() {
    return new PersonphoneId(businessentityid, phonenumber, phonenumbertypeid);
  };
  public PersonphoneId id() {
    return compositeId();
  };
  public PersonphoneRowUnsaved toUnsavedRow(Defaulted<TypoLocalDateTime> modifieddate) {
    return new PersonphoneRowUnsaved(businessentityid, phonenumber, phonenumbertypeid, modifieddate);
  };
}