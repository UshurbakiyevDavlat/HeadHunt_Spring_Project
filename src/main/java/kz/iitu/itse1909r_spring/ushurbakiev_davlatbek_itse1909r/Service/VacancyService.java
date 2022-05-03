package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.AOP.LogToken;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Vacancy;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class VacancyService {
    private VacancyRepository vacancyRepository;

    @Autowired
    @Transactional(timeout = 10, rollbackFor = {SQLException.class})
    public void setVacancyRepository(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @LogToken
    @Transactional(timeout = 10, rollbackFor = {SQLException.class})
    @Cacheable(value = "vacancies")
    public List<Vacancy> getAllVacancies() throws SQLException {
        return this.vacancyRepository.getVacancies();
    }
}
