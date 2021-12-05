package hha.website.services;

import hha.website.DepartmentRepository;
import hha.website.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class HHADepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    DeadLineService deadLineService;

    @Lazy
    @Autowired
    private HHAUserDetailsService userDetailsService;

    public Optional<Department> loadDepartmentByDepartmentName(String department) {
        return departmentRepository.findById(department);
    }

    public Department save(DepartmentDTO data) {
        Department department = new Department();
        /*department.setUsers(data.getUsers());
        department.setDept(data.getDepartment());*/
        return departmentRepository.save(department);
    }

    @PostConstruct
    public void initializeDepartments() {
        System.out.println("initalizing departments...");

        Department nicu_paed = new Department();
        nicu_paed.setDepartmentname("NICU_PAED");
        nicu_paed.setPoints(0);
        nicu_paed.setReportsSubmitted(0);
        departmentRepository.save(nicu_paed);

        Department maternity = new Department();
        maternity.setDepartmentname("maternity");
        maternity.setPoints(0);
        maternity.setReportsSubmitted(0);
        departmentRepository.save(maternity);

        Department rehab = new Department();
        rehab.setDepartmentname("Rehab");
        rehab.setPoints(0);
        rehab.setReportsSubmitted(0);
        departmentRepository.save(rehab);

        Department community_health = new Department();
        community_health.setDepartmentname("community_health");
        community_health.setPoints(0);
        community_health.setReportsSubmitted(0);
        departmentRepository.save(community_health);
    }

    public void addASubmittedReport(User user) {
        DeadLine deadLine = deadLineService.getDeadLine();

        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Calendar curr = Calendar.getInstance(timeZone);

        int cmonth = curr.get(Calendar.MONTH) + 1;

        String currStr = cmonth<=9?"0"+cmonth:""+cmonth;
        cmonth = Integer.parseInt(curr.get(Calendar.YEAR)+""+currStr);
        if (cmonth == deadLine.getCurrentMonth()) {
            departmentRepository.updateDepartmentPoints(user.getDepartment().getDepartmentname());
        }
        // new year?
        if (cmonth > deadLine.getCurrentMonth()) {
            //check up month has submit
            User dbuser = userDetailsService.findByUsername(user.getUsername());
            Set<CaseStudy> studies = dbuser.getCaseStudies();
            int count = 0;
            for (CaseStudy caseStudy : studies) {
                int submitMonth = caseStudy.getDateSubmitted().get(Calendar.MONTH) + 1;
                if (submitMonth == deadLine.getCurrentMonth()) {
                    count++;
                }
            }
            if(count>0){
                // next month submit
                departmentRepository.updateDepartmentPoints(user.getDepartment().getDepartmentname());
            }else {
                //out date reduce point
                departmentRepository.reduceDepartmentPoints(user.getDepartment().getDepartmentname());
            }
        }

        userDetailsService.addASubmittedReportForUser(user);
        departmentRepository.updateDepartmentReportsSubmitted(user.getDepartment().getDepartmentname());
    }


    public List<Department> listAllDepartments() {
        return departmentRepository.findAll();
    }

    public Collection<String> listDepartmentNames() {
        return departmentRepository.queryDepartmentNames();
    }

    public Integer listTotalReportsSubmittedForDepartment(String departmentname) {
        return departmentRepository.queryTotalReportsSubmittedForDepartment(departmentname);
    }
}
