package ctransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DaoImpl implements Dao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public double update(Account account) {
        String sql = "update account set money = ? where name = ?";
        int update = jdbcTemplate.update(sql, account.getmoney(), account.getName());
        return update;
    }

    @Override
    public Account selectById(String accountant) {
        String sql = "select * from account where name = ?";
        Account nameAccountant = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), accountant);
        return nameAccountant;
    }
}
