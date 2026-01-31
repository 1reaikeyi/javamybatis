package mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("server")
public class Server {
    @Autowired
    private Dao dao;
    public int update(Account account) {
        return dao.update(account);
    }
    public Account selectById(String accountant) {
        return dao.selectById(accountant);
    }

    public List<Account> selectAll() {
        return dao.selectAll();
    }

    public void withdraw(String from, String to, int money) {
        Account fromAccount = dao.selectById(from);
        Account toAccount = dao.selectById(to);
        dao.selectAll();
        fromAccount.setmoney(fromAccount.getmoney() - money);
        toAccount.setmoney(toAccount.getmoney() + money);
        dao.selectAll();
        int i = dao.update(fromAccount);
        int j = dao.update(toAccount);
        System.out.println(i);
        System.out.println(j);
    }
}

