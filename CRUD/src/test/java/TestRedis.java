
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import redis.Dao;
import resource.SqlSessionFactotyBuilderUtil;

import java.io.IOException;

public class TestRedis {
//    一级缓存，放到同一个Sqlsession里面，返回相同的参数、使用同一个的SqlSession
    /**
     * 只有相同的select 才会一级缓存
     */
    @Test
    public void test_1() {
        SqlSession sqlSession = SqlSessionFactotyBuilderUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        dao.selectOne(1);
        dao.selectOne(1);
        System.out.println();
        dao.selectOne(2);
        dao.selectOne(1);
        dao.selectOne(2);//Usee
        dao.selectById(2);//void
        // 1-(1) -2 -(1) -(2)-2
        /**
         *   Preparing: select * from shuihu where id = ?;
         *  Parameters: 1(Integer)
         *
         *   Preparing: select * from shuihu where id = ?;
         *  Parameters: 2(Integer)
         *       Total: 1
         *
         *   Preparing: select * from shuihu where id = ?
         * Parameters: 2(Integer)
         *      Total: 1
         */

        sqlSession.close();
    }
    //    二级缓存，放到SqlsessionFactory
    @Test
    public void test_2() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        Dao dao2 = sqlSession2.getMapper(Dao.class);
        Dao dao1 = sqlSession1.getMapper(Dao.class);
        System.out.println("dao1.selectOne(1) = " + dao1.selectOne(2));
        System.out.println("dao2.selectOne(2) = " + dao2.selectOne(2));
        //关闭sqlsession1,写入二级缓存
        sqlSession1.close();
//        System.out.println("dao1.selectOne(1) = " + dao1.selectOne(2));
        System.out.println("dao2.selectOne(2) = " + dao2.selectOne(2));

        sqlSession1.close();
        sqlSession2.close();
    }

}
