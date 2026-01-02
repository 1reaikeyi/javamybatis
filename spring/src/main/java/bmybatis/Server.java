package bmybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("server")
public class Server {
    @Autowired
    private Dao dao;

    public int insert(AccountServer accountServer) {
        return dao.insert(accountServer);
    }

    public int update(AccountServer accountServer) {
        return dao.update(accountServer);
    }

    public int delete(String accountant) {
        return dao.delete(accountant);
    }

    public AccountServer selectById(String accountant) {
        return dao.selectById(accountant);
    }

    public List<AccountServer> selectAll() {
        return dao.selectAll();
    }

    public void withdraw(String from, String to, int money) {
        AccountServer fromAccountServer = dao.selectById(from);
        AccountServer toAccountServer = dao.selectById(to);

        fromAccountServer.setmoney(fromAccountServer.getmoney() - money);
        toAccountServer.setmoney(toAccountServer.getmoney() + money);

        int updateFrom = dao.update(fromAccountServer);
        int updateTo = dao.update(toAccountServer);

        if (updateFrom != 1) {
            throw new RuntimeException("转出账户更新失败");
        }
        if (updateTo != 1) {
            throw new RuntimeException("转入账户更新失败");
        }
    }
}

