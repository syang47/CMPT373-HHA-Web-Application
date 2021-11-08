package hha.website.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "casestudies")
public class CaseStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Calendar dateSubmitted;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Lob
    @Column
    private byte[] photo;

    @Column
    private String caseStudyType;

    @Column
    private Integer reportPoints;

    //patient story
    @Column
    private String patientName;
    @Column
    private String patientAge;
    @Column
    private String patientOrigin;
    @Column
    private String patientReasoning;
    @Column
    private String patientDuration;
    @Column
    private String patientDiagnosis;

    //staff recognition
    @Column
    private String staffName;
    @Column
    private String staffTitle;
    @Column
    private String staffDepartment;
    @Column
    private String staffEmploymentDuration;
    @Column
    private String staffEnjoymentPoints;

    //training session
    @Column
    private String trainingDate;
    @Column
    private String trainingSubject;
    @Column
    private String trainingConductor;
    @Column
    private String trainingAttendees;
    @Column
    private String trainingBenefits;

    //equipment received
    @Column
    private String equipmentReceived;
    @Column
    private String equipmentDepartmentTo;
    @Column
    private String equipmentDepartmentFrom;
    @Column
    private String equipmentOrigin;
    @Column
    private String equipmentUsage;

    @Column
    private String story;

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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientOrigin() {
        return patientOrigin;
    }

    public void setPatientOrigin(String patientOrigin) {
        this.patientOrigin = patientOrigin;
    }

    public String getPatientReasoning() {
        return patientReasoning;
    }

    public void setPatientReasoning(String patientReasoning) {
        this.patientReasoning = patientReasoning;
    }

    public String getPatientDuration() {
        return patientDuration;
    }

    public void setPatientDuration(String patientDuration) {
        this.patientDuration = patientDuration;
    }

    public String getPatientDiagnosis() {
        return patientDiagnosis;
    }

    public void setPatientDiagnosis(String patientDiagnosis) {
        this.patientDiagnosis = patientDiagnosis;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffTitle() {
        return staffTitle;
    }

    public void setStaffTitle(String staffTitle) {
        this.staffTitle = staffTitle;
    }

    public String getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDepartment(String staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    public String getStaffEmploymentDuration() {
        return staffEmploymentDuration;
    }

    public void setStaffEmploymentDuration(String staffEmploymentDuration) {
        this.staffEmploymentDuration = staffEmploymentDuration;
    }

    public String getStaffEnjoymentPoints() {
        return staffEnjoymentPoints;
    }

    public void setStaffEnjoymentPoints(String staffEnjoymentPoints) {
        this.staffEnjoymentPoints = staffEnjoymentPoints;
    }

    public String getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(String trainingDate) {
        this.trainingDate = trainingDate;
    }

    public String getTrainingSubject() {
        return trainingSubject;
    }

    public void setTrainingSubject(String trainingSubject) {
        this.trainingSubject = trainingSubject;
    }

    public String getTrainingConductor() {
        return trainingConductor;
    }

    public void setTrainingConductor(String trainingConductor) {
        this.trainingConductor = trainingConductor;
    }

    public String getTrainingAttendees() {
        return trainingAttendees;
    }

    public void setTrainingAttendees(String trainingAttendees) {
        this.trainingAttendees = trainingAttendees;
    }

    public String getTrainingBenefits() {
        return trainingBenefits;
    }

    public void setTrainingBenefits(String trainingBenefits) {
        this.trainingBenefits = trainingBenefits;
    }

    public String getEquipmentReceived() {
        return equipmentReceived;
    }

    public void setEquipmentReceived(String equipmentReceived) {
        this.equipmentReceived = equipmentReceived;
    }

    public String getEquipmentDepartmentTo() {
        return equipmentDepartmentTo;
    }

    public void setEquipmentDepartmentTo(String equipmentDepartmentTo) {
        this.equipmentDepartmentTo = equipmentDepartmentTo;
    }

    public String getEquipmentDepartmentFrom() {
        return equipmentDepartmentFrom;
    }

    public void setEquipmentDepartmentFrom(String equipmentDepartmentFrom) {
        this.equipmentDepartmentFrom = equipmentDepartmentFrom;
    }

    public String getEquipmentOrigin() {
        return equipmentOrigin;
    }

    public void setEquipmentOrigin(String equipmentOrigin) {
        this.equipmentOrigin = equipmentOrigin;
    }

    public String getEquipmentUsage() {
        return equipmentUsage;
    }

    public void setEquipmentUsage(String equipmentUsage) {
        this.equipmentUsage = equipmentUsage;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Integer getReportPoints() {
        return reportPoints;
    }

    public void setReportPoints(Integer reportPoints) {
        this.reportPoints = reportPoints;
    }
}

