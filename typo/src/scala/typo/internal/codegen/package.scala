package typo
package internal

package object codegen {
  implicit class ToCodeOps[T](private val t: T) extends AnyVal {
    def code(implicit toCode: ToCode[T]): sc.Code = toCode.toCode(t)
  }

  implicit final class CodeInterpolator(private val stringContext: StringContext) extends AnyVal {
    def code(args: sc.Code*): sc.Code = {
      sc.Code.Interpolated(stringContext.parts, args)
    }
  }

  // magnet pattern
  implicit def toCode[T: ToCode](x: T): sc.Code = ToCode[T].toCode(x)

  implicit class CodeOps[C <: sc.Code](private val codes: List[C]) extends AnyVal {
    def mkCode(sep: sc.Code): sc.Code = {
      val interspersed = codes.zipWithIndex.map {
        case (c, 0) => c
        case (c, _) => sc.Code.Combined(List(sep, c))
      }
      sc.Code.Combined(interspersed)
    }
  }

  implicit class CodeOpsNel[C <: sc.Code](private val codes: NonEmptyList[C]) extends AnyVal {
    def mkCode(sep: sc.Code): sc.Code = {
      val interspersed = codes.toList.zipWithIndex.map {
        case (c, 0) => c
        case (c, _) => sc.Code.Combined(List(sep, c))
      }
      sc.Code.Combined(interspersed)
    }
  }

  def scaladoc(lines: List[String]): sc.Comments =
    lines match {
      case Nil      => sc.Comments.Empty
      case nonEmpty => sc.Comments(nonEmpty)
    }
}
