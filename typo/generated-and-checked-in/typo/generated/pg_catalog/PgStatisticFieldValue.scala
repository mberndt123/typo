/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog



sealed abstract class PgStatisticFieldValue[T](val name: String, val value: T)

object PgStatisticFieldValue {
  case class starelid(override val value: Long) extends PgStatisticFieldValue("starelid", value)
  case class staattnum(override val value: Short) extends PgStatisticFieldValue("staattnum", value)
  case class stainherit(override val value: Boolean) extends PgStatisticFieldValue("stainherit", value)
  case class stanullfrac(override val value: Float) extends PgStatisticFieldValue("stanullfrac", value)
  case class stawidth(override val value: Int) extends PgStatisticFieldValue("stawidth", value)
  case class stadistinct(override val value: Float) extends PgStatisticFieldValue("stadistinct", value)
  case class stakind1(override val value: Short) extends PgStatisticFieldValue("stakind1", value)
  case class stakind2(override val value: Short) extends PgStatisticFieldValue("stakind2", value)
  case class stakind3(override val value: Short) extends PgStatisticFieldValue("stakind3", value)
  case class stakind4(override val value: Short) extends PgStatisticFieldValue("stakind4", value)
  case class stakind5(override val value: Short) extends PgStatisticFieldValue("stakind5", value)
  case class staop1(override val value: Long) extends PgStatisticFieldValue("staop1", value)
  case class staop2(override val value: Long) extends PgStatisticFieldValue("staop2", value)
  case class staop3(override val value: Long) extends PgStatisticFieldValue("staop3", value)
  case class staop4(override val value: Long) extends PgStatisticFieldValue("staop4", value)
  case class staop5(override val value: Long) extends PgStatisticFieldValue("staop5", value)
  case class stacoll1(override val value: Long) extends PgStatisticFieldValue("stacoll1", value)
  case class stacoll2(override val value: Long) extends PgStatisticFieldValue("stacoll2", value)
  case class stacoll3(override val value: Long) extends PgStatisticFieldValue("stacoll3", value)
  case class stacoll4(override val value: Long) extends PgStatisticFieldValue("stacoll4", value)
  case class stacoll5(override val value: Long) extends PgStatisticFieldValue("stacoll5", value)
  case class stanumbers1(override val value: Option[Array[Float]]) extends PgStatisticFieldValue("stanumbers1", value)
  case class stanumbers2(override val value: Option[Array[Float]]) extends PgStatisticFieldValue("stanumbers2", value)
  case class stanumbers3(override val value: Option[Array[Float]]) extends PgStatisticFieldValue("stanumbers3", value)
  case class stanumbers4(override val value: Option[Array[Float]]) extends PgStatisticFieldValue("stanumbers4", value)
  case class stanumbers5(override val value: Option[Array[Float]]) extends PgStatisticFieldValue("stanumbers5", value)
  case class stavalues1(override val value: Option[String]) extends PgStatisticFieldValue("stavalues1", value)
  case class stavalues2(override val value: Option[String]) extends PgStatisticFieldValue("stavalues2", value)
  case class stavalues3(override val value: Option[String]) extends PgStatisticFieldValue("stavalues3", value)
  case class stavalues4(override val value: Option[String]) extends PgStatisticFieldValue("stavalues4", value)
  case class stavalues5(override val value: Option[String]) extends PgStatisticFieldValue("stavalues5", value)
}
