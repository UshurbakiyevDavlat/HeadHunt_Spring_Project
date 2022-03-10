package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.config.AppConfCandidates;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.sql.SQLException;

@EnableAutoConfiguration
@EnableAspectJAutoProxy
@ComponentScan
@Import({AppConfCandidates.class, AppConfig.class})
@Slf4j
public class Lab6Application {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Lab6Application.class, args);
    }
}
