package adata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExecuteUpdate {
    Connection connection = JDBC.getConnection();
    String sql = "insert into shuihu(name,id,workplace,salary,job,gender) values (?,?,?,?,?,?)";
    public void insert(Usee usee){
        PreparedStatement preparedStatement = null;
        try {
             preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1, usee.getName());
             preparedStatement.setInt(2, usee.getId());
             preparedStatement.setString(3, usee.getWorkplace());
             preparedStatement.setDouble(4, usee.getSalary());
             preparedStatement.setString(5, usee.getJob());
             preparedStatement.setString(6, usee.getGender());
             int count = preparedStatement.executeUpdate();
             if(count>0){
                 System.out.println("插入成功");
             }else {
                 System.out.println("插入失败");
             }
             preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBC.closeConnection(connection);
        }

    }
    public void delete(int id){
        String sql ="delete from shuihu where id =?";

    }
    public void update(Usee usee){
        String sql ="update shuihu set name =?,id =?,workplace =?,salary =?,job =?,gender =? where id =?";
    }
}
