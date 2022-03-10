package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.AOP.LogToken;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CandidateService {

    private CandidateRepository candidateRepository;

    @Autowired
    public void setCandidateServiceRepo(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @LogToken
    public List<Candidates> findByAccountName(String name) {
        return this.candidateRepository.findByAccountName(name);
    }

    @LogToken
    public void findResumeById(int id) throws SQLException {
        this.candidateRepository.findResumeById(id);
    }

    @LogToken
    public List<Candidates> getCandidates() throws SQLException {
        return this.candidateRepository.getCandidates();
    }

    @LogToken
    public List<Candidates> findById(int id) throws SQLException {
        return this.candidateRepository.findById(id);
    }

    @LogToken
    @Cacheable(value = "candidates_open", key = "status")
    public List<Candidates> findByStatus(int status) throws SQLException {
        return this.candidateRepository.findByStatus(status);
    }

    @LogToken
    @Cacheable(value = "candidates_adults", key = "age")
    public List<Candidates> findByAge(int age) throws SQLException {
        return this.candidateRepository.findByAge(age);
    }

    @LogToken
    public List<Candidates> findAllByAttribute() {
        return this.candidateRepository.findAllByAttribute(new Date());
    }
}
