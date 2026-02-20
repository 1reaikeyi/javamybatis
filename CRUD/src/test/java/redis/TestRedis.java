package redis;

import CRUD.Dao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import resource.SqlSessionUtil;

public class TestRedis {
//    一级缓存，放到同一个Sqlsession里面

    /**
     * 只有相同的select 才会一级缓存
     */
    @Test
    public void test_1() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        dao.selectOne(1);
        dao.selectOne(1);
        System.out.println();
        dao.selectOne(2);
        dao.selectOne(1);
        dao.selectOne(2);
        // 1-(1) -2 -(1) -(2)
        /**
         *   Preparing: select * from shuihu where id = ?;
         *  Parameters: 1(Integer)
         *
         *   Preparing: select * from shuihu where id = ?;
         *  Parameters: 2(Integer)
         *       Total: 1
         */

        sqlSession.close();
    }
//    二级缓存
    @Test
    public void test_2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);

    }
}
