package config;

import java.sql.*;

public class JDBC {

    private static final String url = "jdbc:mysql://localhost:3306/tostu";
    private static final String username = "root";
    private static final String password = System.getenv("Mysql_password");
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static Connection connection = null;
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static void closeConnection(Connection connect) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}