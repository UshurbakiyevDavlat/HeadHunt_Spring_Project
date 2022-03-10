package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.config;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.sql.SQLException;

@Configuration
@Slf4j
@ComponentScan(basePackages = "kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r")
@PropertySource("classpath:application.properties")
public class AppConfCandidates {

    private final CandidateService service;

    @Value("${spring.profiles.active:}")
    protected String activeProfile;

    @Autowired
    public AppConfCandidates(CandidateService service) {
        this.service = service;
    }

    @Bean
    public void getActiveProfileCandidate() {
        log.info(activeProfile);
    }

    @Bean
    public void getCandidateByAccountName() throws SQLException {
        service.findByAccountName("Raf").forEach(candidates -> log.info("Candidate: {}", candidates));
    }

    @Bean
    @Lazy
    public void getCandidates() throws SQLException {
        service.getCandidates().forEach(candidates -> log.info("Candidate: {}", candidates));
    }

    @Bean
    @DependsOn({"getCandidates"})
    public void findById() throws SQLException {
        service.findById(1).forEach(candidates -> log.info("Candidate: {}", candidates));
    }

    @Bean
    @DependsOn({"getCandidates"})
    public void findResumeById() throws SQLException {
        service.findResumeById(1);
    }

    @Bean
    @DependsOn({"getCandidates"})
    public void findAllByAttribute() throws SQLException {
        service.findAllByAttribute().forEach(candidates -> log.info("Candidate:{}", candidates));
    }

    @Bean
    @DependsOn({"getCandidates"})
    public void findByAge() throws SQLException {
        service.findByAge(22).forEach(candidates -> log.info("Candidate:{}", candidates));
    }

    @Bean
    @DependsOn({"getCandidates"})
    public void findByStatus() throws SQLException {
        service.findByStatus(1).forEach(candidates -> log.info("Candidate:{}", candidates));
    }
}
