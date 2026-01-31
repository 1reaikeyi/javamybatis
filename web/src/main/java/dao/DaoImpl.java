package dao;

import Util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Account;

import java.util.List;

public class DaoImpl implements Dao {

    @Override
    public Account selectAccount(String name) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Account setAccount = new Account();
        setAccount.setName(name);
        Account account = sqlSession.selectOne("selectAccount",setAccount);
        return account;
    }



    @Override
    public void selectAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        List<Account> accounts = sqlSession.selectList("selectAll");
        sqlSession.close();
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
        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
