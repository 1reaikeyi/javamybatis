package bean;

import transaction.Transaction;

import javax.sql.DataSource;
import java.util.Map;

public class SqlSessionFactory {
    private Transaction transaction;
    private DataSource dataSource;
    private Map<String,Mapper> mapperMap;

    public SqlSessionFactory() {
    }

    public SqlSessionFactory(Transaction transaction, Map<String, Mapper> mapperMap) {
        this.transaction = transaction;
        this.mapperMap = mapperMap;
    }
}
