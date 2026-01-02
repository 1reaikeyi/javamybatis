import adata.Usee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Testclass {
    @org.junit.Test
   public void testinsert() throws Exception {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Usee usee = new Usee("宋江",20,"梁山",800,"骗子","大侠");
        int i = sqlSession.insert("insertUser",usee);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
   public void testdel() throws Exception {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
       int i = sqlSession.delete("deleteUser",20);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
   public void testupdate() throws Exception {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Usee usee = new Usee();
//        update shuihu set gender = #{gender）where id = #{id};
        usee.setId(2);
        usee.setGender("神仙");
        int i = sqlSession.update("updateUser",usee);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testgetbyid() throws Exception {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Usee usee = sqlSession.selectOne("getUserById",2);
        System.out.println(usee);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testgetall() throws Exception {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
//        配置环境
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream, "development");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Usee> usee = sqlSession.selectList("getAllUsers");
       for (Usee a : usee) {
            System.out.println(a);
        }
        sqlSession.commit();
        sqlSession.close();
    }

}
