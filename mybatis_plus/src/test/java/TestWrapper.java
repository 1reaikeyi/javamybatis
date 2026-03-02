import CRUD.SqlSpringBoot;
import CRUD.baseMapper.UseeMapper;
import CRUD.resource.Usee;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@SpringBootTest(classes = SqlSpringBoot.class)
public class TestWrapper {
    @Autowired
    private UseeMapper useeMapper;
    @Test
    public void test_eq() {
        QueryWrapper<Usee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","孙悟空");
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_equal() {
        LambdaQueryWrapper<Usee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Usee::getName,"孙悟空");
        List<Usee> list = useeMapper.selectList(lambdaQueryWrapper);
        System.out.println(list);

    }
    @Test
    public void test_null_1() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Usee::getName,null);
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_null_2() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
//        condition = false → 不添加这个条件 ，SQL 中完全没有 WHERE name = ? 这个条件
        queryWrapper.eq( false,Usee::getName,null);
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_not_equal() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(Usee::getName,"孙悟空");
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_many() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Usee::getSalary,500.0)
                .eq(Usee::getName,"孙悟空");
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_greater_than() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(Usee::getSalary,500.0);
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_greater_than_equal() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(Usee::getSalary,500.0);
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_less_than(){
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.lt(Usee::getSalary,500.0);
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_less_than_equal() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.le(Usee::getSalary,500.0);
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_between() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.between(Usee::getSalary,500.0,1000.0);
//        SELECT id,name,workplace,salary,job,gender FROM shuihu WHERE (salary BETWEEN ? AND ?)
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_notbetween() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.notBetween(Usee::getSalary,500.0,1000.0);
//        SELECT id,name,workplace,salary,job,gender FROM shuihu WHERE (salary NOT BETWEEN ? AND ?)
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_like() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Usee::getName,"悟");
//        queryWrapper.likeLeft(Usee::getName,"空");
//        queryWrapper.likeRight(Usee::getName,"孙");
//        对于--》test_not_like()
//        queryWrapper.notLike(Usee::getName,"孙");
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_in() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Usee::getSalary,500.0,200.0);
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_not_in() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.notIn(Usee::getSalary,500.0);
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_inSql1() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.inSql(Usee::getSalary,"500,200");
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_inSql2() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.inSql(Usee::getSalary,"select salary from shuihu where salary > 500");
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_groupBy() {
        QueryWrapper<Usee> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("salary, COUNT(*) as num")
                .lambda()
                .groupBy(Usee::getSalary);
        List<Map<String, Object>> list = useeMapper.selectMaps(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_orderBY() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.orderByAsc(Usee::getSalary);
//        queryWrapper.orderByDesc(Usee::getSalary);
        queryWrapper.orderBy(true,true,Usee::getSalary);
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_apply() {
//        指定where
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.apply("id = 1");
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_and_1() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(Usee::getSalary,500.0)
                .le(Usee::getId,7);
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_and_2() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(Usee::getSalary,500.0).and(wrapper -> wrapper.le(Usee::getId,7));
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_func() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.func(new Consumer<LambdaQueryWrapper<Usee>>() {
            @Override
            public void accept(LambdaQueryWrapper<Usee> useeLambdaQueryWrapper) {
                if(true){
                    useeLambdaQueryWrapper.orderByAsc(Usee::getSalary);
                } else {
                    useeLambdaQueryWrapper.orderByDesc(Usee::getSalary);
                }
            }
        });
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_nested() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.nested(wrapper -> wrapper.eq(Usee::getSalary,500.0))
                .nested(wrapper -> wrapper.le(Usee::getId,7));
        List<Usee> list = useeMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void test_last() {}


}
