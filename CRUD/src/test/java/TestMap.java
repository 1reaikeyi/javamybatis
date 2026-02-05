
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import resource.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    @Test
    public void main() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Map<Object,Object> map = new HashMap<>();
        map.put("id",20);
        int i = sqlSession.delete("action.deleteAll",map);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void main2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

    }
}
