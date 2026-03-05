import CRUD.SqlSpringBoot;
import CRUD.BaseMapper.UseeMapper;
import CRUD.resource.Usee;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = SqlSpringBoot.class)
public class Testonly {
    @Autowired
    private UseeMapper useeMapper;
    @Test
    public void testDel() {
        LambdaQueryWrapper<Usee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Usee::getName,"宋江");
        int deleteCount = useeMapper.delete(queryWrapper);
        System.out.println(deleteCount);
    }
    @Test
    public void testauto() {
        Usee usee = new Usee();
        usee.setId(20);
        usee.setWorkplace("梁山");
        usee.setName("宋江");
        useeMapper.updateById(usee);
    }
    @Test
    public void testJSON() {
        Usee usee = new Usee();
        usee.setId(20);
        Map<String,String> map = new HashMap<>();
        map.put("first","滴滴");
        map.put("第二份","外包");
        usee.setJob(map);
        useeMapper.updateById(usee);
    }
}
