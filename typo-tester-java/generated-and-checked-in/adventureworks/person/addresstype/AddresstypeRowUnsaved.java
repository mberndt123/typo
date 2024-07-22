/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.addresstype;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoUUID;
import adventureworks.public_.Name;

/** This class corresponds to a row in table `person.addresstype` which has not been persisted yet */
public record AddresstypeRowUnsaved(
  /** Address type description. For example, Billing, Home, or Shipping. */
  Name name,
  /** Default: nextval('person.addresstype_addresstypeid_seq'::regclass)
    * Primary key for AddressType records.
    */
  Defaulted<AddresstypeId> addresstypeid,
  /** Default: uuid_generate_v1() */
  Defaulted<TypoUUID> rowguid,
  /** Default: now() */
  Defaulted<TypoLocalDateTime> modifieddate
) {
  public AddresstypeRow toRow(
                               java.util.function.Supplier<AddresstypeId> addresstypeidDefault,
                               java.util.function.Supplier<TypoUUID> rowguidDefault,
                               java.util.function.Supplier<TypoLocalDateTime> modifieddateDefault
                             ) {
    return new AddresstypeRow(addresstypeid.getOrElse(addresstypeidDefault), name, rowguid.getOrElse(rowguidDefault), modifieddate.getOrElse(modifieddateDefault));
  };
}