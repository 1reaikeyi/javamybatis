package bean;

import data.UNPOOLDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import transaction.JDBCTransation;
import transaction.Transaction;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
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

            Element transactionElement = environment.element("transactionManager");
            System.out.println("transactionElement = " + transactionElement);
            Element datasourceElement = environment.element("dataSource");
            System.out.println("datasourceElement = " + datasourceElement);

            DataSource dataSource = getDataSource(datasourceElement);
            Transaction transaction = getTransaction(transactionElement, dataSource);

            List<Node> mapperElements = document.selectNodes("//mapper");
            Map<String,Mapper> mapperMap = getMappers(mapperElements);
            sqlSessionFactory = new SqlSessionFactory(transaction, mapperMap);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sqlSessionFactory;
    }

    private Transaction getTransaction(Element transactionElement, DataSource dataSource) {
        String type = transactionElement.attributeValue("type");
        if ("JDBC".equals(type)) {
            return new JDBCTransation(dataSource, false);
        }
        return null;
    }

    private DataSource getDataSource(Element datasourceElement) {
        String type = datasourceElement.attributeValue("type");
        if ("UNPOOLED".equals(type)) {
            String driver = null;
            String url = null;
            String username = null;
            String password = null;
            
            List<Element> properties = datasourceElement.elements("property");
            for (Element property : properties) {
                String name = property.attributeValue("name");
                String value = property.attributeValue("value");
                if ("driver".equals(name)) {
                    driver = value;
                } else if ("url".equals(name)) {
                    url = value;
                } else if ("username".equals(name)) {
                    username = value;
                } else if ("password".equals(name)) {
                    password = value;
                }
            }
            System.out.println("driver = " + driver);
            System.out.println("url = " + url);
            System.out.println("username = " + username);
            System.out.println("password = " + password);
            return new UNPOOLDataSource(driver, url, username, password);
        }
        return null;
    }
    
    private Map<String, Mapper> getMappers(List<Node> XmlPathmapper) {
        Map<String, Mapper> mapperMap = new HashMap<>();
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(Resource.getResourceAsStream("XmlPathmapper"));

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }


        return mapperMap;
    }
}