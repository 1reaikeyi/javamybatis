package config;

import java.sql.*;


public class ExcuteQuery {

    public void selectAll(){
        Connection connect = JDBC.getConnection();
        String sql ="select * from shuihu";
        try {
            PreparedStatement preparedStatement =connect.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            Usee usee = null;
            while(resultSet.next()){
                usee = new Usee();
                usee.setName(resultSet.getString("name"));
                usee.setId(resultSet.getInt("id"));
                usee.setWorkplace(resultSet.getString("workplace"));
                usee.setSalary(resultSet.getDouble("salary"));
                usee.setJob(resultSet.getString("job"));
                usee.setGender(resultSet.getString("gender"));
                System.out.println(usee);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBC.closeConnection(connect);
        }

    }
    public void selectById(int id){
        Connection connect = JDBC.getConnection();
        String sql ="select * from shuihu where id = ?";
        try {
            PreparedStatement preparedStatement =connect.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Usee usee = null;
            if(resultSet.next()) {
                usee = new Usee();
                usee.setName(resultSet.getString("name"));
                usee.setId(resultSet.getInt("id"));
                usee.setWorkplace(resultSet.getString("workplace"));
                usee.setSalary(resultSet.getDouble("salary"));
                usee.setJob(resultSet.getString("job"));
                usee.setGender(resultSet.getString("gender"));
                System.out.println(usee);
            }else {
                System.out.println("没有查询到数据");
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBC.closeConnection(connect);
        }
    }
}