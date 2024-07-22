/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.personphone;

import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.person.phonenumbertype.PhonenumbertypeId;
import adventureworks.public.Phone;
import zio.json.JsonDecoder;
import zio.json.JsonEncoder;
import zio.json.ast.Json;
import zio.json.internal.Write;

/** Type for the composite primary key of table `person.personphone` */
case class PersonphoneId(businessentityid: BusinessentityId, phonenumber: Phone, phonenumbertypeid: PhonenumbertypeId)

object PersonphoneId {
  implicit lazy val jsonDecoder: JsonDecoder[PersonphoneId] = {
    JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
      val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
      val phonenumber = jsonObj.get("phonenumber").toRight("Missing field 'phonenumber'").flatMap(_.as(Phone.jsonDecoder))
      val phonenumbertypeid = jsonObj.get("phonenumbertypeid").toRight("Missing field 'phonenumbertypeid'").flatMap(_.as(PhonenumbertypeId.jsonDecoder))
      if (businessentityid.isRight && phonenumber.isRight && phonenumbertypeid.isRight)
        Right(PersonphoneId(businessentityid = businessentityid.toOption.get, phonenumber = phonenumber.toOption.get, phonenumbertypeid = phonenumbertypeid.toOption.get))
      else Left(List[Either[String, Any]](businessentityid, phonenumber, phonenumbertypeid).flatMap(_.left.toOption).mkString(", "))
    }
  }
  implicit lazy val jsonEncoder: JsonEncoder[PersonphoneId] = {
    new JsonEncoder[PersonphoneId] {
      override def unsafeEncode(a: PersonphoneId, indent: Option[Int], out: Write): Unit = {
        out.write("{")
        out.write(""""businessentityid":""")
        BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
        out.write(",")
        out.write(""""phonenumber":""")
        Phone.jsonEncoder.unsafeEncode(a.phonenumber, indent, out)
        out.write(",")
        out.write(""""phonenumbertypeid":""")
        PhonenumbertypeId.jsonEncoder.unsafeEncode(a.phonenumbertypeid, indent, out)
        out.write("}")
      }
    }
  }
}