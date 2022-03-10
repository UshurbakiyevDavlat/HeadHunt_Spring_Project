package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.AOP.LogToken;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Vacancy;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.repository.VacancyRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class VacancyService {
    private VacancyRepository vacancyRepository;

    @Autowired
    public void setVacancyRepository(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @LogToken
    @Cacheable(value = "vacancies")
    public List<Vacancy> getAllVacancies() throws SQLException {
        return this.vacancyRepository.getVacancies();
    }
}
