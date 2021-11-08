package hha.website.models;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;

public class CaseStudyDTO {

    private MultipartFile photo;
    private String caseStudyType;

    //patient story
    private String patientName;
    private String patientAge;
    private String patientOrigin;
    private String patientReasoning;
    private String patientDuration;
    private String patientDiagnosis;

    //staff recognition
    private String staffName;
    private String staffTitle;
    private String staffDepartment;
    private String staffEmploymentDuration;
    private String staffEnjoymentPoints;

    //training session
    private String trainingDate;
    private String trainingSubject;
    private String trainingConductor;
    private String trainingAttendees;
    private String trainingBenefits;

    //equipment received
    private String equipmentReceived;
    private String equipmentDepartmentTo;
    private String equipmentFrom;
    private String equipmentOrigin;
    private String equipmentUsage;


    private String story;

    public MultipartFile getPhoto() {
        return photo;
    }

    public String getCaseStudyType() {
        return caseStudyType;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public String getPatientOrigin() {
        return patientOrigin;
    }

    public String getPatientReasoning() {
        return patientReasoning;
    }

    public String getPatientDuration() {
        return patientDuration;
    }

    public String getPatientDiagnosis() {
        return patientDiagnosis;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getStaffTitle() {
        return staffTitle;
    }

    public String getStaffDepartment() {
        return staffDepartment;
    }

    public String getStaffEmploymentDuration() {
        return staffEmploymentDuration;
    }

    public String getStaffEnjoymentPoints() {
        return staffEnjoymentPoints;
    }

    public String getTrainingDate() {
        return trainingDate;
    }

    public String getTrainingSubject() {
        return trainingSubject;
    }

    public String getTrainingConductor() {
        return trainingConductor;
    }

    public String getTrainingAttendees() {
        return trainingAttendees;
    }

    public String getTrainingBenefits() {
        return trainingBenefits;
    }

    public String getEquipmentReceived() {
        return equipmentReceived;
    }

    public String getEquipmentDepartmentTo() {
        return equipmentDepartmentTo;
    }

    public String getEquipmentFrom() {
        return equipmentFrom;
    }

    public String getEquipmentOrigin() {
        return equipmentOrigin;
    }

    public String getEquipmentUsage() {
        return equipmentUsage;
    }

    public String getStory() {
        return story;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public void setCaseStudyType(String caseStudyType) {
        this.caseStudyType = caseStudyType;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public void setPatientOrigin(String patientOrigin) {
        this.patientOrigin = patientOrigin;
    }

    public void setPatientReasoning(String patientReasoning) {
        this.patientReasoning = patientReasoning;
    }

    public void setPatientDuration(String patientDuration) {
        this.patientDuration = patientDuration;
    }

    public void setPatientDiagnosis(String patientDiagnosis) {
        this.patientDiagnosis = patientDiagnosis;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setStaffTitle(String staffTitle) {
        this.staffTitle = staffTitle;
    }

    public void setStaffDepartment(String staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    public void setStaffEmploymentDuration(String staffEmploymentDuration) {
        this.staffEmploymentDuration = staffEmploymentDuration;
    }

    public void setStaffEnjoymentPoints(String staffEnjoymentPoints) {
        this.staffEnjoymentPoints = staffEnjoymentPoints;
    }

    public void setTrainingDate(String trainingDate) {
        this.trainingDate = trainingDate;
    }

    public void setTrainingSubject(String trainingSubject) {
        this.trainingSubject = trainingSubject;
    }

    public void setTrainingConductor(String trainingConductor) {
        this.trainingConductor = trainingConductor;
    }

    public void setTrainingAttendees(String trainingAttendees) {
        this.trainingAttendees = trainingAttendees;
    }

    public void setTrainingBenefits(String trainingBenefits) {
        this.trainingBenefits = trainingBenefits;
    }

    public void setEquipmentReceived(String equipmentReceived) {
        this.equipmentReceived = equipmentReceived;
    }

    public void setEquipmentDepartmentTo(String equipmentDepartmentTo) {
        this.equipmentDepartmentTo = equipmentDepartmentTo;
    }

    public void setEquipmentFrom(String equipmentFrom) {
        this.equipmentFrom = equipmentFrom;
    }

    public void setEquipmentOrigin(String equipmentOrigin) {
        this.equipmentOrigin = equipmentOrigin;
    }

    public void setEquipmentUsage(String equipmentUsage) {
        this.equipmentUsage = equipmentUsage;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
