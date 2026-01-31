package dao;

import pojo.Account;

public interface Dao {
    public int update(String name, double money);
    public Account selectAccount(String name);
    public void selectAll();

}
