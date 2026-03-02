package web.dao;

import web.pojo.Account;

public interface Dao {
    public int update(String name, double money);
    public Account selectAccount(String name);
    public void selectAll();

}
