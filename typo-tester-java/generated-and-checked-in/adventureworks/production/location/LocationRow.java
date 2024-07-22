/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.location;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.public_.Name;
import java.math.BigDecimal;

/** Table: production.location
  * Product inventory and manufacturing locations.
  * Primary key: locationid
  */
public record LocationRow(
  /** Primary key for Location records.
    * Default: nextval('production.location_locationid_seq'::regclass)
    */
  LocationId locationid,
  /** Location description. */
  Name name,
  /** Standard hourly cost of the manufacturing location.
    * Default: 0.00
    * Constraint CK_Location_CostRate affecting columns costrate: ((costrate >= 0.00))
    */
  BigDecimal costrate,
  /** Work capacity (in hours) of the manufacturing location.
    * Default: 0.00
    * Constraint CK_Location_Availability affecting columns availability: ((availability >= 0.00))
    */
  BigDecimal availability,
  /** Default: now() */
  TypoLocalDateTime modifieddate
) {
  public LocationId id() {
    return locationid;
  };
  public LocationRowUnsaved toUnsavedRow(
                                          Defaulted<LocationId> locationid,
                                          Defaulted<BigDecimal> costrate,
                                          Defaulted<BigDecimal> availability,
                                          Defaulted<TypoLocalDateTime> modifieddate
                                        ) {
    return new LocationRowUnsaved(name, locationid, costrate, availability, modifieddate);
  };
}