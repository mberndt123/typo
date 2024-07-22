/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.salesterritoryhistory;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.sales.salesterritory.SalesterritoryId;

/** Type for the composite primary key of table `sales.salesterritoryhistory` */
public record SalesterritoryhistoryId(
  BusinessentityId businessentityid,
  TypoLocalDateTime startdate,
  SalesterritoryId territoryid
) {
  
}