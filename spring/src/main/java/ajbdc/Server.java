package ajbdc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Server implements Dao{
    @Autowired
    private Dao dao;

    public int insert(bmybatis.AccountServer accountServer) {
        return dao.insert(accountServer);
    }

    public int update(bmybatis.AccountServer accountServer) {
        return dao.update(accountServer);
    }

    public int delete(String accountant) {
        return dao.delete(accountant);
    }

    public bmybatis.AccountServer selectById(String accountant) {
        return dao.selectById(accountant);
    }

    public List<bmybatis.AccountServer> selectAll() {
        return dao.selectAll();
    }
    public void withdraw(String from, String to, int money) {
        // 2. 查询转出和转入账户
        bmybatis.AccountServer fromAccountServer = dao.selectById(from);
        bmybatis.AccountServer toAccountServer = dao.selectById(to);

        // 3. 校验账户是否存在
        if (fromAccountServer == null) {
            throw new RuntimeException("转出账户不存在: " + from);
        }
        if (toAccountServer == null) {
            throw new RuntimeException("转入账户不存在: " + to);
        }

        // 5. 执行转账逻辑
        fromAccountServer.setmoney(fromAccountServer.getmoney() - money);
        toAccountServer.setmoney(toAccountServer.getmoney() + money);

        // 6. 执行更新并校验结果
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