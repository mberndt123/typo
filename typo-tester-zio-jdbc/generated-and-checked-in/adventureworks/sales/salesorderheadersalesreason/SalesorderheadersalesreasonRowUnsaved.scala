/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesreason.SalesreasonId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `sales.salesorderheadersalesreason` which has not been persisted yet */
case class SalesorderheadersalesreasonRowUnsaved(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
      Points to [[salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Primary key. Foreign key to SalesReason.SalesReasonID.
      Points to [[salesreason.SalesreasonRow.salesreasonid]] */
  salesreasonid: SalesreasonId,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): SalesorderheadersalesreasonRow =
    SalesorderheadersalesreasonRow(
      salesorderid = salesorderid,
      salesreasonid = salesreasonid,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object SalesorderheadersalesreasonRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[SalesorderheadersalesreasonRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val salesorderid = jsonObj.get("salesorderid").toRight("Missing field 'salesorderid'").flatMap(_.as(SalesorderheaderId.jsonDecoder))
    val salesreasonid = jsonObj.get("salesreasonid").toRight("Missing field 'salesreasonid'").flatMap(_.as(SalesreasonId.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (salesorderid.isRight && salesreasonid.isRight && modifieddate.isRight)
      Right(SalesorderheadersalesreasonRowUnsaved(salesorderid = salesorderid.toOption.get, salesreasonid = salesreasonid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](salesorderid, salesreasonid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SalesorderheadersalesreasonRowUnsaved] = new JsonEncoder[SalesorderheadersalesreasonRowUnsaved] {
    override def unsafeEncode(a: SalesorderheadersalesreasonRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""salesorderid":""")
      SalesorderheaderId.jsonEncoder.unsafeEncode(a.salesorderid, indent, out)
      out.write(",")
      out.write(""""salesreasonid":""")
      SalesreasonId.jsonEncoder.unsafeEncode(a.salesreasonid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[SalesorderheadersalesreasonRowUnsaved] = Text.instance[SalesorderheadersalesreasonRowUnsaved]{ (row, sb) =>
    SalesorderheaderId.text.unsafeEncode(row.salesorderid, sb)
    sb.append(Text.DELIMETER)
    SalesreasonId.text.unsafeEncode(row.salesreasonid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
