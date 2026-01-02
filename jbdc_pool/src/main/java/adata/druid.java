package adata;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public class druid {
    public static void main(String[] args) throws Exception {
       try{
                Properties properties = new Properties();
                properties.load(druid.class.getClassLoader().getResourceAsStream("jbdc.properties"));
                DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
                try (Connection connection = dataSource.getConnection();
                     // 准备 SQL 语句
                     PreparedStatement preparedStatement = connection.prepareStatement("select * from xixingji");
                     // 执行查询并获取结果集
                     ResultSet resultSet = preparedStatement.executeQuery()) {
                    // 遍历结果集
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("name") + "\t" + resultSet.getInt("id") + "\t" +
                                resultSet.getString("home") + "\t" + resultSet.getString("score") + "\t" +
                                resultSet.getString("comment"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
