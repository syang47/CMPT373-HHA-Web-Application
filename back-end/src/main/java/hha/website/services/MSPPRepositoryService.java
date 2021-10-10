package hha.website.services;

import hha.website.MSPPRepository;
import hha.website.models.MSPPRequirement;
import hha.website.models.MSPPRequirementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MSPPRepositoryService {
    @Autowired
    private MSPPRepository msppRepository;

    public MSPPRequirement save(MSPPRequirementDTO mspp) {
        MSPPRequirement entry = new MSPPRequirement();
        //entry.setDepartment(mspp.getDepartment());
        //entry.setFirstName(mspp.getFirstName());
        //entry.setLastName(mspp.getLastName());
        entry.setBedDays(mspp.getBedDays());
        entry.setPatientDays(mspp.getPatientDays());
        entry.setHospitalized(mspp.getHospitalized());
        entry.setDischargedAlive(mspp.getDischargedAlive());
        entry.setDiedBefore48h(mspp.getDiedBefore48h());
        entry.setDiedAfter48h(mspp.getDiedAfter48h());
        entry.setDaysHospitalised(mspp.getDaysHospitalised());
        entry.setReferrals(mspp.getReferrals());
        entry.setTransfers(mspp.getTransfers());
        entry.setSelfDischarged(mspp.getSelfDischarged());
        entry.setStayedInTheWard(mspp.getStayedInTheWard());
        entry.setAdmissions(mspp.getAdmissions());
        entry.setBedsAvailable(mspp.getBedsAvailable());
        return msppRepository.save(entry);
    }
}
