package adata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class toupdate {

    String sql = "update shuihu set workplace = ? where id = ?";
    public void update() {
        try {
            Connection connect = JDBC.getConnection();
            // 先获取 PreparedStatement 实例

           PreparedStatement preparedStatement = connect.prepareStatement(sql);
            // 再设置参数
            preparedStatement.setString(1, "上海");
            preparedStatement.setInt(2, 2);
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }
            JDBC.release(preparedStatement,connect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
