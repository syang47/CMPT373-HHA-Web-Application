package hha.website.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name="additionalMSPPData")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdditionalMSPP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "additionalData", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private MSPPRequirement msppRequirementData;

    @Column
    private Integer hospitalizedNICU;
    @Column
    private Integer hospitalizedPaed;
    @Column
    private Integer NICUDischarged;
    @Column
    private Integer diedInNICUBefore48;
    @Column
    private Integer diedInPaedBefore48;
    @Column
    private Integer diedInNICUAfter48;
    @Column
    private Integer diedInPaedAfter48;
    @Column
    private Integer financeCannotAfford;
    @Column
    private Integer financeAvoidPay;
    @Column
    private Integer reasonCultural;
    @Column
    private Integer reasonPersonal;
    @Column
    private Integer otherReason;
    @Column
    private Integer fromQuarterMorin;
    @Column
    private Integer fromCapHaitian;
    @Column
    private Integer fromDepartmentNord;
    @Column
    private String fromOther;
    @Column
    private Integer admissionsExtremelyPreterm;
    @Column
    private Integer admissionsVeryPreterm;
    @Column
    private Integer admissionsModerateToLatePreterm;
    @Column
    private Integer admissionsFullTerm;
    @Column
    private Integer admissionsOlderThanNeonate;
    @Column
    private Integer admissionsAge4WeeksTo5;
    @Column
    private Integer admissionsAge6To11;
    @Column
    private Integer admissionsAge12To18;
    @Column
    private Integer admissionsMale;
    @Column
    private Integer admissionsFemale;
    @Column
    private Integer admissionsRespiratoryArrest;
    @Column
    private Integer admissionsTraumaticInjury;
    @Column
    private Integer admissionsSepticShock;
    @Column
    private Integer admissionsHypovolemicShock;
    @Column
    private Integer admissionsSeizures;
    @Column
    private Integer admissionsPoisoning;
    @Column
    private Integer admissionsAlteredMentalStatus;
    @Column
    private Integer admissionsGastroenteritis;
    @Column
    private Integer admissionsHemorrhage;
    @Column
    private Integer admissionsHypothermia;
    @Column
    private Integer admissionsCardiacCongenitalAnomaly;
    @Column
    private Integer admissionsOtherCongenitalAnomaly;
    @Column
    private Integer admissionsMalnutrition;
    @Column
    private Integer admissionsMeningitis;
    @Column
    private Integer admissionsCommunityAcquiredPneumonia;
    @Column
    private Integer admissionsAspirationPneumonia;
    @Column
    private Integer admissionsModeratePrematurity;
    @Column
    private Integer admissionsSeverePrematurity;
    @Column
    private String admissionsOtherMedical;
    @Column
    private Integer numberOfOutpatients;
    @Column
    private Integer numberOfOutpatientsExtremelyPreterm;
    @Column
    private Integer numberOfOutpatientsVeryPreterm;
    @Column
    private Integer numberOfOutpatientsModerateToLatePreterm;
    @Column
    private Integer numberOfOutpatientsFullTerm;
    @Column
    private Integer numberOfOutpatientsOlderThanNeonate;
    @Column
    private Integer numberOfOutpatientsAge4WeeksTo5;
    @Column
    private Integer numberOfOutpatientsAge6To11;
    @Column
    private Integer numberOfOutpatientsAge12To18;
    @Column
    private Integer numberOfOutpatientsRespiratoryArrest;
    @Column
    private Integer numberOfOutpatientsTraumaticInjury;
    @Column
    private Integer numberOfOutpatientsSepticShock;
    @Column
    private Integer numberOfOutpatientsHypovolemicShock;
    @Column
    private Integer numberOfOutpatientsSeizures;
    @Column
    private Integer numberOfOutpatientsPoisoning;
    @Column
    private Integer numberOfOutpatientsAlteredMentalStatus;
    @Column
    private Integer numberOfOutpatientsGastroenteritis;
    @Column
    private Integer numberOfOutpatientsHemorrhage;
    @Column
    private Integer numberOfOutpatientsHypothermia;
    @Column
    private Integer numberOfOutpatientsCardiacCongenitalAnomaly;
    @Column
    private Integer numberOfOutpatientsOtherCongenitalAnomaly;
    @Column
    private Integer numberOfOutpatientsMalnutrition;
    @Column
    private Integer numberOfOutpatientsMeningitis;
    @Column
    private Integer numberOfOutpatientsCommunityAcquiredPneumonia;
    @Column
    private Integer numberOfOutpatientsAspirationPneumonia;
    @Column
    private Integer numberOfOutpatientsModeratePrematurity;
    @Column
    private Integer numberOfOutpatientsSeverePrematurity;
    @Column
    private String numberOfOutpatientsOtherMedical;
    @Column
    private Integer boy;
    @Column
    private Integer girl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MSPPRequirement getMsppRequirementData() {
        return msppRequirementData;
    }

    public void setMsppRequirement(MSPPRequirement msppRequirementData) {
        this.msppRequirementData = msppRequirementData;
    }

    public Integer getHospitalizedNICU() {
        return hospitalizedNICU;
    }

    public void setHospitalizedNICU(Integer hospitalizedNICU) {
        this.hospitalizedNICU = hospitalizedNICU;
    }

    public Integer getHospitalizedPaed() {
        return hospitalizedPaed;
    }

    public void setHospitalizedPaed(Integer hospitalizedPaed) {
        this.hospitalizedPaed = hospitalizedPaed;
    }

    public Integer getNICUDischarged() {
        return NICUDischarged;
    }

    public void setNICUDischarged(Integer NICUDischarged) {
        this.NICUDischarged = NICUDischarged;
    }

    public Integer getDiedInNICUBefore48() {
        return diedInNICUBefore48;
    }

    public void setDiedInNICUBefore48(Integer diedInNICUBefore48) {
        this.diedInNICUBefore48 = diedInNICUBefore48;
    }

    public Integer getDiedInPaedBefore48() {
        return diedInPaedBefore48;
    }

    public void setDiedInPaedBefore48(Integer diedInPaedBefore48) {
        this.diedInPaedBefore48 = diedInPaedBefore48;
    }

    public Integer getDiedInNICUAfter48() {
        return diedInNICUAfter48;
    }

    public void setDiedInNICUAfter48(Integer diedInNICUAfter48) {
        this.diedInNICUAfter48 = diedInNICUAfter48;
    }

    public Integer getDiedInPaedAfter48() {
        return diedInPaedAfter48;
    }

    public void setDiedInPaedAfter48(Integer diedInPaedAfter48) {
        this.diedInPaedAfter48 = diedInPaedAfter48;
    }

    public Integer getFinanceCannotAfford() {
        return financeCannotAfford;
    }

    public void setFinanceCannotAfford(Integer financeCannotAfford) {
        this.financeCannotAfford = financeCannotAfford;
    }

    public Integer getFinanceAvoidPay() {
        return financeAvoidPay;
    }

    public void setFinanceAvoidPay(Integer financeAvoidPay) {
        this.financeAvoidPay = financeAvoidPay;
    }

    public Integer getReasonCultural() {
        return reasonCultural;
    }

    public void setReasonCultural(Integer reasonCultural) {
        this.reasonCultural = reasonCultural;
    }

    public Integer getReasonPersonal() {
        return reasonPersonal;
    }

    public void setReasonPersonal(Integer reasonPersonal) {
        this.reasonPersonal = reasonPersonal;
    }

    public Integer getOtherReason() {
        return otherReason;
    }

    public void setOtherReason(Integer otherReason) {
        this.otherReason = otherReason;
    }

    public Integer getFromQuarterMorin() {
        return fromQuarterMorin;
    }

    public void setFromQuarterMorin(Integer fromQuarterMorin) {
        this.fromQuarterMorin = fromQuarterMorin;
    }

    public Integer getFromCapHaitian() {
        return fromCapHaitian;
    }

    public void setFromCapHaitian(Integer fromCapHaitian) {
        this.fromCapHaitian = fromCapHaitian;
    }

    public Integer getFromDepartmentNord() {
        return fromDepartmentNord;
    }

    public void setFromDepartmentNord(Integer fromDepartmentNord) {
        this.fromDepartmentNord = fromDepartmentNord;
    }

    public String getFromOther() {
        return fromOther;
    }

    public void setFromOther(String fromOther) {
        this.fromOther = fromOther;
    }

    public Integer getAdmissionsExtremelyPreterm() {
        return admissionsExtremelyPreterm;
    }

    public void setAdmissionsExtremelyPreterm(Integer admissionsExtremelyPreterm) {
        this.admissionsExtremelyPreterm = admissionsExtremelyPreterm;
    }

    public Integer getAdmissionsVeryPreterm() {
        return admissionsVeryPreterm;
    }

    public void setAdmissionsVeryPreterm(Integer admissionsVeryPreterm) {
        this.admissionsVeryPreterm = admissionsVeryPreterm;
    }

    public Integer getAdmissionsModerateToLatePreterm() {
        return admissionsModerateToLatePreterm;
    }

    public void setAdmissionsModerateToLatePreterm(Integer admissionsModerateToLatePreterm) {
        this.admissionsModerateToLatePreterm = admissionsModerateToLatePreterm;
    }

    public Integer getAdmissionsFullTerm() {
        return admissionsFullTerm;
    }

    public void setAdmissionsFullTerm(Integer admissionsFullTerm) {
        this.admissionsFullTerm = admissionsFullTerm;
    }

    public Integer getAdmissionsOlderThanNeonate() {
        return admissionsOlderThanNeonate;
    }

    public void setAdmissionsOlderThanNeonate(Integer admissionsOlderThanNeonate) {
        this.admissionsOlderThanNeonate = admissionsOlderThanNeonate;
    }

    public Integer getAdmissionsAge4WeeksTo5() {
        return admissionsAge4WeeksTo5;
    }

    public void setAdmissionsAge4WeeksTo5(Integer admissionsAge4WeeksTo5) {
        this.admissionsAge4WeeksTo5 = admissionsAge4WeeksTo5;
    }

    public Integer getAdmissionsAge6To11() {
        return admissionsAge6To11;
    }

    public void setAdmissionsAge6To11(Integer admissionsAge6To11) {
        this.admissionsAge6To11 = admissionsAge6To11;
    }

    public Integer getAdmissionsAge12To18() {
        return admissionsAge12To18;
    }

    public void setAdmissionsAge12To18(Integer admissionsAge12To18) {
        this.admissionsAge12To18 = admissionsAge12To18;
    }

    public Integer getAdmissionsMale() {
        return admissionsMale;
    }

    public void setAdmissionsMale(Integer admissionsMale) {
        this.admissionsMale = admissionsMale;
    }

    public Integer getAdmissionsFemale() {
        return admissionsFemale;
    }

    public void setAdmissionsFemale(Integer admissionsFemale) {
        this.admissionsFemale = admissionsFemale;
    }

    public Integer getAdmissionsRespiratoryArrest() {
        return admissionsRespiratoryArrest;
    }

    public void setAdmissionsRespiratoryArrest(Integer admissionsRespiratoryArrest) {
        this.admissionsRespiratoryArrest = admissionsRespiratoryArrest;
    }

    public Integer getAdmissionsTraumaticInjury() {
        return admissionsTraumaticInjury;
    }

    public void setAdmissionsTraumaticInjury(Integer admissionsTraumaticInjury) {
        this.admissionsTraumaticInjury = admissionsTraumaticInjury;
    }

    public Integer getAdmissionsSepticShock() {
        return admissionsSepticShock;
    }

    public void setAdmissionsSepticShock(Integer admissionsSepticShock) {
        this.admissionsSepticShock = admissionsSepticShock;
    }

    public Integer getAdmissionsHypovolemicShock() {
        return admissionsHypovolemicShock;
    }

    public void setAdmissionsHypovolemicShock(Integer admissionsHypovolemicShock) {
        this.admissionsHypovolemicShock = admissionsHypovolemicShock;
    }

    public Integer getAdmissionsSeizures() {
        return admissionsSeizures;
    }

    public void setAdmissionsSeizures(Integer admissionsSeizures) {
        this.admissionsSeizures = admissionsSeizures;
    }

    public Integer getAdmissionsPoisoning() {
        return admissionsPoisoning;
    }

    public void setAdmissionsPoisoning(Integer admissionsPoisoning) {
        this.admissionsPoisoning = admissionsPoisoning;
    }

    public Integer getAdmissionsAlteredMentalStatus() {
        return admissionsAlteredMentalStatus;
    }

    public void setAdmissionsAlteredMentalStatus(Integer admissionsAlteredMentalStatus) {
        this.admissionsAlteredMentalStatus = admissionsAlteredMentalStatus;
    }

    public Integer getAdmissionsGastroenteritis() {
        return admissionsGastroenteritis;
    }

    public void setAdmissionsGastroenteritis(Integer admissionsGastroenteritis) {
        this.admissionsGastroenteritis = admissionsGastroenteritis;
    }

    public Integer getAdmissionsHemorrhage() {
        return admissionsHemorrhage;
    }

    public void setAdmissionsHemorrhage(Integer admissionsHemorrhage) {
        this.admissionsHemorrhage = admissionsHemorrhage;
    }

    public Integer getAdmissionsHypothermia() {
        return admissionsHypothermia;
    }

    public void setAdmissionsHypothermia(Integer admissionsHypothermia) {
        this.admissionsHypothermia = admissionsHypothermia;
    }

    public Integer getAdmissionsCardiacCongenitalAnomaly() {
        return admissionsCardiacCongenitalAnomaly;
    }

    public void setAdmissionsCardiacCongenitalAnomaly(Integer admissionsCardiacCongenitalAnomaly) {
        this.admissionsCardiacCongenitalAnomaly = admissionsCardiacCongenitalAnomaly;
    }

    public Integer getAdmissionsOtherCongenitalAnomaly() {
        return admissionsOtherCongenitalAnomaly;
    }

    public void setAdmissionsOtherCongenitalAnomaly(Integer admissionsOtherCongenitalAnomaly) {
        this.admissionsOtherCongenitalAnomaly = admissionsOtherCongenitalAnomaly;
    }

    public Integer getAdmissionsMalnutrition() {
        return admissionsMalnutrition;
    }

    public void setAdmissionsMalnutrition(Integer admissionsMalnutrition) {
        this.admissionsMalnutrition = admissionsMalnutrition;
    }

    public Integer getAdmissionsMeningitis() {
        return admissionsMeningitis;
    }

    public void setAdmissionsMeningitis(Integer admissionsMeningitis) {
        this.admissionsMeningitis = admissionsMeningitis;
    }

    public Integer getAdmissionsCommunityAcquiredPneumonia() {
        return admissionsCommunityAcquiredPneumonia;
    }

    public void setAdmissionsCommunityAcquiredPneumonia(Integer admissionsCommunityAcquiredPneumonia) {
        this.admissionsCommunityAcquiredPneumonia = admissionsCommunityAcquiredPneumonia;
    }

    public Integer getAdmissionsAspirationPneumonia() {
        return admissionsAspirationPneumonia;
    }

    public void setAdmissionsAspirationPneumonia(Integer admissionsAspirationPneumonia) {
        this.admissionsAspirationPneumonia = admissionsAspirationPneumonia;
    }

    public Integer getAdmissionsModeratePrematurity() {
        return admissionsModeratePrematurity;
    }

    public void setAdmissionsModeratePrematurity(Integer admissionsModeratePrematurity) {
        this.admissionsModeratePrematurity = admissionsModeratePrematurity;
    }

    public Integer getAdmissionsSeverePrematurity() {
        return admissionsSeverePrematurity;
    }

    public void setAdmissionsSeverePrematurity(Integer admissionsSeverePrematurity) {
        this.admissionsSeverePrematurity = admissionsSeverePrematurity;
    }

    public String getAdmissionsOtherMedical() {
        return admissionsOtherMedical;
    }

    public void setAdmissionsOtherMedical(String admissionsOtherMedical) {
        this.admissionsOtherMedical = admissionsOtherMedical;
    }

    public Integer getNumberOfOutpatients() {
        return numberOfOutpatients;
    }

    public void setNumberOfOutpatients(Integer numberOfOutpatients) {
        this.numberOfOutpatients = numberOfOutpatients;
    }

    public Integer getNumberOfOutpatientsExtremelyPreterm() {
        return numberOfOutpatientsExtremelyPreterm;
    }

    public void setNumberOfOutpatientsExtremelyPreterm(Integer numberOfOutpatientsExtremelyPreterm) {
        this.numberOfOutpatientsExtremelyPreterm = numberOfOutpatientsExtremelyPreterm;
    }

    public Integer getNumberOfOutpatientsVeryPreterm() {
        return numberOfOutpatientsVeryPreterm;
    }

    public void setNumberOfOutpatientsVeryPreterm(Integer numberOfOutpatientsVeryPreterm) {
        this.numberOfOutpatientsVeryPreterm = numberOfOutpatientsVeryPreterm;
    }

    public Integer getNumberOfOutpatientsModerateToLatePreterm() {
        return numberOfOutpatientsModerateToLatePreterm;
    }

    public void setNumberOfOutpatientsModerateToLatePreterm(Integer numberOfOutpatientsModerateToLatePreterm) {
        this.numberOfOutpatientsModerateToLatePreterm = numberOfOutpatientsModerateToLatePreterm;
    }

    public Integer getNumberOfOutpatientsFullTerm() {
        return numberOfOutpatientsFullTerm;
    }

    public void setNumberOfOutpatientsFullTerm(Integer numberOfOutpatientsFullTerm) {
        this.numberOfOutpatientsFullTerm = numberOfOutpatientsFullTerm;
    }

    public Integer getNumberOfOutpatientsOlderThanNeonate() {
        return numberOfOutpatientsOlderThanNeonate;
    }

    public void setNumberOfOutpatientsOlderThanNeonate(Integer numberOfOutpatientsOlderThanNeonate) {
        this.numberOfOutpatientsOlderThanNeonate = numberOfOutpatientsOlderThanNeonate;
    }

    public Integer getNumberOfOutpatientsAge4WeeksTo5() {
        return numberOfOutpatientsAge4WeeksTo5;
    }

    public void setNumberOfOutpatientsAge4WeeksTo5(Integer numberOfOutpatientsAge4WeeksTo5) {
        this.numberOfOutpatientsAge4WeeksTo5 = numberOfOutpatientsAge4WeeksTo5;
    }

    public Integer getNumberOfOutpatientsAge6To11() {
        return numberOfOutpatientsAge6To11;
    }

    public void setNumberOfOutpatientsAge6To11(Integer numberOfOutpatientsAge6To11) {
        this.numberOfOutpatientsAge6To11 = numberOfOutpatientsAge6To11;
    }

    public Integer getNumberOfOutpatientsAge12To18() {
        return numberOfOutpatientsAge12To18;
    }

    public void setNumberOfOutpatientsAge12To18(Integer numberOfOutpatientsAge12To18) {
        this.numberOfOutpatientsAge12To18 = numberOfOutpatientsAge12To18;
    }

    public Integer getNumberOfOutpatientsRespiratoryArrest() {
        return numberOfOutpatientsRespiratoryArrest;
    }

    public void setNumberOfOutpatientsRespiratoryArrest(Integer numberOfOutpatientsRespiratoryArrest) {
        this.numberOfOutpatientsRespiratoryArrest = numberOfOutpatientsRespiratoryArrest;
    }

    public Integer getNumberOfOutpatientsTraumaticInjury() {
        return numberOfOutpatientsTraumaticInjury;
    }

    public void setNumberOfOutpatientsTraumaticInjury(Integer numberOfOutpatientsTraumaticInjury) {
        this.numberOfOutpatientsTraumaticInjury = numberOfOutpatientsTraumaticInjury;
    }

    public Integer getNumberOfOutpatientsSepticShock() {
        return numberOfOutpatientsSepticShock;
    }

    public void setNumberOfOutpatientsSepticShock(Integer numberOfOutpatientsSepticShock) {
        this.numberOfOutpatientsSepticShock = numberOfOutpatientsSepticShock;
    }

    public Integer getNumberOfOutpatientsHypovolemicShock() {
        return numberOfOutpatientsHypovolemicShock;
    }

    public void setNumberOfOutpatientsHypovolemicShock(Integer numberOfOutpatientsHypovolemicShock) {
        this.numberOfOutpatientsHypovolemicShock = numberOfOutpatientsHypovolemicShock;
    }

    public Integer getNumberOfOutpatientsSeizures() {
        return numberOfOutpatientsSeizures;
    }

    public void setNumberOfOutpatientsSeizures(Integer numberOfOutpatientsSeizures) {
        this.numberOfOutpatientsSeizures = numberOfOutpatientsSeizures;
    }

    public Integer getNumberOfOutpatientsPoisoning() {
        return numberOfOutpatientsPoisoning;
    }

    public void setNumberOfOutpatientsPoisoning(Integer numberOfOutpatientsPoisoning) {
        this.numberOfOutpatientsPoisoning = numberOfOutpatientsPoisoning;
    }

    public Integer getNumberOfOutpatientsAlteredMentalStatus() {
        return numberOfOutpatientsAlteredMentalStatus;
    }

    public void setNumberOfOutpatientsAlteredMentalStatus(Integer numberOfOutpatientsAlteredMentalStatus) {
        this.numberOfOutpatientsAlteredMentalStatus = numberOfOutpatientsAlteredMentalStatus;
    }

    public Integer getNumberOfOutpatientsGastroenteritis() {
        return numberOfOutpatientsGastroenteritis;
    }

    public void setNumberOfOutpatientsGastroenteritis(Integer numberOfOutpatientsGastroenteritis) {
        this.numberOfOutpatientsGastroenteritis = numberOfOutpatientsGastroenteritis;
    }

    public Integer getNumberOfOutpatientsHemorrhage() {
        return numberOfOutpatientsHemorrhage;
    }

    public void setNumberOfOutpatientsHemorrhage(Integer numberOfOutpatientsHemorrhage) {
        this.numberOfOutpatientsHemorrhage = numberOfOutpatientsHemorrhage;
    }

    public Integer getNumberOfOutpatientsHypothermia() {
        return numberOfOutpatientsHypothermia;
    }

    public void setNumberOfOutpatientsHypothermia(Integer numberOfOutpatientsHypothermia) {
        this.numberOfOutpatientsHypothermia = numberOfOutpatientsHypothermia;
    }

    public Integer getNumberOfOutpatientsCardiacCongenitalAnomaly() {
        return numberOfOutpatientsCardiacCongenitalAnomaly;
    }

    public void setNumberOfOutpatientsCardiacCongenitalAnomaly(Integer numberOfOutpatientsCardiacCongenitalAnomaly) {
        this.numberOfOutpatientsCardiacCongenitalAnomaly = numberOfOutpatientsCardiacCongenitalAnomaly;
    }

    public Integer getNumberOfOutpatientsOtherCongenitalAnomaly() {
        return numberOfOutpatientsOtherCongenitalAnomaly;
    }

    public void setNumberOfOutpatientsOtherCongenitalAnomaly(Integer numberOfOutpatientsOtherCongenitalAnomaly) {
        this.numberOfOutpatientsOtherCongenitalAnomaly = numberOfOutpatientsOtherCongenitalAnomaly;
    }

    public Integer getNumberOfOutpatientsMalnutrition() {
        return numberOfOutpatientsMalnutrition;
    }

    public void setNumberOfOutpatientsMalnutrition(Integer numberOfOutpatientsMalnutrition) {
        this.numberOfOutpatientsMalnutrition = numberOfOutpatientsMalnutrition;
    }

    public Integer getNumberOfOutpatientsMeningitis() {
        return numberOfOutpatientsMeningitis;
    }

    public void setNumberOfOutpatientsMeningitis(Integer numberOfOutpatientsMeningitis) {
        this.numberOfOutpatientsMeningitis = numberOfOutpatientsMeningitis;
    }

    public Integer getNumberOfOutpatientsCommunityAcquiredPneumonia() {
        return numberOfOutpatientsCommunityAcquiredPneumonia;
    }

    public void setNumberOfOutpatientsCommunityAcquiredPneumonia(Integer numberOfOutpatientsCommunityAcquiredPneumonia) {
        this.numberOfOutpatientsCommunityAcquiredPneumonia = numberOfOutpatientsCommunityAcquiredPneumonia;
    }

    public Integer getNumberOfOutpatientsAspirationPneumonia() {
        return numberOfOutpatientsAspirationPneumonia;
    }

    public void setNumberOfOutpatientsAspirationPneumonia(Integer numberOfOutpatientsAspirationPneumonia) {
        this.numberOfOutpatientsAspirationPneumonia = numberOfOutpatientsAspirationPneumonia;
    }

    public Integer getNumberOfOutpatientsModeratePrematurity() {
        return numberOfOutpatientsModeratePrematurity;
    }

    public void setNumberOfOutpatientsModeratePrematurity(Integer numberOfOutpatientsModeratePrematurity) {
        this.numberOfOutpatientsModeratePrematurity = numberOfOutpatientsModeratePrematurity;
    }

    public Integer getNumberOfOutpatientsSeverePrematurity() {
        return numberOfOutpatientsSeverePrematurity;
    }

    public void setNumberOfOutpatientsSeverePrematurity(Integer numberOfOutpatientsSeverePrematurity) {
        this.numberOfOutpatientsSeverePrematurity = numberOfOutpatientsSeverePrematurity;
    }

    public String getNumberOfOutpatientsOtherMedical() {
        return numberOfOutpatientsOtherMedical;
    }

    public void setNumberOfOutpatientsOtherMedical(String numberOfOutpatientsOtherMedical) {
        this.numberOfOutpatientsOtherMedical = numberOfOutpatientsOtherMedical;
    }

    public Integer getBoy() {
        return boy;
    }

    public void setBoy(Integer boy) {
        this.boy = boy;
    }

    public Integer getGirl() {
        return girl;
    }

    public void setGirl(Integer girl) {
        this.girl = girl;
    }
}
