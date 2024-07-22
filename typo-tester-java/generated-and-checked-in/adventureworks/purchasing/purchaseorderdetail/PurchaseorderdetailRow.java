/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.purchasing.purchaseorderdetail;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.customtypes.TypoShort;
import adventureworks.production.product.ProductId;
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId;
import java.math.BigDecimal;

/** Table: purchasing.purchaseorderdetail
  * Individual products associated with a specific purchase order. See PurchaseOrderHeader.
  * Composite primary key: purchaseorderid, purchaseorderdetailid
  */
public record PurchaseorderdetailRow(
  /** Primary key. Foreign key to PurchaseOrderHeader.PurchaseOrderID.
    * Points to {@link adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderRow.purchaseorderid}
    */
  PurchaseorderheaderId purchaseorderid,
  /** Primary key. One line number per purchased product.
    * Default: nextval('purchasing.purchaseorderdetail_purchaseorderdetailid_seq'::regclass)
    */
  Integer purchaseorderdetailid,
  /** Date the product is expected to be received. */
  TypoLocalDateTime duedate,
  /** Quantity ordered.
    * Constraint CK_PurchaseOrderDetail_OrderQty affecting columns orderqty: ((orderqty > 0))
    */
  TypoShort orderqty,
  /** Product identification number. Foreign key to Product.ProductID.
    * Points to {@link adventureworks.production.product.ProductRow.productid}
    */
  ProductId productid,
  /** Vendor's selling price of a single product.
    * Constraint CK_PurchaseOrderDetail_UnitPrice affecting columns unitprice: ((unitprice >= 0.00))
    */
  BigDecimal unitprice,
  /** Quantity actually received from the vendor.
    * Constraint CK_PurchaseOrderDetail_ReceivedQty affecting columns receivedqty: ((receivedqty >= 0.00))
    */
  BigDecimal receivedqty,
  /** Quantity rejected during inspection.
    * Constraint CK_PurchaseOrderDetail_RejectedQty affecting columns rejectedqty: ((rejectedqty >= 0.00))
    */
  BigDecimal rejectedqty,
  /** Default: now() */
  TypoLocalDateTime modifieddate
) {
  static public PurchaseorderdetailRow apply(
                                              PurchaseorderdetailId compositeId,
                                              TypoLocalDateTime duedate,
                                              TypoShort orderqty,
                                              ProductId productid,
                                              BigDecimal unitprice,
                                              BigDecimal receivedqty,
                                              BigDecimal rejectedqty,
                                              TypoLocalDateTime modifieddate
                                            ) {
           return new PurchaseorderdetailRow(compositeId.purchaseorderid(), compositeId.purchaseorderdetailid(), duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate);
         };
  public PurchaseorderdetailId compositeId() {
    return new PurchaseorderdetailId(purchaseorderid, purchaseorderdetailid);
  };
  public PurchaseorderdetailId id() {
    return compositeId();
  };
  public PurchaseorderdetailRowUnsaved toUnsavedRow(Defaulted<Integer> purchaseorderdetailid, Defaulted<TypoLocalDateTime> modifieddate) {
    return new PurchaseorderdetailRowUnsaved(purchaseorderid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, purchaseorderdetailid, modifieddate);
  };
}