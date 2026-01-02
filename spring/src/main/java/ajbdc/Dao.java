package ajbdc;

import bmybatis.AccountServer;

import java.util.List;

public interface Dao {
    int insert(AccountServer accountServer);
    int update(AccountServer accountServer);
    int delete(String accountant);
    AccountServer selectById(String accountant);
    List<AccountServer> selectAll();
}
