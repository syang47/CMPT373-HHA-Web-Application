package hha.website.services;

import hha.website.AdditionalMSPPRepository;
import hha.website.models.AdditionalMSPP;
import hha.website.models.AdditionalMSPPDTO;
import hha.website.models.MSPPRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdditionalMSPPRepositoryService {
    @Autowired
    private AdditionalMSPPRepository additionalMSPPRepository;

    public AdditionalMSPP loadAdditionalMSPPDataByMSPPData(MSPPRequirement msppRequirementData) {
        return additionalMSPPRepository.findBymsppRequirementData(msppRequirementData);
    }

    public AdditionalMSPP save(AdditionalMSPPDTO dataEntry) {
        AdditionalMSPP entry = new AdditionalMSPP();
        entry.setHospitalizedNICU(dataEntry.getHospitalizedNICU());
        entry.setHospitalizedPaed(dataEntry.getHospitalizedPaed());
        entry.setNICUDischarged(dataEntry.getNICUDischarged());
        entry.setDiedInNICUBefore48(dataEntry.getDiedInNICUBefore48());
        entry.setDiedInPaedBefore48(dataEntry.getDiedInPaedBefore48());
        entry.setDiedInNICUAfter48(dataEntry.getDiedInNICUAfter48());
        entry.setDiedInPaedAfter48(dataEntry.getDiedInPaedAfter48());
        entry.setFinanceCannotAfford(dataEntry.getFinanceCannotAfford());
        entry.setFinanceAvoidPay(dataEntry.getFinanceAvoidPay());
        entry.setReasonCultural(dataEntry.getReasonCultural());
        entry.setReasonPersonal(dataEntry.getReasonPersonal());
        entry.setOtherReason(dataEntry.getOtherReason());
        entry.setFromQuarterMorin(dataEntry.getFromQuarterMorin());
        entry.setFromCapHaitian(dataEntry.getFromCapHaitian());
        entry.setFromDepartmentNord(dataEntry.getFromDepartmentNord());
        entry.setFromOther(dataEntry.getFromOther());
        entry.setAdmissionsExtremelyPreterm(dataEntry.getAdmissionsExtremelyPreterm());
        entry.setAdmissionsVeryPreterm(dataEntry.getAdmissionsVeryPreterm());
        entry.setAdmissionsModerateToLatePreterm(dataEntry.getAdmissionsModerateToLatePreterm());
        entry.setAdmissionsFullTerm(dataEntry.getAdmissionsFullTerm());
        entry.setAdmissionsOlderThanNeonate(dataEntry.getAdmissionsOlderThanNeonate());
        entry.setAdmissionsAge4WeeksTo5(dataEntry.getAdmissionsAge4WeeksTo5());
        entry.setAdmissionsAge6To11(dataEntry.getAdmissionsAge6To11());
        entry.setAdmissionsAge12To18(dataEntry.getAdmissionsAge12To18());
        entry.setAdmissionsMale(dataEntry.getAdmissionsMale());
        entry.setAdmissionsFemale(dataEntry.getAdmissionsFemale());
        entry.setAdmissionsRespiratoryArrest(dataEntry.getAdmissionsRespiratoryArrest());
        entry.setAdmissionsTraumaticInjury(dataEntry.getAdmissionsTraumaticInjury());
        entry.setAdmissionsSepticShock(dataEntry.getAdmissionsSepticShock());
        entry.setAdmissionsHypovolemicShock(dataEntry.getAdmissionsHypovolemicShock());
        entry.setAdmissionsSeizures(dataEntry.getAdmissionsSeizures());
        entry.setAdmissionsPoisoning(dataEntry.getAdmissionsPoisoning());
        entry.setAdmissionsAlteredMentalStatus(dataEntry.getAdmissionsAlteredMentalStatus());
        entry.setAdmissionsGastroenteritis(dataEntry.getAdmissionsGastroenteritis());
        entry.setAdmissionsHemorrhage(dataEntry.getAdmissionsHemorrhage());
        entry.setAdmissionsHypothermia(dataEntry.getAdmissionsHypothermia());
        entry.setAdmissionsCardiacCongenitalAnomaly(dataEntry.getAdmissionsCardiacCongenitalAnomaly());
        entry.setAdmissionsOtherCongenitalAnomaly(dataEntry.getAdmissionsOtherCongenitalAnomaly());
        entry.setAdmissionsMalnutrition(dataEntry.getAdmissionsMalnutrition());
        entry.setAdmissionsMeningitis(dataEntry.getAdmissionsMeningitis());
        entry.setAdmissionsCommunityAcquiredPneumonia(dataEntry.getAdmissionsCommunityAcquiredPneumonia());
        entry.setAdmissionsAspirationPneumonia(dataEntry.getAdmissionsAspirationPneumonia());
        entry.setAdmissionsModeratePrematurity(dataEntry.getAdmissionsModeratePrematurity());
        entry.setAdmissionsSeverePrematurity(dataEntry.getAdmissionsSeverePrematurity());
        entry.setAdmissionsOtherMedical(dataEntry.getAdmissionsOtherMedical());
        entry.setNumberOfOutpatients(dataEntry.getNumberOfOutpatients());
        entry.setNumberOfOutpatientsExtremelyPreterm(dataEntry.getNumberOfOutpatientsExtremelyPreterm());
        entry.setNumberOfOutpatientsVeryPreterm(dataEntry.getNumberOfOutpatientsVeryPreterm());
        entry.setNumberOfOutpatientsModerateToLatePreterm(dataEntry.getNumberOfOutpatientsModerateToLatePreterm());
        entry.setNumberOfOutpatientsFullTerm(dataEntry.getNumberOfOutpatientsFullTerm());
        entry.setNumberOfOutpatientsOlderThanNeonate(dataEntry.getNumberOfOutpatientsOlderThanNeonate());
        entry.setNumberOfOutpatientsAge4WeeksTo5(dataEntry.getNumberOfOutpatientsAge4WeeksTo5());
        entry.setNumberOfOutpatientsAge6To11(dataEntry.getNumberOfOutpatientsAge6To11());
        entry.setNumberOfOutpatientsAge12To18(dataEntry.getNumberOfOutpatientsAge12To18());
        entry.setNumberOfOutpatientsRespiratoryArrest(dataEntry.getNumberOfOutpatientsRespiratoryArrest());
        entry.setNumberOfOutpatientsTraumaticInjury(dataEntry.getNumberOfOutpatientsTraumaticInjury());
        entry.setNumberOfOutpatientsSepticShock(dataEntry.getNumberOfOutpatientsSepticShock());
        entry.setNumberOfOutpatientsHypovolemicShock(dataEntry.getNumberOfOutpatientsHypovolemicShock());
        entry.setNumberOfOutpatientsSeizures(dataEntry.getNumberOfOutpatientsSeizures());
        entry.setNumberOfOutpatientsPoisoning(dataEntry.getNumberOfOutpatientsPoisoning());
        entry.setNumberOfOutpatientsAlteredMentalStatus(dataEntry.getNumberOfOutpatientsAlteredMentalStatus());
        entry.setNumberOfOutpatientsGastroenteritis(dataEntry.getNumberOfOutpatientsGastroenteritis());
        entry.setNumberOfOutpatientsHemorrhage(dataEntry.getNumberOfOutpatientsHemorrhage());
        entry.setNumberOfOutpatientsHypothermia(dataEntry.getNumberOfOutpatientsHypothermia());
        entry.setNumberOfOutpatientsCardiacCongenitalAnomaly(dataEntry.getNumberOfOutpatientsCardiacCongenitalAnomaly());
        entry.setNumberOfOutpatientsOtherCongenitalAnomaly(dataEntry.getNumberOfOutpatientsOtherCongenitalAnomaly());
        entry.setNumberOfOutpatientsMalnutrition(dataEntry.getNumberOfOutpatientsMalnutrition());
        entry.setNumberOfOutpatientsMeningitis(dataEntry.getNumberOfOutpatientsMeningitis());
        entry.setNumberOfOutpatientsCommunityAcquiredPneumonia(dataEntry.getNumberOfOutpatientsCommunityAcquiredPneumonia());
        entry.setNumberOfOutpatientsAspirationPneumonia(dataEntry.getNumberOfOutpatientsAspirationPneumonia());
        entry.setNumberOfOutpatientsModeratePrematurity(dataEntry.getNumberOfOutpatientsModeratePrematurity());
        entry.setNumberOfOutpatientsSeverePrematurity(dataEntry.getNumberOfOutpatientsSeverePrematurity());
        entry.setNumberOfOutpatientsOtherMedical(dataEntry.getNumberOfOutpatientsOtherMedical());
        entry.setBoy(dataEntry.getBoy());
        entry.setGirl(dataEntry.getGirl());
        System.out.println("entry saved - additional data");
        return additionalMSPPRepository.save(entry);
    }

    public AdditionalMSPP getAdditionalData(MSPPRequirement requiredData) {
        return additionalMSPPRepository.findBymsppRequirementData(requiredData);
    }
}
