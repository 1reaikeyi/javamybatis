import CRUD.Iserver.UseeService;
import CRUD.SqlSpringBoot;
import CRUD.resource.Usee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = SqlSpringBoot.class)
public class TestIService {
    @Autowired
    private UseeService useeService;
    @Test
    public void test_1() {
        Usee usee = new Usee(20,"宋江","梁山",800.0,"骗子","大侠");
        boolean i = useeService.save(usee);
        System.out.println(i);
    }
    @Test
    public void test_2() {
        Usee usee = useeService.getById(5);
        System.out.println(usee);
        List<Usee> list = useeService.list();
        System.out.println(list);
    }
    @Test
    public void test_3() {
        Usee usee = new Usee();
        usee.setId(5);
        usee.setSalary(200.0);
        Boolean i = useeService.updateById(usee);
        System.out.println(i);
    }
    @Test
    public void test_4() {
        boolean i = useeService.removeById(20);
        System.out.println(i);
    }

}
