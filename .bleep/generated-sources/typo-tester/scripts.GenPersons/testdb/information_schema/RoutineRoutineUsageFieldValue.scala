package testdb.information_schema



sealed abstract class RoutineRoutineUsageFieldValue[T](val name: String, val value: T)

object RoutineRoutineUsageFieldValue {
  case class specificCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutineRoutineUsageFieldValue("specific_catalog", value)
  case class specificSchema(override val value: /* unknown nullability */ Option[String]) extends RoutineRoutineUsageFieldValue("specific_schema", value)
  case class specificName(override val value: /* unknown nullability */ Option[String]) extends RoutineRoutineUsageFieldValue("specific_name", value)
  case class routineCatalog(override val value: /* unknown nullability */ Option[String]) extends RoutineRoutineUsageFieldValue("routine_catalog", value)
  case class routineSchema(override val value: /* unknown nullability */ Option[String]) extends RoutineRoutineUsageFieldValue("routine_schema", value)
  case class routineName(override val value: /* unknown nullability */ Option[String]) extends RoutineRoutineUsageFieldValue("routine_name", value)
}
