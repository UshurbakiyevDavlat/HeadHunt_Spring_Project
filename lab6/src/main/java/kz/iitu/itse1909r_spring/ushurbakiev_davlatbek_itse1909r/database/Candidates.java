package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Table(name = "candidates")
@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Candidates.getCandidates",
                query = "select s from Candidates s "
        ),
        @NamedQuery(name = "Candidates.findById",
                query = "select s from Candidates s " +
                        "where s.id = :id"
        ),
        @NamedQuery(name = "Candidates.findResumeById",
                query = "select  s from Candidates s " +
                        "inner join fetch s.resume a " +
                        "where s.id = :id"),
        @NamedQuery(name = "Candidates.findByAge",
                query = "select distinct s from Candidates s " +
                        "where s.age >= :age"),
        @NamedQuery(name = "Candidates.findByStatus",
                query = "select distinct s from Candidates s " +
                        "where s.status = :status"),
})

public class Candidates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id", nullable = false)
    private Integer id;

    @Column(name = "account_name", nullable = false, length = 60)
    private String accountName;

    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Override
    public String toString() {
        return "Candidates{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "resume_id", nullable = false)
    Resume resume;

    @CreatedDate
    private Date created_at;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "candidate_id")
    private List<Vacancy> vacancies = new ArrayList<>();


    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public Candidates(Integer id, String accountName, String email, Integer age, Integer status, Resume resume) {
        this.id = id;
        this.accountName = accountName;
        this.email = email;
        this.age = age;
        this.status = status;
        this.resume = resume;
    }

    public Candidates() {

    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}