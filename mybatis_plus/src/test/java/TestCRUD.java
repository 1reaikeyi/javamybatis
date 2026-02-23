
import base.CRUD.useeMapper;
import base.resource.Usee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = base.MybatisSpringBoot.class)
public class TestCRUD {
    @Autowired
    private useeMapper useeMapper;
    @Test
    public void testCRUD() {
        List<Usee> usees = useeMapper.selectList(null);
        for (Usee usee : usees) {
            System.out.println(usee);
        }
    }
    @Test
    public void test_1() {
        Usee usee = new Usee("宋江",20,"梁山",800.0,"骗子","大侠");
        int i = useeMapper.insert(usee);
        System.out.println(i);
    }
    @Test
    public void test_2() {
        int i = useeMapper.deleteById(20);
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
        Usee i = useeMapper.selectById(1);
        System.out.println(i);
    }
}
