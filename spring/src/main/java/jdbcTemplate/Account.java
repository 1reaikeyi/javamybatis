package jdbcTemplate;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private String accountant;
    private int money;
    private int id;

    public Account() {
    }

    public Account(String accountant, int money, int id) {
        this.accountant = accountant;
        this.money = money;
        this.id = id;
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
                ", id=" + id +
                '}';
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountant() {
        return accountant;
    }

    public void setAccountant(String accountant) {
        this.accountant = accountant;
    }
}
