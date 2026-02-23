package mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
    @Transactional(rollbackFor = RuntimeException.class)
    public void withdraw(String from, String to, int money) {
        try {
            Account fromAccount = dao.selectById(from);
            Account toAccount = dao.selectById(to);
            if (fromAccount == null) {
                throw new RuntimeException("转出账户[" + from + "]不存在");
            }
            if (toAccount == null) {
                throw new RuntimeException("转入账户[" + to + "]不存在");
            }
            if (fromAccount.getmoney() < money) {
                throw new RuntimeException("转出账户[" + from + "]余额不足，当前余额：" + fromAccount.getmoney());
            }
            dao.selectAll();
            fromAccount.setmoney(fromAccount.getmoney() - money);
            toAccount.setmoney(toAccount.getmoney() + money);
            int i = dao.update(fromAccount);
            int j = dao.update(toAccount);
//            模拟RuntimeExpection
//            i = -1;
            if (i <= 0 || j <= 0) {
                dao.selectAll();
                throw new RuntimeException("rollback");
            }
        } catch (Exception e) {
            throw new RuntimeException("转账失败"+e.getMessage());
        }
    }
}

