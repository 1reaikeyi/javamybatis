package mybatis;

import org.springframework.stereotype.Component;
@Component
public class Account {
    private String accountant;
    private int money;
    public Account() {
    }

    public Account(String accountant, int money) {
        this.accountant = accountant;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountant='" + accountant + '\'' +
                ", money=" + money +
                '}';
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
