import CRUD.SqlSpringBoot;
import CRUD.BaseMapper.UseeMapper;
import CRUD.config.Gender;
import CRUD.resource.Usee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SqlSpringBoot.class)
public class TestEnum {
    @Autowired
    private UseeMapper useeMapper;
    @Test
    public void testEnum() {
        Usee usee = new Usee();
        usee.setName("宋江");
        usee.setWorkplace("骗子");
        usee.setId(20);
        usee.setStatus(1);
        usee.setGender(Gender.GENTlEMAN);
        int i = useeMapper.updateById(usee);
        System.out.println(i);
    }
}
