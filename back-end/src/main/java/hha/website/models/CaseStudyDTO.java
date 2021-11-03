package hha.website.models;

import java.time.LocalDate;

public class CaseStudyDTO {
    private String title;
    private LocalDate date;
    private Integer points;
    private Boolean status;

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

    public Boolean getSubmissionStatus() {
        return status;
    }

    public void setSubmissionStatus(Boolean status) {
        this.status = status;
    }
}
