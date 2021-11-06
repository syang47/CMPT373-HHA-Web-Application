package hha.website.models;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="casestudies")
public class CaseStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String department; 

    @Column
    private String title;

    @Column
    private LocalDate date;

    @Column
    private Integer points;

    @Column
    private Boolean status;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String object) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Boolean getSubmissionStatus() {
        return status;
    }

    public void setSubmissionStatus(Boolean status) {
        this.status = status;
    }
}
