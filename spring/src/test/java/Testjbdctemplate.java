import jbdc.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.junit.Test;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Testjbdctemplate {
    @Test
    public  void testInsert() {
        ApplicationContext ac = new AnnotationConfigApplicationContext("jbdc");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into account(name,money,id) values(?,?,?)";
        int update = jdbcTemplate.update(sql, "马小六", 1000, "003");
        System.out.println(update);
    }
    @Test
    public  void testUpdate() {
        ApplicationContext ac = new AnnotationConfigApplicationContext("jbdc");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update account set money=? where name=?";
        int update = jdbcTemplate.update(sql, 10000, "马小六");
        System.out.println(update);
    }
        @Test
        public  void testDelete() {
            ApplicationContext ac = new AnnotationConfigApplicationContext("jbdc");
            JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
            String sql = "delete from account where name=?";
            int update = jdbcTemplate.update(sql, "马小六");
            System.out.println(update);
        }
        @Test
        public  void testSelectAccount() {
            ApplicationContext ac = new AnnotationConfigApplicationContext("jbdc");
            JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
            String sql = "select name, money from account where name = ?";
            Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), "马小六");
            System.out.println(account);
        }
        @Test
        public  void testSelectAll() {
            ApplicationContext ac = new AnnotationConfigApplicationContext("jbdc");
            JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
            String sql = "select name, money from account";
            List<Account> accountDaos = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
            System.out.println(accountDaos);
        }
        @Test
        public  void testCount() {
            ApplicationContext ac = new AnnotationConfigApplicationContext("jbdc");
            JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
            String sql = "select count(*) from account";
            int count = jdbcTemplate.queryForObject(sql, Integer.class);
            System.out.println(count);
        }
        //批量
        @Test
        public  void testBatchInsert() {
            ApplicationContext ac = new AnnotationConfigApplicationContext("jbdc");
            JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
            String sql = "insert into account(name,money) values(?,?)";
            Account account1 = new Account("马小六",1000);
            Account account2 = new Account("王小五",1000);
            ArrayList<Object[]> accounts = new ArrayList<>();
            accounts.add(new Object[]{"马小六",1000});
            accounts.add(new Object[]{"王小五",1000});
            int[] count = jdbcTemplate.batchUpdate(sql,accounts);
            System.out.println(count.toString());
        }
        //处理复杂的JDBC操作
        @Test
        public  void testCallback() {
            ApplicationContext ac = new AnnotationConfigApplicationContext("jbdc");
            JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
            String sql = "insert into account(name,money) values(?,?)";
             jdbcTemplate.execute(sql, new PreparedStatementCallback<Object>() {
                @Override
                public Object doInPreparedStatement(PreparedStatement ps) throws SQLException {
                    ps.setString(1, "马小六");
                    ps.setInt(2, 10);
                    return ps.executeUpdate();
                }
            });

        }

}
