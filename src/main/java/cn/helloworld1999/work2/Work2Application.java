package cn.helloworld1999.work2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("cn.helloworld1999.work2.mapper")
@EnableTransactionManagement
public class Work2Application {

    public static void main(String[] args) {
        SpringApplication.run(Work2Application.class, args);
    }

}
