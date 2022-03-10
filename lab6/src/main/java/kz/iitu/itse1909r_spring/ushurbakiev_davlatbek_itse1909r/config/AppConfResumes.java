package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.config;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.ResumeService;
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
public class AppConfResumes {
    @Value("${spring.profiles.active:}")
    protected String activeProfile;

    private final ResumeService service;

    @Autowired
    public AppConfResumes(ResumeService service) {
        this.service = service;
    }

    @Bean
    public void getActiveProfileResume() {
        log.info(activeProfile);
    }

    @Bean
    public void getAllResumes() throws SQLException {
        service.getAllResume().forEach(resume -> log.info("Resume: {}", resume));
    }

    @Bean
    public void getResumeById() throws SQLException {
        service.getResumeById().forEach(resume -> log.info("Resume: {}", resume));
    }

    @Bean
    public void findByDescriptionIsNotNull() throws SQLException {
        service.findByDescriptionIsNotNull().forEach(resume -> log.info("Resume: {}", resume));
    }

    @Bean
    public void findByEducationOrderByPhoneDesc() throws SQLException {
        service.findByEducationOrderByPhoneDesc("IITU 3 course ITSE1909R group").forEach(resume -> log.info("Resume: {}", resume));;
    }
}
