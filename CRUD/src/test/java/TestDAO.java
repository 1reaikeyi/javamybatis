import function.Dao;
import function.SqlSessionUtil;
import function.Usee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDAO {
    @Test
    public void test_1() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        Usee usee = new Usee("宋江",20,"梁山",800.0,"骗子","大侠");
        int i = dao.insert(usee);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test_2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        Usee usee = new Usee();
        usee.setId(20);
        usee.setJob("对抗路");
        int i = dao.update(usee);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test_3() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        int i = dao.delete(20);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test_4() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        Usee usee = dao.selectOne(20);
        System.out.println(usee);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test_5() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        List<Usee> usees = dao.selectAll();
        System.out.println(usees);
        sqlSession.commit();
        sqlSession.close();
    }
}
