
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import resource.SqlSessionFactotyBuilderUtil;

public class Test_$ {
    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionFactotyBuilderUtil.getSqlSession();
        int i = sqlSession.delete("deleteAll", "20,15,5,6");
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
}
