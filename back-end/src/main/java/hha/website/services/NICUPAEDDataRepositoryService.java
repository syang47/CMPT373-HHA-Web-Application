package hha.website.services;

import hha.website.NICUPAEDDataRepository;
import hha.website.models.datainput.NICUPAEDData;
import hha.website.models.datainput.NICUPAEDDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class NICUPAEDDataRepositoryService {
    @Autowired
    private NICUPAEDDataRepository nicupaedDataRepository;

    public NICUPAEDData save(NICUPAEDDataDTO dataEntry) {
        NICUPAEDData entry = new NICUPAEDData();
        entry.setDepartment(dataEntry.getDepartment());
        entry.setBedDays(dataEntry.getBedDays());
        entry.setPatientDays(dataEntry.getPatientDays());
        entry.setHospitalized(dataEntry.getHospitalized());
        entry.setDischargedAlive(dataEntry.getDischargedAlive());
        entry.setDiedBefore48h(dataEntry.getDiedBefore48h());
        entry.setDiedAfter48h(dataEntry.getDiedAfter48h());
        entry.setDaysHospitalised(dataEntry.getDaysHospitalised());
        entry.setReferrals(dataEntry.getReferrals());
        entry.setTransfers(dataEntry.getTransfers());
        entry.setSelfDischarged(dataEntry.getSelfDischarged());
        entry.setStayedInTheWard(dataEntry.getStayedInTheWard());
        entry.setAdmissions(dataEntry.getAdmissions());
        entry.setBedsAvailable(dataEntry.getBedsAvailable());
        System.out.println("entry saved - NICUPAED");
        return nicupaedDataRepository.save(entry);
    }
}
