import CRUD.Dao;
import resource.SqlSessionFactotyBuilderUtil;
import resource.Usee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestCRUD {
    @Test
    public void test_1() {
        SqlSession sqlSession = SqlSessionFactotyBuilderUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        Usee usee = new Usee("宋江",20,"梁山",800.0,"骗子","大侠");
        int i = dao.insert(usee);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test_2() {
        SqlSession sqlSession = SqlSessionFactotyBuilderUtil.getSqlSession();
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
        SqlSession sqlSession = SqlSessionFactotyBuilderUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        int i = dao.delete(20);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test_4() {
        SqlSession sqlSession = SqlSessionFactotyBuilderUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        Usee usee = dao.selectOne(20);
        System.out.println(usee);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test_5() {
        SqlSession sqlSession = SqlSessionFactotyBuilderUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        List<Usee> usees = dao.selectAll();
        for (Usee usee : usees) {
            System.out.println(usee);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
