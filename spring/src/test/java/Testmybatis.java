import bmybatis.AccountServer;
import bmybatis.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Testmybatis {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("mybatis/mybatisbean.xml");
        Server service = ac.getBean("drawMoney", Server.class);
        service.withdraw("张三", "李四", 100);
        List<AccountServer> accountServers = service.selectAll();
        for (AccountServer accountServer : accountServers) {
            System.out.println(accountServer);
        }
    }
}
