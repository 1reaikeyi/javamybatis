package adata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Toexecutedel {

    String sql = "delete from shuihu where id = ?";
    public void del() {
        try (Connection connect = JDBC.getConnection();
            PreparedStatement preparedStatement= connect.prepareStatement(sql)) {
            preparedStatement.setInt(1, 5);
            int rows = preparedStatement.executeUpdate();
            System.out.println("删除了 " + rows + " 条记录！");
            JDBC.release(preparedStatement,connect);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}