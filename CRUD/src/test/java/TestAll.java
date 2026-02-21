
import all.Dao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import resource.SqlSessionFactotyBuilderUtil;
import resource.Usee;

import java.util.ArrayList;
import java.util.List;

public class TestAll {
    @Test
    public void test_1() {
        SqlSession sqlSession = SqlSessionFactotyBuilderUtil.getSqlSession();
        Dao mapper = sqlSession.getMapper(Dao.class);
        List<Integer> list = new ArrayList<>();
        list.add(20);list.add(21);list.add(22);
        int i = mapper.deleteForeach(list);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test_2() {
        SqlSession sqlSession = SqlSessionFactotyBuilderUtil.getSqlSession();
        Dao mapper = sqlSession.getMapper(Dao.class);
        Usee songJiang = new Usee("宋江", 1001, "梁山泊", 8000.0, "寨主", "男");
        Usee luJunYi = new Usee("卢俊义", 1002, "梁山泊", 7800.0, "副寨主", "男");
        Usee wuYong = new Usee("吴用", 1003, "梁山泊", 7500.0, "军师", "男");
        Usee linChong = new Usee("林冲", 1004, "梁山泊", 7000.0, "教头", "男");
        Usee wuSong = new Usee("武松", 1005, "清河县", 6800.0, "都头", "男");
        Usee sunErNiang = new Usee("孙二娘", 1010, "十字坡", 5800.0, "店主", "女");
        List<Usee> useeList = new ArrayList<>();
        useeList.add(songJiang);useeList.add(luJunYi);useeList.add(wuYong);useeList.add(linChong);useeList.add(wuSong);useeList.add(sunErNiang);
        int i = mapper.insertForeach(useeList);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
}
