
import map.Dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import resource.SqlSessionUtil;
import resource.Usee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestMap {
//    @Test
//    public void main() {
//        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
//        Map<String,String> map = new HashMap<>();
//        map.put("id","5,4,10");
//        Dao dao = sqlSession.getMapper(Dao.class);
//        int i = dao.deleteAll(map.get("id"));
//        System.out.println(i);
//        sqlSession.commit();
//        sqlSession.close();
//    }

    @Test
    public void main2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        Usee usee = dao.selectOne(1);
        System.out.println(usee);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void main3() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        List<Usee> usee = dao.selectList();
        for (Usee usee1 : usee) {
            System.out.println(usee1);
        }
        System.out.println(usee);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void main4() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        Map<String, Object> map = dao.selectOneMap();
        System.out.println(map);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void main5() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        List<Map<String, Object>> list = dao.selectListMap();
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void main6() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        Map<String, Map<Integer, Object>> map = dao.selectMapMap();
        System.out.println(map);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void main7() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        List<Usee> usee = dao.resultMap();
        System.out.println(usee);
        sqlSession.commit();
        sqlSession.close();
    }

}
