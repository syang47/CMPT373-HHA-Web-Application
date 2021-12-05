package hha.website.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hha.website.CaseStudyRepository;
import hha.website.models.*;
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
import java.util.stream.Collectors;

@Service
@Transactional
public class CaseStudyService {

    @Autowired
    private CaseStudyRepository caseStudyRepository;
    @Autowired
    private HHADepartmentService hhaDepartmentService;

    public CaseStudy save(User user, String data, MultipartFile file) throws JsonProcessingException  {
        CaseStudy entry = new CaseStudy();

        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        entry.setDateSubmitted(Calendar.getInstance(timeZone));
        entry.setUser(user);

        Optional<MultipartFile> photoBytes = Optional.ofNullable(file);
        photoBytes.ifPresent(p -> {
            try{
                entry.setPhoto(p.getBytes());
                entry.setPhotoType(p.getContentType());
            } catch(IOException e) {
                e.printStackTrace();
            }
        });

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> d;
        try {
            d = objectMapper.readValue(data, Map.class);
            entry.setCaseStudyType(d.remove("caseStudyType").toString());
            entry.setCaseStudyData(d);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw e;
        }

        hhaDepartmentService.addASubmittedReport(user);
        System.out.println("case study saved");
        return caseStudyRepository.save(entry);
    }

    public List<List<Object>> listAllCaseStudies() {
        List<List<Object>> caseStudies = new ArrayList<>();
        for(CaseStudy c : caseStudyRepository.findAll()){
            List<Object> cData = new ArrayList<>();
            cData.add(c.getId());
            cData.add(c.getDateSubmitted().getTime().toString());
            cData.add(c.getCaseStudyType());
            cData.add(c.getUser().getUsername());
            cData.add(c.getPhoto());
            cData.add(c.getPhotoType());
            cData.add(c.getCaseStudyData());
            caseStudies.add(cData);
        }
        return caseStudies;
    }

    public List<String> listCaseStudyTypes() {
        return caseStudyRepository.queryCaseStudyTypes();
    }

    public void deleteCaseStudy(Integer id) {
        Optional<CaseStudy> caseStudyToDelete = caseStudyRepository.findById(id);
        caseStudyToDelete.ifPresent(c -> {
            hhaDepartmentService.deleteASubmittedReport(c.getUser());
            caseStudyRepository.deleteById(id);
        });
    }

    public List<Object> getACaseStudy(String month) {
        Optional<CaseStudy> cs = caseStudyRepository.findByCaseStudyOfTheMonth(month);
        List<Object> csData = new ArrayList<>();
        cs.ifPresent(c -> {
            csData.add(c.getDateSubmitted().getTime().toString());
            csData.add(c.getCaseStudyType());
            csData.add(c.getUser().getUsername());
            csData.add(c.getPhoto());
            csData.add(c.getPhotoType());
            csData.add(c.getCaseStudyData());
        });

        return csData;
    }

    public String setCaseStudyOfTheMonth(Integer id, String month){
        Optional<CaseStudy> currentCaseStudyofTheMonth = caseStudyRepository.findByCaseStudyOfTheMonth(month);
        currentCaseStudyofTheMonth.ifPresent(e -> e.setCaseStudyOfTheMonth(""));
        CaseStudy cs = caseStudyRepository.getById(id);
        cs.setCaseStudyOfTheMonth(month);
        return cs.getId().toString();
    }

    public HashMap<String, List<Integer>> listReportsForMonthAndYear(Integer year, Integer month) {
        Calendar queryDate = new GregorianCalendar(year,Calendar.JANUARY,1);
        List<CaseStudy> allReportsGivenYear = caseStudyRepository.findAllByDateSubmittedAfter(queryDate);

        HashMap<String, List<Integer>> departmentReports = new HashMap<>();
        for(Department d : hhaDepartmentService.getAllDepartments()){
            List<CaseStudy> filterReports = allReportsGivenYear.stream().filter(r -> r.getUser().getDepartment() == d).collect(Collectors.toList());
            List<Integer> reportsSubmitted = new ArrayList<>();

            reportsSubmitted.add(filterReports.size());

            filterReports = filterReports.stream().filter(r -> r.getUser().getDepartment() == d && r.getDateSubmitted().get(Calendar.MONTH) == month).collect(Collectors.toList());
            reportsSubmitted.add(filterReports.size());

            departmentReports.put(d.getDepartmentname(), reportsSubmitted);
        }

        return departmentReports;
    }
}
