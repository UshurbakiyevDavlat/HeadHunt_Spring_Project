package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.sql.SQLException;

//@EnableAutoConfiguration
//@ComponentScan
//@Import({AppConfCandidates.class, AppConfig.class})
@Slf4j
@EnableAspectJAutoProxy
@SpringBootApplication
public class Lab12Application {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Lab12Application.class, args);
    }
}
