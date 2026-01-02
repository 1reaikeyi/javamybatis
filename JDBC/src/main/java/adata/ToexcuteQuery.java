package adata;

import java.sql.*;


public class ToexcuteQuery {
    Connection connect = null;

    String sql ="select * from shuihu";
    public  PreparedStatement preparedStatement = null;
    public  ResultSet resultSet = null;
    public void query() {
        try {
            connect = JDBC.getConnection();
            preparedStatement = connect.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            resultSet = preparedStatement.executeQuery();
            //  打印表头（列名）
//            ResultSetMetaData metaData = resultSet.getMetaData();
//            int columnCount = metaData.getColumnCount();
//
//            System.out.print("表头:\t");
//            for (int i = 1; i <= columnCount; i++) {
//                System.out.print(metaData.getColumnName(i) + "\t");
//            }
//            System.out.println();


            while (resultSet.next()) {
//                System.out.println(resultSet.getString("name") + "\t\t" + resultSet.getInt("id") + "\t\t" +
//                        resultSet.getString("home") + "\t\t" + resultSet.getString("score") + "\t\t" +
//                        resultSet.getString("comment"));
                Usee use = new Usee(
                        resultSet.getString("name"),
                        resultSet.getInt("id"),
                        resultSet.getString("workplace"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("job"),
                        resultSet.getString("gender")
                );
                System.out.println(use);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBC.release(resultSet,preparedStatement,connect);
        }

    }
}