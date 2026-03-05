package CRUD;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("CRUD.BaseMapper")
public class SqlSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(SqlSpringBoot.class, args);
    }
}
