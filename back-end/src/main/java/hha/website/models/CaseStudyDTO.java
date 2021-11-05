package hha.website.models;

import javax.persistence.Column;

public class CaseStudyDTO {

    private byte[] photo;

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
    private String equipmentDepartmentFrom;
    private String equipmentOrigin;
    private String equipmentUsage;

    
    private String story;

    public byte[] getPhoto() {
        return photo;
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

    public String getEquipmentDepartmentFrom() {
        return equipmentDepartmentFrom;
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
}
