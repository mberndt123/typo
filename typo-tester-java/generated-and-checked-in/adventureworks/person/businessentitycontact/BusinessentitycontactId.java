/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.businessentitycontact;

import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.person.contacttype.ContacttypeId;

/** Type for the composite primary key of table `person.businessentitycontact` */
public record BusinessentitycontactId(
  BusinessentityId businessentityid,
  BusinessentityId personid,
  ContacttypeId contacttypeid
) {
  
}