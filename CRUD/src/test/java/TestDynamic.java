import dynamic.Dao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import resource.SqlSessionUtil;
import resource.Usee;

import java.util.List;

public class TestDynamic {
    @Test
    public void test_1() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao mapper = sqlSession.getMapper(Dao.class);
        List<Usee> usees1 = mapper.selectIf("唐僧", Double.valueOf("6000.0"),"大唐");
        List<Usee> usees2 = mapper.selectIf("唐僧", Double.valueOf("6000.0"),"");
        List<Usee> usees3 = mapper.selectIf("唐僧", null,"");
        List<Usee> usees4 = mapper.selectIf("", null,"");
        System.out.println("usees1 = " + usees1);
        System.out.println("usees2 = " + usees2);
        System.out.println("usees3 = " + usees3);
        System.out.println("usees4 = " + usees4);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test_2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Dao mapper = sqlSession.getMapper(Dao.class);
        List<Usee> usees1 = mapper.selectTrim("唐僧", Double.valueOf("6000.0"),"大唐");
        List<Usee> usees2 = mapper.selectTrim("唐僧", Double.valueOf("6000.0"),"");
        List<Usee> usees3 = mapper.selectTrim("唐僧", null,"");
        List<Usee> usees4 = mapper.selectTrim("", null,"");
        System.out.println("usees1 = " + usees1);
        System.out.println("usees2 = " + usees2);
        System.out.println("usees3 = " + usees3);
        System.out.println("usees4 = " + usees4);
        sqlSession.commit();
        sqlSession.close();
    }
}
