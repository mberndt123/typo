/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vindividualcustomer

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import org.postgresql.jdbc.PgSQLXML

sealed abstract class VindividualcustomerFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class VindividualcustomerFieldValue[T](name: String, value: T) extends VindividualcustomerFieldOrIdValue(name, value)

object VindividualcustomerFieldValue {
  case class businessentityid(override val value: Option[BusinessentityId]) extends VindividualcustomerFieldValue("businessentityid", value)
  case class title(override val value: Option[String]) extends VindividualcustomerFieldValue("title", value)
  case class firstname(override val value: Option[Name]) extends VindividualcustomerFieldValue("firstname", value)
  case class middlename(override val value: Option[Name]) extends VindividualcustomerFieldValue("middlename", value)
  case class lastname(override val value: Option[Name]) extends VindividualcustomerFieldValue("lastname", value)
  case class suffix(override val value: Option[String]) extends VindividualcustomerFieldValue("suffix", value)
  case class phonenumber(override val value: Option[Phone]) extends VindividualcustomerFieldValue("phonenumber", value)
  case class phonenumbertype(override val value: Option[Name]) extends VindividualcustomerFieldValue("phonenumbertype", value)
  case class emailaddress(override val value: Option[String]) extends VindividualcustomerFieldValue("emailaddress", value)
  case class emailpromotion(override val value: Option[Int]) extends VindividualcustomerFieldValue("emailpromotion", value)
  case class addresstype(override val value: Option[Name]) extends VindividualcustomerFieldValue("addresstype", value)
  case class addressline1(override val value: Option[String]) extends VindividualcustomerFieldValue("addressline1", value)
  case class addressline2(override val value: Option[String]) extends VindividualcustomerFieldValue("addressline2", value)
  case class city(override val value: Option[String]) extends VindividualcustomerFieldValue("city", value)
  case class stateprovincename(override val value: Option[Name]) extends VindividualcustomerFieldValue("stateprovincename", value)
  case class postalcode(override val value: Option[String]) extends VindividualcustomerFieldValue("postalcode", value)
  case class countryregionname(override val value: Option[Name]) extends VindividualcustomerFieldValue("countryregionname", value)
  case class demographics(override val value: Option[PgSQLXML]) extends VindividualcustomerFieldValue("demographics", value)
}
