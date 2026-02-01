package service;

import Util.SqlSessionUtil;
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
//        //模拟异常
//        i=0;
        if (i > 0 && j > 0) {
            System.out.println("转账成功");
            SqlSessionUtil.getSqlSession().commit();
            SqlSessionUtil.closeSqlSession();
        }else {
            System.out.println("转账失败");
            SqlSessionUtil.getSqlSession().rollback();
            SqlSessionUtil.closeSqlSession();
        }

    }
}
