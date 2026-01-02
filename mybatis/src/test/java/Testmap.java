import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Testmap {
    public static void main(String[] args) throws IOException {
//        1
        InputStream inputStream = Resources.getResourceAsStream("src/main/resources/mybatis.xml");
//        2
//        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
//        3
//        InputStream inputStream = new FileInputStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<Object,Object> insertmap2 = new HashMap<>();
        insertmap2.put("name","宋江");
        insertmap2.put("salary",10000);
        int i = sqlSession.insert("insertUser",insertmap2);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
}
