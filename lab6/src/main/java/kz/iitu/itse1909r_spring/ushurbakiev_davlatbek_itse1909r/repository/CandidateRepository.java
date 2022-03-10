package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.repository;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidates, Long> {

    @Transactional(timeout = 10)
    @Query(value = "SELECT s from Candidates s")
    List<Candidates> findAllc();

    @Query("select u from #{#entityName} u where u.created_at = ?1")
    List<Candidates> findAllByAttribute(Date attribute);

    List<Candidates> findByAccountName(String firstName);


    List<Candidates> getCandidates() throws SQLException;

    List<Candidates> findById(int id) throws SQLException;

    void findResumeById(int id) throws SQLException;

    List<Candidates> findByAge(int age) throws SQLException;

    List<Candidates> findByStatus(int status) throws SQLException;

}
