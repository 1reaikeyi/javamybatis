import org.junit.Test;
import pool.Druid;
import pool.Usee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Testpool {
    @Test
    public void test() {
        Connection connect = null;
        String sql = "select * from shuihu";
        try {
            // 使用Druid连接池获取连接
            connect = Druid.getInstance().getConnection();
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            Usee usee = null;
            while (resultSet.next()) {
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
        } finally {
            // 使用Druid连接池关闭连接（实际上是归还连接到连接池）
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void testDruidPoolConfiguration() {
        System.out.println("=== 测试Druid连接池配置并行 ===");
        // 获取Druid实例
        Druid druid = Druid.getInstance();
        // 测试连接池的连接获取和释放
        List<Connection> connections = new ArrayList<>();
        try {
            // 逐步获取连接，观察连接池状态
            System.out.println("\n=== 开始获取连接 ===");
            // 获取第1个连接
            Connection conn1 = druid.getConnection();
            connections.add(conn1);
            System.out.println("获取第1个连接成功");
            // 获取第2个连接
            Connection conn2 = druid.getConnection();
            connections.add(conn2);
            System.out.println("获取第2个连接成功");
            // 获取第3个连接
            Connection conn3 = druid.getConnection();
            connections.add(conn3);
            System.out.println("获取第3个连接成功（达到最大活跃连接数）");
            // 尝试获取第4个连接（应该会等待或超时）
            try {
                System.out.println("尝试获取第4个连接（超过最大活跃连接数）...");
                Connection conn5 = druid.getConnection();
                connections.add(conn5);
                System.out.println("获取第4个连接成功");
            } catch (SQLException e) {
                System.out.println("获取第4个连接失败，原因: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("获取连接时发生错误: " + e.getMessage());
        } finally {
            // 释放所有连接
            System.out.println("\n=== 开始释放连接 ===");
            for (int i = 0; i < connections.size(); i++) {
                try {
                    connections.get(i).close();
                    System.out.println("释放第" + (i + 1) + "个连接成功");
                } catch (SQLException e) {
                    System.err.println("释放第" + (i + 1) + "个连接失败: " + e.getMessage());
                }
            }
        }
    }

    @Test
    public void testConcurrentConnections() {
        System.out.println("=== 测试并发连接 ===");
        Druid druid = Druid.getInstance();
        // 创建多个线程同时获取连接
        Thread[] threads = new Thread[4]; // 3个线程同时获取连接
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i + 1;
            threads[i] = new Thread(() -> {
                try {
                    System.out.println("线程" + threadId + "尝试获取连接...");
                    Connection conn = druid.getConnection();
                    System.out.println("线程" + threadId + "获取连接成功");
                    // 模拟使用连接
                    Thread.sleep(3000);
                    // 释放连接
                    conn.close();
                    System.out.println("线程" + threadId + "释放连接成功");
                } catch (Exception e) {
                    System.err.println("线程" + threadId + "操作失败: " + e.getMessage());
                }
            });
        }
        // 启动所有线程
        for (Thread thread : threads) {
            thread.start();
        }
        // 等待所有线程完成
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("等待线程完成时被中断: " + e.getMessage());
            }
        }

        System.out.println("所有线程操作完成");
    }
}