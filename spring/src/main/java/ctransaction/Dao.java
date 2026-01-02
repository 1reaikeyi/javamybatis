package ctransaction;


public interface Dao {
    double update(Account account);
    Account selectById(String accountant);
}
