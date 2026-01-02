package ajbdc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component
public class AccountDao {
    private String accountant;
    private int money;

    @Override
    public String toString() {
        return "Account{" +
                "accountant='" + accountant + '\'' +
                ", money=" + money +
                '}';
    }

    public AccountDao() {

    }

    public AccountDao(String accountant, int money) {
        this.accountant = accountant;
        this.money = money;
    }

    public String getAccountant() {
        return accountant;
    }

    public void setAccountant(String accountant) {
        this.accountant = accountant;
    }

    public int getmoney() {
        return money;
    }

    public void setmoney(int money) {
        this.money = money;
    }
}
