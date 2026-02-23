package base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("base.CRUD")
public class MybatisSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringBoot.class, args);
    }
}
