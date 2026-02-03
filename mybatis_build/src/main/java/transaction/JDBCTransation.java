package transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCTransation implements Transaction{
    private DataSource dataSource;
    private boolean autoCommit;
    private Connection connection;

    public JDBCTransation(DataSource dataSource, boolean autoCommit) {
        this.dataSource = dataSource;
        this.autoCommit = autoCommit;
    }

    @Override
    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return this.connection;
    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
