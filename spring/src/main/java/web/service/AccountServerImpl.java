package web.service;

import web.Util.SqlSessionUtil;
import web.dao.Dao;
import web.dao.DaoImpl;
import web.pojo.Account;

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
            SqlSessionUtil.getSqlSession().close();
        }else {
            System.out.println("转账失败");
            SqlSessionUtil.getSqlSession().rollback();
            SqlSessionUtil.getSqlSession().close();
        }

    }
}

