import adata.ToexcuteQuery;
import adata.Toexecutedel;
import adata.toinserts;
import adata.toupdate;

public class Test {
    @org.junit.Test
    public void test3() {
        toinserts insert = new toinserts();
        insert.insert();
        System.out.println("------------------");
    }

    @org.junit.Test
    public void test2() {
        Toexecutedel del = new Toexecutedel();
        del.del();
        System.out.println("------------------");
    }
    @org.junit.Test
    public void test4() {
        toupdate update = new toupdate();
        update.update();
        System.out.println("------------------");
    }
    @org.junit.Test
    public void test() {
        ToexcuteQuery query = new ToexcuteQuery();
        query.query();
        System.out.println("------------------");
    }


}