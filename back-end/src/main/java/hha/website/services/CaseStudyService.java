package hha.website.services;

import hha.website.CaseStudyRepository;
import hha.website.models.CaseStudy;
import hha.website.models.CaseStudyDTO;
import hha.website.models.Department;
import hha.website.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class CaseStudyService {

    @Autowired
    private CaseStudyRepository caseStudyRepository;

    public CaseStudy save(User user, CaseStudyDTO data) {
        CaseStudy entry = new CaseStudy();

        entry.setDateSubmitted(Calendar.getInstance());
        entry.setUser(user);

        entry.setPhoto(data.getPhoto());

        entry.setPatientName(data.getPatientName());
        entry.setPatientAge(data.getPatientAge());
        entry.setPatientOrigin(data.getPatientOrigin());
        entry.setPatientReasoning(data.getPatientReasoning());
        entry.setPatientDuration(data.getPatientDuration());
        entry.setPatientDiagnosis(data.getPatientDiagnosis());

        entry.setStaffName(data.getStaffName());
        entry.setStaffTitle(data.getStaffTitle());
        entry.setStaffDepartment(data.getStaffDepartment());
        entry.setStaffEmploymentDuration(data.getStaffEmploymentDuration());
        entry.setStaffEnjoymentPoints(data.getStaffEnjoymentPoints());

        entry.setTrainingDate(data.getTrainingDate());
        entry.setTrainingSubject(data.getTrainingSubject());
        entry.setTrainingConductor(data.getTrainingConductor());
        entry.setTrainingAttendees(data.getTrainingAttendees());
        entry.setTrainingBenefits(data.getTrainingBenefits());

        entry.setEquipmentReceived(data.getEquipmentReceived());
        entry.setEquipmentDepartmentTo(data.getEquipmentDepartmentTo());
        entry.setEquipmentDepartmentFrom(data.getEquipmentDepartmentFrom());
        entry.setEquipmentOrigin(data.getEquipmentOrigin());
        entry.setEquipmentUsage(data.getEquipmentUsage());

        entry.setStory(data.getStory());

        return caseStudyRepository.save(entry);
    }

    public List<CaseStudy> listAllCaseStudies() {
        return caseStudyRepository.findAll();
    }
}
