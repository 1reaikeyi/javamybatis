package Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;


public class SqlSessionUtil { 
    private static SqlSessionFactory sqlSessionFactory; 
    private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    
    // 静态初始化块，只在类加载时执行一次
    static {
        try {
            String resource = "mybatis.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("初始化SqlSessionFactory失败", e);
        }
    }
    
    // 私有构造方法，防止外部实例化
    private SqlSessionUtil() {
    } 

    public static SqlSession getSqlSession() {
        SqlSession session = threadLocal.get();
        if (session == null) {
            session = sqlSessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSqlSession() {
        SqlSession session = threadLocal.get();
        if (session != null) {
            try {
                session.close();
            } finally {
                threadLocal.remove();
            }
        }
    }
}