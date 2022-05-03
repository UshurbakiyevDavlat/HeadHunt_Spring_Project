package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;
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
                        "where s.candidate_id = :id"
        ),
        @NamedQuery(name = "Candidates.findResumeById",
                query = "select  s from Candidates s " +
                        "inner join fetch s.resume a " +
                        "where s.candidate_id = :id"),
        @NamedQuery(name = "Candidates.findByAge",
                query = "select distinct s from Candidates s " +
                        "where s.age >= :age"),
        @NamedQuery(name = "Candidates.findByStatus",
                query = "select distinct s from Candidates s " +
                        "where s.status = :status"),
})

public class Candidates {

    //    @Min(value = 1, message = ">1")
//    @Max(100)
    @NotNull
    @Size(max = 250)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "candidate_id", nullable = false)
    private Integer candidate_id;

    @Column(name = "account_name", nullable = false, length = 60)
    private String accountName;

    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "status", nullable = false)
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "password", length = 100)
    private String password;

    @Override
    public String toString() {
        return "Candidates{" +
                "candidate_id=" + candidate_id +
                ", accountName='" + accountName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", status=" + status +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    @CreatedBy
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    Resume resume;

    @CreatedDate
    private Date created_at;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "candidate_id")
    private List<Vacancy> vacancies = new ArrayList<>();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public Candidates(Integer candidate_id, String accountName, String email, Integer age, Integer status, Resume resume) {
        this.candidate_id = candidate_id;
        this.accountName = accountName;
        this.email = email;
        this.age = age;
        this.status = status;
        this.resume = resume;
    }

    public Candidates(String accountName, String password, String email) {
        this.accountName = accountName;
        this.email = email;
        this.password = password;
        this.age = 19;
        this.status = 1;
        this.resume = null;
        this.role = null;
        this.created_at = Date.valueOf(LocalDate.now());
    }

    public Candidates(Integer candidate_id, String accountName, String password, String email) {
        this.candidate_id = candidate_id;
        this.accountName = accountName;
        this.password = password;
        this.email = email;
        this.age = 18;
        this.status = 1;
        this.resume = null;
        this.role = null;
    }

    public Candidates() {

    }

    public Candidates(String name, Integer age) {
        this.accountName = name;
        this.age = age;
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

    public Integer getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(Integer candidate_id) {
        this.candidate_id = candidate_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}