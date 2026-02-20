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
        List<One> student = onemapper.studentById(101);
        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void test_2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Twomapper twomapper = sqlSession.getMapper(Twomapper.class);
        List<Two> two = twomapper.teacherById(202);
        System.out.println(two);
        sqlSession.close();
    }
    @Test
    public void test_3() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Onemapper onemapper = sqlSession.getMapper(Onemapper.class);
        List<One> one = onemapper.studentStep(101);
        System.out.println(one);
        sqlSession.close();
    }
    @Test
    public void test_4() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Twomapper twomapper = sqlSession.getMapper(Twomapper.class);
        List<Two> twos = twomapper.teacherCollection(201);
        for (Two two : twos)
            System.out.println(two);
        sqlSession.close();
    }
    @Test
    public void test_5() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Twomapper twomapper = sqlSession.getMapper(Twomapper.class);
        List<Two> twos = twomapper.teacherStep(202);
        for (Two two : twos){
            System.out.println(two);
        }
        sqlSession.close();
    }
}
