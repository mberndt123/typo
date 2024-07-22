/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb.hardcoded;



import org.postgresql.PGConnection
import org.postgresql.copy.CopyIn
import org.postgresql.util.PSQLException
import zio.*
import zio.jdbc.ZConnection
import zio.stream.{ZSink, ZStream}

object streamingInsert {
  def apply[T](copyCommand: String, batchSize: Int, rows: ZStream[ZConnection, Throwable, T])(implicit text: Text[T]): ZIO[ZConnection, Throwable, Long] = ZIO.scoped {
    def startCopy(c: ZConnection): Task[CopyIn] =
      c.access(_.unwrap(classOf[PGConnection])).flatMap(c => ZIO.attemptBlocking(c.getCopyAPI.copyIn(copyCommand)))

    def cancelCopy(copyIn: CopyIn): ZIO[Any, Throwable, Unit] =
      ZIO.attemptBlocking(copyIn.cancelCopy()).catchAll {
        case x: PSQLException if x.getMessage == "Tried to cancel an inactive copy operation" => ZIO.unit
        case x                                                                                => ZIO.fail(x)
      }

    for {
      c <- ZIO.environment[ZConnection].map(_.get)
      copyIn <- ZIO.acquireReleaseExit(startCopy(c)) {
        case (copyIn, Exit.Failure(_)) =>
          cancelCopy(copyIn).orDie
        case (copyIn, Exit.Success(_)) =>
          ZIO.attemptBlocking(copyIn.endCopy()).onError(_ => cancelCopy(copyIn).orDie).orDie
      }
      numRows <- rows
        .grouped(batchSize)
        .map { group =>
          val sb = new StringBuilder
          group.foreach { t =>
            Text[T].unsafeEncode(t, sb)
            sb ++= "\n"
          }
          (group.size, sb.result().getBytes("UTF-8"))
        }
        .mapZIO { case (num, bytes) =>
          ZIO.attemptBlocking(copyIn.writeToCopy(bytes, 0, bytes.length)).as(num)
        }
        .run(ZSink.sum)
    } yield numRows.toLong
  }
}
