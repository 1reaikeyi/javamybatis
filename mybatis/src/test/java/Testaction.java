import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Testaction {
    public static void main(String[] args) throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream("src/main/resources/mybatis.xml");

        InputStream inputStream = new FileInputStream("src/main/resources/mybatis.xml");

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
