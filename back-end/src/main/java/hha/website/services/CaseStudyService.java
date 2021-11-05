package hha.website.services;

import hha.website.CaseStudyRepository;
import hha.website.models.CaseStudy;
import hha.website.models.CaseStudyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;


@Service
@Transactional
public class CaseStudyService {
    @Autowired
    private CaseStudyRepository caseStudyRepository;

    // hardcoded case studies, to be deleted when case study page is setup
    public void loadCaseStudyByTitle() {
        CaseStudy tempCase1 = new CaseStudy();
        tempCase1.setTitle("tempCaseStudy1");
        
        LocalDate theDate1 = LocalDate.parse("2021-11-03");
        tempCase1.setDate(theDate1);
        tempCase1.setPoints(10);
        tempCase1.setSubmissionStatus(true);
        caseStudyRepository.save(tempCase1);

        CaseStudy tempCase2 = new CaseStudy();
        tempCase2.setTitle("tempCaseStudy2");
        LocalDate theDate2 =  LocalDate.parse("2021-11-02");
        tempCase2.setDate(theDate2);
        tempCase2.setSubmissionStatus(true);
        caseStudyRepository.save(tempCase2);

        CaseStudy tempCase3 = new CaseStudy();
        tempCase3.setTitle("tempCaseStudy3");
        LocalDate theDate3 =  LocalDate.parse("2021-11-01");
        tempCase3.setDate(theDate3);
        tempCase3.setPoints(15);
        tempCase3.setSubmissionStatus(true);
        caseStudyRepository.save(tempCase3);
        
    }

    public CaseStudy save(CaseStudyDTO casestudy) {
        CaseStudy entry = new CaseStudy();
        entry.setDepartment(casestudy.getDepartment());
        entry.setTitle(casestudy.getTitle());
        entry.setDate(casestudy.getDate());
        entry.setPoints(casestudy.getPoints());
        entry.setSubmissionStatus(casestudy.getSubmissionStatus());
        System.out.println("entry saved");
        return caseStudyRepository.save(entry);
    }

    public Collection<String> listDistinctItemsInField() {
        return caseStudyRepository.queryDistinctField();
    }

    public Collection<Integer> listPointsInField() {
        return caseStudyRepository.queryBestCasestudy();
    }

    public Collection<Boolean> listSubmissionStatusInField() {
        return caseStudyRepository.querySubmissionStatus();
    }

    public Collection<Integer> listTotalReportsSubmittedField() {
        return caseStudyRepository.queryTotalReportsField();
    }
}