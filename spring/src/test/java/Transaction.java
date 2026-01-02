import ctransaction.DrawMoney;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Transaction {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc/jdbc.xml");
        DrawMoney drawMoney = context.getBean("drawMoney", DrawMoney.class);
        drawMoney.draw("张三", "李四", 100);
    }
    @Test
    public void testAnnotion(){
        ApplicationContext context = new AnnotationConfigApplicationContext("ctransaction");
        DrawMoney drawMoney = context.getBean("drawMoney", DrawMoney.class);
        drawMoney.draw("张三", "李四", 100);
    }
}
