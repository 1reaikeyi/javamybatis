package bean;

import ch.qos.logback.classic.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import transaction.Transaction;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Map;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactoryBuilder() {
    }

    public SqlSessionFactory build(InputStream inputStream) {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            Element environments = (Element) document.selectSingleNode("/configuration/environments");
            String defaultEnvironment = environments.attributeValue("default");
            System.out.println("defaultEnvironment = " + defaultEnvironment);

            Element environment = (Element) document.selectSingleNode("/configuration/environments/environment");
            String environment_type = environment.attributeValue("id");
            System.out.println("environment_type = " + environment_type);

            Element transactionElement = environment.element("transaction");
            Element datasourceElement = environment.element("dataSource");

            DataSource dataSource = getDataSource(datasourceElement);
            Transaction transaction = getTransaction(transactionElement, dataSource);

            Map<String,Mapper> mapperMap = null;
            sqlSessionFactory = new SqlSessionFactory(transaction, mapperMap);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sqlSessionFactory;
    }

    private Transaction getTransaction(Element transactionElement, DataSource dataSource) {
    }

    private DataSource getDataSource(Element datasourceElement) {
        return null;
    }
}
