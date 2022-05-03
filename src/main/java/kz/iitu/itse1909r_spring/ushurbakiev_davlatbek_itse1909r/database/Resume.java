package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Resume.getResumeById",
                query = "select s from Resume s " +
                        "where s.id = :id"
        )
}
)
public class Resume {
    @Id
    @Min(value = 1, message = ">1")
    @Max(100)
    @NotNull
    @Size(max = 250)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "education", nullable = false, length = 100)
    private String education;

    @Column(name = "phone", nullable = false, length = 100)
    private String phone;

    @CreatedDate
    private Date created_at;

    @CreatedBy
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "resume_id")
    private List<Candidates> candidateses = new ArrayList<>();

    public List<Candidates> getCandidateses() {
        return candidateses;
    }

    public void setCandidateses(List<Candidates> candidateses) {
        this.candidateses = candidateses;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", education='" + education + '\'' +
                ", phone='" + phone + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}

