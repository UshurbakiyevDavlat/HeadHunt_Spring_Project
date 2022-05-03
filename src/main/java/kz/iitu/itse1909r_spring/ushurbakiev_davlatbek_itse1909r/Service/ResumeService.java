package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.AOP.LogToken;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Resume;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class ResumeService {
    private ResumeRepository resumeRepository;

    @Autowired
    @Transactional(timeout = 10, rollbackFor = {SQLException.class})
    public void setResumeRepository(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @LogToken
    @Transactional(timeout = 10, rollbackFor = {SQLException.class})
    public List<Resume> getAllResume() throws SQLException {
        return this.resumeRepository.getResumes();
    }

    @LogToken
    @Transactional(timeout = 10, rollbackFor = {SQLException.class})
    public List<Resume> getResumeById() throws SQLException {
        return this.resumeRepository.getResumeById(1);
    }

    @LogToken
    @Transactional(timeout = 10, rollbackFor = {SQLException.class})
    @Cacheable(value = "resumes", key = "findByDescriptionIsNotNull")
    public List<Resume> findByDescriptionIsNotNull() throws SQLException {
        return this.resumeRepository.findByDescriptionIsNotNull();
    }

    @LogToken
    @Transactional(timeout = 10, rollbackFor = {SQLException.class})
    public List<Resume> findByEducationOrderByPhoneDesc(String education) throws SQLException {
        return this.resumeRepository.findByEducationOrderByPhoneDesc(education);
    }
}
