package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.repository;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Resume;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Resume, Long> {

    @Query(value = "SELECT s from Vacancy s")
    List<Vacancy> getVacancies() throws SQLException;
}
