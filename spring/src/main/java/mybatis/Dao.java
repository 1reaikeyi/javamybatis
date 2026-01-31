package mybatis;

import java.util.List;

public interface Dao {
    int update(Account accountServer);
    Account selectById(String accountant);
    List<Account> selectAll();
}
