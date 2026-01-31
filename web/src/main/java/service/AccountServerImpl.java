package service;

import dao.Dao;
import dao.DaoImpl;
import pojo.Account;

public class AccountServerImpl implements AccountServer {
    private Dao dao = new DaoImpl();
    @Override
    public void transfer(String fromName, String toName, Double money) {
        Account fromAccount = dao.selectAccount(fromName);
        Account toAccount = dao.selectAccount(toName);
        dao.selectAll();
        int i = dao.update(fromAccount.getName(), fromAccount.getMoney() - money);
        int j = dao.update(toAccount.getName(), toAccount.getMoney() + money);
        if (i > 0 && j > 0) {
            System.out.println("转账成功");
        }
        dao.selectAll();

    }
}
