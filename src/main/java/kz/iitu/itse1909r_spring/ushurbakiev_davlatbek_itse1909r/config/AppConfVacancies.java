package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.config;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.VacancyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.SQLException;

@Configuration
@Slf4j
@PropertySource("classpath:application.properties")
public class AppConfVacancies {
    @Value("${spring.profiles.active:}")
    protected String activeProfile;

    private final VacancyService service;

    @Autowired
    public AppConfVacancies(VacancyService service) {
        this.service = service;
    }

    @Bean
    public void getActiveProfileVacancy() {
        log.info(activeProfile);
    }

    @Bean
    public void getAllVacancies() throws SQLException {
        service.getAllVacancies().forEach(vacancy -> log.info("Resume: {}", vacancy));
    }
}
