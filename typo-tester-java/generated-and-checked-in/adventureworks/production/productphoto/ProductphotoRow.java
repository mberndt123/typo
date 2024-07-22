/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.production.productphoto;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoBytea;
import adventureworks.customtypes.TypoLocalDateTime;
import java.util.Optional;

/** Table: production.productphoto
  * Product images.
  * Primary key: productphotoid
  */
public record ProductphotoRow(
  /** Primary key for ProductPhoto records.
    * Default: nextval('production.productphoto_productphotoid_seq'::regclass)
    */
  ProductphotoId productphotoid,
  /** Small image of the product. */
  Optional<TypoBytea> thumbnailphoto,
  /** Small image file name. */
  Optional</* max 50 chars */ String> thumbnailphotofilename,
  /** Large image of the product. */
  Optional<TypoBytea> largephoto,
  /** Large image file name. */
  Optional</* max 50 chars */ String> largephotofilename,
  /** Default: now() */
  TypoLocalDateTime modifieddate
) {
  public ProductphotoId id() {
    return productphotoid;
  };
  public ProductphotoRowUnsaved toUnsavedRow(Defaulted<ProductphotoId> productphotoid, Defaulted<TypoLocalDateTime> modifieddate) {
    return new ProductphotoRowUnsaved(thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, productphotoid, modifieddate);
  };
}