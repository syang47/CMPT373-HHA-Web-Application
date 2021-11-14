package hha.website.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import hha.website.CaseStudyRepository;
import hha.website.models.CaseStudy;
import hha.website.models.CaseStudyDTO;
import hha.website.models.Department;
import hha.website.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.*;

@Service
@Transactional
public class CaseStudyService {

    @Autowired
    private CaseStudyRepository caseStudyRepository;
    @Autowired
    private HHADepartmentService hhaDepartmentService;

    public CaseStudy save(User user, CaseStudyDTO data, MultipartFile file) {
        CaseStudy entry = new CaseStudy();

        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        entry.setDateSubmitted(Calendar.getInstance(timeZone));
        entry.setUser(user);
        entry.setCaseStudyType(data.getCaseStudyType());

        Optional<MultipartFile> photoBytes = Optional.ofNullable(file);
        photoBytes.ifPresent(p -> {
            try{
                entry.setPhoto(p.getBytes());
                entry.setPhotoType(p.getContentType());
            } catch(IOException e) {
                e.printStackTrace();
            }
        });

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
        entry.setEquipmentDepartmentFrom(data.getEquipmentFrom());
        entry.setEquipmentOrigin(data.getEquipmentOrigin());
        entry.setEquipmentUsage(data.getEquipmentUsage());

        entry.setStory(data.getStory());

        hhaDepartmentService.addASubmittedReport(user);
        System.out.println("case study saved");
        return caseStudyRepository.save(entry);
    }

    public List<CaseStudy> listAllCaseStudies() {
        return caseStudyRepository.findAll();
    }

    public List<String> listCaseStudyTypes() {
        return caseStudyRepository.queryCaseStudyTypes();
    }

//    public Collection<String> listDistinctItemsInField() {
//        return caseStudyRepository.queryDistinctField();
//    }
//
//    public Collection<Integer> listPointsInField() {
//        return caseStudyRepository.queryBestCasestudy();
//    }
//
//    public Collection<Boolean> listSubmissionStatusInField() {
//        return caseStudyRepository.querySubmissionStatus();
//    }
//
//    public Collection<Integer> listTotalReportsSubmittedField() {
//        return caseStudyRepository.queryTotalReportsField();
//    }
}
