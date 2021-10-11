package hha.website.models;


import javax.persistence.*;

@Entity
@Table(name="MSPPData")
public class MSPPRequirement {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    public MSPPRequirement(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column
    private String department;
    @Column
    private String firstName;
    @Column
    private String lastName;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    private Integer bedsAvailable;
    @Column
    private Integer bedDays;
    @Column
    private Integer patientDays;
    @Column
    private Integer hospitalized;
    @Column
    private Integer dischargedAlive;
    @Column
    private Integer diedBefore48h;
    @Column
    private Integer diedAfter48h;
    @Column
    private Integer daysHospitalised;
    @Column
    private Integer referrals;
    @Column
    private Integer transfers;
    @Column
    private Integer selfDischarged;

    @Column
    private Integer stayedInTheWard;
    @Column
    private Integer admissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getBedsAvailable() {
        return bedsAvailable;
    }

    public void setBedsAvailable(Integer bedsAvailable) {
        this.bedsAvailable = bedsAvailable;
    }

    public Integer getBedDays() {
        return bedDays;
    }

    public void setBedDays(Integer bedDays) {
        this.bedDays = bedDays;
    }

    public Integer getPatientDays() {
        return patientDays;
    }

    public void setPatientDays(Integer patientDays) {
        this.patientDays = patientDays;
    }

    public Integer getHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(Integer hospitalized) {
        this.hospitalized = hospitalized;
    }

    public Integer getDischargedAlive() {
        return dischargedAlive;
    }

    public void setDischargedAlive(Integer dischargedAlive) {
        this.dischargedAlive = dischargedAlive;
    }

    public Integer getDiedBefore48h() {
        return diedBefore48h;
    }

    public void setDiedBefore48h(Integer diedBefore48h) {
        this.diedBefore48h = diedBefore48h;
    }

    public Integer getDiedAfter48h() {
        return diedAfter48h;
    }

    public void setDiedAfter48h(Integer diedAfter48h) {
        this.diedAfter48h = diedAfter48h;
    }

    public Integer getDaysHospitalised() {
        return daysHospitalised;
    }

    public void setDaysHospitalised(Integer daysHospitalised) {
        this.daysHospitalised = daysHospitalised;
    }

    public Integer getReferrals() {
        return referrals;
    }

    public void setReferrals(Integer referrals) {
        this.referrals = referrals;
    }

    public Integer getTransfers() {
        return transfers;
    }

    public void setTransfers(Integer transfers) {
        this.transfers = transfers;
    }

    public Integer getSelfDischarged() {
        return selfDischarged;
    }

    public void setSelfDischarged(Integer selfDischarged) {
        this.selfDischarged = selfDischarged;
    }

    public Integer getStayedInTheWard() {
        return stayedInTheWard;
    }

    public void setStayedInTheWard(Integer stayedInTheWard) {
        this.stayedInTheWard = stayedInTheWard;
    }

    public Integer getAdmissions() {
        return admissions;
    }

    public void setAdmissions(Integer admissions) {
        this.admissions = admissions;
    }

}
