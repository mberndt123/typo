package testdb.information_schema



sealed abstract class TablePrivilegesFieldValue[T](val name: String, val value: T)

object TablePrivilegesFieldValue {
  case class grantor(override val value: /* unknown nullability */ Option[String]) extends TablePrivilegesFieldValue("grantor", value)
  case class grantee(override val value: /* unknown nullability */ Option[String]) extends TablePrivilegesFieldValue("grantee", value)
  case class tableCatalog(override val value: /* unknown nullability */ Option[String]) extends TablePrivilegesFieldValue("table_catalog", value)
  case class tableSchema(override val value: /* unknown nullability */ Option[String]) extends TablePrivilegesFieldValue("table_schema", value)
  case class tableName(override val value: /* unknown nullability */ Option[String]) extends TablePrivilegesFieldValue("table_name", value)
  case class privilegeType(override val value: /* unknown nullability */ Option[String]) extends TablePrivilegesFieldValue("privilege_type", value)
  case class isGrantable(override val value: /* unknown nullability */ Option[String]) extends TablePrivilegesFieldValue("is_grantable", value)
  case class withHierarchy(override val value: /* unknown nullability */ Option[String]) extends TablePrivilegesFieldValue("with_hierarchy", value)
}
