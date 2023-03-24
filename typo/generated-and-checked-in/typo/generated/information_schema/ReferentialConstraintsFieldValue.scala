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



sealed abstract class ReferentialConstraintsFieldValue[T](val name: String, val value: T)

object ReferentialConstraintsFieldValue {
  case class constraintCatalog(override val value: Option[String]) extends ReferentialConstraintsFieldValue("constraint_catalog", value)
  case class constraintSchema(override val value: Option[String]) extends ReferentialConstraintsFieldValue("constraint_schema", value)
  case class constraintName(override val value: Option[String]) extends ReferentialConstraintsFieldValue("constraint_name", value)
  case class uniqueConstraintCatalog(override val value: Option[String]) extends ReferentialConstraintsFieldValue("unique_constraint_catalog", value)
  case class uniqueConstraintSchema(override val value: Option[String]) extends ReferentialConstraintsFieldValue("unique_constraint_schema", value)
  case class uniqueConstraintName(override val value: Option[String]) extends ReferentialConstraintsFieldValue("unique_constraint_name", value)
  case class matchOption(override val value: Option[String]) extends ReferentialConstraintsFieldValue("match_option", value)
  case class updateRule(override val value: Option[String]) extends ReferentialConstraintsFieldValue("update_rule", value)
  case class deleteRule(override val value: Option[String]) extends ReferentialConstraintsFieldValue("delete_rule", value)
}
