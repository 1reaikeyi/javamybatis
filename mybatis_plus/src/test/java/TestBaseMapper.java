
import CRUD.SqlSpringBoot;
import CRUD.BaseMapper.UseeMapper;
import CRUD.resource.Usee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = SqlSpringBoot.class)
public class TestBaseMapper {
    @Autowired
    private UseeMapper useeMapper;
    @Test
    public void testCRUD() {
        List<Usee> usees = useeMapper.selectList(null);
        for (Usee usee : usees) {
            System.out.println(usee);
        }
    }
    @Test
    public void test_1() {
        Usee usee = new Usee();
        usee.setName("宋江");
        usee.setWorkplace("骗子");
        int i = useeMapper.insert(usee);
        System.out.println(i);
    }
    @Test
    public void test_2() {
        Usee i = useeMapper.selectById(1);
        System.out.println(i);
    }

    @Test
    public void test_3() {
        Usee usee = new Usee();
        usee.setId(1);
        usee.setSalary(500.0);
        int i = useeMapper.updateById(usee);
        System.out.println(i);
    }

    @Test
    public void test_4() {
        int i = useeMapper.deleteById(20);
        System.out.println(i);
    }

    @Test
    public void test_mapperxml() {
        System.out.println(useeMapper.selectByName("孙悟空"));
    }
}
