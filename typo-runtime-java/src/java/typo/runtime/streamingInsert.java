package typo.runtime;

import org.postgresql.PGConnection;
import org.postgresql.util.PSQLException;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

public class streamingInsert {
    static <T> long insert(String copyCommand, int batchSize, Iterator<T> rows, Connection c, PgText<T> T) throws SQLException {
        var copyManager = c.unwrap(PGConnection.class).getCopyAPI();

        var in = copyManager.copyIn(copyCommand);
        try {
            while (rows.hasNext()) {
                var sb = new StringBuilder();
                for (int i = 0; i < batchSize && rows.hasNext(); i++) {
                    T.unsafeEncode.accept(rows.next(), sb);
                    sb.append("\n");
                }
                var bytes = sb.toString().getBytes(StandardCharsets.UTF_8);
                in.writeToCopy(bytes, 0, bytes.length);
            }
            return in.endCopy();
        } catch (Throwable th) {
            try {
                in.cancelCopy();
            } catch (PSQLException ignored) {
            }
            throw th;
        }
    }
}
