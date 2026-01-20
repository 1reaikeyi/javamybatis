import config.ExcuteQuery;
import config.ExecuteUpdate;
import config.Usee;
import org.junit.Test;

public class Testjdbc {
    @org.junit.Test
    public void test1() {
        ExcuteQuery query = new ExcuteQuery();
        query.selectAll();
    }
    @Test
    public void test2() {
        ExcuteQuery query = new ExcuteQuery();
        query.selectById(1);
    }
    @Test
    public void test3() {
        ExecuteUpdate update = new ExecuteUpdate();
        Usee usee = new Usee("张飞", 10, "北京", 10000.0, "拉煤", "男");
        update.insert(usee);
    }
    @Test
    public void test4() {
        ExecuteUpdate update = new ExecuteUpdate();
        update.delete(10);
    }

    @Test
    public void test5() {
        ExecuteUpdate update = new ExecuteUpdate();
        update.update("10", "上海");
    }




}