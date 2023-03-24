/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema



sealed abstract class CollationCharacterSetApplicabilityFieldValue[T](val name: String, val value: T)

object CollationCharacterSetApplicabilityFieldValue {
  case class collationCatalog(override val value: Option[String]) extends CollationCharacterSetApplicabilityFieldValue("collation_catalog", value)
  case class collationSchema(override val value: Option[String]) extends CollationCharacterSetApplicabilityFieldValue("collation_schema", value)
  case class collationName(override val value: Option[String]) extends CollationCharacterSetApplicabilityFieldValue("collation_name", value)
  case class characterSetCatalog(override val value: Option[String]) extends CollationCharacterSetApplicabilityFieldValue("character_set_catalog", value)
  case class characterSetSchema(override val value: Option[String]) extends CollationCharacterSetApplicabilityFieldValue("character_set_schema", value)
  case class characterSetName(override val value: Option[String]) extends CollationCharacterSetApplicabilityFieldValue("character_set_name", value)
}
