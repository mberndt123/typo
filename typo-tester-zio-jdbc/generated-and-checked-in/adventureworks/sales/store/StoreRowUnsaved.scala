/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.sales.store

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `sales.store` which has not been persisted yet */
case class StoreRowUnsaved(
  /** Primary key. Foreign key to Customer.BusinessEntityID.
      Points to [[adventureworks.person.businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Name of the store. */
  name: Name,
  /** ID of the sales person assigned to the customer. Foreign key to SalesPerson.BusinessEntityID.
      Points to [[adventureworks.sales.salesperson.SalespersonRow.businessentityid]] */
  salespersonid: Option[BusinessentityId],
  /** Demographic informationg about the store such as the number of employees, annual sales and store type. */
  demographics: Option[TypoXml],
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): StoreRow =
    StoreRow(
      businessentityid = businessentityid,
      name = name,
      salespersonid = salespersonid,
      demographics = demographics,
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
object StoreRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[StoreRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val salespersonid = jsonObj.get("salespersonid").fold[Either[String, Option[BusinessentityId]]](Right(None))(_.as(JsonDecoder.option(using BusinessentityId.jsonDecoder)))
    val demographics = jsonObj.get("demographics").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(Defaulted.jsonDecoder(TypoUUID.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (businessentityid.isRight && name.isRight && salespersonid.isRight && demographics.isRight && rowguid.isRight && modifieddate.isRight)
      Right(StoreRowUnsaved(businessentityid = businessentityid.toOption.get, name = name.toOption.get, salespersonid = salespersonid.toOption.get, demographics = demographics.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, name, salespersonid, demographics, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[StoreRowUnsaved] = new JsonEncoder[StoreRowUnsaved] {
    override def unsafeEncode(a: StoreRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""salespersonid":""")
      JsonEncoder.option(using BusinessentityId.jsonEncoder).unsafeEncode(a.salespersonid, indent, out)
      out.write(",")
      out.write(""""demographics":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.demographics, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      Defaulted.jsonEncoder(TypoUUID.jsonEncoder).unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[StoreRowUnsaved] = Text.instance[StoreRowUnsaved]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Text.option(BusinessentityId.text).unsafeEncode(row.salespersonid, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoXml.text).unsafeEncode(row.demographics, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
