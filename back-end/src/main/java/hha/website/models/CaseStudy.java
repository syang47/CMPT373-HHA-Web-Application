package hha.website.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import hha.website.HashMapConverter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Map;

@Entity
@Table(name = "casestudies")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaseStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Calendar dateSubmitted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Lob
    @Column
    private byte[] photo;

    @Column
    private String photoType;

    @Column
    private String caseStudyType;

    @Lob
    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> caseStudyData;

    @Column
    private String caseStudyOfTheMonth;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Calendar dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getCaseStudyType() {
        return caseStudyType;
    }

    public void setCaseStudyType(String caseStudyType) {
        this.caseStudyType = caseStudyType;
    }

    public Map<String, Object> getCaseStudyData() {
        return caseStudyData;
    }

    public void setCaseStudyData(Map<String, Object> caseStudyData) {
        this.caseStudyData = caseStudyData;
    }

    public String getCaseStudyOfTheMonth() {
        return caseStudyOfTheMonth;
    }

    public void setCaseStudyOfTheMonth(String caseStudyOfTheMonth) {
        this.caseStudyOfTheMonth = caseStudyOfTheMonth;
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }
}

