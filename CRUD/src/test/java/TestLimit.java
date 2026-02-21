import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import limit.Dao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import resource.SqlSessionFactotyBuilderUtil;
import resource.Usee;

import java.util.List;

public class TestLimit {
    @Test
    public void test_1() {
        SqlSession sqlSession = SqlSessionFactotyBuilderUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        int pageNum = 2;
        int pageSize = 3;
        int start = (pageNum - 1) * pageSize;
        List<Usee> usees = dao.selectPage(start, pageSize);
        for (Usee usee : usees) {
            System.out.println(usee);
        }
        sqlSession.close();
    }
    @Test
    public void test_2() {
        SqlSession sqlSession = SqlSessionFactotyBuilderUtil.getSqlSession();
        Dao dao = sqlSession.getMapper(Dao.class);
        int pageNum = 2;
        int pageSize = 3;
        PageHelper.startPage(pageNum,pageSize);
        List<Usee> usees = dao.selectAll();
        for (Usee usee : usees) {
            System.out.println(usee);
        }
        PageInfo<Usee> pageInfo = new PageInfo<Usee>(usees,10);
        System.out.println(pageInfo);
        sqlSession.close();
        /**
         * PageInfo{pageNum=2, pageSize=3, size=3, startRow=4, endRow=6, total=20, pages=7,
         * list=Page{count=true, pageNum=2, pageSize=3, startRow=3, endRow=6, total=20, pages=7, reasonable=false, pageSizeZero=false}
         * [config.Usee{name='宋江', id=1001, workplace='梁山泊', salary=8000.0, job='寨主', gender='男'},
         * config.Usee{name='卢俊义', id=1002, workplace='梁山泊', salary=7800.0, job='副寨主', gender='男'},
         * config.Usee{name='吴用', id=1003, workplace='梁山泊', salary=7500.0, job='军师', gender='男'}],
         * prePage=1, nextPage=3, isFirstPage=false, isLastPage=false, hasPreviousPage=true, hasNextPage=true, navigatePages=10, navigateFirstPage=1, navigateLastPage=7, navigatepageNums=[1, 2, 3, 4, 5, 6, 7]}
         */
    }
}
