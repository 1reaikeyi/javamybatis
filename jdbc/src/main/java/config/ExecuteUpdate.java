package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExecuteUpdate {
    public void insert(Usee usee){
        Connection connection = JDBC.getConnection();
        String sql = "insert into shuihu(name,id,workplace,salary,job,gender) values (?,?,?,?,?,?)";
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
        Connection connection = JDBC.getConnection();
        String sql ="delete from shuihu where id =?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int count = preparedStatement.executeUpdate();
            if(count>0){
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBC.closeConnection(connection);
        }

    }
    public void update(String id,String workplace){
        Connection connection = JDBC.getConnection();
        String sql ="update shuihu set workplace =? where id =?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, workplace);
            preparedStatement.setString(2, id);
            int count = preparedStatement.executeUpdate();
            if(count>0){
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBC.closeConnection(connection);
        }
    }
}
