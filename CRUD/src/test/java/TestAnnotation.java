
import annotion.Dao;
import resource.SqlSessionFactotyBuilderUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestAnnotation {
    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionFactotyBuilderUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
//        config.Usee{name='张飞', id=10, workplace='北京', salary=10000.0, job='拉煤', gender='男'}
        int result = dao.updateParam("深圳", "快递员", "张飞");
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();

    }
}
