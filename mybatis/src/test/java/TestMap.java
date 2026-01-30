import function.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Map<Object,Object> map = new HashMap<>();
        map.put("id",20);
        int i = sqlSession.delete("action.deleteUser",map);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
}
