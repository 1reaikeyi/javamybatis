package adata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class toinserts {

    String sql = "insert into shuihu (name,id,workplace,salary,job,gender) values (?,?,?,?,?,?)";
    public void insert() {
        try {
           Connection connect = JDBC.getConnection();

           PreparedStatement preparedStatement  = connect.prepareStatement(sql);
            preparedStatement.setString(1,"林冲");
            preparedStatement.setInt(2,5);
            preparedStatement.setString(3,"梁山");
            preparedStatement.setDouble(4,10000);
            preparedStatement.setString(5,"跑腿");
            preparedStatement.setString(6,"大侠");
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("插入"+rows+"条记录");
                System.out.println("插入成功");
            }
            else {
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
