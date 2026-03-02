package web.dao;

import web.Util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import web.pojo.Account;
import java.util.HashMap;
import java.util.List;

public class DaoImpl implements Dao {

    @Override
    public Account selectAccount(String name) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        HashMap<String,String> nameMap = new HashMap<>();
        nameMap.put("name",name);
        Account account = sqlSession.selectOne("selectAccount",nameMap);
        return account;
    }

    @Override
    public void selectAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        List<Account> accounts = sqlSession.selectList("selectAll");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Override
    public int update(String name,double money) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);
        int count = sqlSession.update("update",account);
        return count;
    }
}
