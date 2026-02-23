import mybatis.Account;
import mybatis.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Testmybatis {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mybatis-bean.xml");
        Server service = applicationContext.getBean("drawMoney", Server.class);
        service.withdraw("张三", "李四", 100);
        List<Account> accounts = service.selectAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
