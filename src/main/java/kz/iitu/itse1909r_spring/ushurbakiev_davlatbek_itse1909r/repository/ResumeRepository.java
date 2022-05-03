package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.repository;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Repository

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    @Transactional(timeout = 10)
    @Query(value = "SELECT s from Resume s")
    List<Resume> getResumes() throws SQLException;

    List<Resume> getResumeById(Integer id) throws SQLException;

    List<Resume> findByDescriptionIsNotNull() throws SQLException;

    @Query("select u from #{#entityName} u where u.education = ?1")
    List<Resume> findByEducationOrderByPhoneDesc(String education) throws SQLException;
}
