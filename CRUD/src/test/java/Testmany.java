import many.One;
import many.Onemapper;
import many.Two;
import many.Twomapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import resource.SqlSessionUtil;

import java.util.List;

public class Testmany {
    @Test
    public void test_1() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Onemapper onemapper = sqlSession.getMapper(Onemapper.class);
        One student = onemapper.studentById(101);
        System.out.println(student.getSname());
        System.out.println(student.getTwo());
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test_2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Twomapper twomapper = sqlSession.getMapper(Twomapper.class);
        List<Two> two = twomapper.teacherById(202);
        System.out.println(two);
        sqlSession.commit();
        sqlSession.close();
    }
}
