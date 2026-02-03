package transaction;

import java.sql.Connection;

public interface Transaction {
    void commit();
    void rollback();
    void close();
    Connection getConnection();
}
