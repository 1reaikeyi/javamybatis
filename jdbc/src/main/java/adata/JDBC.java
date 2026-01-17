package adata;

import java.sql.*;

public class JDBC {

      private static final String url = "jdbc:mysql://localhost:3306/tostu";
      private static final String username = "root";
      private static final String password = "111222";
      private static final String driver = "com.mysql.cj.jdbc.Driver";
      private static Connection connection = null;
        static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        }

        public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
        }

    public static void release(PreparedStatement preStmt, Connection conn) {
        if (preStmt != null) {
            try {
                preStmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void release(ResultSet resu, PreparedStatement Prestmt, Connection conn) {
        if (Prestmt != null) {
            try {
                Prestmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (resu != null) {
            try {
                resu.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}