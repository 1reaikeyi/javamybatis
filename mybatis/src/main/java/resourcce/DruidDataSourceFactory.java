package resourcce;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class DruidDataSourceFactory implements DataSourceFactory {
    private Properties properties;
    private DruidDataSource dataSource;

    @Override
    public void setProperties(Properties props) {
        this.properties = props;
    }

    @Override
    public DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new DruidDataSource();
            
            // 设置基本连接属性
            String driver = properties.getProperty("driver");
            if (driver == null) {
                driver = properties.getProperty("driverClassName");
            }
            if (driver != null) {
                dataSource.setDriverClassName(driver);
            }
            
            String url = properties.getProperty("url");
            if (url != null) {
                dataSource.setUrl(url);
            }
            
            String username = properties.getProperty("username");
            if (username != null) {
                dataSource.setUsername(username);
            }
            
            String password = properties.getProperty("password");
            if (password != null) {
                dataSource.setPassword(password);
            }
            
            // 设置连接池属性
            String initialSize = properties.getProperty("initialSize");
            if (initialSize != null) {
                dataSource.setInitialSize(Integer.parseInt(initialSize));
            }
            
            String maxActive = properties.getProperty("maxActive");
            if (maxActive != null) {
                dataSource.setMaxActive(Integer.parseInt(maxActive));
            }
            
            String maxWait = properties.getProperty("maxWait");
            if (maxWait != null) {
                dataSource.setMaxWait(Long.parseLong(maxWait));
            }
        }
        return dataSource;
    }
}

