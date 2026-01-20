package pool;

import com.alibaba.druid.pool.DruidDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Druid {
    private static Druid instance;
    private DruidDataSource dataSource;

    private Druid() {
        initDataSource();
    }

    private void initDataSource() {
        dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/tostu");
        dataSource.setUsername("root");
        dataSource.setPassword(System.getenv("Mysql_password"));
        // 连接池配置
        dataSource.setInitialSize(3);
        dataSource.setMaxActive(4);
        dataSource.setMaxWait(3000);
    }

    public static synchronized Druid getInstance() {
        if (instance == null) {
            instance = new Druid();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
