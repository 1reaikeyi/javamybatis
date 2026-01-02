package ctransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DrawMoney{
    @Autowired
    private Dao dao;

    public double update(Account account) {
       return dao.update(account);
    }

    public Account selectById(String accountant) {
        return dao.selectById(accountant);
    }
    @Transactional(rollbackFor = {RuntimeException.class})
    public void draw(String from, String to, double money) {
        Account fromAccount = selectById(from);
        Account toAccount = selectById(to);
        fromAccount.setmoney(fromAccount.getmoney() - money);
        toAccount.setmoney(toAccount.getmoney() + money);

        // 累积两次更新的结果
        int count = 0;
        count += update(fromAccount);
        count += update(toAccount);

        if(count == 2){
            System.out.println("转账成功");
            System.out.println(fromAccount);
            System.out.println(toAccount);
        }else{
            System.out.println("转账失败");
            // 业务逻辑失败，抛出RuntimeException触发事务回滚
            throw new RuntimeException("转账失败，事务回滚");
        }


    }

}
