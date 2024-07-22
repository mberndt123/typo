/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.businessentityaddress;

import adventureworks.person.address.AddressId;
import adventureworks.person.addresstype.AddresstypeId;
import adventureworks.person.businessentity.BusinessentityId;
import play.api.libs.json.JsObject;
import play.api.libs.json.JsResult;
import play.api.libs.json.JsValue;
import play.api.libs.json.OWrites;
import play.api.libs.json.Reads;
import scala.collection.immutable.ListMap;
import scala.util.Try;

/** Type for the composite primary key of table `person.businessentityaddress` */
case class BusinessentityaddressId(businessentityid: BusinessentityId, addressid: AddressId, addresstypeid: AddresstypeId)

object BusinessentityaddressId {
  implicit lazy val reads: Reads[BusinessentityaddressId] = {
    Reads[BusinessentityaddressId](json => JsResult.fromTry(
        Try(
          BusinessentityaddressId(
            businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
            addressid = json.\("addressid").as(AddressId.reads),
            addresstypeid = json.\("addresstypeid").as(AddresstypeId.reads)
          )
        )
      ),
    )
  }
  implicit lazy val writes: OWrites[BusinessentityaddressId] = {
    OWrites[BusinessentityaddressId](o =>
      new JsObject(ListMap[String, JsValue](
        "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
        "addressid" -> AddressId.writes.writes(o.addressid),
        "addresstypeid" -> AddresstypeId.writes.writes(o.addresstypeid)
      ))
    )
  }
}